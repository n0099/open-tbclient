package com.huawei.hms.framework.common.hianalytics;

import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CrashHianalyticsData extends HianalyticsBaseData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRASH_TYPE = "crash_type";
    public static final String EVENT_ID_CRASH = "crash";
    public static final String EXCEPTION_NAME = "exception_name";
    public static final String MESSAGE = "message";
    public static final String PROCESS_ID = "process_id";
    public static final String STACK_TRACE = "stack_trace";
    public static final String THREAD_ID = "thread_id";
    public static final String THREAD_NAME = "thread_name";
    public static final String TIME = "time";
    public transient /* synthetic */ FieldHolder $fh;

    public CrashHianalyticsData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        put("time", "" + System.currentTimeMillis());
        put(PROCESS_ID, "" + Process.myPid());
        put("thread_id", "" + Process.myTid());
    }
}
