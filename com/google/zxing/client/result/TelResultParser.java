package com.google.zxing.client.result;

import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.google.zxing.Result;
/* loaded from: classes5.dex */
public final class TelResultParser extends ResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PONE) || massagedText.startsWith("TEL:")) {
            String str = massagedText.startsWith("TEL:") ? UrlSchemaHelper.SCHEMA_TYPE_PONE + massagedText.substring(4) : massagedText;
            int indexOf = massagedText.indexOf(63, 4);
            return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
        }
        return null;
    }
}
