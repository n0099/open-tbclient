package d.f.b.a.a0.t;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes8.dex */
public final class i implements h {
    public static /* synthetic */ Interceptable $ic;
    public static final double[] n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69538a;

    /* renamed from: b  reason: collision with root package name */
    public d.f.b.a.a0.m f69539b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69540c;

    /* renamed from: d  reason: collision with root package name */
    public long f69541d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean[] f69542e;

    /* renamed from: f  reason: collision with root package name */
    public final a f69543f;

    /* renamed from: g  reason: collision with root package name */
    public long f69544g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69545h;

    /* renamed from: i  reason: collision with root package name */
    public long f69546i;
    public long j;
    public long k;
    public boolean l;
    public boolean m;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final byte[] f69547e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f69548a;

        /* renamed from: b  reason: collision with root package name */
        public int f69549b;

        /* renamed from: c  reason: collision with root package name */
        public int f69550c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f69551d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1348244939, "Ld/f/b/a/a0/t/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1348244939, "Ld/f/b/a/a0/t/i$a;");
                    return;
                }
            }
            f69547e = new byte[]{0, 0, 1};
        }

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f69551d = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.f69548a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f69551d;
                int length = bArr2.length;
                int i5 = this.f69549b;
                if (length < i5 + i4) {
                    this.f69551d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f69551d, this.f69549b, i4);
                this.f69549b += i4;
            }
        }

        public boolean b(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                if (this.f69548a) {
                    int i4 = this.f69549b - i3;
                    this.f69549b = i4;
                    if (this.f69550c == 0 && i2 == 181) {
                        this.f69550c = i4;
                    } else {
                        this.f69548a = false;
                        return true;
                    }
                } else if (i2 == 179) {
                    this.f69548a = true;
                }
                byte[] bArr = f69547e;
                a(bArr, 0, bArr.length);
                return false;
            }
            return invokeII.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f69548a = false;
                this.f69549b = 0;
                this.f69550c = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942728978, "Ld/f/b/a/a0/t/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942728978, "Ld/f/b/a/a0/t/i;");
                return;
            }
        }
        n = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69542e = new boolean[4];
        this.f69543f = new a(128);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Format, Long> a(a aVar, String str) {
        InterceptResult invokeLL;
        float f2;
        int i2;
        float f3;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, str)) == null) {
            byte[] copyOf = Arrays.copyOf(aVar.f69551d, aVar.f69549b);
            int i5 = copyOf[5] & 255;
            int i6 = ((copyOf[4] & 255) << 4) | (i5 >> 4);
            int i7 = ((i5 & 15) << 8) | (copyOf[6] & 255);
            int i8 = (copyOf[7] & 240) >> 4;
            if (i8 == 2) {
                f2 = i7 * 4;
                i2 = i6 * 3;
            } else if (i8 == 3) {
                f2 = i7 * 16;
                i2 = i6 * 9;
            } else if (i8 != 4) {
                f3 = 1.0f;
                Format createVideoSampleFormat = Format.createVideoSampleFormat(str, "video/mpeg2", null, -1, -1, i6, i7, -1.0f, Collections.singletonList(copyOf), -1, f3, null);
                long j = 0;
                i3 = (copyOf[7] & 15) - 1;
                if (i3 >= 0) {
                    double[] dArr = n;
                    if (i3 < dArr.length) {
                        double d2 = dArr[i3];
                        int i9 = aVar.f69550c + 9;
                        int i10 = (copyOf[i9] & 96) >> 5;
                        if (i10 != (copyOf[i9] & 31)) {
                            d2 *= (i10 + 1.0d) / (i4 + 1);
                        }
                        j = (long) (1000000.0d / d2);
                    }
                }
                return Pair.create(createVideoSampleFormat, Long.valueOf(j));
            } else {
                f2 = i7 * 121;
                i2 = i6 * 100;
            }
            f3 = f2 / i2;
            Format createVideoSampleFormat2 = Format.createVideoSampleFormat(str, "video/mpeg2", null, -1, -1, i6, i7, -1.0f, Collections.singletonList(copyOf), -1, f3, null);
            long j2 = 0;
            i3 = (copyOf[7] & 15) - 1;
            if (i3 >= 0) {
            }
            return Pair.create(createVideoSampleFormat2, Long.valueOf(j2));
        }
        return (Pair) invokeLL.objValue;
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.f.b.a.i0.j.a(this.f69542e);
            this.f69543f.c();
            this.f69544g = 0L;
            this.f69545h = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            int c2 = lVar.c();
            int d2 = lVar.d();
            byte[] bArr = lVar.f70489a;
            this.f69544g += lVar.a();
            this.f69539b.a(lVar, lVar.a());
            while (true) {
                int c3 = d.f.b.a.i0.j.c(bArr, c2, d2, this.f69542e);
                if (c3 == d2) {
                    break;
                }
                int i2 = c3 + 3;
                int i3 = lVar.f70489a[i2] & 255;
                if (!this.f69540c) {
                    int i4 = c3 - c2;
                    if (i4 > 0) {
                        this.f69543f.a(bArr, c2, c3);
                    }
                    if (this.f69543f.b(i3, i4 < 0 ? -i4 : 0)) {
                        Pair<Format, Long> a2 = a(this.f69543f, this.f69538a);
                        this.f69539b.b((Format) a2.first);
                        this.f69541d = ((Long) a2.second).longValue();
                        this.f69540c = true;
                    }
                }
                if (i3 == 0 || i3 == 179) {
                    int i5 = d2 - c3;
                    if (this.f69545h && this.m && this.f69540c) {
                        this.f69539b.c(this.k, this.l ? 1 : 0, ((int) (this.f69544g - this.j)) - i5, i5, null);
                    }
                    if (!this.f69545h || this.m) {
                        this.j = this.f69544g - i5;
                        long j = this.f69546i;
                        if (j == -9223372036854775807L) {
                            j = this.f69545h ? this.k + this.f69541d : 0L;
                        }
                        this.k = j;
                        this.l = false;
                        this.f69546i = -9223372036854775807L;
                        this.f69545h = true;
                    }
                    this.m = i3 == 0;
                } else if (i3 == 184) {
                    this.l = true;
                }
                c2 = i2;
            }
            if (this.f69540c) {
                return;
            }
            this.f69543f.a(bArr, c2, d2);
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f69546i = j;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            this.f69538a = dVar.b();
            this.f69539b = gVar.a(dVar.c(), 2);
        }
    }
}
