package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.UnsupportedEncodingException;
@Deprecated
/* loaded from: classes8.dex */
public class Base64 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* loaded from: classes8.dex */
    public static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i2);

        public abstract boolean process(byte[] bArr, int i2, int i3, boolean z);
    }

    /* loaded from: classes8.dex */
    public static class Decoder extends Coder {
        public static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int EQUALS = -2;
        public static final int SKIP = -1;
        public final int[] alphabet;
        public int state;
        public int value;

        public Decoder(int i2, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i2 & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i2) {
            return ((i2 * 3) / 4) + 10;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public boolean process(byte[] bArr, int i2, int i3, boolean z) {
            int i4 = this.state;
            if (i4 == 6) {
                return false;
            }
            int i5 = i3 + i2;
            int i6 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i7 = i6;
            int i8 = 0;
            int i9 = i4;
            int i10 = i2;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5 || (i7 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i8 + 2] = (byte) i7;
                        bArr2[i8 + 1] = (byte) (i7 >> 8);
                        bArr2[i8] = (byte) (i7 >> 16);
                        i8 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i13 |= i7 << 6;
                    } else if (i9 == 2) {
                        if (i13 < 0) {
                            if (i13 == -2) {
                                bArr2[i8] = (byte) (i7 >> 4);
                                i8++;
                                i9 = 4;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i13 |= i7 << 6;
                    } else if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5 && i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i13 == -2) {
                            i9++;
                        } else if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        int i14 = i13 | (i7 << 6);
                        bArr2[i8 + 2] = (byte) i14;
                        bArr2[i8 + 1] = (byte) (i14 >> 8);
                        bArr2[i8] = (byte) (i14 >> 16);
                        i8 += 3;
                        i7 = i14;
                        i9 = 0;
                    } else if (i13 == -2) {
                        bArr2[i8 + 1] = (byte) (i7 >> 2);
                        bArr2[i8] = (byte) (i7 >> 10);
                        i8 += 2;
                        i9 = 5;
                    } else if (i13 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i9++;
                    i7 = i13;
                } else {
                    if (i13 < 0) {
                        if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i9++;
                    i7 = i13;
                }
                i10 = i12;
            }
            if (!z) {
                this.state = i9;
                this.value = i7;
                this.op = i8;
                return true;
            } else if (i9 != 1) {
                if (i9 == 2) {
                    bArr2[i8] = (byte) (i7 >> 4);
                    i8++;
                } else if (i9 == 3) {
                    int i15 = i8 + 1;
                    bArr2[i8] = (byte) (i7 >> 10);
                    i8 = i15 + 1;
                    bArr2[i15] = (byte) (i7 >> 2);
                } else if (i9 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i9;
                this.op = i8;
                return true;
            } else {
                this.state = 6;
                return false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class Encoder extends Coder {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        public static final int LINE_GROUPS = 19;
        public final byte[] alphabet;
        public int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        public final byte[] tail;
        public int tailLen;

        public Encoder(int i2, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i2 & 1) == 0;
            this.do_newline = (i2 & 2) == 0;
            this.do_cr = (i2 & 4) != 0;
            this.alphabet = (i2 & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        public int maxOutputSize(int i2) {
            return ((i2 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        @Override // org.apache.commons.codec.binary4util.bdapp.Base64.Coder
        @android.annotation.SuppressLint({"Assert"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.alphabet
                byte[] r2 = r0.output
                int r3 = r0.count
                int r4 = r20 + r19
                int r5 = r0.tailLen
                r6 = -1
                r7 = 0
                r8 = 2
                r9 = 1
                if (r5 == r9) goto L31
                if (r5 == r8) goto L15
                goto L50
            L15:
                int r5 = r19 + 1
                if (r5 > r4) goto L50
                byte[] r10 = r0.tail
                r11 = r10[r7]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.tailLen = r7
                r11 = r5
                goto L53
            L31:
                int r5 = r19 + 2
                if (r5 > r4) goto L50
                byte[] r5 = r0.tail
                r5 = r5[r7]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.tailLen = r7
                goto L53
            L50:
                r11 = r19
                r10 = -1
            L53:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L8f
                int r6 = r10 >> 18
                r6 = r6 & 63
                r6 = r1[r6]
                r2[r7] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                r6 = r1[r6]
                r2[r8] = r6
                r6 = r10 & 63
                r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + (-1)
                if (r3 != 0) goto L8d
                boolean r3 = r0.do_cr
                if (r3 == 0) goto L85
                r3 = 5
                r2[r12] = r13
                goto L86
            L85:
                r3 = 4
            L86:
                int r6 = r3 + 1
                r2[r3] = r14
            L8a:
                r3 = 19
                goto L90
            L8d:
                r6 = 4
                goto L90
            L8f:
                r6 = 0
            L90:
                int r10 = r11 + 3
                if (r10 > r4) goto Le6
                r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                r5 = r18[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + (-1)
                if (r3 != 0) goto Le4
                boolean r3 = r0.do_cr
                if (r3 == 0) goto Ldd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            Ldd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L8a
            Le4:
                r11 = r10
                goto L90
            Le6:
                if (r21 == 0) goto L1b5
                int r5 = r0.tailLen
                int r10 = r11 - r5
                int r15 = r4 + (-1)
                r16 = 61
                if (r10 != r15) goto L136
                if (r5 <= 0) goto Lfa
                byte[] r4 = r0.tail
                r4 = r4[r7]
                r7 = 1
                goto Lfc
            Lfa:
                r4 = r18[r11]
            Lfc:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r5 = r0.tailLen
                int r5 = r5 - r7
                r0.tailLen = r5
                int r5 = r6 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                r4 = r4 & 63
                r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.do_padding
                if (r1 == 0) goto L122
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L122:
                boolean r1 = r0.do_newline
                if (r1 == 0) goto L1de
                boolean r1 = r0.do_cr
                if (r1 == 0) goto L12f
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L12f:
                int r1 = r6 + 1
                r2[r6] = r14
            L133:
                r6 = r1
                goto L1de
            L136:
                int r10 = r11 - r5
                int r4 = r4 - r8
                if (r10 != r4) goto L19c
                if (r5 <= r9) goto L143
                byte[] r4 = r0.tail
                r4 = r4[r7]
                r7 = 1
                goto L149
            L143:
                int r4 = r11 + 1
                r5 = r18[r11]
                r11 = r4
                r4 = r5
            L149:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                int r5 = r0.tailLen
                if (r5 <= 0) goto L158
                byte[] r5 = r0.tail
                int r10 = r7 + 1
                r5 = r5[r7]
                r7 = r10
                goto L15a
            L158:
                r5 = r18[r11]
            L15a:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r8
                r4 = r4 | r5
                int r5 = r0.tailLen
                int r5 = r5 - r7
                r0.tailLen = r5
                int r5 = r6 + 1
                int r7 = r4 >> 12
                r7 = r7 & 63
                r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                r7 = r1[r7]
                r2[r5] = r7
                int r5 = r6 + 1
                r4 = r4 & 63
                r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.do_padding
                if (r1 == 0) goto L188
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L188:
                boolean r1 = r0.do_newline
                if (r1 == 0) goto L19a
                boolean r1 = r0.do_cr
                if (r1 == 0) goto L195
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L195:
                int r1 = r5 + 1
                r2[r5] = r14
                r5 = r1
            L19a:
                r6 = r5
                goto L1de
            L19c:
                boolean r1 = r0.do_newline
                if (r1 == 0) goto L1de
                if (r6 <= 0) goto L1de
                r1 = 19
                if (r3 == r1) goto L1de
                boolean r1 = r0.do_cr
                if (r1 == 0) goto L1af
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L1af:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L133
            L1b5:
                int r1 = r4 + (-1)
                if (r11 != r1) goto L1c6
                byte[] r1 = r0.tail
                int r2 = r0.tailLen
                int r4 = r2 + 1
                r0.tailLen = r4
                r4 = r18[r11]
                r1[r2] = r4
                goto L1de
            L1c6:
                int r4 = r4 - r8
                if (r11 != r4) goto L1de
                byte[] r1 = r0.tail
                int r2 = r0.tailLen
                int r4 = r2 + 1
                r0.tailLen = r4
                r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.tailLen = r2
                int r11 = r11 + r9
                r2 = r18[r11]
                r1[r4] = r2
            L1de:
                r0.op = r6
                r0.count = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary4util.bdapp.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int i2) throws IllegalArgumentException {
        return decode(str.getBytes(), i2);
    }

    public static byte[] encode(byte[] bArr, int i2) {
        return encode(bArr, 0, bArr.length, i2);
    }

    public static String encodeToString(byte[] bArr, int i2) {
        try {
            return new String(encode(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] decode(byte[] bArr, int i2) throws IllegalArgumentException {
        return decode(bArr, 0, bArr.length, i2);
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        Encoder encoder = new Encoder(i4, null);
        int i5 = (i3 / 3) * 4;
        if (encoder.do_padding) {
            if (i3 % 3 > 0) {
                i5 += 4;
            }
        } else {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        }
        if (encoder.do_newline && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i5];
        encoder.process(bArr, i2, i3, true);
        return encoder.output;
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IllegalArgumentException {
        Decoder decoder = new Decoder(i4, new byte[(i3 * 3) / 4]);
        if (decoder.process(bArr, i2, i3, true)) {
            int i5 = decoder.op;
            byte[] bArr2 = decoder.output;
            if (i5 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr2, 0, bArr3, 0, i5);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String encodeToString(byte[] bArr, int i2, int i3, int i4) {
        try {
            return new String(encode(bArr, i2, i3, i4), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
