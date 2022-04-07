package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t0<l0> a;
    public final t0<l0> b;
    public boolean c;
    public boolean d;
    public ComponentOperationHandler e;
    public u0<i0> f;
    public y6<i0> g;
    public b7 h;
    public b7 i;

    public l0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new u0<>();
        this.g = new y6<>(false, 16);
        this.h = new b7();
        this.i = new b7();
        this.a = new t0<>();
        this.b = new t0<>();
    }

    public l0 a(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i0Var)) == null) {
            if (b(i0Var)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (l0) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.repackage.l0 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var)) == null) {
            Class<?> cls = i0Var.getClass();
            i0 d = d(cls);
            if (i0Var == d) {
                return false;
            }
            if (d != null) {
                k(cls);
            }
            int d2 = j0.d(cls);
            this.f.d(d2, i0Var);
            this.g.a(i0Var);
            this.h.k(d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public <T extends i0> T c(j0 j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j0Var)) == null) {
            if (j0Var.c() < this.f.b()) {
                return (T) this.f.a(j0Var.c());
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public <T extends i0> T d(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) ? (T) c(j0.b(cls)) : (T) invokeL.objValue;
    }

    public b7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (b7) invokeV.objValue;
    }

    public b7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (b7) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.b(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.b(this);
        }
    }

    public i0 i(Class<? extends i0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            i0 a = this.f.a(j0.b(cls).c());
            if (a != null && k(cls)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.c(this);
                } else {
                    h();
                }
            }
            return a;
        }
        return (i0) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.repackage.l0 */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            y6<i0> y6Var = this.g;
            if (y6Var.b <= 0) {
                return;
            }
            i(y6Var.get(0).getClass());
        }
    }

    public boolean k(Class<? extends i0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c = j0.b(cls).c();
            i0 a = this.f.a(c);
            if (a != null) {
                this.f.d(c, null);
                this.g.j(a, true);
                this.h.c(c);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
