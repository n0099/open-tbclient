package com.kwad.sdk.core.b;

import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f33418a = Charset.forName("ISO-8859-1");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f33421c;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f33423e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f33424f;

        /* renamed from: a  reason: collision with root package name */
        public static final a f33419a = new a(false, false);

        /* renamed from: b  reason: collision with root package name */
        public static final a f33420b = new a(true, false);

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f33422d = new int[256];

        static {
            int[] iArr = new int[256];
            f33421c = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < b.f33428d.length; i++) {
                f33421c[b.f33428d[i]] = i;
            }
            f33421c[61] = -2;
            Arrays.fill(f33422d, -1);
            for (int i2 = 0; i2 < b.f33429e.length; i2++) {
                f33422d[b.f33429e[i2]] = i2;
            }
            f33422d[61] = -2;
        }

        public a(boolean z, boolean z2) {
            this.f33423e = z;
            this.f33424f = z2;
        }

        private int a(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.f33423e ? f33422d : f33421c;
            int i4 = i2 - i;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.f33424f && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.f33424f) {
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
            if (r10.f33424f == false) goto L38;
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
        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int[] iArr = this.f33423e ? f33422d : f33421c;
            int i3 = 0;
            int i4 = 18;
            int i5 = 0;
            while (true) {
                if (i >= i2) {
                    break;
                }
                int i6 = i + 1;
                int i7 = iArr[bArr[i] & 255];
                if (i7 >= 0) {
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
                } else if (i7 == -2) {
                    if (i4 == 6) {
                        if (i6 != i2) {
                            i = i6 + 1;
                        }
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    i = i6;
                } else if (!this.f33424f) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i6 - 1], 16));
                }
                i = i6;
            }
        }

        public byte[] a(String str) {
            return a(str.getBytes(c.f33418a));
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
        public static final b f33427c;

        /* renamed from: f  reason: collision with root package name */
        public static final byte[] f33430f;

        /* renamed from: g  reason: collision with root package name */
        public final byte[] f33431g;

        /* renamed from: h  reason: collision with root package name */
        public final int f33432h;
        public final boolean i;
        public final boolean j;

        /* renamed from: a  reason: collision with root package name */
        public static final b f33425a = new b(false, null, -1, true);

        /* renamed from: b  reason: collision with root package name */
        public static final b f33426b = new b(true, null, -1, false);

        /* renamed from: d  reason: collision with root package name */
        public static final char[] f33428d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

        /* renamed from: e  reason: collision with root package name */
        public static final char[] f33429e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

        static {
            byte[] bArr = {13, 10};
            f33430f = bArr;
            f33427c = new b(false, bArr, 76, true);
        }

        public b(boolean z, byte[] bArr, int i, boolean z2) {
            this.i = z;
            this.f33431g = bArr;
            this.f33432h = i;
            this.j = z2;
        }

        private final int a(int i) {
            int i2;
            if (this.j) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.f33432h;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.f33431g.length) : i2;
        }

        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.i ? f33429e : f33428d;
            int i3 = ((i2 - i) / 3) * 3;
            int i4 = i + i3;
            int i5 = this.f33432h;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = 0;
            while (i < i4) {
                int min = Math.min(i + i3, i4);
                int i7 = i;
                int i8 = i6;
                while (i7 < min) {
                    int i9 = i7 + 1;
                    int i10 = i9 + 1;
                    int i11 = ((bArr[i7] & 255) << 16) | ((bArr[i9] & 255) << 8);
                    int i12 = i10 + 1;
                    int i13 = i11 | (bArr[i10] & 255);
                    int i14 = i8 + 1;
                    bArr2[i8] = (byte) cArr[(i13 >>> 18) & 63];
                    int i15 = i14 + 1;
                    bArr2[i14] = (byte) cArr[(i13 >>> 12) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i13 >>> 6) & 63];
                    i8 = i16 + 1;
                    bArr2[i16] = (byte) cArr[i13 & 63];
                    i7 = i12;
                }
                int i17 = ((min - i) / 3) * 4;
                i6 += i17;
                if (i17 == this.f33432h && min < i2) {
                    byte[] bArr3 = this.f33431g;
                    int length = bArr3.length;
                    int i18 = 0;
                    while (i18 < length) {
                        bArr2[i6] = bArr3[i18];
                        i18++;
                        i6++;
                    }
                }
                i = min;
            }
            if (i < i2) {
                int i19 = i + 1;
                int i20 = bArr[i] & 255;
                int i21 = i6 + 1;
                bArr2[i6] = (byte) cArr[i20 >> 2];
                if (i19 == i2) {
                    int i22 = i21 + 1;
                    bArr2[i21] = (byte) cArr[(i20 << 4) & 63];
                    if (this.j) {
                        int i23 = i22 + 1;
                        bArr2[i22] = 61;
                        int i24 = i23 + 1;
                        bArr2[i23] = 61;
                        return i24;
                    }
                    return i22;
                }
                int i25 = bArr[i19] & 255;
                int i26 = i21 + 1;
                bArr2[i21] = (byte) cArr[((i20 << 4) & 63) | (i25 >> 4)];
                int i27 = i26 + 1;
                bArr2[i26] = (byte) cArr[(i25 << 2) & 63];
                if (this.j) {
                    int i28 = i27 + 1;
                    bArr2[i27] = 61;
                    return i28;
                }
                return i27;
            }
            return i6;
        }

        public byte[] a(byte[] bArr) {
            int a2 = a(bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
        }
    }

    public static b a() {
        return b.f33425a;
    }

    public static a b() {
        return a.f33419a;
    }
}
