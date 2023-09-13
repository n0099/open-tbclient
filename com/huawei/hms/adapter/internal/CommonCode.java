package com.huawei.hms.adapter.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class CommonCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int OK = 0;
    public static final int UNBIND_SERVICE = 11;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface BusInterceptor {
        public static final int INDETERMINATE = 2;
        public static final int PRIVACY_AGREE = 1001;
        public static final int PRIVACY_CANCEL = 1002;
        public static final int PRIVACY_CNCEL_ERROR_CODE = 907135705;
    }

    /* loaded from: classes10.dex */
    public interface MapKey {
        public static final String API_NAME = "api_name";
        public static final String HAS_RESOLUTION = "resolution";
        public static final String HMS_FOREGROUND_RES_UI = "HMS_FOREGROUND_RES_UI";
        public static final String JSON_BODY = "json_body";
        public static final String JSON_HEADER = "json_header";
        public static final String NEW_UPDATE = "new_update";
        public static final String PRIVACY_STATEMENT_CONFIRM_RESULT = "privacy_statement_confirm_result";
        public static final String RESOLUTION_INSTALL_HMS = "installHMS";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String UPDATE_VERSION = "update_version";
    }

    public CommonCode() {
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
