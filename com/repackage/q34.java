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
public class q34 implements ij2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q34() {
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

    @Override // com.repackage.ij2
    public boolean a(Context context, xl2 xl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xl2Var, ql2Var, hz2Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean b(Context context, sl2 sl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sl2Var, ql2Var, hz2Var)) == null) ? z34.e().c(context, sl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean c(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tl2Var, ql2Var, hz2Var)) == null) ? y34.d().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public void d(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nl1Var) == null) {
            p34.h(nl1Var);
        }
    }

    @Override // com.repackage.ij2
    public boolean e(Context context, rl2 rl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, rl2Var, ql2Var, hz2Var)) == null) ? w44.h().c(context, rl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public void f(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nl1Var) == null) {
            p34.d(nl1Var);
        }
    }

    @Override // com.repackage.ij2
    public boolean g(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, tl2Var, ql2Var, hz2Var)) == null) ? t34.e().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean h(Context context, vl2 vl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, vl2Var, ql2Var, hz2Var)) == null) ? b44.e().c(context, vl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public void i(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nl1Var) == null) {
            p34.e(nl1Var);
        }
    }

    @Override // com.repackage.ij2
    public boolean j(Context context, wl2 wl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, wl2Var, ql2Var, hz2Var)) == null) ? c44.e().c(context, wl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean k(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, tl2Var, ql2Var, hz2Var)) == null) ? w34.d().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean l(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, tl2Var, ql2Var, hz2Var)) == null) ? u34.d().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean m(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, tl2Var, ql2Var, hz2Var)) == null) ? a44.f().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean n(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, tl2Var, ql2Var, hz2Var)) == null) ? x34.d().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ij2
    public boolean update(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, tl2Var, ql2Var, hz2Var)) == null) ? v34.d().c(context, tl2Var, ql2Var, hz2Var) : invokeLLLL.booleanValue;
    }
}
