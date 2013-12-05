package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private final int bits;

    /* renamed from: a  reason: collision with root package name */
    private static final ErrorCorrectionLevel[] f2877a = {M, L, H, Q};

    /* JADX DEBUG: Replace access to removed values field (b) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ErrorCorrectionLevel[] valuesCustom() {
        ErrorCorrectionLevel[] valuesCustom = values();
        int length = valuesCustom.length;
        ErrorCorrectionLevel[] errorCorrectionLevelArr = new ErrorCorrectionLevel[length];
        System.arraycopy(valuesCustom, 0, errorCorrectionLevelArr, 0, length);
        return errorCorrectionLevelArr;
    }

    ErrorCorrectionLevel(int i) {
        this.bits = i;
    }

    public int getBits() {
        return this.bits;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i < 0 || i >= f2877a.length) {
            throw new IllegalArgumentException();
        }
        return f2877a[i];
    }
}
