package com.dxmpay.wallet.router;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class ErrorAction implements NoProguard, RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_MESSAGE = "Something was really wrong.";
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.dxmpay.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || routerCallback == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errorMsg", "Something was really wrong.");
        routerCallback.onResult(5, hashMap2);
    }
}
