package h.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f63477b;

    /* renamed from: c  reason: collision with root package name */
    public final h f63478c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f63479d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63480e;

    /* renamed from: f  reason: collision with root package name */
    public long f63481f;

    /* renamed from: g  reason: collision with root package name */
    public int f63482g;

    /* renamed from: h  reason: collision with root package name */
    public int f63483h;

    /* renamed from: i  reason: collision with root package name */
    public int f63484i;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[4160];
        this.f63477b = new int[1040];
        this.f63478c = new h();
        this.f63484i = 0;
    }

    public static void a(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, aVar, z) == null) && aVar.f63480e) {
            int i2 = ((aVar.f63483h << 2) + ((aVar.f63482g + 7) >> 3)) - 8;
            int i3 = aVar.f63484i;
            if (i2 > i3) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i2 != i3) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(a aVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            InputStream inputStream = aVar.f63479d;
            aVar.f63479d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(a aVar, byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, aVar, bArr, i2, i3) == null) {
            if ((aVar.f63482g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i4 = aVar.f63482g;
                if (i4 == 64 || i3 == 0) {
                    break;
                }
                bArr[i2] = (byte) (aVar.f63481f >>> i4);
                aVar.f63482g = i4 + 8;
                i3--;
                i2++;
            }
            if (i3 == 0) {
                return;
            }
            int min = Math.min(f(aVar), i3 >> 2);
            if (min > 0) {
                int i5 = min << 2;
                System.arraycopy(aVar.a, aVar.f63483h << 2, bArr, i2, i5);
                i2 += i5;
                i3 -= i5;
                aVar.f63483h += min;
            }
            if (i3 == 0) {
                return;
            }
            if (f(aVar) <= 0) {
                while (i3 > 0) {
                    try {
                        int read = aVar.f63479d.read(bArr, i2, i3);
                        if (read == -1) {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                        i2 += read;
                        i3 -= read;
                    } catch (IOException e2) {
                        throw new BrotliRuntimeException("Failed to read input", e2);
                    }
                }
                return;
            }
            d(aVar);
            while (i3 != 0) {
                long j2 = aVar.f63481f;
                int i6 = aVar.f63482g;
                bArr[i2] = (byte) (j2 >>> i6);
                aVar.f63482g = i6 + 8;
                i3--;
                i2++;
            }
            a(aVar, false);
        }
    }

    public static void d(a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (i2 = aVar.f63482g) < 32) {
            return;
        }
        int[] iArr = aVar.f63477b;
        int i3 = aVar.f63483h;
        aVar.f63483h = i3 + 1;
        aVar.f63481f = (iArr[i3] << 32) | (aVar.f63481f >>> 32);
        aVar.f63482g = i2 - 32;
    }

    public static void e(a aVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, inputStream) == null) {
            if (aVar.f63479d == null) {
                h.b(aVar.f63478c, aVar.a, aVar.f63477b);
                aVar.f63479d = inputStream;
                aVar.f63481f = 0L;
                aVar.f63482g = 64;
                aVar.f63483h = 1024;
                aVar.f63480e = false;
                h(aVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return (aVar.f63480e ? (aVar.f63484i + 3) >> 2 : 1024) - aVar.f63483h;
        }
        return invokeL.intValue;
    }

    public static void g(a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, aVar) == null) && (i2 = (64 - aVar.f63482g) & 7) != 0 && i(aVar, i2) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            j(aVar);
            a(aVar, false);
            d(aVar);
            d(aVar);
        }
    }

    public static int i(a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, aVar, i2)) == null) {
            d(aVar);
            long j2 = aVar.f63481f;
            int i3 = aVar.f63482g;
            int i4 = ((int) (j2 >>> i3)) & ((1 << i2) - 1);
            aVar.f63482g = i3 + i2;
            return i4;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4.f63480e = true;
        r4.f63484i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, aVar) == null) || (i2 = aVar.f63483h) <= 1015) {
            return;
        }
        if (aVar.f63480e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i3 = i2 << 2;
        int i4 = 4096 - i3;
        byte[] bArr = aVar.a;
        System.arraycopy(bArr, i3, bArr, 0, i4);
        aVar.f63483h = 0;
        while (true) {
            if (i4 >= 4096) {
                break;
            }
            try {
                int read = aVar.f63479d.read(aVar.a, i4, 4096 - i4);
                if (read <= 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e2) {
                throw new BrotliRuntimeException("Failed to read input", e2);
            }
        }
        h.a(aVar.f63478c, i4 >> 2);
    }

    public static void k(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, aVar) == null) && aVar.f63482g == 64) {
            h(aVar);
        }
    }
}
