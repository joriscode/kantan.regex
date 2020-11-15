/*
 * Copyright 2016 Nicolas Rinaudo
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

package kantan.regex.java8

import java.time.LocalTime
import kantan.regex.{GroupDecoder, MatchDecoder}
import kantan.regex.java8.arbitrary._
import kantan.regex.laws.discipline.{DisciplineSuite, GroupDecoderTests, MatchDecoderTests, SerializableTests}

class LocalTimeDecoderTests extends DisciplineSuite {

  checkAll("GroupDecoder[LocalTime]", GroupDecoderTests[LocalTime].decoder[Int, Int])
  checkAll("GroupDecoder[LocalTime]", SerializableTests[GroupDecoder[LocalTime]].serializable)

  checkAll("MatchDecoder[LocalTime]", MatchDecoderTests[LocalTime].decoder[Int, Int])
  checkAll("MatchDecoder[LocalTime]", SerializableTests[MatchDecoder[LocalTime]].serializable)

}
