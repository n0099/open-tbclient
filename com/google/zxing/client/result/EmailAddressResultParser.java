package com.google.zxing.client.result;

import androidx.core.net.MailTo;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class EmailAddressResultParser extends ResultParser {
    public static final Pattern COMMA = Pattern.compile(",");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String str;
        String str2;
        String[] strArr5;
        String str3;
        String massagedText = ResultParser.getMassagedText(result);
        String[] strArr6 = null;
        if (!massagedText.startsWith("mailto:") && !massagedText.startsWith("MAILTO:")) {
            if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
                return null;
            }
            return new EmailAddressParsedResult(massagedText);
        }
        String substring = massagedText.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        try {
            String urlDecode = ResultParser.urlDecode(substring);
            if (!urlDecode.isEmpty()) {
                strArr = COMMA.split(urlDecode);
            } else {
                strArr = null;
            }
            Map<String, String> parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
            if (parseNameValuePairs != null) {
                if (strArr == null && (str3 = parseNameValuePairs.get("to")) != null) {
                    strArr = COMMA.split(str3);
                }
                String str4 = parseNameValuePairs.get(MailTo.CC);
                if (str4 != null) {
                    strArr5 = COMMA.split(str4);
                } else {
                    strArr5 = null;
                }
                String str5 = parseNameValuePairs.get(MailTo.BCC);
                if (str5 != null) {
                    strArr6 = COMMA.split(str5);
                }
                str2 = parseNameValuePairs.get("body");
                strArr2 = strArr;
                strArr4 = strArr6;
                strArr3 = strArr5;
                str = parseNameValuePairs.get(MailTo.SUBJECT);
            } else {
                strArr2 = strArr;
                strArr3 = null;
                strArr4 = null;
                str = null;
                str2 = null;
            }
            return new EmailAddressParsedResult(strArr2, strArr3, strArr4, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
