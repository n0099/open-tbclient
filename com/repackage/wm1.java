package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanWebModeWidget;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wm1 implements im1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wm1() {
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

    @Override // com.repackage.im1
    public qm1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new SwanWebModeWidget(context) : (qm1) invokeL.objValue;
    }

    @Override // com.repackage.im1
    public mm1 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new ez1(context) : (mm1) invokeL.objValue;
    }

    @Override // com.repackage.im1
    public qm1 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new dn1(context) : (qm1) invokeL.objValue;
    }

    @Override // com.repackage.im1
    public c22 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c22() : (c22) invokeV.objValue;
    }

    @Override // com.repackage.im1
    public nm1 e(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i)) == null) ? new SwanAppSlaveManager(context) : (nm1) invokeLI.objValue;
    }

    @Override // com.repackage.im1
    public qm1 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new wn1(context) : (qm1) invokeL.objValue;
    }

    @Override // com.repackage.im1
    public qm1 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new ao1(context) : (qm1) invokeL.objValue;
    }

    @Override // com.repackage.im1
    public d22 h(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, context, i)) == null) ? new e22().a(context, i) : (d22) invokeLI.objValue;
    }

    @Override // com.repackage.im1
    public qm1 i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? new SwanAppSimpleH5Widget(context) : (qm1) invokeL.objValue;
    }

    @Override // com.repackage.im1
    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i == 0 : invokeI.booleanValue;
    }
}
