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
import com.repackage.ou9;
import com.repackage.qu9;
import com.repackage.uu9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public final class xy9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ev9<Throwable> a;
    public static volatile iv9<qu9.a, qu9.a> b;
    public static volatile iv9<uu9.c, uu9.c> c;
    public static volatile iv9<ou9.f, ou9.f> d;
    public static volatile jv9<qu9, qu9.a, qu9.a> e;
    public static volatile jv9<uu9, uu9.c, uu9.c> f;
    public static volatile jv9<ou9, ou9.f, ou9.f> g;
    public static volatile iv9<tu9, tu9> h;
    public static volatile iv9<tu9, tu9> i;
    public static volatile iv9<tu9, tu9> j;
    public static volatile iv9<dv9, dv9> k;
    public static volatile iv9<xu9, xu9> l;
    public static volatile iv9<xu9, xu9> m;
    public static volatile hv9<? extends ScheduledExecutorService> n;
    public static volatile iv9<Throwable, Throwable> o;
    public static volatile iv9<Throwable, Throwable> p;
    public static volatile iv9<Throwable, Throwable> q;
    public static volatile iv9<qu9.b, qu9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements iv9<Throwable, Throwable> {
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
        @Override // com.repackage.iv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                az9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements iv9<Throwable, Throwable> {
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
        @Override // com.repackage.iv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                az9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements iv9<qu9.a, qu9.a> {
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
        @Override // com.repackage.iv9
        public qu9.a call(qu9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                az9.c().d().a(aVar);
                return aVar;
            }
            return (qu9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements iv9<uu9.c, uu9.c> {
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
        @Override // com.repackage.iv9
        public uu9.c call(uu9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                az9.c().g().a(cVar);
                return cVar;
            }
            return (uu9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements iv9<ou9.f, ou9.f> {
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
        @Override // com.repackage.iv9
        public ou9.f call(ou9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                az9.c().a().a(fVar);
                return fVar;
            }
            return (ou9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements ev9<Throwable> {
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
        @Override // com.repackage.ev9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                az9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements jv9<qu9, qu9.a, qu9.a> {
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
        @Override // com.repackage.jv9
        public qu9.a call(qu9 qu9Var, qu9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qu9Var, aVar)) == null) {
                az9.c().d().e(qu9Var, aVar);
                return aVar;
            }
            return (qu9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements iv9<xu9, xu9> {
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
        @Override // com.repackage.iv9
        public xu9 call(xu9 xu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xu9Var)) == null) {
                az9.c().d().d(xu9Var);
                return xu9Var;
            }
            return (xu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements jv9<uu9, uu9.c, uu9.c> {
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
        @Override // com.repackage.jv9
        public uu9.c call(uu9 uu9Var, uu9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uu9Var, cVar)) == null) {
                cz9 g = az9.c().g();
                if (g == dz9.e()) {
                    return cVar;
                }
                iw9 iw9Var = new iw9(cVar);
                g.d(uu9Var, iw9Var);
                return new fw9(iw9Var);
            }
            return (uu9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements iv9<xu9, xu9> {
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
        @Override // com.repackage.iv9
        public xu9 call(xu9 xu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xu9Var)) == null) {
                az9.c().g().c(xu9Var);
                return xu9Var;
            }
            return (xu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements jv9<ou9, ou9.f, ou9.f> {
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
        @Override // com.repackage.jv9
        public ou9.f call(ou9 ou9Var, ou9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ou9Var, fVar)) == null) {
                az9.c().a().c(ou9Var, fVar);
                return fVar;
            }
            return (ou9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements iv9<dv9, dv9> {
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
        @Override // com.repackage.iv9
        public dv9 call(dv9 dv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dv9Var)) == null) {
                az9.c().f().k(dv9Var);
                return dv9Var;
            }
            return (dv9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements iv9<Throwable, Throwable> {
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
        @Override // com.repackage.iv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                az9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements iv9<qu9.b, qu9.b> {
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
        @Override // com.repackage.iv9
        public qu9.b call(qu9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                az9.c().d().b(bVar);
                return bVar;
            }
            return (qu9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755155111, "Lcom/repackage/xy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755155111, "Lcom/repackage/xy9;");
                return;
            }
        }
        b();
    }

    public static hv9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (hv9) invokeV.objValue;
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
            iv9<Throwable, Throwable> iv9Var = q;
            return iv9Var != null ? iv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> ou9.f e(ou9 ou9Var, ou9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, ou9Var, fVar)) == null) {
            jv9<ou9, ou9.f, ou9.f> jv9Var = g;
            return jv9Var != null ? jv9Var.call(ou9Var, fVar) : fVar;
        }
        return (ou9.f) invokeLL.objValue;
    }

    public static tu9 f(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tu9Var)) == null) {
            iv9<tu9, tu9> iv9Var = h;
            return iv9Var != null ? iv9Var.call(tu9Var) : tu9Var;
        }
        return (tu9) invokeL.objValue;
    }

    public static ou9.f g(ou9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            iv9<ou9.f, ou9.f> iv9Var = d;
            return iv9Var != null ? iv9Var.call(fVar) : fVar;
        }
        return (ou9.f) invokeL.objValue;
    }

    public static <T> qu9.a<T> h(qu9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            iv9<qu9.a, qu9.a> iv9Var = b;
            return iv9Var != null ? iv9Var.call(aVar) : aVar;
        }
        return (qu9.a) invokeL.objValue;
    }

    public static <T> uu9.c<T> i(uu9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            iv9<uu9.c, uu9.c> iv9Var = c;
            return iv9Var != null ? iv9Var.call(cVar) : cVar;
        }
        return (uu9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            ev9<Throwable> ev9Var = a;
            if (ev9Var != null) {
                try {
                    ev9Var.call(th);
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

    public static tu9 k(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tu9Var)) == null) {
            iv9<tu9, tu9> iv9Var = i;
            return iv9Var != null ? iv9Var.call(tu9Var) : tu9Var;
        }
        return (tu9) invokeL.objValue;
    }

    public static tu9 l(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, tu9Var)) == null) {
            iv9<tu9, tu9> iv9Var = j;
            return iv9Var != null ? iv9Var.call(tu9Var) : tu9Var;
        }
        return (tu9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            iv9<Throwable, Throwable> iv9Var = o;
            return iv9Var != null ? iv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> qu9.b<R, T> n(qu9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            iv9<qu9.b, qu9.b> iv9Var = r;
            return iv9Var != null ? iv9Var.call(bVar) : bVar;
        }
        return (qu9.b) invokeL.objValue;
    }

    public static xu9 o(xu9 xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, xu9Var)) == null) {
            iv9<xu9, xu9> iv9Var = l;
            return iv9Var != null ? iv9Var.call(xu9Var) : xu9Var;
        }
        return (xu9) invokeL.objValue;
    }

    public static <T> qu9.a<T> p(qu9<T> qu9Var, qu9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, qu9Var, aVar)) == null) {
            jv9<qu9, qu9.a, qu9.a> jv9Var = e;
            return jv9Var != null ? jv9Var.call(qu9Var, aVar) : aVar;
        }
        return (qu9.a) invokeLL.objValue;
    }

    public static dv9 q(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, dv9Var)) == null) {
            iv9<dv9, dv9> iv9Var = k;
            return iv9Var != null ? iv9Var.call(dv9Var) : dv9Var;
        }
        return (dv9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            iv9<Throwable, Throwable> iv9Var = p;
            return iv9Var != null ? iv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static xu9 s(xu9 xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, xu9Var)) == null) {
            iv9<xu9, xu9> iv9Var = m;
            return iv9Var != null ? iv9Var.call(xu9Var) : xu9Var;
        }
        return (xu9) invokeL.objValue;
    }

    public static <T> uu9.c<T> t(uu9<T> uu9Var, uu9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, uu9Var, cVar)) == null) {
            jv9<uu9, uu9.c, uu9.c> jv9Var = f;
            return jv9Var != null ? jv9Var.call(uu9Var, cVar) : cVar;
        }
        return (uu9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
