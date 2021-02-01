package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes4.dex */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (text.startsWith("MEBKM:")) {
            String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("TITLE:", text, true);
            String[] matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("URL:", text, true);
            if (matchDoCoMoPrefixedField != null) {
                String str = matchDoCoMoPrefixedField[0];
                if (URIResultParser.isBasicallyValidURI(str)) {
                    return new URIParsedResult(str, matchSingleDoCoMoPrefixedField);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
