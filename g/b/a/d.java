package g.b.a;

import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f67582a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f67583b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f67584c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f67585d = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    public static void a(j jVar) {
        a aVar = jVar.f67604c;
        byte[] bArr = jVar.f67605d;
        int i = jVar.f67608g;
        if (i <= 0) {
            a.k(aVar);
            jVar.f67602a = 1;
            return;
        }
        int min = Math.min(jVar.Q - jVar.r, i);
        a.c(aVar, bArr, jVar.r, min);
        jVar.f67608g -= min;
        int i2 = jVar.r + min;
        jVar.r = i2;
        int i3 = jVar.Q;
        if (i2 == i3) {
            jVar.f67603b = 5;
            jVar.Y = i3;
            jVar.X = 0;
            jVar.f67602a = 12;
            return;
        }
        a.k(aVar);
        jVar.f67602a = 1;
    }

    public static void b(j jVar, int i) {
        int i2;
        a aVar = jVar.f67604c;
        int[] iArr = jVar.p;
        int i3 = i * 2;
        a.d(aVar);
        int i4 = i * 1080;
        int r = r(jVar.f67606e, i4, aVar);
        jVar.n[i] = m(jVar.f67607f, i4, aVar);
        if (r == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else {
            i2 = r == 0 ? iArr[i3] : r - 2;
        }
        int[] iArr2 = jVar.o;
        if (i2 >= iArr2[i]) {
            i2 -= iArr2[i];
        }
        int i5 = i3 + 1;
        iArr[i3] = iArr[i5];
        iArr[i5] = i2;
    }

    public static void c(j jVar) {
        b(jVar, 1);
        jVar.F = jVar.l.f67591c[jVar.p[3]];
    }

    public static int d(int i, byte[] bArr, a aVar) {
        a.j(aVar);
        int h2 = h(aVar) + 1;
        if (h2 == 1) {
            l.a(bArr, 0, i);
            return h2;
        }
        int i2 = a.i(aVar, 1) == 1 ? a.i(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        n(h2 + i2, iArr, 0, aVar);
        int i3 = 0;
        while (i3 < i) {
            a.j(aVar);
            a.d(aVar);
            int r = r(iArr, 0, aVar);
            if (r == 0) {
                bArr[i3] = 0;
            } else if (r <= i2) {
                for (int i4 = (1 << r) + a.i(aVar, r); i4 != 0; i4--) {
                    if (i3 < i) {
                        bArr[i3] = 0;
                        i3++;
                    } else {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                }
                continue;
            } else {
                bArr[i3] = (byte) (r - i2);
            }
            i3++;
        }
        if (a.i(aVar, 1) == 1) {
            j(bArr, i);
        }
        return h2;
    }

    public static void e(j jVar) {
        b(jVar, 2);
        jVar.C = jVar.p[5] << 2;
    }

    public static void f(j jVar) {
        b(jVar, 0);
        int i = jVar.p[1];
        int i2 = i << 6;
        jVar.B = i2;
        int i3 = jVar.A[i2] & 255;
        jVar.v = i3;
        jVar.w = jVar.k.f67591c[i3];
        byte b2 = jVar.z[i];
        int[] iArr = c.f67581b;
        jVar.D = iArr[b2];
        jVar.E = iArr[b2 + 1];
    }

    public static void g(a aVar, j jVar) {
        boolean z = a.i(aVar, 1) == 1;
        jVar.f67609h = z;
        jVar.f67608g = 0;
        jVar.i = false;
        jVar.j = false;
        if (!z || a.i(aVar, 1) == 0) {
            int i = a.i(aVar, 2) + 4;
            if (i == 7) {
                jVar.j = true;
                if (a.i(aVar, 1) == 0) {
                    int i2 = a.i(aVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = a.i(aVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        jVar.f67608g = (i4 << (i3 * 8)) | jVar.f67608g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = a.i(aVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.f67608g = (i6 << (i5 * 4)) | jVar.f67608g;
                }
            }
            jVar.f67608g++;
            if (jVar.f67609h) {
                return;
            }
            jVar.i = a.i(aVar, 1) == 1;
        }
    }

    public static int h(a aVar) {
        if (a.i(aVar, 1) != 0) {
            int i = a.i(aVar, 3);
            if (i == 0) {
                return 1;
            }
            return a.i(aVar, i) + (1 << i);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a9, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0311 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x030c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013e A[LOOP:2: B:48:0x013e->B:54:0x0174, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(j jVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = jVar.f67602a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 != 11) {
            a aVar = jVar.f67604c;
            int i8 = jVar.Q - 1;
            byte[] bArr = jVar.f67605d;
            while (true) {
                int i9 = jVar.f67602a;
                if (i9 == 10) {
                    if (i9 == 10) {
                        if (jVar.f67608g >= 0) {
                            a.g(aVar);
                            a.a(jVar.f67604c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i9 != 12) {
                    int i10 = 0;
                    switch (i9) {
                        case 1:
                            if (jVar.f67608g >= 0) {
                                q(jVar);
                                i8 = jVar.Q - 1;
                                bArr = jVar.f67605d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(jVar);
                            jVar.f67602a = 3;
                            if (jVar.f67608g > 0) {
                                jVar.f67602a = 1;
                                break;
                            } else {
                                a.j(aVar);
                                if (jVar.n[1] == 0) {
                                    c(jVar);
                                }
                                int[] iArr = jVar.n;
                                iArr[1] = iArr[1] - 1;
                                a.d(aVar);
                                int r = r(jVar.l.f67590b, jVar.F, aVar);
                                int i11 = r >>> 6;
                                jVar.G = 0;
                                if (i11 >= 2) {
                                    i11 -= 2;
                                    jVar.G = -1;
                                }
                                int i12 = i.f67600g[i11] + ((r >>> 3) & 7);
                                int i13 = i.f67601h[i11] + (r & 7);
                                jVar.y = i.f67596c[i12] + a.i(aVar, i.f67597d[i12]);
                                jVar.M = i.f67598e[i13] + a.i(aVar, i.f67599f[i13]);
                                jVar.x = 0;
                                jVar.f67602a = 6;
                                if (jVar.u) {
                                    int i14 = jVar.r;
                                    int i15 = bArr[(i14 - 1) & i8] & 255;
                                    int i16 = bArr[(i14 - 2) & i8] & 255;
                                    while (true) {
                                        if (jVar.x < jVar.y) {
                                            a.j(aVar);
                                            if (jVar.n[0] == 0) {
                                                f(jVar);
                                            }
                                            byte[] bArr2 = jVar.A;
                                            int i17 = jVar.B;
                                            int[] iArr2 = c.f67580a;
                                            int i18 = iArr2[jVar.D + i15];
                                            int[] iArr3 = jVar.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            a.d(aVar);
                                            g gVar = jVar.k;
                                            int r2 = r(gVar.f67590b, gVar.f67591c[bArr2[i17 + (iArr2[jVar.E + i16] | i18)] & 255], aVar);
                                            int i19 = jVar.r;
                                            bArr[i19] = (byte) r2;
                                            jVar.x++;
                                            jVar.r = i19 + 1;
                                            if (i19 == i8) {
                                                jVar.f67603b = 6;
                                                jVar.Y = jVar.Q;
                                                jVar.X = 0;
                                                jVar.f67602a = 12;
                                            } else {
                                                int i20 = i15;
                                                i15 = r2;
                                                i16 = i20;
                                            }
                                        }
                                    }
                                } else {
                                    while (true) {
                                        if (jVar.x < jVar.y) {
                                            a.j(aVar);
                                            if (jVar.n[0] == 0) {
                                                f(jVar);
                                            }
                                            int[] iArr4 = jVar.n;
                                            iArr4[0] = iArr4[0] - 1;
                                            a.d(aVar);
                                            bArr[jVar.r] = (byte) r(jVar.k.f67590b, jVar.w, aVar);
                                            jVar.x++;
                                            int i21 = jVar.r;
                                            jVar.r = i21 + 1;
                                            if (i21 == i8) {
                                                jVar.f67603b = 6;
                                                jVar.Y = jVar.Q;
                                                jVar.X = 0;
                                                jVar.f67602a = 12;
                                            }
                                        }
                                    }
                                }
                                if (jVar.f67602a == 6) {
                                    continue;
                                } else {
                                    int i22 = jVar.f67608g - jVar.y;
                                    jVar.f67608g = i22;
                                    if (i22 <= 0) {
                                        jVar.f67602a = 3;
                                        break;
                                    } else {
                                        if (jVar.G < 0) {
                                            a.j(aVar);
                                            if (jVar.n[2] == 0) {
                                                e(jVar);
                                            }
                                            int[] iArr5 = jVar.n;
                                            iArr5[2] = iArr5[2] - 1;
                                            a.d(aVar);
                                            g gVar2 = jVar.m;
                                            int[] iArr6 = gVar2.f67590b;
                                            int[] iArr7 = gVar2.f67591c;
                                            byte[] bArr3 = jVar.H;
                                            int i23 = jVar.C;
                                            int i24 = jVar.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], aVar);
                                            jVar.G = r3;
                                            int i25 = jVar.I;
                                            if (r3 >= i25) {
                                                int i26 = r3 - i25;
                                                jVar.G = i26;
                                                int i27 = jVar.J & i26;
                                                int i28 = i26 >>> jVar.K;
                                                jVar.G = i28;
                                                int i29 = (i28 >>> 1) + 1;
                                                jVar.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + a.i(aVar, i29)) << jVar.K);
                                            }
                                        }
                                        int t = t(jVar.G, jVar.q, jVar.t);
                                        jVar.L = t;
                                        if (t >= 0) {
                                            int i30 = jVar.s;
                                            int i31 = jVar.O;
                                            if (i30 != i31 && (i6 = jVar.r) < i31) {
                                                jVar.s = i6;
                                            } else {
                                                jVar.s = jVar.O;
                                            }
                                            jVar.N = jVar.r;
                                            int i32 = jVar.L;
                                            if (i32 > jVar.s) {
                                                jVar.f67602a = 9;
                                                break;
                                            } else {
                                                if (jVar.G > 0) {
                                                    int[] iArr8 = jVar.q;
                                                    int i33 = jVar.t;
                                                    iArr8[i33 & 3] = i32;
                                                    jVar.t = i33 + 1;
                                                }
                                                if (jVar.M <= jVar.f67608g) {
                                                    jVar.x = 0;
                                                    jVar.f67602a = 7;
                                                    int i34 = jVar.r;
                                                    i = (i34 - jVar.L) & i8;
                                                    i2 = jVar.M - jVar.x;
                                                    if (i + i2 >= i8 && i34 + i2 < i8) {
                                                        while (i10 < i2) {
                                                            bArr[i34] = bArr[i];
                                                            i10++;
                                                            i34++;
                                                            i++;
                                                        }
                                                        jVar.x += i2;
                                                        jVar.f67608g -= i2;
                                                        jVar.r += i2;
                                                    } else {
                                                        do {
                                                            i3 = jVar.x;
                                                            if (i3 >= jVar.M) {
                                                                i4 = jVar.r;
                                                                bArr[i4] = bArr[(i4 - jVar.L) & i8];
                                                                jVar.f67608g--;
                                                                jVar.x = i3 + 1;
                                                                jVar.r = i4 + 1;
                                                            }
                                                        } while (i4 != i8);
                                                        i5 = 7;
                                                        jVar.f67603b = 7;
                                                        jVar.Y = jVar.Q;
                                                        jVar.X = 0;
                                                        jVar.f67602a = 12;
                                                        if (jVar.f67602a != i5) {
                                                            break;
                                                        } else {
                                                            jVar.f67602a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i5 = 7;
                                                    if (jVar.f67602a != i5) {
                                                    }
                                                } else {
                                                    throw new BrotliRuntimeException("Invalid backward reference");
                                                }
                                            }
                                        } else {
                                            throw new BrotliRuntimeException("Negative distance");
                                        }
                                    }
                                }
                            }
                            break;
                        case 3:
                            if (jVar.f67608g > 0) {
                            }
                            break;
                        case 4:
                            while (jVar.f67608g > 0) {
                                a.j(aVar);
                                a.i(aVar, 8);
                                jVar.f67608g--;
                            }
                            jVar.f67602a = 1;
                            break;
                        case 5:
                            a(jVar);
                            break;
                        case 6:
                            if (jVar.u) {
                            }
                            if (jVar.f67602a == 6) {
                            }
                            break;
                        case 7:
                            int i342 = jVar.r;
                            i = (i342 - jVar.L) & i8;
                            i2 = jVar.M - jVar.x;
                            if (i + i2 >= i8) {
                                break;
                            }
                            do {
                                i3 = jVar.x;
                                if (i3 >= jVar.M) {
                                }
                            } while (i4 != i8);
                            i5 = 7;
                            jVar.f67603b = 7;
                            jVar.Y = jVar.Q;
                            jVar.X = 0;
                            jVar.f67602a = 12;
                            if (jVar.f67602a != i5) {
                            }
                            break;
                        case 8:
                            int i35 = jVar.Q;
                            System.arraycopy(bArr, i35, bArr, 0, jVar.N - i35);
                            jVar.f67602a = 3;
                            break;
                        case 9:
                            int i36 = jVar.M;
                            if (i36 >= 4 && i36 <= 24) {
                                int i37 = e.f67586a[i36];
                                int i38 = (jVar.L - jVar.s) - 1;
                                int i39 = e.f67587b[i36];
                                int i40 = ((1 << i39) - 1) & i38;
                                int i41 = i38 >>> i39;
                                int i42 = i37 + (i40 * i36);
                                if (i41 < k.f67610d.length) {
                                    int b2 = k.b(bArr, jVar.N, e.a(), i42, jVar.M, k.f67610d[i41]);
                                    int i43 = jVar.N + b2;
                                    jVar.N = i43;
                                    jVar.r += b2;
                                    jVar.f67608g -= b2;
                                    int i44 = jVar.Q;
                                    if (i43 >= i44) {
                                        jVar.f67603b = 8;
                                        jVar.Y = i44;
                                        jVar.X = 0;
                                        jVar.f67602a = 12;
                                        break;
                                    } else {
                                        jVar.f67602a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + jVar.f67602a);
                    }
                } else if (!u(jVar)) {
                    return;
                } else {
                    int i45 = jVar.r;
                    int i46 = jVar.O;
                    if (i45 >= i46) {
                        jVar.s = i46;
                    }
                    jVar.r &= i8;
                    jVar.f67602a = jVar.f67603b;
                }
            }
        } else {
            throw new IllegalStateException("Can't decompress after close");
        }
    }

    public static void j(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                l(iArr, i4);
            }
        }
    }

    public static void k(j jVar) {
        int i;
        int i2 = jVar.P;
        long j = jVar.R;
        if (i2 > j) {
            while (true) {
                int i3 = i2 >> 1;
                if (i3 <= ((int) j) + jVar.S.length) {
                    break;
                }
                i2 = i3;
            }
            if (!jVar.f67609h && i2 < 16384 && jVar.P >= 16384) {
                i2 = 16384;
            }
        }
        int i4 = jVar.Q;
        if (i2 <= i4) {
            return;
        }
        byte[] bArr = new byte[i2 + 37];
        byte[] bArr2 = jVar.f67605d;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, i4);
        } else {
            byte[] bArr3 = jVar.S;
            if (bArr3.length != 0) {
                int length = bArr3.length;
                int i5 = jVar.O;
                if (length > i5) {
                    i = length - i5;
                } else {
                    i5 = length;
                    i = 0;
                }
                System.arraycopy(jVar.S, i, bArr, 0, i5);
                jVar.r = i5;
                jVar.T = i5;
            }
        }
        jVar.f67605d = bArr;
        jVar.Q = i2;
    }

    public static void l(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    public static int m(int[] iArr, int i, a aVar) {
        a.d(aVar);
        int r = r(iArr, i, aVar);
        return i.f67594a[r] + a.i(aVar, i.f67595b[r]);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, a aVar) {
        a.j(aVar);
        int[] iArr2 = new int[i];
        int i3 = a.i(aVar, 2);
        boolean z = true;
        if (i3 == 1) {
            int i4 = i - 1;
            int[] iArr3 = new int[4];
            int i5 = a.i(aVar, 2) + 1;
            int i6 = 0;
            while (i4 != 0) {
                i4 >>= 1;
                i6++;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr3[i7] = a.i(aVar, i6) % i;
                iArr2[iArr3[i7]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i5 != 3) {
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (a.i(aVar, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z = z2;
                } else if (iArr3[0] != iArr3[1] && iArr3[0] != iArr3[2] && iArr3[1] != iArr3[2]) {
                    r5 = true;
                }
            }
            if (!z) {
                f.a(iArr, i2, 8, iArr2, i);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i8 = 32;
        int i9 = 0;
        while (i3 < 18 && i8 > 0) {
            int i10 = f67582a[i3];
            a.d(aVar);
            long j = aVar.f67573f;
            int i11 = aVar.f67574g;
            int i12 = ((int) (j >>> i11)) & 15;
            int[] iArr5 = f67585d;
            aVar.f67574g = i11 + (iArr5[i12] >> 16);
            int i13 = iArr5[i12] & 65535;
            iArr4[i10] = i13;
            if (i13 != 0) {
                i8 -= 32 >> i13;
                i9++;
            }
            i3++;
        }
        r5 = (i9 == 1 || i8 == 0) ? true : true;
        o(iArr4, i, iArr2, aVar);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r4 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
        g.b.a.l.b(r13, r3, r12 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Unused space");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(int[] iArr, int i, int[] iArr2, a aVar) {
        int[] iArr3 = new int[32];
        f.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 0;
        int i4 = 32768;
        int i5 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (i3 < i && i4 > 0) {
                a.j(aVar);
                a.d(aVar);
                long j = aVar.f67573f;
                int i7 = aVar.f67574g;
                int i8 = ((int) (j >>> i7)) & 31;
                aVar.f67574g = i7 + (iArr3[i8] >> 16);
                int i9 = iArr3[i8] & 65535;
                if (i9 < 16) {
                    int i10 = i3 + 1;
                    iArr2[i3] = i9;
                    if (i9 != 0) {
                        i4 -= 32768 >> i9;
                        i3 = i10;
                        i2 = i9;
                    } else {
                        i3 = i10;
                    }
                } else {
                    int i11 = i9 - 14;
                    int i12 = i9 == 16 ? i2 : 0;
                    if (i5 != i12) {
                        i5 = i12;
                        i6 = 0;
                    }
                    int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + a.i(aVar, i11) + 3;
                    int i14 = i13 - i6;
                    if (i3 + i14 > i) {
                        throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                    }
                    int i15 = 0;
                    while (i15 < i14) {
                        iArr2[i3] = i5;
                        i15++;
                        i3++;
                    }
                    if (i5 != 0) {
                        i4 -= i14 << (15 - i5);
                    }
                    i6 = i13;
                }
            }
        }
    }

    public static void p(j jVar) {
        int[] iArr;
        a aVar = jVar.f67604c;
        for (int i = 0; i < 3; i++) {
            jVar.o[i] = h(aVar) + 1;
            jVar.n[i] = 268435456;
            int[] iArr2 = jVar.o;
            if (iArr2[i] > 1) {
                int i2 = i * 1080;
                n(iArr2[i] + 2, jVar.f67606e, i2, aVar);
                n(26, jVar.f67607f, i2, aVar);
                jVar.n[i] = m(jVar.f67607f, i2, aVar);
            }
        }
        a.j(aVar);
        jVar.K = a.i(aVar, 2);
        int i3 = a.i(aVar, 4);
        int i4 = jVar.K;
        int i5 = (i3 << i4) + 16;
        jVar.I = i5;
        jVar.J = (1 << i4) - 1;
        int i6 = i5 + (48 << i4);
        jVar.z = new byte[jVar.o[0]];
        int i7 = 0;
        while (true) {
            iArr = jVar.o;
            if (i7 >= iArr[0]) {
                break;
            }
            int min = Math.min(i7 + 96, iArr[0]);
            while (i7 < min) {
                jVar.z[i7] = (byte) (a.i(aVar, 2) << 1);
                i7++;
            }
            a.j(aVar);
        }
        byte[] bArr = new byte[iArr[0] << 6];
        jVar.A = bArr;
        int d2 = d(iArr[0] << 6, bArr, aVar);
        jVar.u = true;
        int i8 = 0;
        while (true) {
            if (i8 >= (jVar.o[0] << 6)) {
                break;
            } else if (jVar.A[i8] != (i8 >> 6)) {
                jVar.u = false;
                break;
            } else {
                i8++;
            }
        }
        int[] iArr3 = jVar.o;
        byte[] bArr2 = new byte[iArr3[2] << 2];
        jVar.H = bArr2;
        int d3 = d(iArr3[2] << 2, bArr2, aVar);
        g.b(jVar.k, 256, d2);
        g.b(jVar.l, 704, jVar.o[1]);
        g.b(jVar.m, i6, d3);
        g.a(jVar.k, aVar);
        g.a(jVar.l, aVar);
        g.a(jVar.m, aVar);
        jVar.B = 0;
        jVar.C = 0;
        int[] iArr4 = c.f67581b;
        byte[] bArr3 = jVar.z;
        jVar.D = iArr4[bArr3[0]];
        jVar.E = iArr4[bArr3[0] + 1];
        jVar.v = 0;
        jVar.w = jVar.k.f67591c[0];
        jVar.F = jVar.l.f67591c[0];
        int[] iArr5 = jVar.p;
        iArr5[4] = 1;
        iArr5[2] = 1;
        iArr5[0] = 1;
        iArr5[5] = 0;
        iArr5[3] = 0;
        iArr5[1] = 0;
    }

    public static void q(j jVar) {
        a aVar = jVar.f67604c;
        if (jVar.f67609h) {
            jVar.f67603b = 10;
            jVar.Y = jVar.r;
            jVar.X = 0;
            jVar.f67602a = 12;
            return;
        }
        g gVar = jVar.k;
        gVar.f67590b = null;
        gVar.f67591c = null;
        g gVar2 = jVar.l;
        gVar2.f67590b = null;
        gVar2.f67591c = null;
        g gVar3 = jVar.m;
        gVar3.f67590b = null;
        gVar3.f67591c = null;
        a.j(aVar);
        g(aVar, jVar);
        if (jVar.f67608g != 0 || jVar.j) {
            if (!jVar.i && !jVar.j) {
                jVar.f67602a = 2;
            } else {
                a.g(aVar);
                jVar.f67602a = jVar.j ? 4 : 5;
            }
            if (jVar.j) {
                return;
            }
            jVar.R += jVar.f67608g;
            if (jVar.Q < jVar.P) {
                k(jVar);
            }
        }
    }

    public static int r(int[] iArr, int i, a aVar) {
        long j = aVar.f67573f;
        int i2 = aVar.f67574g;
        int i3 = (int) (j >>> i2);
        int i4 = i + (i3 & 255);
        int i5 = iArr[i4] >> 16;
        int i6 = iArr[i4] & 65535;
        if (i5 <= 8) {
            aVar.f67574g = i2 + i5;
            return i6;
        }
        int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
        aVar.f67574g = i2 + (iArr[i7] >> 16) + 8;
        return iArr[i7] & 65535;
    }

    public static void s(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.S = bArr;
    }

    public static int t(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(i2 + f67583b[i]) & 3] + f67584c[i] : (i - 16) + 1;
    }

    public static boolean u(j jVar) {
        int i = jVar.T;
        if (i != 0) {
            jVar.X += i;
            jVar.T = 0;
        }
        int min = Math.min(jVar.V - jVar.W, jVar.Y - jVar.X);
        if (min != 0) {
            System.arraycopy(jVar.f67605d, jVar.X, jVar.Z, jVar.U + jVar.W, min);
            jVar.W += min;
            jVar.X += min;
        }
        return jVar.W < jVar.V;
    }
}
