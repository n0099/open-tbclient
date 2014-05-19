package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static final Pattern ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String[] matchDoCoMoPrefixedField;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("MATMSG:") && (matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("TO:", massagedText, true)) != null) {
            String str = matchDoCoMoPrefixedField[0];
            if (isBasicallyValidEmailAddress(str)) {
                return new EmailAddressParsedResult(str, matchSingleDoCoMoPrefixedField("SUB:", massagedText, false), matchSingleDoCoMoPrefixedField("BODY:", massagedText, false), "mailto:" + str);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBasicallyValidEmailAddress(String str) {
        return str != null && ATEXT_ALPHANUMERIC.matcher(str).matches() && str.indexOf(64) >= 0;
    }
}
