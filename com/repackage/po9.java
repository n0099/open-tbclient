package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes6.dex */
public final class po9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755403049, "Lcom/repackage/po9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755403049, "Lcom/repackage/po9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, vo9Var) == null) {
            mo9 mo9Var = vo9Var.c;
            byte[] bArr = vo9Var.d;
            int i = vo9Var.g;
            if (i <= 0) {
                mo9.k(mo9Var);
                vo9Var.a = 1;
                return;
            }
            int min = Math.min(vo9Var.Q - vo9Var.r, i);
            mo9.c(mo9Var, bArr, vo9Var.r, min);
            vo9Var.g -= min;
            int i2 = vo9Var.r + min;
            vo9Var.r = i2;
            int i3 = vo9Var.Q;
            if (i2 == i3) {
                vo9Var.b = 5;
                vo9Var.Y = i3;
                vo9Var.X = 0;
                vo9Var.a = 12;
                return;
            }
            mo9.k(mo9Var);
            vo9Var.a = 1;
        }
    }

    public static void b(vo9 vo9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, vo9Var, i) == null) {
            mo9 mo9Var = vo9Var.c;
            int[] iArr = vo9Var.p;
            int i3 = i * 2;
            mo9.d(mo9Var);
            int i4 = i * 1080;
            int r = r(vo9Var.e, i4, mo9Var);
            vo9Var.n[i] = m(vo9Var.f, i4, mo9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else {
                i2 = r == 0 ? iArr[i3] : r - 2;
            }
            int[] iArr2 = vo9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, vo9Var) == null) {
            b(vo9Var, 1);
            vo9Var.F = vo9Var.l.c[vo9Var.p[3]];
        }
    }

    public static int d(int i, byte[] bArr, mo9 mo9Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, mo9Var)) == null) {
            mo9.j(mo9Var);
            int h = h(mo9Var) + 1;
            if (h == 1) {
                xo9.a(bArr, 0, i);
                return h;
            }
            int i2 = mo9.i(mo9Var, 1) == 1 ? mo9.i(mo9Var, 4) + 1 : 0;
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, mo9Var);
            int i3 = 0;
            while (i3 < i) {
                mo9.j(mo9Var);
                mo9.d(mo9Var);
                int r = r(iArr, 0, mo9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + mo9.i(mo9Var, r); i4 != 0; i4--) {
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
            if (mo9.i(mo9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void e(vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, vo9Var) == null) {
            b(vo9Var, 2);
            vo9Var.C = vo9Var.p[5] << 2;
        }
    }

    public static void f(vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, vo9Var) == null) {
            b(vo9Var, 0);
            int i = vo9Var.p[1];
            int i2 = i << 6;
            vo9Var.B = i2;
            int i3 = vo9Var.A[i2] & 255;
            vo9Var.v = i3;
            vo9Var.w = vo9Var.k.c[i3];
            byte b2 = vo9Var.z[i];
            int[] iArr = oo9.b;
            vo9Var.D = iArr[b2];
            vo9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(mo9 mo9Var, vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, mo9Var, vo9Var) == null) {
            boolean z = mo9.i(mo9Var, 1) == 1;
            vo9Var.h = z;
            vo9Var.g = 0;
            vo9Var.i = false;
            vo9Var.j = false;
            if (!z || mo9.i(mo9Var, 1) == 0) {
                int i = mo9.i(mo9Var, 2) + 4;
                if (i == 7) {
                    vo9Var.j = true;
                    if (mo9.i(mo9Var, 1) == 0) {
                        int i2 = mo9.i(mo9Var, 2);
                        if (i2 == 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < i2; i3++) {
                            int i4 = mo9.i(mo9Var, 8);
                            if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                                throw new BrotliRuntimeException("Exuberant nibble");
                            }
                            vo9Var.g = (i4 << (i3 * 8)) | vo9Var.g;
                        }
                    } else {
                        throw new BrotliRuntimeException("Corrupted reserved bit");
                    }
                } else {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = mo9.i(mo9Var, 4);
                        if (i6 == 0 && i5 + 1 == i && i > 4) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        vo9Var.g = (i6 << (i5 * 4)) | vo9Var.g;
                    }
                }
                vo9Var.g++;
                if (vo9Var.h) {
                    return;
                }
                vo9Var.i = mo9.i(mo9Var, 1) == 1;
            }
        }
    }

    public static int h(mo9 mo9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, mo9Var)) == null) {
            if (mo9.i(mo9Var, 1) != 0) {
                int i = mo9.i(mo9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return mo9.i(mo9Var, i) + (1 << i);
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
    public static void i(vo9 vo9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, vo9Var) != null) {
            return;
        }
        int i7 = vo9Var.a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 != 11) {
            mo9 mo9Var = vo9Var.c;
            int i8 = vo9Var.Q - 1;
            byte[] bArr = vo9Var.d;
            while (true) {
                int i9 = vo9Var.a;
                if (i9 == 10) {
                    if (i9 == 10) {
                        if (vo9Var.g >= 0) {
                            mo9.g(mo9Var);
                            mo9.a(vo9Var.c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i9 != 12) {
                    int i10 = 0;
                    switch (i9) {
                        case 1:
                            if (vo9Var.g >= 0) {
                                q(vo9Var);
                                i8 = vo9Var.Q - 1;
                                bArr = vo9Var.d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(vo9Var);
                            vo9Var.a = 3;
                            if (vo9Var.g > 0) {
                                vo9Var.a = 1;
                                break;
                            } else {
                                mo9.j(mo9Var);
                                if (vo9Var.n[1] == 0) {
                                    c(vo9Var);
                                }
                                int[] iArr = vo9Var.n;
                                iArr[1] = iArr[1] - 1;
                                mo9.d(mo9Var);
                                int r = r(vo9Var.l.b, vo9Var.F, mo9Var);
                                int i11 = r >>> 6;
                                vo9Var.G = 0;
                                if (i11 >= 2) {
                                    i11 -= 2;
                                    vo9Var.G = -1;
                                }
                                int i12 = uo9.g[i11] + ((r >>> 3) & 7);
                                int i13 = uo9.h[i11] + (r & 7);
                                vo9Var.y = uo9.c[i12] + mo9.i(mo9Var, uo9.d[i12]);
                                vo9Var.M = uo9.e[i13] + mo9.i(mo9Var, uo9.f[i13]);
                                vo9Var.x = 0;
                                vo9Var.a = 6;
                                if (vo9Var.u) {
                                    int i14 = vo9Var.r;
                                    int i15 = bArr[(i14 - 1) & i8] & 255;
                                    int i16 = bArr[(i14 - 2) & i8] & 255;
                                    while (true) {
                                        if (vo9Var.x < vo9Var.y) {
                                            mo9.j(mo9Var);
                                            if (vo9Var.n[0] == 0) {
                                                f(vo9Var);
                                            }
                                            byte[] bArr2 = vo9Var.A;
                                            int i17 = vo9Var.B;
                                            int[] iArr2 = oo9.a;
                                            int i18 = iArr2[vo9Var.D + i15];
                                            int[] iArr3 = vo9Var.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            mo9.d(mo9Var);
                                            so9 so9Var = vo9Var.k;
                                            int r2 = r(so9Var.b, so9Var.c[bArr2[i17 + (iArr2[vo9Var.E + i16] | i18)] & 255], mo9Var);
                                            int i19 = vo9Var.r;
                                            bArr[i19] = (byte) r2;
                                            vo9Var.x++;
                                            vo9Var.r = i19 + 1;
                                            if (i19 == i8) {
                                                vo9Var.b = 6;
                                                vo9Var.Y = vo9Var.Q;
                                                vo9Var.X = 0;
                                                vo9Var.a = 12;
                                            } else {
                                                int i20 = i15;
                                                i15 = r2;
                                                i16 = i20;
                                            }
                                        }
                                    }
                                } else {
                                    while (true) {
                                        if (vo9Var.x < vo9Var.y) {
                                            mo9.j(mo9Var);
                                            if (vo9Var.n[0] == 0) {
                                                f(vo9Var);
                                            }
                                            int[] iArr4 = vo9Var.n;
                                            iArr4[0] = iArr4[0] - 1;
                                            mo9.d(mo9Var);
                                            bArr[vo9Var.r] = (byte) r(vo9Var.k.b, vo9Var.w, mo9Var);
                                            vo9Var.x++;
                                            int i21 = vo9Var.r;
                                            vo9Var.r = i21 + 1;
                                            if (i21 == i8) {
                                                vo9Var.b = 6;
                                                vo9Var.Y = vo9Var.Q;
                                                vo9Var.X = 0;
                                                vo9Var.a = 12;
                                            }
                                        }
                                    }
                                }
                                if (vo9Var.a == 6) {
                                    continue;
                                } else {
                                    int i22 = vo9Var.g - vo9Var.y;
                                    vo9Var.g = i22;
                                    if (i22 <= 0) {
                                        vo9Var.a = 3;
                                        break;
                                    } else {
                                        if (vo9Var.G < 0) {
                                            mo9.j(mo9Var);
                                            if (vo9Var.n[2] == 0) {
                                                e(vo9Var);
                                            }
                                            int[] iArr5 = vo9Var.n;
                                            iArr5[2] = iArr5[2] - 1;
                                            mo9.d(mo9Var);
                                            so9 so9Var2 = vo9Var.m;
                                            int[] iArr6 = so9Var2.b;
                                            int[] iArr7 = so9Var2.c;
                                            byte[] bArr3 = vo9Var.H;
                                            int i23 = vo9Var.C;
                                            int i24 = vo9Var.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], mo9Var);
                                            vo9Var.G = r3;
                                            int i25 = vo9Var.I;
                                            if (r3 >= i25) {
                                                int i26 = r3 - i25;
                                                vo9Var.G = i26;
                                                int i27 = vo9Var.J & i26;
                                                int i28 = i26 >>> vo9Var.K;
                                                vo9Var.G = i28;
                                                int i29 = (i28 >>> 1) + 1;
                                                vo9Var.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + mo9.i(mo9Var, i29)) << vo9Var.K);
                                            }
                                        }
                                        int t = t(vo9Var.G, vo9Var.q, vo9Var.t);
                                        vo9Var.L = t;
                                        if (t >= 0) {
                                            int i30 = vo9Var.s;
                                            int i31 = vo9Var.O;
                                            if (i30 != i31 && (i6 = vo9Var.r) < i31) {
                                                vo9Var.s = i6;
                                            } else {
                                                vo9Var.s = vo9Var.O;
                                            }
                                            vo9Var.N = vo9Var.r;
                                            int i32 = vo9Var.L;
                                            if (i32 > vo9Var.s) {
                                                vo9Var.a = 9;
                                                break;
                                            } else {
                                                if (vo9Var.G > 0) {
                                                    int[] iArr8 = vo9Var.q;
                                                    int i33 = vo9Var.t;
                                                    iArr8[i33 & 3] = i32;
                                                    vo9Var.t = i33 + 1;
                                                }
                                                if (vo9Var.M <= vo9Var.g) {
                                                    vo9Var.x = 0;
                                                    vo9Var.a = 7;
                                                    int i34 = vo9Var.r;
                                                    i = (i34 - vo9Var.L) & i8;
                                                    i2 = vo9Var.M - vo9Var.x;
                                                    if (i + i2 >= i8 && i34 + i2 < i8) {
                                                        while (i10 < i2) {
                                                            bArr[i34] = bArr[i];
                                                            i10++;
                                                            i34++;
                                                            i++;
                                                        }
                                                        vo9Var.x += i2;
                                                        vo9Var.g -= i2;
                                                        vo9Var.r += i2;
                                                    } else {
                                                        do {
                                                            i3 = vo9Var.x;
                                                            if (i3 >= vo9Var.M) {
                                                                i4 = vo9Var.r;
                                                                bArr[i4] = bArr[(i4 - vo9Var.L) & i8];
                                                                vo9Var.g--;
                                                                vo9Var.x = i3 + 1;
                                                                vo9Var.r = i4 + 1;
                                                            }
                                                        } while (i4 != i8);
                                                        i5 = 7;
                                                        vo9Var.b = 7;
                                                        vo9Var.Y = vo9Var.Q;
                                                        vo9Var.X = 0;
                                                        vo9Var.a = 12;
                                                        if (vo9Var.a != i5) {
                                                            break;
                                                        } else {
                                                            vo9Var.a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i5 = 7;
                                                    if (vo9Var.a != i5) {
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
                            if (vo9Var.g > 0) {
                            }
                            break;
                        case 4:
                            while (vo9Var.g > 0) {
                                mo9.j(mo9Var);
                                mo9.i(mo9Var, 8);
                                vo9Var.g--;
                            }
                            vo9Var.a = 1;
                            break;
                        case 5:
                            a(vo9Var);
                            break;
                        case 6:
                            if (vo9Var.u) {
                            }
                            if (vo9Var.a == 6) {
                            }
                            break;
                        case 7:
                            int i342 = vo9Var.r;
                            i = (i342 - vo9Var.L) & i8;
                            i2 = vo9Var.M - vo9Var.x;
                            if (i + i2 >= i8) {
                                break;
                            }
                            do {
                                i3 = vo9Var.x;
                                if (i3 >= vo9Var.M) {
                                }
                            } while (i4 != i8);
                            i5 = 7;
                            vo9Var.b = 7;
                            vo9Var.Y = vo9Var.Q;
                            vo9Var.X = 0;
                            vo9Var.a = 12;
                            if (vo9Var.a != i5) {
                            }
                            break;
                        case 8:
                            int i35 = vo9Var.Q;
                            System.arraycopy(bArr, i35, bArr, 0, vo9Var.N - i35);
                            vo9Var.a = 3;
                            break;
                        case 9:
                            int i36 = vo9Var.M;
                            if (i36 >= 4 && i36 <= 24) {
                                int i37 = qo9.a[i36];
                                int i38 = (vo9Var.L - vo9Var.s) - 1;
                                int i39 = qo9.b[i36];
                                int i40 = ((1 << i39) - 1) & i38;
                                int i41 = i38 >>> i39;
                                int i42 = i37 + (i40 * i36);
                                if (i41 < wo9.d.length) {
                                    int b2 = wo9.b(bArr, vo9Var.N, qo9.a(), i42, vo9Var.M, wo9.d[i41]);
                                    int i43 = vo9Var.N + b2;
                                    vo9Var.N = i43;
                                    vo9Var.r += b2;
                                    vo9Var.g -= b2;
                                    int i44 = vo9Var.Q;
                                    if (i43 >= i44) {
                                        vo9Var.b = 8;
                                        vo9Var.Y = i44;
                                        vo9Var.X = 0;
                                        vo9Var.a = 12;
                                        break;
                                    } else {
                                        vo9Var.a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + vo9Var.a);
                    }
                } else if (!u(vo9Var)) {
                    return;
                } else {
                    int i45 = vo9Var.r;
                    int i46 = vo9Var.O;
                    if (i45 >= i46) {
                        vo9Var.s = i46;
                    }
                    vo9Var.r &= i8;
                    vo9Var.a = vo9Var.b;
                }
            }
        } else {
            throw new IllegalStateException("Can't decompress after close");
        }
    }

    public static void j(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, bArr, i) == null) {
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
    }

    public static void k(vo9 vo9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, vo9Var) == null) {
            int i2 = vo9Var.P;
            long j = vo9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + vo9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!vo9Var.h && i2 < 16384 && vo9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = vo9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = vo9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = vo9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = vo9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(vo9Var.S, i, bArr, 0, i5);
                    vo9Var.r = i5;
                    vo9Var.T = i5;
                }
            }
            vo9Var.d = bArr;
            vo9Var.Q = i2;
        }
    }

    public static void l(int[] iArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, iArr, i) == null) {
            int i2 = iArr[i];
            while (i > 0) {
                iArr[i] = iArr[i - 1];
                i--;
            }
            iArr[0] = i2;
        }
    }

    public static int m(int[] iArr, int i, mo9 mo9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, mo9Var)) == null) {
            mo9.d(mo9Var);
            int r = r(iArr, i, mo9Var);
            return uo9.a[r] + mo9.i(mo9Var, uo9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, mo9 mo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), mo9Var}) != null) {
            return;
        }
        mo9.j(mo9Var);
        int[] iArr2 = new int[i];
        int i3 = mo9.i(mo9Var, 2);
        boolean z = true;
        if (i3 == 1) {
            int i4 = i - 1;
            int[] iArr3 = new int[4];
            int i5 = mo9.i(mo9Var, 2) + 1;
            int i6 = 0;
            while (i4 != 0) {
                i4 >>= 1;
                i6++;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr3[i7] = mo9.i(mo9Var, i6) % i;
                iArr2[iArr3[i7]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i5 != 3) {
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (mo9.i(mo9Var, 1) == 1) {
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
                ro9.a(iArr, i2, 8, iArr2, i);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i8 = 32;
        int i9 = 0;
        while (i3 < 18 && i8 > 0) {
            int i10 = a[i3];
            mo9.d(mo9Var);
            long j = mo9Var.f;
            int i11 = mo9Var.g;
            int i12 = ((int) (j >>> i11)) & 15;
            int[] iArr5 = d;
            mo9Var.g = i11 + (iArr5[i12] >> 16);
            int i13 = iArr5[i12] & 65535;
            iArr4[i10] = i13;
            if (i13 != 0) {
                i8 -= 32 >> i13;
                i9++;
            }
            i3++;
        }
        r5 = (i9 == 1 || i8 == 0) ? true : true;
        o(iArr4, i, iArr2, mo9Var);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.repackage.xo9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, mo9 mo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65551, null, iArr, i, iArr2, mo9Var) != null) {
            return;
        }
        int[] iArr3 = new int[32];
        ro9.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 0;
        int i4 = 32768;
        int i5 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (i3 < i && i4 > 0) {
                mo9.j(mo9Var);
                mo9.d(mo9Var);
                long j = mo9Var.f;
                int i7 = mo9Var.g;
                int i8 = ((int) (j >>> i7)) & 31;
                mo9Var.g = i7 + (iArr3[i8] >> 16);
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
                    int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + mo9.i(mo9Var, i11) + 3;
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

    public static void p(vo9 vo9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, vo9Var) == null) {
            mo9 mo9Var = vo9Var.c;
            for (int i = 0; i < 3; i++) {
                vo9Var.o[i] = h(mo9Var) + 1;
                vo9Var.n[i] = 268435456;
                int[] iArr2 = vo9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, vo9Var.e, i2, mo9Var);
                    n(26, vo9Var.f, i2, mo9Var);
                    vo9Var.n[i] = m(vo9Var.f, i2, mo9Var);
                }
            }
            mo9.j(mo9Var);
            vo9Var.K = mo9.i(mo9Var, 2);
            int i3 = mo9.i(mo9Var, 4);
            int i4 = vo9Var.K;
            int i5 = (i3 << i4) + 16;
            vo9Var.I = i5;
            vo9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            vo9Var.z = new byte[vo9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = vo9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    vo9Var.z[i7] = (byte) (mo9.i(mo9Var, 2) << 1);
                    i7++;
                }
                mo9.j(mo9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            vo9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, mo9Var);
            vo9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (vo9Var.o[0] << 6)) {
                    break;
                } else if (vo9Var.A[i8] != (i8 >> 6)) {
                    vo9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = vo9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            vo9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, mo9Var);
            so9.b(vo9Var.k, 256, d2);
            so9.b(vo9Var.l, 704, vo9Var.o[1]);
            so9.b(vo9Var.m, i6, d3);
            so9.a(vo9Var.k, mo9Var);
            so9.a(vo9Var.l, mo9Var);
            so9.a(vo9Var.m, mo9Var);
            vo9Var.B = 0;
            vo9Var.C = 0;
            int[] iArr4 = oo9.b;
            byte[] bArr3 = vo9Var.z;
            vo9Var.D = iArr4[bArr3[0]];
            vo9Var.E = iArr4[bArr3[0] + 1];
            vo9Var.v = 0;
            vo9Var.w = vo9Var.k.c[0];
            vo9Var.F = vo9Var.l.c[0];
            int[] iArr5 = vo9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, vo9Var) == null) {
            mo9 mo9Var = vo9Var.c;
            if (vo9Var.h) {
                vo9Var.b = 10;
                vo9Var.Y = vo9Var.r;
                vo9Var.X = 0;
                vo9Var.a = 12;
                return;
            }
            so9 so9Var = vo9Var.k;
            so9Var.b = null;
            so9Var.c = null;
            so9 so9Var2 = vo9Var.l;
            so9Var2.b = null;
            so9Var2.c = null;
            so9 so9Var3 = vo9Var.m;
            so9Var3.b = null;
            so9Var3.c = null;
            mo9.j(mo9Var);
            g(mo9Var, vo9Var);
            if (vo9Var.g != 0 || vo9Var.j) {
                if (!vo9Var.i && !vo9Var.j) {
                    vo9Var.a = 2;
                } else {
                    mo9.g(mo9Var);
                    vo9Var.a = vo9Var.j ? 4 : 5;
                }
                if (vo9Var.j) {
                    return;
                }
                vo9Var.R += vo9Var.g;
                if (vo9Var.Q < vo9Var.P) {
                    k(vo9Var);
                }
            }
        }
    }

    public static int r(int[] iArr, int i, mo9 mo9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, mo9Var)) == null) {
            long j = mo9Var.f;
            int i2 = mo9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                mo9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            mo9Var.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static void s(vo9 vo9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, vo9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            vo9Var.S = bArr;
        }
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) ? i < 16 ? iArr[(i2 + b[i]) & 3] + c[i] : (i - 16) + 1 : invokeCommon.intValue;
    }

    public static boolean u(vo9 vo9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, vo9Var)) == null) {
            int i = vo9Var.T;
            if (i != 0) {
                vo9Var.X += i;
                vo9Var.T = 0;
            }
            int min = Math.min(vo9Var.V - vo9Var.W, vo9Var.Y - vo9Var.X);
            if (min != 0) {
                System.arraycopy(vo9Var.d, vo9Var.X, vo9Var.Z, vo9Var.U + vo9Var.W, min);
                vo9Var.W += min;
                vo9Var.X += min;
            }
            return vo9Var.W < vo9Var.V;
        }
        return invokeL.booleanValue;
    }
}
