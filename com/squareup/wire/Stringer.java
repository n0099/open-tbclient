package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            r9.state = r4;
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
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0129, code lost:
            switch(r4) {
                case 0: goto L26;
                case 1: goto L23;
                case 2: goto L25;
                case 3: goto L28;
                case 4: goto L29;
                case 5: goto L26;
                default: goto L21;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0141, code lost:
            throw new java.lang.AssertionError("state = " + r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0142, code lost:
            r9.state = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
            r6[r0] = (byte) (r2 >> 4);
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0150, code lost:
            r9.state = r4;
            r9.op = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0157, code lost:
            r1 = r0 + 1;
            r6[r0] = (byte) (r2 >> 10);
            r0 = r1 + 1;
            r6[r1] = (byte) (r2 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0166, code lost:
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

    /* loaded from: classes5.dex */
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
            int i4;
            int i5;
            byte b2;
            byte b3;
            byte b4;
            int i6 = 1;
            byte[] bArr2 = ENCODE;
            byte[] bArr3 = this.output;
            int i7 = i2 + i;
            switch (this.tailLen) {
                case 0:
                    i4 = -1;
                    i3 = i;
                    break;
                case 1:
                    if (i + 2 <= i7) {
                        int i8 = i + 1;
                        int i9 = i8 + 1;
                        i4 = (bArr[i8] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                        this.tailLen = 0;
                        i3 = i9;
                        break;
                    }
                    i4 = -1;
                    i3 = i;
                    break;
                case 2:
                    if (i + 1 <= i7) {
                        i3 = i + 1;
                        i4 = ((this.tail[1] & 255) << 8) | ((this.tail[0] & 255) << 16) | (bArr[i] & 255);
                        this.tailLen = 0;
                        break;
                    }
                    i4 = -1;
                    i3 = i;
                    break;
                default:
                    throw new AssertionError("tailLen = " + this.tailLen);
            }
            if (i4 != -1) {
                bArr3[0] = bArr2[(i4 >> 18) & 63];
                bArr3[1] = bArr2[(i4 >> 12) & 63];
                bArr3[2] = bArr2[(i4 >> 6) & 63];
                bArr3[3] = bArr2[i4 & 63];
                i5 = 4;
            } else {
                i5 = 0;
            }
            while (i3 + 3 <= i7) {
                int i10 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                bArr3[i5] = bArr2[(i10 >> 18) & 63];
                bArr3[i5 + 1] = bArr2[(i10 >> 12) & 63];
                bArr3[i5 + 2] = bArr2[(i10 >> 6) & 63];
                bArr3[i5 + 3] = bArr2[i10 & 63];
                i3 += 3;
                i5 += 4;
            }
            if (z) {
                if (i3 - this.tailLen == i7 - 1) {
                    if (this.tailLen > 0) {
                        b4 = this.tail[0];
                    } else {
                        b4 = bArr[i3];
                        i6 = 0;
                    }
                    int i11 = (b4 & 255) << 4;
                    this.tailLen -= i6;
                    int i12 = i5 + 1;
                    bArr3[i5] = bArr2[(i11 >> 6) & 63];
                    int i13 = i12 + 1;
                    bArr3[i12] = bArr2[i11 & 63];
                    bArr3[i13] = 61;
                    bArr3[i13 + 1] = 61;
                } else if (i3 - this.tailLen == i7 - 2) {
                    if (this.tailLen > 1) {
                        b2 = this.tail[0];
                    } else {
                        b2 = bArr[i3];
                        i6 = 0;
                        i3++;
                    }
                    int i14 = (b2 & 255) << 10;
                    if (this.tailLen > 0) {
                        b3 = this.tail[i6];
                        i6++;
                    } else {
                        b3 = bArr[i3];
                    }
                    int i15 = ((b3 & 255) << 2) | i14;
                    this.tailLen -= i6;
                    int i16 = i5 + 1;
                    bArr3[i5] = bArr2[(i15 >> 12) & 63];
                    int i17 = i16 + 1;
                    bArr3[i16] = bArr2[(i15 >> 6) & 63];
                    bArr3[i17] = bArr2[i15 & 63];
                    bArr3[i17 + 1] = 61;
                }
            } else if (i3 == i7 - 1) {
                byte[] bArr4 = this.tail;
                int i18 = this.tailLen;
                this.tailLen = i18 + 1;
                bArr4[i18] = bArr[i3];
            } else if (i3 == i7 - 2) {
                byte[] bArr5 = this.tail;
                int i19 = this.tailLen;
                this.tailLen = i19 + 1;
                bArr5[i19] = bArr[i3];
                byte[] bArr6 = this.tail;
                int i20 = this.tailLen;
                this.tailLen = i20 + 1;
                bArr6[i20] = bArr[i3 + 1];
            }
        }
    }
}
