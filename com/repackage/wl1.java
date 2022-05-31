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
public class wl1 implements il1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wl1() {
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

    @Override // com.repackage.il1
    public ql1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new SwanWebModeWidget(context) : (ql1) invokeL.objValue;
    }

    @Override // com.repackage.il1
    public ml1 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new ey1(context) : (ml1) invokeL.objValue;
    }

    @Override // com.repackage.il1
    public ql1 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new dm1(context) : (ql1) invokeL.objValue;
    }

    @Override // com.repackage.il1
    public c12 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c12() : (c12) invokeV.objValue;
    }

    @Override // com.repackage.il1
    public nl1 e(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i)) == null) ? new SwanAppSlaveManager(context) : (nl1) invokeLI.objValue;
    }

    @Override // com.repackage.il1
    public ql1 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new wm1(context) : (ql1) invokeL.objValue;
    }

    @Override // com.repackage.il1
    public ql1 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new an1(context) : (ql1) invokeL.objValue;
    }

    @Override // com.repackage.il1
    public d12 h(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, context, i)) == null) ? new e12().a(context, i) : (d12) invokeLI.objValue;
    }

    @Override // com.repackage.il1
    public ql1 i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? new SwanAppSimpleH5Widget(context) : (ql1) invokeL.objValue;
    }

    @Override // com.repackage.il1
    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i == 0 : invokeI.booleanValue;
    }
}
