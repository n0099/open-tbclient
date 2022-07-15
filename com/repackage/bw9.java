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
import com.repackage.sr9;
import com.repackage.ur9;
import com.repackage.yr9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public final class bw9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile is9<Throwable> a;
    public static volatile ms9<ur9.a, ur9.a> b;
    public static volatile ms9<yr9.c, yr9.c> c;
    public static volatile ms9<sr9.f, sr9.f> d;
    public static volatile ns9<ur9, ur9.a, ur9.a> e;
    public static volatile ns9<yr9, yr9.c, yr9.c> f;
    public static volatile ns9<sr9, sr9.f, sr9.f> g;
    public static volatile ms9<xr9, xr9> h;
    public static volatile ms9<xr9, xr9> i;
    public static volatile ms9<xr9, xr9> j;
    public static volatile ms9<hs9, hs9> k;
    public static volatile ms9<bs9, bs9> l;
    public static volatile ms9<bs9, bs9> m;
    public static volatile ls9<? extends ScheduledExecutorService> n;
    public static volatile ms9<Throwable, Throwable> o;
    public static volatile ms9<Throwable, Throwable> p;
    public static volatile ms9<Throwable, Throwable> q;
    public static volatile ms9<ur9.b, ur9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ms9<Throwable, Throwable> {
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
        @Override // com.repackage.ms9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ew9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ms9<Throwable, Throwable> {
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
        @Override // com.repackage.ms9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ew9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements ms9<ur9.a, ur9.a> {
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
        @Override // com.repackage.ms9
        public ur9.a call(ur9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                ew9.c().d().a(aVar);
                return aVar;
            }
            return (ur9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements ms9<yr9.c, yr9.c> {
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
        @Override // com.repackage.ms9
        public yr9.c call(yr9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                ew9.c().g().a(cVar);
                return cVar;
            }
            return (yr9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements ms9<sr9.f, sr9.f> {
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
        @Override // com.repackage.ms9
        public sr9.f call(sr9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                ew9.c().a().a(fVar);
                return fVar;
            }
            return (sr9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements is9<Throwable> {
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
        @Override // com.repackage.is9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                ew9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements ns9<ur9, ur9.a, ur9.a> {
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
        @Override // com.repackage.ns9
        public ur9.a call(ur9 ur9Var, ur9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ur9Var, aVar)) == null) {
                ew9.c().d().e(ur9Var, aVar);
                return aVar;
            }
            return (ur9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements ms9<bs9, bs9> {
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
        @Override // com.repackage.ms9
        public bs9 call(bs9 bs9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bs9Var)) == null) {
                ew9.c().d().d(bs9Var);
                return bs9Var;
            }
            return (bs9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements ns9<yr9, yr9.c, yr9.c> {
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
        @Override // com.repackage.ns9
        public yr9.c call(yr9 yr9Var, yr9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yr9Var, cVar)) == null) {
                gw9 g = ew9.c().g();
                if (g == hw9.e()) {
                    return cVar;
                }
                mt9 mt9Var = new mt9(cVar);
                g.d(yr9Var, mt9Var);
                return new jt9(mt9Var);
            }
            return (yr9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements ms9<bs9, bs9> {
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
        @Override // com.repackage.ms9
        public bs9 call(bs9 bs9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bs9Var)) == null) {
                ew9.c().g().c(bs9Var);
                return bs9Var;
            }
            return (bs9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements ns9<sr9, sr9.f, sr9.f> {
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
        @Override // com.repackage.ns9
        public sr9.f call(sr9 sr9Var, sr9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sr9Var, fVar)) == null) {
                ew9.c().a().c(sr9Var, fVar);
                return fVar;
            }
            return (sr9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements ms9<hs9, hs9> {
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
        @Override // com.repackage.ms9
        public hs9 call(hs9 hs9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hs9Var)) == null) {
                ew9.c().f().k(hs9Var);
                return hs9Var;
            }
            return (hs9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements ms9<Throwable, Throwable> {
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
        @Override // com.repackage.ms9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ew9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements ms9<ur9.b, ur9.b> {
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
        @Override // com.repackage.ms9
        public ur9.b call(ur9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                ew9.c().d().b(bVar);
                return bVar;
            }
            return (ur9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755812435, "Lcom/repackage/bw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755812435, "Lcom/repackage/bw9;");
                return;
            }
        }
        b();
    }

    public static ls9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (ls9) invokeV.objValue;
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
            ms9<Throwable, Throwable> ms9Var = q;
            return ms9Var != null ? ms9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> sr9.f e(sr9 sr9Var, sr9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sr9Var, fVar)) == null) {
            ns9<sr9, sr9.f, sr9.f> ns9Var = g;
            return ns9Var != null ? ns9Var.call(sr9Var, fVar) : fVar;
        }
        return (sr9.f) invokeLL.objValue;
    }

    public static xr9 f(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xr9Var)) == null) {
            ms9<xr9, xr9> ms9Var = h;
            return ms9Var != null ? ms9Var.call(xr9Var) : xr9Var;
        }
        return (xr9) invokeL.objValue;
    }

    public static sr9.f g(sr9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            ms9<sr9.f, sr9.f> ms9Var = d;
            return ms9Var != null ? ms9Var.call(fVar) : fVar;
        }
        return (sr9.f) invokeL.objValue;
    }

    public static <T> ur9.a<T> h(ur9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            ms9<ur9.a, ur9.a> ms9Var = b;
            return ms9Var != null ? ms9Var.call(aVar) : aVar;
        }
        return (ur9.a) invokeL.objValue;
    }

    public static <T> yr9.c<T> i(yr9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            ms9<yr9.c, yr9.c> ms9Var = c;
            return ms9Var != null ? ms9Var.call(cVar) : cVar;
        }
        return (yr9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            is9<Throwable> is9Var = a;
            if (is9Var != null) {
                try {
                    is9Var.call(th);
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

    public static xr9 k(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, xr9Var)) == null) {
            ms9<xr9, xr9> ms9Var = i;
            return ms9Var != null ? ms9Var.call(xr9Var) : xr9Var;
        }
        return (xr9) invokeL.objValue;
    }

    public static xr9 l(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, xr9Var)) == null) {
            ms9<xr9, xr9> ms9Var = j;
            return ms9Var != null ? ms9Var.call(xr9Var) : xr9Var;
        }
        return (xr9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            ms9<Throwable, Throwable> ms9Var = o;
            return ms9Var != null ? ms9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> ur9.b<R, T> n(ur9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            ms9<ur9.b, ur9.b> ms9Var = r;
            return ms9Var != null ? ms9Var.call(bVar) : bVar;
        }
        return (ur9.b) invokeL.objValue;
    }

    public static bs9 o(bs9 bs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bs9Var)) == null) {
            ms9<bs9, bs9> ms9Var = l;
            return ms9Var != null ? ms9Var.call(bs9Var) : bs9Var;
        }
        return (bs9) invokeL.objValue;
    }

    public static <T> ur9.a<T> p(ur9<T> ur9Var, ur9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, ur9Var, aVar)) == null) {
            ns9<ur9, ur9.a, ur9.a> ns9Var = e;
            return ns9Var != null ? ns9Var.call(ur9Var, aVar) : aVar;
        }
        return (ur9.a) invokeLL.objValue;
    }

    public static hs9 q(hs9 hs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, hs9Var)) == null) {
            ms9<hs9, hs9> ms9Var = k;
            return ms9Var != null ? ms9Var.call(hs9Var) : hs9Var;
        }
        return (hs9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            ms9<Throwable, Throwable> ms9Var = p;
            return ms9Var != null ? ms9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static bs9 s(bs9 bs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bs9Var)) == null) {
            ms9<bs9, bs9> ms9Var = m;
            return ms9Var != null ? ms9Var.call(bs9Var) : bs9Var;
        }
        return (bs9) invokeL.objValue;
    }

    public static <T> yr9.c<T> t(yr9<T> yr9Var, yr9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, yr9Var, cVar)) == null) {
            ns9<yr9, yr9.c, yr9.c> ns9Var = f;
            return ns9Var != null ? ns9Var.call(yr9Var, cVar) : cVar;
        }
        return (yr9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
