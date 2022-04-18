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
import com.repackage.bz9;
import com.repackage.fz9;
import com.repackage.zy9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public final class j3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pz9<Throwable> a;
    public static volatile tz9<bz9.a, bz9.a> b;
    public static volatile tz9<fz9.c, fz9.c> c;
    public static volatile tz9<zy9.f, zy9.f> d;
    public static volatile uz9<bz9, bz9.a, bz9.a> e;
    public static volatile uz9<fz9, fz9.c, fz9.c> f;
    public static volatile uz9<zy9, zy9.f, zy9.f> g;
    public static volatile tz9<ez9, ez9> h;
    public static volatile tz9<ez9, ez9> i;
    public static volatile tz9<ez9, ez9> j;
    public static volatile tz9<oz9, oz9> k;
    public static volatile tz9<iz9, iz9> l;
    public static volatile tz9<iz9, iz9> m;
    public static volatile sz9<? extends ScheduledExecutorService> n;
    public static volatile tz9<Throwable, Throwable> o;
    public static volatile tz9<Throwable, Throwable> p;
    public static volatile tz9<Throwable, Throwable> q;
    public static volatile tz9<bz9.b, bz9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements tz9<Throwable, Throwable> {
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
        @Override // com.repackage.tz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                m3a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements tz9<Throwable, Throwable> {
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
        @Override // com.repackage.tz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                m3a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements tz9<bz9.a, bz9.a> {
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
        @Override // com.repackage.tz9
        public bz9.a call(bz9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                m3a.c().d().a(aVar);
                return aVar;
            }
            return (bz9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements tz9<fz9.c, fz9.c> {
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
        @Override // com.repackage.tz9
        public fz9.c call(fz9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                m3a.c().g().a(cVar);
                return cVar;
            }
            return (fz9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements tz9<zy9.f, zy9.f> {
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
        @Override // com.repackage.tz9
        public zy9.f call(zy9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                m3a.c().a().a(fVar);
                return fVar;
            }
            return (zy9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements pz9<Throwable> {
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
        @Override // com.repackage.pz9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                m3a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements uz9<bz9, bz9.a, bz9.a> {
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
        @Override // com.repackage.uz9
        public bz9.a call(bz9 bz9Var, bz9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bz9Var, aVar)) == null) {
                m3a.c().d().e(bz9Var, aVar);
                return aVar;
            }
            return (bz9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements tz9<iz9, iz9> {
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
        @Override // com.repackage.tz9
        public iz9 call(iz9 iz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iz9Var)) == null) {
                m3a.c().d().d(iz9Var);
                return iz9Var;
            }
            return (iz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements uz9<fz9, fz9.c, fz9.c> {
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
        @Override // com.repackage.uz9
        public fz9.c call(fz9 fz9Var, fz9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fz9Var, cVar)) == null) {
                o3a g = m3a.c().g();
                if (g == p3a.e()) {
                    return cVar;
                }
                u0a u0aVar = new u0a(cVar);
                g.d(fz9Var, u0aVar);
                return new r0a(u0aVar);
            }
            return (fz9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements tz9<iz9, iz9> {
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
        @Override // com.repackage.tz9
        public iz9 call(iz9 iz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iz9Var)) == null) {
                m3a.c().g().c(iz9Var);
                return iz9Var;
            }
            return (iz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements uz9<zy9, zy9.f, zy9.f> {
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
        @Override // com.repackage.uz9
        public zy9.f call(zy9 zy9Var, zy9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zy9Var, fVar)) == null) {
                m3a.c().a().c(zy9Var, fVar);
                return fVar;
            }
            return (zy9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements tz9<oz9, oz9> {
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
        @Override // com.repackage.tz9
        public oz9 call(oz9 oz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oz9Var)) == null) {
                m3a.c().f().k(oz9Var);
                return oz9Var;
            }
            return (oz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements tz9<Throwable, Throwable> {
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
        @Override // com.repackage.tz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                m3a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements tz9<bz9.b, bz9.b> {
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
        @Override // com.repackage.tz9
        public bz9.b call(bz9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                m3a.c().d().b(bVar);
                return bVar;
            }
            return (bz9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638215, "Lcom/repackage/j3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638215, "Lcom/repackage/j3a;");
                return;
            }
        }
        b();
    }

    public static sz9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (sz9) invokeV.objValue;
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
            tz9<Throwable, Throwable> tz9Var = q;
            return tz9Var != null ? tz9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> zy9.f e(zy9 zy9Var, zy9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, zy9Var, fVar)) == null) {
            uz9<zy9, zy9.f, zy9.f> uz9Var = g;
            return uz9Var != null ? uz9Var.call(zy9Var, fVar) : fVar;
        }
        return (zy9.f) invokeLL.objValue;
    }

    public static ez9 f(ez9 ez9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ez9Var)) == null) {
            tz9<ez9, ez9> tz9Var = h;
            return tz9Var != null ? tz9Var.call(ez9Var) : ez9Var;
        }
        return (ez9) invokeL.objValue;
    }

    public static zy9.f g(zy9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            tz9<zy9.f, zy9.f> tz9Var = d;
            return tz9Var != null ? tz9Var.call(fVar) : fVar;
        }
        return (zy9.f) invokeL.objValue;
    }

    public static <T> bz9.a<T> h(bz9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            tz9<bz9.a, bz9.a> tz9Var = b;
            return tz9Var != null ? tz9Var.call(aVar) : aVar;
        }
        return (bz9.a) invokeL.objValue;
    }

    public static <T> fz9.c<T> i(fz9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            tz9<fz9.c, fz9.c> tz9Var = c;
            return tz9Var != null ? tz9Var.call(cVar) : cVar;
        }
        return (fz9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            pz9<Throwable> pz9Var = a;
            if (pz9Var != null) {
                try {
                    pz9Var.call(th);
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

    public static ez9 k(ez9 ez9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ez9Var)) == null) {
            tz9<ez9, ez9> tz9Var = i;
            return tz9Var != null ? tz9Var.call(ez9Var) : ez9Var;
        }
        return (ez9) invokeL.objValue;
    }

    public static ez9 l(ez9 ez9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, ez9Var)) == null) {
            tz9<ez9, ez9> tz9Var = j;
            return tz9Var != null ? tz9Var.call(ez9Var) : ez9Var;
        }
        return (ez9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            tz9<Throwable, Throwable> tz9Var = o;
            return tz9Var != null ? tz9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> bz9.b<R, T> n(bz9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            tz9<bz9.b, bz9.b> tz9Var = r;
            return tz9Var != null ? tz9Var.call(bVar) : bVar;
        }
        return (bz9.b) invokeL.objValue;
    }

    public static iz9 o(iz9 iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, iz9Var)) == null) {
            tz9<iz9, iz9> tz9Var = l;
            return tz9Var != null ? tz9Var.call(iz9Var) : iz9Var;
        }
        return (iz9) invokeL.objValue;
    }

    public static <T> bz9.a<T> p(bz9<T> bz9Var, bz9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bz9Var, aVar)) == null) {
            uz9<bz9, bz9.a, bz9.a> uz9Var = e;
            return uz9Var != null ? uz9Var.call(bz9Var, aVar) : aVar;
        }
        return (bz9.a) invokeLL.objValue;
    }

    public static oz9 q(oz9 oz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, oz9Var)) == null) {
            tz9<oz9, oz9> tz9Var = k;
            return tz9Var != null ? tz9Var.call(oz9Var) : oz9Var;
        }
        return (oz9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            tz9<Throwable, Throwable> tz9Var = p;
            return tz9Var != null ? tz9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static iz9 s(iz9 iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, iz9Var)) == null) {
            tz9<iz9, iz9> tz9Var = m;
            return tz9Var != null ? tz9Var.call(iz9Var) : iz9Var;
        }
        return (iz9) invokeL.objValue;
    }

    public static <T> fz9.c<T> t(fz9<T> fz9Var, fz9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, fz9Var, cVar)) == null) {
            uz9<fz9, fz9.c, fz9.c> uz9Var = f;
            return uz9Var != null ? uz9Var.call(fz9Var, cVar) : cVar;
        }
        return (fz9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
