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
/* loaded from: classes5.dex */
public class d54 implements vk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d54() {
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

    @Override // com.repackage.vk2
    public boolean a(Context context, kn2 kn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, kn2Var, dn2Var, u03Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean b(Context context, fn2 fn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fn2Var, dn2Var, u03Var)) == null) ? m54.e().c(context, fn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean c(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, gn2Var, dn2Var, u03Var)) == null) ? l54.d().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public void d(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, an1Var) == null) {
            c54.h(an1Var);
        }
    }

    @Override // com.repackage.vk2
    public boolean e(Context context, en2 en2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, en2Var, dn2Var, u03Var)) == null) ? j64.h().c(context, en2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public void f(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, an1Var) == null) {
            c54.d(an1Var);
        }
    }

    @Override // com.repackage.vk2
    public boolean g(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, gn2Var, dn2Var, u03Var)) == null) ? g54.e().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean h(Context context, in2 in2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, in2Var, dn2Var, u03Var)) == null) ? o54.e().c(context, in2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public void i(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, an1Var) == null) {
            c54.e(an1Var);
        }
    }

    @Override // com.repackage.vk2
    public boolean j(Context context, jn2 jn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, jn2Var, dn2Var, u03Var)) == null) ? p54.e().c(context, jn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean k(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, gn2Var, dn2Var, u03Var)) == null) ? j54.d().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean l(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, gn2Var, dn2Var, u03Var)) == null) ? h54.d().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean m(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, gn2Var, dn2Var, u03Var)) == null) ? n54.f().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean n(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, gn2Var, dn2Var, u03Var)) == null) ? k54.d().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.vk2
    public boolean update(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, gn2Var, dn2Var, u03Var)) == null) ? i54.d().c(context, gn2Var, dn2Var, u03Var) : invokeLLLL.booleanValue;
    }
}
