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
import com.repackage.nu9;
import com.repackage.pu9;
import com.repackage.tu9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public final class wy9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dv9<Throwable> a;
    public static volatile hv9<pu9.a, pu9.a> b;
    public static volatile hv9<tu9.c, tu9.c> c;
    public static volatile hv9<nu9.f, nu9.f> d;
    public static volatile iv9<pu9, pu9.a, pu9.a> e;
    public static volatile iv9<tu9, tu9.c, tu9.c> f;
    public static volatile iv9<nu9, nu9.f, nu9.f> g;
    public static volatile hv9<su9, su9> h;
    public static volatile hv9<su9, su9> i;
    public static volatile hv9<su9, su9> j;
    public static volatile hv9<cv9, cv9> k;
    public static volatile hv9<wu9, wu9> l;
    public static volatile hv9<wu9, wu9> m;
    public static volatile gv9<? extends ScheduledExecutorService> n;
    public static volatile hv9<Throwable, Throwable> o;
    public static volatile hv9<Throwable, Throwable> p;
    public static volatile hv9<Throwable, Throwable> q;
    public static volatile hv9<pu9.b, pu9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements hv9<Throwable, Throwable> {
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
        @Override // com.repackage.hv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                zy9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements hv9<Throwable, Throwable> {
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
        @Override // com.repackage.hv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                zy9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements hv9<pu9.a, pu9.a> {
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
        @Override // com.repackage.hv9
        public pu9.a call(pu9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                zy9.c().d().a(aVar);
                return aVar;
            }
            return (pu9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements hv9<tu9.c, tu9.c> {
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
        @Override // com.repackage.hv9
        public tu9.c call(tu9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                zy9.c().g().a(cVar);
                return cVar;
            }
            return (tu9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements hv9<nu9.f, nu9.f> {
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
        @Override // com.repackage.hv9
        public nu9.f call(nu9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                zy9.c().a().a(fVar);
                return fVar;
            }
            return (nu9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements dv9<Throwable> {
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
        @Override // com.repackage.dv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                zy9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements iv9<pu9, pu9.a, pu9.a> {
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
        @Override // com.repackage.iv9
        public pu9.a call(pu9 pu9Var, pu9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pu9Var, aVar)) == null) {
                zy9.c().d().e(pu9Var, aVar);
                return aVar;
            }
            return (pu9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements hv9<wu9, wu9> {
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
        @Override // com.repackage.hv9
        public wu9 call(wu9 wu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wu9Var)) == null) {
                zy9.c().d().d(wu9Var);
                return wu9Var;
            }
            return (wu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements iv9<tu9, tu9.c, tu9.c> {
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
        @Override // com.repackage.iv9
        public tu9.c call(tu9 tu9Var, tu9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tu9Var, cVar)) == null) {
                bz9 g = zy9.c().g();
                if (g == cz9.e()) {
                    return cVar;
                }
                hw9 hw9Var = new hw9(cVar);
                g.d(tu9Var, hw9Var);
                return new ew9(hw9Var);
            }
            return (tu9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements hv9<wu9, wu9> {
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
        @Override // com.repackage.hv9
        public wu9 call(wu9 wu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wu9Var)) == null) {
                zy9.c().g().c(wu9Var);
                return wu9Var;
            }
            return (wu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements iv9<nu9, nu9.f, nu9.f> {
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
        @Override // com.repackage.iv9
        public nu9.f call(nu9 nu9Var, nu9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, nu9Var, fVar)) == null) {
                zy9.c().a().c(nu9Var, fVar);
                return fVar;
            }
            return (nu9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements hv9<cv9, cv9> {
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
        @Override // com.repackage.hv9
        public cv9 call(cv9 cv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cv9Var)) == null) {
                zy9.c().f().k(cv9Var);
                return cv9Var;
            }
            return (cv9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements hv9<Throwable, Throwable> {
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
        @Override // com.repackage.hv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                zy9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements hv9<pu9.b, pu9.b> {
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
        @Override // com.repackage.hv9
        public pu9.b call(pu9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                zy9.c().d().b(bVar);
                return bVar;
            }
            return (pu9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755184902, "Lcom/repackage/wy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755184902, "Lcom/repackage/wy9;");
                return;
            }
        }
        b();
    }

    public static gv9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (gv9) invokeV.objValue;
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
            hv9<Throwable, Throwable> hv9Var = q;
            return hv9Var != null ? hv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> nu9.f e(nu9 nu9Var, nu9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, nu9Var, fVar)) == null) {
            iv9<nu9, nu9.f, nu9.f> iv9Var = g;
            return iv9Var != null ? iv9Var.call(nu9Var, fVar) : fVar;
        }
        return (nu9.f) invokeLL.objValue;
    }

    public static su9 f(su9 su9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, su9Var)) == null) {
            hv9<su9, su9> hv9Var = h;
            return hv9Var != null ? hv9Var.call(su9Var) : su9Var;
        }
        return (su9) invokeL.objValue;
    }

    public static nu9.f g(nu9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            hv9<nu9.f, nu9.f> hv9Var = d;
            return hv9Var != null ? hv9Var.call(fVar) : fVar;
        }
        return (nu9.f) invokeL.objValue;
    }

    public static <T> pu9.a<T> h(pu9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            hv9<pu9.a, pu9.a> hv9Var = b;
            return hv9Var != null ? hv9Var.call(aVar) : aVar;
        }
        return (pu9.a) invokeL.objValue;
    }

    public static <T> tu9.c<T> i(tu9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            hv9<tu9.c, tu9.c> hv9Var = c;
            return hv9Var != null ? hv9Var.call(cVar) : cVar;
        }
        return (tu9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            dv9<Throwable> dv9Var = a;
            if (dv9Var != null) {
                try {
                    dv9Var.call(th);
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

    public static su9 k(su9 su9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, su9Var)) == null) {
            hv9<su9, su9> hv9Var = i;
            return hv9Var != null ? hv9Var.call(su9Var) : su9Var;
        }
        return (su9) invokeL.objValue;
    }

    public static su9 l(su9 su9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, su9Var)) == null) {
            hv9<su9, su9> hv9Var = j;
            return hv9Var != null ? hv9Var.call(su9Var) : su9Var;
        }
        return (su9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            hv9<Throwable, Throwable> hv9Var = o;
            return hv9Var != null ? hv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> pu9.b<R, T> n(pu9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            hv9<pu9.b, pu9.b> hv9Var = r;
            return hv9Var != null ? hv9Var.call(bVar) : bVar;
        }
        return (pu9.b) invokeL.objValue;
    }

    public static wu9 o(wu9 wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, wu9Var)) == null) {
            hv9<wu9, wu9> hv9Var = l;
            return hv9Var != null ? hv9Var.call(wu9Var) : wu9Var;
        }
        return (wu9) invokeL.objValue;
    }

    public static <T> pu9.a<T> p(pu9<T> pu9Var, pu9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, pu9Var, aVar)) == null) {
            iv9<pu9, pu9.a, pu9.a> iv9Var = e;
            return iv9Var != null ? iv9Var.call(pu9Var, aVar) : aVar;
        }
        return (pu9.a) invokeLL.objValue;
    }

    public static cv9 q(cv9 cv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, cv9Var)) == null) {
            hv9<cv9, cv9> hv9Var = k;
            return hv9Var != null ? hv9Var.call(cv9Var) : cv9Var;
        }
        return (cv9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            hv9<Throwable, Throwable> hv9Var = p;
            return hv9Var != null ? hv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static wu9 s(wu9 wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, wu9Var)) == null) {
            hv9<wu9, wu9> hv9Var = m;
            return hv9Var != null ? hv9Var.call(wu9Var) : wu9Var;
        }
        return (wu9) invokeL.objValue;
    }

    public static <T> tu9.c<T> t(tu9<T> tu9Var, tu9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, tu9Var, cVar)) == null) {
            iv9<tu9, tu9.c, tu9.c> iv9Var = f;
            return iv9Var != null ? iv9Var.call(tu9Var, cVar) : cVar;
        }
        return (tu9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
