package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class ru9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755337701, "Lcom/repackage/ru9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755337701, "Lcom/repackage/ru9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, xu9Var) == null) {
            ou9 ou9Var = xu9Var.c;
            byte[] bArr = xu9Var.d;
            int i = xu9Var.g;
            if (i <= 0) {
                ou9.k(ou9Var);
                xu9Var.a = 1;
                return;
            }
            int min = Math.min(xu9Var.Q - xu9Var.r, i);
            ou9.c(ou9Var, bArr, xu9Var.r, min);
            xu9Var.g -= min;
            int i2 = xu9Var.r + min;
            xu9Var.r = i2;
            int i3 = xu9Var.Q;
            if (i2 == i3) {
                xu9Var.b = 5;
                xu9Var.Y = i3;
                xu9Var.X = 0;
                xu9Var.a = 12;
                return;
            }
            ou9.k(ou9Var);
            xu9Var.a = 1;
        }
    }

    public static void b(xu9 xu9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, xu9Var, i) == null) {
            ou9 ou9Var = xu9Var.c;
            int[] iArr = xu9Var.p;
            int i3 = i * 2;
            ou9.d(ou9Var);
            int i4 = i * 1080;
            int r = r(xu9Var.e, i4, ou9Var);
            xu9Var.n[i] = m(xu9Var.f, i4, ou9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else {
                i2 = r == 0 ? iArr[i3] : r - 2;
            }
            int[] iArr2 = xu9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xu9Var) == null) {
            b(xu9Var, 1);
            xu9Var.F = xu9Var.l.c[xu9Var.p[3]];
        }
    }

    public static int d(int i, byte[] bArr, ou9 ou9Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, ou9Var)) == null) {
            ou9.j(ou9Var);
            int h = h(ou9Var) + 1;
            if (h == 1) {
                zu9.a(bArr, 0, i);
                return h;
            }
            int i2 = ou9.i(ou9Var, 1) == 1 ? ou9.i(ou9Var, 4) + 1 : 0;
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, ou9Var);
            int i3 = 0;
            while (i3 < i) {
                ou9.j(ou9Var);
                ou9.d(ou9Var);
                int r = r(iArr, 0, ou9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + ou9.i(ou9Var, r); i4 != 0; i4--) {
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
            if (ou9.i(ou9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void e(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, xu9Var) == null) {
            b(xu9Var, 2);
            xu9Var.C = xu9Var.p[5] << 2;
        }
    }

    public static void f(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, xu9Var) == null) {
            b(xu9Var, 0);
            int i = xu9Var.p[1];
            int i2 = i << 6;
            xu9Var.B = i2;
            int i3 = xu9Var.A[i2] & 255;
            xu9Var.v = i3;
            xu9Var.w = xu9Var.k.c[i3];
            byte b2 = xu9Var.z[i];
            int[] iArr = qu9.b;
            xu9Var.D = iArr[b2];
            xu9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(ou9 ou9Var, xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ou9Var, xu9Var) == null) {
            boolean z = ou9.i(ou9Var, 1) == 1;
            xu9Var.h = z;
            xu9Var.g = 0;
            xu9Var.i = false;
            xu9Var.j = false;
            if (!z || ou9.i(ou9Var, 1) == 0) {
                int i = ou9.i(ou9Var, 2) + 4;
                if (i == 7) {
                    xu9Var.j = true;
                    if (ou9.i(ou9Var, 1) == 0) {
                        int i2 = ou9.i(ou9Var, 2);
                        if (i2 == 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < i2; i3++) {
                            int i4 = ou9.i(ou9Var, 8);
                            if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                                throw new BrotliRuntimeException("Exuberant nibble");
                            }
                            xu9Var.g = (i4 << (i3 * 8)) | xu9Var.g;
                        }
                    } else {
                        throw new BrotliRuntimeException("Corrupted reserved bit");
                    }
                } else {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = ou9.i(ou9Var, 4);
                        if (i6 == 0 && i5 + 1 == i && i > 4) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        xu9Var.g = (i6 << (i5 * 4)) | xu9Var.g;
                    }
                }
                xu9Var.g++;
                if (xu9Var.h) {
                    return;
                }
                xu9Var.i = ou9.i(ou9Var, 1) == 1;
            }
        }
    }

    public static int h(ou9 ou9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ou9Var)) == null) {
            if (ou9.i(ou9Var, 1) != 0) {
                int i = ou9.i(ou9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return ou9.i(ou9Var, i) + (1 << i);
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
    public static void i(xu9 xu9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, xu9Var) != null) {
            return;
        }
        int i7 = xu9Var.a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 != 11) {
            ou9 ou9Var = xu9Var.c;
            int i8 = xu9Var.Q - 1;
            byte[] bArr = xu9Var.d;
            while (true) {
                int i9 = xu9Var.a;
                if (i9 == 10) {
                    if (i9 == 10) {
                        if (xu9Var.g >= 0) {
                            ou9.g(ou9Var);
                            ou9.a(xu9Var.c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i9 != 12) {
                    int i10 = 0;
                    switch (i9) {
                        case 1:
                            if (xu9Var.g >= 0) {
                                q(xu9Var);
                                i8 = xu9Var.Q - 1;
                                bArr = xu9Var.d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(xu9Var);
                            xu9Var.a = 3;
                            if (xu9Var.g > 0) {
                                xu9Var.a = 1;
                                break;
                            } else {
                                ou9.j(ou9Var);
                                if (xu9Var.n[1] == 0) {
                                    c(xu9Var);
                                }
                                int[] iArr = xu9Var.n;
                                iArr[1] = iArr[1] - 1;
                                ou9.d(ou9Var);
                                int r = r(xu9Var.l.b, xu9Var.F, ou9Var);
                                int i11 = r >>> 6;
                                xu9Var.G = 0;
                                if (i11 >= 2) {
                                    i11 -= 2;
                                    xu9Var.G = -1;
                                }
                                int i12 = wu9.g[i11] + ((r >>> 3) & 7);
                                int i13 = wu9.h[i11] + (r & 7);
                                xu9Var.y = wu9.c[i12] + ou9.i(ou9Var, wu9.d[i12]);
                                xu9Var.M = wu9.e[i13] + ou9.i(ou9Var, wu9.f[i13]);
                                xu9Var.x = 0;
                                xu9Var.a = 6;
                                if (xu9Var.u) {
                                    int i14 = xu9Var.r;
                                    int i15 = bArr[(i14 - 1) & i8] & 255;
                                    int i16 = bArr[(i14 - 2) & i8] & 255;
                                    while (true) {
                                        if (xu9Var.x < xu9Var.y) {
                                            ou9.j(ou9Var);
                                            if (xu9Var.n[0] == 0) {
                                                f(xu9Var);
                                            }
                                            byte[] bArr2 = xu9Var.A;
                                            int i17 = xu9Var.B;
                                            int[] iArr2 = qu9.a;
                                            int i18 = iArr2[xu9Var.D + i15];
                                            int[] iArr3 = xu9Var.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            ou9.d(ou9Var);
                                            uu9 uu9Var = xu9Var.k;
                                            int r2 = r(uu9Var.b, uu9Var.c[bArr2[i17 + (iArr2[xu9Var.E + i16] | i18)] & 255], ou9Var);
                                            int i19 = xu9Var.r;
                                            bArr[i19] = (byte) r2;
                                            xu9Var.x++;
                                            xu9Var.r = i19 + 1;
                                            if (i19 == i8) {
                                                xu9Var.b = 6;
                                                xu9Var.Y = xu9Var.Q;
                                                xu9Var.X = 0;
                                                xu9Var.a = 12;
                                            } else {
                                                int i20 = i15;
                                                i15 = r2;
                                                i16 = i20;
                                            }
                                        }
                                    }
                                } else {
                                    while (true) {
                                        if (xu9Var.x < xu9Var.y) {
                                            ou9.j(ou9Var);
                                            if (xu9Var.n[0] == 0) {
                                                f(xu9Var);
                                            }
                                            int[] iArr4 = xu9Var.n;
                                            iArr4[0] = iArr4[0] - 1;
                                            ou9.d(ou9Var);
                                            bArr[xu9Var.r] = (byte) r(xu9Var.k.b, xu9Var.w, ou9Var);
                                            xu9Var.x++;
                                            int i21 = xu9Var.r;
                                            xu9Var.r = i21 + 1;
                                            if (i21 == i8) {
                                                xu9Var.b = 6;
                                                xu9Var.Y = xu9Var.Q;
                                                xu9Var.X = 0;
                                                xu9Var.a = 12;
                                            }
                                        }
                                    }
                                }
                                if (xu9Var.a == 6) {
                                    continue;
                                } else {
                                    int i22 = xu9Var.g - xu9Var.y;
                                    xu9Var.g = i22;
                                    if (i22 <= 0) {
                                        xu9Var.a = 3;
                                        break;
                                    } else {
                                        if (xu9Var.G < 0) {
                                            ou9.j(ou9Var);
                                            if (xu9Var.n[2] == 0) {
                                                e(xu9Var);
                                            }
                                            int[] iArr5 = xu9Var.n;
                                            iArr5[2] = iArr5[2] - 1;
                                            ou9.d(ou9Var);
                                            uu9 uu9Var2 = xu9Var.m;
                                            int[] iArr6 = uu9Var2.b;
                                            int[] iArr7 = uu9Var2.c;
                                            byte[] bArr3 = xu9Var.H;
                                            int i23 = xu9Var.C;
                                            int i24 = xu9Var.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], ou9Var);
                                            xu9Var.G = r3;
                                            int i25 = xu9Var.I;
                                            if (r3 >= i25) {
                                                int i26 = r3 - i25;
                                                xu9Var.G = i26;
                                                int i27 = xu9Var.J & i26;
                                                int i28 = i26 >>> xu9Var.K;
                                                xu9Var.G = i28;
                                                int i29 = (i28 >>> 1) + 1;
                                                xu9Var.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + ou9.i(ou9Var, i29)) << xu9Var.K);
                                            }
                                        }
                                        int t = t(xu9Var.G, xu9Var.q, xu9Var.t);
                                        xu9Var.L = t;
                                        if (t >= 0) {
                                            int i30 = xu9Var.s;
                                            int i31 = xu9Var.O;
                                            if (i30 != i31 && (i6 = xu9Var.r) < i31) {
                                                xu9Var.s = i6;
                                            } else {
                                                xu9Var.s = xu9Var.O;
                                            }
                                            xu9Var.N = xu9Var.r;
                                            int i32 = xu9Var.L;
                                            if (i32 > xu9Var.s) {
                                                xu9Var.a = 9;
                                                break;
                                            } else {
                                                if (xu9Var.G > 0) {
                                                    int[] iArr8 = xu9Var.q;
                                                    int i33 = xu9Var.t;
                                                    iArr8[i33 & 3] = i32;
                                                    xu9Var.t = i33 + 1;
                                                }
                                                if (xu9Var.M <= xu9Var.g) {
                                                    xu9Var.x = 0;
                                                    xu9Var.a = 7;
                                                    int i34 = xu9Var.r;
                                                    i = (i34 - xu9Var.L) & i8;
                                                    i2 = xu9Var.M - xu9Var.x;
                                                    if (i + i2 >= i8 && i34 + i2 < i8) {
                                                        while (i10 < i2) {
                                                            bArr[i34] = bArr[i];
                                                            i10++;
                                                            i34++;
                                                            i++;
                                                        }
                                                        xu9Var.x += i2;
                                                        xu9Var.g -= i2;
                                                        xu9Var.r += i2;
                                                    } else {
                                                        do {
                                                            i3 = xu9Var.x;
                                                            if (i3 >= xu9Var.M) {
                                                                i4 = xu9Var.r;
                                                                bArr[i4] = bArr[(i4 - xu9Var.L) & i8];
                                                                xu9Var.g--;
                                                                xu9Var.x = i3 + 1;
                                                                xu9Var.r = i4 + 1;
                                                            }
                                                        } while (i4 != i8);
                                                        i5 = 7;
                                                        xu9Var.b = 7;
                                                        xu9Var.Y = xu9Var.Q;
                                                        xu9Var.X = 0;
                                                        xu9Var.a = 12;
                                                        if (xu9Var.a != i5) {
                                                            break;
                                                        } else {
                                                            xu9Var.a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i5 = 7;
                                                    if (xu9Var.a != i5) {
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
                            if (xu9Var.g > 0) {
                            }
                            break;
                        case 4:
                            while (xu9Var.g > 0) {
                                ou9.j(ou9Var);
                                ou9.i(ou9Var, 8);
                                xu9Var.g--;
                            }
                            xu9Var.a = 1;
                            break;
                        case 5:
                            a(xu9Var);
                            break;
                        case 6:
                            if (xu9Var.u) {
                            }
                            if (xu9Var.a == 6) {
                            }
                            break;
                        case 7:
                            int i342 = xu9Var.r;
                            i = (i342 - xu9Var.L) & i8;
                            i2 = xu9Var.M - xu9Var.x;
                            if (i + i2 >= i8) {
                                break;
                            }
                            do {
                                i3 = xu9Var.x;
                                if (i3 >= xu9Var.M) {
                                }
                            } while (i4 != i8);
                            i5 = 7;
                            xu9Var.b = 7;
                            xu9Var.Y = xu9Var.Q;
                            xu9Var.X = 0;
                            xu9Var.a = 12;
                            if (xu9Var.a != i5) {
                            }
                            break;
                        case 8:
                            int i35 = xu9Var.Q;
                            System.arraycopy(bArr, i35, bArr, 0, xu9Var.N - i35);
                            xu9Var.a = 3;
                            break;
                        case 9:
                            int i36 = xu9Var.M;
                            if (i36 >= 4 && i36 <= 24) {
                                int i37 = su9.a[i36];
                                int i38 = (xu9Var.L - xu9Var.s) - 1;
                                int i39 = su9.b[i36];
                                int i40 = ((1 << i39) - 1) & i38;
                                int i41 = i38 >>> i39;
                                int i42 = i37 + (i40 * i36);
                                if (i41 < yu9.d.length) {
                                    int b2 = yu9.b(bArr, xu9Var.N, su9.a(), i42, xu9Var.M, yu9.d[i41]);
                                    int i43 = xu9Var.N + b2;
                                    xu9Var.N = i43;
                                    xu9Var.r += b2;
                                    xu9Var.g -= b2;
                                    int i44 = xu9Var.Q;
                                    if (i43 >= i44) {
                                        xu9Var.b = 8;
                                        xu9Var.Y = i44;
                                        xu9Var.X = 0;
                                        xu9Var.a = 12;
                                        break;
                                    } else {
                                        xu9Var.a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + xu9Var.a);
                    }
                } else if (!u(xu9Var)) {
                    return;
                } else {
                    int i45 = xu9Var.r;
                    int i46 = xu9Var.O;
                    if (i45 >= i46) {
                        xu9Var.s = i46;
                    }
                    xu9Var.r &= i8;
                    xu9Var.a = xu9Var.b;
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

    public static void k(xu9 xu9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, xu9Var) == null) {
            int i2 = xu9Var.P;
            long j = xu9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + xu9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!xu9Var.h && i2 < 16384 && xu9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = xu9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = xu9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = xu9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = xu9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(xu9Var.S, i, bArr, 0, i5);
                    xu9Var.r = i5;
                    xu9Var.T = i5;
                }
            }
            xu9Var.d = bArr;
            xu9Var.Q = i2;
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

    public static int m(int[] iArr, int i, ou9 ou9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, ou9Var)) == null) {
            ou9.d(ou9Var);
            int r = r(iArr, i, ou9Var);
            return wu9.a[r] + ou9.i(ou9Var, wu9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, ou9 ou9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), ou9Var}) != null) {
            return;
        }
        ou9.j(ou9Var);
        int[] iArr2 = new int[i];
        int i3 = ou9.i(ou9Var, 2);
        boolean z = true;
        if (i3 == 1) {
            int i4 = i - 1;
            int[] iArr3 = new int[4];
            int i5 = ou9.i(ou9Var, 2) + 1;
            int i6 = 0;
            while (i4 != 0) {
                i4 >>= 1;
                i6++;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr3[i7] = ou9.i(ou9Var, i6) % i;
                iArr2[iArr3[i7]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i5 != 3) {
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (ou9.i(ou9Var, 1) == 1) {
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
                tu9.a(iArr, i2, 8, iArr2, i);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i8 = 32;
        int i9 = 0;
        while (i3 < 18 && i8 > 0) {
            int i10 = a[i3];
            ou9.d(ou9Var);
            long j = ou9Var.f;
            int i11 = ou9Var.g;
            int i12 = ((int) (j >>> i11)) & 15;
            int[] iArr5 = d;
            ou9Var.g = i11 + (iArr5[i12] >> 16);
            int i13 = iArr5[i12] & 65535;
            iArr4[i10] = i13;
            if (i13 != 0) {
                i8 -= 32 >> i13;
                i9++;
            }
            i3++;
        }
        r5 = (i9 == 1 || i8 == 0) ? true : true;
        o(iArr4, i, iArr2, ou9Var);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.repackage.zu9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, ou9 ou9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65551, null, iArr, i, iArr2, ou9Var) != null) {
            return;
        }
        int[] iArr3 = new int[32];
        tu9.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 0;
        int i4 = 32768;
        int i5 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (i3 < i && i4 > 0) {
                ou9.j(ou9Var);
                ou9.d(ou9Var);
                long j = ou9Var.f;
                int i7 = ou9Var.g;
                int i8 = ((int) (j >>> i7)) & 31;
                ou9Var.g = i7 + (iArr3[i8] >> 16);
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
                    int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + ou9.i(ou9Var, i11) + 3;
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

    public static void p(xu9 xu9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, xu9Var) == null) {
            ou9 ou9Var = xu9Var.c;
            for (int i = 0; i < 3; i++) {
                xu9Var.o[i] = h(ou9Var) + 1;
                xu9Var.n[i] = 268435456;
                int[] iArr2 = xu9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, xu9Var.e, i2, ou9Var);
                    n(26, xu9Var.f, i2, ou9Var);
                    xu9Var.n[i] = m(xu9Var.f, i2, ou9Var);
                }
            }
            ou9.j(ou9Var);
            xu9Var.K = ou9.i(ou9Var, 2);
            int i3 = ou9.i(ou9Var, 4);
            int i4 = xu9Var.K;
            int i5 = (i3 << i4) + 16;
            xu9Var.I = i5;
            xu9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            xu9Var.z = new byte[xu9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = xu9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    xu9Var.z[i7] = (byte) (ou9.i(ou9Var, 2) << 1);
                    i7++;
                }
                ou9.j(ou9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            xu9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, ou9Var);
            xu9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (xu9Var.o[0] << 6)) {
                    break;
                } else if (xu9Var.A[i8] != (i8 >> 6)) {
                    xu9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = xu9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            xu9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, ou9Var);
            uu9.b(xu9Var.k, 256, d2);
            uu9.b(xu9Var.l, 704, xu9Var.o[1]);
            uu9.b(xu9Var.m, i6, d3);
            uu9.a(xu9Var.k, ou9Var);
            uu9.a(xu9Var.l, ou9Var);
            uu9.a(xu9Var.m, ou9Var);
            xu9Var.B = 0;
            xu9Var.C = 0;
            int[] iArr4 = qu9.b;
            byte[] bArr3 = xu9Var.z;
            xu9Var.D = iArr4[bArr3[0]];
            xu9Var.E = iArr4[bArr3[0] + 1];
            xu9Var.v = 0;
            xu9Var.w = xu9Var.k.c[0];
            xu9Var.F = xu9Var.l.c[0];
            int[] iArr5 = xu9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, xu9Var) == null) {
            ou9 ou9Var = xu9Var.c;
            if (xu9Var.h) {
                xu9Var.b = 10;
                xu9Var.Y = xu9Var.r;
                xu9Var.X = 0;
                xu9Var.a = 12;
                return;
            }
            uu9 uu9Var = xu9Var.k;
            uu9Var.b = null;
            uu9Var.c = null;
            uu9 uu9Var2 = xu9Var.l;
            uu9Var2.b = null;
            uu9Var2.c = null;
            uu9 uu9Var3 = xu9Var.m;
            uu9Var3.b = null;
            uu9Var3.c = null;
            ou9.j(ou9Var);
            g(ou9Var, xu9Var);
            if (xu9Var.g != 0 || xu9Var.j) {
                if (!xu9Var.i && !xu9Var.j) {
                    xu9Var.a = 2;
                } else {
                    ou9.g(ou9Var);
                    xu9Var.a = xu9Var.j ? 4 : 5;
                }
                if (xu9Var.j) {
                    return;
                }
                xu9Var.R += xu9Var.g;
                if (xu9Var.Q < xu9Var.P) {
                    k(xu9Var);
                }
            }
        }
    }

    public static int r(int[] iArr, int i, ou9 ou9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, ou9Var)) == null) {
            long j = ou9Var.f;
            int i2 = ou9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                ou9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            ou9Var.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static void s(xu9 xu9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, xu9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            xu9Var.S = bArr;
        }
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) ? i < 16 ? iArr[(i2 + b[i]) & 3] + c[i] : (i - 16) + 1 : invokeCommon.intValue;
    }

    public static boolean u(xu9 xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, xu9Var)) == null) {
            int i = xu9Var.T;
            if (i != 0) {
                xu9Var.X += i;
                xu9Var.T = 0;
            }
            int min = Math.min(xu9Var.V - xu9Var.W, xu9Var.Y - xu9Var.X);
            if (min != 0) {
                System.arraycopy(xu9Var.d, xu9Var.X, xu9Var.Z, xu9Var.U + xu9Var.W, min);
                xu9Var.W += min;
                xu9Var.X += min;
            }
            return xu9Var.W < xu9Var.V;
        }
        return invokeL.booleanValue;
    }
}
