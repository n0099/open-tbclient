package com.google.zxing;
/* loaded from: classes.dex */
public enum EncodeHintType {
    ERROR_CORRECTION,
    CHARACTER_SET,
    DATA_MATRIX_SHAPE,
    MIN_SIZE,
    MAX_SIZE,
    MARGIN,
    PDF417_COMPACT,
    PDF417_COMPACTION,
    PDF417_DIMENSIONS;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static EncodeHintType[] valuesCustom() {
        EncodeHintType[] valuesCustom = values();
        int length = valuesCustom.length;
        EncodeHintType[] encodeHintTypeArr = new EncodeHintType[length];
        System.arraycopy(valuesCustom, 0, encodeHintTypeArr, 0, length);
        return encodeHintTypeArr;
    }
}
