package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class FormatInformation {
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP = {new int[]{FORMAT_INFO_MASK_QR}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private static final int[] BITS_SET_IN_HALF_BYTE = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    private FormatInformation(int i) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.dataMask = (byte) (i & 7);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=8] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int numBitsDiffering(int i, int i2) {
        int i3 = i ^ i2;
        return BITS_SET_IN_HALF_BYTE[(i3 >>> 28) & 15] + BITS_SET_IN_HALF_BYTE[i3 & 15] + BITS_SET_IN_HALF_BYTE[(i3 >>> 4) & 15] + BITS_SET_IN_HALF_BYTE[(i3 >>> 8) & 15] + BITS_SET_IN_HALF_BYTE[(i3 >>> 12) & 15] + BITS_SET_IN_HALF_BYTE[(i3 >>> 16) & 15] + BITS_SET_IN_HALF_BYTE[(i3 >>> 20) & 15] + BITS_SET_IN_HALF_BYTE[(i3 >>> 24) & 15];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormatInformation decodeFormatInformation(int i, int i2) {
        FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(i, i2);
        return doDecodeFormatInformation != null ? doDecodeFormatInformation : doDecodeFormatInformation(i ^ FORMAT_INFO_MASK_QR, i2 ^ FORMAT_INFO_MASK_QR);
    }

    private static FormatInformation doDecodeFormatInformation(int i, int i2) {
        int i3;
        int i4;
        int i5 = Integer.MAX_VALUE;
        int[][] iArr = FORMAT_INFO_DECODE_LOOKUP;
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int[] iArr2 = iArr[i6];
            int i8 = iArr2[0];
            if (i8 == i || i8 == i2) {
                return new FormatInformation(iArr2[1]);
            }
            int numBitsDiffering = numBitsDiffering(i, i8);
            if (numBitsDiffering < i5) {
                i3 = iArr2[1];
            } else {
                numBitsDiffering = i5;
                i3 = i7;
            }
            if (i == i2 || (i4 = numBitsDiffering(i2, i8)) >= numBitsDiffering) {
                i4 = numBitsDiffering;
            } else {
                i3 = iArr2[1];
            }
            i6++;
            int i9 = i3;
            i5 = i4;
            i7 = i9;
        }
        if (i5 <= 3) {
            return new FormatInformation(i7);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte getDataMask() {
        return this.dataMask;
    }

    public final int hashCode() {
        return (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof FormatInformation) {
            FormatInformation formatInformation = (FormatInformation) obj;
            return this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask;
        }
        return false;
    }
}
