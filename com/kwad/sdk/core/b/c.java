package com.kwad.sdk.core.b;

import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f31989a = Charset.forName("ISO-8859-1");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f31992c;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f31994e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f31995f;

        /* renamed from: a  reason: collision with root package name */
        public static final a f31990a = new a(false, false);

        /* renamed from: b  reason: collision with root package name */
        public static final a f31991b = new a(true, false);

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f31993d = new int[256];

        static {
            int[] iArr = new int[256];
            f31992c = iArr;
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < b.f31999d.length; i2++) {
                f31992c[b.f31999d[i2]] = i2;
            }
            f31992c[61] = -2;
            Arrays.fill(f31993d, -1);
            for (int i3 = 0; i3 < b.f32000e.length; i3++) {
                f31993d[b.f32000e[i3]] = i3;
            }
            f31993d[61] = -2;
        }

        public a(boolean z, boolean z2) {
            this.f31994e = z;
            this.f31995f = z2;
        }

        private int a(byte[] bArr, int i2, int i3) {
            int i4;
            int[] iArr = this.f31994e ? f31993d : f31992c;
            int i5 = i3 - i2;
            int i6 = 0;
            if (i5 == 0) {
                return 0;
            }
            if (i5 < 2) {
                if (this.f31995f && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.f31995f) {
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i8 = i2 + 1;
                    int i9 = bArr[i2] & 255;
                    if (i9 == 61) {
                        i5 -= (i3 - i8) + 1;
                        break;
                    }
                    if (iArr[i9] == -1) {
                        i7++;
                    }
                    i2 = i8;
                }
                i5 -= i7;
            } else if (bArr[i3 - 1] == 61) {
                i6 = bArr[i3 - 2] == 61 ? 2 : 1;
            }
            if (i6 == 0 && (i4 = i5 & 3) != 0) {
                i6 = 4 - i4;
            }
            return (((i5 + 3) / 4) * 3) - i6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
            if (r11[r8] == 61) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
            if (r4 != 18) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
            if (r4 != 6) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
            r14[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
            if (r4 != 0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
            r1 = r5 + 1;
            r14[r5] = (byte) (r3 >> 16);
            r5 = r1 + 1;
            r14[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009d, code lost:
            if (r4 == 12) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
            if (r12 >= r13) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
            if (r10.f31995f == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a5, code lost:
            r14 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ab, code lost:
            if (r0[r11[r12]] >= 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c6, code lost:
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c7, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00cf, code lost:
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i2, int i3, byte[] bArr2) {
            int[] iArr = this.f31994e ? f31993d : f31992c;
            int i4 = 0;
            int i5 = 18;
            int i6 = 0;
            while (true) {
                if (i2 >= i3) {
                    break;
                }
                int i7 = i2 + 1;
                int i8 = iArr[bArr[i2] & 255];
                if (i8 >= 0) {
                    int i9 = (i8 << i5) | i4;
                    i5 -= 6;
                    if (i5 < 0) {
                        int i10 = i6 + 1;
                        bArr2[i6] = (byte) (i9 >> 16);
                        int i11 = i10 + 1;
                        bArr2[i10] = (byte) (i9 >> 8);
                        i6 = i11 + 1;
                        bArr2[i11] = (byte) i9;
                        i4 = 0;
                        i5 = 18;
                    } else {
                        i4 = i9;
                    }
                } else if (i8 == -2) {
                    if (i5 == 6) {
                        if (i7 != i3) {
                            i2 = i7 + 1;
                        }
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    i2 = i7;
                } else if (!this.f31995f) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i7 - 1], 16));
                }
                i2 = i7;
            }
        }

        public byte[] a(String str) {
            return a(str.getBytes(c.f31989a));
        }

        public byte[] a(byte[] bArr) {
            int a2 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        public static final b f31998c;

        /* renamed from: f  reason: collision with root package name */
        public static final byte[] f32001f;

        /* renamed from: g  reason: collision with root package name */
        public final byte[] f32002g;

        /* renamed from: h  reason: collision with root package name */
        public final int f32003h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f32004i;
        public final boolean j;

        /* renamed from: a  reason: collision with root package name */
        public static final b f31996a = new b(false, null, -1, true);

        /* renamed from: b  reason: collision with root package name */
        public static final b f31997b = new b(true, null, -1, false);

        /* renamed from: d  reason: collision with root package name */
        public static final char[] f31999d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

        /* renamed from: e  reason: collision with root package name */
        public static final char[] f32000e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

        static {
            byte[] bArr = {13, 10};
            f32001f = bArr;
            f31998c = new b(false, bArr, 76, true);
        }

        public b(boolean z, byte[] bArr, int i2, boolean z2) {
            this.f32004i = z;
            this.f32002g = bArr;
            this.f32003h = i2;
            this.j = z2;
        }

        private final int a(int i2) {
            int i3;
            if (this.j) {
                i3 = ((i2 + 2) / 3) * 4;
            } else {
                int i4 = i2 % 3;
                i3 = ((i2 / 3) * 4) + (i4 == 0 ? 0 : i4 + 1);
            }
            int i5 = this.f32003h;
            return i5 > 0 ? i3 + (((i3 - 1) / i5) * this.f32002g.length) : i3;
        }

        private int a(byte[] bArr, int i2, int i3, byte[] bArr2) {
            char[] cArr = this.f32004i ? f32000e : f31999d;
            int i4 = ((i3 - i2) / 3) * 3;
            int i5 = i2 + i4;
            int i6 = this.f32003h;
            if (i6 > 0 && i4 > (i6 / 4) * 3) {
                i4 = (i6 / 4) * 3;
            }
            int i7 = 0;
            while (i2 < i5) {
                int min = Math.min(i2 + i4, i5);
                int i8 = i2;
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
                int i18 = ((min - i2) / 3) * 4;
                i7 += i18;
                if (i18 == this.f32003h && min < i3) {
                    byte[] bArr3 = this.f32002g;
                    int length = bArr3.length;
                    int i19 = 0;
                    while (i19 < length) {
                        bArr2[i7] = bArr3[i19];
                        i19++;
                        i7++;
                    }
                }
                i2 = min;
            }
            if (i2 < i3) {
                int i20 = i2 + 1;
                int i21 = bArr[i2] & 255;
                int i22 = i7 + 1;
                bArr2[i7] = (byte) cArr[i21 >> 2];
                if (i20 == i3) {
                    int i23 = i22 + 1;
                    bArr2[i22] = (byte) cArr[(i21 << 4) & 63];
                    if (this.j) {
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
                if (this.j) {
                    int i29 = i28 + 1;
                    bArr2[i28] = 61;
                    return i29;
                }
                return i28;
            }
            return i7;
        }

        public byte[] a(byte[] bArr) {
            int a2 = a(bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
        }
    }

    public static b a() {
        return b.f31996a;
    }

    public static a b() {
        return a.f31990a;
    }
}
