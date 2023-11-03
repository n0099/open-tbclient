package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes10.dex */
public final class TelResultParser extends ResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String str;
        String substring;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("tel:") && !massagedText.startsWith("TEL:")) {
            return null;
        }
        if (massagedText.startsWith("TEL:")) {
            str = "tel:" + massagedText.substring(4);
        } else {
            str = massagedText;
        }
        int indexOf = massagedText.indexOf(63, 4);
        if (indexOf < 0) {
            substring = massagedText.substring(4);
        } else {
            substring = massagedText.substring(4, indexOf);
        }
        return new TelParsedResult(substring, str, null);
    }
}
