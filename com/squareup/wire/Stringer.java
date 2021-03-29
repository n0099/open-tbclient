package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.nio.charset.Charset;
/* loaded from: classes7.dex */
public final class Stringer {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* loaded from: classes7.dex */
    public static class Decoder {
        public static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int EQUALS = -2;
        public static final int SKIP = -1;
        public int op;
        public final byte[] output;
        public int state = 0;
        public int value = 0;

        public Decoder(byte[] bArr) {
            this.output = bArr;
        }

        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.state;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = DECODE;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4) {
                            break;
                        }
                        i6 = iArr[bArr[i9 + 3] & 255] | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 2] & 255] << 6);
                        if (i6 < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                if (i12 != -2) {
                                    if (i12 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                }
                                i8++;
                            } else if (i8 != 5) {
                                throw new AssertionError("state = " + i8);
                            } else if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            i6 = (i6 << 6) | i12;
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i11;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i9 = i11;
                            i8 = 5;
                        } else if (i12 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i12 == -2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                        i9 = i11;
                        i8 = 4;
                    } else if (i12 != -1) {
                        this.state = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i8++;
                    i6 = i12;
                } else if (i12 != -1) {
                    this.state = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.state = i8;
                this.value = i6;
                this.op = i7;
                return true;
            }
            if (i8 != 0) {
                if (i8 == 1) {
                    this.state = 6;
                    return false;
                } else if (i8 == 2) {
                    bArr2[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i13 = i7 + 1;
                    bArr2[i7] = (byte) (i6 >> 10);
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    this.state = 6;
                    return false;
                } else if (i8 != 5) {
                    throw new AssertionError("state = " + i8);
                }
            }
            this.state = i8;
            this.op = i7;
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static class Encoder {
        public static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public final byte[] output;
        public final byte[] tail = new byte[2];
        public int tailLen = 0;

        public Encoder(byte[] bArr) {
            this.output = bArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x013b A[LOOP:0: B:19:0x0088->B:45:0x013b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x008c A[EDGE_INSN: B:46:0x008c->B:21:0x008c ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            int i5;
            int i6;
            byte b2;
            byte b3;
            byte b4;
            byte[] bArr2 = ENCODE;
            byte[] bArr3 = this.output;
            int i7 = i2 + i;
            int i8 = this.tailLen;
            int i9 = 0;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        throw new AssertionError("tailLen = " + this.tailLen);
                    }
                    i3 = i + 1;
                    if (i3 <= i7) {
                        byte[] bArr4 = this.tail;
                        i4 = (bArr[i] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16);
                        this.tailLen = 0;
                    }
                } else if (i + 2 <= i7) {
                    int i10 = i + 1;
                    i3 = i10 + 1;
                    i4 = ((bArr[i] & 255) << 8) | ((this.tail[0] & 255) << 16) | (bArr[i10] & 255);
                    this.tailLen = 0;
                }
                if (i4 == -1) {
                    bArr3[0] = bArr2[(i4 >> 18) & 63];
                    bArr3[1] = bArr2[(i4 >> 12) & 63];
                    bArr3[2] = bArr2[(i4 >> 6) & 63];
                    bArr3[3] = bArr2[i4 & 63];
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                while (true) {
                    i6 = i3 + 3;
                    if (i6 <= i7) {
                        break;
                    }
                    int i11 = (bArr[i3 + 2] & 255) | ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
                    bArr3[i5] = bArr2[(i11 >> 18) & 63];
                    bArr3[i5 + 1] = bArr2[(i11 >> 12) & 63];
                    bArr3[i5 + 2] = bArr2[(i11 >> 6) & 63];
                    bArr3[i5 + 3] = bArr2[i11 & 63];
                    i5 += 4;
                    i3 = i6;
                }
                if (z) {
                    if (i3 == i7 - 1) {
                        byte[] bArr5 = this.tail;
                        int i12 = this.tailLen;
                        this.tailLen = i12 + 1;
                        bArr5[i12] = bArr[i3];
                        return;
                    } else if (i3 == i7 - 2) {
                        byte[] bArr6 = this.tail;
                        int i13 = this.tailLen;
                        int i14 = i13 + 1;
                        this.tailLen = i14;
                        bArr6[i13] = bArr[i3];
                        this.tailLen = i14 + 1;
                        bArr6[i14] = bArr[i3 + 1];
                        return;
                    } else {
                        return;
                    }
                }
                int i15 = this.tailLen;
                if (i3 - i15 == i7 - 1) {
                    if (i15 > 0) {
                        b4 = this.tail[0];
                        i9 = 1;
                    } else {
                        b4 = bArr[i3];
                    }
                    int i16 = (b4 & 255) << 4;
                    this.tailLen -= i9;
                    int i17 = i5 + 1;
                    bArr3[i5] = bArr2[(i16 >> 6) & 63];
                    int i18 = i17 + 1;
                    bArr3[i17] = bArr2[i16 & 63];
                    bArr3[i18] = 61;
                    bArr3[i18 + 1] = 61;
                    return;
                } else if (i3 - i15 == i7 - 2) {
                    if (i15 > 1) {
                        b2 = this.tail[0];
                        i9 = 1;
                    } else {
                        byte b5 = bArr[i3];
                        i3++;
                        b2 = b5;
                    }
                    int i19 = (b2 & 255) << 10;
                    if (this.tailLen > 0) {
                        b3 = this.tail[i9];
                        i9++;
                    } else {
                        b3 = bArr[i3];
                    }
                    int i20 = ((b3 & 255) << 2) | i19;
                    this.tailLen -= i9;
                    int i21 = i5 + 1;
                    bArr3[i5] = bArr2[(i20 >> 12) & 63];
                    int i22 = i21 + 1;
                    bArr3[i21] = bArr2[(i20 >> 6) & 63];
                    bArr3[i22] = bArr2[i20 & 63];
                    bArr3[i22 + 1] = 61;
                    return;
                } else {
                    return;
                }
            }
            i3 = i;
            i4 = -1;
            if (i4 == -1) {
            }
            while (true) {
                i6 = i3 + 3;
                if (i6 <= i7) {
                }
                int i112 = (bArr[i3 + 2] & 255) | ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
                bArr3[i5] = bArr2[(i112 >> 18) & 63];
                bArr3[i5 + 1] = bArr2[(i112 >> 12) & 63];
                bArr3[i5 + 2] = bArr2[(i112 >> 6) & 63];
                bArr3[i5 + 3] = bArr2[i112 & 63];
                i5 += 4;
                i3 = i6;
            }
            if (z) {
            }
        }
    }

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes(UTF_8);
        Decoder decoder = new Decoder(new byte[(bytes.length * 3) / 4]);
        if (decoder.process(bytes, 0, bytes.length, true)) {
            if (decoder.op == decoder.output.length) {
                return decoder.output;
            }
            byte[] bArr = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr, 0, decoder.op);
            return bArr;
        }
        throw new IllegalArgumentException("bad base-64");
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
}
