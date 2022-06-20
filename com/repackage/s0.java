package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w7;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y0<o0> a;
    public w7<r0, a7<o0>> b;
    public w7<r0, y0<o0>> c;
    public g8<c> d;
    public w7<r0, d7> e;
    public b f;
    public boolean g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends z7<d7> {
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
        @Override // com.repackage.z7
        /* renamed from: g */
        public d7 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new d7() : (d7) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public p0 a;
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

    public s0(y0<o0> y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new w7<>();
        this.c = new w7<>();
        this.d = new g8<>(true, 16);
        this.e = new w7<>();
        this.f = new b(null);
        this.g = false;
        this.a = y0Var;
    }

    public void a(r0 r0Var, int i, p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, r0Var, i, p0Var) == null) {
            d(r0Var);
            int i2 = 0;
            while (true) {
                g8<c> g8Var = this.d;
                if (i2 >= g8Var.b || g8Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            w7.e<d7> n = this.e.n();
            n.d();
            while (n.hasNext()) {
                d7 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(r0Var).k(i2);
            c cVar = new c(null);
            cVar.a = p0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public y0<o0> b(r0 r0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r0Var)) == null) ? d(r0Var) : (y0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public final y0<o0> d(r0 r0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, r0Var)) == null) {
            y0<o0> c2 = this.c.c(r0Var);
            if (c2 == null) {
                a7<o0> a7Var = new a7<>(false, 16);
                y0<o0> y0Var = new y0<>(a7Var);
                this.b.i(r0Var, a7Var);
                this.c.i(r0Var, y0Var);
                this.e.i(r0Var, new d7());
                Iterator<o0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return y0Var;
            }
            return c2;
        }
        return (y0) invokeL.objValue;
    }

    public void e(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, p0Var) != null) {
            return;
        }
        int i = 0;
        while (true) {
            g8<c> g8Var = this.d;
            if (i >= g8Var.b) {
                return;
            }
            if (g8Var.get(i).a == p0Var) {
                w7.e<d7> n = this.e.n();
                n.d();
                while (n.hasNext()) {
                    d7 next = n.next();
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

    public void f(o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, o0Var) == null) {
            d7 e = this.f.e();
            d7 e2 = this.f.e();
            w7.c<r0> f = this.e.f();
            f.d();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                r0 next = f.next();
                int g = next.g();
                d7 f2 = o0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(o0Var) && !o0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    d7 c2 = this.e.c(next);
                    a7<o0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(o0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.j(o0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] p = this.d.p();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    p[i].a.a(o0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    p[i2].a.b(o0Var);
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
