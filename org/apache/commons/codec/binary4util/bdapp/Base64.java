package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
@Deprecated
/* loaded from: classes6.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static {
        $assertionsDisabled = !Base64.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        Coder() {
        }
    }

    public static byte[] decode(String str, int i) throws IllegalArgumentException {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) throws IllegalArgumentException {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) throws IllegalArgumentException {
        Decoder decoder = new Decoder(i3, new byte[(i2 * 3) / 4]);
        if (!decoder.process(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }
        byte[] bArr2 = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, bArr2, 0, decoder.op);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
            if (r13 != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
            r9.state = r3;
            r9.value = r2;
            r9.op = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0104, code lost:
            switch(r3) {
                case 0: goto L21;
                case 1: goto L23;
                case 2: goto L25;
                case 3: goto L26;
                case 4: goto L27;
                default: goto L21;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0107, code lost:
            r9.state = r3;
            r9.op = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010e, code lost:
            r9.state = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0114, code lost:
            r5[r0] = (byte) (r2 >> 4);
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x011d, code lost:
            r1 = r0 + 1;
            r5[r0] = (byte) (r2 >> 10);
            r0 = r1 + 1;
            r5[r1] = (byte) (r2 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x012c, code lost:
            r9.state = 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:?, code lost:
            return false;
         */
        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
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
            int[] iArr = this.alphabet;
            int i8 = i;
            while (true) {
                if (i8 < i4) {
                    if (i5 == 0) {
                        while (i8 + 4 <= i4 && (i6 = (iArr[bArr[i8] & 255] << 18) | (iArr[bArr[i8 + 1] & 255] << 12) | (iArr[bArr[i8 + 2] & 255] << 6) | iArr[bArr[i8 + 3] & 255]) >= 0) {
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i8 += 4;
                        }
                        if (i8 >= i4) {
                            i3 = i6;
                        }
                    }
                    int i9 = i8 + 1;
                    int i10 = iArr[bArr[i8] & 255];
                    switch (i5) {
                        case 0:
                            if (i10 >= 0) {
                                i5++;
                                i6 = i10;
                                break;
                            } else if (i10 == -1) {
                                break;
                            } else {
                                this.state = 6;
                                return false;
                            }
                        case 1:
                            if (i10 >= 0) {
                                i6 = (i6 << 6) | i10;
                                i5++;
                                break;
                            } else if (i10 == -1) {
                                break;
                            } else {
                                this.state = 6;
                                return false;
                            }
                        case 2:
                            if (i10 >= 0) {
                                i6 = (i6 << 6) | i10;
                                i5++;
                                break;
                            } else if (i10 == -2) {
                                bArr2[i7] = (byte) (i6 >> 4);
                                i5 = 4;
                                i7++;
                                break;
                            } else if (i10 == -1) {
                                break;
                            } else {
                                this.state = 6;
                                return false;
                            }
                        case 3:
                            if (i10 >= 0) {
                                i6 = (i6 << 6) | i10;
                                bArr2[i7 + 2] = (byte) i6;
                                bArr2[i7 + 1] = (byte) (i6 >> 8);
                                bArr2[i7] = (byte) (i6 >> 16);
                                i7 += 3;
                                i5 = 0;
                                break;
                            } else if (i10 == -2) {
                                bArr2[i7 + 1] = (byte) (i6 >> 2);
                                bArr2[i7] = (byte) (i6 >> 10);
                                i7 += 2;
                                i5 = 5;
                                break;
                            } else if (i10 == -1) {
                                break;
                            } else {
                                this.state = 6;
                                return false;
                            }
                        case 4:
                            if (i10 == -2) {
                                i5++;
                                break;
                            } else if (i10 == -1) {
                                break;
                            } else {
                                this.state = 6;
                                return false;
                            }
                        case 5:
                            if (i10 == -1) {
                                break;
                            } else {
                                this.state = 6;
                                return false;
                            }
                    }
                    i8 = i9;
                } else {
                    i3 = i6;
                }
            }
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(encode(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        if (encoder.do_padding) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        }
        if (encoder.do_newline && i2 > 0) {
            i4 += (encoder.do_cr ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        if ($assertionsDisabled || encoder.op == i4) {
            return encoder.output;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final byte[] ENCODE;
        private static final byte[] ENCODE_WEBSAFE;
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            $assertionsDisabled = !Base64.class.desiredAssertionStatus();
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public Encoder(int i, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            this.do_newline = (i & 2) == 0;
            this.do_cr = (i & 4) != 0;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        @SuppressLint({"Assert"})
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            byte b2;
            int i5;
            byte b3;
            int i6;
            byte b4;
            int i7;
            int i8;
            int i9;
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i10 = 0;
            int i11 = this.count;
            int i12 = i2 + i;
            int i13 = -1;
            switch (this.tailLen) {
                case 0:
                    i3 = i;
                    break;
                case 1:
                    if (i + 2 <= i12) {
                        int i14 = i + 1;
                        i13 = ((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8) | (bArr[i14] & 255);
                        this.tailLen = 0;
                        i3 = i14 + 1;
                        break;
                    }
                    i3 = i;
                    break;
                case 2:
                    if (i + 1 <= i12) {
                        i3 = i + 1;
                        i13 = ((this.tail[0] & 255) << 16) | ((this.tail[1] & 255) << 8) | (bArr[i] & 255);
                        this.tailLen = 0;
                        break;
                    }
                    i3 = i;
                    break;
                default:
                    i3 = i;
                    break;
            }
            if (i13 != -1) {
                bArr3[0] = bArr2[(i13 >> 18) & 63];
                bArr3[1] = bArr2[(i13 >> 12) & 63];
                bArr3[2] = bArr2[(i13 >> 6) & 63];
                i10 = 4;
                bArr3[3] = bArr2[i13 & 63];
                i11--;
                if (i11 == 0) {
                    if (this.do_cr) {
                        i9 = 5;
                        bArr3[4] = 13;
                    } else {
                        i9 = 4;
                    }
                    i10 = i9 + 1;
                    bArr3[i9] = 10;
                    i11 = 19;
                }
            }
            while (true) {
                int i15 = i11;
                int i16 = i10;
                if (i3 + 3 <= i12) {
                    int i17 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                    bArr3[i16] = bArr2[(i17 >> 18) & 63];
                    bArr3[i16 + 1] = bArr2[(i17 >> 12) & 63];
                    bArr3[i16 + 2] = bArr2[(i17 >> 6) & 63];
                    bArr3[i16 + 3] = bArr2[i17 & 63];
                    i3 += 3;
                    i10 = i16 + 4;
                    i11 = i15 - 1;
                    if (i11 == 0) {
                        if (this.do_cr) {
                            i8 = i10 + 1;
                            bArr3[i10] = 13;
                        } else {
                            i8 = i10;
                        }
                        i10 = i8 + 1;
                        bArr3[i8] = 10;
                        i11 = 19;
                    }
                } else {
                    if (z) {
                        if (i3 - this.tailLen == i12 - 1) {
                            if (this.tailLen > 0) {
                                i7 = 1;
                                b4 = this.tail[0];
                            } else {
                                b4 = bArr[i3];
                                i7 = 0;
                                i3++;
                            }
                            int i18 = (b4 & 255) << 4;
                            this.tailLen -= i7;
                            int i19 = i16 + 1;
                            bArr3[i16] = bArr2[(i18 >> 6) & 63];
                            int i20 = i19 + 1;
                            bArr3[i19] = bArr2[i18 & 63];
                            if (this.do_padding) {
                                int i21 = i20 + 1;
                                bArr3[i20] = 61;
                                i20 = i21 + 1;
                                bArr3[i21] = 61;
                            }
                            if (this.do_newline) {
                                if (this.do_cr) {
                                    bArr3[i20] = 13;
                                    i20++;
                                }
                                bArr3[i20] = 10;
                                i20++;
                            }
                            i16 = i20;
                        } else if (i3 - this.tailLen == i12 - 2) {
                            if (this.tailLen > 1) {
                                i5 = 1;
                                b2 = this.tail[0];
                            } else {
                                b2 = bArr[i3];
                                i5 = 0;
                                i3++;
                            }
                            int i22 = (b2 & 255) << 10;
                            if (this.tailLen > 0) {
                                b3 = this.tail[i5];
                                i5++;
                            } else {
                                b3 = bArr[i3];
                                i3++;
                            }
                            int i23 = ((b3 & 255) << 2) | i22;
                            this.tailLen -= i5;
                            int i24 = i16 + 1;
                            bArr3[i16] = bArr2[(i23 >> 12) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[(i23 >> 6) & 63];
                            int i26 = i25 + 1;
                            bArr3[i25] = bArr2[i23 & 63];
                            if (this.do_padding) {
                                i6 = i26 + 1;
                                bArr3[i26] = 61;
                            } else {
                                i6 = i26;
                            }
                            if (this.do_newline) {
                                if (this.do_cr) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                bArr3[i6] = 10;
                                i6++;
                            }
                            i16 = i6;
                        } else if (this.do_newline && i16 > 0 && i15 != 19) {
                            if (this.do_cr) {
                                i4 = i16 + 1;
                                bArr3[i16] = 13;
                            } else {
                                i4 = i16;
                            }
                            i16 = i4 + 1;
                            bArr3[i4] = 10;
                        }
                        if (!$assertionsDisabled && this.tailLen != 0) {
                            throw new AssertionError();
                        }
                        if (!$assertionsDisabled && i3 != i12) {
                            throw new AssertionError();
                        }
                    } else if (i3 == i12 - 1) {
                        byte[] bArr4 = this.tail;
                        int i27 = this.tailLen;
                        this.tailLen = i27 + 1;
                        bArr4[i27] = bArr[i3];
                    } else if (i3 == i12 - 2) {
                        byte[] bArr5 = this.tail;
                        int i28 = this.tailLen;
                        this.tailLen = i28 + 1;
                        bArr5[i28] = bArr[i3];
                        byte[] bArr6 = this.tail;
                        int i29 = this.tailLen;
                        this.tailLen = i29 + 1;
                        bArr6[i29] = bArr[i3 + 1];
                    }
                    this.op = i16;
                    this.count = i15;
                    return true;
                }
            }
        }
    }

    private Base64() {
    }
}
