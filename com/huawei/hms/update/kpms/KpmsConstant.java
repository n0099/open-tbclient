package com.huawei.hms.update.kpms;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class KpmsConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALLER_PACKAGE_NAME = "kpms_key_caller_packagename";
    public static final String KIT_UPDATE_RESULT = "kit_update_result";
    public static final int RESULT_UPDATE_BREAK = 3;
    public static final int RESULT_UPDATE_CANCEL = 2;
    public static final int RESULT_UPDATE_FAILED = 0;
    public static final int RESULT_UPDATE_SUCCESS = 1;
    public static final String UPDATE_PACKAGE_NAME = "kitUpdatePackageName";
    public transient /* synthetic */ FieldHolder $fh;

    public KpmsConstant() {
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
