package com.google.zxing.client.result;

import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.webkit.sdk.WebView;
import com.google.zxing.Result;
import java.util.List;
/* loaded from: classes6.dex */
public final class VEventResultParser extends ResultParser {
    public static String matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<String> matchSingleVCardPrefixedField = VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z, false);
        if (matchSingleVCardPrefixedField == null || matchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchSingleVCardPrefixedField.get(0);
    }

    public static String[] matchVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<List<String>> matchVCardPrefixedField = VCardResultParser.matchVCardPrefixedField(charSequence, str, z, false);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        int size = matchVCardPrefixedField.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = matchVCardPrefixedField.get(i2).get(0);
        }
        return strArr;
    }

    public static String stripMailto(String str) {
        return str != null ? (str.startsWith(WebView.SCHEME_MAILTO) || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public CalendarParsedResult parse(Result result) {
        double parseDouble;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("SUMMARY", massagedText, true);
        String matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("DTSTART", massagedText, true);
        if (matchSingleVCardPrefixedField2 == null) {
            return null;
        }
        String matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("DTEND", massagedText, true);
        String matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("DURATION", massagedText, true);
        String matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("LOCATION", massagedText, true);
        String stripMailto = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", massagedText, true));
        String[] matchVCardPrefixedField = matchVCardPrefixedField("ATTENDEE", massagedText, true);
        if (matchVCardPrefixedField != null) {
            for (int i2 = 0; i2 < matchVCardPrefixedField.length; i2++) {
                matchVCardPrefixedField[i2] = stripMailto(matchVCardPrefixedField[i2]);
            }
        }
        String matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("DESCRIPTION", massagedText, true);
        String matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField(BdSailorConfig.SAILOR_BASE_GEO, massagedText, true);
        double d2 = Double.NaN;
        if (matchSingleVCardPrefixedField7 == null) {
            parseDouble = Double.NaN;
        } else {
            int indexOf = matchSingleVCardPrefixedField7.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                d2 = Double.parseDouble(matchSingleVCardPrefixedField7.substring(0, indexOf));
                parseDouble = Double.parseDouble(matchSingleVCardPrefixedField7.substring(indexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new CalendarParsedResult(matchSingleVCardPrefixedField, matchSingleVCardPrefixedField2, matchSingleVCardPrefixedField3, matchSingleVCardPrefixedField4, matchSingleVCardPrefixedField5, stripMailto, matchVCardPrefixedField, matchSingleVCardPrefixedField6, d2, parseDouble);
    }
}
