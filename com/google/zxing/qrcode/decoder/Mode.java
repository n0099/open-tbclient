package com.google.zxing.qrcode.decoder;
/* loaded from: classes6.dex */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    public final int bits;
    public final int[] characterCountBitsForVersions;

    Mode(int[] iArr, int i2) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i2;
    }

    public static Mode forBits(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                if (i2 != 7) {
                                    if (i2 != 8) {
                                        if (i2 != 9) {
                                            if (i2 == 13) {
                                                return HANZI;
                                            }
                                            throw new IllegalArgumentException();
                                        }
                                        return FNC1_SECOND_POSITION;
                                    }
                                    return KANJI;
                                }
                                return ECI;
                            }
                            return FNC1_FIRST_POSITION;
                        }
                        return BYTE;
                    }
                    return STRUCTURED_APPEND;
                }
                return ALPHANUMERIC;
            }
            return NUMERIC;
        }
        return TERMINATOR;
    }

    public int getBits() {
        return this.bits;
    }

    public int getCharacterCountBits(Version version) {
        int versionNumber = version.getVersionNumber();
        return this.characterCountBitsForVersions[versionNumber <= 9 ? (char) 0 : versionNumber <= 26 ? (char) 1 : (char) 2];
    }
}
