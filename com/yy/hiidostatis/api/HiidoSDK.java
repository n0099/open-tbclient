package com.yy.hiidostatis.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
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
/* loaded from: classes8.dex */
public class HiidoSDK {
    public static volatile String HIIDO_HOST = "mlog.bigda.com";
    public static final String SDK_DURATION_COUNTER_NAME = "SDK_DUR";
    public static final String SDK_FAILED_COUNTER_NAME = "SDK_FAIL";
    public static final String SDK_METRICS_NAME = "SDK_METRICS";
    public static final int SDK_SCODE = 50000;
    public static final String SDK_SUCCESS_COUNTER_NAME = "SDK_SUC";
    public static boolean isDebugMode;
    public Context appContext;
    public static volatile String[] HIIDO_IPS = {"180.163.71.28", "180.163.71.178", "183.36.1.155", "183.36.1.113"};
    public static HiidoSDK instance = new HiidoSDK();
    public volatile boolean userAgreed = true;
    public HiidoApi api = new NotInitHiidoApi();
    public Options mOptions = new Options();
    public boolean isInited = false;

    /* loaded from: classes8.dex */
    public interface HdidReceiver {
        void onHdidReceived(String str);
    }

    /* loaded from: classes8.dex */
    public enum PageActionReportOption {
        REPORT_ON_FUTURE_RESUME,
        DO_NOT_REPORT_ON_FUTURE_RESUME
    }

    public static String getHiidoHost() {
        return HIIDO_HOST;
    }

    public static String[] getHiidoIps() {
        return HIIDO_IPS;
    }

    public static HiidoSDK instance() {
        return instance;
    }

    public void appRun() {
        this.api.appRun();
    }

    public StatisAPI createNewStatisApi() {
        StatisAPI statisAPI = new StatisAPI();
        statisAPI.setAbroad(getOptions().isAbroad);
        statisAPI.setTestServer(getOptions().testServer);
        statisAPI.setBusinessType(getOptions().businessType);
        return statisAPI;
    }

    public String getAppId() {
        return this.api.getAppId();
    }

    public String getAppKey() {
        return this.api.getAppKey();
    }

    public Context getContext() {
        return this.api.getContext();
    }

    public String getFrom() {
        return this.api.getFrom();
    }

    public OnStatisListener getOnStatisListener() {
        return this.api.getOnStatisListener();
    }

    public Options getOptions() {
        return this.mOptions;
    }

    public StatisOption getStatisOption() {
        return this.api.getStatisOption();
    }

    /* loaded from: classes8.dex */
    public static class Options {
        public static final int BEHAVIOR_SEND_THRESHOLD_DEFAULT = 10;
        public static final int BEHAVIOR_SEND_THRESHOLD_MAX = 100;
        public static final int DEFAULT_BACKGROUND_DURATION_MILLIS_AS_QUIT = 30000;
        public static final int DEFAULT_BASIC_BEHAVIOR_SEND_INTERVAL = 600000;
        public static final int MAX_BASIC_BEHAVIOR_SEND_INTERVAL = 1800000;
        public static final int MIN_BASIC_BEHAVIOR_SEND_INTERVAL = 60000;
        public String bdCuid;
        public Set<String> ignoreActivity;
        @Deprecated
        public volatile String testServer;
        public int behaviorSendThreshold = 10;
        @Deprecated
        public int behaviorSendIntervalMillis = 600000;
        @Deprecated
        public long backgroundDurationMillisAsQuit = 30000;
        public boolean isOpenCrashMonitor = true;
        public boolean isLogOn = false;
        public boolean outputDebugLog = false;
        @Deprecated
        public boolean isOpenDo5 = true;
        @Deprecated
        public boolean isOpenDoShort = true;
        @Deprecated
        public boolean reportApplist = false;
        @Deprecated
        public boolean isAbroad = false;
        public boolean gaidEnable = false;
        @Deprecated
        public int businessType = 100;
        @Deprecated
        public boolean isNewMac = true;
        public int defaultMetricsExpire = 1800;
        public int defaultMetricsInterval = 60;
        public boolean openSDKMetrics = true;
        public boolean openAutoTrack = false;
        public boolean waitGrant = false;
        public float gyroscopeThreshold = 0.5f;
        public float accelerometerThreshold = 0.6f;
        public float lightThreshold = 15.0f;
        public boolean openSensorMonitor = false;
        public int interval = 30;
        public boolean useOaid = true;

        public Options addOaidInitListener(OaidController.OaidInitListener oaidInitListener) {
            if (Build.VERSION.SDK_INT < 28) {
                return this;
            }
            OaidController.INSTANCE.addListener(oaidInitListener);
            return this;
        }

