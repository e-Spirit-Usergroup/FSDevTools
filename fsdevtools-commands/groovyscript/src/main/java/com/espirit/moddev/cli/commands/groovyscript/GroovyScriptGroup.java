package com.espirit.moddev.cli.commands.groovyscript;

import com.github.rvesse.airline.annotations.Group;

/**
 * {@link com.github.rvesse.airline.annotations.Group} that contains commands to handle FirstSpirit groovy scripts.
 */
@Group(name = "groovyscript", description = "interact with groovy scripts", defaultCommand = RunGroovyScriptCommand.class)
public class GroovyScriptGroup {
}
