package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ql3 implements jl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rl3 a;
    public int b;
    public boolean c;

    public ql3(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        c(context);
    }

    @Override // com.repackage.jl3
    public void a() {
        rl3 rl3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c && (rl3Var = this.a) != null && rl3Var.c()) {
            this.c = false;
            if (this.a.b()) {
                g();
            } else {
                f();
            }
        }
    }

    @Override // com.repackage.jl3
    public void b(int i) {
        rl3 rl3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.c || (rl3Var = this.a) == null || !rl3Var.c()) {
            return;
        }
        this.c = true;
        if (this.a.b()) {
            e(i);
        } else {
            d(i);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = rl3.a(context);
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int g = this.a.g();
            this.b = g;
            if (g != -1) {
                pl3 f = wl3.f();
                int i2 = f.a;
                if (i2 < 1) {
                    i2 = 10;
                }
                int a = f.a() <= 0 ? 10000000 : f.a();
                int i3 = i2;
                this.a.h(this.b, 0, i3, -1, -1, -1);
                this.a.h(this.b, 2, i3, i2, -1, -1);
                int i4 = a;
                this.a.h(this.b, 4, i4, -1, -1, -1);
                this.a.h(this.b, 6, i4, a, -1, -1);
                this.a.h(this.b, 15, i2, i2, i2, i2);
                this.a.h(this.b, 17, a, a, a, a);
                this.a.e(this.b, i);
            }
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            pl3 f = wl3.f();
            int i2 = f.a;
            if (i2 < 1) {
                i2 = 10;
            }
            int a = f.a() <= 0 ? 10000000 : f.a();
            int f2 = this.a.f(i2, a, i2, a);
            this.b = f2;
            if (f2 != -1) {
                this.a.e(f2, i);
            }
        }
    }

    public final void f() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (i = this.b) == -1) {
            return;
        }
        this.a.d(i);
        this.a.j(this.b);
    }

    public final void g() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (i = this.b) == -1) {
            return;
        }
        this.a.d(i);
        this.a.i(this.b);
    }
}