        @Deprecated
        public Options setAbroad(boolean z) {
            this.isAbroad = z;
            return this;
        }

        public Options setActLogEnable(boolean z) {
            ActLog.setLogEnable(z);
            TraceLog.setEnable(z);
            return this;
        }

        public Options setBackgroundDurationMillisAsQuit(long j) {
            this.backgroundDurationMillisAsQuit = j;
            return this;
        }

        public void setBdCuid(String str) {
            this.bdCuid = str;
        }

        public Options setBehaviorSendThreshold(int i) {
            this.behaviorSendThreshold = i;
            return this;
        }

        public Options setDefaultMetricsExpire(int i) {
            this.defaultMetricsExpire = i;
            return this;
        }

        public Options setDefaultMetricsInterval(int i) {
            this.defaultMetricsInterval = i;
            return this;
        }

        public Options setGaidEnable(boolean z) {
            this.isAbroad = z;
            this.gaidEnable = z;
            return this;
        }

        public Options setHostApp(InsideMode.HostApp hostApp) {
            InsideMode.initHostApp(hostApp);
            return this;
        }

        public Options setIgnoreActivity(String... strArr) {
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

        public void setInterval(int i) {
            this.interval = i;
        }

        public Options setLogOn(boolean z) {
            this.isLogOn = z;
            return this;
        }

        public Options setMaxDataCacheDay(int i) {
            if (i <= 5) {
                i = 5;
            }
            AbstractConfig.MAX_DATA_CACHE_DAY = i;
            return this;
        }

        public Options setMaxDataRetryTimes(int i) {
            if (i <= 10000) {
                i = 10000;
            }
            AbstractConfig.MAX_DATA_RETRY_TIME = i;
            return this;
        }

        public Options setOpenAutoTrack(boolean z) {
            this.openAutoTrack = z;
            return this;
        }

        public Options setOpenCrashMonitor(boolean z) {
            this.isOpenCrashMonitor = z;
            return this;
        }

        @Deprecated
        public Options setOpenDoShort(boolean z) {
            this.isOpenDoShort = z;
            return this;
        }

        public Options setOpenSDKMetrics(boolean z) {
            this.openSDKMetrics = z;
            return this;
        }

        public Options setOpenSensorMonitor(boolean z) {
            this.openSensorMonitor = z;
            return this;
        }

        public Options setOutputDebugLog(boolean z) {
            this.outputDebugLog = z;
            return this;
        }

        public Options setShowFloatingDialog(boolean z) {
            FloatingService.INSTANCT.setDebug(z);
            return this;
        }

        public Options setTaskExecutor(IYYTaskExecutor iYYTaskExecutor) {
            ExecutorProvider.setIyyTaskExecutor(iYYTaskExecutor);
            return this;
        }

        public Options setUseOaid(boolean z) {
            this.useOaid = z;
            return this;
        }

        public Options setWaitGrant(boolean z) {
            this.waitGrant = z;
            return this;
        }

        public long getBackgroundDurationMillisAsQuit() {
            return this.backgroundDurationMillisAsQuit;
        }

        public String getBdCuid() {
            return this.bdCuid;
        }

        public int getBehaviorSendThreshold() {
            return this.behaviorSendThreshold;
        }

        public int getDefaultMetricsExpire() {
            return this.defaultMetricsExpire;
        }

        public int getDefaultMetricsInterval() {
            return this.defaultMetricsInterval;
        }

        public Set<String> getIgnoreActivity() {
            return this.ignoreActivity;
        }

        public int getInterval() {
            return this.interval;
        }

        @Deprecated
        public boolean isAbroad() {
            return this.isAbroad;
        }

        public boolean isGaidEnable() {
            return this.gaidEnable;
        }

        public boolean isLogOn() {
            return this.isLogOn;
        }

        public boolean isOpenAutoTrack() {
            return this.openAutoTrack;
        }

        public boolean isOpenCrashMonitor() {
            return this.isOpenCrashMonitor;
        }

        @Deprecated
        public boolean isOpenDoShort() {
            return this.isOpenDoShort;
        }

        public boolean isOpenSDKMetrics() {
            return this.openSDKMetrics;
        }

        public boolean isOpenSensorMonitor() {
            return this.openSensorMonitor;
        }

        public boolean isShowFloatingDialog() {
            return FloatingService.INSTANCT.isDebug();
        }

        public boolean isUseOaid() {
            return this.useOaid;
        }

        public boolean isWaitGrant() {
            return this.waitGrant;
        }

        public Options needUserAgree() {
            HiidoSDK.instance().setUserAgreed(false);
            return this;
        }

        public Options setSensorThreshold(float f, float f2, float f3) {
            this.gyroscopeThreshold = f;
            this.accelerometerThreshold = f2;
            this.lightThreshold = f3;
            return this;
        }
    }

