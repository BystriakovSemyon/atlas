/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.atlas.core.validation

/**
 * Created by brharrington on 3/14/15.
 */
sealed trait ValidationResult {
  def isSuccess: Boolean
  def isFailure: Boolean = !isSuccess
}

object ValidationResult {
  case object Pass extends ValidationResult {
    def isSuccess: Boolean = true
  }

  case class Fail(rule: String, reason: String) extends ValidationResult {
    def isSuccess: Boolean = false
  }
}

