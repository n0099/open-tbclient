package g.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.b;
import g.d;
import g.h;
import g.o.a.v;
import g.o.a.y;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g.n.b<Throwable> a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile g.n.f<d.a, d.a> f45052b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile g.n.f<h.c, h.c> f45053c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g.n.f<b.f, b.f> f45054d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g.n.g<g.d, d.a, d.a> f45055e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile g.n.g<g.h, h.c, h.c> f45056f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile g.n.g<g.b, b.f, b.f> f45057g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g.n.f<g.g, g.g> f45058h;
    public static volatile g.n.f<g.g, g.g> i;
    public static volatile g.n.f<g.g, g.g> j;
    public static volatile g.n.f<g.n.a, g.n.a> k;
    public static volatile g.n.f<g.k, g.k> l;
    public static volatile g.n.f<g.k, g.k> m;
    public static volatile g.n.e<? extends ScheduledExecutorService> n;
    public static volatile g.n.f<Throwable, Throwable> o;
    public static volatile g.n.f<Throwable, Throwable> p;
    public static volatile g.n.f<Throwable, Throwable> q;
    public static volatile g.n.f<d.b, d.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g.n.f<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                g.r.f.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements g.n.f<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                g.r.f.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* renamed from: g.r.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2147c implements g.n.f<d.a, d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2147c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public d.a call(d.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                g.r.f.c().d().a(aVar);
                return aVar;
            }
            return (d.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements g.n.f<h.c, h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public h.c call(h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                g.r.f.c().g().a(cVar);
                return cVar;
            }
            return (h.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements g.n.f<b.f, b.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public b.f call(b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                g.r.f.c().a().a(fVar);
                return fVar;
            }
            return (b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements g.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                g.r.f.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements g.n.g<g.d, d.a, d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.g
        public d.a call(g.d dVar, d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, aVar)) == null) {
                g.r.f.c().d().e(dVar, aVar);
                return aVar;
            }
            return (d.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements g.n.f<g.k, g.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public g.k call(g.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                g.r.f.c().d().d(kVar);
                return kVar;
            }
            return (g.k) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements g.n.g<g.h, h.c, h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.g
        public h.c call(g.h hVar, h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hVar, cVar)) == null) {
                g.r.h g2 = g.r.f.c().g();
                if (g2 == g.r.i.e()) {
                    return cVar;
                }
                y yVar = new y(cVar);
                g2.d(hVar, yVar);
                return new v(yVar);
            }
            return (h.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements g.n.f<g.k, g.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public g.k call(g.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                g.r.f.c().g().c(kVar);
                return kVar;
            }
            return (g.k) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements g.n.g<g.b, b.f, b.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.g
        public b.f call(g.b bVar, b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, fVar)) == null) {
                g.r.f.c().a().c(bVar, fVar);
                return fVar;
            }
            return (b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements g.n.f<g.n.a, g.n.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public g.n.a call(g.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                g.r.f.c().f().k(aVar);
                return aVar;
            }
            return (g.n.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements g.n.f<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                g.r.f.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements g.n.f<d.b, d.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public d.b call(d.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                g.r.f.c().d().b(bVar);
                return bVar;
            }
            return (d.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1726455529, "Lg/r/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1726455529, "Lg/r/c;");
                return;
            }
        }
        b();
    }

    public static g.n.e<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (g.n.e) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a = new f();
            f45055e = new g();
            l = new h();
            f45056f = new i();
            m = new j();
            f45057g = new k();
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
            f45052b = new C2147c();
            f45053c = new d();
            f45054d = new e();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            g.n.f<Throwable, Throwable> fVar = q;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> b.f e(g.b bVar, b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bVar, fVar)) == null) {
            g.n.g<g.b, b.f, b.f> gVar = f45057g;
            return gVar != null ? gVar.call(bVar, fVar) : fVar;
        }
        return (b.f) invokeLL.objValue;
    }

    public static g.g f(g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gVar)) == null) {
            g.n.f<g.g, g.g> fVar = f45058h;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (g.g) invokeL.objValue;
    }

    public static b.f g(b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            g.n.f<b.f, b.f> fVar2 = f45054d;
            return fVar2 != null ? fVar2.call(fVar) : fVar;
        }
        return (b.f) invokeL.objValue;
    }

    public static <T> d.a<T> h(d.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            g.n.f<d.a, d.a> fVar = f45052b;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (d.a) invokeL.objValue;
    }

    public static <T> h.c<T> i(h.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            g.n.f<h.c, h.c> fVar = f45053c;
            return fVar != null ? fVar.call(cVar) : cVar;
        }
        return (h.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            g.n.b<Throwable> bVar = a;
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

    public static g.g k(g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gVar)) == null) {
            g.n.f<g.g, g.g> fVar = i;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (g.g) invokeL.objValue;
    }

    public static g.g l(g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, gVar)) == null) {
            g.n.f<g.g, g.g> fVar = j;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (g.g) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            g.n.f<Throwable, Throwable> fVar = o;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> d.b<R, T> n(d.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            g.n.f<d.b, d.b> fVar = r;
            return fVar != null ? fVar.call(bVar) : bVar;
        }
        return (d.b) invokeL.objValue;
    }

    public static g.k o(g.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, kVar)) == null) {
            g.n.f<g.k, g.k> fVar = l;
            return fVar != null ? fVar.call(kVar) : kVar;
        }
        return (g.k) invokeL.objValue;
    }

    public static <T> d.a<T> p(g.d<T> dVar, d.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, dVar, aVar)) == null) {
            g.n.g<g.d, d.a, d.a> gVar = f45055e;
            return gVar != null ? gVar.call(dVar, aVar) : aVar;
        }
        return (d.a) invokeLL.objValue;
    }

    public static g.n.a q(g.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) {
            g.n.f<g.n.a, g.n.a> fVar = k;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (g.n.a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            g.n.f<Throwable, Throwable> fVar = p;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static g.k s(g.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, kVar)) == null) {
            g.n.f<g.k, g.k> fVar = m;
            return fVar != null ? fVar.call(kVar) : kVar;
        }
        return (g.k) invokeL.objValue;
    }

    public static <T> h.c<T> t(g.h<T> hVar, h.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, hVar, cVar)) == null) {
            g.n.g<g.h, h.c, h.c> gVar = f45056f;
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