    public static void setHiidoHost(String str, List<String> list) {
        if (str != null && !str.isEmpty()) {
            HIIDO_HOST = str;
        }
        if (list != null && !list.isEmpty()) {
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i);
            }
            HIIDO_IPS = strArr;
        }
    }

    public MetricsWorker addMetricsWorker(String str, long j) {
        return this.api.addMetricsWorker(str, j);
    }

    public boolean flushSession(String str, String str2) {
        return this.api.flushSession(str, str2);
    }

    public boolean flushSessionAll(String str, Set<String> set) {
        return this.api.flushSessionAll(str, set);
    }

    public void getHdid(Context context, final HdidReceiver hdidReceiver) {
        final Context applicationContext = AndroidUtil.applicationContext(context);
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDK.1
            @Override // java.lang.Runnable
            public void run() {
                hdidReceiver.onHdidReceived(DeviceProxy.getHdid(applicationContext));
            }
        });
    }

    public String getOnlineConfigParams(Context context, String str) {
        return this.api.getOnlineConfigParams(AndroidUtil.applicationContext(context), str);
    }

    public void onPause(Activity activity, PageActionReportOption pageActionReportOption) {
        this.api.onPause(activity, pageActionReportOption);
    }

    public void onResume(long j, Activity activity) {
        this.api.onResume(j, activity);
    }

    public void reportCrash(long j, String str) {
        this.api.reportCrash(j, str);
    }

    public void reportStatisticContent(String str, StatisContent statisContent) {
        this.api.reportStatisticContent(str, statisContent);
    }

    public void reportStatisticContentTemporary(String str, StatisContent statisContent) {
        this.api.reportStatisticContentTemporary(str, statisContent);
    }

    public void reportTimesEvent(long j, String str) {
        this.api.reportTimesEvent(j, str);
    }

    public void setHeartbeatField(String str, String str2) {
        this.api.setHeartbeatField(str, str2);
    }

    public void addActAdditionListener(ActListener actListener) {
        this.api.addActAdditionListener(actListener);
    }

    public void closeSession(String str) {
        this.api.closeSession(str);
    }

    public boolean flushSessionAll(String str) {
        return flushSessionAll(str, null);
    }

    public String getDeviceId(Context context) {
        return CommonFiller.getIMEI(AndroidUtil.applicationContext(context));
    }

    @Deprecated
    public String getHdid(Context context) {
        return DeviceProxy.getHdid(AndroidUtil.applicationContext(context));
    }

    public String getHdidSync(Context context) {
        return DeviceProxy.getHdid(AndroidUtil.applicationContext(context));
    }

    public String getMac(Context context) {
        return CommonFiller.getMacAddr(AndroidUtil.applicationContext(context));
    }

    public void onScreenMonitor(MotionEvent motionEvent) {
        this.api.onScreenMonitor(motionEvent);
    }

    public void onScreenPause(String str) {
        this.api.onScreenPause(str);
    }

    public void onScreenResume(String str) {
        this.api.onScreenResume(str);
    }

    public boolean registerActivityLifecycleMonitor(Context context) {
        return this.api.registerActivityLifecycleMonitor(AndroidUtil.applicationContext(context));
    }

    public void removeActAdditionListerner(ActListener actListener) {
        this.api.removeActAdditionListerner(actListener);
    }

    public void reportAppsflyer(String str) {
        this.api.reportAppsflyer(str);
    }

    public void reportLogin(long j) {
        this.api.reportLogin(j);
    }

    public void reportPushToken(String str) {
        this.api.reportPushToken(str);
    }

    public void setABTest(Map<String, String> map) {
        ABTestHandler.updateValue(this.appContext, map);
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        this.api.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
    }

    public void setBdCuid(String str) {
        this.api.setBdCuid(str);
    }

    public void setCurPageParam(String str) {
        this.api.setCurPageParam(str);
    }

    public HiidoSDK setLogWriter(StatisLogWriter statisLogWriter) {
        L.setLogSetting(statisLogWriter);
        return this;
    }

    public void setOnLineConfigListener(OnLineConfigListener onLineConfigListener) {
        this.api.setOnLineConfigListener(onLineConfigListener);
    }

    public void setOptions(Options options) {
        this.mOptions = options;
    }

    public void setUserAgreed(boolean z) {
        this.userAgreed = z;
    }

    public void updateOnlineConfigs(Context context) {
        this.api.updateOnlineConfigs(AndroidUtil.applicationContext(context));
    }

    public synchronized void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        boolean z = false;
        if (this.isInited) {
            L.warnOn(this, "appStartLaunchWithAppKey isInited is true", new Object[0]);
            return;
        }
        if (!NoNull.isEmpty(instance().getOptions().testServer)) {
            z = true;
        }
        isDebugMode = z;
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

    public void appStartLaunchWithAppKey(Context context, String str, String str2, String str3, OnStatisListener onStatisListener) {
        StatisOption statisOption = new StatisOption();
        statisOption.setAppId(str2);
        statisOption.setAppkey(str);
        statisOption.setFrom(str3);
        appStartLaunchWithAppKey(context, statisOption, onStatisListener);
    }

    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        return this.api.pushToSession(str, str2, list, map, map2);
    }

    public void reportCount(int i, String str, String str2, long j, int i2) {
        this.api.reportCount(i, str, str2, j, i2);
    }

    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
        this.api.reportCountEvent(j, str, d, str2, property);
    }

    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
        this.api.reportReturnCode(i, str, j, str2, map);
    }

    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
        this.api.reportSrcData(i, str, str2, j, map);
    }

    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        this.api.reportSuccess(j, str, str2, j2, str3);
    }

    public void beginSession(String str, String str2, long j, Map<String, Long> map) {
        this.api.beginSession(str, str2, j, map);
    }

    public void reportCount(int i, String str, String str2, long j) {
        this.api.reportCount(i, str, str2, j);
    }

    public void reportCountEvent(long j, String str, double d, String str2) {
        this.api.reportCountEvent(j, str, d, str2);
    }

    public void reportErrorEvent(long j, String str, String str2, String str3) {
        this.api.reportErrorEvent(j, str, str2, str3);
    }

    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        this.api.reportReg(str, str2, str3, map);
    }

    public void reportReturnCode(int i, String str, long j, String str2) {
        this.api.reportReturnCode(i, str, j, str2, null);
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        this.api.reportStatisticContentWithNoComm(AndroidUtil.applicationContext(context), str, statisContent, z);
    }

    public void reportTimesEvent(long j, String str, String str2, Property property) {
        this.api.reportTimesEvent(j, str, str2, property);
    }

    public boolean isUserAgreed() {
        if (Build.VERSION.SDK_INT >= 23 || this.userAgreed) {
            return true;
        }
        String str = null;
        try {
            str = ArdUtil.getSjp(this.appContext).trim();
        } catch (Throwable th) {
            L.debug(this, th.toString(), new Object[0]);
        }
        if (str != null && (str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("VIVO"))) {
            return true;
        }
        return false;
    }

    public void onPause(String str, PageActionReportOption pageActionReportOption) {
        this.api.onPause(str, pageActionReportOption);
    }

    public void onResume(long j, String str) {
        this.api.onResume(j, str);
    }

    public void reportCrash(long j, Throwable th) {
        this.api.reportCrash(j, th);
    }

    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        return this.api.pushToSession(str, str2, calAction, str3, number, map, map2);
    }

    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
        this.api.reportShare(str, i, str2, shareType, str3, str4, str5);
    }

    public void reportCount(String str, int i, String str2, String str3, long j) {
        this.api.reportCount(str, i, str2, str3, j, 1);
    }

    public void reportReturnCode(String str, int i, String str2, long j, String str3) {
        this.api.reportReturnCode(str, i, str2, j, str3, null);
    }

    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
        this.api.reportCount(str, i, str2, str3, j, i2);
    }

    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        this.api.reportFailure(j, str, str2, str3, str4, str5);
    }

    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
        this.api.reportReturnCode(str, i, str2, j, str3, map);
    }

    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
        this.api.reportSrcData(str, i, str2, str3, j, map);
    }

    public void reportCountEvent(long j, String str, double d) {
        this.api.reportCountEvent(j, str, d);
    }

    public void reportCustomContent(long j, String str, String str2) {
        this.api.reportCustomContent(j, str, str2);
    }

    public boolean reportFeedBack(String str, String str2, String str3) {
        return this.api.reportFeedBack(str, str2, str3);
    }

    public void reportLocation(double d, double d2, double d3) {
        this.api.reportLocation(d, d2, d3);
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z) {
        this.api.reportStatisticContent(str, statisContent, z);
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        this.api.reportStatisticContentWithNoComm(AndroidUtil.applicationContext(context), str, statisContent);
    }

    public void reportTimesEvent(long j, String str, String str2) {
        this.api.reportTimesEvent(j, str, str2);
    }

    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
        this.api.reportIM(str, str2, str3, date, date2, str4, i, str5);
    }

    public void setABTest(String... strArr) {
        ABTestHandler.updateValue(this.appContext, strArr);
    }
}
