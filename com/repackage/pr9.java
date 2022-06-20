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
public final class pr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final wr9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public pr9() {
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
        this.c = new wr9();
        this.i = 0;
    }

    public static void a(pr9 pr9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, pr9Var, z) == null) && pr9Var.e) {
            int i = ((pr9Var.h << 2) + ((pr9Var.g + 7) >> 3)) - 8;
            int i2 = pr9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(pr9 pr9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pr9Var) == null) {
            InputStream inputStream = pr9Var.d;
            pr9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(pr9 pr9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, pr9Var, bArr, i, i2) == null) {
            if ((pr9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = pr9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (pr9Var.f >>> i3);
                pr9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(pr9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(pr9Var.a, pr9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                pr9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(pr9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = pr9Var.d.read(bArr, i, i2);
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
            d(pr9Var);
            while (i2 != 0) {
                long j = pr9Var.f;
                int i5 = pr9Var.g;
                bArr[i] = (byte) (j >>> i5);
                pr9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(pr9Var, false);
        }
    }

    public static void d(pr9 pr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pr9Var) == null) || (i = pr9Var.g) < 32) {
            return;
        }
        int[] iArr = pr9Var.b;
        int i2 = pr9Var.h;
        pr9Var.h = i2 + 1;
        pr9Var.f = (iArr[i2] << 32) | (pr9Var.f >>> 32);
        pr9Var.g = i - 32;
    }

    public static void e(pr9 pr9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pr9Var, inputStream) == null) {
            if (pr9Var.d == null) {
                wr9.b(pr9Var.c, pr9Var.a, pr9Var.b);
                pr9Var.d = inputStream;
                pr9Var.f = 0L;
                pr9Var.g = 64;
                pr9Var.h = 1024;
                pr9Var.e = false;
                h(pr9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(pr9 pr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pr9Var)) == null) {
            return (pr9Var.e ? (pr9Var.i + 3) >> 2 : 1024) - pr9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(pr9 pr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, pr9Var) == null) && (i = (64 - pr9Var.g) & 7) != 0 && i(pr9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(pr9 pr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, pr9Var) == null) {
            j(pr9Var);
            a(pr9Var, false);
            d(pr9Var);
            d(pr9Var);
        }
    }

    public static int i(pr9 pr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, pr9Var, i)) == null) {
            d(pr9Var);
            long j = pr9Var.f;
            int i2 = pr9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            pr9Var.g = i2 + i;
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
    public static void j(pr9 pr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, pr9Var) == null) || (i = pr9Var.h) <= 1015) {
            return;
        }
        if (pr9Var.e) {
            if (f(pr9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = pr9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        pr9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = pr9Var.d.read(pr9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        wr9.a(pr9Var.c, i3 >> 2);
    }

    public static void k(pr9 pr9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, pr9Var) == null) && pr9Var.g == 64) {
            h(pr9Var);
        }
    }
}
