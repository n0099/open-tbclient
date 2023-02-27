package com.huawei.hms.framework.common.hianalytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes8.dex */
public class HianalyticsHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEAULT_HA_SERVICE_TAG = "_default_config_tag";
    public static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    public static final String TAG = "HianalyticsHelper";
    public static final int TYPE_MAINTF = 1;
    public static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    public static final int USER_EXPERIENCE_ON = 1;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile HianalyticsHelper instance;
    public transient /* synthetic */ FieldHolder $fh;
    public HiAnalyticsInstance defaultInstance;
    public HiAnalyticsInstance hInstance;
    public String haTag;
    public boolean hasHMSBI;
    public boolean hasHianalytics;
    public boolean isEnablePrivacyPolicy;
    public ExecutorService reportExecutor;

    /* loaded from: classes8.dex */
    public static class HianalyticsRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HianalyticsBaseData data;
        public final String event;

        public HianalyticsRunnable(HianalyticsBaseData hianalyticsBaseData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hianalyticsBaseData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = hianalyticsBaseData;
            this.event = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HianalyticsHelper.getInstance().onEvent(this.data.get(), this.event);
            }
        }
    }

    public HianalyticsHelper() {
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
        this.haTag = HWID_HA_SERVICE_TAG;
        this.hInstance = null;
        this.defaultInstance = null;
        this.isEnablePrivacyPolicy = false;
        this.reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");
        try {
            HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG);
            this.hasHianalytics = true;
        } catch (Throwable unused) {
            Logger.i(TAG, "Hianalytics sdk not found");
            this.hasHianalytics = false;
        }
        if (!this.hasHianalytics) {
            tryHMSBIInit(ContextHolder.getAppContext());
        }
        Logger.v(TAG, "this time the ha %s, mini %s", Boolean.valueOf(this.hasHianalytics), Boolean.valueOf(this.hasHMSBI));
    }

    public static HianalyticsHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (HianalyticsHelper.class) {
                    if (instance == null) {
                        instance = new HianalyticsHelper();
                    }
                }
            }
            return instance;
        }
        return (HianalyticsHelper) invokeV.objValue;
    }

    public ExecutorService getReportExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.reportExecutor;
        }
        return (ExecutorService) invokeV.objValue;
    }

    private boolean isHianalyticsOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG)) {
                if (this.defaultInstance == null) {
                    this.defaultInstance = HiAnalyticsManager.getInstanceByTag(DEAULT_HA_SERVICE_TAG);
                }
                if (this.defaultInstance != null) {
                    return true;
                }
                return false;
            }
            if (this.hInstance == null) {
                this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
            }
            if (this.hInstance != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void onNewEvent(Context context, String str, Map map, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65539, this, context, str, map, i) == null) && context != null && map != null) {
            Logger.v(TAG, "data = %s", map);
            try {
                HiAnalyticsUtils.getInstance().onNewEvent(context, str, map, i);
            } catch (NoSuchMethodError unused) {
                Logger.w(TAG, "may be you need upgrade stats sdk");
            } catch (Throwable unused2) {
                Logger.i(TAG, "the stats has other error,pls check it");
            }
        }
    }

    private void tryHMSBIInit(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            if (context == null) {
                Logger.i(TAG, "the appContext hasn't init");
                return;
            }
            try {
                HMSBIInitializer.getInstance(context).initBI();
                this.hasHMSBI = true;
            } catch (NoClassDefFoundError unused) {
                Logger.w(TAG, "maybe you need add base sdk!");
            } catch (Throwable unused2) {
                Logger.w(TAG, "the hms base has other error!");
            }
        }
    }

    public void enablePrivacyPolicy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.isEnablePrivacyPolicy = z;
        }
    }

    public boolean isEnableReport(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.hasHMSBI) {
                return true;
            }
            if (!this.hasHianalytics) {
                return false;
            }
            return isEnableReportNoSeed(context);
        }
        return invokeL.booleanValue;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, linkedHashMap) == null) {
            onEvent(linkedHashMap, HianalyticsBaseData.EVENT_ID);
        }
    }

    public void setHaTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.haTag = str;
        }
    }

    public void executeReportHa(HianalyticsBaseData hianalyticsBaseData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hianalyticsBaseData, str) == null) {
            getReportExecutor().execute(new HianalyticsRunnable(hianalyticsBaseData, str));
        }
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, linkedHashMap, str) == null) {
            onEvent(linkedHashMap, str, 1);
        }
    }

    public boolean isEnableReportNoSeed(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.hasHMSBI) {
                return true;
            }
            if (!this.hasHianalytics) {
                Logger.i(TAG, "Hianalytics sdk need to be initialized");
                return false;
            } else if (context == null) {
                Logger.i(TAG, "HianalyticsHelper context can't be null");
                return false;
            } else if (this.isEnablePrivacyPolicy) {
                return isHianalyticsOk();
            } else {
                try {
                    if (Settings.Secure.getInt(context.getContentResolver(), USER_EXPERIENCE_INVOLVED, -1) == 1) {
                        return isHianalyticsOk();
                    }
                } catch (IllegalStateException unused) {
                    Logger.w(TAG, "the setting has illegalStateException");
                } catch (Throwable unused2) {
                    Logger.w(TAG, "the setting has other error");
                }
                Logger.i(TAG, "user experience involved needs to be opened");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str, int i) {
        HiAnalyticsInstance hiAnalyticsInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, linkedHashMap, str, i) == null) {
            if (this.hasHMSBI) {
                onNewEvent(ContextHolder.getAppContext(), str, linkedHashMap, i);
            } else if (i == 0) {
                Logger.v(TAG, "the base sdk isn't exsit, and reportType is %s", Integer.valueOf(i));
                return;
            }
            if (!this.hasHianalytics || linkedHashMap == null) {
                return;
            }
            Logger.v(TAG, "data = %s", linkedHashMap);
            if (HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG) && (hiAnalyticsInstance = this.defaultInstance) != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
                return;
            }
            HiAnalyticsInstance hiAnalyticsInstance2 = this.hInstance;
            if (hiAnalyticsInstance2 != null) {
                hiAnalyticsInstance2.onEvent(1, str, linkedHashMap);
            } else {
                Logger.e(TAG, "the ha has error,has init but is null!");
            }
        }
    }

    public void reportData(Context context, LinkedHashMap<String, String> linkedHashMap, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, linkedHashMap, str, i) != null) || !isEnableReportNoSeed(context)) {
            return;
        }
        onEvent(linkedHashMap, str, i);
    }

    public void reportException(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, th, str) != null) || !getInstance().isEnableReport(ContextHolder.getAppContext())) {
            return;
        }
        try {
            this.reportExecutor.submit(new Runnable(this, Thread.currentThread().getName(), th, str) { // from class: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HianalyticsHelper this$0;
                public final /* synthetic */ Throwable val$e;
                public final /* synthetic */ String val$eventId;
                public final /* synthetic */ String val$threadName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, th, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$threadName = r7;
                    this.val$e = th;
                    this.val$eventId = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CrashHianalyticsData crashHianalyticsData = new CrashHianalyticsData();
                        crashHianalyticsData.put("sdk_version", "5.0.10.302");
                        crashHianalyticsData.put(CrashHianalyticsData.CRASH_TYPE, "exception");
                        crashHianalyticsData.put(CrashHianalyticsData.THREAD_NAME, this.val$threadName);
                        crashHianalyticsData.put(CrashHianalyticsData.EXCEPTION_NAME, this.val$e.getClass().getName());
                        crashHianalyticsData.put("message", StringUtils.anonymizeMessage(this.val$e.getMessage()));
                        crashHianalyticsData.put(CrashHianalyticsData.STACK_TRACE, StringUtils.getTraceInfo(this.val$e));
                        HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), this.val$eventId);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.i(TAG, "reportException error RejectedExecutionException");
        } catch (Exception unused2) {
            Logger.i(TAG, "reportException error!", th);
        }
    }
}
