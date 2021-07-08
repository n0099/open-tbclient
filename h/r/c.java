package h.r;

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
import h.b;
import h.d;
import h.h;
import h.o.a.a0;
import h.o.a.x;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile h.n.b<Throwable> f72717a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile h.n.f<d.a, d.a> f72718b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile h.n.f<h.c, h.c> f72719c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile h.n.f<b.f, b.f> f72720d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h.n.g<h.d, d.a, d.a> f72721e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile h.n.g<h.h, h.c, h.c> f72722f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile h.n.g<h.b, b.f, b.f> f72723g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile h.n.f<h.g, h.g> f72724h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile h.n.f<h.g, h.g> f72725i;
    public static volatile h.n.f<h.g, h.g> j;
    public static volatile h.n.f<h.n.a, h.n.a> k;
    public static volatile h.n.f<h.k, h.k> l;
    public static volatile h.n.f<h.k, h.k> m;
    public static volatile h.n.e<? extends ScheduledExecutorService> n;
    public static volatile h.n.f<Throwable, Throwable> o;
    public static volatile h.n.f<Throwable, Throwable> p;
    public static volatile h.n.f<Throwable, Throwable> q;
    public static volatile h.n.f<d.b, d.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements h.n.f<Throwable, Throwable> {
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
                h.r.f.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements h.n.f<Throwable, Throwable> {
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
                h.r.f.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* renamed from: h.r.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2079c implements h.n.f<d.a, d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2079c() {
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
                h.r.f.c().d().a(aVar);
                return aVar;
            }
            return (d.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ d.a call(d.a aVar) {
            d.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements h.n.f<h.c, h.c> {
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
                h.r.f.c().g().a(cVar);
                return cVar;
            }
            return (h.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ h.c call(h.c cVar) {
            h.c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements h.n.f<b.f, b.f> {
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
                h.r.f.c().a().a(fVar);
                return fVar;
            }
            return (b.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ b.f call(b.f fVar) {
            b.f fVar2 = fVar;
            a(fVar2);
            return fVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements h.n.b<Throwable> {
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
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                h.r.f.c().b().a(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements h.n.g<h.d, d.a, d.a> {
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
        @Override // h.n.g
        public /* bridge */ /* synthetic */ d.a a(h.d dVar, d.a aVar) {
            d.a aVar2 = aVar;
            b(dVar, aVar2);
            return aVar2;
        }

        public d.a b(h.d dVar, d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, aVar)) == null) {
                h.r.f.c().d().e(dVar, aVar);
                return aVar;
            }
            return (d.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements h.n.f<h.k, h.k> {
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

        public h.k a(h.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                h.r.f.c().d().d(kVar);
                return kVar;
            }
            return (h.k) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ h.k call(h.k kVar) {
            h.k kVar2 = kVar;
            a(kVar2);
            return kVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements h.n.g<h.h, h.c, h.c> {
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
        @Override // h.n.g
        /* renamed from: b */
        public h.c a(h.h hVar, h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, cVar)) == null) {
                h.r.h g2 = h.r.f.c().g();
                if (g2 == h.r.i.e()) {
                    return cVar;
                }
                a0 a0Var = new a0(cVar);
                g2.d(hVar, a0Var);
                return new x(a0Var);
            }
            return (h.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j implements h.n.f<h.k, h.k> {
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

        public h.k a(h.k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kVar)) == null) {
                h.r.f.c().g().c(kVar);
                return kVar;
            }
            return (h.k) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ h.k call(h.k kVar) {
            h.k kVar2 = kVar;
            a(kVar2);
            return kVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class k implements h.n.g<h.b, b.f, b.f> {
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
        @Override // h.n.g
        public /* bridge */ /* synthetic */ b.f a(h.b bVar, b.f fVar) {
            b.f fVar2 = fVar;
            b(bVar, fVar2);
            return fVar2;
        }

        public b.f b(h.b bVar, b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fVar)) == null) {
                h.r.f.c().a().c(bVar, fVar);
                return fVar;
            }
            return (b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class l implements h.n.f<h.n.a, h.n.a> {
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

        public h.n.a a(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                h.r.f.c().f().k(aVar);
                return aVar;
            }
            return (h.n.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ h.n.a call(h.n.a aVar) {
            h.n.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements h.n.f<Throwable, Throwable> {
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
                h.r.f.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class n implements h.n.f<d.b, d.b> {
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
                h.r.f.c().d().b(bVar);
                return bVar;
            }
            return (d.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.n.f
        public /* bridge */ /* synthetic */ d.b call(d.b bVar) {
            d.b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1755084680, "Lh/r/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1755084680, "Lh/r/c;");
                return;
            }
        }
        b();
    }

    public static h.n.e<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (h.n.e) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f72717a = new f();
            f72721e = new g();
            l = new h();
            f72722f = new i();
            m = new j();
            f72723g = new k();
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
            f72718b = new C2079c();
            f72719c = new d();
            f72720d = new e();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            h.n.f<Throwable, Throwable> fVar = q;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> b.f e(h.b bVar, b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bVar, fVar)) == null) {
            h.n.g<h.b, b.f, b.f> gVar = f72723g;
            return gVar != null ? gVar.a(bVar, fVar) : fVar;
        }
        return (b.f) invokeLL.objValue;
    }

    public static h.g f(h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, gVar)) == null) {
            h.n.f<h.g, h.g> fVar = f72724h;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (h.g) invokeL.objValue;
    }

    public static b.f g(b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            h.n.f<b.f, b.f> fVar2 = f72720d;
            return fVar2 != null ? fVar2.call(fVar) : fVar;
        }
        return (b.f) invokeL.objValue;
    }

    public static <T> d.a<T> h(d.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            h.n.f<d.a, d.a> fVar = f72718b;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (d.a) invokeL.objValue;
    }

    public static <T> h.c<T> i(h.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            h.n.f<h.c, h.c> fVar = f72719c;
            return fVar != null ? fVar.call(cVar) : cVar;
        }
        return (h.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            h.n.b<Throwable> bVar = f72717a;
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

    public static h.g k(h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gVar)) == null) {
            h.n.f<h.g, h.g> fVar = f72725i;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (h.g) invokeL.objValue;
    }

    public static h.g l(h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, gVar)) == null) {
            h.n.f<h.g, h.g> fVar = j;
            return fVar != null ? fVar.call(gVar) : gVar;
        }
        return (h.g) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            h.n.f<Throwable, Throwable> fVar = o;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> d.b<R, T> n(d.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            h.n.f<d.b, d.b> fVar = r;
            return fVar != null ? fVar.call(bVar) : bVar;
        }
        return (d.b) invokeL.objValue;
    }

    public static h.k o(h.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, kVar)) == null) {
            h.n.f<h.k, h.k> fVar = l;
            return fVar != null ? fVar.call(kVar) : kVar;
        }
        return (h.k) invokeL.objValue;
    }

    public static <T> d.a<T> p(h.d<T> dVar, d.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, dVar, aVar)) == null) {
            h.n.g<h.d, d.a, d.a> gVar = f72721e;
            return gVar != null ? gVar.a(dVar, aVar) : aVar;
        }
        return (d.a) invokeLL.objValue;
    }

    public static h.n.a q(h.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) {
            h.n.f<h.n.a, h.n.a> fVar = k;
            return fVar != null ? fVar.call(aVar) : aVar;
        }
        return (h.n.a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            h.n.f<Throwable, Throwable> fVar = p;
            return fVar != null ? fVar.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static h.k s(h.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, kVar)) == null) {
            h.n.f<h.k, h.k> fVar = m;
            return fVar != null ? fVar.call(kVar) : kVar;
        }
        return (h.k) invokeL.objValue;
    }

    public static <T> h.c<T> t(h.h<T> hVar, h.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, hVar, cVar)) == null) {
            h.n.g<h.h, h.c, h.c> gVar = f72722f;
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
