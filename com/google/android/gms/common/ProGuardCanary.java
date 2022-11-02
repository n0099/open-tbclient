package com.google.android.gms.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes7.dex */
public final class ProGuardCanary {
    public static /* synthetic */ Interceptable $ic = null;
    @KeepForSdk
    public static final String CANARY = "gms_proguard_canary";
    public transient /* synthetic */ FieldHolder $fh;

    public ProGuardCanary() {
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
}
