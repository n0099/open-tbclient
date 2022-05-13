package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public final class m12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o12 a;
    public long b;

    public m12() {
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
        this.b = 0L;
        this.a = new o12();
    }

    public void a(k12 k12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k12Var) == null) {
            this.a.a(k12Var);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = this.a.d().size();
            int i = this.a.i();
            return i > 0 && (((double) size) * 1.0d) / ((double) i) > 0.5d;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<k12> d = this.a.d();
            if (d.size() <= 0) {
                return false;
            }
            for (k12 k12Var : d) {
                if (e62.k().i(k12Var.f)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((double) this.a.g().size()) >= 2.0d : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.i() <= 2 || System.currentTimeMillis() - this.b < 3000 : invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.a.f().size();
            int i = this.a.i();
            return i > 0 && (((double) size) * 1.0d) / ((double) i) > 0.5d;
        }
        return invokeV.booleanValue;
    }

    public n12 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            n12 n12Var = new n12();
            n12Var.i(this.b);
            n12Var.h(this.a.d());
            n12Var.k(this.a.g());
            n12Var.l(this.a.i());
            if (c()) {
                n12Var.j(RequestStatus.STATUS_CORE_FAILED);
            } else if (e()) {
                n12Var.j(RequestStatus.STATUS_UNKNOWN);
            } else if (f()) {
                n12Var.j(RequestStatus.STATUS_SERVER_FAILED);
            } else if (b()) {
                n12Var.j(RequestStatus.STATUS_FAILED);
            } else if (d()) {
                n12Var.j(RequestStatus.STATUS_SLOW);
            } else {
                n12Var.j(RequestStatus.STATUS_SUCCESS);
            }
            return n12Var;
        }
        return (n12) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.b();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = System.currentTimeMillis();
        }
    }
}
