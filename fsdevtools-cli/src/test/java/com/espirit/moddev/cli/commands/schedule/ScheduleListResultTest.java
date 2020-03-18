package com.espirit.moddev.cli.commands.schedule;

import de.espirit.firstspirit.access.schedule.ScheduleEntry;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ScheduleListResultTest {

	@Test
	public void constructor_server_side() {
		// setup
		final ArrayList<ScheduleEntry> list = new ArrayList<>();
		final ScheduleEntry createdEntry = ScheduleUtils.createScheduleEntry(1337, "myEntry");
		list.add(createdEntry);
		// test
		final ScheduleListResult scheduleListResult = new ScheduleListResult(list);
		// verify
		assertNull("project must be null", scheduleListResult.getProjectName());
		final List<ScheduleEntry> entryList = scheduleListResult.getScheduleEntryList();
		assertEquals("entry size mismatch", 1, entryList.size());
		final ScheduleEntry entry = entryList.get(0);
		assertEquals("entry id mismatch", createdEntry.getId(), entry.getId());
		assertEquals("entry name mismatch", createdEntry.getName(), entry.getName());
	}

	@Test
	public void constructor_project_bound() {
		// setup
		final String projectName = "myProject";
		final ArrayList<ScheduleEntry> list = new ArrayList<>();
		final ScheduleEntry createdEntry = ScheduleUtils.createScheduleEntry(1337, "myEntry");
		list.add(createdEntry);
		// test
		final ScheduleListResult scheduleListResult = new ScheduleListResult(projectName, list);
		// verify
		assertEquals("project name mismatch", projectName, scheduleListResult.getProjectName());
		final List<ScheduleEntry> entryList = scheduleListResult.getScheduleEntryList();
		assertEquals("entry size mismatch", 1, entryList.size());
		final ScheduleEntry entry = entryList.get(0);
		assertEquals("entry id mismatch", createdEntry.getId(), entry.getId());
		assertEquals("entry name mismatch", createdEntry.getName(), entry.getName());
	}

	@Test
	public void constructor_exception() {
		// setup
		final String exceptionMessage = "myException";
		// test
		final ScheduleListResult scheduleListResult = new ScheduleListResult(new RuntimeException(exceptionMessage));
		// verify
		assertTrue("result should be an error result", scheduleListResult.isError());
		assertNotNull("exception must be != null", scheduleListResult.getError());
		assertEquals("exception class mismatch", RuntimeException.class, scheduleListResult.getError().getClass());
		assertEquals("message mismatch", exceptionMessage, scheduleListResult.getError().getMessage());
	}

	@Test
	public void buildLog_server_side() {
		// setup
		final ArrayList<ScheduleEntry> list = new ArrayList<>();
		final ScheduleEntry createdEntry = ScheduleUtils.createScheduleEntry(1337, "myEntry");
		list.add(createdEntry);
		final ScheduleListResult scheduleListResult = new ScheduleListResult(list);
		// test
		final String log = scheduleListResult.buildLog();
		// verify
		assertTrue("topic mismatch", log.contains(ScheduleListResult.MESSAGE_TOPIC_SERVER_SIDE));
		assertTrue("entry not found in log", log.contains("- " + createdEntry.getName()));
		assertEquals("entry found multiple times", 1, StringUtils.countMatches(log, "- " + createdEntry.getName()));
	}

	@Test
	public void buildLog_project_bound() {
		// setup
		final String projectName = "myProject";
		final ArrayList<ScheduleEntry> list = new ArrayList<>();
		final ScheduleEntry createdEntry = ScheduleUtils.createScheduleEntry(1337, "myEntry");
		list.add(createdEntry);
		final ScheduleListResult scheduleListResult = new ScheduleListResult(projectName, list);
		// test
		final String log = scheduleListResult.buildLog();
		// verify
		assertTrue("topic mismatch", log.contains(String.format(ScheduleListResult.MESSAGE_TOPIC_PROJECT_BOUND, projectName)));
		assertTrue("entry not found in log", log.contains("- " + createdEntry.getName()));
		assertEquals("entry found multiple times", 1, StringUtils.countMatches(log, "- " + createdEntry.getName()));
	}

}