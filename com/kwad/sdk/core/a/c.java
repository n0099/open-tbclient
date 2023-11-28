package com.kwad.sdk.core.a;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes10.dex */
public final class c {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* loaded from: classes10.dex */
    public static class a {
        public static final int[] asJ;
        public final boolean asL;
        public final boolean asM = false;
        public static final a asH = new a(false, false);
        public static final a asI = new a(true, false);
        public static final int[] asK = new int[256];

        static {
            int[] iArr = new int[256];
            asJ = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < b.asP.length; i++) {
                asJ[b.asP[i]] = i;
            }
            asJ[61] = -2;
            Arrays.fill(asK, -1);
            for (int i2 = 0; i2 < b.asQ.length; i2++) {
                asK[b.asQ[i2]] = i2;
            }
            asK[61] = -2;
        }

        public a(boolean z, boolean z2) {
            this.asL = z;
        }

        private int a(byte[] bArr, int i, int i2) {
            int[] iArr;
            int i3;
            if (this.asL) {
                iArr = asK;
            } else {
                iArr = asJ;
            }
            int i4 = i2 + 0;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.asM && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.asM) {
                int i6 = 0;
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i7 = i + 1;
                    int i8 = bArr[i] & 255;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
            if (r11[r8] == 61) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
            if (r4 != 18) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
            if (r4 != 6) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
            r14[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
            if (r4 != 0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
            r1 = r5 + 1;
            r14[r5] = (byte) (r3 >> 16);
            r5 = r1 + 1;
            r14[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
            if (r4 == 12) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
            if (r12 >= r13) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
            if (r10.asM == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
            r14 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
            if (r0[r11[r12]] >= 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ac, code lost:
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c1, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int[] iArr;
            if (this.asL) {
                iArr = asK;
            } else {
                iArr = asJ;
            }
            int i3 = 0;
            int i4 = 18;
            int i5 = 0;
            while (true) {
                if (i >= i2) {
                    break;
                }
                int i6 = i + 1;
                int i7 = iArr[bArr[i] & 255];
                if (i7 < 0) {
                    if (i7 == -2) {
                        if (i4 == 6) {
                            if (i6 != i2) {
                                i = i6 + 1;
                            }
                            throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                        }
                        i = i6;
                    } else if (!this.asM) {
                        throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i6 - 1], 16));
                    }
                } else {
                    int i8 = (i7 << i4) | i3;
                    i4 -= 6;
                    if (i4 < 0) {
                        int i9 = i5 + 1;
                        bArr2[i5] = (byte) (i8 >> 16);
                        int i10 = i9 + 1;
                        bArr2[i9] = (byte) (i8 >> 8);
                        i5 = i10 + 1;
                        bArr2[i10] = (byte) i8;
                        i3 = 0;
                        i4 = 18;
                    } else {
                        i3 = i8;
                    }
                }
                i = i6;
            }
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        public final byte[] decode(byte[] bArr) {
            int a = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a];
            int a2 = a(bArr, 0, bArr.length, bArr2);
            if (a2 != a) {
                return Arrays.copyOf(bArr2, a2);
            }
            return bArr2;
        }
    }

    public static b Ci() {
        return b.asN;
    }

    public static b Cj() {
        return b.asO;
    }

    public static a Ck() {
        return a.asH;
    }

    public static a Cl() {
        return a.asI;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static final b asN = new b(false, null, -1, true);
        public static final b asO = new b(true, null, -1, false);
        public static final char[] asP = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};
        public static final char[] asQ = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureImpl.SEP, '_'};
        public final boolean asL;
        public final byte[] asR = null;
        public final int asS = -1;
        public final boolean asT;

        public b(boolean z, byte[] bArr, int i, boolean z2) {
            this.asL = z;
            this.asT = z2;
        }

        private int b(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr;
            if (this.asL) {
                cArr = asQ;
            } else {
                cArr = asP;
            }
            int i3 = ((i2 + 0) / 3) * 3;
            int i4 = i3 + 0;
            int i5 = this.asS;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                int min = Math.min(i6 + i3, i4);
                int i8 = i6;
                int i9 = i7;
                while (i8 < min) {
                    int i10 = i8 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((bArr[i8] & 255) << 16) | ((bArr[i10] & 255) << 8);
                    int i13 = i11 + 1;
                    int i14 = i12 | (bArr[i11] & 255);
                    int i15 = i9 + 1;
                    bArr2[i9] = (byte) cArr[(i14 >>> 18) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i14 >>> 12) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) cArr[(i14 >>> 6) & 63];
                    i9 = i17 + 1;
                    bArr2[i17] = (byte) cArr[i14 & 63];
                    i8 = i13;
                }
                int i18 = ((min - i6) / 3) * 4;
                i7 += i18;
                if (i18 == this.asS && min < i2) {
                    byte[] bArr3 = this.asR;
                    int length = bArr3.length;
                    int i19 = 0;
                    while (i19 < length) {
                        bArr2[i7] = bArr3[i19];
                        i19++;
                        i7++;
                    }
                }
                i6 = min;
            }
            if (i6 < i2) {
                int i20 = i6 + 1;
                int i21 = bArr[i6] & 255;
                int i22 = i7 + 1;
                bArr2[i7] = (byte) cArr[i21 >> 2];
                if (i20 == i2) {
                    int i23 = i22 + 1;
                    bArr2[i22] = (byte) cArr[(i21 << 4) & 63];
                    if (this.asT) {
                        int i24 = i23 + 1;
                        bArr2[i23] = 61;
                        int i25 = i24 + 1;
                        bArr2[i24] = 61;
                        return i25;
                    }
                    return i23;
                }
                int i26 = bArr[i20] & 255;
                int i27 = i22 + 1;
                bArr2[i22] = (byte) cArr[((i21 << 4) & 63) | (i26 >> 4)];
                int i28 = i27 + 1;
                bArr2[i27] = (byte) cArr[(i26 << 2) & 63];
                if (this.asT) {
                    int i29 = i28 + 1;
                    bArr2[i28] = 61;
                    return i29;
                }
                return i28;
            }
            return i7;
        }

        private final int cq(int i) {
            int i2;
            int i3;
            if (this.asT) {
                i3 = ((i + 2) / 3) * 4;
            } else {
                int i4 = i % 3;
                int i5 = (i / 3) * 4;
                if (i4 == 0) {
                    i2 = 0;
                } else {
                    i2 = i4 + 1;
                }
                i3 = i5 + i2;
            }
            int i6 = this.asS;
            if (i6 > 0) {
                return i3 + (((i3 - 1) / i6) * this.asR.length);
            }
            return i3;
        }

        public final byte[] encode(byte[] bArr) {
            int cq = cq(bArr.length);
            byte[] bArr2 = new byte[cq];
            int b = b(bArr, 0, bArr.length, bArr2);
            if (b != cq) {
                return Arrays.copyOf(bArr2, b);
            }
            return bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static String dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(Ci().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("sDAkk/dS")) {
            return new String(Ck().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8);
        }
        return str;
    }

    public static boolean dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }
}
