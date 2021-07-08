package d.f.b.a.d0.v;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import d.f.b.a.d0.b;
import d.f.b.a.d0.l;
import d.f.b.a.d0.v.a;
import d.f.b.a.h0.e;
import d.f.b.a.h0.n;
import d.f.b.a.h0.o;
import d.f.b.a.i0.v;
import d.f.b.a.k;
import d.f.b.a.w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public final class c implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69903e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f69904f;

    /* renamed from: g  reason: collision with root package name */
    public final a.InterfaceC1978a f69905g;

    /* renamed from: h  reason: collision with root package name */
    public final int f69906h;

    /* renamed from: i  reason: collision with root package name */
    public final long f69907i;
    public final b.a j;
    public final o.a<? extends d.f.b.a.d0.v.g.b> k;
    public final e l;
    public final Object m;
    public final SparseArray<d.f.b.a.d0.v.b> n;
    public final Runnable o;
    public final Runnable p;
    public l.a q;
    public d.f.b.a.h0.e r;
    public Loader s;
    public n t;
    public Uri u;
    public long v;
    public long w;
    public d.f.b.a.d0.v.g.b x;
    public Handler y;
    public long z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69908e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69908e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f69908e.v();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69909e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69909e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f69909e.p(false);
            }
        }
    }

    /* renamed from: d.f.b.a.d0.v.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1979c extends w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f69910b;

        /* renamed from: c  reason: collision with root package name */
        public final long f69911c;

        /* renamed from: d  reason: collision with root package name */
        public final int f69912d;

        /* renamed from: e  reason: collision with root package name */
        public final long f69913e;

        /* renamed from: f  reason: collision with root package name */
        public final long f69914f;

        /* renamed from: g  reason: collision with root package name */
        public final long f69915g;

        /* renamed from: h  reason: collision with root package name */
        public final d.f.b.a.d0.v.g.b f69916h;

        public C1979c(long j, long j2, int i2, long j3, long j4, long j5, d.f.b.a.d0.v.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69910b = j;
            this.f69911c = j2;
            this.f69912d = i2;
            this.f69913e = j3;
            this.f69914f = j4;
            this.f69915g = j5;
            this.f69916h = bVar;
        }

        @Override // d.f.b.a.w
        public int b(Object obj) {
            InterceptResult invokeL;
            int intValue;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= (i2 = this.f69912d) && intValue < i2 + h()) {
                    return intValue - this.f69912d;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // d.f.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                d.f.b.a.i0.a.c(i2, 0, this.f69916h.b());
                Integer num = null;
                String str = z ? this.f69916h.a(i2).f69967a : null;
                if (z) {
                    int i3 = this.f69912d;
                    d.f.b.a.i0.a.c(i2, 0, this.f69916h.b());
                    num = Integer.valueOf(i3 + i2);
                }
                bVar.n(str, num, 0, this.f69916h.d(i2), d.f.b.a.b.a(this.f69916h.a(i2).f69968b - this.f69916h.a(0).f69968b) - this.f69913e);
                return bVar;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // d.f.b.a.w
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69916h.b() : invokeV.intValue;
        }

        @Override // d.f.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                d.f.b.a.i0.a.c(i2, 0, 1);
                long r = r(j);
                long j2 = this.f69910b;
                long j3 = this.f69911c;
                d.f.b.a.d0.v.g.b bVar = this.f69916h;
                cVar.d(null, j2, j3, true, bVar.f69946c, r, this.f69914f, 0, bVar.b() - 1, this.f69913e);
                return cVar;
            }
            return (w.c) invokeCommon.objValue;
        }

        @Override // d.f.b.a.w
        public int o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public final long r(long j) {
            InterceptResult invokeJ;
            d.f.b.a.d0.v.d i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                long j2 = this.f69915g;
                if (this.f69916h.f69946c) {
                    if (j > 0) {
                        j2 += j;
                        if (j2 > this.f69914f) {
                            return -9223372036854775807L;
                        }
                    }
                    long j3 = this.f69913e + j2;
                    long d2 = this.f69916h.d(0);
                    int i3 = 0;
                    while (i3 < this.f69916h.b() - 1 && j3 >= d2) {
                        j3 -= d2;
                        i3++;
                        d2 = this.f69916h.d(i3);
                    }
                    d.f.b.a.d0.v.g.e a2 = this.f69916h.a(i3);
                    int a3 = a2.a(2);
                    return (a3 == -1 || (i2 = a2.f69969c.get(a3).f69941c.get(0).i()) == null || i2.c(d2) == 0) ? j2 : (j2 + i2.f(i2.b(j3, d2))) - j3;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements o.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.b.a.h0.o.a
        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, inputStream)) == null) {
                String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
                } catch (ParseException e2) {
                    throw new ParserException(e2);
                }
            }
            return (Long) invokeLL.objValue;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public final class e implements Loader.a<o<d.f.b.a.d0.v.g.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69917e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69917e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: a */
        public void l(o<d.f.b.a.d0.v.g.b> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.f69917e.i(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: b */
        public void m(o<d.f.b.a.d0.v.g.b> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f69917e.j(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int n(o<d.f.b.a.d0.v.g.b> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) ? this.f69917e.k(oVar, j, j2, iOException) : invokeCommon.intValue;
        }

        public /* synthetic */ e(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes8.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f69918a;

        /* renamed from: b  reason: collision with root package name */
        public final long f69919b;

        /* renamed from: c  reason: collision with root package name */
        public final long f69920c;

        public f(boolean z, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69918a = z;
            this.f69919b = j;
            this.f69920c = j2;
        }

        public static f a(d.f.b.a.d0.v.g.e eVar, long j) {
            InterceptResult invokeLJ;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, eVar, j)) == null) {
                int size = eVar.f69969c.size();
                int i3 = 0;
                long j2 = Long.MAX_VALUE;
                int i4 = 0;
                boolean z = false;
                boolean z2 = false;
                long j3 = 0;
                while (i4 < size) {
                    d.f.b.a.d0.v.d i5 = eVar.f69969c.get(i4).f69941c.get(i3).i();
                    if (i5 == null) {
                        return new f(true, 0L, j);
                    }
                    z2 |= i5.g();
                    int c2 = i5.c(j);
                    if (c2 == 0) {
                        i2 = i4;
                        z = true;
                        j3 = 0;
                        j2 = 0;
                    } else if (z) {
                        i2 = i4;
                    } else {
                        int d2 = i5.d();
                        i2 = i4;
                        j3 = Math.max(j3, i5.f(d2));
                        if (c2 != -1) {
                            int i6 = (d2 + c2) - 1;
                            j2 = Math.min(j2, i5.f(i6) + i5.a(i6, j));
                        }
                    }
                    i4 = i2 + 1;
                    i3 = 0;
                }
                return new f(z2, j3, j2);
            }
            return (f) invokeLJ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class g implements Loader.a<o<Long>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69921e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69921e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: a */
        public void l(o<Long> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.f69921e.i(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: b */
        public void m(o<Long> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f69921e.l(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int n(o<Long> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) ? this.f69921e.m(oVar, j, j2, iOException) : invokeCommon.intValue;
        }

        public /* synthetic */ g(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h implements o.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.b.a.h0.o.a
        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, inputStream)) == null) ? Long.valueOf(v.D(new BufferedReader(new InputStreamReader(inputStream)).readLine())) : (Long) invokeLL.objValue;
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310332121, "Ld/f/b/a/d0/v/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(310332121, "Ld/f/b/a/d0/v/c;");
                return;
            }
        }
        k.a("goog.exo.dash");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, a.InterfaceC1978a interfaceC1978a, Handler handler, d.f.b.a.d0.b bVar) {
        this(uri, aVar, interfaceC1978a, 3, -1L, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, interfaceC1978a, handler, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (a.InterfaceC1978a) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (d.f.b.a.d0.b) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.d0.l
    public void a(d.f.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.q = aVar;
            if (this.f69903e) {
                this.t = new n.a();
                p(false);
                return;
            }
            this.r = this.f69904f.a();
            Loader loader = new Loader("Loader:DashMediaSource");
            this.s = loader;
            this.t = loader;
            this.y = new Handler();
            v();
        }
    }

    @Override // d.f.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.a();
        }
    }

    @Override // d.f.b.a.d0.l
    public d.f.b.a.d0.k d(l.b bVar, d.f.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2)) == null) {
            int i2 = bVar.f69812a;
            d.f.b.a.d0.v.b bVar3 = new d.f.b.a.d0.v.b(this.A + i2, this.x, i2, this.f69905g, this.f69906h, this.j.d(this.x.a(i2).f69968b), this.z, this.t, bVar2);
            this.n.put(bVar3.f69892e, bVar3);
            return bVar3;
        }
        return (d.f.b.a.d0.k) invokeLL.objValue;
    }

    @Override // d.f.b.a.d0.l
    public void e(d.f.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            d.f.b.a.d0.v.b bVar = (d.f.b.a.d0.v.b) kVar;
            bVar.v();
            this.n.remove(bVar.f69892e);
        }
    }

    @Override // d.f.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.r = null;
            this.t = null;
            Loader loader = this.s;
            if (loader != null) {
                loader.i();
                this.s = null;
            }
            this.v = 0L;
            this.w = 0L;
            this.x = null;
            Handler handler = this.y;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.y = null;
            }
            this.z = 0L;
            this.n.clear();
        }
    }

    public final long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.z != 0) {
                return d.f.b.a.b.a(SystemClock.elapsedRealtime() + this.z);
            }
            return d.f.b.a.b.a(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    public void i(o<?> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.g(oVar.f70437a, oVar.f70438b, j, j2, oVar.d());
        }
    }

    public void j(o<d.f.b.a.d0.v.g.b> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.i(oVar.f70437a, oVar.f70438b, j, j2, oVar.d());
            d.f.b.a.d0.v.g.b e2 = oVar.e();
            d.f.b.a.d0.v.g.b bVar = this.x;
            int i2 = 0;
            int b2 = bVar == null ? 0 : bVar.b();
            long j3 = e2.a(0).f69968b;
            while (i2 < b2 && this.x.a(i2).f69968b < j3) {
                i2++;
            }
            if (b2 - i2 > e2.b()) {
                Log.w("DashMediaSource", "Out of sync manifest");
                t();
                return;
            }
            this.x = e2;
            this.v = j - j2;
            this.w = j;
            if (e2.f69951h != null) {
                synchronized (this.m) {
                    if (oVar.f70437a.f70383a == this.u) {
                        this.u = this.x.f69951h;
                    }
                }
            }
            if (b2 == 0) {
                d.f.b.a.d0.v.g.k kVar = this.x.f69950g;
                if (kVar != null) {
                    q(kVar);
                    return;
                } else {
                    p(true);
                    return;
                }
            }
            this.A += i2;
            p(true);
        }
    }

    public int k(o<d.f.b.a.d0.v.g.b> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.j.k(oVar.f70437a, oVar.f70438b, j, j2, oVar.d(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public void l(o<Long> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.i(oVar.f70437a, oVar.f70438b, j, j2, oVar.d());
            o(oVar.e().longValue() - j);
        }
    }

    public int m(o<Long> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            this.j.k(oVar.f70437a, oVar.f70438b, j, j2, oVar.d(), iOException, true);
            n(iOException);
            return 2;
        }
        return invokeCommon.intValue;
    }

    public final void n(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iOException) == null) {
            Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
            p(true);
        }
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.z = j;
            p(true);
        }
    }

    public final void p(boolean z) {
        long j;
        boolean z2;
        long d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt >= this.A) {
                    this.n.valueAt(i2).x(this.x, keyAt - this.A);
                }
            }
            int b2 = this.x.b() - 1;
            f a2 = f.a(this.x.a(0), this.x.d(0));
            f a3 = f.a(this.x.a(b2), this.x.d(b2));
            long j2 = a2.f69919b;
            long j3 = a3.f69920c;
            long j4 = 0;
            if (!this.x.f69946c || a3.f69918a) {
                j = j2;
                z2 = false;
            } else {
                j3 = Math.min((h() - d.f.b.a.b.a(this.x.f69944a)) - d.f.b.a.b.a(this.x.a(b2).f69968b), j3);
                long j5 = this.x.f69948e;
                if (j5 != -9223372036854775807L) {
                    long a4 = j3 - d.f.b.a.b.a(j5);
                    while (a4 < 0 && b2 > 0) {
                        b2--;
                        a4 += this.x.d(b2);
                    }
                    if (b2 == 0) {
                        d2 = Math.max(j2, a4);
                    } else {
                        d2 = this.x.d(0);
                    }
                    j2 = d2;
                }
                j = j2;
                z2 = true;
            }
            long j6 = j3 - j;
            for (int i3 = 0; i3 < this.x.b() - 1; i3++) {
                j6 += this.x.d(i3);
            }
            d.f.b.a.d0.v.g.b bVar = this.x;
            if (bVar.f69946c) {
                long j7 = this.f69907i;
                if (j7 == -1) {
                    long j8 = bVar.f69949f;
                    if (j8 == -9223372036854775807L) {
                        j8 = 30000;
                    }
                    j7 = j8;
                }
                j4 = j6 - d.f.b.a.b.a(j7);
                if (j4 < 5000000) {
                    j4 = Math.min(5000000L, j6 / 2);
                }
            }
            d.f.b.a.d0.v.g.b bVar2 = this.x;
            long b3 = bVar2.f69944a + bVar2.a(0).f69968b + d.f.b.a.b.b(j);
            d.f.b.a.d0.v.g.b bVar3 = this.x;
            this.q.c(this, new C1979c(bVar3.f69944a, b3, this.A, j, j6, j4, bVar3), this.x);
            if (this.f69903e) {
                return;
            }
            this.y.removeCallbacks(this.p);
            if (z2) {
                this.y.postDelayed(this.p, 5000L);
            }
            if (z) {
                t();
            }
        }
    }

    public final void q(d.f.b.a.d0.v.g.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kVar) == null) {
            String str = kVar.f70001a;
            if (!v.a(str, "urn:mpeg:dash:utc:direct:2014") && !v.a(str, "urn:mpeg:dash:utc:direct:2012")) {
                if (!v.a(str, "urn:mpeg:dash:utc:http-iso:2014") && !v.a(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                    if (!v.a(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !v.a(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                        n(new IOException("Unsupported UTC timing scheme"));
                        return;
                    } else {
                        s(kVar, new h(null));
                        return;
                    }
                }
                s(kVar, new d(null));
                return;
            }
            r(kVar);
        }
    }

    public final void r(d.f.b.a.d0.v.g.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            try {
                o(v.D(kVar.f70002b) - this.w);
            } catch (ParserException e2) {
                n(e2);
            }
        }
    }

    public final void s(d.f.b.a.d0.v.g.k kVar, o.a<Long> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, kVar, aVar) == null) {
            u(new o(this.r, Uri.parse(kVar.f70002b), 5, aVar), new g(this, null), 1);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d.f.b.a.d0.v.g.b bVar = this.x;
            if (bVar.f69946c) {
                long j = bVar.f69947d;
                if (j == 0) {
                    j = 5000;
                }
                this.y.postDelayed(this.o, Math.max(0L, (this.v + j) - SystemClock.elapsedRealtime()));
            }
        }
    }

    public final <T> void u(o<T> oVar, Loader.a<o<T>> aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, oVar, aVar, i2) == null) {
            this.j.m(oVar.f70437a, oVar.f70438b, this.s.k(oVar, aVar, i2));
        }
    }

    public final void v() {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this.m) {
                uri = this.u;
            }
            u(new o(this.r, uri, 4, this.k), this.l, this.f69906h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, a.InterfaceC1978a interfaceC1978a, int i2, long j, Handler handler, d.f.b.a.d0.b bVar) {
        this(uri, aVar, new d.f.b.a.d0.v.g.c(), interfaceC1978a, i2, j, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, interfaceC1978a, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (o.a) objArr2[2], (a.InterfaceC1978a) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (d.f.b.a.d0.b) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, o.a<? extends d.f.b.a.d0.v.g.b> aVar2, a.InterfaceC1978a interfaceC1978a, int i2, long j, Handler handler, d.f.b.a.d0.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC1978a, i2, j, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, aVar, aVar2, interfaceC1978a, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d.f.b.a.d0.v.g.b) objArr2[0], (Uri) objArr2[1], (e.a) objArr2[2], (o.a) objArr2[3], (a.InterfaceC1978a) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (d.f.b.a.d0.b) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public c(d.f.b.a.d0.v.g.b bVar, Uri uri, e.a aVar, o.a<? extends d.f.b.a.d0.v.g.b> aVar2, a.InterfaceC1978a interfaceC1978a, int i2, long j, Handler handler, d.f.b.a.d0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, uri, aVar, aVar2, interfaceC1978a, Integer.valueOf(i2), Long.valueOf(j), handler, bVar2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.x = bVar;
        this.u = uri;
        this.f69904f = aVar;
        this.k = aVar2;
        this.f69905g = interfaceC1978a;
        this.f69906h = i2;
        this.f69907i = j;
        this.f69903e = bVar != null;
        this.j = new b.a(handler, bVar2);
        this.m = new Object();
        this.n = new SparseArray<>();
        if (this.f69903e) {
            d.f.b.a.i0.a.f(!bVar.f69946c);
            this.l = null;
            this.o = null;
            this.p = null;
            return;
        }
        this.l = new e(this, null);
        this.o = new a(this);
        this.p = new b(this);
    }
}
