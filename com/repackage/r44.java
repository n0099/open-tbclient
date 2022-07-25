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
public class r44 implements jk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r44() {
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

    @Override // com.repackage.jk2
    public boolean a(Context context, ym2 ym2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ym2Var, rm2Var, i03Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean b(Context context, tm2 tm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tm2Var, rm2Var, i03Var)) == null) ? a54.e().c(context, tm2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean c(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, um2Var, rm2Var, i03Var)) == null) ? z44.d().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public void d(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, om1Var) == null) {
            q44.h(om1Var);
        }
    }

    @Override // com.repackage.jk2
    public boolean e(Context context, sm2 sm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, sm2Var, rm2Var, i03Var)) == null) ? x54.h().c(context, sm2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public void f(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, om1Var) == null) {
            q44.d(om1Var);
        }
    }

    @Override // com.repackage.jk2
    public boolean g(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, um2Var, rm2Var, i03Var)) == null) ? u44.e().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean h(Context context, wm2 wm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, wm2Var, rm2Var, i03Var)) == null) ? c54.e().c(context, wm2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public void i(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, om1Var) == null) {
            q44.e(om1Var);
        }
    }

    @Override // com.repackage.jk2
    public boolean j(Context context, xm2 xm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, xm2Var, rm2Var, i03Var)) == null) ? d54.e().c(context, xm2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean k(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, um2Var, rm2Var, i03Var)) == null) ? x44.d().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean l(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, um2Var, rm2Var, i03Var)) == null) ? v44.d().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean m(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, um2Var, rm2Var, i03Var)) == null) ? b54.f().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean n(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, um2Var, rm2Var, i03Var)) == null) ? y44.d().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.jk2
    public boolean update(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, um2Var, rm2Var, i03Var)) == null) ? w44.d().c(context, um2Var, rm2Var, i03Var) : invokeLLLL.booleanValue;
    }
}
