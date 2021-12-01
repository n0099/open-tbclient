package com.tachikoma.core.utility;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TimeCostType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HM_EXPORT_CLASSES_COUNT = "HM_EXPORT_CLASSES_COUNT";
    public static final String NJ_TC_BIZ_JS_DOWNLOAD = "NJ_TC_BIZ_JS_DOWNLOAD";
    public static final String NJ_TC_BIZ_JS_EXECUTE = "NJ_TC_BIZ_JS_EXECUTE";
    public static final String NJ_TC_BIZ_JS_SCAN_PATH_IN_CACHE = "NJ_TC_BIZ_JS_SCAN_PATH_IN_CACHE";
    public static final String NJ_TC_EXPORT_CLASSES = "NJ_TC_EXPORT_CLASSES";
    public static final String NJ_TC_JS_SPLIT_AND_EXECUTE = "NJ_TC_JS_SPLIT_AND_EXECUTE";
    public static final String NJ_TC_LOAD_BIZ_JS = "NJ_TC_LOAD_BIZ_JS";
    public static final String NJ_TC_NATIVE_EXECUTE_COMPLETE = "NJ_TC_NATIVE_EXECUTE_COMPLETE";
    public static final String NJ_TC_UNKOWN = "NJ_TC_UNKOWN";
    public static final String NJ_TTC_JSEXECUTE_COMPLETE = "NJ_TTC_JSEXECUTE_COMPLETE";
    public static final String NJ_TTC_JSEXECUTE_RENDER_AND_COMPLETE = "NJ_TTC_JSEXECUTE_RENDER_AND_COMPLETE";
    public static final String NJ_TTC_NATIVEJS_MODULE_INIT = "NJ_TTC_NATIVEJS_MODULE_INIT";
    public transient /* synthetic */ FieldHolder $fh;

    public TimeCostType() {
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
