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

package com.espirit.moddev.cli.exception;

import java.util.Locale;

/**
 * Error severities used in the cli application.
 *
 * @author e-Spirit GmbH
 */
public enum CliErrorSevereness {

    /**
     * Minor severity.
     */
    MINOR,

    /**
     * Major severity.
     */
    MAJOR,

    /**
     * Fatal severity.
     */
    FATAL;

    private static final int BASE_LINE = 100;

    /**
     * Get the error code.
     *
     * @return the error code
     */
    public int getErrorCode() {
        return (ordinal() + 1) * BASE_LINE;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase(Locale.UK);
    }
}
