package i.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.b;
import i.d;
import i.h;
import i.o.a.v;
import i.o.a.y;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i.n.b<Throwable> a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile i.n.f<d.a, d.a> f62125b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i.n.f<h.c, h.c> f62126c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i.n.f<b.f, b.f> f62127d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile i.n.g<i.d, d.a, d.a> f62128e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile i.n.g<i.h, h.c, h.c> f62129f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile i.n.g<i.b, b.f, b.f> f62130g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile i.n.f<i.g, i.g> f62131h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile i.n.f<i.g, i.g> f62132i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile i.n.f<i.g, i.g> f62133j;
    public static volatile i.n.f<i.n.a, i.n.a> k;
    public static volatile i.n.f<i.k, i.k> l;
    public static volatile i.n.f<i.k, i.k> m;
    public static volatile i.n.e<? extends ScheduledExecutorService> n;
    public static volatile i.n.f<Throwable, Throwable> o;
    public static volatile i.n.f<Throwable, Throwable> p;
    public static volatile i.n.f<Throwable, Throwable> q;
    public static volatile i.n.f<d.b, d.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements i.n.f<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                i.r.f.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements i.n.f<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        @Override // i.n.f
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                i.r.f.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* renamed from: i.r.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2302c implements i.n.f<d.a, d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2302c() {
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
        @Override // i.n.f
        public d.a call(d.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                i.r.f.c().d().a(aVar);
                return aVar;
            }
            return (d.a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements i.n.f<h.c, h.c> {
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
        @Override // i.n.f
        public h.c call(h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                i.r.f.c().g().a(cVar);
                return cVar;
            }
            return (h.c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements i.n.f<b.f, b.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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
        @Override // i.n.f
        public b.f call(b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                i.r.f.c().a().a(fVar);
                return fVar;
            }
            return (b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements i.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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
        @Override // i.n.b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                i.r.f.c().b().a(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements i.n.g<i.d, d.a, d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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
        @Override // i.n.g
        public d.a call(i.d dVar, d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, aVar)) == null) {
                i.r.f.c().d().e(dVar, aVar);
                return aVar;
            }
            return (d.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements i.n.f<i.k, i.k> {
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
        @Override // i.n.f
        public i.k call(i.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                i.r.f.c().d().d(kVar);
                return kVar;
            }
            return (i.k) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements i.n.g<i.h, h.c, h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
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
        @Override // i.n.g
        public h.c call(i.h hVar, h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hVar, cVar)) == null) {
                i.r.h g2 = i.r.f.c().g();
                if (g2 == i.r.i.e()) {
                    return cVar;
                }
                y yVar = new y(cVar);
                g2.d(hVar, yVar);
                return new v(yVar);
            }
            return (h.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements i.n.f<i.k, i.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
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
        @Override // i.n.f
        public i.k call(i.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                i.r.f.c().g().c(kVar);
                return kVar;
            }
            return (i.k) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements i.n.g<i.b, b.f, b.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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
        @Override // i.n.g
        public b.f call(i.b bVar, b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, fVar)) == null) {
                i.r.f.c().a().c(bVar, fVar);
                return fVar;
            }
            return (b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements i.n.f<i.n.a, i.n.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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
        @Override // i.n.f
        public i.n.a call(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                i.r.f.c().f().k(aVar);
                return aVar;
            }
            return (i.n.a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements i.n.f<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
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
        @Override // i.n.f
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                i.r.f.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements i.n.f<d.b, d.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
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
        @Override // i.n.f
        public d.b call(d.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                i.r.f.c().d().b(bVar);
                return bVar;
            }
            return (d.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1783713831, "Li/r/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1783713831, "Li/r/c;");
                return;
            }
        }
        b();
    }

    public static i.n.e<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (i.n.e) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a = new f();
            f62128e = new g();
            l = new h();
            f62129f = new i();
            m = new j();
            f62130g = new k();
            k = new l();
            o = new m();
            r = new n();
            p = new a();
            q = new b();
            c();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f62125b = new C2302c();
            f62126c = new d();
            f62127d = new e();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            i.n.f<Throwable, Throwable> fVar = q;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> b.f e(i.b bVar, b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bVar, fVar)) == null) {
            i.n.g<i.b, b.f, b.f> gVar = f62130g;
            return gVar != null ? gVar.call(bVar, fVar) : fVar;
        }
        return (b.f) invokeLL.objValue;
    }

    public static i.g f(i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gVar)) == null) {
            i.n.f<i.g, i.g> fVar = f62131h;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (i.g) invokeL.objValue;
    }

    public static b.f g(b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            i.n.f<b.f, b.f> fVar2 = f62127d;
            return fVar2 != null ? fVar2.call(fVar) : fVar;
        }
        return (b.f) invokeL.objValue;
    }

    public static <T> d.a<T> h(d.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            i.n.f<d.a, d.a> fVar = f62125b;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (d.a) invokeL.objValue;
    }

    public static <T> h.c<T> i(h.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            i.n.f<h.c, h.c> fVar = f62126c;
            return fVar != null ? fVar.call(cVar) : cVar;
        }
        return (h.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            i.n.b<Throwable> bVar = a;
            if (bVar != null) {
                try {
                    bVar.call(th);
                    return;
                } catch (Throwable th2) {
                    PrintStream printStream = System.err;
                    printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                    th2.printStackTrace();
                    u(th2);
                }
            }
            u(th);
        }
    }

    public static i.g k(i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gVar)) == null) {
            i.n.f<i.g, i.g> fVar = f62132i;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (i.g) invokeL.objValue;
    }

    public static i.g l(i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, gVar)) == null) {
            i.n.f<i.g, i.g> fVar = f62133j;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (i.g) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            i.n.f<Throwable, Throwable> fVar = o;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> d.b<R, T> n(d.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            i.n.f<d.b, d.b> fVar = r;
            return fVar != null ? fVar.call(bVar) : bVar;
        }
        return (d.b) invokeL.objValue;
    }

    public static i.k o(i.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, kVar)) == null) {
            i.n.f<i.k, i.k> fVar = l;
            return fVar != null ? fVar.call(kVar) : kVar;
        }
        return (i.k) invokeL.objValue;
    }

    public static <T> d.a<T> p(i.d<T> dVar, d.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, dVar, aVar)) == null) {
            i.n.g<i.d, d.a, d.a> gVar = f62128e;
            return gVar != null ? gVar.call(dVar, aVar) : aVar;
        }
        return (d.a) invokeLL.objValue;
    }

    public static i.n.a q(i.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) {
            i.n.f<i.n.a, i.n.a> fVar = k;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (i.n.a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            i.n.f<Throwable, Throwable> fVar = p;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static i.k s(i.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, kVar)) == null) {
            i.n.f<i.k, i.k> fVar = m;
            return fVar != null ? fVar.call(kVar) : kVar;
        }
        return (i.k) invokeL.objValue;
    }

    public static <T> h.c<T> t(i.h<T> hVar, h.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, hVar, cVar)) == null) {
            i.n.g<i.h, h.c, h.c> gVar = f62129f;
            return gVar != null ? gVar.call(hVar, cVar) : cVar;
        }
        return (h.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
