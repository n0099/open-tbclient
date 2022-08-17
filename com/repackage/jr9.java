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
public final class jr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final qr9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public jr9() {
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
        this.c = new qr9();
        this.i = 0;
    }

    public static void a(jr9 jr9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, jr9Var, z) == null) && jr9Var.e) {
            int i = ((jr9Var.h << 2) + ((jr9Var.g + 7) >> 3)) - 8;
            int i2 = jr9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(jr9 jr9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jr9Var) == null) {
            InputStream inputStream = jr9Var.d;
            jr9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(jr9 jr9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, jr9Var, bArr, i, i2) == null) {
            if ((jr9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = jr9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (jr9Var.f >>> i3);
                jr9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(jr9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(jr9Var.a, jr9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                jr9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(jr9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = jr9Var.d.read(bArr, i, i2);
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
            d(jr9Var);
            while (i2 != 0) {
                long j = jr9Var.f;
                int i5 = jr9Var.g;
                bArr[i] = (byte) (j >>> i5);
                jr9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(jr9Var, false);
        }
    }

    public static void d(jr9 jr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jr9Var) == null) || (i = jr9Var.g) < 32) {
            return;
        }
        int[] iArr = jr9Var.b;
        int i2 = jr9Var.h;
        jr9Var.h = i2 + 1;
        jr9Var.f = (iArr[i2] << 32) | (jr9Var.f >>> 32);
        jr9Var.g = i - 32;
    }

    public static void e(jr9 jr9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, jr9Var, inputStream) == null) {
            if (jr9Var.d == null) {
                qr9.b(jr9Var.c, jr9Var.a, jr9Var.b);
                jr9Var.d = inputStream;
                jr9Var.f = 0L;
                jr9Var.g = 64;
                jr9Var.h = 1024;
                jr9Var.e = false;
                h(jr9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(jr9 jr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jr9Var)) == null) {
            return (jr9Var.e ? (jr9Var.i + 3) >> 2 : 1024) - jr9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(jr9 jr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, jr9Var) == null) && (i = (64 - jr9Var.g) & 7) != 0 && i(jr9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(jr9 jr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, jr9Var) == null) {
            j(jr9Var);
            a(jr9Var, false);
            d(jr9Var);
            d(jr9Var);
        }
    }

    public static int i(jr9 jr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, jr9Var, i)) == null) {
            d(jr9Var);
            long j = jr9Var.f;
            int i2 = jr9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            jr9Var.g = i2 + i;
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
    public static void j(jr9 jr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, jr9Var) == null) || (i = jr9Var.h) <= 1015) {
            return;
        }
        if (jr9Var.e) {
            if (f(jr9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = jr9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        jr9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = jr9Var.d.read(jr9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        qr9.a(jr9Var.c, i3 >> 2);
    }

    public static void k(jr9 jr9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, jr9Var) == null) && jr9Var.g == 64) {
            h(jr9Var);
        }
    }
}
