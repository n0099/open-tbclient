package g.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f72298a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f72299b;

    /* renamed from: c  reason: collision with root package name */
    public final h f72300c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f72301d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72302e;

    /* renamed from: f  reason: collision with root package name */
    public long f72303f;

    /* renamed from: g  reason: collision with root package name */
    public int f72304g;

    /* renamed from: h  reason: collision with root package name */
    public int f72305h;

    /* renamed from: i  reason: collision with root package name */
    public int f72306i;

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
        this.f72298a = new byte[4160];
        this.f72299b = new int[1040];
        this.f72300c = new h();
        this.f72306i = 0;
    }

    public static void a(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, aVar, z) == null) && aVar.f72302e) {
            int i2 = ((aVar.f72305h << 2) + ((aVar.f72304g + 7) >> 3)) - 8;
            int i3 = aVar.f72306i;
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
            InputStream inputStream = aVar.f72301d;
            aVar.f72301d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(a aVar, byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, aVar, bArr, i2, i3) == null) {
            if ((aVar.f72304g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i4 = aVar.f72304g;
                if (i4 == 64 || i3 == 0) {
                    break;
                }
                bArr[i2] = (byte) (aVar.f72303f >>> i4);
                aVar.f72304g = i4 + 8;
                i3--;
                i2++;
            }
            if (i3 == 0) {
                return;
            }
            int min = Math.min(f(aVar), i3 >> 2);
            if (min > 0) {
                int i5 = min << 2;
                System.arraycopy(aVar.f72298a, aVar.f72305h << 2, bArr, i2, i5);
                i2 += i5;
                i3 -= i5;
                aVar.f72305h += min;
            }
            if (i3 == 0) {
                return;
            }
            if (f(aVar) <= 0) {
                while (i3 > 0) {
                    try {
                        int read = aVar.f72301d.read(bArr, i2, i3);
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
                long j = aVar.f72303f;
                int i6 = aVar.f72304g;
                bArr[i2] = (byte) (j >>> i6);
                aVar.f72304g = i6 + 8;
                i3--;
                i2++;
            }
            a(aVar, false);
        }
    }

    public static void d(a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (i2 = aVar.f72304g) < 32) {
            return;
        }
        int[] iArr = aVar.f72299b;
        int i3 = aVar.f72305h;
        aVar.f72305h = i3 + 1;
        aVar.f72303f = (iArr[i3] << 32) | (aVar.f72303f >>> 32);
        aVar.f72304g = i2 - 32;
    }

    public static void e(a aVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, inputStream) == null) {
            if (aVar.f72301d == null) {
                h.b(aVar.f72300c, aVar.f72298a, aVar.f72299b);
                aVar.f72301d = inputStream;
                aVar.f72303f = 0L;
                aVar.f72304g = 64;
                aVar.f72305h = 1024;
                aVar.f72302e = false;
                h(aVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, aVar)) == null) {
            return (aVar.f72302e ? (aVar.f72306i + 3) >> 2 : 1024) - aVar.f72305h;
        }
        return invokeL.intValue;
    }

    public static void g(a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, aVar) == null) && (i2 = (64 - aVar.f72304g) & 7) != 0 && i(aVar, i2) != 0) {
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
            long j = aVar.f72303f;
            int i3 = aVar.f72304g;
            int i4 = ((int) (j >>> i3)) & ((1 << i2) - 1);
            aVar.f72304g = i3 + i2;
            return i4;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4.f72302e = true;
        r4.f72306i = r1;
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
        if (!(interceptable == null || interceptable.invokeL(65546, null, aVar) == null) || (i2 = aVar.f72305h) <= 1015) {
            return;
        }
        if (aVar.f72302e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i3 = i2 << 2;
        int i4 = 4096 - i3;
        byte[] bArr = aVar.f72298a;
        System.arraycopy(bArr, i3, bArr, 0, i4);
        aVar.f72305h = 0;
        while (true) {
            if (i4 >= 4096) {
                break;
            }
            try {
                int read = aVar.f72301d.read(aVar.f72298a, i4, 4096 - i4);
                if (read <= 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e2) {
                throw new BrotliRuntimeException("Failed to read input", e2);
            }
        }
        h.a(aVar.f72300c, i4 >> 2);
    }

    public static void k(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, aVar) == null) && aVar.f72304g == 64) {
            h(aVar);
        }
    }
}
