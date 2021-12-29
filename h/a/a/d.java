package h.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f64066b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f64067c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f64068d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1772533370, "Lh/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1772533370, "Lh/a/a/d;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        f64066b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        f64067c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        f64068d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jVar) == null) {
            a aVar = jVar.f64081c;
            byte[] bArr = jVar.f64082d;
            int i2 = jVar.f64085g;
            if (i2 <= 0) {
                a.k(aVar);
                jVar.a = 1;
                return;
            }
            int min = Math.min(jVar.Q - jVar.r, i2);
            a.c(aVar, bArr, jVar.r, min);
            jVar.f64085g -= min;
            int i3 = jVar.r + min;
            jVar.r = i3;
            int i4 = jVar.Q;
            if (i3 == i4) {
                jVar.f64080b = 5;
                jVar.Y = i4;
                jVar.X = 0;
                jVar.a = 12;
                return;
            }
            a.k(aVar);
            jVar.a = 1;
        }
    }

    public static void b(j jVar, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, jVar, i2) == null) {
            a aVar = jVar.f64081c;
            int[] iArr = jVar.p;
            int i4 = i2 * 2;
            a.d(aVar);
            int i5 = i2 * 1080;
            int r = r(jVar.f64083e, i5, aVar);
            jVar.n[i2] = m(jVar.f64084f, i5, aVar);
            if (r == 1) {
                i3 = iArr[i4 + 1] + 1;
            } else {
                i3 = r == 0 ? iArr[i4] : r - 2;
            }
            int[] iArr2 = jVar.o;
            if (i3 >= iArr2[i2]) {
                i3 -= iArr2[i2];
            }
            int i6 = i4 + 1;
            iArr[i4] = iArr[i6];
            iArr[i6] = i3;
        }
    }

    public static void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jVar) == null) {
            b(jVar, 1);
            jVar.F = jVar.l.f64071c[jVar.p[3]];
        }
    }

    public static int d(int i2, byte[] bArr, a aVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, bArr, aVar)) == null) {
            a.j(aVar);
            int h2 = h(aVar) + 1;
            if (h2 == 1) {
                l.a(bArr, 0, i2);
                return h2;
            }
            int i3 = a.i(aVar, 1) == 1 ? a.i(aVar, 4) + 1 : 0;
            int[] iArr = new int[1080];
            n(h2 + i3, iArr, 0, aVar);
            int i4 = 0;
            while (i4 < i2) {
                a.j(aVar);
                a.d(aVar);
                int r = r(iArr, 0, aVar);
                if (r == 0) {
                    bArr[i4] = 0;
                } else if (r <= i3) {
                    for (int i5 = (1 << r) + a.i(aVar, r); i5 != 0; i5--) {
                        if (i4 < i2) {
                            bArr[i4] = 0;
                            i4++;
                        } else {
                            throw new BrotliRuntimeException("Corrupted context map");
                        }
                    }
                    continue;
                } else {
                    bArr[i4] = (byte) (r - i3);
                }
                i4++;
            }
            if (a.i(aVar, 1) == 1) {
                j(bArr, i2);
            }
            return h2;
        }
        return invokeILL.intValue;
    }

    public static void e(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, jVar) == null) {
            b(jVar, 2);
            jVar.C = jVar.p[5] << 2;
        }
    }

    public static void f(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, jVar) == null) {
            b(jVar, 0);
            int i2 = jVar.p[1];
            int i3 = i2 << 6;
            jVar.B = i3;
            int i4 = jVar.A[i3] & 255;
            jVar.v = i4;
            jVar.w = jVar.f64089k.f64071c[i4];
            byte b2 = jVar.z[i2];
            int[] iArr = c.f64065b;
            jVar.D = iArr[b2];
            jVar.E = iArr[b2 + 1];
        }
    }

    public static void g(a aVar, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, aVar, jVar) == null) {
            boolean z = a.i(aVar, 1) == 1;
            jVar.f64086h = z;
            jVar.f64085g = 0;
            jVar.f64087i = false;
            jVar.f64088j = false;
            if (!z || a.i(aVar, 1) == 0) {
                int i2 = a.i(aVar, 2) + 4;
                if (i2 == 7) {
                    jVar.f64088j = true;
                    if (a.i(aVar, 1) == 0) {
                        int i3 = a.i(aVar, 2);
                        if (i3 == 0) {
                            return;
                        }
                        for (int i4 = 0; i4 < i3; i4++) {
                            int i5 = a.i(aVar, 8);
                            if (i5 == 0 && i4 + 1 == i3 && i3 > 1) {
                                throw new BrotliRuntimeException("Exuberant nibble");
                            }
                            jVar.f64085g = (i5 << (i4 * 8)) | jVar.f64085g;
                        }
                    } else {
                        throw new BrotliRuntimeException("Corrupted reserved bit");
                    }
                } else {
                    for (int i6 = 0; i6 < i2; i6++) {
                        int i7 = a.i(aVar, 4);
                        if (i7 == 0 && i6 + 1 == i2 && i2 > 4) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        jVar.f64085g = (i7 << (i6 * 4)) | jVar.f64085g;
                    }
                }
                jVar.f64085g++;
                if (jVar.f64086h) {
                    return;
                }
                jVar.f64087i = a.i(aVar, 1) == 1;
            }
        }
    }

    public static int h(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            if (a.i(aVar, 1) != 0) {
                int i2 = a.i(aVar, 3);
                if (i2 == 0) {
                    return 1;
                }
                return a.i(aVar, i2) + (1 << i2);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0310 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142 A[LOOP:2: B:50:0x0142->B:56:0x0178, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(j jVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, jVar) != null) {
            return;
        }
        int i8 = jVar.a;
        if (i8 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i8 != 11) {
            a aVar = jVar.f64081c;
            int i9 = jVar.Q - 1;
            byte[] bArr = jVar.f64082d;
            while (true) {
                int i10 = jVar.a;
                if (i10 == 10) {
                    if (i10 == 10) {
                        if (jVar.f64085g >= 0) {
                            a.g(aVar);
                            a.a(jVar.f64081c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i10 != 12) {
                    int i11 = 0;
                    switch (i10) {
                        case 1:
                            if (jVar.f64085g >= 0) {
                                q(jVar);
                                i9 = jVar.Q - 1;
                                bArr = jVar.f64082d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(jVar);
                            jVar.a = 3;
                            if (jVar.f64085g > 0) {
                                jVar.a = 1;
                                break;
                            } else {
                                a.j(aVar);
                                if (jVar.n[1] == 0) {
                                    c(jVar);
                                }
                                int[] iArr = jVar.n;
                                iArr[1] = iArr[1] - 1;
                                a.d(aVar);
                                int r = r(jVar.l.f64070b, jVar.F, aVar);
                                int i12 = r >>> 6;
                                jVar.G = 0;
                                if (i12 >= 2) {
                                    i12 -= 2;
                                    jVar.G = -1;
                                }
                                int i13 = i.f64078g[i12] + ((r >>> 3) & 7);
                                int i14 = i.f64079h[i12] + (r & 7);
                                jVar.y = i.f64074c[i13] + a.i(aVar, i.f64075d[i13]);
                                jVar.M = i.f64076e[i14] + a.i(aVar, i.f64077f[i14]);
                                jVar.x = 0;
                                jVar.a = 6;
                                if (jVar.u) {
                                    int i15 = jVar.r;
                                    int i16 = bArr[(i15 - 1) & i9] & 255;
                                    int i17 = bArr[(i15 - 2) & i9] & 255;
                                    while (true) {
                                        if (jVar.x < jVar.y) {
                                            a.j(aVar);
                                            if (jVar.n[0] == 0) {
                                                f(jVar);
                                            }
                                            byte[] bArr2 = jVar.A;
                                            int i18 = jVar.B;
                                            int[] iArr2 = c.a;
                                            int i19 = iArr2[jVar.D + i16];
                                            int[] iArr3 = jVar.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            a.d(aVar);
                                            g gVar = jVar.f64089k;
                                            int r2 = r(gVar.f64070b, gVar.f64071c[bArr2[i18 + (iArr2[jVar.E + i17] | i19)] & 255], aVar);
                                            int i20 = jVar.r;
                                            bArr[i20] = (byte) r2;
                                            jVar.x++;
                                            jVar.r = i20 + 1;
                                            if (i20 == i9) {
                                                jVar.f64080b = 6;
                                                jVar.Y = jVar.Q;
                                                jVar.X = 0;
                                                jVar.a = 12;
                                            } else {
                                                int i21 = i16;
                                                i16 = r2;
                                                i17 = i21;
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
                                            bArr[jVar.r] = (byte) r(jVar.f64089k.f64070b, jVar.w, aVar);
                                            jVar.x++;
                                            int i22 = jVar.r;
                                            jVar.r = i22 + 1;
                                            if (i22 == i9) {
                                                jVar.f64080b = 6;
                                                jVar.Y = jVar.Q;
                                                jVar.X = 0;
                                                jVar.a = 12;
                                            }
                                        }
                                    }
                                }
                                if (jVar.a == 6) {
                                    continue;
                                } else {
                                    int i23 = jVar.f64085g - jVar.y;
                                    jVar.f64085g = i23;
                                    if (i23 <= 0) {
                                        jVar.a = 3;
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
                                            int[] iArr6 = gVar2.f64070b;
                                            int[] iArr7 = gVar2.f64071c;
                                            byte[] bArr3 = jVar.H;
                                            int i24 = jVar.C;
                                            int i25 = jVar.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i24 + (i25 > 4 ? 3 : i25 - 2)] & 255], aVar);
                                            jVar.G = r3;
                                            int i26 = jVar.I;
                                            if (r3 >= i26) {
                                                int i27 = r3 - i26;
                                                jVar.G = i27;
                                                int i28 = jVar.J & i27;
                                                int i29 = i27 >>> jVar.K;
                                                jVar.G = i29;
                                                int i30 = (i29 >>> 1) + 1;
                                                jVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + a.i(aVar, i30)) << jVar.K);
                                            }
                                        }
                                        int t = t(jVar.G, jVar.q, jVar.t);
                                        jVar.L = t;
                                        if (t >= 0) {
                                            int i31 = jVar.s;
                                            int i32 = jVar.O;
                                            if (i31 != i32 && (i7 = jVar.r) < i32) {
                                                jVar.s = i7;
                                            } else {
                                                jVar.s = jVar.O;
                                            }
                                            jVar.N = jVar.r;
                                            int i33 = jVar.L;
                                            if (i33 > jVar.s) {
                                                jVar.a = 9;
                                                break;
                                            } else {
                                                if (jVar.G > 0) {
                                                    int[] iArr8 = jVar.q;
                                                    int i34 = jVar.t;
                                                    iArr8[i34 & 3] = i33;
                                                    jVar.t = i34 + 1;
                                                }
                                                if (jVar.M <= jVar.f64085g) {
                                                    jVar.x = 0;
                                                    jVar.a = 7;
                                                    int i35 = jVar.r;
                                                    i2 = (i35 - jVar.L) & i9;
                                                    i3 = jVar.M - jVar.x;
                                                    if (i2 + i3 >= i9 && i35 + i3 < i9) {
                                                        while (i11 < i3) {
                                                            bArr[i35] = bArr[i2];
                                                            i11++;
                                                            i35++;
                                                            i2++;
                                                        }
                                                        jVar.x += i3;
                                                        jVar.f64085g -= i3;
                                                        jVar.r += i3;
                                                    } else {
                                                        do {
                                                            i4 = jVar.x;
                                                            if (i4 >= jVar.M) {
                                                                i5 = jVar.r;
                                                                bArr[i5] = bArr[(i5 - jVar.L) & i9];
                                                                jVar.f64085g--;
                                                                jVar.x = i4 + 1;
                                                                jVar.r = i5 + 1;
                                                            }
                                                        } while (i5 != i9);
                                                        i6 = 7;
                                                        jVar.f64080b = 7;
                                                        jVar.Y = jVar.Q;
                                                        jVar.X = 0;
                                                        jVar.a = 12;
                                                        if (jVar.a != i6) {
                                                            break;
                                                        } else {
                                                            jVar.a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i6 = 7;
                                                    if (jVar.a != i6) {
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
                            if (jVar.f64085g > 0) {
                            }
                            break;
                        case 4:
                            while (jVar.f64085g > 0) {
                                a.j(aVar);
                                a.i(aVar, 8);
                                jVar.f64085g--;
                            }
                            jVar.a = 1;
                            break;
                        case 5:
                            a(jVar);
                            break;
                        case 6:
                            if (jVar.u) {
                            }
                            if (jVar.a == 6) {
                            }
                            break;
                        case 7:
                            int i352 = jVar.r;
                            i2 = (i352 - jVar.L) & i9;
                            i3 = jVar.M - jVar.x;
                            if (i2 + i3 >= i9) {
                                break;
                            }
                            do {
                                i4 = jVar.x;
                                if (i4 >= jVar.M) {
                                }
                            } while (i5 != i9);
                            i6 = 7;
                            jVar.f64080b = 7;
                            jVar.Y = jVar.Q;
                            jVar.X = 0;
                            jVar.a = 12;
                            if (jVar.a != i6) {
                            }
                            break;
                        case 8:
                            int i36 = jVar.Q;
                            System.arraycopy(bArr, i36, bArr, 0, jVar.N - i36);
                            jVar.a = 3;
                            break;
                        case 9:
                            int i37 = jVar.M;
                            if (i37 >= 4 && i37 <= 24) {
                                int i38 = e.a[i37];
                                int i39 = (jVar.L - jVar.s) - 1;
                                int i40 = e.f64069b[i37];
                                int i41 = ((1 << i40) - 1) & i39;
                                int i42 = i39 >>> i40;
                                int i43 = i38 + (i41 * i37);
                                if (i42 < k.f64090d.length) {
                                    int b2 = k.b(bArr, jVar.N, e.a(), i43, jVar.M, k.f64090d[i42]);
                                    int i44 = jVar.N + b2;
                                    jVar.N = i44;
                                    jVar.r += b2;
                                    jVar.f64085g -= b2;
                                    int i45 = jVar.Q;
                                    if (i44 >= i45) {
                                        jVar.f64080b = 8;
                                        jVar.Y = i45;
                                        jVar.X = 0;
                                        jVar.a = 12;
                                        break;
                                    } else {
                                        jVar.a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + jVar.a);
                    }
                } else if (!u(jVar)) {
                    return;
                } else {
                    int i46 = jVar.r;
                    int i47 = jVar.O;
                    if (i46 >= i47) {
                        jVar.s = i47;
                    }
                    jVar.r &= i9;
                    jVar.a = jVar.f64080b;
                }
            }
        } else {
            throw new IllegalStateException("Can't decompress after close");
        }
    }

    public static void j(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, bArr, i2) == null) {
            int[] iArr = new int[256];
            for (int i3 = 0; i3 < 256; i3++) {
                iArr[i3] = i3;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = bArr[i4] & 255;
                bArr[i4] = (byte) iArr[i5];
                if (i5 != 0) {
                    l(iArr, i5);
                }
            }
        }
    }

    public static void k(j jVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, jVar) == null) {
            int i3 = jVar.P;
            long j2 = jVar.R;
            if (i3 > j2) {
                while (true) {
                    int i4 = i3 >> 1;
                    if (i4 <= ((int) j2) + jVar.S.length) {
                        break;
                    }
                    i3 = i4;
                }
                if (!jVar.f64086h && i3 < 16384 && jVar.P >= 16384) {
                    i3 = 16384;
                }
            }
            int i5 = jVar.Q;
            if (i3 <= i5) {
                return;
            }
            byte[] bArr = new byte[i3 + 37];
            byte[] bArr2 = jVar.f64082d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i5);
            } else {
                byte[] bArr3 = jVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i6 = jVar.O;
                    if (length > i6) {
                        i2 = length - i6;
                    } else {
                        i6 = length;
                        i2 = 0;
                    }
                    System.arraycopy(jVar.S, i2, bArr, 0, i6);
                    jVar.r = i6;
                    jVar.T = i6;
                }
            }
            jVar.f64082d = bArr;
            jVar.Q = i3;
        }
    }

    public static void l(int[] iArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, iArr, i2) == null) {
            int i3 = iArr[i2];
            while (i2 > 0) {
                iArr[i2] = iArr[i2 - 1];
                i2--;
            }
            iArr[0] = i3;
        }
    }

    public static int m(int[] iArr, int i2, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i2, aVar)) == null) {
            a.d(aVar);
            int r = r(iArr, i2, aVar);
            return i.a[r] + a.i(aVar, i.f64073b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i2, int[] iArr, int i3, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), iArr, Integer.valueOf(i3), aVar}) != null) {
            return;
        }
        a.j(aVar);
        int[] iArr2 = new int[i2];
        int i4 = a.i(aVar, 2);
        boolean z = true;
        if (i4 == 1) {
            int i5 = i2 - 1;
            int[] iArr3 = new int[4];
            int i6 = a.i(aVar, 2) + 1;
            int i7 = 0;
            while (i5 != 0) {
                i5 >>= 1;
                i7++;
            }
            for (int i8 = 0; i8 < i6; i8++) {
                iArr3[i8] = a.i(aVar, i7) % i2;
                iArr2[iArr3[i8]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i6 != 1) {
                if (i6 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i6 != 3) {
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
                f.a(iArr, i3, 8, iArr2, i2);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i9 = 32;
        int i10 = 0;
        while (i4 < 18 && i9 > 0) {
            int i11 = a[i4];
            a.d(aVar);
            long j2 = aVar.f64057f;
            int i12 = aVar.f64058g;
            int i13 = ((int) (j2 >>> i12)) & 15;
            int[] iArr5 = f64068d;
            aVar.f64058g = i12 + (iArr5[i13] >> 16);
            int i14 = iArr5[i13] & 65535;
            iArr4[i11] = i14;
            if (i14 != 0) {
                i9 -= 32 >> i14;
                i10++;
            }
            i4++;
        }
        r5 = (i10 == 1 || i9 == 0) ? true : true;
        o(iArr4, i2, iArr2, aVar);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        h.a.a.l.b(r13, r3, r12 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Unused space");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(int[] iArr, int i2, int[] iArr2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65551, null, iArr, i2, iArr2, aVar) != null) {
            return;
        }
        int[] iArr3 = new int[32];
        f.a(iArr3, 0, 5, iArr, 18);
        int i3 = 8;
        int i4 = 0;
        int i5 = 32768;
        int i6 = 0;
        loop0: while (true) {
            int i7 = 0;
            while (i4 < i2 && i5 > 0) {
                a.j(aVar);
                a.d(aVar);
                long j2 = aVar.f64057f;
                int i8 = aVar.f64058g;
                int i9 = ((int) (j2 >>> i8)) & 31;
                aVar.f64058g = i8 + (iArr3[i9] >> 16);
                int i10 = iArr3[i9] & 65535;
                if (i10 < 16) {
                    int i11 = i4 + 1;
                    iArr2[i4] = i10;
                    if (i10 != 0) {
                        i5 -= 32768 >> i10;
                        i4 = i11;
                        i3 = i10;
                    } else {
                        i4 = i11;
                    }
                } else {
                    int i12 = i10 - 14;
                    int i13 = i10 == 16 ? i3 : 0;
                    if (i6 != i13) {
                        i6 = i13;
                        i7 = 0;
                    }
                    int i14 = (i7 > 0 ? (i7 - 2) << i12 : i7) + a.i(aVar, i12) + 3;
                    int i15 = i14 - i7;
                    if (i4 + i15 > i2) {
                        throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                    }
                    int i16 = 0;
                    while (i16 < i15) {
                        iArr2[i4] = i6;
                        i16++;
                        i4++;
                    }
                    if (i6 != 0) {
                        i5 -= i15 << (15 - i6);
                    }
                    i7 = i14;
                }
            }
        }
    }

    public static void p(j jVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, jVar) == null) {
            a aVar = jVar.f64081c;
            for (int i2 = 0; i2 < 3; i2++) {
                jVar.o[i2] = h(aVar) + 1;
                jVar.n[i2] = 268435456;
                int[] iArr2 = jVar.o;
                if (iArr2[i2] > 1) {
                    int i3 = i2 * 1080;
                    n(iArr2[i2] + 2, jVar.f64083e, i3, aVar);
                    n(26, jVar.f64084f, i3, aVar);
                    jVar.n[i2] = m(jVar.f64084f, i3, aVar);
                }
            }
            a.j(aVar);
            jVar.K = a.i(aVar, 2);
            int i4 = a.i(aVar, 4);
            int i5 = jVar.K;
            int i6 = (i4 << i5) + 16;
            jVar.I = i6;
            jVar.J = (1 << i5) - 1;
            int i7 = i6 + (48 << i5);
            jVar.z = new byte[jVar.o[0]];
            int i8 = 0;
            while (true) {
                iArr = jVar.o;
                if (i8 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i8 + 96, iArr[0]);
                while (i8 < min) {
                    jVar.z[i8] = (byte) (a.i(aVar, 2) << 1);
                    i8++;
                }
                a.j(aVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            jVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, aVar);
            jVar.u = true;
            int i9 = 0;
            while (true) {
                if (i9 >= (jVar.o[0] << 6)) {
                    break;
                } else if (jVar.A[i9] != (i9 >> 6)) {
                    jVar.u = false;
                    break;
                } else {
                    i9++;
                }
            }
            int[] iArr3 = jVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            jVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, aVar);
            g.b(jVar.f64089k, 256, d2);
            g.b(jVar.l, 704, jVar.o[1]);
            g.b(jVar.m, i7, d3);
            g.a(jVar.f64089k, aVar);
            g.a(jVar.l, aVar);
            g.a(jVar.m, aVar);
            jVar.B = 0;
            jVar.C = 0;
            int[] iArr4 = c.f64065b;
            byte[] bArr3 = jVar.z;
            jVar.D = iArr4[bArr3[0]];
            jVar.E = iArr4[bArr3[0] + 1];
            jVar.v = 0;
            jVar.w = jVar.f64089k.f64071c[0];
            jVar.F = jVar.l.f64071c[0];
            int[] iArr5 = jVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, jVar) == null) {
            a aVar = jVar.f64081c;
            if (jVar.f64086h) {
                jVar.f64080b = 10;
                jVar.Y = jVar.r;
                jVar.X = 0;
                jVar.a = 12;
                return;
            }
            g gVar = jVar.f64089k;
            gVar.f64070b = null;
            gVar.f64071c = null;
            g gVar2 = jVar.l;
            gVar2.f64070b = null;
            gVar2.f64071c = null;
            g gVar3 = jVar.m;
            gVar3.f64070b = null;
            gVar3.f64071c = null;
            a.j(aVar);
            g(aVar, jVar);
            if (jVar.f64085g != 0 || jVar.f64088j) {
                if (!jVar.f64087i && !jVar.f64088j) {
                    jVar.a = 2;
                } else {
                    a.g(aVar);
                    jVar.a = jVar.f64088j ? 4 : 5;
                }
                if (jVar.f64088j) {
                    return;
                }
                jVar.R += jVar.f64085g;
                if (jVar.Q < jVar.P) {
                    k(jVar);
                }
            }
        }
    }

    public static int r(int[] iArr, int i2, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i2, aVar)) == null) {
            long j2 = aVar.f64057f;
            int i3 = aVar.f64058g;
            int i4 = (int) (j2 >>> i3);
            int i5 = i2 + (i4 & 255);
            int i6 = iArr[i5] >> 16;
            int i7 = iArr[i5] & 65535;
            if (i6 <= 8) {
                aVar.f64058g = i3 + i6;
                return i7;
            }
            int i8 = i5 + i7 + ((((1 << i6) - 1) & i4) >>> 8);
            aVar.f64058g = i3 + (iArr[i8] >> 16) + 8;
            return iArr[i8] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static void s(j jVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, jVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            jVar.S = bArr;
        }
    }

    public static int t(int i2, int[] iArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i2), iArr, Integer.valueOf(i3)})) == null) ? i2 < 16 ? iArr[(i3 + f64066b[i2]) & 3] + f64067c[i2] : (i2 - 16) + 1 : invokeCommon.intValue;
    }

    public static boolean u(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, jVar)) == null) {
            int i2 = jVar.T;
            if (i2 != 0) {
                jVar.X += i2;
                jVar.T = 0;
            }
            int min = Math.min(jVar.V - jVar.W, jVar.Y - jVar.X);
            if (min != 0) {
                System.arraycopy(jVar.f64082d, jVar.X, jVar.Z, jVar.U + jVar.W, min);
                jVar.W += min;
                jVar.X += min;
            }
            return jVar.W < jVar.V;
        }
        return invokeL.booleanValue;
    }
}
