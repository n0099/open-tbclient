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
/* loaded from: classes6.dex */
public final class ir9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final pr9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public ir9() {
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
        this.c = new pr9();
        this.i = 0;
    }

    public static void a(ir9 ir9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, ir9Var, z) == null) && ir9Var.e) {
            int i = ((ir9Var.h << 2) + ((ir9Var.g + 7) >> 3)) - 8;
            int i2 = ir9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(ir9 ir9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ir9Var) == null) {
            InputStream inputStream = ir9Var.d;
            ir9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(ir9 ir9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, ir9Var, bArr, i, i2) == null) {
            if ((ir9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = ir9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (ir9Var.f >>> i3);
                ir9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(ir9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(ir9Var.a, ir9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                ir9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(ir9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = ir9Var.d.read(bArr, i, i2);
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
            d(ir9Var);
            while (i2 != 0) {
                long j = ir9Var.f;
                int i5 = ir9Var.g;
                bArr[i] = (byte) (j >>> i5);
                ir9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(ir9Var, false);
        }
    }

    public static void d(ir9 ir9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ir9Var) == null) || (i = ir9Var.g) < 32) {
            return;
        }
        int[] iArr = ir9Var.b;
        int i2 = ir9Var.h;
        ir9Var.h = i2 + 1;
        ir9Var.f = (iArr[i2] << 32) | (ir9Var.f >>> 32);
        ir9Var.g = i - 32;
    }

    public static void e(ir9 ir9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ir9Var, inputStream) == null) {
            if (ir9Var.d == null) {
                pr9.b(ir9Var.c, ir9Var.a, ir9Var.b);
                ir9Var.d = inputStream;
                ir9Var.f = 0L;
                ir9Var.g = 64;
                ir9Var.h = 1024;
                ir9Var.e = false;
                h(ir9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(ir9 ir9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ir9Var)) == null) {
            return (ir9Var.e ? (ir9Var.i + 3) >> 2 : 1024) - ir9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(ir9 ir9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, ir9Var) == null) && (i = (64 - ir9Var.g) & 7) != 0 && i(ir9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(ir9 ir9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ir9Var) == null) {
            j(ir9Var);
            a(ir9Var, false);
            d(ir9Var);
            d(ir9Var);
        }
    }

    public static int i(ir9 ir9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, ir9Var, i)) == null) {
            d(ir9Var);
            long j = ir9Var.f;
            int i2 = ir9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            ir9Var.g = i2 + i;
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
    public static void j(ir9 ir9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, ir9Var) == null) || (i = ir9Var.h) <= 1015) {
            return;
        }
        if (ir9Var.e) {
            if (f(ir9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = ir9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        ir9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = ir9Var.d.read(ir9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        pr9.a(ir9Var.c, i3 >> 2);
    }

    public static void k(ir9 ir9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, ir9Var) == null) && ir9Var.g == 64) {
            h(ir9Var);
        }
    }
}
