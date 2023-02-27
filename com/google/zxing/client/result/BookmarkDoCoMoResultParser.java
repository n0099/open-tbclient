package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes8.dex */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("TITLE:", text, true);
        String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", text, true);
        if (matchDoCoMoPrefixedField == null) {
            return null;
        }
        String str = matchDoCoMoPrefixedField[0];
        if (!URIResultParser.isBasicallyValidURI(str)) {
            return null;
        }
        return new URIParsedResult(str, matchSingleDoCoMoPrefixedField);
    }
}
