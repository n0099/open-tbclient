package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
public enum Mode {
    TERMINATOR(new int[3], 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[3], 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[3], 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[3], 5),
    FNC1_SECOND_POSITION(new int[3], 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int bits;
    private final int[] characterCountBitsForVersions;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static Mode[] valuesCustom() {
        Mode[] valuesCustom = values();
        int length = valuesCustom.length;
        Mode[] modeArr = new Mode[length];
        System.arraycopy(valuesCustom, 0, modeArr, 0, length);
        return modeArr;
    }

    Mode(int[] iArr, int i) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i;
    }

    public static Mode forBits(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 6:
            case 10:
            case 11:
            case 12:
            default:
                throw new IllegalArgumentException();
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case 13:
                return HANZI;
        }
    }

    public int getCharacterCountBits(Version version) {
        char c;
        int versionNumber = version.getVersionNumber();
        if (versionNumber <= 9) {
            c = 0;
        } else if (versionNumber <= 26) {
            c = 1;
        } else {
            c = 2;
        }
        return this.characterCountBitsForVersions[c];
    }

    public int getBits() {
        return this.bits;
    }
}
