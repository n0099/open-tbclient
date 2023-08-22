package com.huawei.hms.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PackageConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPID_HMS = "C10132067";
    public static final String APPID_HMS_TV = "C100636709";
    public static final String GENERAL_SERVICES_ACTION = "com.huawei.hms.core";
    public static final int HMS_SDK_VERSION_CODE = 60500300;
    public static final String HMS_SDK_VERSION_NAME = "6.5.0.300";
    public static final String INTERNAL_SERVICES_ACTION = "com.huawei.hms.core.internal";
    public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
    public static final String SERVICES_PACKAGE = "com.huawei.hwid";
    @Deprecated
    public static final String SERVICES_PACKAGE_ALL_SCENE = "com.huawei.hms";
    public static final String SERVICES_PACKAGE_CAR = "com.huawei.hwid.car";
    public static final String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";
    public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    public static final String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static final String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public transient /* synthetic */ FieldHolder $fh;

    public PackageConstants() {
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
