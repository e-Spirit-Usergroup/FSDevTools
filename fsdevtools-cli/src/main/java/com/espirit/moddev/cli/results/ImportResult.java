/*
 *
 * *********************************************************************
 * fsdevtools
 * %%
 * Copyright (C) 2016 e-Spirit AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * *********************************************************************
 *
 */

package com.espirit.moddev.cli.results;

import de.espirit.firstspirit.access.database.BasicEntityInfo;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.store.access.nexport.operations.ImportOperation;

import java.util.List;
import java.util.Set;

/**
 * Specialization of {@link com.espirit.moddev.cli.results.SimpleResult} that can be used in conjunction with import commands.
 * @author e-Spirit AG
 */
public class ImportResult extends SimpleResult<ImportOperation.Result> {

    /**
     * Creates a new instance using the given command result.
     *
     * @param result Result produced by the command
     */
    public ImportResult(ImportOperation.Result result) {
        super(result);
    }

    /**
     * Creates a new error result using the given exception.
     *
     * @param exception Exception produced by the command
     */
    public ImportResult(Exception exception) {
        super(exception);
    }

    @Override
    public void log() {
        if (isError()) {
            LOGGER.error("Import operation not successful", exception);
        } else {
            LOGGER.info("Import operation successful");

            logUpdateElements(getType().getUpdatedElements(), "updated elements");
            logUpdateElements(getType().getCreatedElements(), "created elements");
            logUpdateElements(getType().getDeletedElements(), "deleted elements");
            logUpdateElements(getType().getMovedElements(), "moved elements");
            logCreatedElements(getType().getCreatedEntities(), "created entities");
            logUpdateElements(getType().getLostAndFoundElements(), "lost and found elements");
            logProblems(getType().getProblems(), "problems");

            Object[] args = {Integer.valueOf(getType().getUpdatedElements().size()),
                    Integer.valueOf(getType().getCreatedElements().size()),
                    Integer.valueOf(getType().getDeletedElements().size())};

            LOGGER.info("Import done.\n\t"
                    + "updated elements: {}\n\t"
                    + "created elements: {}\n\t"
                    + "deleted elements: {}", args);
        }
    }

    private void logProblems(List<ImportOperation.Problem> problems, String state) {
        LOGGER.info(state + ": " + problems.size());
        for (ImportOperation.Problem problem : problems) {
            LOGGER.debug(problem.getMessage());
        }
    }

    private void logCreatedElements(Set<BasicEntityInfo> createdEntities, String state) {
        LOGGER.info(state + ": " + createdEntities.size());
        for (BasicEntityInfo info : createdEntities) {
            LOGGER.debug("Gid: " + info.getGid() + " EntityType: " + info.getEntityType());
        }
    }

    /**
     * Log info messages.
     *
     * @param handle represents the current element that was imported
     * @param state  is used for the log message ("updated", "created" and "deleted" etc.)
     */
    public void logUpdateElements(final Set<BasicElementInfo> handle, final String state) {
        LOGGER.info(state + ": " + handle.size());
        for (BasicElementInfo _handle : handle) {
            LOGGER.debug("Uid: " + _handle.getUid() + " NodeId: " + _handle.getNodeId());
        }
    }
}
