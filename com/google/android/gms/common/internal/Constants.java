package com.google.android.gms.common.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_LOAD_IMAGE = "com.google.android.gms.common.images.LOAD_IMAGE";
    public static final String EXTRA_PRIORITY = "com.google.android.gms.extras.priority";
    public static final String EXTRA_RESULT_RECEIVER = "com.google.android.gms.extras.resultReceiver";
    public static final String EXTRA_URI = "com.google.android.gms.extras.uri";
    public static final String KEY_GMS_ERROR_CODE = "gms_error_code";
    public static final String KEY_NETWORK_TO_USE = "networkToUse";
    public transient /* synthetic */ FieldHolder $fh;

    public Constants() {
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
