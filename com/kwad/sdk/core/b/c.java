package com.kwad.sdk.core.b;

import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f6009a = Charset.forName("ISO-8859-1");

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final a f6010a = new a(false, false);
        static final a b = new a(true, false);
        private static final int[] c = new int[256];
        private static final int[] d = new int[256];
        private final boolean e;
        private final boolean f;

        static {
            Arrays.fill(c, -1);
            for (int i = 0; i < b.d.length; i++) {
                c[b.d[i]] = i;
            }
            c[61] = -2;
            Arrays.fill(d, -1);
            for (int i2 = 0; i2 < b.e.length; i2++) {
                d[b.e[i2]] = i2;
            }
            d[61] = -2;
        }

        private a(boolean z, boolean z2) {
            this.e = z;
            this.f = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0067, code lost:
            if (r9[r11 - 2] != 61) goto L44;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i, int i2) {
            int i3 = 2;
            int[] iArr = this.e ? d : c;
            int i4 = i2 - i;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.f && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.f) {
                int i5 = 0;
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i6 = i + 1;
                    int i7 = bArr[i] & 255;
                    if (i7 == 61) {
                        i4 -= (i2 - i6) + 1;
                        break;
                    }
                    if (iArr[i7] == -1) {
                        i5++;
                    }
                    i = i6;
                }
                i4 -= i5;
                i3 = 0;
            } else {
                int i8 = bArr[i2 + (-1)] == 61 ? 1 : 0;
                i3 = i8;
            }
            if (i3 == 0 && (i4 & 3) != 0) {
                i3 = 4 - (i4 & 3);
            }
            return (((i4 + 3) / 4) * 3) - i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
            if (r11[r7] == 61) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3;
            int i4;
            int i5;
            int[] iArr = this.e ? d : c;
            int i6 = 18;
            int i7 = 0;
            int i8 = 0;
            int i9 = i;
            while (true) {
                if (i9 >= i2) {
                    i3 = i9;
                    break;
                }
                int i10 = i9 + 1;
                int i11 = iArr[bArr[i9] & 255];
                if (i11 >= 0) {
                    i7 |= i11 << i6;
                    int i12 = i6 - 6;
                    if (i12 < 0) {
                        int i13 = i8 + 1;
                        bArr2[i8] = (byte) (i7 >> 16);
                        int i14 = i13 + 1;
                        bArr2[i13] = (byte) (i7 >> 8);
                        i8 = i14 + 1;
                        bArr2[i14] = (byte) i7;
                        i12 = 18;
                        i7 = 0;
                    }
                    i6 = i12;
                    i9 = i10;
                } else if (i11 == -2) {
                    if (i6 == 6) {
                        if (i10 != i2) {
                            i5 = i10 + 1;
                        }
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    i5 = i10;
                    if (i6 != 18) {
                        i3 = i5;
                    }
                    throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                } else if (!this.f) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i10 - 1], 16));
                } else {
                    i9 = i10;
                }
            }
            if (i6 == 6) {
                bArr2[i8] = (byte) (i7 >> 16);
                i8++;
            } else if (i6 == 0) {
                int i15 = i8 + 1;
                bArr2[i8] = (byte) (i7 >> 16);
                i8 = i15 + 1;
                bArr2[i15] = (byte) (i7 >> 8);
            } else if (i6 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i3 < i2) {
                if (this.f) {
                    int i16 = i3 + 1;
                    if (iArr[bArr[i3]] < 0) {
                        i3 = i16;
                    } else {
                        i4 = i16;
                    }
                } else {
                    i4 = i3;
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i4);
            }
            return i8;
        }

        public byte[] a(String str) {
            return a(str.getBytes(c.f6009a));
        }

        public byte[] a(byte[] bArr) {
            byte[] bArr2 = new byte[a(bArr, 0, bArr.length)];
            int a2 = a(bArr, 0, bArr.length, bArr2);
            return a2 != bArr2.length ? Arrays.copyOf(bArr2, a2) : bArr2;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private final byte[] g;
        private final int h;
        private final boolean i;
        private final boolean j;

        /* renamed from: a  reason: collision with root package name */
        static final b f6011a = new b(false, null, -1, true);
        static final b b = new b(true, null, -1, false);
        private static final char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private static final byte[] f = {13, 10};
        static final b c = new b(false, f, 76, true);

        private b(boolean z, byte[] bArr, int i, boolean z2) {
            this.i = z;
            this.g = bArr;
            this.h = i;
            this.j = z2;
        }

        private final int a(int i) {
            int i2;
            if (this.j) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = (i3 == 0 ? 0 : i3 + 1) + ((i / 3) * 4);
            }
            return this.h > 0 ? i2 + (((i2 - 1) / this.h) * this.g.length) : i2;
        }

        private int a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3;
            char[] cArr = this.i ? e : d;
            int i4 = ((i2 - i) / 3) * 3;
            int i5 = i + i4;
            if (this.h > 0 && i4 > (this.h / 4) * 3) {
                i4 = (this.h / 4) * 3;
            }
            int i6 = 0;
            int i7 = i;
            while (i7 < i5) {
                int min = Math.min(i7 + i4, i5);
                int i8 = i6;
                int i9 = i7;
                while (i9 < min) {
                    int i10 = i9 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((bArr[i10] & 255) << 8) | ((bArr[i9] & 255) << 16);
                    i9 = i11 + 1;
                    int i13 = i12 | (bArr[i11] & 255);
                    int i14 = i8 + 1;
                    bArr2[i8] = (byte) cArr[(i13 >>> 18) & 63];
                    int i15 = i14 + 1;
                    bArr2[i14] = (byte) cArr[(i13 >>> 12) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i13 >>> 6) & 63];
                    i8 = i16 + 1;
                    bArr2[i16] = (byte) cArr[i13 & 63];
                }
                int i17 = ((min - i7) / 3) * 4;
                i6 += i17;
                if (i17 == this.h && min < i2) {
                    byte[] bArr3 = this.g;
                    int length = bArr3.length;
                    int i18 = 0;
                    while (i18 < length) {
                        bArr2[i6] = bArr3[i18];
                        i18++;
                        i6++;
                    }
                }
                i7 = min;
            }
            if (i7 < i2) {
                int i19 = i7 + 1;
                int i20 = bArr[i7] & 255;
                int i21 = i6 + 1;
                bArr2[i6] = (byte) cArr[i20 >> 2];
                if (i19 == i2) {
                    i3 = i21 + 1;
                    bArr2[i21] = (byte) cArr[(i20 << 4) & 63];
                    if (this.j) {
                        int i22 = i3 + 1;
                        bArr2[i3] = 61;
                        int i23 = i22 + 1;
                        bArr2[i22] = 61;
                        return i23;
                    }
                } else {
                    int i24 = i19 + 1;
                    int i25 = bArr[i19] & 255;
                    int i26 = i21 + 1;
                    bArr2[i21] = (byte) cArr[((i20 << 4) & 63) | (i25 >> 4)];
                    i3 = i26 + 1;
                    bArr2[i26] = (byte) cArr[(i25 << 2) & 63];
                    if (this.j) {
                        int i27 = i3 + 1;
                        bArr2[i3] = 61;
                        return i27;
                    }
                }
                return i3;
            }
            return i6;
        }

        public byte[] a(byte[] bArr) {
            byte[] bArr2 = new byte[a(bArr.length)];
            int a2 = a(bArr, 0, bArr.length, bArr2);
            return a2 != bArr2.length ? Arrays.copyOf(bArr2, a2) : bArr2;
        }
    }

    public static b a() {
        return b.f6011a;
    }

    public static a b() {
        return a.f6010a;
    }
}
