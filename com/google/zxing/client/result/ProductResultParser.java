package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
/* loaded from: classes.dex */
public final class ProductResultParser extends ResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public final ProductParsedResult parse(Result result) {
        BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat == BarcodeFormat.UPC_A || barcodeFormat == BarcodeFormat.UPC_E || barcodeFormat == BarcodeFormat.EAN_8 || barcodeFormat == BarcodeFormat.EAN_13) {
            String massagedText = getMassagedText(result);
            int length = massagedText.length();
            for (int i = 0; i < length; i++) {
                char charAt = massagedText.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
            }
            return new ProductParsedResult(massagedText, massagedText);
        }
        return null;
    }
}
