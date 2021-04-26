package d.a.j.d.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: g  reason: collision with root package name */
    public static int[] f50269g;

    /* renamed from: h  reason: collision with root package name */
    public static int[] f50270h;

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f50271i = new byte[256];
    public static final byte[] j = new byte[256];
    public static final int[] k = new int[256];
    public static final int[] l = new int[256];
    public static final int[] m = new int[256];
    public static final int[] n = new int[256];
    public static final int[] o = new int[256];
    public static final int[] p = new int[256];
    public static final int[] q = new int[256];
    public static final int[] r = new int[256];
    public static final int[] s = new int[256];
    public static final int[] t = new int[256];
    public static final int[] u = new int[256];
    public static final int[] v = new int[256];
    public static final byte[] w = new byte[30];

    /* renamed from: b  reason: collision with root package name */
    public boolean f50272b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50273c = false;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f50274d = null;

    /* renamed from: e  reason: collision with root package name */
    public int[] f50275e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f50276f = 0;

    static {
        int[] iArr = new int[256];
        f50269g = iArr;
        f50270h = new int[256];
        iArr[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int[] iArr2 = f50269g;
            int i3 = i2 - 1;
            int i4 = iArr2[i3] ^ (iArr2[i3] << 1);
            if ((i4 & 256) != 0) {
                i4 ^= 283;
            }
            f50269g[i2] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            f50270h[f50269g[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = f50269g[255 - f50270h[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, 256, 8);
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            f50271i[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = f50271i;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            j[f50271i[i12] & 255] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance(byte.class, 4, 8);
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(byte.class, 4, 4);
        for (int i16 = 0; i16 < 4; i16++) {
            byte b2 = bArr8[i16][i16];
            if (b2 == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte b3 = bArr8[i16][i18];
                    bArr8[i16][i18] = bArr8[i17][i18];
                    bArr8[i17][i18] = b3;
                }
                b2 = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                if (bArr8[i16][i19] != 0) {
                    byte[] bArr10 = bArr8[i16];
                    int[] iArr3 = f50269g;
                    int[] iArr4 = f50270h;
                    bArr10[i19] = (byte) iArr3[((iArr4[bArr8[i16][i19] & 255] + 255) - iArr4[b2 & 255]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr11 = bArr8[i20];
                        bArr11[i21] = (byte) (bArr11[i21] ^ b(bArr8[i16][i21], bArr8[i20][i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b4 = f50271i[i24];
            k[i24] = c(b4, bArr7[0]);
            l[i24] = c(b4, bArr7[1]);
            m[i24] = c(b4, bArr7[2]);
            n[i24] = c(b4, bArr7[3]);
            byte b5 = j[i24];
            o[i24] = c(b5, bArr9[0]);
            p[i24] = c(b5, bArr9[1]);
            q[i24] = c(b5, bArr9[2]);
            r[i24] = c(b5, bArr9[3]);
            s[i24] = c(i24, bArr9[0]);
            t[i24] = c(i24, bArr9[1]);
            u[i24] = c(i24, bArr9[2]);
            v[i24] = c(i24, bArr9[3]);
        }
        int i25 = 1;
        w[0] = 1;
        for (int i26 = 1; i26 < 30; i26++) {
            i25 = b(2, i25);
            w[i26] = (byte) i25;
        }
        f50270h = null;
        f50269g = null;
    }

    public static final int b(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = f50269g;
        int[] iArr2 = f50270h;
        return iArr[(iArr2[i2 & 255] + iArr2[i3 & 255]) % 255];
    }

    public static final int c(int i2, byte[] bArr) {
        if (i2 == 0) {
            return 0;
        }
        int[] iArr = f50270h;
        int i3 = iArr[i2 & 255];
        return ((bArr[0] != 0 ? f50269g[(iArr[bArr[0] & 255] + i3) % 255] & 255 : 0) << 24) | ((bArr[1] != 0 ? f50269g[(f50270h[bArr[1] & 255] + i3) % 255] & 255 : 0) << 16) | ((bArr[2] != 0 ? f50269g[(f50270h[bArr[2] & 255] + i3) % 255] & 255 : 0) << 8) | (bArr[3] != 0 ? f50269g[(i3 + f50270h[bArr[3] & 255]) % 255] & 255 : 0);
    }

    public static final boolean g(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = a.f50268a;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i2 == iArr[i3]) {
                return true;
            }
            i3++;
        }
    }

    public static Object[] h(byte[] bArr) {
        int i2;
        if (bArr != null) {
            if (!g(bArr.length)) {
                throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
            }
            int i3 = i(bArr.length);
            int i4 = i3 + 1;
            int i5 = i4 * 4;
            char c2 = 0;
            int[][] iArr = (int[][]) Array.newInstance(int.class, i4, 4);
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, i4, 4);
            int length = bArr.length / 4;
            int[] iArr3 = new int[length];
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                iArr3[i6] = ((bArr[i7 + 2] & 255) << 8) | (bArr[i7] << 24) | ((bArr[i7 + 1] & 255) << 16) | (bArr[i7 + 3] & 255);
                i6++;
                i7 += 4;
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < length && i9 < i5) {
                int i10 = i9 / 4;
                int i11 = i9 % 4;
                iArr[i10][i11] = iArr3[i8];
                iArr2[i3 - i10][i11] = iArr3[i8];
                i8++;
                i9++;
            }
            int i12 = 0;
            while (i9 < i5) {
                int i13 = iArr3[length - 1];
                int i14 = iArr3[c2];
                byte[] bArr2 = f50271i;
                int i15 = (((bArr2[(i13 >>> 16) & 255] << 24) ^ ((bArr2[(i13 >>> 8) & 255] & 255) << 16)) ^ ((bArr2[i13 & 255] & 255) << 8)) ^ (bArr2[i13 >>> 24] & 255);
                int i16 = i12 + 1;
                iArr3[c2] = ((w[i12] << 24) ^ i15) ^ i14;
                int i17 = 1;
                int i18 = 0;
                if (length != 8) {
                    while (i17 < length) {
                        iArr3[i17] = iArr3[i17] ^ iArr3[i18];
                        i17++;
                        i18++;
                    }
                } else {
                    while (true) {
                        i2 = length / 2;
                        if (i17 >= i2) {
                            break;
                        }
                        iArr3[i17] = iArr3[i17] ^ iArr3[i18];
                        i17++;
                        i18++;
                    }
                    int i19 = iArr3[i2 - 1];
                    int i20 = iArr3[i2];
                    byte[] bArr3 = f50271i;
                    iArr3[i2] = ((bArr3[i19 >>> 24] << 24) ^ ((((bArr3[(i19 >>> 8) & 255] & 255) << 8) ^ (bArr3[i19 & 255] & 255)) ^ ((bArr3[(i19 >>> 16) & 255] & 255) << 16))) ^ i20;
                    int i21 = i2 + 1;
                    while (i21 < length) {
                        iArr3[i21] = iArr3[i21] ^ iArr3[i2];
                        i21++;
                        i2++;
                    }
                }
                int i22 = 0;
                while (i22 < length && i9 < i5) {
                    int i23 = i9 / 4;
                    int i24 = i9 % 4;
                    iArr[i23][i24] = iArr3[i22];
                    iArr2[i3 - i23][i24] = iArr3[i22];
                    i22++;
                    i9++;
                }
                i12 = i16;
                c2 = 0;
            }
            for (int i25 = 1; i25 < i3; i25++) {
                for (int i26 = 0; i26 < 4; i26++) {
                    int i27 = iArr2[i25][i26];
                    iArr2[i25][i26] = v[i27 & 255] ^ ((s[(i27 >>> 24) & 255] ^ t[(i27 >>> 16) & 255]) ^ u[(i27 >>> 8) & 255]);
                }
            }
            return new Object[]{iArr, iArr2};
        }
        throw new InvalidKeyException("Empty key");
    }

    public static int i(int i2) {
        return (i2 >> 2) + 6;
    }

    public int a() {
        return 16;
    }

    public final void d(boolean z) {
        int[][] iArr = (int[][]) this.f50274d[z ? 1 : 0];
        int length = iArr.length;
        this.f50275e = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.f50275e[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int[] iArr2 = this.f50275e;
            int i4 = iArr2[iArr2.length - 4];
            int i5 = iArr2[iArr2.length - 3];
            int i6 = iArr2[iArr2.length - 2];
            int i7 = iArr2[iArr2.length - 1];
            for (int length2 = iArr2.length - 1; length2 > 3; length2--) {
                int[] iArr3 = this.f50275e;
                iArr3[length2] = iArr3[length2 - 4];
            }
            int[] iArr4 = this.f50275e;
            iArr4[0] = i4;
            iArr4[1] = i5;
            iArr4[2] = i6;
            iArr4[3] = i7;
        }
        this.f50272b = length >= 13;
        this.f50273c = length == 15;
        this.f50276f = (length - 1) * 4;
    }

    public void e(boolean z, String str, byte[] bArr) {
        if (g(bArr.length)) {
            this.f50274d = h(bArr);
            d(z);
            return;
        }
        throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
    }

    public void f(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = ((bArr[i4] & 255) << 16) | (bArr[i2] << 24) | ((bArr[i5] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        int[] iArr = this.f50275e;
        int i10 = i9 ^ iArr[0];
        int i11 = i8 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i8] << 24) | ((bArr[i11] & 255) << 16);
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        int i16 = i14 + 1;
        int i17 = (i15 | (bArr[i14] & 255)) ^ iArr[1];
        int i18 = i16 + 1;
        int i19 = i18 + 1;
        int i20 = ((bArr[i18] & 255) << 16) | (bArr[i16] << 24);
        int i21 = i19 + 1;
        int i22 = i20 | ((bArr[i19] & 255) << 8);
        int i23 = i21 + 1;
        int i24 = (i22 | (bArr[i21] & 255)) ^ iArr[2];
        int i25 = i23 + 1;
        int i26 = i25 + 1;
        int i27 = iArr[3];
        int i28 = i27 ^ (((((bArr[i25] & 255) << 16) | (bArr[i23] << 24)) | ((bArr[i26] & 255) << 8)) | (bArr[i26 + 1] & 255));
        int i29 = 4;
        while (i29 < this.f50276f) {
            int[] iArr2 = k;
            int i30 = iArr2[i10 >>> 24];
            int[] iArr3 = l;
            int i31 = i30 ^ iArr3[(i17 >>> 16) & 255];
            int[] iArr4 = m;
            int i32 = i31 ^ iArr4[(i24 >>> 8) & 255];
            int[] iArr5 = n;
            int i33 = i32 ^ iArr5[i28 & 255];
            int[] iArr6 = this.f50275e;
            int i34 = i29 + 1;
            int i35 = iArr6[i29] ^ i33;
            int i36 = i34 + 1;
            int i37 = (((iArr2[i17 >>> 24] ^ iArr3[(i24 >>> 16) & 255]) ^ iArr4[(i28 >>> 8) & 255]) ^ iArr5[i10 & 255]) ^ iArr6[i34];
            int i38 = ((iArr2[i24 >>> 24] ^ iArr3[(i28 >>> 16) & 255]) ^ iArr4[(i10 >>> 8) & 255]) ^ iArr5[i17 & 255];
            int i39 = i36 + 1;
            int i40 = (((iArr3[(i10 >>> 16) & 255] ^ iArr2[i28 >>> 24]) ^ iArr4[(i17 >>> 8) & 255]) ^ iArr5[i24 & 255]) ^ iArr6[i39];
            i17 = i37;
            i24 = i38 ^ iArr6[i36];
            i28 = i40;
            i10 = i35;
            i29 = i39 + 1;
        }
        int[] iArr7 = this.f50275e;
        int i41 = i29 + 1;
        int i42 = iArr7[i29];
        int i43 = i3 + 1;
        byte[] bArr3 = f50271i;
        bArr2[i3] = (byte) (bArr3[i10 >>> 24] ^ (i42 >>> 24));
        int i44 = i43 + 1;
        bArr2[i43] = (byte) (bArr3[(i17 >>> 16) & 255] ^ (i42 >>> 16));
        int i45 = i44 + 1;
        bArr2[i44] = (byte) (bArr3[(i24 >>> 8) & 255] ^ (i42 >>> 8));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (i42 ^ bArr3[i28 & 255]);
        int i47 = i41 + 1;
        int i48 = iArr7[i41];
        int i49 = i46 + 1;
        bArr2[i46] = (byte) (bArr3[i17 >>> 24] ^ (i48 >>> 24));
        int i50 = i49 + 1;
        bArr2[i49] = (byte) (bArr3[(i24 >>> 16) & 255] ^ (i48 >>> 16));
        int i51 = i50 + 1;
        bArr2[i50] = (byte) (bArr3[(i28 >>> 8) & 255] ^ (i48 >>> 8));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (i48 ^ bArr3[i10 & 255]);
        int i53 = i47 + 1;
        int i54 = iArr7[i47];
        int i55 = i52 + 1;
        bArr2[i52] = (byte) (bArr3[i24 >>> 24] ^ (i54 >>> 24));
        int i56 = i55 + 1;
        bArr2[i55] = (byte) (bArr3[(i28 >>> 16) & 255] ^ (i54 >>> 16));
        int i57 = i56 + 1;
        bArr2[i56] = (byte) (bArr3[(i10 >>> 8) & 255] ^ (i54 >>> 8));
        int i58 = i57 + 1;
        bArr2[i57] = (byte) (i54 ^ bArr3[i17 & 255]);
        int i59 = iArr7[i53];
        int i60 = i58 + 1;
        bArr2[i58] = (byte) (bArr3[i28 >>> 24] ^ (i59 >>> 24));
        int i61 = i60 + 1;
        bArr2[i60] = (byte) (bArr3[(i10 >>> 16) & 255] ^ (i59 >>> 16));
        bArr2[i61] = (byte) (bArr3[(i17 >>> 8) & 255] ^ (i59 >>> 8));
        bArr2[i61 + 1] = (byte) (bArr3[i24 & 255] ^ i59);
    }

    public void j(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2 + 1;
        int i10 = i9 + 1;
        int i11 = i10 + 1;
        int i12 = ((bArr[i9] & 255) << 16) | (bArr[i2] << 24) | ((bArr[i10] & 255) << 8);
        int i13 = i11 + 1;
        int i14 = i12 | (bArr[i11] & 255);
        int[] iArr = this.f50275e;
        int i15 = i14 ^ iArr[4];
        int i16 = i13 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i13] << 24) | ((bArr[i16] & 255) << 16);
        int i19 = i17 + 1;
        int i20 = i18 | ((bArr[i17] & 255) << 8);
        int i21 = i19 + 1;
        int i22 = (i20 | (bArr[i19] & 255)) ^ iArr[5];
        int i23 = i21 + 1;
        int i24 = i23 + 1;
        int i25 = ((bArr[i23] & 255) << 16) | (bArr[i21] << 24);
        int i26 = i24 + 1;
        int i27 = i25 | ((bArr[i24] & 255) << 8);
        int i28 = i26 + 1;
        int i29 = (i27 | (bArr[i26] & 255)) ^ iArr[6];
        int i30 = i28 + 1;
        int i31 = i30 + 1;
        int i32 = (((((bArr[i30] & 255) << 16) | (bArr[i28] << 24)) | ((bArr[i31] & 255) << 8)) | (bArr[i31 + 1] & 255)) ^ iArr[7];
        if (this.f50272b) {
            int[] iArr2 = o;
            int i33 = iArr2[i15 >>> 24];
            int[] iArr3 = p;
            int i34 = i33 ^ iArr3[(i32 >>> 16) & 255];
            int[] iArr4 = q;
            int i35 = i34 ^ iArr4[(i29 >>> 8) & 255];
            int[] iArr5 = r;
            int i36 = (i35 ^ iArr5[i22 & 255]) ^ iArr[8];
            int i37 = (((iArr3[(i15 >>> 16) & 255] ^ iArr2[i22 >>> 24]) ^ iArr4[(i32 >>> 8) & 255]) ^ iArr5[i29 & 255]) ^ iArr[9];
            int i38 = (((iArr3[(i22 >>> 16) & 255] ^ iArr2[i29 >>> 24]) ^ iArr4[(i15 >>> 8) & 255]) ^ iArr5[i32 & 255]) ^ iArr[10];
            int i39 = iArr2[i32 >>> 24];
            int i40 = iArr4[(i22 >>> 8) & 255];
            int i41 = (iArr5[i15 & 255] ^ (i40 ^ (iArr3[(i29 >>> 16) & 255] ^ i39))) ^ iArr[11];
            i7 = iArr[12] ^ (((iArr2[i36 >>> 24] ^ iArr3[(i41 >>> 16) & 255]) ^ iArr4[(i38 >>> 8) & 255]) ^ iArr5[i37 & 255]);
            i6 = (((iArr2[i37 >>> 24] ^ iArr3[(i36 >>> 16) & 255]) ^ iArr4[(i41 >>> 8) & 255]) ^ iArr5[i38 & 255]) ^ iArr[13];
            i5 = (((iArr2[i38 >>> 24] ^ iArr3[(i37 >>> 16) & 255]) ^ iArr4[(i36 >>> 8) & 255]) ^ iArr5[i41 & 255]) ^ iArr[14];
            int i42 = (((iArr2[i41 >>> 24] ^ iArr3[(i38 >>> 16) & 255]) ^ iArr4[(i37 >>> 8) & 255]) ^ iArr5[i36 & 255]) ^ iArr[15];
            if (this.f50273c) {
                int i43 = (((iArr2[i7 >>> 24] ^ iArr3[(i42 >>> 16) & 255]) ^ iArr4[(i5 >>> 8) & 255]) ^ iArr5[i6 & 255]) ^ iArr[16];
                int i44 = iArr[17] ^ (((iArr2[i6 >>> 24] ^ iArr3[(i7 >>> 16) & 255]) ^ iArr4[(i42 >>> 8) & 255]) ^ iArr5[i5 & 255]);
                int i45 = (((iArr2[i5 >>> 24] ^ iArr3[(i6 >>> 16) & 255]) ^ iArr4[(i7 >>> 8) & 255]) ^ iArr5[i42 & 255]) ^ iArr[18];
                int i46 = (((iArr2[i42 >>> 24] ^ iArr3[(i5 >>> 16) & 255]) ^ iArr4[(i6 >>> 8) & 255]) ^ iArr5[i7 & 255]) ^ iArr[19];
                i7 = iArr[20] ^ (((iArr2[i43 >>> 24] ^ iArr3[(i46 >>> 16) & 255]) ^ iArr4[(i45 >>> 8) & 255]) ^ iArr5[i44 & 255]);
                i6 = (((iArr2[i44 >>> 24] ^ iArr3[(i43 >>> 16) & 255]) ^ iArr4[(i46 >>> 8) & 255]) ^ iArr5[i45 & 255]) ^ iArr[21];
                i5 = (((iArr2[i45 >>> 24] ^ iArr3[(i44 >>> 16) & 255]) ^ iArr4[(i43 >>> 8) & 255]) ^ iArr5[i46 & 255]) ^ iArr[22];
                i4 = (((iArr2[i46 >>> 24] ^ iArr3[(i45 >>> 16) & 255]) ^ iArr4[(i44 >>> 8) & 255]) ^ iArr5[i43 & 255]) ^ iArr[23];
                i8 = 24;
            } else {
                i4 = i42;
                i8 = 16;
            }
        } else {
            i4 = i32;
            i5 = i29;
            i6 = i22;
            i7 = i15;
            i8 = 8;
        }
        int[] iArr6 = o;
        int i47 = iArr6[i7 >>> 24];
        int[] iArr7 = p;
        int i48 = i47 ^ iArr7[(i4 >>> 16) & 255];
        int[] iArr8 = q;
        int i49 = i48 ^ iArr8[(i5 >>> 8) & 255];
        int[] iArr9 = r;
        int i50 = i49 ^ iArr9[i6 & 255];
        int[] iArr10 = this.f50275e;
        int i51 = i8 + 1;
        int i52 = iArr10[i8] ^ i50;
        int i53 = i51 + 1;
        int i54 = (((iArr6[i6 >>> 24] ^ iArr7[(i7 >>> 16) & 255]) ^ iArr8[(i4 >>> 8) & 255]) ^ iArr9[i5 & 255]) ^ iArr10[i51];
        int i55 = i53 + 1;
        int i56 = (((iArr6[i5 >>> 24] ^ iArr7[(i6 >>> 16) & 255]) ^ iArr8[(i7 >>> 8) & 255]) ^ iArr9[i4 & 255]) ^ iArr10[i53];
        int i57 = ((iArr6[i4 >>> 24] ^ iArr7[(i5 >>> 16) & 255]) ^ iArr8[(i6 >>> 8) & 255]) ^ iArr9[i7 & 255];
        int i58 = i55 + 1;
        int i59 = i57 ^ iArr10[i55];
        int i60 = i58 + 1;
        int i61 = iArr10[i58] ^ (((iArr6[i52 >>> 24] ^ iArr7[(i59 >>> 16) & 255]) ^ iArr8[(i56 >>> 8) & 255]) ^ iArr9[i54 & 255]);
        int i62 = i60 + 1;
        int i63 = (((iArr6[i54 >>> 24] ^ iArr7[(i52 >>> 16) & 255]) ^ iArr8[(i59 >>> 8) & 255]) ^ iArr9[i56 & 255]) ^ iArr10[i60];
        int i64 = i62 + 1;
        int i65 = (((iArr6[i56 >>> 24] ^ iArr7[(i54 >>> 16) & 255]) ^ iArr8[(i52 >>> 8) & 255]) ^ iArr9[i59 & 255]) ^ iArr10[i62];
        int i66 = iArr9[i52 & 255] ^ ((iArr6[i59 >>> 24] ^ iArr7[(i56 >>> 16) & 255]) ^ iArr8[(i54 >>> 8) & 255]);
        int i67 = i64 + 1;
        int i68 = i66 ^ iArr10[i64];
        int i69 = i67 + 1;
        int i70 = iArr10[i67] ^ (((iArr6[i61 >>> 24] ^ iArr7[(i68 >>> 16) & 255]) ^ iArr8[(i65 >>> 8) & 255]) ^ iArr9[i63 & 255]);
        int i71 = i69 + 1;
        int i72 = (((iArr6[i63 >>> 24] ^ iArr7[(i61 >>> 16) & 255]) ^ iArr8[(i68 >>> 8) & 255]) ^ iArr9[i65 & 255]) ^ iArr10[i69];
        int i73 = i71 + 1;
        int i74 = (((iArr6[i65 >>> 24] ^ iArr7[(i63 >>> 16) & 255]) ^ iArr8[(i61 >>> 8) & 255]) ^ iArr9[i68 & 255]) ^ iArr10[i71];
        int i75 = ((iArr6[i68 >>> 24] ^ iArr7[(i65 >>> 16) & 255]) ^ iArr8[(i63 >>> 8) & 255]) ^ iArr9[i61 & 255];
        int i76 = i73 + 1;
        int i77 = i75 ^ iArr10[i73];
        int i78 = i76 + 1;
        int i79 = iArr10[i76] ^ (((iArr6[i70 >>> 24] ^ iArr7[(i77 >>> 16) & 255]) ^ iArr8[(i74 >>> 8) & 255]) ^ iArr9[i72 & 255]);
        int i80 = i78 + 1;
        int i81 = (((iArr6[i72 >>> 24] ^ iArr7[(i70 >>> 16) & 255]) ^ iArr8[(i77 >>> 8) & 255]) ^ iArr9[i74 & 255]) ^ iArr10[i78];
        int i82 = i80 + 1;
        int i83 = (((iArr6[i74 >>> 24] ^ iArr7[(i72 >>> 16) & 255]) ^ iArr8[(i70 >>> 8) & 255]) ^ iArr9[i77 & 255]) ^ iArr10[i80];
        int i84 = ((iArr6[i77 >>> 24] ^ iArr7[(i74 >>> 16) & 255]) ^ iArr8[(i72 >>> 8) & 255]) ^ iArr9[i70 & 255];
        int i85 = i82 + 1;
        int i86 = i84 ^ iArr10[i82];
        int i87 = i85 + 1;
        int i88 = iArr10[i85] ^ (((iArr6[i79 >>> 24] ^ iArr7[(i86 >>> 16) & 255]) ^ iArr8[(i83 >>> 8) & 255]) ^ iArr9[i81 & 255]);
        int i89 = i87 + 1;
        int i90 = (((iArr6[i81 >>> 24] ^ iArr7[(i79 >>> 16) & 255]) ^ iArr8[(i86 >>> 8) & 255]) ^ iArr9[i83 & 255]) ^ iArr10[i87];
        int i91 = i89 + 1;
        int i92 = (((iArr6[i83 >>> 24] ^ iArr7[(i81 >>> 16) & 255]) ^ iArr8[(i79 >>> 8) & 255]) ^ iArr9[i86 & 255]) ^ iArr10[i89];
        int i93 = ((iArr6[i86 >>> 24] ^ iArr7[(i83 >>> 16) & 255]) ^ iArr8[(i81 >>> 8) & 255]) ^ iArr9[i79 & 255];
        int i94 = i91 + 1;
        int i95 = i93 ^ iArr10[i91];
        int i96 = i94 + 1;
        int i97 = iArr10[i94] ^ (((iArr6[i88 >>> 24] ^ iArr7[(i95 >>> 16) & 255]) ^ iArr8[(i92 >>> 8) & 255]) ^ iArr9[i90 & 255]);
        int i98 = i96 + 1;
        int i99 = (((iArr6[i90 >>> 24] ^ iArr7[(i88 >>> 16) & 255]) ^ iArr8[(i95 >>> 8) & 255]) ^ iArr9[i92 & 255]) ^ iArr10[i96];
        int i100 = i98 + 1;
        int i101 = (((iArr6[i92 >>> 24] ^ iArr7[(i90 >>> 16) & 255]) ^ iArr8[(i88 >>> 8) & 255]) ^ iArr9[i95 & 255]) ^ iArr10[i98];
        int i102 = ((iArr6[i95 >>> 24] ^ iArr7[(i92 >>> 16) & 255]) ^ iArr8[(i90 >>> 8) & 255]) ^ iArr9[i88 & 255];
        int i103 = i100 + 1;
        int i104 = i102 ^ iArr10[i100];
        int i105 = i103 + 1;
        int i106 = iArr10[i103] ^ (((iArr6[i97 >>> 24] ^ iArr7[(i104 >>> 16) & 255]) ^ iArr8[(i101 >>> 8) & 255]) ^ iArr9[i99 & 255]);
        int i107 = i105 + 1;
        int i108 = (((iArr6[i99 >>> 24] ^ iArr7[(i97 >>> 16) & 255]) ^ iArr8[(i104 >>> 8) & 255]) ^ iArr9[i101 & 255]) ^ iArr10[i105];
        int i109 = i107 + 1;
        int i110 = (((iArr6[i101 >>> 24] ^ iArr7[(i99 >>> 16) & 255]) ^ iArr8[(i97 >>> 8) & 255]) ^ iArr9[i104 & 255]) ^ iArr10[i107];
        int i111 = ((iArr6[i104 >>> 24] ^ iArr7[(i101 >>> 16) & 255]) ^ iArr8[(i99 >>> 8) & 255]) ^ iArr9[i97 & 255];
        int i112 = i109 + 1;
        int i113 = i111 ^ iArr10[i109];
        int i114 = i112 + 1;
        int i115 = iArr10[i112] ^ (((iArr6[i106 >>> 24] ^ iArr7[(i113 >>> 16) & 255]) ^ iArr8[(i110 >>> 8) & 255]) ^ iArr9[i108 & 255]);
        int i116 = i114 + 1;
        int i117 = (((iArr6[i108 >>> 24] ^ iArr7[(i106 >>> 16) & 255]) ^ iArr8[(i113 >>> 8) & 255]) ^ iArr9[i110 & 255]) ^ iArr10[i114];
        int i118 = i116 + 1;
        int i119 = (((iArr6[i110 >>> 24] ^ iArr7[(i108 >>> 16) & 255]) ^ iArr8[(i106 >>> 8) & 255]) ^ iArr9[i113 & 255]) ^ iArr10[i116];
        int i120 = ((iArr6[i113 >>> 24] ^ iArr7[(i110 >>> 16) & 255]) ^ iArr8[(i108 >>> 8) & 255]) ^ iArr9[i106 & 255];
        int i121 = i118 + 1;
        int i122 = i120 ^ iArr10[i118];
        int i123 = i121 + 1;
        int i124 = iArr10[i121] ^ (((iArr6[i115 >>> 24] ^ iArr7[(i122 >>> 16) & 255]) ^ iArr8[(i119 >>> 8) & 255]) ^ iArr9[i117 & 255]);
        int i125 = i123 + 1;
        int i126 = (((iArr6[i117 >>> 24] ^ iArr7[(i115 >>> 16) & 255]) ^ iArr8[(i122 >>> 8) & 255]) ^ iArr9[i119 & 255]) ^ iArr10[i123];
        int i127 = (((iArr6[i119 >>> 24] ^ iArr7[(i117 >>> 16) & 255]) ^ iArr8[(i115 >>> 8) & 255]) ^ iArr9[i122 & 255]) ^ iArr10[i125];
        int i128 = (((iArr6[i122 >>> 24] ^ iArr7[(i119 >>> 16) & 255]) ^ iArr8[(i117 >>> 8) & 255]) ^ iArr9[i115 & 255]) ^ iArr10[i125 + 1];
        int i129 = iArr10[0];
        int i130 = i3 + 1;
        byte[] bArr3 = j;
        bArr2[i3] = (byte) (bArr3[i124 >>> 24] ^ (i129 >>> 24));
        int i131 = i130 + 1;
        bArr2[i130] = (byte) (bArr3[(i128 >>> 16) & 255] ^ (i129 >>> 16));
        int i132 = i131 + 1;
        bArr2[i131] = (byte) (bArr3[(i127 >>> 8) & 255] ^ (i129 >>> 8));
        int i133 = i132 + 1;
        bArr2[i132] = (byte) (i129 ^ bArr3[i126 & 255]);
        int i134 = iArr10[1];
        int i135 = i133 + 1;
        bArr2[i133] = (byte) (bArr3[i126 >>> 24] ^ (i134 >>> 24));
        int i136 = i135 + 1;
        bArr2[i135] = (byte) (bArr3[(i124 >>> 16) & 255] ^ (i134 >>> 16));
        int i137 = i136 + 1;
        bArr2[i136] = (byte) (bArr3[(i128 >>> 8) & 255] ^ (i134 >>> 8));
        int i138 = i137 + 1;
        bArr2[i137] = (byte) (i134 ^ bArr3[i127 & 255]);
        int i139 = iArr10[2];
        int i140 = i138 + 1;
        bArr2[i138] = (byte) (bArr3[i127 >>> 24] ^ (i139 >>> 24));
        int i141 = i140 + 1;
        bArr2[i140] = (byte) (bArr3[(i126 >>> 16) & 255] ^ (i139 >>> 16));
        int i142 = i141 + 1;
        bArr2[i141] = (byte) (bArr3[(i124 >>> 8) & 255] ^ (i139 >>> 8));
        int i143 = i142 + 1;
        bArr2[i142] = (byte) (i139 ^ bArr3[i128 & 255]);
        int i144 = iArr10[3];
        int i145 = i143 + 1;
        bArr2[i143] = (byte) (bArr3[i128 >>> 24] ^ (i144 >>> 24));
        int i146 = i145 + 1;
        bArr2[i145] = (byte) (bArr3[(i127 >>> 16) & 255] ^ (i144 >>> 16));
        bArr2[i146] = (byte) (bArr3[(i126 >>> 8) & 255] ^ (i144 >>> 8));
        bArr2[i146 + 1] = (byte) (bArr3[i124 & 255] ^ i144);
    }
}
