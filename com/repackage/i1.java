package com.repackage;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes6.dex */
public class i1 implements o8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j1 a;
    public final f1 b;
    public final k1 c;
    public final m8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile y6<f1> h;
    public volatile n8<Void> i;
    public volatile n8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public i1(j1 j1Var, f1 f1Var, k1 k1Var, m8 m8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var, f1Var, k1Var, m8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j1Var;
        this.b = f1Var;
        this.c = k1Var;
        this.d = m8Var;
        this.e = j1Var.m.d() == 3 ? k8.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l1 l1Var = (l1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            j1 j1Var = this.a;
                            f1 f1Var = this.b;
                            this.k = l1Var.d(j1Var, f1Var.a, d(this.c, f1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                j1 j1Var2 = this.a;
                f1 f1Var2 = this.b;
                this.k = l1Var.d(j1Var2, f1Var2.a, d(this.c, f1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    j1 j1Var3 = this.a;
                    f1 f1Var3 = this.b;
                    this.k = l1Var.d(j1Var3, f1Var3.a, d(this.c, f1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x1 x1Var = (x1) this.c;
            if (!this.g) {
                this.g = true;
                f1 f1Var = this.b;
                this.h = x1Var.a(f1Var.a, d(this.c, f1Var), this.b.c);
                if (this.h == null) {
                    j1 j1Var = this.a;
                    f1 f1Var2 = this.b;
                    this.k = x1Var.c(j1Var, f1Var2.a, d(this.c, f1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            j1 j1Var2 = this.a;
            f1 f1Var3 = this.b;
            this.k = x1Var.c(j1Var2, f1Var3.a, d(this.c, f1Var3), this.b.c);
        }
    }

    public final void c(y6<f1> y6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y6Var) == null) {
            boolean z = y6Var.c;
            y6Var.c = true;
            for (int i = 0; i < y6Var.b; i++) {
                String str = y6Var.get(i).a;
                GenericDeclaration genericDeclaration = y6Var.get(i).b;
                for (int i2 = y6Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == y6Var.get(i2).b && str.equals(y6Var.get(i2).a)) {
                        y6Var.i(i2);
                    }
                }
            }
            y6Var.c = z;
        }
    }

    public final h3 d(k1 k1Var, f1 f1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k1Var, f1Var)) == null) {
            if (f1Var.d == null) {
                f1Var.d = k1Var.b(f1Var.a);
            }
            return f1Var.d;
        }
        return (h3) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k1 k1Var = this.c;
            if (k1Var instanceof l1) {
                j1 j1Var = this.a;
                f1 f1Var = this.b;
                ((l1) k1Var).e(j1Var, f1Var.a, d(k1Var, f1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof x1) {
                b();
            } else {
                a();
            }
            return this.k != null;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            l1 l1Var = (l1) this.c;
            if (!this.g) {
                f1 f1Var = this.b;
                this.h = l1Var.a(f1Var.a, d(this.c, f1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    j1 j1Var = this.a;
                    f1 f1Var2 = this.b;
                    l1Var.c(j1Var, f1Var2.a, d(this.c, f1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                j1 j1Var2 = this.a;
                f1 f1Var3 = this.b;
                l1Var.c(j1Var2, f1Var3.a, d(this.c, f1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
