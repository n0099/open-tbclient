package org.apache.commons.codec.binary;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes10.dex */
public class Base32 extends BaseNCodec {
    public static final int BITS_PER_ENCODED_BYTE = 5;
    public static final int BYTES_PER_ENCODED_BLOCK = 8;
    public static final int BYTES_PER_UNENCODED_BLOCK = 5;
    public static final byte[] CHUNK_SEPARATOR = {13, 10};
    public static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    public static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    public static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    public static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    public static final int MASK_5BITS = 31;
    public long bitWorkArea;
    public final int decodeSize;
    public final byte[] decodeTable;
    public final int encodeSize;
    public final byte[] encodeTable;
    public final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Base32(int i, byte[] bArr, boolean z) {
        super(5, 8, i, r1);
        int length;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i > 0) {
            if (bArr != null) {
                if (!containsAlphabetOrPad(bArr)) {
                    this.encodeSize = bArr.length + 8;
                    byte[] bArr2 = new byte[bArr.length];
                    this.lineSeparator = bArr2;
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                } else {
                    String newStringUtf8 = StringUtils.newStringUtf8(bArr);
                    throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + PreferencesUtil.RIGHT_MOUNT);
                }
            } else {
                throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
            }
        } else {
            this.encodeSize = 8;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
    }

    public Base32(boolean z) {
        this(0, null, z);
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int, boolean] */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i, int i2) {
        byte b;
        if (this.eof) {
            return;
        }
        ?? r2 = 1;
        if (i2 < 0) {
            this.eof = true;
        }
        int i3 = i;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 == 61) {
                this.eof = r2;
                break;
            }
            ensureBufferSize(this.decodeSize);
            if (b2 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i6 = (this.modulus + r2) % 8;
                    this.modulus = i6;
                    long j = (this.bitWorkArea << 5) + b;
                    this.bitWorkArea = j;
                    if (i6 == 0) {
                        byte[] bArr3 = this.buffer;
                        int i7 = this.pos;
                        int i8 = i7 + 1;
                        this.pos = i8;
                        bArr3[i7] = (byte) ((j >> 32) & 255);
                        int i9 = i8 + 1;
                        this.pos = i9;
                        bArr3[i8] = (byte) ((j >> 24) & 255);
                        int i10 = i9 + 1;
                        this.pos = i10;
                        bArr3[i9] = (byte) ((j >> 16) & 255);
                        int i11 = i10 + 1;
                        this.pos = i11;
                        bArr3[i10] = (byte) ((j >> 8) & 255);
                        this.pos = i11 + 1;
                        bArr3[i11] = (byte) (j & 255);
                    }
                }
            }
            i4++;
            i3 = i5;
            r2 = 1;
        }
        if (this.eof && this.modulus >= 2) {
            ensureBufferSize(this.decodeSize);
            switch (this.modulus) {
                case 2:
                    byte[] bArr4 = this.buffer;
                    int i12 = this.pos;
                    this.pos = i12 + 1;
                    bArr4[i12] = (byte) ((this.bitWorkArea >> 2) & 255);
                    return;
                case 3:
                    byte[] bArr5 = this.buffer;
                    int i13 = this.pos;
                    this.pos = i13 + 1;
                    bArr5[i13] = (byte) ((this.bitWorkArea >> 7) & 255);
                    return;
                case 4:
                    long j2 = this.bitWorkArea >> 4;
                    this.bitWorkArea = j2;
                    byte[] bArr6 = this.buffer;
                    int i14 = this.pos;
                    int i15 = i14 + 1;
                    this.pos = i15;
                    bArr6[i14] = (byte) ((j2 >> 8) & 255);
                    this.pos = i15 + 1;
                    bArr6[i15] = (byte) (j2 & 255);
                    return;
                case 5:
                    long j3 = this.bitWorkArea >> 1;
                    this.bitWorkArea = j3;
                    byte[] bArr7 = this.buffer;
                    int i16 = this.pos;
                    int i17 = i16 + 1;
                    this.pos = i17;
                    bArr7[i16] = (byte) ((j3 >> 16) & 255);
                    int i18 = i17 + 1;
                    this.pos = i18;
                    bArr7[i17] = (byte) ((j3 >> 8) & 255);
                    this.pos = i18 + 1;
                    bArr7[i18] = (byte) (j3 & 255);
                    return;
                case 6:
                    long j4 = this.bitWorkArea >> 6;
                    this.bitWorkArea = j4;
                    byte[] bArr8 = this.buffer;
                    int i19 = this.pos;
                    int i20 = i19 + 1;
                    this.pos = i20;
                    bArr8[i19] = (byte) ((j4 >> 16) & 255);
                    int i21 = i20 + 1;
                    this.pos = i21;
                    bArr8[i20] = (byte) ((j4 >> 8) & 255);
                    this.pos = i21 + 1;
                    bArr8[i21] = (byte) (j4 & 255);
                    return;
                case 7:
                    long j5 = this.bitWorkArea >> 3;
                    this.bitWorkArea = j5;
                    byte[] bArr9 = this.buffer;
                    int i22 = this.pos;
                    int i23 = i22 + 1;
                    this.pos = i23;
                    bArr9[i22] = (byte) ((j5 >> 24) & 255);
                    int i24 = i23 + 1;
                    this.pos = i24;
                    bArr9[i23] = (byte) ((j5 >> 16) & 255);
                    int i25 = i24 + 1;
                    this.pos = i25;
                    bArr9[i24] = (byte) ((j5 >> 8) & 255);
                    this.pos = i25 + 1;
                    bArr9[i25] = (byte) (j5 & 255);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 < 0) {
            this.eof = true;
            if (this.modulus == 0 && this.lineLength == 0) {
                return;
            }
            ensureBufferSize(this.encodeSize);
            int i3 = this.pos;
            int i4 = this.modulus;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            byte[] bArr2 = this.buffer;
                            int i5 = i3 + 1;
                            this.pos = i5;
                            byte[] bArr3 = this.encodeTable;
                            long j = this.bitWorkArea;
                            bArr2[i3] = bArr3[((int) (j >> 27)) & 31];
                            int i6 = i5 + 1;
                            this.pos = i6;
                            bArr2[i5] = bArr3[((int) (j >> 22)) & 31];
                            int i7 = i6 + 1;
                            this.pos = i7;
                            bArr2[i6] = bArr3[((int) (j >> 17)) & 31];
                            int i8 = i7 + 1;
                            this.pos = i8;
                            bArr2[i7] = bArr3[((int) (j >> 12)) & 31];
                            int i9 = i8 + 1;
                            this.pos = i9;
                            bArr2[i8] = bArr3[((int) (j >> 7)) & 31];
                            int i10 = i9 + 1;
                            this.pos = i10;
                            bArr2[i9] = bArr3[((int) (j >> 2)) & 31];
                            int i11 = i10 + 1;
                            this.pos = i11;
                            bArr2[i10] = bArr3[((int) (j << 3)) & 31];
                            this.pos = i11 + 1;
                            bArr2[i11] = 61;
                        }
                    } else {
                        byte[] bArr4 = this.buffer;
                        int i12 = i3 + 1;
                        this.pos = i12;
                        byte[] bArr5 = this.encodeTable;
                        long j2 = this.bitWorkArea;
                        bArr4[i3] = bArr5[((int) (j2 >> 19)) & 31];
                        int i13 = i12 + 1;
                        this.pos = i13;
                        bArr4[i12] = bArr5[((int) (j2 >> 14)) & 31];
                        int i14 = i13 + 1;
                        this.pos = i14;
                        bArr4[i13] = bArr5[((int) (j2 >> 9)) & 31];
                        int i15 = i14 + 1;
                        this.pos = i15;
                        bArr4[i14] = bArr5[((int) (j2 >> 4)) & 31];
                        int i16 = i15 + 1;
                        this.pos = i16;
                        bArr4[i15] = bArr5[((int) (j2 << 1)) & 31];
                        int i17 = i16 + 1;
                        this.pos = i17;
                        bArr4[i16] = 61;
                        int i18 = i17 + 1;
                        this.pos = i18;
                        bArr4[i17] = 61;
                        this.pos = i18 + 1;
                        bArr4[i18] = 61;
                    }
                } else {
                    byte[] bArr6 = this.buffer;
                    int i19 = i3 + 1;
                    this.pos = i19;
                    byte[] bArr7 = this.encodeTable;
                    long j3 = this.bitWorkArea;
                    bArr6[i3] = bArr7[((int) (j3 >> 11)) & 31];
                    int i20 = i19 + 1;
                    this.pos = i20;
                    bArr6[i19] = bArr7[((int) (j3 >> 6)) & 31];
                    int i21 = i20 + 1;
                    this.pos = i21;
                    bArr6[i20] = bArr7[((int) (j3 >> 1)) & 31];
                    int i22 = i21 + 1;
                    this.pos = i22;
                    bArr6[i21] = bArr7[((int) (j3 << 4)) & 31];
                    int i23 = i22 + 1;
                    this.pos = i23;
                    bArr6[i22] = 61;
                    int i24 = i23 + 1;
                    this.pos = i24;
                    bArr6[i23] = 61;
                    int i25 = i24 + 1;
                    this.pos = i25;
                    bArr6[i24] = 61;
                    this.pos = i25 + 1;
                    bArr6[i25] = 61;
                }
            } else {
                byte[] bArr8 = this.buffer;
                int i26 = i3 + 1;
                this.pos = i26;
                byte[] bArr9 = this.encodeTable;
                long j4 = this.bitWorkArea;
                bArr8[i3] = bArr9[((int) (j4 >> 3)) & 31];
                int i27 = i26 + 1;
                this.pos = i27;
                bArr8[i26] = bArr9[((int) (j4 << 2)) & 31];
                int i28 = i27 + 1;
                this.pos = i28;
                bArr8[i27] = 61;
                int i29 = i28 + 1;
                this.pos = i29;
                bArr8[i28] = 61;
                int i30 = i29 + 1;
                this.pos = i30;
                bArr8[i29] = 61;
                int i31 = i30 + 1;
                this.pos = i31;
                bArr8[i30] = 61;
                int i32 = i31 + 1;
                this.pos = i32;
                bArr8[i31] = 61;
                this.pos = i32 + 1;
                bArr8[i32] = 61;
            }
            int i33 = this.currentLinePos;
            int i34 = this.pos;
            int i35 = i33 + (i34 - i3);
            this.currentLinePos = i35;
            if (this.lineLength > 0 && i35 > 0) {
                byte[] bArr10 = this.lineSeparator;
                System.arraycopy(bArr10, 0, this.buffer, i34, bArr10.length);
                this.pos += this.lineSeparator.length;
                return;
            }
            return;
        }
        int i36 = i;
        int i37 = 0;
        while (i37 < i2) {
            ensureBufferSize(this.encodeSize);
            this.modulus = (this.modulus + 1) % 5;
            int i38 = i36 + 1;
            int i39 = bArr[i36];
            if (i39 < 0) {
                i39 += 256;
            }
            long j5 = (this.bitWorkArea << 8) + i39;
            this.bitWorkArea = j5;
            if (this.modulus == 0) {
                byte[] bArr11 = this.buffer;
                int i40 = this.pos;
                int i41 = i40 + 1;
                this.pos = i41;
                byte[] bArr12 = this.encodeTable;
                bArr11[i40] = bArr12[((int) (j5 >> 35)) & 31];
                int i42 = i41 + 1;
                this.pos = i42;
                bArr11[i41] = bArr12[((int) (j5 >> 30)) & 31];
                int i43 = i42 + 1;
                this.pos = i43;
                bArr11[i42] = bArr12[((int) (j5 >> 25)) & 31];
                int i44 = i43 + 1;
                this.pos = i44;
                bArr11[i43] = bArr12[((int) (j5 >> 20)) & 31];
                int i45 = i44 + 1;
                this.pos = i45;
                bArr11[i44] = bArr12[((int) (j5 >> 15)) & 31];
                int i46 = i45 + 1;
                this.pos = i46;
                bArr11[i45] = bArr12[((int) (j5 >> 10)) & 31];
                int i47 = i46 + 1;
                this.pos = i47;
                bArr11[i46] = bArr12[((int) (j5 >> 5)) & 31];
                int i48 = i47 + 1;
                this.pos = i48;
                bArr11[i47] = bArr12[((int) j5) & 31];
                int i49 = this.currentLinePos + 8;
                this.currentLinePos = i49;
                int i50 = this.lineLength;
                if (i50 > 0 && i50 <= i49) {
                    byte[] bArr13 = this.lineSeparator;
                    System.arraycopy(bArr13, 0, bArr11, i48, bArr13.length);
                    this.pos += this.lineSeparator.length;
                    this.currentLinePos = 0;
                }
            }
            i37++;
            i36 = i38;
        }
    }
}
