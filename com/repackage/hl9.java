package com.repackage;

import android.util.Log;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes6.dex */
public class hl9 implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ViewTreeObserver a;

    public hl9(ml9 ml9Var, ViewTreeObserver viewTreeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ml9Var, viewTreeObserver};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewTreeObserver;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.e(MiPushClient.COMMAND_REGISTER, "onGlobalLayout:" + this.a.isAlive());
        }
    }
}
