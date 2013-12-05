package com.google.zxing;
/* loaded from: classes.dex */
public enum ResultMetadataType {
    OTHER,
    ORIENTATION,
    BYTE_SEGMENTS,
    ERROR_CORRECTION_LEVEL,
    ISSUE_NUMBER,
    SUGGESTED_PRICE,
    POSSIBLE_COUNTRY,
    UPC_EAN_EXTENSION,
    PDF417_EXTRA_METADATA;

    /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ResultMetadataType[] valuesCustom() {
        ResultMetadataType[] valuesCustom = values();
        int length = valuesCustom.length;
        ResultMetadataType[] resultMetadataTypeArr = new ResultMetadataType[length];
        System.arraycopy(valuesCustom, 0, resultMetadataTypeArr, 0, length);
        return resultMetadataTypeArr;
    }
}
