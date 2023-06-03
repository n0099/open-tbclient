package com.fun.ad.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUILD_TYPE = "release";
    public static final String CONFIG_DOMAIN = "https://cd.xdplt.com";
    public static final String CPM_DOMAIN = "https://cd.xdplt.com";
    public static final boolean DEBUG = false;
    public static final boolean ENABLE_AUTO_RATIO = false;
    public static final String FLAVOR = "baidu";
    public static final Boolean IS_ADM_REPORT;
    public static final boolean IS_OVERSEA_PROD = false;
    public static final boolean IS_VIDEO_PRODUCT_TEST = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.fun.ad.sdk";
    public static final String PLUGIN_RC = null;
    public static final String REPORT_DOMAIN = "https://rpe.xdplt.com";
    public static final int VERSION_CODE = 10437;
    public static final String VERSION_NAME = "4.6.34";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(448152642, "Lcom/fun/ad/sdk/BuildConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(448152642, "Lcom/fun/ad/sdk/BuildConfig;");
                return;
            }
        }
        IS_ADM_REPORT = Boolean.TRUE;
    }

    public BuildConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
