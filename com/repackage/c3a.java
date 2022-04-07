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
import com.repackage.sy9;
import com.repackage.uy9;
import com.repackage.yy9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public final class c3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iz9<Throwable> a;
    public static volatile mz9<uy9.a, uy9.a> b;
    public static volatile mz9<yy9.c, yy9.c> c;
    public static volatile mz9<sy9.f, sy9.f> d;
    public static volatile nz9<uy9, uy9.a, uy9.a> e;
    public static volatile nz9<yy9, yy9.c, yy9.c> f;
    public static volatile nz9<sy9, sy9.f, sy9.f> g;
    public static volatile mz9<xy9, xy9> h;
    public static volatile mz9<xy9, xy9> i;
    public static volatile mz9<xy9, xy9> j;
    public static volatile mz9<hz9, hz9> k;
    public static volatile mz9<bz9, bz9> l;
    public static volatile mz9<bz9, bz9> m;
    public static volatile lz9<? extends ScheduledExecutorService> n;
    public static volatile mz9<Throwable, Throwable> o;
    public static volatile mz9<Throwable, Throwable> p;
    public static volatile mz9<Throwable, Throwable> q;
    public static volatile mz9<uy9.b, uy9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements mz9<Throwable, Throwable> {
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
        @Override // com.repackage.mz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                f3a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements mz9<Throwable, Throwable> {
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
        @Override // com.repackage.mz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                f3a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements mz9<uy9.a, uy9.a> {
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
        @Override // com.repackage.mz9
        public uy9.a call(uy9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                f3a.c().d().a(aVar);
                return aVar;
            }
            return (uy9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements mz9<yy9.c, yy9.c> {
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
        @Override // com.repackage.mz9
        public yy9.c call(yy9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                f3a.c().g().a(cVar);
                return cVar;
            }
            return (yy9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements mz9<sy9.f, sy9.f> {
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
        @Override // com.repackage.mz9
        public sy9.f call(sy9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                f3a.c().a().a(fVar);
                return fVar;
            }
            return (sy9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements iz9<Throwable> {
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
        @Override // com.repackage.iz9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                f3a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements nz9<uy9, uy9.a, uy9.a> {
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
        @Override // com.repackage.nz9
        public uy9.a call(uy9 uy9Var, uy9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uy9Var, aVar)) == null) {
                f3a.c().d().e(uy9Var, aVar);
                return aVar;
            }
            return (uy9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements mz9<bz9, bz9> {
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
        @Override // com.repackage.mz9
        public bz9 call(bz9 bz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bz9Var)) == null) {
                f3a.c().d().d(bz9Var);
                return bz9Var;
            }
            return (bz9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements nz9<yy9, yy9.c, yy9.c> {
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
        @Override // com.repackage.nz9
        public yy9.c call(yy9 yy9Var, yy9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yy9Var, cVar)) == null) {
                h3a g = f3a.c().g();
                if (g == i3a.e()) {
                    return cVar;
                }
                n0a n0aVar = new n0a(cVar);
                g.d(yy9Var, n0aVar);
                return new k0a(n0aVar);
            }
            return (yy9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements mz9<bz9, bz9> {
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
        @Override // com.repackage.mz9
        public bz9 call(bz9 bz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bz9Var)) == null) {
                f3a.c().g().c(bz9Var);
                return bz9Var;
            }
            return (bz9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements nz9<sy9, sy9.f, sy9.f> {
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
        @Override // com.repackage.nz9
        public sy9.f call(sy9 sy9Var, sy9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sy9Var, fVar)) == null) {
                f3a.c().a().c(sy9Var, fVar);
                return fVar;
            }
            return (sy9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements mz9<hz9, hz9> {
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
        @Override // com.repackage.mz9
        public hz9 call(hz9 hz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hz9Var)) == null) {
                f3a.c().f().k(hz9Var);
                return hz9Var;
            }
            return (hz9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements mz9<Throwable, Throwable> {
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
        @Override // com.repackage.mz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                f3a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements mz9<uy9.b, uy9.b> {
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
        @Override // com.repackage.mz9
        public uy9.b call(uy9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                f3a.c().d().b(bVar);
                return bVar;
            }
            return (uy9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755846752, "Lcom/repackage/c3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755846752, "Lcom/repackage/c3a;");
                return;
            }
        }
        b();
    }

    public static lz9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (lz9) invokeV.objValue;
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
            mz9<Throwable, Throwable> mz9Var = q;
            return mz9Var != null ? mz9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> sy9.f e(sy9 sy9Var, sy9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sy9Var, fVar)) == null) {
            nz9<sy9, sy9.f, sy9.f> nz9Var = g;
            return nz9Var != null ? nz9Var.call(sy9Var, fVar) : fVar;
        }
        return (sy9.f) invokeLL.objValue;
    }

    public static xy9 f(xy9 xy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xy9Var)) == null) {
            mz9<xy9, xy9> mz9Var = h;
            return mz9Var != null ? mz9Var.call(xy9Var) : xy9Var;
        }
        return (xy9) invokeL.objValue;
    }

    public static sy9.f g(sy9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            mz9<sy9.f, sy9.f> mz9Var = d;
            return mz9Var != null ? mz9Var.call(fVar) : fVar;
        }
        return (sy9.f) invokeL.objValue;
    }

    public static <T> uy9.a<T> h(uy9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            mz9<uy9.a, uy9.a> mz9Var = b;
            return mz9Var != null ? mz9Var.call(aVar) : aVar;
        }
        return (uy9.a) invokeL.objValue;
    }

    public static <T> yy9.c<T> i(yy9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            mz9<yy9.c, yy9.c> mz9Var = c;
            return mz9Var != null ? mz9Var.call(cVar) : cVar;
        }
        return (yy9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            iz9<Throwable> iz9Var = a;
            if (iz9Var != null) {
                try {
                    iz9Var.call(th);
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

    public static xy9 k(xy9 xy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, xy9Var)) == null) {
            mz9<xy9, xy9> mz9Var = i;
            return mz9Var != null ? mz9Var.call(xy9Var) : xy9Var;
        }
        return (xy9) invokeL.objValue;
    }

    public static xy9 l(xy9 xy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, xy9Var)) == null) {
            mz9<xy9, xy9> mz9Var = j;
            return mz9Var != null ? mz9Var.call(xy9Var) : xy9Var;
        }
        return (xy9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            mz9<Throwable, Throwable> mz9Var = o;
            return mz9Var != null ? mz9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> uy9.b<R, T> n(uy9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            mz9<uy9.b, uy9.b> mz9Var = r;
            return mz9Var != null ? mz9Var.call(bVar) : bVar;
        }
        return (uy9.b) invokeL.objValue;
    }

    public static bz9 o(bz9 bz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bz9Var)) == null) {
            mz9<bz9, bz9> mz9Var = l;
            return mz9Var != null ? mz9Var.call(bz9Var) : bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    public static <T> uy9.a<T> p(uy9<T> uy9Var, uy9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, uy9Var, aVar)) == null) {
            nz9<uy9, uy9.a, uy9.a> nz9Var = e;
            return nz9Var != null ? nz9Var.call(uy9Var, aVar) : aVar;
        }
        return (uy9.a) invokeLL.objValue;
    }

    public static hz9 q(hz9 hz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, hz9Var)) == null) {
            mz9<hz9, hz9> mz9Var = k;
            return mz9Var != null ? mz9Var.call(hz9Var) : hz9Var;
        }
        return (hz9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            mz9<Throwable, Throwable> mz9Var = p;
            return mz9Var != null ? mz9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static bz9 s(bz9 bz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bz9Var)) == null) {
            mz9<bz9, bz9> mz9Var = m;
            return mz9Var != null ? mz9Var.call(bz9Var) : bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    public static <T> yy9.c<T> t(yy9<T> yy9Var, yy9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, yy9Var, cVar)) == null) {
            nz9<yy9, yy9.c, yy9.c> nz9Var = f;
            return nz9Var != null ? nz9Var.call(yy9Var, cVar) : cVar;
        }
        return (yy9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
