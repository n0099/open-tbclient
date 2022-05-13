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
import com.repackage.ay9;
import com.repackage.ux9;
import com.repackage.wx9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public final class d2a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ky9<Throwable> a;
    public static volatile oy9<wx9.a, wx9.a> b;
    public static volatile oy9<ay9.c, ay9.c> c;
    public static volatile oy9<ux9.f, ux9.f> d;
    public static volatile py9<wx9, wx9.a, wx9.a> e;
    public static volatile py9<ay9, ay9.c, ay9.c> f;
    public static volatile py9<ux9, ux9.f, ux9.f> g;
    public static volatile oy9<zx9, zx9> h;
    public static volatile oy9<zx9, zx9> i;
    public static volatile oy9<zx9, zx9> j;
    public static volatile oy9<jy9, jy9> k;
    public static volatile oy9<dy9, dy9> l;
    public static volatile oy9<dy9, dy9> m;
    public static volatile ny9<? extends ScheduledExecutorService> n;
    public static volatile oy9<Throwable, Throwable> o;
    public static volatile oy9<Throwable, Throwable> p;
    public static volatile oy9<Throwable, Throwable> q;
    public static volatile oy9<wx9.b, wx9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements oy9<Throwable, Throwable> {
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
        @Override // com.repackage.oy9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                g2a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements oy9<Throwable, Throwable> {
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
        @Override // com.repackage.oy9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                g2a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements oy9<wx9.a, wx9.a> {
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
        @Override // com.repackage.oy9
        public wx9.a call(wx9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                g2a.c().d().a(aVar);
                return aVar;
            }
            return (wx9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements oy9<ay9.c, ay9.c> {
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
        @Override // com.repackage.oy9
        public ay9.c call(ay9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                g2a.c().g().a(cVar);
                return cVar;
            }
            return (ay9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements oy9<ux9.f, ux9.f> {
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
        @Override // com.repackage.oy9
        public ux9.f call(ux9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                g2a.c().a().a(fVar);
                return fVar;
            }
            return (ux9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements ky9<Throwable> {
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
        @Override // com.repackage.ky9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                g2a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements py9<wx9, wx9.a, wx9.a> {
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
        @Override // com.repackage.py9
        public wx9.a call(wx9 wx9Var, wx9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wx9Var, aVar)) == null) {
                g2a.c().d().e(wx9Var, aVar);
                return aVar;
            }
            return (wx9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements oy9<dy9, dy9> {
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
        @Override // com.repackage.oy9
        public dy9 call(dy9 dy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dy9Var)) == null) {
                g2a.c().d().d(dy9Var);
                return dy9Var;
            }
            return (dy9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements py9<ay9, ay9.c, ay9.c> {
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
        @Override // com.repackage.py9
        public ay9.c call(ay9 ay9Var, ay9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ay9Var, cVar)) == null) {
                i2a g = g2a.c().g();
                if (g == j2a.e()) {
                    return cVar;
                }
                oz9 oz9Var = new oz9(cVar);
                g.d(ay9Var, oz9Var);
                return new lz9(oz9Var);
            }
            return (ay9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements oy9<dy9, dy9> {
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
        @Override // com.repackage.oy9
        public dy9 call(dy9 dy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dy9Var)) == null) {
                g2a.c().g().c(dy9Var);
                return dy9Var;
            }
            return (dy9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements py9<ux9, ux9.f, ux9.f> {
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
        @Override // com.repackage.py9
        public ux9.f call(ux9 ux9Var, ux9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ux9Var, fVar)) == null) {
                g2a.c().a().c(ux9Var, fVar);
                return fVar;
            }
            return (ux9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements oy9<jy9, jy9> {
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
        @Override // com.repackage.oy9
        public jy9 call(jy9 jy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jy9Var)) == null) {
                g2a.c().f().k(jy9Var);
                return jy9Var;
            }
            return (jy9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements oy9<Throwable, Throwable> {
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
        @Override // com.repackage.oy9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                g2a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements oy9<wx9.b, wx9.b> {
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
        @Override // com.repackage.oy9
        public wx9.b call(wx9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                g2a.c().d().b(bVar);
                return bVar;
            }
            return (wx9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755817922, "Lcom/repackage/d2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755817922, "Lcom/repackage/d2a;");
                return;
            }
        }
        b();
    }

    public static ny9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (ny9) invokeV.objValue;
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
            oy9<Throwable, Throwable> oy9Var = q;
            return oy9Var != null ? oy9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> ux9.f e(ux9 ux9Var, ux9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, ux9Var, fVar)) == null) {
            py9<ux9, ux9.f, ux9.f> py9Var = g;
            return py9Var != null ? py9Var.call(ux9Var, fVar) : fVar;
        }
        return (ux9.f) invokeLL.objValue;
    }

    public static zx9 f(zx9 zx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, zx9Var)) == null) {
            oy9<zx9, zx9> oy9Var = h;
            return oy9Var != null ? oy9Var.call(zx9Var) : zx9Var;
        }
        return (zx9) invokeL.objValue;
    }

    public static ux9.f g(ux9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            oy9<ux9.f, ux9.f> oy9Var = d;
            return oy9Var != null ? oy9Var.call(fVar) : fVar;
        }
        return (ux9.f) invokeL.objValue;
    }

    public static <T> wx9.a<T> h(wx9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            oy9<wx9.a, wx9.a> oy9Var = b;
            return oy9Var != null ? oy9Var.call(aVar) : aVar;
        }
        return (wx9.a) invokeL.objValue;
    }

    public static <T> ay9.c<T> i(ay9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            oy9<ay9.c, ay9.c> oy9Var = c;
            return oy9Var != null ? oy9Var.call(cVar) : cVar;
        }
        return (ay9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            ky9<Throwable> ky9Var = a;
            if (ky9Var != null) {
                try {
                    ky9Var.call(th);
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

    public static zx9 k(zx9 zx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, zx9Var)) == null) {
            oy9<zx9, zx9> oy9Var = i;
            return oy9Var != null ? oy9Var.call(zx9Var) : zx9Var;
        }
        return (zx9) invokeL.objValue;
    }

    public static zx9 l(zx9 zx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, zx9Var)) == null) {
            oy9<zx9, zx9> oy9Var = j;
            return oy9Var != null ? oy9Var.call(zx9Var) : zx9Var;
        }
        return (zx9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            oy9<Throwable, Throwable> oy9Var = o;
            return oy9Var != null ? oy9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> wx9.b<R, T> n(wx9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            oy9<wx9.b, wx9.b> oy9Var = r;
            return oy9Var != null ? oy9Var.call(bVar) : bVar;
        }
        return (wx9.b) invokeL.objValue;
    }

    public static dy9 o(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, dy9Var)) == null) {
            oy9<dy9, dy9> oy9Var = l;
            return oy9Var != null ? oy9Var.call(dy9Var) : dy9Var;
        }
        return (dy9) invokeL.objValue;
    }

    public static <T> wx9.a<T> p(wx9<T> wx9Var, wx9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, wx9Var, aVar)) == null) {
            py9<wx9, wx9.a, wx9.a> py9Var = e;
            return py9Var != null ? py9Var.call(wx9Var, aVar) : aVar;
        }
        return (wx9.a) invokeLL.objValue;
    }

    public static jy9 q(jy9 jy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, jy9Var)) == null) {
            oy9<jy9, jy9> oy9Var = k;
            return oy9Var != null ? oy9Var.call(jy9Var) : jy9Var;
        }
        return (jy9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            oy9<Throwable, Throwable> oy9Var = p;
            return oy9Var != null ? oy9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static dy9 s(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, dy9Var)) == null) {
            oy9<dy9, dy9> oy9Var = m;
            return oy9Var != null ? oy9Var.call(dy9Var) : dy9Var;
        }
        return (dy9) invokeL.objValue;
    }

    public static <T> ay9.c<T> t(ay9<T> ay9Var, ay9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, ay9Var, cVar)) == null) {
            py9<ay9, ay9.c, ay9.c> py9Var = f;
            return py9Var != null ? py9Var.call(ay9Var, cVar) : cVar;
        }
        return (ay9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
