package com.google.zxing.client.result;

import com.baidu.webkit.sdk.WebView;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class EmailAddressResultParser extends ResultParser {
    public static final Pattern COMMA = Pattern.compile(",");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith(WebView.SCHEME_MAILTO) && !massagedText.startsWith("MAILTO:")) {
            if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
                return new EmailAddressParsedResult(massagedText);
            }
            return null;
        }
        String substring = massagedText.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        try {
            String urlDecode = ResultParser.urlDecode(substring);
            String[] split = !urlDecode.isEmpty() ? COMMA.split(urlDecode) : null;
            Map<String, String> parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
            if (parseNameValuePairs != null) {
                if (split == null && (str3 = parseNameValuePairs.get("to")) != null) {
                    split = COMMA.split(str3);
                }
                String str4 = parseNameValuePairs.get("cc");
                String[] split2 = str4 != null ? COMMA.split(str4) : null;
                String str5 = parseNameValuePairs.get("bcc");
                String[] split3 = str5 != null ? COMMA.split(str5) : null;
                str2 = parseNameValuePairs.get("body");
                strArr = split;
                strArr3 = split3;
                strArr2 = split2;
                str = parseNameValuePairs.get("subject");
            } else {
                strArr = split;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new EmailAddressParsedResult(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
