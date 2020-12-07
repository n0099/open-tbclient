package com.google.zxing.client.result;

import com.baidu.webkit.sdk.WebView;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes16.dex */
public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = Pattern.compile(",");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String[] strArr;
        String str3;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith(WebView.SCHEME_MAILTO) || massagedText.startsWith("MAILTO:")) {
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            try {
                String urlDecode = urlDecode(substring);
                String[] split = !urlDecode.isEmpty() ? COMMA.split(urlDecode) : null;
                Map<String, String> parseNameValuePairs = parseNameValuePairs(massagedText);
                if (parseNameValuePairs != null) {
                    String[] split2 = (split != null || (str3 = parseNameValuePairs.get("to")) == null) ? split : COMMA.split(str3);
                    String str4 = parseNameValuePairs.get("cc");
                    String[] split3 = str4 != null ? COMMA.split(str4) : null;
                    String str5 = parseNameValuePairs.get("bcc");
                    r2 = str5 != null ? COMMA.split(str5) : null;
                    str = parseNameValuePairs.get("body");
                    split = split2;
                    strArr = r2;
                    r2 = split3;
                    str2 = parseNameValuePairs.get("subject");
                } else {
                    str = null;
                    str2 = null;
                    strArr = null;
                }
                return new EmailAddressParsedResult(split, r2, strArr, str2, str);
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
            return new EmailAddressParsedResult(massagedText);
        } else {
            return null;
        }
    }
}
