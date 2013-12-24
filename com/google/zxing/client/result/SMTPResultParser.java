package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes.dex */
public final class SMTPResultParser extends ResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2 = null;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("smtp:") || massagedText.startsWith("SMTP:")) {
            String substring = massagedText.substring(5);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
                int indexOf2 = str.indexOf(58);
                if (indexOf2 >= 0) {
                    str2 = str.substring(indexOf2 + 1);
                    str = str.substring(0, indexOf2);
                }
            } else {
                str = null;
            }
            return new EmailAddressParsedResult(substring, str, str2, "mailto:" + substring);
        }
        return null;
    }
}
