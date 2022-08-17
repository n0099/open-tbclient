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
import com.repackage.pu9;
import com.repackage.ru9;
import com.repackage.vu9;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public final class yy9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fv9<Throwable> a;
    public static volatile jv9<ru9.a, ru9.a> b;
    public static volatile jv9<vu9.c, vu9.c> c;
    public static volatile jv9<pu9.f, pu9.f> d;
    public static volatile kv9<ru9, ru9.a, ru9.a> e;
    public static volatile kv9<vu9, vu9.c, vu9.c> f;
    public static volatile kv9<pu9, pu9.f, pu9.f> g;
    public static volatile jv9<uu9, uu9> h;
    public static volatile jv9<uu9, uu9> i;
    public static volatile jv9<uu9, uu9> j;
    public static volatile jv9<ev9, ev9> k;
    public static volatile jv9<yu9, yu9> l;
    public static volatile jv9<yu9, yu9> m;
    public static volatile iv9<? extends ScheduledExecutorService> n;
    public static volatile jv9<Throwable, Throwable> o;
    public static volatile jv9<Throwable, Throwable> p;
    public static volatile jv9<Throwable, Throwable> q;
    public static volatile jv9<ru9.b, ru9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements jv9<Throwable, Throwable> {
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
        @Override // com.repackage.jv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                bz9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements jv9<Throwable, Throwable> {
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
        @Override // com.repackage.jv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                bz9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements jv9<ru9.a, ru9.a> {
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
        @Override // com.repackage.jv9
        public ru9.a call(ru9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                bz9.c().d().a(aVar);
                return aVar;
            }
            return (ru9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements jv9<vu9.c, vu9.c> {
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
        @Override // com.repackage.jv9
        public vu9.c call(vu9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                bz9.c().g().a(cVar);
                return cVar;
            }
            return (vu9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements jv9<pu9.f, pu9.f> {
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
        @Override // com.repackage.jv9
        public pu9.f call(pu9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                bz9.c().a().a(fVar);
                return fVar;
            }
            return (pu9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements fv9<Throwable> {
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
        @Override // com.repackage.fv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                bz9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements kv9<ru9, ru9.a, ru9.a> {
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
        @Override // com.repackage.kv9
        public ru9.a call(ru9 ru9Var, ru9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ru9Var, aVar)) == null) {
                bz9.c().d().e(ru9Var, aVar);
                return aVar;
            }
            return (ru9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements jv9<yu9, yu9> {
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
        @Override // com.repackage.jv9
        public yu9 call(yu9 yu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yu9Var)) == null) {
                bz9.c().d().d(yu9Var);
                return yu9Var;
            }
            return (yu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements kv9<vu9, vu9.c, vu9.c> {
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
        @Override // com.repackage.kv9
        public vu9.c call(vu9 vu9Var, vu9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vu9Var, cVar)) == null) {
                dz9 g = bz9.c().g();
                if (g == ez9.e()) {
                    return cVar;
                }
                jw9 jw9Var = new jw9(cVar);
                g.d(vu9Var, jw9Var);
                return new gw9(jw9Var);
            }
            return (vu9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements jv9<yu9, yu9> {
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
        @Override // com.repackage.jv9
        public yu9 call(yu9 yu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yu9Var)) == null) {
                bz9.c().g().c(yu9Var);
                return yu9Var;
            }
            return (yu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements kv9<pu9, pu9.f, pu9.f> {
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
        @Override // com.repackage.kv9
        public pu9.f call(pu9 pu9Var, pu9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pu9Var, fVar)) == null) {
                bz9.c().a().c(pu9Var, fVar);
                return fVar;
            }
            return (pu9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements jv9<ev9, ev9> {
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
        @Override // com.repackage.jv9
        public ev9 call(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) {
                bz9.c().f().k(ev9Var);
                return ev9Var;
            }
            return (ev9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements jv9<Throwable, Throwable> {
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
        @Override // com.repackage.jv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                bz9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements jv9<ru9.b, ru9.b> {
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
        @Override // com.repackage.jv9
        public ru9.b call(ru9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                bz9.c().d().b(bVar);
                return bVar;
            }
            return (ru9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755125320, "Lcom/repackage/yy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755125320, "Lcom/repackage/yy9;");
                return;
            }
        }
        b();
    }

    public static iv9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (iv9) invokeV.objValue;
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
            jv9<Throwable, Throwable> jv9Var = q;
            return jv9Var != null ? jv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> pu9.f e(pu9 pu9Var, pu9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, pu9Var, fVar)) == null) {
            kv9<pu9, pu9.f, pu9.f> kv9Var = g;
            return kv9Var != null ? kv9Var.call(pu9Var, fVar) : fVar;
        }
        return (pu9.f) invokeLL.objValue;
    }

    public static uu9 f(uu9 uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uu9Var)) == null) {
            jv9<uu9, uu9> jv9Var = h;
            return jv9Var != null ? jv9Var.call(uu9Var) : uu9Var;
        }
        return (uu9) invokeL.objValue;
    }

    public static pu9.f g(pu9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            jv9<pu9.f, pu9.f> jv9Var = d;
            return jv9Var != null ? jv9Var.call(fVar) : fVar;
        }
        return (pu9.f) invokeL.objValue;
    }

    public static <T> ru9.a<T> h(ru9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            jv9<ru9.a, ru9.a> jv9Var = b;
            return jv9Var != null ? jv9Var.call(aVar) : aVar;
        }
        return (ru9.a) invokeL.objValue;
    }

    public static <T> vu9.c<T> i(vu9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            jv9<vu9.c, vu9.c> jv9Var = c;
            return jv9Var != null ? jv9Var.call(cVar) : cVar;
        }
        return (vu9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            fv9<Throwable> fv9Var = a;
            if (fv9Var != null) {
                try {
                    fv9Var.call(th);
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

    public static uu9 k(uu9 uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uu9Var)) == null) {
            jv9<uu9, uu9> jv9Var = i;
            return jv9Var != null ? jv9Var.call(uu9Var) : uu9Var;
        }
        return (uu9) invokeL.objValue;
    }

    public static uu9 l(uu9 uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uu9Var)) == null) {
            jv9<uu9, uu9> jv9Var = j;
            return jv9Var != null ? jv9Var.call(uu9Var) : uu9Var;
        }
        return (uu9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            jv9<Throwable, Throwable> jv9Var = o;
            return jv9Var != null ? jv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> ru9.b<R, T> n(ru9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            jv9<ru9.b, ru9.b> jv9Var = r;
            return jv9Var != null ? jv9Var.call(bVar) : bVar;
        }
        return (ru9.b) invokeL.objValue;
    }

    public static yu9 o(yu9 yu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, yu9Var)) == null) {
            jv9<yu9, yu9> jv9Var = l;
            return jv9Var != null ? jv9Var.call(yu9Var) : yu9Var;
        }
        return (yu9) invokeL.objValue;
    }

    public static <T> ru9.a<T> p(ru9<T> ru9Var, ru9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, ru9Var, aVar)) == null) {
            kv9<ru9, ru9.a, ru9.a> kv9Var = e;
            return kv9Var != null ? kv9Var.call(ru9Var, aVar) : aVar;
        }
        return (ru9.a) invokeLL.objValue;
    }

    public static ev9 q(ev9 ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, ev9Var)) == null) {
            jv9<ev9, ev9> jv9Var = k;
            return jv9Var != null ? jv9Var.call(ev9Var) : ev9Var;
        }
        return (ev9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            jv9<Throwable, Throwable> jv9Var = p;
            return jv9Var != null ? jv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static yu9 s(yu9 yu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, yu9Var)) == null) {
            jv9<yu9, yu9> jv9Var = m;
            return jv9Var != null ? jv9Var.call(yu9Var) : yu9Var;
        }
        return (yu9) invokeL.objValue;
    }

    public static <T> vu9.c<T> t(vu9<T> vu9Var, vu9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, vu9Var, cVar)) == null) {
            kv9<vu9, vu9.c, vu9.c> kv9Var = f;
            return kv9Var != null ? kv9Var.call(vu9Var, cVar) : cVar;
        }
        return (vu9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
