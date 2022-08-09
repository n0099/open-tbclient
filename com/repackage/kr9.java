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
public final class kr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755549121, "Lcom/repackage/kr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755549121, "Lcom/repackage/kr9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, qr9Var) == null) {
            hr9 hr9Var = qr9Var.c;
            byte[] bArr = qr9Var.d;
            int i = qr9Var.g;
            if (i <= 0) {
                hr9.k(hr9Var);
                qr9Var.a = 1;
                return;
            }
            int min = Math.min(qr9Var.Q - qr9Var.r, i);
            hr9.c(hr9Var, bArr, qr9Var.r, min);
            qr9Var.g -= min;
            int i2 = qr9Var.r + min;
            qr9Var.r = i2;
            int i3 = qr9Var.Q;
            if (i2 == i3) {
                qr9Var.b = 5;
                qr9Var.Y = i3;
                qr9Var.X = 0;
                qr9Var.a = 12;
                return;
            }
            hr9.k(hr9Var);
            qr9Var.a = 1;
        }
    }

    public static void b(qr9 qr9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, qr9Var, i) == null) {
            hr9 hr9Var = qr9Var.c;
            int[] iArr = qr9Var.p;
            int i3 = i * 2;
            hr9.d(hr9Var);
            int i4 = i * 1080;
            int r = r(qr9Var.e, i4, hr9Var);
            qr9Var.n[i] = m(qr9Var.f, i4, hr9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else {
                i2 = r == 0 ? iArr[i3] : r - 2;
            }
            int[] iArr2 = qr9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qr9Var) == null) {
            b(qr9Var, 1);
            qr9Var.F = qr9Var.l.c[qr9Var.p[3]];
        }
    }

    public static int d(int i, byte[] bArr, hr9 hr9Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, hr9Var)) == null) {
            hr9.j(hr9Var);
            int h = h(hr9Var) + 1;
            if (h == 1) {
                sr9.a(bArr, 0, i);
                return h;
            }
            int i2 = hr9.i(hr9Var, 1) == 1 ? hr9.i(hr9Var, 4) + 1 : 0;
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, hr9Var);
            int i3 = 0;
            while (i3 < i) {
                hr9.j(hr9Var);
                hr9.d(hr9Var);
                int r = r(iArr, 0, hr9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + hr9.i(hr9Var, r); i4 != 0; i4--) {
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
            if (hr9.i(hr9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void e(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, qr9Var) == null) {
            b(qr9Var, 2);
            qr9Var.C = qr9Var.p[5] << 2;
        }
    }

    public static void f(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, qr9Var) == null) {
            b(qr9Var, 0);
            int i = qr9Var.p[1];
            int i2 = i << 6;
            qr9Var.B = i2;
            int i3 = qr9Var.A[i2] & 255;
            qr9Var.v = i3;
            qr9Var.w = qr9Var.k.c[i3];
            byte b2 = qr9Var.z[i];
            int[] iArr = jr9.b;
            qr9Var.D = iArr[b2];
            qr9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(hr9 hr9Var, qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hr9Var, qr9Var) == null) {
            boolean z = hr9.i(hr9Var, 1) == 1;
            qr9Var.h = z;
            qr9Var.g = 0;
            qr9Var.i = false;
            qr9Var.j = false;
            if (!z || hr9.i(hr9Var, 1) == 0) {
                int i = hr9.i(hr9Var, 2) + 4;
                if (i == 7) {
                    qr9Var.j = true;
                    if (hr9.i(hr9Var, 1) == 0) {
                        int i2 = hr9.i(hr9Var, 2);
                        if (i2 == 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < i2; i3++) {
                            int i4 = hr9.i(hr9Var, 8);
                            if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                                throw new BrotliRuntimeException("Exuberant nibble");
                            }
                            qr9Var.g = (i4 << (i3 * 8)) | qr9Var.g;
                        }
                    } else {
                        throw new BrotliRuntimeException("Corrupted reserved bit");
                    }
                } else {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = hr9.i(hr9Var, 4);
                        if (i6 == 0 && i5 + 1 == i && i > 4) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        qr9Var.g = (i6 << (i5 * 4)) | qr9Var.g;
                    }
                }
                qr9Var.g++;
                if (qr9Var.h) {
                    return;
                }
                qr9Var.i = hr9.i(hr9Var, 1) == 1;
            }
        }
    }

    public static int h(hr9 hr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, hr9Var)) == null) {
            if (hr9.i(hr9Var, 1) != 0) {
                int i = hr9.i(hr9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return hr9.i(hr9Var, i) + (1 << i);
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
    public static void i(qr9 qr9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, qr9Var) != null) {
            return;
        }
        int i7 = qr9Var.a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 != 11) {
            hr9 hr9Var = qr9Var.c;
            int i8 = qr9Var.Q - 1;
            byte[] bArr = qr9Var.d;
            while (true) {
                int i9 = qr9Var.a;
                if (i9 == 10) {
                    if (i9 == 10) {
                        if (qr9Var.g >= 0) {
                            hr9.g(hr9Var);
                            hr9.a(qr9Var.c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i9 != 12) {
                    int i10 = 0;
                    switch (i9) {
                        case 1:
                            if (qr9Var.g >= 0) {
                                q(qr9Var);
                                i8 = qr9Var.Q - 1;
                                bArr = qr9Var.d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(qr9Var);
                            qr9Var.a = 3;
                            if (qr9Var.g > 0) {
                                qr9Var.a = 1;
                                break;
                            } else {
                                hr9.j(hr9Var);
                                if (qr9Var.n[1] == 0) {
                                    c(qr9Var);
                                }
                                int[] iArr = qr9Var.n;
                                iArr[1] = iArr[1] - 1;
                                hr9.d(hr9Var);
                                int r = r(qr9Var.l.b, qr9Var.F, hr9Var);
                                int i11 = r >>> 6;
                                qr9Var.G = 0;
                                if (i11 >= 2) {
                                    i11 -= 2;
                                    qr9Var.G = -1;
                                }
                                int i12 = pr9.g[i11] + ((r >>> 3) & 7);
                                int i13 = pr9.h[i11] + (r & 7);
                                qr9Var.y = pr9.c[i12] + hr9.i(hr9Var, pr9.d[i12]);
                                qr9Var.M = pr9.e[i13] + hr9.i(hr9Var, pr9.f[i13]);
                                qr9Var.x = 0;
                                qr9Var.a = 6;
                                if (qr9Var.u) {
                                    int i14 = qr9Var.r;
                                    int i15 = bArr[(i14 - 1) & i8] & 255;
                                    int i16 = bArr[(i14 - 2) & i8] & 255;
                                    while (true) {
                                        if (qr9Var.x < qr9Var.y) {
                                            hr9.j(hr9Var);
                                            if (qr9Var.n[0] == 0) {
                                                f(qr9Var);
                                            }
                                            byte[] bArr2 = qr9Var.A;
                                            int i17 = qr9Var.B;
                                            int[] iArr2 = jr9.a;
                                            int i18 = iArr2[qr9Var.D + i15];
                                            int[] iArr3 = qr9Var.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            hr9.d(hr9Var);
                                            nr9 nr9Var = qr9Var.k;
                                            int r2 = r(nr9Var.b, nr9Var.c[bArr2[i17 + (iArr2[qr9Var.E + i16] | i18)] & 255], hr9Var);
                                            int i19 = qr9Var.r;
                                            bArr[i19] = (byte) r2;
                                            qr9Var.x++;
                                            qr9Var.r = i19 + 1;
                                            if (i19 == i8) {
                                                qr9Var.b = 6;
                                                qr9Var.Y = qr9Var.Q;
                                                qr9Var.X = 0;
                                                qr9Var.a = 12;
                                            } else {
                                                int i20 = i15;
                                                i15 = r2;
                                                i16 = i20;
                                            }
                                        }
                                    }
                                } else {
                                    while (true) {
                                        if (qr9Var.x < qr9Var.y) {
                                            hr9.j(hr9Var);
                                            if (qr9Var.n[0] == 0) {
                                                f(qr9Var);
                                            }
                                            int[] iArr4 = qr9Var.n;
                                            iArr4[0] = iArr4[0] - 1;
                                            hr9.d(hr9Var);
                                            bArr[qr9Var.r] = (byte) r(qr9Var.k.b, qr9Var.w, hr9Var);
                                            qr9Var.x++;
                                            int i21 = qr9Var.r;
                                            qr9Var.r = i21 + 1;
                                            if (i21 == i8) {
                                                qr9Var.b = 6;
                                                qr9Var.Y = qr9Var.Q;
                                                qr9Var.X = 0;
                                                qr9Var.a = 12;
                                            }
                                        }
                                    }
                                }
                                if (qr9Var.a == 6) {
                                    continue;
                                } else {
                                    int i22 = qr9Var.g - qr9Var.y;
                                    qr9Var.g = i22;
                                    if (i22 <= 0) {
                                        qr9Var.a = 3;
                                        break;
                                    } else {
                                        if (qr9Var.G < 0) {
                                            hr9.j(hr9Var);
                                            if (qr9Var.n[2] == 0) {
                                                e(qr9Var);
                                            }
                                            int[] iArr5 = qr9Var.n;
                                            iArr5[2] = iArr5[2] - 1;
                                            hr9.d(hr9Var);
                                            nr9 nr9Var2 = qr9Var.m;
                                            int[] iArr6 = nr9Var2.b;
                                            int[] iArr7 = nr9Var2.c;
                                            byte[] bArr3 = qr9Var.H;
                                            int i23 = qr9Var.C;
                                            int i24 = qr9Var.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], hr9Var);
                                            qr9Var.G = r3;
                                            int i25 = qr9Var.I;
                                            if (r3 >= i25) {
                                                int i26 = r3 - i25;
                                                qr9Var.G = i26;
                                                int i27 = qr9Var.J & i26;
                                                int i28 = i26 >>> qr9Var.K;
                                                qr9Var.G = i28;
                                                int i29 = (i28 >>> 1) + 1;
                                                qr9Var.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + hr9.i(hr9Var, i29)) << qr9Var.K);
                                            }
                                        }
                                        int t = t(qr9Var.G, qr9Var.q, qr9Var.t);
                                        qr9Var.L = t;
                                        if (t >= 0) {
                                            int i30 = qr9Var.s;
                                            int i31 = qr9Var.O;
                                            if (i30 != i31 && (i6 = qr9Var.r) < i31) {
                                                qr9Var.s = i6;
                                            } else {
                                                qr9Var.s = qr9Var.O;
                                            }
                                            qr9Var.N = qr9Var.r;
                                            int i32 = qr9Var.L;
                                            if (i32 > qr9Var.s) {
                                                qr9Var.a = 9;
                                                break;
                                            } else {
                                                if (qr9Var.G > 0) {
                                                    int[] iArr8 = qr9Var.q;
                                                    int i33 = qr9Var.t;
                                                    iArr8[i33 & 3] = i32;
                                                    qr9Var.t = i33 + 1;
                                                }
                                                if (qr9Var.M <= qr9Var.g) {
                                                    qr9Var.x = 0;
                                                    qr9Var.a = 7;
                                                    int i34 = qr9Var.r;
                                                    i = (i34 - qr9Var.L) & i8;
                                                    i2 = qr9Var.M - qr9Var.x;
                                                    if (i + i2 >= i8 && i34 + i2 < i8) {
                                                        while (i10 < i2) {
                                                            bArr[i34] = bArr[i];
                                                            i10++;
                                                            i34++;
                                                            i++;
                                                        }
                                                        qr9Var.x += i2;
                                                        qr9Var.g -= i2;
                                                        qr9Var.r += i2;
                                                    } else {
                                                        do {
                                                            i3 = qr9Var.x;
                                                            if (i3 >= qr9Var.M) {
                                                                i4 = qr9Var.r;
                                                                bArr[i4] = bArr[(i4 - qr9Var.L) & i8];
                                                                qr9Var.g--;
                                                                qr9Var.x = i3 + 1;
                                                                qr9Var.r = i4 + 1;
                                                            }
                                                        } while (i4 != i8);
                                                        i5 = 7;
                                                        qr9Var.b = 7;
                                                        qr9Var.Y = qr9Var.Q;
                                                        qr9Var.X = 0;
                                                        qr9Var.a = 12;
                                                        if (qr9Var.a != i5) {
                                                            break;
                                                        } else {
                                                            qr9Var.a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i5 = 7;
                                                    if (qr9Var.a != i5) {
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
                            if (qr9Var.g > 0) {
                            }
                            break;
                        case 4:
                            while (qr9Var.g > 0) {
                                hr9.j(hr9Var);
                                hr9.i(hr9Var, 8);
                                qr9Var.g--;
                            }
                            qr9Var.a = 1;
                            break;
                        case 5:
                            a(qr9Var);
                            break;
                        case 6:
                            if (qr9Var.u) {
                            }
                            if (qr9Var.a == 6) {
                            }
                            break;
                        case 7:
                            int i342 = qr9Var.r;
                            i = (i342 - qr9Var.L) & i8;
                            i2 = qr9Var.M - qr9Var.x;
                            if (i + i2 >= i8) {
                                break;
                            }
                            do {
                                i3 = qr9Var.x;
                                if (i3 >= qr9Var.M) {
                                }
                            } while (i4 != i8);
                            i5 = 7;
                            qr9Var.b = 7;
                            qr9Var.Y = qr9Var.Q;
                            qr9Var.X = 0;
                            qr9Var.a = 12;
                            if (qr9Var.a != i5) {
                            }
                            break;
                        case 8:
                            int i35 = qr9Var.Q;
                            System.arraycopy(bArr, i35, bArr, 0, qr9Var.N - i35);
                            qr9Var.a = 3;
                            break;
                        case 9:
                            int i36 = qr9Var.M;
                            if (i36 >= 4 && i36 <= 24) {
                                int i37 = lr9.a[i36];
                                int i38 = (qr9Var.L - qr9Var.s) - 1;
                                int i39 = lr9.b[i36];
                                int i40 = ((1 << i39) - 1) & i38;
                                int i41 = i38 >>> i39;
                                int i42 = i37 + (i40 * i36);
                                if (i41 < rr9.d.length) {
                                    int b2 = rr9.b(bArr, qr9Var.N, lr9.a(), i42, qr9Var.M, rr9.d[i41]);
                                    int i43 = qr9Var.N + b2;
                                    qr9Var.N = i43;
                                    qr9Var.r += b2;
                                    qr9Var.g -= b2;
                                    int i44 = qr9Var.Q;
                                    if (i43 >= i44) {
                                        qr9Var.b = 8;
                                        qr9Var.Y = i44;
                                        qr9Var.X = 0;
                                        qr9Var.a = 12;
                                        break;
                                    } else {
                                        qr9Var.a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + qr9Var.a);
                    }
                } else if (!u(qr9Var)) {
                    return;
                } else {
                    int i45 = qr9Var.r;
                    int i46 = qr9Var.O;
                    if (i45 >= i46) {
                        qr9Var.s = i46;
                    }
                    qr9Var.r &= i8;
                    qr9Var.a = qr9Var.b;
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

    public static void k(qr9 qr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, qr9Var) == null) {
            int i2 = qr9Var.P;
            long j = qr9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + qr9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!qr9Var.h && i2 < 16384 && qr9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = qr9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = qr9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = qr9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = qr9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(qr9Var.S, i, bArr, 0, i5);
                    qr9Var.r = i5;
                    qr9Var.T = i5;
                }
            }
            qr9Var.d = bArr;
            qr9Var.Q = i2;
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

    public static int m(int[] iArr, int i, hr9 hr9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, hr9Var)) == null) {
            hr9.d(hr9Var);
            int r = r(iArr, i, hr9Var);
            return pr9.a[r] + hr9.i(hr9Var, pr9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, hr9 hr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), hr9Var}) != null) {
            return;
        }
        hr9.j(hr9Var);
        int[] iArr2 = new int[i];
        int i3 = hr9.i(hr9Var, 2);
        boolean z = true;
        if (i3 == 1) {
            int i4 = i - 1;
            int[] iArr3 = new int[4];
            int i5 = hr9.i(hr9Var, 2) + 1;
            int i6 = 0;
            while (i4 != 0) {
                i4 >>= 1;
                i6++;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr3[i7] = hr9.i(hr9Var, i6) % i;
                iArr2[iArr3[i7]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i5 != 3) {
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (hr9.i(hr9Var, 1) == 1) {
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
                mr9.a(iArr, i2, 8, iArr2, i);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i8 = 32;
        int i9 = 0;
        while (i3 < 18 && i8 > 0) {
            int i10 = a[i3];
            hr9.d(hr9Var);
            long j = hr9Var.f;
            int i11 = hr9Var.g;
            int i12 = ((int) (j >>> i11)) & 15;
            int[] iArr5 = d;
            hr9Var.g = i11 + (iArr5[i12] >> 16);
            int i13 = iArr5[i12] & 65535;
            iArr4[i10] = i13;
            if (i13 != 0) {
                i8 -= 32 >> i13;
                i9++;
            }
            i3++;
        }
        r5 = (i9 == 1 || i8 == 0) ? true : true;
        o(iArr4, i, iArr2, hr9Var);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.repackage.sr9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, hr9 hr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65551, null, iArr, i, iArr2, hr9Var) != null) {
            return;
        }
        int[] iArr3 = new int[32];
        mr9.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 0;
        int i4 = 32768;
        int i5 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (i3 < i && i4 > 0) {
                hr9.j(hr9Var);
                hr9.d(hr9Var);
                long j = hr9Var.f;
                int i7 = hr9Var.g;
                int i8 = ((int) (j >>> i7)) & 31;
                hr9Var.g = i7 + (iArr3[i8] >> 16);
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
                    int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + hr9.i(hr9Var, i11) + 3;
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

    public static void p(qr9 qr9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, qr9Var) == null) {
            hr9 hr9Var = qr9Var.c;
            for (int i = 0; i < 3; i++) {
                qr9Var.o[i] = h(hr9Var) + 1;
                qr9Var.n[i] = 268435456;
                int[] iArr2 = qr9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, qr9Var.e, i2, hr9Var);
                    n(26, qr9Var.f, i2, hr9Var);
                    qr9Var.n[i] = m(qr9Var.f, i2, hr9Var);
                }
            }
            hr9.j(hr9Var);
            qr9Var.K = hr9.i(hr9Var, 2);
            int i3 = hr9.i(hr9Var, 4);
            int i4 = qr9Var.K;
            int i5 = (i3 << i4) + 16;
            qr9Var.I = i5;
            qr9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            qr9Var.z = new byte[qr9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = qr9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    qr9Var.z[i7] = (byte) (hr9.i(hr9Var, 2) << 1);
                    i7++;
                }
                hr9.j(hr9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            qr9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, hr9Var);
            qr9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (qr9Var.o[0] << 6)) {
                    break;
                } else if (qr9Var.A[i8] != (i8 >> 6)) {
                    qr9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = qr9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            qr9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, hr9Var);
            nr9.b(qr9Var.k, 256, d2);
            nr9.b(qr9Var.l, 704, qr9Var.o[1]);
            nr9.b(qr9Var.m, i6, d3);
            nr9.a(qr9Var.k, hr9Var);
            nr9.a(qr9Var.l, hr9Var);
            nr9.a(qr9Var.m, hr9Var);
            qr9Var.B = 0;
            qr9Var.C = 0;
            int[] iArr4 = jr9.b;
            byte[] bArr3 = qr9Var.z;
            qr9Var.D = iArr4[bArr3[0]];
            qr9Var.E = iArr4[bArr3[0] + 1];
            qr9Var.v = 0;
            qr9Var.w = qr9Var.k.c[0];
            qr9Var.F = qr9Var.l.c[0];
            int[] iArr5 = qr9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, qr9Var) == null) {
            hr9 hr9Var = qr9Var.c;
            if (qr9Var.h) {
                qr9Var.b = 10;
                qr9Var.Y = qr9Var.r;
                qr9Var.X = 0;
                qr9Var.a = 12;
                return;
            }
            nr9 nr9Var = qr9Var.k;
            nr9Var.b = null;
            nr9Var.c = null;
            nr9 nr9Var2 = qr9Var.l;
            nr9Var2.b = null;
            nr9Var2.c = null;
            nr9 nr9Var3 = qr9Var.m;
            nr9Var3.b = null;
            nr9Var3.c = null;
            hr9.j(hr9Var);
            g(hr9Var, qr9Var);
            if (qr9Var.g != 0 || qr9Var.j) {
                if (!qr9Var.i && !qr9Var.j) {
                    qr9Var.a = 2;
                } else {
                    hr9.g(hr9Var);
                    qr9Var.a = qr9Var.j ? 4 : 5;
                }
                if (qr9Var.j) {
                    return;
                }
                qr9Var.R += qr9Var.g;
                if (qr9Var.Q < qr9Var.P) {
                    k(qr9Var);
                }
            }
        }
    }

    public static int r(int[] iArr, int i, hr9 hr9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, hr9Var)) == null) {
            long j = hr9Var.f;
            int i2 = hr9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                hr9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            hr9Var.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static void s(qr9 qr9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, qr9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            qr9Var.S = bArr;
        }
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) ? i < 16 ? iArr[(i2 + b[i]) & 3] + c[i] : (i - 16) + 1 : invokeCommon.intValue;
    }

    public static boolean u(qr9 qr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, qr9Var)) == null) {
            int i = qr9Var.T;
            if (i != 0) {
                qr9Var.X += i;
                qr9Var.T = 0;
            }
            int min = Math.min(qr9Var.V - qr9Var.W, qr9Var.Y - qr9Var.X);
            if (min != 0) {
                System.arraycopy(qr9Var.d, qr9Var.X, qr9Var.Z, qr9Var.U + qr9Var.W, min);
                qr9Var.W += min;
                qr9Var.X += min;
            }
            return qr9Var.W < qr9Var.V;
        }
        return invokeL.booleanValue;
    }
}
