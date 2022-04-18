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
public class s44 implements kk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s44() {
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

    @Override // com.repackage.kk2
    public boolean a(Context context, zm2 zm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, zm2Var, sm2Var, j03Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean b(Context context, um2 um2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, um2Var, sm2Var, j03Var)) == null) ? b54.e().c(context, um2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean c(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, vm2Var, sm2Var, j03Var)) == null) ? a54.d().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public void d(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pm1Var) == null) {
            r44.h(pm1Var);
        }
    }

    @Override // com.repackage.kk2
    public boolean e(Context context, tm2 tm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, tm2Var, sm2Var, j03Var)) == null) ? y54.h().c(context, tm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public void f(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pm1Var) == null) {
            r44.d(pm1Var);
        }
    }

    @Override // com.repackage.kk2
    public boolean g(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, vm2Var, sm2Var, j03Var)) == null) ? v44.e().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean h(Context context, xm2 xm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, xm2Var, sm2Var, j03Var)) == null) ? d54.e().c(context, xm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public void i(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pm1Var) == null) {
            r44.e(pm1Var);
        }
    }

    @Override // com.repackage.kk2
    public boolean j(Context context, ym2 ym2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ym2Var, sm2Var, j03Var)) == null) ? e54.e().c(context, ym2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean k(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, vm2Var, sm2Var, j03Var)) == null) ? y44.d().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean l(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, vm2Var, sm2Var, j03Var)) == null) ? w44.d().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean m(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, vm2Var, sm2Var, j03Var)) == null) ? c54.f().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean n(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, vm2Var, sm2Var, j03Var)) == null) ? z44.d().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.kk2
    public boolean update(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, vm2Var, sm2Var, j03Var)) == null) ? x44.d().c(context, vm2Var, sm2Var, j03Var) : invokeLLLL.booleanValue;
    }
}
