package com.yy.hiidostatis.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.config.ABNameDefine;
import com.yy.hiidostatis.config.ABTestHandler;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.defs.controller.OaidController;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.InsideMode;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.log.TraceLog;
import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import com.yy.hiidostatis.message.module.sessionreport.EventValue;
import com.yy.hiidostatis.message.utils.AndroidUtil;
import com.yy.hiidostatis.message.utils.KVIO;
import com.yy.hiidostatis.message.utils.NoNull;
import com.yy.hiidostatis.testui.FloatingService;
import com.yy.mobile.perf.taskexecutor.IYYTaskExecutor;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class HiidoSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile String HIIDO_HOST = "mlog.bigda.com";
    public static volatile String[] HIIDO_IPS = null;
    public static final String SDK_DURATION_COUNTER_NAME = "SDK_DUR";
    public static final String SDK_FAILED_COUNTER_NAME = "SDK_FAIL";
    public static final String SDK_METRICS_NAME = "SDK_METRICS";
    public static final int SDK_SCODE = 50000;
    public static final String SDK_SUCCESS_COUNTER_NAME = "SDK_SUC";
    public static HiidoSDK instance;
    public static boolean isDebugMode;
    public transient /* synthetic */ FieldHolder $fh;
    public HiidoApi api;
    public Context appContext;
    public boolean isInited;
    public Options mOptions;
    public volatile boolean userAgreed;

    /* loaded from: classes4.dex */
    public interface HdidReceiver {
        void onHdidReceived(String str);
    }

    /* loaded from: classes4.dex */
    public static class Options {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BEHAVIOR_SEND_THRESHOLD_DEFAULT = 10;
        public static final int BEHAVIOR_SEND_THRESHOLD_MAX = 100;
        public static final int DEFAULT_BACKGROUND_DURATION_MILLIS_AS_QUIT = 30000;
        public static final int DEFAULT_BASIC_BEHAVIOR_SEND_INTERVAL = 600000;
        public static final int MAX_BASIC_BEHAVIOR_SEND_INTERVAL = 1800000;
        public static final int MIN_BASIC_BEHAVIOR_SEND_INTERVAL = 60000;
        public transient /* synthetic */ FieldHolder $fh;
        public float accelerometerThreshold;
        @Deprecated
        public long backgroundDurationMillisAsQuit;
        public String bdCuid;
        @Deprecated
        public int behaviorSendIntervalMillis;
        public int behaviorSendThreshold;
        @Deprecated
        public int businessType;
        public int defaultMetricsExpire;
        public int defaultMetricsInterval;
        public boolean gaidEnable;
        public float gyroscopeThreshold;
        public Set<String> ignoreActivity;
        public int interval;
        @Deprecated
        public boolean isAbroad;
        public boolean isLogOn;
        @Deprecated
        public boolean isNewMac;
        public boolean isOpenCrashMonitor;
        @Deprecated
        public boolean isOpenDo5;
        @Deprecated
        public boolean isOpenDoShort;
        public float lightThreshold;
        public boolean openAutoTrack;
        public boolean openSDKMetrics;
        public boolean openSensorMonitor;
        public boolean outputDebugLog;
        @Deprecated
        public boolean reportApplist;
        @Deprecated
        public volatile String testServer;
        public boolean useOaid;
        public boolean waitGrant;

        public Options() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.behaviorSendThreshold = 10;
            this.behaviorSendIntervalMillis = 600000;
            this.backgroundDurationMillisAsQuit = 30000L;
            this.isOpenCrashMonitor = true;
            this.isLogOn = false;
            this.outputDebugLog = false;
            this.isOpenDo5 = true;
            this.isOpenDoShort = true;
            this.reportApplist = false;
            this.isAbroad = false;
            this.gaidEnable = false;
            this.businessType = 100;
            this.isNewMac = true;
            this.defaultMetricsExpire = 1800;
            this.defaultMetricsInterval = 60;
            this.openSDKMetrics = true;
            this.openAutoTrack = false;
            this.waitGrant = false;
            this.gyroscopeThreshold = 0.5f;
            this.accelerometerThreshold = 0.6f;
            this.lightThreshold = 15.0f;
            this.openSensorMonitor = false;
            this.interval = 30;
            this.useOaid = true;
        }

        public Options addOaidInitListener(OaidController.OaidInitListener oaidInitListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oaidInitListener)) == null) {
                if (Build.VERSION.SDK_INT < 28) {
                    return this;
                }
                OaidController.INSTANCE.addListener(oaidInitListener);
                return this;
            }
            return (Options) invokeL.objValue;
        }

        public long getBackgroundDurationMillisAsQuit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.backgroundDurationMillisAsQuit : invokeV.longValue;
        }

        public String getBdCuid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bdCuid : (String) invokeV.objValue;
        }

        public int getBehaviorSendThreshold() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.behaviorSendThreshold : invokeV.intValue;
        }

        public int getDefaultMetricsExpire() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.defaultMetricsExpire : invokeV.intValue;
        }

        public int getDefaultMetricsInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.defaultMetricsInterval : invokeV.intValue;
        }

        public Set<String> getIgnoreActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.ignoreActivity : (Set) invokeV.objValue;
        }

        public int getInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.interval : invokeV.intValue;
        }

        @Deprecated
        public boolean isAbroad() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isAbroad : invokeV.booleanValue;
        }

        public boolean isGaidEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.gaidEnable : invokeV.booleanValue;
        }

        public boolean isLogOn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isLogOn : invokeV.booleanValue;
        }

        public boolean isOpenAutoTrack() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.openAutoTrack : invokeV.booleanValue;
        }

        public boolean isOpenCrashMonitor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isOpenCrashMonitor : invokeV.booleanValue;
        }

        @Deprecated
        public boolean isOpenDoShort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isOpenDoShort : invokeV.booleanValue;
        }

        public boolean isOpenSDKMetrics() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.openSDKMetrics : invokeV.booleanValue;
        }

        public boolean isOpenSensorMonitor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.openSensorMonitor : invokeV.booleanValue;
        }

        public boolean isShowFloatingDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? FloatingService.INSTANCT.isDebug() : invokeV.booleanValue;
        }

        public boolean isUseOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.useOaid : invokeV.booleanValue;
        }

        public boolean isWaitGrant() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.waitGrant : invokeV.booleanValue;
        }

        public Options needUserAgree() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                HiidoSDK.instance().setUserAgreed(false);
                return this;
            }
            return (Options) invokeV.objValue;
        }

        @Deprecated
        public Options setAbroad(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                this.isAbroad = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setActLogEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
                ActLog.setLogEnable(z);
                TraceLog.setEnable(z);
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setBackgroundDurationMillisAsQuit(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) {
                this.backgroundDurationMillisAsQuit = j2;
                return this;
            }
            return (Options) invokeJ.objValue;
        }

        public void setBdCuid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.bdCuid = str;
            }
        }

        public Options setBehaviorSendThreshold(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                this.behaviorSendThreshold = i2;
                return this;
            }
            return (Options) invokeI.objValue;
        }

        public Options setDefaultMetricsExpire(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
                this.defaultMetricsExpire = i2;
                return this;
            }
            return (Options) invokeI.objValue;
        }

        public Options setDefaultMetricsInterval(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
                this.defaultMetricsInterval = i2;
                return this;
            }
            return (Options) invokeI.objValue;
        }

        public Options setGaidEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
                this.isAbroad = z;
                this.gaidEnable = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setHostApp(InsideMode.HostApp hostApp) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, hostApp)) == null) {
                InsideMode.initHostApp(hostApp);
                return this;
            }
            return (Options) invokeL.objValue;
        }

        public Options setIgnoreActivity(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, strArr)) == null) {
                if (strArr == null) {
                    return this;
                }
                Set<String> set = this.ignoreActivity;
                if (set == null) {
                    this.ignoreActivity = new HashSet(strArr.length);
                } else {
                    set.clear();
                }
                this.ignoreActivity.addAll(Arrays.asList(strArr));
                return this;
            }
            return (Options) invokeL.objValue;
        }

        public void setInterval(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
                this.interval = i2;
            }
        }

        public Options setLogOn(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.isLogOn = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setMaxDataCacheDay(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
                if (i2 <= 5) {
                    i2 = 5;
                }
                AbstractConfig.MAX_DATA_CACHE_DAY = i2;
                return this;
            }
            return (Options) invokeI.objValue;
        }

        public Options setMaxDataRetryTimes(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
                if (i2 <= 10000) {
                    i2 = 10000;
                }
                AbstractConfig.MAX_DATA_RETRY_TIME = i2;
                return this;
            }
            return (Options) invokeI.objValue;
        }

        public Options setOpenAutoTrack(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                this.openAutoTrack = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setOpenCrashMonitor(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
                this.isOpenCrashMonitor = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        @Deprecated
        public Options setOpenDoShort(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.isOpenDoShort = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setOpenSDKMetrics(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
                this.openSDKMetrics = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setOpenSensorMonitor(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
                this.openSensorMonitor = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setOutputDebugLog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) {
                this.outputDebugLog = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setSensorThreshold(float f2, float f3, float f4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                this.gyroscopeThreshold = f2;
                this.accelerometerThreshold = f3;
                this.lightThreshold = f4;
                return this;
            }
            return (Options) invokeCommon.objValue;
        }

        public Options setShowFloatingDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
                FloatingService.INSTANCT.setDebug(z);
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setTaskExecutor(IYYTaskExecutor iYYTaskExecutor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, iYYTaskExecutor)) == null) {
                ExecutorProvider.setIyyTaskExecutor(iYYTaskExecutor);
                return this;
            }
            return (Options) invokeL.objValue;
        }

        public Options setUseOaid(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
                this.useOaid = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }

        public Options setWaitGrant(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) {
                this.waitGrant = z;
                return this;
            }
            return (Options) invokeZ.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class PageActionReportOption {
        public static final /* synthetic */ PageActionReportOption[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PageActionReportOption DO_NOT_REPORT_ON_FUTURE_RESUME;
        public static final PageActionReportOption REPORT_ON_FUTURE_RESUME;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1805214088, "Lcom/yy/hiidostatis/api/HiidoSDK$PageActionReportOption;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1805214088, "Lcom/yy/hiidostatis/api/HiidoSDK$PageActionReportOption;");
                    return;
                }
            }
            REPORT_ON_FUTURE_RESUME = new PageActionReportOption("REPORT_ON_FUTURE_RESUME", 0);
            PageActionReportOption pageActionReportOption = new PageActionReportOption("DO_NOT_REPORT_ON_FUTURE_RESUME", 1);
            DO_NOT_REPORT_ON_FUTURE_RESUME = pageActionReportOption;
            $VALUES = new PageActionReportOption[]{REPORT_ON_FUTURE_RESUME, pageActionReportOption};
        }

        public PageActionReportOption(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PageActionReportOption valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PageActionReportOption) Enum.valueOf(PageActionReportOption.class, str) : (PageActionReportOption) invokeL.objValue;
        }

        public static PageActionReportOption[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PageActionReportOption[]) $VALUES.clone() : (PageActionReportOption[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1260641588, "Lcom/yy/hiidostatis/api/HiidoSDK;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1260641588, "Lcom/yy/hiidostatis/api/HiidoSDK;");
                return;
            }
        }
        HIIDO_IPS = new String[]{"180.163.71.28", "180.163.71.178", "183.36.1.155", "183.36.1.113"};
        instance = new HiidoSDK();
    }

    public HiidoSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.userAgreed = true;
        this.api = new NotInitHiidoApi();
        this.mOptions = new Options();
        this.isInited = false;
    }

    public static String getHiidoHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? HIIDO_HOST : (String) invokeV.objValue;
    }

    public static String[] getHiidoIps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? HIIDO_IPS : (String[]) invokeV.objValue;
    }

    public static HiidoSDK instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? instance : (HiidoSDK) invokeV.objValue;
    }

    public static void setHiidoHost(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, list) == null) {
            if (str != null && !str.isEmpty()) {
                HIIDO_HOST = str;
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            String[] strArr = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                strArr[i2] = list.get(i2);
            }
            HIIDO_IPS = strArr;
        }
    }

    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
            this.api.addActAdditionListener(actListener);
        }
    }

    public MetricsWorker addMetricsWorker(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2)) == null) ? this.api.addMetricsWorker(str, j2) : (MetricsWorker) invokeLJ.objValue;
    }

    public void appRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.api.appRun();
        }
    }

    public void appStartLaunchWithAppKey(Context context, String str, String str2, String str3, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, str, str2, str3, onStatisListener) == null) {
            StatisOption statisOption = new StatisOption();
            statisOption.setAppId(str2);
            statisOption.setAppkey(str);
            statisOption.setFrom(str3);
            appStartLaunchWithAppKey(context, statisOption, onStatisListener);
        }
    }

    public void beginSession(String str, String str2, long j2, Map<String, Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Long.valueOf(j2), map}) == null) {
            this.api.beginSession(str, str2, j2, map);
        }
    }

    public void closeSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.api.closeSession(str);
        }
    }

    public StatisAPI createNewStatisApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StatisAPI statisAPI = new StatisAPI();
            statisAPI.setAbroad(getOptions().isAbroad);
            statisAPI.setTestServer(getOptions().testServer);
            statisAPI.setBusinessType(getOptions().businessType);
            return statisAPI;
        }
        return (StatisAPI) invokeV.objValue;
    }

    public boolean flushSession(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) ? this.api.flushSession(str, str2) : invokeLL.booleanValue;
    }

    public boolean flushSessionAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? flushSessionAll(str, null) : invokeL.booleanValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.api.getAppId() : (String) invokeV.objValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.api.getAppKey() : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.api.getContext() : (Context) invokeV.objValue;
    }

    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) ? CommonFiller.getIMEI(AndroidUtil.applicationContext(context)) : (String) invokeL.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.api.getFrom() : (String) invokeV.objValue;
    }

    @Deprecated
    public String getHdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) ? DeviceProxy.getHdid(AndroidUtil.applicationContext(context)) : (String) invokeL.objValue;
    }

    public String getHdidSync(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) ? DeviceProxy.getHdid(AndroidUtil.applicationContext(context)) : (String) invokeL.objValue;
    }

    public String getMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) ? CommonFiller.getMacAddr(AndroidUtil.applicationContext(context)) : (String) invokeL.objValue;
    }

    public OnStatisListener getOnStatisListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.api.getOnStatisListener() : (OnStatisListener) invokeV.objValue;
    }

    public String getOnlineConfigParams(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, context, str)) == null) ? this.api.getOnlineConfigParams(AndroidUtil.applicationContext(context), str) : (String) invokeLL.objValue;
    }

    public Options getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mOptions : (Options) invokeV.objValue;
    }

    public StatisOption getStatisOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.api.getStatisOption() : (StatisOption) invokeV.objValue;
    }

    public boolean isUserAgreed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23 || this.userAgreed) {
                return true;
            }
            String str = null;
            try {
                str = ArdUtil.getSjp(this.appContext).trim();
            } catch (Throwable th) {
                L.debug(this, th.toString(), new Object[0]);
            }
            return str != null && (str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("VIVO"));
        }
        return invokeV.booleanValue;
    }

    public void onPause(String str, PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, pageActionReportOption) == null) {
            this.api.onPause(str, pageActionReportOption);
        }
    }

    public void onResume(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048604, this, j2, str) == null) {
            this.api.onResume(j2, str);
        }
    }

    public void onScreenMonitor(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, motionEvent) == null) {
            this.api.onScreenMonitor(motionEvent);
        }
    }

    public void onScreenPause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.api.onScreenPause(str);
        }
    }

    public void onScreenResume(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.api.onScreenResume(str);
        }
    }

    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048609, this, str, str2, list, map, map2)) == null) ? this.api.pushToSession(str, str2, list, map, map2) : invokeLLLLL.booleanValue;
    }

    public boolean registerActivityLifecycleMonitor(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, context)) == null) ? this.api.registerActivityLifecycleMonitor(AndroidUtil.applicationContext(context)) : invokeL.booleanValue;
    }

    public void removeActAdditionListerner(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, actListener) == null) {
            this.api.removeActAdditionListerner(actListener);
        }
    }

    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.api.reportAppsflyer(str);
        }
    }

    public void reportCount(int i2, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2)}) == null) {
            this.api.reportCount(i2, str, str2, j2);
        }
    }

    public void reportCountEvent(long j2, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2)}) == null) {
            this.api.reportCountEvent(j2, str, d2);
        }
    }

    public void reportCrash(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048620, this, j2, str) == null) {
            this.api.reportCrash(j2, str);
        }
    }

    public void reportCustomContent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.api.reportCustomContent(j2, str, str2);
        }
    }

    public void reportErrorEvent(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            this.api.reportErrorEvent(j2, str, str2, str3);
        }
    }

    public void reportFailure(long j2, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, str5}) == null) {
            this.api.reportFailure(j2, str, str2, str3, str4, str5);
        }
    }

    public boolean reportFeedBack(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048625, this, str, str2, str3)) == null) ? this.api.reportFeedBack(str, str2, str3) : invokeLLL.booleanValue;
    }

    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i2), str5}) == null) {
            this.api.reportIM(str, str2, str3, date, date2, str4, i2, str5);
        }
    }

    public void reportLocation(double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) {
            this.api.reportLocation(d2, d3, d4);
        }
    }

    public void reportLogin(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j2) == null) {
            this.api.reportLogin(j2);
        }
    }

    public void reportPushToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.api.reportPushToken(str);
        }
    }

    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048630, this, str, str2, str3, map) == null) {
            this.api.reportReg(str, str2, str3, map);
        }
    }

    public void reportReturnCode(int i2, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), str2}) == null) {
            this.api.reportReturnCode(i2, str, j2, str2, null);
        }
    }

    public void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{str, Integer.valueOf(i2), str2, shareType, str3, str4, str5}) == null) {
            this.api.reportShare(str, i2, str2, shareType, str3, str4, str5);
        }
    }

    public void reportSrcData(int i2, String str, String str2, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), map}) == null) {
            this.api.reportSrcData(i2, str, str2, j2, map);
        }
    }

    public void reportStatisticContent(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, str, statisContent) == null) {
            this.api.reportStatisticContent(str, statisContent);
        }
    }

    public void reportStatisticContentTemporary(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, str, statisContent) == null) {
            this.api.reportStatisticContentTemporary(str, statisContent);
        }
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048641, this, context, str, statisContent) == null) {
            this.api.reportStatisticContentWithNoComm(AndroidUtil.applicationContext(context), str, statisContent);
        }
    }

    public void reportSuccess(long j2, String str, String str2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3), str3}) == null) {
            this.api.reportSuccess(j2, str, str2, j3, str3);
        }
    }

    public void reportTimesEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048644, this, j2, str) == null) {
            this.api.reportTimesEvent(j2, str);
        }
    }

    public void setABTest(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, strArr) == null) {
            ABTestHandler.updateValue(this.appContext, strArr);
        }
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, hiidoSdkAdditionDelegate) == null) {
            this.api.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
        }
    }

    public void setBdCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.api.setBdCuid(str);
        }
    }

    public void setCurPageParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            this.api.setCurPageParam(str);
        }
    }

    public void setHeartbeatField(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048652, this, str, str2) == null) {
            this.api.setHeartbeatField(str, str2);
        }
    }

    public HiidoSDK setLogWriter(StatisLogWriter statisLogWriter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, statisLogWriter)) == null) {
            L.setLogSetting(statisLogWriter);
            return this;
        }
        return (HiidoSDK) invokeL.objValue;
    }

    public void setOnLineConfigListener(OnLineConfigListener onLineConfigListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onLineConfigListener) == null) {
            this.api.setOnLineConfigListener(onLineConfigListener);
        }
    }

    public void setOptions(Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, options) == null) {
            this.mOptions = options;
        }
    }

    public void setUserAgreed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.userAgreed = z;
        }
    }

    public void updateOnlineConfigs(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, context) == null) {
            this.api.updateOnlineConfigs(AndroidUtil.applicationContext(context));
        }
    }

    public boolean flushSessionAll(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, set)) == null) ? this.api.flushSessionAll(str, set) : invokeLL.booleanValue;
    }

    public void getHdid(Context context, HdidReceiver hdidReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, hdidReceiver) == null) {
            ThreadPool.getPool().execute(new Runnable(this, AndroidUtil.applicationContext(context), hdidReceiver) { // from class: com.yy.hiidostatis.api.HiidoSDK.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDK this$0;
                public final /* synthetic */ Context val$app;
                public final /* synthetic */ HdidReceiver val$receiver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, hdidReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$app = r7;
                    this.val$receiver = hdidReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$receiver.onHdidReceived(DeviceProxy.getHdid(this.val$app));
                    }
                }
            });
        }
    }

    public void onPause(Activity activity, PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, activity, pageActionReportOption) == null) {
            this.api.onPause(activity, pageActionReportOption);
        }
    }

    public void onResume(long j2, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048603, this, j2, activity) == null) {
            this.api.onResume(j2, activity);
        }
    }

    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{str, str2, calAction, str3, number, map, map2})) == null) ? this.api.pushToSession(str, str2, calAction, str3, number, map, map2) : invokeCommon.booleanValue;
    }

    public void reportCount(int i2, String str, String str2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.api.reportCount(i2, str, str2, j2, i3);
        }
    }

    public void reportCountEvent(long j2, String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2}) == null) {
            this.api.reportCountEvent(j2, str, d2, str2);
        }
    }

    public void reportCrash(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048621, this, j2, th) == null) {
            this.api.reportCrash(j2, th);
        }
    }

    public void reportReturnCode(int i2, String str, long j2, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), str2, map}) == null) {
            this.api.reportReturnCode(i2, str, j2, str2, map);
        }
    }

    public void reportSrcData(String str, int i2, String str2, String str3, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), map}) == null) {
            this.api.reportSrcData(str, i2, str2, str3, j2, map);
        }
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048639, this, str, statisContent, z) == null) {
            this.api.reportStatisticContent(str, statisContent, z);
        }
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
            this.api.reportStatisticContentWithNoComm(AndroidUtil.applicationContext(context), str, statisContent, z);
        }
    }

    public void reportTimesEvent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.api.reportTimesEvent(j2, str, str2);
        }
    }

    public void setABTest(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, map) == null) {
            ABTestHandler.updateValue(this.appContext, map);
        }
    }

    public void reportCount(String str, int i2, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)}) == null) {
            this.api.reportCount(str, i2, str2, str3, j2, 1);
        }
    }

    public void reportCountEvent(long j2, String str, double d2, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2, property}) == null) {
            this.api.reportCountEvent(j2, str, d2, str2, property);
        }
    }

    public void reportReturnCode(String str, int i2, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3}) == null) {
            this.api.reportReturnCode(str, i2, str2, j2, str3, null);
        }
    }

    public void reportTimesEvent(long j2, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Long.valueOf(j2), str, str2, property}) == null) {
            this.api.reportTimesEvent(j2, str, str2, property);
        }
    }

    public void reportCount(String str, int i2, String str2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.api.reportCount(str, i2, str2, str3, j2, i3);
        }
    }

    public void reportReturnCode(String str, int i2, String str2, long j2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3, map}) == null) {
            this.api.reportReturnCode(str, i2, str2, j2, str3, map);
        }
    }

    public synchronized void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, statisOption, onStatisListener) == null) {
            synchronized (this) {
                if (this.isInited) {
                    L.warnOn(this, "appStartLaunchWithAppKey isInited is true", new Object[0]);
                    return;
                }
                isDebugMode = NoNull.isEmpty(instance().getOptions().testServer) ? false : true;
                Context applicationContext = AndroidUtil.applicationContext(context);
                this.appContext = applicationContext;
                ABTestHandler.initInstance(applicationContext);
                KVIO.initialize(this.appContext);
                if (ABTestHandler.getAbBoolean(ABNameDefine.NEW_PACKER_MODULE)) {
                    this.api = new HiidoSDKNew();
                } else {
                    this.api = new HiidoSDKOld();
                }
                this.api.appStartLaunchWithAppKey(this.appContext, statisOption, onStatisListener);
                this.isInited = true;
            }
        }
    }
}
