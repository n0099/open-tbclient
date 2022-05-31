package com.repackage;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nx2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class mx2 extends hv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mx2() {
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

    @Override // com.repackage.hv2
    public void b(Bundle params) {
        nx2.a b;
        nx2.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            String string = params.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
            String string2 = params.getString("swanId");
            String string3 = params.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            String string4 = params.getString("hostName");
            if (ProcessUtils.isMainProcess()) {
                if (string != null && (b2 = nx2.c.b()) != null) {
                    b2.a(string, string3, string4);
                }
                if (string2 == null || (b = nx2.c.b()) == null) {
                    return;
                }
                b.b(string2, string3, string4);
            }
        }
    }
}
