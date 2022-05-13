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
import com.repackage.d02;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pt3 implements jp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pt3() {
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

    @Override // com.repackage.jp3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            d02 V = hm2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    m03.f(appContext, R.string.obfuscated_res_0x7f0f019e).G();
                    return;
                }
                return;
            }
            uq2 d = uq2.d(str, str);
            d.h(jSONObject.toString());
            d02.b i = V.i("adLanding");
            i.n(d02.g, d02.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.jp3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? st3.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.jp3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? st3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.repackage.jp3
    public boolean d(View view2, do3 do3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, do3Var)) == null) ? st3.a(view2, new ar2(do3Var.c(), do3Var.d(), do3Var.e(), do3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.repackage.jp3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            hm2.U().W().g(true);
        }
    }

    @Override // com.repackage.jp3
    public boolean f(View view2, do3 do3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, do3Var)) == null) {
            li1 W = hm2.U().W();
            return W != null && W.a(view2, new ar2(do3Var.c(), do3Var.d(), do3Var.e(), do3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.jp3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? st3.d(view2) : invokeL.booleanValue;
    }
}
