package com.huawei.hms.framework.network.grs;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final String APPLICATION_ID = "com.huawei.hms.framework.network.grs";
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "";
    public static final String LIBRARY_PACKAGE_NAME = "com.huawei.hms.framework.network.grs";
    public static final int VERSION_CODE = 50010302;
    public static final String VERSION_NAME = "5.0.10.302";
    public transient /* synthetic */ FieldHolder $fh;

    public BuildConfig() {
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
