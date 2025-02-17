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

dependencies {
    implementation(project(":fsdevtools-cli"))
    implementation(project(":fsdevtools-cli-api"))
    implementation("de.espirit.firstspirit:fs-isolated-runtime:${project.properties["fsRuntimeVersion"]}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${project.properties["jacksonDatabindVersion"]}")
    implementation("io.github.classgraph:classgraph:${project.properties["classGraphVersion"]}")
    implementation("com.github.rvesse:airline:${project.properties["airlineVersion"]}")
    implementation("com.github.rvesse:airline-help-markdown:${project.properties["airlineVersion"]}")
}

