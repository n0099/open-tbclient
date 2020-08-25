package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import java.nio.charset.Charset;
/* loaded from: classes18.dex */
final class Stringer {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private Stringer() {
    }

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes(UTF_8);
        Decoder decoder = new Decoder(new byte[(bytes.length * 3) / 4]);
        if (!decoder.process(bytes, 0, bytes.length, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }
        byte[] bArr = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, bArr, 0, decoder.op);
        return bArr;
    }

    public static String encode(byte[] bArr) {
        int length = (bArr.length / 3) * 4;
        if (bArr.length % 3 > 0) {
            length += 4;
        }
        Encoder encoder = new Encoder(new byte[length]);
        encoder.process(bArr, 0, bArr.length, true);
        return new String(encoder.output, UTF_8);
    }

    /* loaded from: classes18.dex */
    private static class Decoder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private int op;
        private final byte[] output;
        private int state = 0;
        private int value = 0;

        public Decoder(byte[] bArr) {
            this.output = bArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [108=4] */
        /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
            r9.state = r3;
            r9.value = r2;
            r9.op = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:?, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x012b, code lost:
            switch(r3) {
                case 0: goto L26;
                case 1: goto L23;
                case 2: goto L25;
                case 3: goto L28;
                case 4: goto L29;
                case 5: goto L26;
                default: goto L21;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0143, code lost:
            throw new java.lang.AssertionError("state = " + r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0144, code lost:
            r9.state = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x014a, code lost:
            r5[r0] = (byte) (r2 >> 4);
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0152, code lost:
            r9.state = r3;
            r9.op = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0159, code lost:
            r1 = r0 + 1;
            r5[r0] = (byte) (r2 >> 10);
            r0 = r1 + 1;
            r5[r1] = (byte) (r2 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0168, code lost:
            r9.state = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r13 != false) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            if (this.state == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.state;
            int i6 = this.value;
            int i7 = 0;
            byte[] bArr2 = this.output;
            int[] iArr = DECODE;
            int i8 = i5;
            int i9 = i;
            while (true) {
                if (i9 >= i4) {
                    i3 = i6;
                } else {
                    if (i8 == 0) {
                        while (i9 + 4 <= i4 && (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) >= 0) {
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 += 4;
                        }
                        if (i9 >= i4) {
                            i3 = i6;
                        }
                    }
                    int i10 = i9 + 1;
                    int i11 = iArr[bArr[i9] & 255];
                    switch (i8) {
                        case 0:
                            if (i11 >= 0) {
                                i8++;
                                i6 = i11;
                                i9 = i10;
                                continue;
                            } else if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                            break;
                        case 1:
                            if (i11 >= 0) {
                                i6 = (i6 << 6) | i11;
                                i8++;
                                i9 = i10;
                                continue;
                            } else if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                            break;
                        case 2:
                            if (i11 >= 0) {
                                i6 = (i6 << 6) | i11;
                                i8++;
                                i9 = i10;
                                continue;
                            } else if (i11 == -2) {
                                bArr2[i7] = (byte) (i6 >> 4);
                                i8 = 4;
                                i7++;
                                i9 = i10;
                            } else if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                            break;
                        case 3:
                            if (i11 >= 0) {
                                i6 = (i6 << 6) | i11;
                                bArr2[i7 + 2] = (byte) i6;
                                bArr2[i7 + 1] = (byte) (i6 >> 8);
                                bArr2[i7] = (byte) (i6 >> 16);
                                i7 += 3;
                                i8 = 0;
                                i9 = i10;
                                continue;
                            } else if (i11 == -2) {
                                bArr2[i7 + 1] = (byte) (i6 >> 2);
                                bArr2[i7] = (byte) (i6 >> 10);
                                i7 += 2;
                                i8 = 5;
                                i9 = i10;
                            } else if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                            break;
                        case 4:
                            if (i11 == -2) {
                                i8++;
                                i9 = i10;
                                continue;
                            } else if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                            break;
                        case 5:
                            if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                            break;
                        default:
                            throw new AssertionError("state = " + i8);
                    }
                    i9 = i10;
                }
            }
        }
    }

    /* loaded from: classes18.dex */
    private static class Encoder {
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private final byte[] output;
        private final byte[] tail = new byte[2];
        private int tailLen = 0;

        public Encoder(byte[] bArr) {
            this.output = bArr;
        }

        public void process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            byte b;
            int i4;
            int i5;
            byte b2;
            byte b3;
            int i6;
            byte[] bArr2 = ENCODE;
            byte[] bArr3 = this.output;
            int i7 = 0;
            int i8 = i2 + i;
            int i9 = -1;
            switch (this.tailLen) {
                case 0:
                    i3 = i;
                    break;
                case 1:
                    if (i + 2 <= i8) {
                        int i10 = i + 1;
                        i9 = ((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8) | (bArr[i10] & 255);
                        this.tailLen = 0;
                        i3 = i10 + 1;
                        break;
                    }
                    i3 = i;
                    break;
                case 2:
                    if (i + 1 <= i8) {
                        i3 = i + 1;
                        i9 = ((this.tail[0] & 255) << 16) | ((this.tail[1] & 255) << 8) | (bArr[i] & 255);
                        this.tailLen = 0;
                        break;
                    }
                    i3 = i;
                    break;
                default:
                    throw new AssertionError("tailLen = " + this.tailLen);
            }
            if (i9 != -1) {
                bArr3[0] = bArr2[(i9 >> 18) & 63];
                bArr3[1] = bArr2[(i9 >> 12) & 63];
                bArr3[2] = bArr2[(i9 >> 6) & 63];
                i7 = 4;
                bArr3[3] = bArr2[i9 & 63];
            }
            while (true) {
                int i11 = i7;
                if (i3 + 3 <= i8) {
                    int i12 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                    bArr3[i11] = bArr2[(i12 >> 18) & 63];
                    bArr3[i11 + 1] = bArr2[(i12 >> 12) & 63];
                    bArr3[i11 + 2] = bArr2[(i12 >> 6) & 63];
                    bArr3[i11 + 3] = bArr2[i12 & 63];
                    i3 += 3;
                    i7 = i11 + 4;
                } else if (z) {
                    if (i3 - this.tailLen == i8 - 1) {
                        if (this.tailLen > 0) {
                            i6 = 1;
                            b3 = this.tail[0];
                        } else {
                            b3 = bArr[i3];
                            i6 = 0;
                        }
                        int i13 = (b3 & 255) << 4;
                        this.tailLen -= i6;
                        int i14 = i11 + 1;
                        bArr3[i11] = bArr2[(i13 >> 6) & 63];
                        int i15 = i14 + 1;
                        bArr3[i14] = bArr2[i13 & 63];
                        bArr3[i15] = 61;
                        bArr3[i15 + 1] = 61;
                        return;
                    } else if (i3 - this.tailLen == i8 - 2) {
                        if (this.tailLen > 1) {
                            i5 = 1;
                            b = this.tail[0];
                            i4 = i3;
                        } else {
                            b = bArr[i3];
                            i4 = i3 + 1;
                            i5 = 0;
                        }
                        int i16 = (b & 255) << 10;
                        if (this.tailLen > 0) {
                            b2 = this.tail[i5];
                            i5++;
                        } else {
                            b2 = bArr[i4];
                        }
                        int i17 = ((b2 & 255) << 2) | i16;
                        this.tailLen -= i5;
                        int i18 = i11 + 1;
                        bArr3[i11] = bArr2[(i17 >> 12) & 63];
                        int i19 = i18 + 1;
                        bArr3[i18] = bArr2[(i17 >> 6) & 63];
                        bArr3[i19] = bArr2[i17 & 63];
                        bArr3[i19 + 1] = 61;
                        return;
                    } else {
                        return;
                    }
                } else if (i3 == i8 - 1) {
                    byte[] bArr4 = this.tail;
                    int i20 = this.tailLen;
                    this.tailLen = i20 + 1;
                    bArr4[i20] = bArr[i3];
                    return;
                } else if (i3 == i8 - 2) {
                    byte[] bArr5 = this.tail;
                    int i21 = this.tailLen;
                    this.tailLen = i21 + 1;
                    bArr5[i21] = bArr[i3];
                    byte[] bArr6 = this.tail;
                    int i22 = this.tailLen;
                    this.tailLen = i22 + 1;
                    bArr6[i22] = bArr[i3 + 1];
                    return;
                } else {
                    return;
                }
            }
        }
    }
}
