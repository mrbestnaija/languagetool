/* LanguageTool, a natural language style checker 
 * Copyright (C) 2013 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.rules.de;

import org.languagetool.AnalyzedToken;
import org.languagetool.AnalyzedTokenReadings;
import org.languagetool.JLanguageTool;
import org.languagetool.tagging.de.AnalyzedGermanToken;
import org.languagetool.tagging.de.GermanToken;

public final class GermanHelper {

  private GermanHelper() {
  }

  public static boolean hasReadingOfType(AnalyzedTokenReadings tokenReadings, GermanToken.POSType type) {
    if (tokenReadings == null) {
      return false;
    }
    for (AnalyzedToken reading : tokenReadings) {
      if (reading.getPOSTag() != null) {
        if (reading.getPOSTag().equals(JLanguageTool.SENTENCE_END_TAGNAME) || reading.getPOSTag().equals(JLanguageTool.PARAGRAPH_END_TAGNAME)) {
          return false;
        }
      }
      final AnalyzedGermanToken germanReading = (AnalyzedGermanToken) reading;
      if (germanReading.getType() == type) {
        return true;
      }
    }
    return false;
  }

}
