package com.repackage;

import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes7.dex */
public class rk9 implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ jl9 a;

    public rk9(ml9 ml9Var, jl9 jl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ml9Var, jl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jl9Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            Log.e(MiPushClient.COMMAND_REGISTER, "onGlobalFocusChanged:" + view2 + ",newFocus:" + view3);
            jl9 jl9Var = this.a;
            if (jl9Var != null) {
                jl9Var.b();
            }
        }
    }
}
