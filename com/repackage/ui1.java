package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rk1;
/* loaded from: classes7.dex */
public class ui1 implements rk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    public ui1() {
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

    @Override // com.repackage.rk1
    public void a(rk1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.onFinish();
    }

    @Override // com.repackage.rk1
    public void b(Activity activity, Bundle bundle, gh1 gh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, gh1Var) == null) {
            SwanAppAllianceLoginHelper.d.i(gh1Var);
        }
    }

    @Override // com.repackage.rk1
    public void c(ih1 ih1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ih1Var) == null) {
        }
    }

    @Override // com.repackage.rk1
    public String d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? fo1.a.a() : (String) invokeL.objValue;
    }

    @Override // com.repackage.rk1
    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            boolean g = SwanAppAllianceLoginHelper.d.g();
            this.a = Boolean.TRUE;
            return g;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.rk1
    public String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? fh4.b(context).a() : (String) invokeL.objValue;
    }

    @Override // com.repackage.rk1
    public void g(rk1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        cVar.b();
    }

    @Override // com.repackage.rk1
    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? io1.b.a() : (String) invokeL.objValue;
    }

    @Override // com.repackage.rk1
    public String i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? fh4.b(context).a() : (String) invokeL.objValue;
    }

    @Override // com.repackage.rk1
    public void j(gh1 gh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gh1Var) == null) {
        }
    }

    public boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (this.a == null) {
                e(context);
            }
            Boolean bool = this.a;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }
}
