package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u7;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v0<l0> a;
    public u7<o0, y6<l0>> b;
    public u7<o0, v0<l0>> c;
    public e8<c> d;
    public u7<o0, b7> e;
    public b f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends x7<b7> {
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
        @Override // com.repackage.x7
        /* renamed from: g */
        public b7 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b7() : (b7) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m0 a;
        public int b;

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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public p0(v0<l0> v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new u7<>();
        this.c = new u7<>();
        this.d = new e8<>(true, 16);
        this.e = new u7<>();
        this.f = new b(null);
        this.g = false;
        this.a = v0Var;
    }

    public void a(o0 o0Var, int i, m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, o0Var, i, m0Var) == null) {
            d(o0Var);
            int i2 = 0;
            while (true) {
                e8<c> e8Var = this.d;
                if (i2 >= e8Var.b || e8Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            u7.e<b7> n = this.e.n();
            n.d();
            while (n.hasNext()) {
                b7 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(o0Var).k(i2);
            c cVar = new c(null);
            cVar.a = m0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public v0<l0> b(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o0Var)) == null) ? d(o0Var) : (v0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public final v0<l0> d(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, o0Var)) == null) {
            v0<l0> c2 = this.c.c(o0Var);
            if (c2 == null) {
                y6<l0> y6Var = new y6<>(false, 16);
                v0<l0> v0Var = new v0<>(y6Var);
                this.b.i(o0Var, y6Var);
                this.c.i(o0Var, v0Var);
                this.e.i(o0Var, new b7());
                Iterator<l0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return v0Var;
            }
            return c2;
        }
        return (v0) invokeL.objValue;
    }

    public void e(m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, m0Var) != null) {
            return;
        }
        int i = 0;
        while (true) {
            e8<c> e8Var = this.d;
            if (i >= e8Var.b) {
                return;
            }
            if (e8Var.get(i).a == m0Var) {
                u7.e<b7> n = this.e.n();
                n.d();
                while (n.hasNext()) {
                    b7 next = n.next();
                    int h = next.h();
                    int i2 = i;
                    while (i2 < h) {
                        int i3 = i2 + 1;
                        if (next.e(i3)) {
                            next.k(i2);
                        } else {
                            next.c(i2);
                        }
                        i2 = i3;
                    }
                }
                this.d.i(i);
                i--;
            }
            i++;
        }
    }

    public void f(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, l0Var) == null) {
            b7 e = this.f.e();
            b7 e2 = this.f.e();
            u7.c<o0> f = this.e.f();
            f.d();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                o0 next = f.next();
                int g = next.g();
                b7 f2 = l0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(l0Var) && !l0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    b7 c2 = this.e.c(next);
                    y6<l0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(l0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.j(l0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] p = this.d.p();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    p[i].a.a(l0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    p[i2].a.b(l0Var);
                }
            } finally {
                e.b();
                e2.b();
                this.f.c(e);
                this.f.c(e2);
                this.d.q();
                this.g = false;
            }
        }
    }
}
