/*
 *
 * *********************************************************************
 * fsdevtools
 * %%
 * Copyright (C) 2021 e-Spirit GmbH
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

package com.espirit.moddev.cli.testcommands.reflectiontest;

import com.espirit.moddev.cli.api.command.Command;
import com.espirit.moddev.cli.api.annotations.Description;

/**
 * @author e-Spirit GmbH
 */
@com.github.rvesse.airline.annotations.Command(name = "command_with_description_annotation")
public final class CommandWithDescriptionAnnotation implements Command {
    @Description
    public static String getMyCustomDescription() {
        return "xyz";
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
