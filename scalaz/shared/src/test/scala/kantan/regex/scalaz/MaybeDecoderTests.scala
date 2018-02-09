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

package kantan.regex
package scalaz

import _root_.scalaz.Maybe
import _root_.scalaz.scalacheck.ScalazArbitrary._
import laws._
import laws.discipline._, arbitrary._
import org.scalacheck.Arbitrary

class MaybeDecoderTests extends DisciplineSuite {

  implicit val legalGroup: Arbitrary[LegalGroup[Maybe[Int]]]     = arbLegalMaybe
  implicit val illegalGroup: Arbitrary[IllegalGroup[Maybe[Int]]] = arbIllegalMaybe
  implicit val legalMatch: Arbitrary[LegalMatch[Maybe[Int]]]     = arbLegalMaybe
  implicit val illegalMatch: Arbitrary[IllegalMatch[Maybe[Int]]] = arbIllegalMaybe

  checkAll("GroupDecoder[Maybe[Int]]", GroupDecoderTests[Maybe[Int]].decoder[Int, Int])
  checkAll("MatchDecoder[Maybe[Int]]", MatchDecoderTests[Maybe[Int]].decoder[Int, Int])

}
