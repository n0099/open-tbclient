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
public final class ou9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final vu9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public ou9() {
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
        this.c = new vu9();
        this.i = 0;
    }

    public static void a(ou9 ou9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, ou9Var, z) == null) && ou9Var.e) {
            int i = ((ou9Var.h << 2) + ((ou9Var.g + 7) >> 3)) - 8;
            int i2 = ou9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(ou9 ou9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ou9Var) == null) {
            InputStream inputStream = ou9Var.d;
            ou9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(ou9 ou9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, ou9Var, bArr, i, i2) == null) {
            if ((ou9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = ou9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (ou9Var.f >>> i3);
                ou9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(ou9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(ou9Var.a, ou9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                ou9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(ou9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = ou9Var.d.read(bArr, i, i2);
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
            d(ou9Var);
            while (i2 != 0) {
                long j = ou9Var.f;
                int i5 = ou9Var.g;
                bArr[i] = (byte) (j >>> i5);
                ou9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(ou9Var, false);
        }
    }

    public static void d(ou9 ou9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ou9Var) == null) || (i = ou9Var.g) < 32) {
            return;
        }
        int[] iArr = ou9Var.b;
        int i2 = ou9Var.h;
        ou9Var.h = i2 + 1;
        ou9Var.f = (iArr[i2] << 32) | (ou9Var.f >>> 32);
        ou9Var.g = i - 32;
    }

    public static void e(ou9 ou9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ou9Var, inputStream) == null) {
            if (ou9Var.d == null) {
                vu9.b(ou9Var.c, ou9Var.a, ou9Var.b);
                ou9Var.d = inputStream;
                ou9Var.f = 0L;
                ou9Var.g = 64;
                ou9Var.h = 1024;
                ou9Var.e = false;
                h(ou9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(ou9 ou9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ou9Var)) == null) {
            return (ou9Var.e ? (ou9Var.i + 3) >> 2 : 1024) - ou9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(ou9 ou9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, ou9Var) == null) && (i = (64 - ou9Var.g) & 7) != 0 && i(ou9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(ou9 ou9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ou9Var) == null) {
            j(ou9Var);
            a(ou9Var, false);
            d(ou9Var);
            d(ou9Var);
        }
    }

    public static int i(ou9 ou9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, ou9Var, i)) == null) {
            d(ou9Var);
            long j = ou9Var.f;
            int i2 = ou9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            ou9Var.g = i2 + i;
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
    public static void j(ou9 ou9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, ou9Var) == null) || (i = ou9Var.h) <= 1015) {
            return;
        }
        if (ou9Var.e) {
            if (f(ou9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = ou9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        ou9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = ou9Var.d.read(ou9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        vu9.a(ou9Var.c, i3 >> 2);
    }

    public static void k(ou9 ou9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, ou9Var) == null) && ou9Var.g == 64) {
            h(ou9Var);
        }
    }
}
