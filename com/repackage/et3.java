package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sz1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class et3 implements yo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public et3() {
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

    @Override // com.repackage.yo3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            sz1 V = wl2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    b03.f(appContext, R.string.obfuscated_res_0x7f0f019c).G();
                    return;
                }
                return;
            }
            jq2 d = jq2.d(str, str);
            d.h(jSONObject.toString());
            sz1.b i = V.i("adLanding");
            i.n(sz1.g, sz1.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.yo3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ht3.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.yo3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? ht3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.repackage.yo3
    public boolean d(View view2, sn3 sn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, sn3Var)) == null) ? ht3.a(view2, new pq2(sn3Var.c(), sn3Var.d(), sn3Var.e(), sn3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.repackage.yo3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = wl2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            wl2.U().W().g(true);
        }
    }

    @Override // com.repackage.yo3
    public boolean f(View view2, sn3 sn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, sn3Var)) == null) {
            ai1 W = wl2.U().W();
            return W != null && W.a(view2, new pq2(sn3Var.c(), sn3Var.d(), sn3Var.e(), sn3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.yo3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? ht3.d(view2) : invokeL.booleanValue;
    }
}
