package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes7.dex */
public class q44 implements ik2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q44() {
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

    @Override // com.repackage.ik2
    public boolean a(Context context, xm2 xm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xm2Var, qm2Var, h03Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean b(Context context, sm2 sm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sm2Var, qm2Var, h03Var)) == null) ? z44.e().c(context, sm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean c(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tm2Var, qm2Var, h03Var)) == null) ? y44.d().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public void d(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nm1Var) == null) {
            p44.h(nm1Var);
        }
    }

    @Override // com.repackage.ik2
    public boolean e(Context context, rm2 rm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, rm2Var, qm2Var, h03Var)) == null) ? w54.h().c(context, rm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public void f(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nm1Var) == null) {
            p44.d(nm1Var);
        }
    }

    @Override // com.repackage.ik2
    public boolean g(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, tm2Var, qm2Var, h03Var)) == null) ? t44.e().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean h(Context context, vm2 vm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, vm2Var, qm2Var, h03Var)) == null) ? b54.e().c(context, vm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public void i(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nm1Var) == null) {
            p44.e(nm1Var);
        }
    }

    @Override // com.repackage.ik2
    public boolean j(Context context, wm2 wm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, wm2Var, qm2Var, h03Var)) == null) ? c54.e().c(context, wm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean k(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, tm2Var, qm2Var, h03Var)) == null) ? w44.d().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean l(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, tm2Var, qm2Var, h03Var)) == null) ? u44.d().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean m(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, tm2Var, qm2Var, h03Var)) == null) ? a54.f().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean n(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, tm2Var, qm2Var, h03Var)) == null) ? x44.d().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ik2
    public boolean update(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, tm2Var, qm2Var, h03Var)) == null) ? v44.d().c(context, tm2Var, qm2Var, h03Var) : invokeLLLL.booleanValue;
    }
}
