package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
/* loaded from: classes.dex */
public final class EmailAddressResultParser extends ResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String str3 = null;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("mailto:") || massagedText.startsWith("MAILTO:")) {
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            String urlDecode = urlDecode(substring);
            Map<String, String> parseNameValuePairs = parseNameValuePairs(massagedText);
            if (parseNameValuePairs != null) {
                str = urlDecode.length() == 0 ? parseNameValuePairs.get("to") : urlDecode;
                str2 = parseNameValuePairs.get("subject");
                str3 = parseNameValuePairs.get("body");
            } else {
                str = urlDecode;
                str2 = null;
            }
            return new EmailAddressParsedResult(str, str2, str3, massagedText);
        } else if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
            return new EmailAddressParsedResult(massagedText, null, null, "mailto:" + massagedText);
        } else {
            return null;
        }
    }
}
