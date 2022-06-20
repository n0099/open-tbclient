package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bv9;
import com.repackage.vu9;
import com.repackage.xu9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public final class ez9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lv9<Throwable> a;
    public static volatile pv9<xu9.a, xu9.a> b;
    public static volatile pv9<bv9.c, bv9.c> c;
    public static volatile pv9<vu9.f, vu9.f> d;
    public static volatile qv9<xu9, xu9.a, xu9.a> e;
    public static volatile qv9<bv9, bv9.c, bv9.c> f;
    public static volatile qv9<vu9, vu9.f, vu9.f> g;
    public static volatile pv9<av9, av9> h;
    public static volatile pv9<av9, av9> i;
    public static volatile pv9<av9, av9> j;
    public static volatile pv9<kv9, kv9> k;
    public static volatile pv9<ev9, ev9> l;
    public static volatile pv9<ev9, ev9> m;
    public static volatile ov9<? extends ScheduledExecutorService> n;
    public static volatile pv9<Throwable, Throwable> o;
    public static volatile pv9<Throwable, Throwable> p;
    public static volatile pv9<Throwable, Throwable> q;
    public static volatile pv9<xu9.b, xu9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements pv9<Throwable, Throwable> {
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
        @Override // com.repackage.pv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                hz9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements pv9<Throwable, Throwable> {
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
        @Override // com.repackage.pv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                hz9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements pv9<xu9.a, xu9.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
        @Override // com.repackage.pv9
        public xu9.a call(xu9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                hz9.c().d().a(aVar);
                return aVar;
            }
            return (xu9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements pv9<bv9.c, bv9.c> {
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
        @Override // com.repackage.pv9
        public bv9.c call(bv9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                hz9.c().g().a(cVar);
                return cVar;
            }
            return (bv9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements pv9<vu9.f, vu9.f> {
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
        @Override // com.repackage.pv9
        public vu9.f call(vu9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                hz9.c().a().a(fVar);
                return fVar;
            }
            return (vu9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements lv9<Throwable> {
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
        @Override // com.repackage.lv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                hz9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements qv9<xu9, xu9.a, xu9.a> {
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
        @Override // com.repackage.qv9
        public xu9.a call(xu9 xu9Var, xu9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xu9Var, aVar)) == null) {
                hz9.c().d().e(xu9Var, aVar);
                return aVar;
            }
            return (xu9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements pv9<ev9, ev9> {
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
        @Override // com.repackage.pv9
        public ev9 call(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) {
                hz9.c().d().d(ev9Var);
                return ev9Var;
            }
            return (ev9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements qv9<bv9, bv9.c, bv9.c> {
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
        @Override // com.repackage.qv9
        public bv9.c call(bv9 bv9Var, bv9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bv9Var, cVar)) == null) {
                jz9 g = hz9.c().g();
                if (g == kz9.e()) {
                    return cVar;
                }
                pw9 pw9Var = new pw9(cVar);
                g.d(bv9Var, pw9Var);
                return new mw9(pw9Var);
            }
            return (bv9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements pv9<ev9, ev9> {
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
        @Override // com.repackage.pv9
        public ev9 call(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) {
                hz9.c().g().c(ev9Var);
                return ev9Var;
            }
            return (ev9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements qv9<vu9, vu9.f, vu9.f> {
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
        @Override // com.repackage.qv9
        public vu9.f call(vu9 vu9Var, vu9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vu9Var, fVar)) == null) {
                hz9.c().a().c(vu9Var, fVar);
                return fVar;
            }
            return (vu9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements pv9<kv9, kv9> {
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
        @Override // com.repackage.pv9
        public kv9 call(kv9 kv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kv9Var)) == null) {
                hz9.c().f().k(kv9Var);
                return kv9Var;
            }
            return (kv9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements pv9<Throwable, Throwable> {
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
        @Override // com.repackage.pv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                hz9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements pv9<xu9.b, xu9.b> {
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
        @Override // com.repackage.pv9
        public xu9.b call(xu9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                hz9.c().d().b(bVar);
                return bVar;
            }
            return (xu9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755720179, "Lcom/repackage/ez9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755720179, "Lcom/repackage/ez9;");
                return;
            }
        }
        b();
    }

    public static ov9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (ov9) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a = new f();
            e = new g();
            l = new h();
            f = new i();
            m = new j();
            g = new k();
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
            b = new c();
            c = new d();
            d = new e();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            pv9<Throwable, Throwable> pv9Var = q;
            return pv9Var != null ? pv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> vu9.f e(vu9 vu9Var, vu9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, vu9Var, fVar)) == null) {
            qv9<vu9, vu9.f, vu9.f> qv9Var = g;
            return qv9Var != null ? qv9Var.call(vu9Var, fVar) : fVar;
        }
        return (vu9.f) invokeLL.objValue;
    }

    public static av9 f(av9 av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, av9Var)) == null) {
            pv9<av9, av9> pv9Var = h;
            return pv9Var != null ? pv9Var.call(av9Var) : av9Var;
        }
        return (av9) invokeL.objValue;
    }

    public static vu9.f g(vu9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            pv9<vu9.f, vu9.f> pv9Var = d;
            return pv9Var != null ? pv9Var.call(fVar) : fVar;
        }
        return (vu9.f) invokeL.objValue;
    }

    public static <T> xu9.a<T> h(xu9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            pv9<xu9.a, xu9.a> pv9Var = b;
            return pv9Var != null ? pv9Var.call(aVar) : aVar;
        }
        return (xu9.a) invokeL.objValue;
    }

    public static <T> bv9.c<T> i(bv9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            pv9<bv9.c, bv9.c> pv9Var = c;
            return pv9Var != null ? pv9Var.call(cVar) : cVar;
        }
        return (bv9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            lv9<Throwable> lv9Var = a;
            if (lv9Var != null) {
                try {
                    lv9Var.call(th);
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

    public static av9 k(av9 av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, av9Var)) == null) {
            pv9<av9, av9> pv9Var = i;
            return pv9Var != null ? pv9Var.call(av9Var) : av9Var;
        }
        return (av9) invokeL.objValue;
    }

    public static av9 l(av9 av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, av9Var)) == null) {
            pv9<av9, av9> pv9Var = j;
            return pv9Var != null ? pv9Var.call(av9Var) : av9Var;
        }
        return (av9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            pv9<Throwable, Throwable> pv9Var = o;
            return pv9Var != null ? pv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> xu9.b<R, T> n(xu9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            pv9<xu9.b, xu9.b> pv9Var = r;
            return pv9Var != null ? pv9Var.call(bVar) : bVar;
        }
        return (xu9.b) invokeL.objValue;
    }

    public static ev9 o(ev9 ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, ev9Var)) == null) {
            pv9<ev9, ev9> pv9Var = l;
            return pv9Var != null ? pv9Var.call(ev9Var) : ev9Var;
        }
        return (ev9) invokeL.objValue;
    }

    public static <T> xu9.a<T> p(xu9<T> xu9Var, xu9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, xu9Var, aVar)) == null) {
            qv9<xu9, xu9.a, xu9.a> qv9Var = e;
            return qv9Var != null ? qv9Var.call(xu9Var, aVar) : aVar;
        }
        return (xu9.a) invokeLL.objValue;
    }

    public static kv9 q(kv9 kv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, kv9Var)) == null) {
            pv9<kv9, kv9> pv9Var = k;
            return pv9Var != null ? pv9Var.call(kv9Var) : kv9Var;
        }
        return (kv9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            pv9<Throwable, Throwable> pv9Var = p;
            return pv9Var != null ? pv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static ev9 s(ev9 ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, ev9Var)) == null) {
            pv9<ev9, ev9> pv9Var = m;
            return pv9Var != null ? pv9Var.call(ev9Var) : ev9Var;
        }
        return (ev9) invokeL.objValue;
    }

    public static <T> bv9.c<T> t(bv9<T> bv9Var, bv9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, bv9Var, cVar)) == null) {
            qv9<bv9, bv9.c, bv9.c> qv9Var = f;
            return qv9Var != null ? qv9Var.call(bv9Var, cVar) : cVar;
        }
        return (bv9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
