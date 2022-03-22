package f.a.a;

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
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f44707b;

    /* renamed from: c  reason: collision with root package name */
    public final h f44708c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f44709d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44710e;

    /* renamed from: f  reason: collision with root package name */
    public long f44711f;

    /* renamed from: g  reason: collision with root package name */
    public int f44712g;

    /* renamed from: h  reason: collision with root package name */
    public int f44713h;
    public int i;

    public a() {
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
        this.f44707b = new int[1040];
        this.f44708c = new h();
        this.i = 0;
    }

    public static void a(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, aVar, z) == null) && aVar.f44710e) {
            int i = ((aVar.f44713h << 2) + ((aVar.f44712g + 7) >> 3)) - 8;
            int i2 = aVar.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(a aVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            InputStream inputStream = aVar.f44709d;
            aVar.f44709d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(a aVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, aVar, bArr, i, i2) == null) {
            if ((aVar.f44712g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = aVar.f44712g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (aVar.f44711f >>> i3);
                aVar.f44712g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(aVar), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(aVar.a, aVar.f44713h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                aVar.f44713h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(aVar) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = aVar.f44709d.read(bArr, i, i2);
                        if (read == -1) {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                        i += read;
                        i2 -= read;
                    } catch (IOException e2) {
                        throw new BrotliRuntimeException("Failed to read input", e2);
                    }
                }
                return;
            }
            d(aVar);
            while (i2 != 0) {
                long j = aVar.f44711f;
                int i5 = aVar.f44712g;
                bArr[i] = (byte) (j >>> i5);
                aVar.f44712g = i5 + 8;
                i2--;
                i++;
            }
            a(aVar, false);
        }
    }

    public static void d(a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (i = aVar.f44712g) < 32) {
            return;
        }
        int[] iArr = aVar.f44707b;
        int i2 = aVar.f44713h;
        aVar.f44713h = i2 + 1;
        aVar.f44711f = (iArr[i2] << 32) | (aVar.f44711f >>> 32);
        aVar.f44712g = i - 32;
    }

    public static void e(a aVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, inputStream) == null) {
            if (aVar.f44709d == null) {
                h.b(aVar.f44708c, aVar.a, aVar.f44707b);
                aVar.f44709d = inputStream;
                aVar.f44711f = 0L;
                aVar.f44712g = 64;
                aVar.f44713h = 1024;
                aVar.f44710e = false;
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
            return (aVar.f44710e ? (aVar.i + 3) >> 2 : 1024) - aVar.f44713h;
        }
        return invokeL.intValue;
    }

    public static void g(a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, aVar) == null) && (i = (64 - aVar.f44712g) & 7) != 0 && i(aVar, i) != 0) {
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

    public static int i(a aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, aVar, i)) == null) {
            d(aVar);
            long j = aVar.f44711f;
            int i2 = aVar.f44712g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            aVar.f44712g = i2 + i;
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4.f44710e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, aVar) == null) || (i = aVar.f44713h) <= 1015) {
            return;
        }
        if (aVar.f44710e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = aVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        aVar.f44713h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = aVar.f44709d.read(aVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e2) {
                throw new BrotliRuntimeException("Failed to read input", e2);
            }
        }
        h.a(aVar.f44708c, i3 >> 2);
    }

    public static void k(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, aVar) == null) && aVar.f44712g == 64) {
            h(aVar);
        }
    }
}
