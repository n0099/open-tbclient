package d.f.b.a.d0;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes10.dex */
public interface b {

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f72623a;

        /* renamed from: b  reason: collision with root package name */
        public final b f72624b;

        /* renamed from: c  reason: collision with root package name */
        public final long f72625c;

        /* renamed from: d.f.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2007a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.h0.g f72626e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f72627f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f72628g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f72629h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f72630i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC2007a(a aVar, d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r4;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.n = aVar;
                this.f72626e = gVar;
                this.f72627f = i2;
                this.f72628g = i3;
                this.f72629h = format;
                this.f72630i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f72624b.d(this.f72626e, this.f72627f, this.f72628g, this.f72629h, this.f72630i, this.j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: d.f.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2008b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.h0.g f72631e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f72632f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f72633g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f72634h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f72635i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC2008b(a aVar, d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.p = aVar;
                this.f72631e = gVar;
                this.f72632f = i2;
                this.f72633g = i3;
                this.f72634h = format;
                this.f72635i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
                this.n = j4;
                this.o = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.p.f72624b.e(this.f72631e, this.f72632f, this.f72633g, this.f72634h, this.f72635i, this.j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.h0.g f72636e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f72637f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f72638g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f72639h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f72640i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public c(a aVar, d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.p = aVar;
                this.f72636e = gVar;
                this.f72637f = i2;
                this.f72638g = i3;
                this.f72639h = format;
                this.f72640i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
                this.n = j4;
                this.o = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.p.f72624b.b(this.f72636e, this.f72637f, this.f72638g, this.f72639h, this.f72640i, this.j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.h0.g f72641e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f72642f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f72643g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f72644h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f72645i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ IOException p;
            public final /* synthetic */ boolean q;
            public final /* synthetic */ a r;

            public d(a aVar, d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.r = aVar;
                this.f72641e = gVar;
                this.f72642f = i2;
                this.f72643g = i3;
                this.f72644h = format;
                this.f72645i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
                this.n = j4;
                this.o = j5;
                this.p = iOException;
                this.q = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.r.f72624b.c(this.f72641e, this.f72642f, this.f72643g, this.f72644h, this.f72645i, this.j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f72646e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f72647f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f72648g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f72649h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f72650i;
            public final /* synthetic */ a j;

            public e(a aVar, int i2, Format format, int i3, Object obj, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = aVar;
                this.f72646e = i2;
                this.f72647f = format;
                this.f72648g = i3;
                this.f72649h = obj;
                this.f72650i = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.j.f72624b.a(this.f72646e, this.f72647f, this.f72648g, this.f72649h, this.j.c(this.f72650i));
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, b bVar) {
            this(handler, bVar, 0L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Handler) objArr2[0], (b) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final long c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long b2 = d.f.b.a.b.b(j);
                if (b2 == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return this.f72625c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new a(this.f72623a, this.f72624b, j) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j)}) == null) || this.f72624b == null) {
                return;
            }
            this.f72623a.post(new e(this, i2, format, i3, obj, j));
        }

        public void f(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.f72624b == null) {
                return;
            }
            this.f72623a.post(new c(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5));
        }

        public void g(d.f.b.a.h0.g gVar, int i2, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            }
        }

        public void h(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.f72624b == null) {
                return;
            }
            this.f72623a.post(new RunnableC2008b(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5));
        }

        public void i(d.f.b.a.h0.g gVar, int i2, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            }
        }

        public void j(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)}) == null) || this.f72624b == null) {
                return;
            }
            this.f72623a.post(new d(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5, iOException, z));
        }

        public void k(d.f.b.a.h0.g gVar, int i2, long j, long j2, long j3, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
            }
        }

        public void l(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f72624b == null) {
                return;
            }
            this.f72623a.post(new RunnableC2007a(this, gVar, i2, i3, format, i4, obj, j, j2, j3));
        }

        public void m(d.f.b.a.h0.g gVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                l(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
            }
        }

        public a(Handler handler, b bVar, long j) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, bVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (bVar != null) {
                d.f.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f72623a = handler2;
            this.f72624b = bVar;
            this.f72625c = j;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j);

    void b(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5);

    void c(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void d(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3);

    void e(d.f.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5);
}
