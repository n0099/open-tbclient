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
public final class wv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755187785, "Lcom/repackage/wv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755187785, "Lcom/repackage/wv9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cw9Var) == null) {
            tv9 tv9Var = cw9Var.c;
            byte[] bArr = cw9Var.d;
            int i = cw9Var.g;
            if (i <= 0) {
                tv9.k(tv9Var);
                cw9Var.a = 1;
                return;
            }
            int min = Math.min(cw9Var.Q - cw9Var.r, i);
            tv9.c(tv9Var, bArr, cw9Var.r, min);
            cw9Var.g -= min;
            int i2 = cw9Var.r + min;
            cw9Var.r = i2;
            int i3 = cw9Var.Q;
            if (i2 == i3) {
                cw9Var.b = 5;
                cw9Var.Y = i3;
                cw9Var.X = 0;
                cw9Var.a = 12;
                return;
            }
            tv9.k(tv9Var);
            cw9Var.a = 1;
        }
    }

    public static void b(cw9 cw9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, cw9Var, i) == null) {
            tv9 tv9Var = cw9Var.c;
            int[] iArr = cw9Var.p;
            int i3 = i * 2;
            tv9.d(tv9Var);
            int i4 = i * 1080;
            int r = r(cw9Var.e, i4, tv9Var);
            cw9Var.n[i] = m(cw9Var.f, i4, tv9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else {
                i2 = r == 0 ? iArr[i3] : r - 2;
            }
            int[] iArr2 = cw9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cw9Var) == null) {
            b(cw9Var, 1);
            cw9Var.F = cw9Var.l.c[cw9Var.p[3]];
        }
    }

    public static int d(int i, byte[] bArr, tv9 tv9Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, tv9Var)) == null) {
            tv9.j(tv9Var);
            int h = h(tv9Var) + 1;
            if (h == 1) {
                ew9.a(bArr, 0, i);
                return h;
            }
            int i2 = tv9.i(tv9Var, 1) == 1 ? tv9.i(tv9Var, 4) + 1 : 0;
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, tv9Var);
            int i3 = 0;
            while (i3 < i) {
                tv9.j(tv9Var);
                tv9.d(tv9Var);
                int r = r(iArr, 0, tv9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + tv9.i(tv9Var, r); i4 != 0; i4--) {
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
            if (tv9.i(tv9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void e(cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cw9Var) == null) {
            b(cw9Var, 2);
            cw9Var.C = cw9Var.p[5] << 2;
        }
    }

    public static void f(cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, cw9Var) == null) {
            b(cw9Var, 0);
            int i = cw9Var.p[1];
            int i2 = i << 6;
            cw9Var.B = i2;
            int i3 = cw9Var.A[i2] & 255;
            cw9Var.v = i3;
            cw9Var.w = cw9Var.k.c[i3];
            byte b2 = cw9Var.z[i];
            int[] iArr = vv9.b;
            cw9Var.D = iArr[b2];
            cw9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(tv9 tv9Var, cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tv9Var, cw9Var) == null) {
            boolean z = tv9.i(tv9Var, 1) == 1;
            cw9Var.h = z;
            cw9Var.g = 0;
            cw9Var.i = false;
            cw9Var.j = false;
            if (!z || tv9.i(tv9Var, 1) == 0) {
                int i = tv9.i(tv9Var, 2) + 4;
                if (i == 7) {
                    cw9Var.j = true;
                    if (tv9.i(tv9Var, 1) == 0) {
                        int i2 = tv9.i(tv9Var, 2);
                        if (i2 == 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < i2; i3++) {
                            int i4 = tv9.i(tv9Var, 8);
                            if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                                throw new BrotliRuntimeException("Exuberant nibble");
                            }
                            cw9Var.g = (i4 << (i3 * 8)) | cw9Var.g;
                        }
                    } else {
                        throw new BrotliRuntimeException("Corrupted reserved bit");
                    }
                } else {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = tv9.i(tv9Var, 4);
                        if (i6 == 0 && i5 + 1 == i && i > 4) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        cw9Var.g = (i6 << (i5 * 4)) | cw9Var.g;
                    }
                }
                cw9Var.g++;
                if (cw9Var.h) {
                    return;
                }
                cw9Var.i = tv9.i(tv9Var, 1) == 1;
            }
        }
    }

    public static int h(tv9 tv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tv9Var)) == null) {
            if (tv9.i(tv9Var, 1) != 0) {
                int i = tv9.i(tv9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return tv9.i(tv9Var, i) + (1 << i);
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
    public static void i(cw9 cw9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, cw9Var) != null) {
            return;
        }
        int i7 = cw9Var.a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 != 11) {
            tv9 tv9Var = cw9Var.c;
            int i8 = cw9Var.Q - 1;
            byte[] bArr = cw9Var.d;
            while (true) {
                int i9 = cw9Var.a;
                if (i9 == 10) {
                    if (i9 == 10) {
                        if (cw9Var.g >= 0) {
                            tv9.g(tv9Var);
                            tv9.a(cw9Var.c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i9 != 12) {
                    int i10 = 0;
                    switch (i9) {
                        case 1:
                            if (cw9Var.g >= 0) {
                                q(cw9Var);
                                i8 = cw9Var.Q - 1;
                                bArr = cw9Var.d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(cw9Var);
                            cw9Var.a = 3;
                            if (cw9Var.g > 0) {
                                cw9Var.a = 1;
                                break;
                            } else {
                                tv9.j(tv9Var);
                                if (cw9Var.n[1] == 0) {
                                    c(cw9Var);
                                }
                                int[] iArr = cw9Var.n;
                                iArr[1] = iArr[1] - 1;
                                tv9.d(tv9Var);
                                int r = r(cw9Var.l.b, cw9Var.F, tv9Var);
                                int i11 = r >>> 6;
                                cw9Var.G = 0;
                                if (i11 >= 2) {
                                    i11 -= 2;
                                    cw9Var.G = -1;
                                }
                                int i12 = bw9.g[i11] + ((r >>> 3) & 7);
                                int i13 = bw9.h[i11] + (r & 7);
                                cw9Var.y = bw9.c[i12] + tv9.i(tv9Var, bw9.d[i12]);
                                cw9Var.M = bw9.e[i13] + tv9.i(tv9Var, bw9.f[i13]);
                                cw9Var.x = 0;
                                cw9Var.a = 6;
                                if (cw9Var.u) {
                                    int i14 = cw9Var.r;
                                    int i15 = bArr[(i14 - 1) & i8] & 255;
                                    int i16 = bArr[(i14 - 2) & i8] & 255;
                                    while (true) {
                                        if (cw9Var.x < cw9Var.y) {
                                            tv9.j(tv9Var);
                                            if (cw9Var.n[0] == 0) {
                                                f(cw9Var);
                                            }
                                            byte[] bArr2 = cw9Var.A;
                                            int i17 = cw9Var.B;
                                            int[] iArr2 = vv9.a;
                                            int i18 = iArr2[cw9Var.D + i15];
                                            int[] iArr3 = cw9Var.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            tv9.d(tv9Var);
                                            zv9 zv9Var = cw9Var.k;
                                            int r2 = r(zv9Var.b, zv9Var.c[bArr2[i17 + (iArr2[cw9Var.E + i16] | i18)] & 255], tv9Var);
                                            int i19 = cw9Var.r;
                                            bArr[i19] = (byte) r2;
                                            cw9Var.x++;
                                            cw9Var.r = i19 + 1;
                                            if (i19 == i8) {
                                                cw9Var.b = 6;
                                                cw9Var.Y = cw9Var.Q;
                                                cw9Var.X = 0;
                                                cw9Var.a = 12;
                                            } else {
                                                int i20 = i15;
                                                i15 = r2;
                                                i16 = i20;
                                            }
                                        }
                                    }
                                } else {
                                    while (true) {
                                        if (cw9Var.x < cw9Var.y) {
                                            tv9.j(tv9Var);
                                            if (cw9Var.n[0] == 0) {
                                                f(cw9Var);
                                            }
                                            int[] iArr4 = cw9Var.n;
                                            iArr4[0] = iArr4[0] - 1;
                                            tv9.d(tv9Var);
                                            bArr[cw9Var.r] = (byte) r(cw9Var.k.b, cw9Var.w, tv9Var);
                                            cw9Var.x++;
                                            int i21 = cw9Var.r;
                                            cw9Var.r = i21 + 1;
                                            if (i21 == i8) {
                                                cw9Var.b = 6;
                                                cw9Var.Y = cw9Var.Q;
                                                cw9Var.X = 0;
                                                cw9Var.a = 12;
                                            }
                                        }
                                    }
                                }
                                if (cw9Var.a == 6) {
                                    continue;
                                } else {
                                    int i22 = cw9Var.g - cw9Var.y;
                                    cw9Var.g = i22;
                                    if (i22 <= 0) {
                                        cw9Var.a = 3;
                                        break;
                                    } else {
                                        if (cw9Var.G < 0) {
                                            tv9.j(tv9Var);
                                            if (cw9Var.n[2] == 0) {
                                                e(cw9Var);
                                            }
                                            int[] iArr5 = cw9Var.n;
                                            iArr5[2] = iArr5[2] - 1;
                                            tv9.d(tv9Var);
                                            zv9 zv9Var2 = cw9Var.m;
                                            int[] iArr6 = zv9Var2.b;
                                            int[] iArr7 = zv9Var2.c;
                                            byte[] bArr3 = cw9Var.H;
                                            int i23 = cw9Var.C;
                                            int i24 = cw9Var.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], tv9Var);
                                            cw9Var.G = r3;
                                            int i25 = cw9Var.I;
                                            if (r3 >= i25) {
                                                int i26 = r3 - i25;
                                                cw9Var.G = i26;
                                                int i27 = cw9Var.J & i26;
                                                int i28 = i26 >>> cw9Var.K;
                                                cw9Var.G = i28;
                                                int i29 = (i28 >>> 1) + 1;
                                                cw9Var.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + tv9.i(tv9Var, i29)) << cw9Var.K);
                                            }
                                        }
                                        int t = t(cw9Var.G, cw9Var.q, cw9Var.t);
                                        cw9Var.L = t;
                                        if (t >= 0) {
                                            int i30 = cw9Var.s;
                                            int i31 = cw9Var.O;
                                            if (i30 != i31 && (i6 = cw9Var.r) < i31) {
                                                cw9Var.s = i6;
                                            } else {
                                                cw9Var.s = cw9Var.O;
                                            }
                                            cw9Var.N = cw9Var.r;
                                            int i32 = cw9Var.L;
                                            if (i32 > cw9Var.s) {
                                                cw9Var.a = 9;
                                                break;
                                            } else {
                                                if (cw9Var.G > 0) {
                                                    int[] iArr8 = cw9Var.q;
                                                    int i33 = cw9Var.t;
                                                    iArr8[i33 & 3] = i32;
                                                    cw9Var.t = i33 + 1;
                                                }
                                                if (cw9Var.M <= cw9Var.g) {
                                                    cw9Var.x = 0;
                                                    cw9Var.a = 7;
                                                    int i34 = cw9Var.r;
                                                    i = (i34 - cw9Var.L) & i8;
                                                    i2 = cw9Var.M - cw9Var.x;
                                                    if (i + i2 >= i8 && i34 + i2 < i8) {
                                                        while (i10 < i2) {
                                                            bArr[i34] = bArr[i];
                                                            i10++;
                                                            i34++;
                                                            i++;
                                                        }
                                                        cw9Var.x += i2;
                                                        cw9Var.g -= i2;
                                                        cw9Var.r += i2;
                                                    } else {
                                                        do {
                                                            i3 = cw9Var.x;
                                                            if (i3 >= cw9Var.M) {
                                                                i4 = cw9Var.r;
                                                                bArr[i4] = bArr[(i4 - cw9Var.L) & i8];
                                                                cw9Var.g--;
                                                                cw9Var.x = i3 + 1;
                                                                cw9Var.r = i4 + 1;
                                                            }
                                                        } while (i4 != i8);
                                                        i5 = 7;
                                                        cw9Var.b = 7;
                                                        cw9Var.Y = cw9Var.Q;
                                                        cw9Var.X = 0;
                                                        cw9Var.a = 12;
                                                        if (cw9Var.a != i5) {
                                                            break;
                                                        } else {
                                                            cw9Var.a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i5 = 7;
                                                    if (cw9Var.a != i5) {
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
                            if (cw9Var.g > 0) {
                            }
                            break;
                        case 4:
                            while (cw9Var.g > 0) {
                                tv9.j(tv9Var);
                                tv9.i(tv9Var, 8);
                                cw9Var.g--;
                            }
                            cw9Var.a = 1;
                            break;
                        case 5:
                            a(cw9Var);
                            break;
                        case 6:
                            if (cw9Var.u) {
                            }
                            if (cw9Var.a == 6) {
                            }
                            break;
                        case 7:
                            int i342 = cw9Var.r;
                            i = (i342 - cw9Var.L) & i8;
                            i2 = cw9Var.M - cw9Var.x;
                            if (i + i2 >= i8) {
                                break;
                            }
                            do {
                                i3 = cw9Var.x;
                                if (i3 >= cw9Var.M) {
                                }
                            } while (i4 != i8);
                            i5 = 7;
                            cw9Var.b = 7;
                            cw9Var.Y = cw9Var.Q;
                            cw9Var.X = 0;
                            cw9Var.a = 12;
                            if (cw9Var.a != i5) {
                            }
                            break;
                        case 8:
                            int i35 = cw9Var.Q;
                            System.arraycopy(bArr, i35, bArr, 0, cw9Var.N - i35);
                            cw9Var.a = 3;
                            break;
                        case 9:
                            int i36 = cw9Var.M;
                            if (i36 >= 4 && i36 <= 24) {
                                int i37 = xv9.a[i36];
                                int i38 = (cw9Var.L - cw9Var.s) - 1;
                                int i39 = xv9.b[i36];
                                int i40 = ((1 << i39) - 1) & i38;
                                int i41 = i38 >>> i39;
                                int i42 = i37 + (i40 * i36);
                                if (i41 < dw9.d.length) {
                                    int b2 = dw9.b(bArr, cw9Var.N, xv9.a(), i42, cw9Var.M, dw9.d[i41]);
                                    int i43 = cw9Var.N + b2;
                                    cw9Var.N = i43;
                                    cw9Var.r += b2;
                                    cw9Var.g -= b2;
                                    int i44 = cw9Var.Q;
                                    if (i43 >= i44) {
                                        cw9Var.b = 8;
                                        cw9Var.Y = i44;
                                        cw9Var.X = 0;
                                        cw9Var.a = 12;
                                        break;
                                    } else {
                                        cw9Var.a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + cw9Var.a);
                    }
                } else if (!u(cw9Var)) {
                    return;
                } else {
                    int i45 = cw9Var.r;
                    int i46 = cw9Var.O;
                    if (i45 >= i46) {
                        cw9Var.s = i46;
                    }
                    cw9Var.r &= i8;
                    cw9Var.a = cw9Var.b;
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

    public static void k(cw9 cw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cw9Var) == null) {
            int i2 = cw9Var.P;
            long j = cw9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + cw9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!cw9Var.h && i2 < 16384 && cw9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = cw9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = cw9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = cw9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = cw9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(cw9Var.S, i, bArr, 0, i5);
                    cw9Var.r = i5;
                    cw9Var.T = i5;
                }
            }
            cw9Var.d = bArr;
            cw9Var.Q = i2;
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

    public static int m(int[] iArr, int i, tv9 tv9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, tv9Var)) == null) {
            tv9.d(tv9Var);
            int r = r(iArr, i, tv9Var);
            return bw9.a[r] + tv9.i(tv9Var, bw9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, tv9 tv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), tv9Var}) != null) {
            return;
        }
        tv9.j(tv9Var);
        int[] iArr2 = new int[i];
        int i3 = tv9.i(tv9Var, 2);
        boolean z = true;
        if (i3 == 1) {
            int i4 = i - 1;
            int[] iArr3 = new int[4];
            int i5 = tv9.i(tv9Var, 2) + 1;
            int i6 = 0;
            while (i4 != 0) {
                i4 >>= 1;
                i6++;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr3[i7] = tv9.i(tv9Var, i6) % i;
                iArr2[iArr3[i7]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i5 != 3) {
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (tv9.i(tv9Var, 1) == 1) {
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
                yv9.a(iArr, i2, 8, iArr2, i);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i8 = 32;
        int i9 = 0;
        while (i3 < 18 && i8 > 0) {
            int i10 = a[i3];
            tv9.d(tv9Var);
            long j = tv9Var.f;
            int i11 = tv9Var.g;
            int i12 = ((int) (j >>> i11)) & 15;
            int[] iArr5 = d;
            tv9Var.g = i11 + (iArr5[i12] >> 16);
            int i13 = iArr5[i12] & 65535;
            iArr4[i10] = i13;
            if (i13 != 0) {
                i8 -= 32 >> i13;
                i9++;
            }
            i3++;
        }
        r5 = (i9 == 1 || i8 == 0) ? true : true;
        o(iArr4, i, iArr2, tv9Var);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.repackage.ew9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, tv9 tv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65551, null, iArr, i, iArr2, tv9Var) != null) {
            return;
        }
        int[] iArr3 = new int[32];
        yv9.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 0;
        int i4 = 32768;
        int i5 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (i3 < i && i4 > 0) {
                tv9.j(tv9Var);
                tv9.d(tv9Var);
                long j = tv9Var.f;
                int i7 = tv9Var.g;
                int i8 = ((int) (j >>> i7)) & 31;
                tv9Var.g = i7 + (iArr3[i8] >> 16);
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
                    int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + tv9.i(tv9Var, i11) + 3;
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

    public static void p(cw9 cw9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, cw9Var) == null) {
            tv9 tv9Var = cw9Var.c;
            for (int i = 0; i < 3; i++) {
                cw9Var.o[i] = h(tv9Var) + 1;
                cw9Var.n[i] = 268435456;
                int[] iArr2 = cw9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, cw9Var.e, i2, tv9Var);
                    n(26, cw9Var.f, i2, tv9Var);
                    cw9Var.n[i] = m(cw9Var.f, i2, tv9Var);
                }
            }
            tv9.j(tv9Var);
            cw9Var.K = tv9.i(tv9Var, 2);
            int i3 = tv9.i(tv9Var, 4);
            int i4 = cw9Var.K;
            int i5 = (i3 << i4) + 16;
            cw9Var.I = i5;
            cw9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            cw9Var.z = new byte[cw9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = cw9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    cw9Var.z[i7] = (byte) (tv9.i(tv9Var, 2) << 1);
                    i7++;
                }
                tv9.j(tv9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            cw9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, tv9Var);
            cw9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (cw9Var.o[0] << 6)) {
                    break;
                } else if (cw9Var.A[i8] != (i8 >> 6)) {
                    cw9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = cw9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            cw9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, tv9Var);
            zv9.b(cw9Var.k, 256, d2);
            zv9.b(cw9Var.l, 704, cw9Var.o[1]);
            zv9.b(cw9Var.m, i6, d3);
            zv9.a(cw9Var.k, tv9Var);
            zv9.a(cw9Var.l, tv9Var);
            zv9.a(cw9Var.m, tv9Var);
            cw9Var.B = 0;
            cw9Var.C = 0;
            int[] iArr4 = vv9.b;
            byte[] bArr3 = cw9Var.z;
            cw9Var.D = iArr4[bArr3[0]];
            cw9Var.E = iArr4[bArr3[0] + 1];
            cw9Var.v = 0;
            cw9Var.w = cw9Var.k.c[0];
            cw9Var.F = cw9Var.l.c[0];
            int[] iArr5 = cw9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, cw9Var) == null) {
            tv9 tv9Var = cw9Var.c;
            if (cw9Var.h) {
                cw9Var.b = 10;
                cw9Var.Y = cw9Var.r;
                cw9Var.X = 0;
                cw9Var.a = 12;
                return;
            }
            zv9 zv9Var = cw9Var.k;
            zv9Var.b = null;
            zv9Var.c = null;
            zv9 zv9Var2 = cw9Var.l;
            zv9Var2.b = null;
            zv9Var2.c = null;
            zv9 zv9Var3 = cw9Var.m;
            zv9Var3.b = null;
            zv9Var3.c = null;
            tv9.j(tv9Var);
            g(tv9Var, cw9Var);
            if (cw9Var.g != 0 || cw9Var.j) {
                if (!cw9Var.i && !cw9Var.j) {
                    cw9Var.a = 2;
                } else {
                    tv9.g(tv9Var);
                    cw9Var.a = cw9Var.j ? 4 : 5;
                }
                if (cw9Var.j) {
                    return;
                }
                cw9Var.R += cw9Var.g;
                if (cw9Var.Q < cw9Var.P) {
                    k(cw9Var);
                }
            }
        }
    }

    public static int r(int[] iArr, int i, tv9 tv9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, tv9Var)) == null) {
            long j = tv9Var.f;
            int i2 = tv9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                tv9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            tv9Var.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static void s(cw9 cw9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, cw9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            cw9Var.S = bArr;
        }
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) ? i < 16 ? iArr[(i2 + b[i]) & 3] + c[i] : (i - 16) + 1 : invokeCommon.intValue;
    }

    public static boolean u(cw9 cw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, cw9Var)) == null) {
            int i = cw9Var.T;
            if (i != 0) {
                cw9Var.X += i;
                cw9Var.T = 0;
            }
            int min = Math.min(cw9Var.V - cw9Var.W, cw9Var.Y - cw9Var.X);
            if (min != 0) {
                System.arraycopy(cw9Var.d, cw9Var.X, cw9Var.Z, cw9Var.U + cw9Var.W, min);
                cw9Var.W += min;
                cw9Var.X += min;
            }
            return cw9Var.W < cw9Var.V;
        }
        return invokeL.booleanValue;
    }
}
