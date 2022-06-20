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
public class b44 implements tj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b44() {
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

    @Override // com.repackage.tj2
    public boolean a(Context context, im2 im2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, im2Var, bm2Var, sz2Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean b(Context context, dm2 dm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dm2Var, bm2Var, sz2Var)) == null) ? k44.e().c(context, dm2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean c(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, em2Var, bm2Var, sz2Var)) == null) ? j44.d().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public void d(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yl1Var) == null) {
            a44.h(yl1Var);
        }
    }

    @Override // com.repackage.tj2
    public boolean e(Context context, cm2 cm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, cm2Var, bm2Var, sz2Var)) == null) ? h54.h().c(context, cm2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public void f(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yl1Var) == null) {
            a44.d(yl1Var);
        }
    }

    @Override // com.repackage.tj2
    public boolean g(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, em2Var, bm2Var, sz2Var)) == null) ? e44.e().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean h(Context context, gm2 gm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, gm2Var, bm2Var, sz2Var)) == null) ? m44.e().c(context, gm2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public void i(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yl1Var) == null) {
            a44.e(yl1Var);
        }
    }

    @Override // com.repackage.tj2
    public boolean j(Context context, hm2 hm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, hm2Var, bm2Var, sz2Var)) == null) ? n44.e().c(context, hm2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean k(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, em2Var, bm2Var, sz2Var)) == null) ? h44.d().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean l(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, em2Var, bm2Var, sz2Var)) == null) ? f44.d().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean m(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, em2Var, bm2Var, sz2Var)) == null) ? l44.f().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean n(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, em2Var, bm2Var, sz2Var)) == null) ? i44.d().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.tj2
    public boolean update(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, em2Var, bm2Var, sz2Var)) == null) ? g44.d().c(context, em2Var, bm2Var, sz2Var) : invokeLLLL.booleanValue;
    }
}
