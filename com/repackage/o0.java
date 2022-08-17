package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w0<o0> a;
    public final w0<o0> b;
    public boolean c;
    public boolean d;
    public ComponentOperationHandler e;
    public x0<l0> f;
    public a7<l0> g;
    public d7 h;
    public d7 i;

    public o0() {
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
        this.f = new x0<>();
        this.g = new a7<>(false, 16);
        this.h = new d7();
        this.i = new d7();
        this.a = new w0<>();
        this.b = new w0<>();
    }

    public o0 a(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l0Var)) == null) {
            if (b(l0Var)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (o0) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.repackage.o0 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var)) == null) {
            Class<?> cls = l0Var.getClass();
            l0 d = d(cls);
            if (l0Var == d) {
                return false;
            }
            if (d != null) {
                k(cls);
            }
            int d2 = m0.d(cls);
            this.f.d(d2, l0Var);
            this.g.a(l0Var);
            this.h.k(d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public <T extends l0> T c(m0 m0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m0Var)) == null) {
            if (m0Var.c() < this.f.b()) {
                return (T) this.f.a(m0Var.c());
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public <T extends l0> T d(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) ? (T) c(m0.b(cls)) : (T) invokeL.objValue;
    }

    public d7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (d7) invokeV.objValue;
    }

    public d7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (d7) invokeV.objValue;
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

    public l0 i(Class<? extends l0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            l0 a = this.f.a(m0.b(cls).c());
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
        return (l0) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.repackage.o0 */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            a7<l0> a7Var = this.g;
            if (a7Var.b <= 0) {
                return;
            }
            i(a7Var.get(0).getClass());
        }
    }

    public boolean k(Class<? extends l0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c = m0.b(cls).c();
            l0 a = this.f.a(c);
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
