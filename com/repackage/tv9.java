package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class tv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final aw9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public tv9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[4160];
        this.b = new int[1040];
        this.c = new aw9();
        this.i = 0;
    }

    public static void a(tv9 tv9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, tv9Var, z) == null) && tv9Var.e) {
            int i = ((tv9Var.h << 2) + ((tv9Var.g + 7) >> 3)) - 8;
            int i2 = tv9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(tv9 tv9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tv9Var) == null) {
            InputStream inputStream = tv9Var.d;
            tv9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(tv9 tv9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, tv9Var, bArr, i, i2) == null) {
            if ((tv9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = tv9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (tv9Var.f >>> i3);
                tv9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(tv9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(tv9Var.a, tv9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                tv9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(tv9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = tv9Var.d.read(bArr, i, i2);
                        if (read == -1) {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                        i += read;
                        i2 -= read;
                    } catch (IOException e) {
                        throw new BrotliRuntimeException("Failed to read input", e);
                    }
                }
                return;
            }
            d(tv9Var);
            while (i2 != 0) {
                long j = tv9Var.f;
                int i5 = tv9Var.g;
                bArr[i] = (byte) (j >>> i5);
                tv9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(tv9Var, false);
        }
    }

    public static void d(tv9 tv9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tv9Var) == null) || (i = tv9Var.g) < 32) {
            return;
        }
        int[] iArr = tv9Var.b;
        int i2 = tv9Var.h;
        tv9Var.h = i2 + 1;
        tv9Var.f = (iArr[i2] << 32) | (tv9Var.f >>> 32);
        tv9Var.g = i - 32;
    }

    public static void e(tv9 tv9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, tv9Var, inputStream) == null) {
            if (tv9Var.d == null) {
                aw9.b(tv9Var.c, tv9Var.a, tv9Var.b);
                tv9Var.d = inputStream;
                tv9Var.f = 0L;
                tv9Var.g = 64;
                tv9Var.h = 1024;
                tv9Var.e = false;
                h(tv9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(tv9 tv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tv9Var)) == null) {
            return (tv9Var.e ? (tv9Var.i + 3) >> 2 : 1024) - tv9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(tv9 tv9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, tv9Var) == null) && (i = (64 - tv9Var.g) & 7) != 0 && i(tv9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(tv9 tv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, tv9Var) == null) {
            j(tv9Var);
            a(tv9Var, false);
            d(tv9Var);
            d(tv9Var);
        }
    }

    public static int i(tv9 tv9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, tv9Var, i)) == null) {
            d(tv9Var);
            long j = tv9Var.f;
            int i2 = tv9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            tv9Var.g = i2 + i;
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4.e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(tv9 tv9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, tv9Var) == null) || (i = tv9Var.h) <= 1015) {
            return;
        }
        if (tv9Var.e) {
            if (f(tv9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = tv9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        tv9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = tv9Var.d.read(tv9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        aw9.a(tv9Var.c, i3 >> 2);
    }

    public static void k(tv9 tv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, tv9Var) == null) && tv9Var.g == 64) {
            h(tv9Var);
        }
    }
}
