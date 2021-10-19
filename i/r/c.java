package i.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import i.o.a.a0;
import i.o.a.x;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile i.n.b<Throwable> f79258a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile i.n.f<d.a, d.a> f79259b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i.n.f<h.c, h.c> f79260c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i.n.f<b.f, b.f> f79261d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile i.n.g<i.d, d.a, d.a> f79262e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile i.n.g<i.h, h.c, h.c> f79263f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile i.n.g<i.b, b.f, b.f> f79264g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile i.n.f<i.g, i.g> f79265h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile i.n.f<i.g, i.g> f79266i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile i.n.f<i.g, i.g> f79267j;
    public static volatile i.n.f<i.n.a, i.n.a> k;
    public static volatile i.n.f<i.k, i.k> l;
    public static volatile i.n.f<i.k, i.k> m;
    public static volatile i.n.e<? extends ScheduledExecutorService> n;
    public static volatile i.n.f<Throwable, Throwable> o;
    public static volatile i.n.f<Throwable, Throwable> p;
    public static volatile i.n.f<Throwable, Throwable> q;
    public static volatile i.n.f<d.b, d.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
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

        public Throwable a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
                i.r.f.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes10.dex */
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

        public Throwable a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
                i.r.f.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* renamed from: i.r.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2140c implements i.n.f<d.a, d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2140c() {
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

        public d.a a(d.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                i.r.f.c().d().a(aVar);
                return aVar;
            }
            return (d.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ d.a call(d.a aVar) {
            d.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes10.dex */
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

        public h.c a(h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                i.r.f.c().g().a(cVar);
                return cVar;
            }
            return (h.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ h.c call(h.c cVar) {
            h.c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    /* loaded from: classes10.dex */
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

        public b.f a(b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                i.r.f.c().a().a(fVar);
                return fVar;
            }
            return (b.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ b.f call(b.f fVar) {
            b.f fVar2 = fVar;
            a(fVar2);
            return fVar2;
        }
    }

    /* loaded from: classes10.dex */
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
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                i.r.f.c().b().a(th);
            }
        }
    }

    /* loaded from: classes10.dex */
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.g
        public /* bridge */ /* synthetic */ d.a a(i.d dVar, d.a aVar) {
            d.a aVar2 = aVar;
            b(dVar, aVar2);
            return aVar2;
        }

        public d.a b(i.d dVar, d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, aVar)) == null) {
                i.r.f.c().d().e(dVar, aVar);
                return aVar;
            }
            return (d.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
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

        public i.k a(i.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                i.r.f.c().d().d(kVar);
                return kVar;
            }
            return (i.k) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ i.k call(i.k kVar) {
            i.k kVar2 = kVar;
            a(kVar2);
            return kVar2;
        }
    }

    /* loaded from: classes10.dex */
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
        /* renamed from: b */
        public h.c a(i.h hVar, h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, cVar)) == null) {
                i.r.h g2 = i.r.f.c().g();
                if (g2 == i.r.i.e()) {
                    return cVar;
                }
                a0 a0Var = new a0(cVar);
                g2.d(hVar, a0Var);
                return new x(a0Var);
            }
            return (h.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
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

        public i.k a(i.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                i.r.f.c().g().c(kVar);
                return kVar;
            }
            return (i.k) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ i.k call(i.k kVar) {
            i.k kVar2 = kVar;
            a(kVar2);
            return kVar2;
        }
    }

    /* loaded from: classes10.dex */
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.g
        public /* bridge */ /* synthetic */ b.f a(i.b bVar, b.f fVar) {
            b.f fVar2 = fVar;
            b(bVar, fVar2);
            return fVar2;
        }

        public b.f b(i.b bVar, b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fVar)) == null) {
                i.r.f.c().a().c(bVar, fVar);
                return fVar;
            }
            return (b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
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

        public i.n.a a(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                i.r.f.c().f().k(aVar);
                return aVar;
            }
            return (i.n.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ i.n.a call(i.n.a aVar) {
            i.n.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes10.dex */
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

        public Throwable a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
                i.r.f.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes10.dex */
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

        public d.b a(d.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                i.r.f.c().d().b(bVar);
                return bVar;
            }
            return (d.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // i.n.f
        public /* bridge */ /* synthetic */ d.b call(d.b bVar) {
            d.b bVar2 = bVar;
            a(bVar2);
            return bVar2;
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
            f79258a = new f();
            f79262e = new g();
            l = new h();
            f79263f = new i();
            m = new j();
            f79264g = new k();
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
            f79259b = new C2140c();
            f79260c = new d();
            f79261d = new e();
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bVar, fVar)) == null) {
            i.n.g<i.b, b.f, b.f> gVar = f79264g;
            return gVar != null ? gVar.a(bVar, fVar) : fVar;
        }
        return (b.f) invokeLL.objValue;
    }

    public static i.g f(i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, gVar)) == null) {
            i.n.f<i.g, i.g> fVar = f79265h;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (i.g) invokeL.objValue;
    }

    public static b.f g(b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            i.n.f<b.f, b.f> fVar2 = f79261d;
            return fVar2 != null ? fVar2.call(fVar) : fVar;
        }
        return (b.f) invokeL.objValue;
    }

    public static <T> d.a<T> h(d.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            i.n.f<d.a, d.a> fVar = f79259b;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (d.a) invokeL.objValue;
    }

    public static <T> h.c<T> i(h.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            i.n.f<h.c, h.c> fVar = f79260c;
            return fVar != null ? fVar.call(cVar) : cVar;
        }
        return (h.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            i.n.b<Throwable> bVar = f79258a;
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
            i.n.f<i.g, i.g> fVar = f79266i;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (i.g) invokeL.objValue;
    }

    public static i.g l(i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, gVar)) == null) {
            i.n.f<i.g, i.g> fVar = f79267j;
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
            i.n.g<i.d, d.a, d.a> gVar = f79262e;
            return gVar != null ? gVar.a(dVar, aVar) : aVar;
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
            i.n.g<i.h, h.c, h.c> gVar = f79263f;
            return gVar != null ? gVar.a(hVar, cVar) : cVar;
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
