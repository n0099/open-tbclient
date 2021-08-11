package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class PushClientConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PUSH_APP_ALIAS = "com.vivo.pushservice.app.alias";
    public static final String PUSH_APP_TAGS = "com.vivo.pushservice.app.tags";
    public static final String TAG_CLASS_NAME = "className";
    public static final String TAG_PARAM_KEYS = "paramKeys";
    public static final String TAG_PARAM_TYPES = "paramTypes";
    public static final String TAG_PARAM_VALS = "paramVals";
    public static final String TAG_PKG_NAME = "pkgName";
    public transient /* synthetic */ FieldHolder $fh;

    public PushClientConstants() {
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
}
