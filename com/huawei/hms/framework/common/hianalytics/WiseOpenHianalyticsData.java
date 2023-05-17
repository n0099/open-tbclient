package com.huawei.hms.framework.common.hianalytics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class WiseOpenHianalyticsData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String UNION_API_NAME = "apiName";
    public static final String UNION_APP_VERSION = "cpAppVersion";
    public static final String UNION_CALLTIME = "callTime";
    public static final String UNION_COSTTIME = "costTime";
    public static final String UNION_EVENT_ID = "60000";
    public static final String UNION_PACKAGE = "package";
    public static final String UNION_RESULT = "result";
    public static final String UNION_SERVICE = "service";
    public static final String UNION_VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    public WiseOpenHianalyticsData() {
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
