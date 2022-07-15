package com.win.opensdk;

import android.util.Log;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes8.dex */
public class H0 implements ViewTreeObserver.OnWindowFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ N0 a;

    public H0(N0 n0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n0;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Log.e(MiPushClient.COMMAND_REGISTER, "onWindowFocusChanged:" + z);
            if (this.a.c != null) {
                Log.e(MiPushClient.COMMAND_REGISTER, "FocusChange000");
                this.a.c.a(z);
            }
        }
    }
}
