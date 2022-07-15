package com.repackage;

import android.os.Bundle;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface f42 {
    public static final f42 a = new a();

    /* loaded from: classes6.dex */
    public static class a implements f42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.f42
        public boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, prefetchEvent, pMSAppInfo, bundle)) == null) ? pMSAppInfo != null && pMSAppInfo.appCategory == 0 : invokeLLL.booleanValue;
        }
    }

    boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle);
}
