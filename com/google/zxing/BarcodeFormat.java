package com.google.zxing;
/* loaded from: classes.dex */
public enum BarcodeFormat {
    AZTEC,
    CODABAR,
    CODE_39,
    CODE_93,
    CODE_128,
    DATA_MATRIX,
    EAN_8,
    EAN_13,
    ITF,
    MAXICODE,
    PDF_417,
    QR_CODE,
    RSS_14,
    RSS_EXPANDED,
    UPC_A,
    UPC_E,
    UPC_EAN_EXTENSION;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static BarcodeFormat[] valuesCustom() {
        BarcodeFormat[] valuesCustom = values();
        int length = valuesCustom.length;
        BarcodeFormat[] barcodeFormatArr = new BarcodeFormat[length];
        System.arraycopy(valuesCustom, 0, barcodeFormatArr, 0, length);
        return barcodeFormatArr;
    }
}
