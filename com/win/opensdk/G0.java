package com.win.opensdk;

import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes8.dex */
public class G0 implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ M0 a;

    public G0(N0 n0, M0 m0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n0, m0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            Log.e(MiPushClient.COMMAND_REGISTER, "onGlobalFocusChanged:" + view2 + ",newFocus:" + view3);
            M0 m0 = this.a;
            if (m0 != null) {
                m0.b();
            }
        }
    }
}
