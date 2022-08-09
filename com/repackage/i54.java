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
/* loaded from: classes6.dex */
public class i54 implements al2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i54() {
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

    @Override // com.repackage.al2
    public boolean a(Context context, pn2 pn2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pn2Var, in2Var, z03Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean b(Context context, kn2 kn2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, kn2Var, in2Var, z03Var)) == null) ? r54.e().c(context, kn2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean c(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ln2Var, in2Var, z03Var)) == null) ? q54.d().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public void d(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fn1Var) == null) {
            h54.h(fn1Var);
        }
    }

    @Override // com.repackage.al2
    public boolean e(Context context, jn2 jn2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, jn2Var, in2Var, z03Var)) == null) ? o64.h().c(context, jn2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public void f(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fn1Var) == null) {
            h54.d(fn1Var);
        }
    }

    @Override // com.repackage.al2
    public boolean g(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ln2Var, in2Var, z03Var)) == null) ? l54.e().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean h(Context context, nn2 nn2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, nn2Var, in2Var, z03Var)) == null) ? t54.e().c(context, nn2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public void i(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fn1Var) == null) {
            h54.e(fn1Var);
        }
    }

    @Override // com.repackage.al2
    public boolean j(Context context, on2 on2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, on2Var, in2Var, z03Var)) == null) ? u54.e().c(context, on2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean k(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ln2Var, in2Var, z03Var)) == null) ? o54.d().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean l(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ln2Var, in2Var, z03Var)) == null) ? m54.d().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean m(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ln2Var, in2Var, z03Var)) == null) ? s54.f().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean n(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ln2Var, in2Var, z03Var)) == null) ? p54.d().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.al2
    public boolean update(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ln2Var, in2Var, z03Var)) == null) ? n54.d().c(context, ln2Var, in2Var, z03Var) : invokeLLLL.booleanValue;
    }
}
