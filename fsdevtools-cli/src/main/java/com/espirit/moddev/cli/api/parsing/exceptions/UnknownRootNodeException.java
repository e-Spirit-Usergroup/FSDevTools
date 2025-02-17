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

package com.espirit.moddev.cli.api.parsing.exceptions;

/**
 * States, that a given FirstSpirit root node identifier is not a known one.
 *
 * @author e-Spirit GmbH
 */
public class UnknownRootNodeException extends RuntimeException {

    /**
     * Create a new instance of this exception with the given message.
     * @see java.lang.Exception#Exception(String)
     * @param message the message of this exception
     */
    public UnknownRootNodeException(String message) {
        super(message);
    }
}
