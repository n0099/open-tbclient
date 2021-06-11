package com.yy.hiidostatis.provider;

import android.app.Application;
import android.content.Context;
import com.yy.hiidostatis.api.OnStatisListener;
import com.yy.hiidostatis.defs.listener.ActAdditionListenerController;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.util.Set;
/* loaded from: classes7.dex */
public class MessageConfig {
    public static final int MIN_INTERVAL = 5;
    public static final String SDK_VER = "4.0.23";
    public Application ApplicationContext;
    public String appId;
    public String appkey;
    public String appsflyer;
    public String bdCuid;
    public String cacheFileName;
    public String from;
    public Set<String> ignoreActivity;
    public final boolean isMainConfig;
    public boolean lifecycleMonitor;
    public String sessionId;
    public OnStatisListener uidProvider;
    public String ver;
    public boolean isOpenCrashMonitor = true;
    public boolean isLogOn = false;
    public boolean reportApplist = false;
    public int defaultMetricsExpire = 1800;
    public int defaultMetricsInterval = 60;
    public boolean openSDKMetrics = true;
    public boolean openAutoTrack = false;
    public float gyroscopeThreshold = 0.5f;
    public float accelerometerThreshold = 0.6f;
    public float lightThreshold = 15.0f;
    public boolean openSensorMonitor = false;
    public boolean gaidEnable = false;
    public int interval = 30;
    public int batchThreshold = 20;
    public ActAdditionListenerController mActListenerController = new ActAdditionListenerController();

    public MessageConfig(Context context, String str, boolean z) {
        this.cacheFileName = "hdcommon_module_used_file";
        this.ApplicationContext = (Application) (context instanceof Application ? context : context.getApplicationContext());
        this.appkey = str;
        this.isMainConfig = z;
        this.cacheFileName = HdStatisConfig.getConfig(str).getCacheFileName();
    }

    public void addActAdditionListener(ActListener actListener) {
        this.mActListenerController.add(actListener);
    }

    public float getAccelerometerThreshold() {
        return this.accelerometerThreshold;
    }

    public ActAdditionListenerController getActListenerController() {
        return this.mActListenerController;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public Context getApplicationContext() {
        return this.ApplicationContext;
    }

    public String getAppsflyer() {
        return this.appsflyer;
    }

    public int getBatchThreshold() {
        return this.batchThreshold;
    }

    public String getBdCuid() {
        return this.bdCuid;
    }

    public String getCacheFileName() {
        return this.cacheFileName;
    }

    public int getDefaultMetricsExpire() {
        return this.defaultMetricsExpire;
    }

    public int getDefaultMetricsInterval() {
        return this.defaultMetricsInterval;
    }

    public String getFrom() {
        return this.from;
    }

    public float getGyroscopeThreshold() {
        return this.gyroscopeThreshold;
    }

    public Set<String> getIgnoreActivity() {
        return this.ignoreActivity;
    }

    public int getInterval() {
        return this.interval;
    }

    public float getLightThreshold() {
        return this.lightThreshold;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public OnStatisListener getUidProvider() {
        return this.uidProvider;
    }

    public String getVer() {
        return this.ver;
    }

    public boolean isGaidEnable() {
        return this.gaidEnable;
    }

    public boolean isLifecycleMonitor() {
        return this.lifecycleMonitor;
    }

    public boolean isLogOn() {
        return this.isLogOn;
    }

    public boolean isMainConfig() {
        return this.isMainConfig;
    }

    public boolean isOpenAutoTrack() {
        return this.openAutoTrack;
    }

    public boolean isOpenCrashMonitor() {
        return this.isOpenCrashMonitor;
    }

    public boolean isOpenSDKMetrics() {
        return this.openSDKMetrics;
    }

    public boolean isOpenSensorMonitor() {
        return this.openSensorMonitor;
    }

    public boolean isReportApplist() {
        return this.reportApplist;
    }

    public void removeActAdditionListerner(ActListener actListener) {
        this.mActListenerController.remove(actListener);
    }

    public void setAccelerometerThreshold(float f2) {
        this.accelerometerThreshold = f2;
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        this.mActListenerController.setHiidoSdkAdditionDelegate(hiidoSdkAdditionDelegate);
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setAppsflyer(String str) {
        this.appsflyer = str;
    }

    public void setBatchThreshold(int i2) {
        this.batchThreshold = i2;
    }

    public void setBdCuid(String str) {
        this.bdCuid = str;
    }

    public void setDefaultMetricsExpire(int i2) {
        this.defaultMetricsExpire = i2;
    }

    public void setDefaultMetricsInterval(int i2) {
        this.defaultMetricsInterval = i2;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setGaidEnable(boolean z) {
        this.gaidEnable = z;
    }

    public void setGyroscopeThreshold(float f2) {
        this.gyroscopeThreshold = f2;
    }

    public void setIgnoreActivity(Set<String> set) {
        this.ignoreActivity = set;
    }

    public void setInterval(int i2) {
        this.interval = i2;
    }

    public void setLifecycleMonitor(boolean z) {
        this.lifecycleMonitor = z;
    }

    public void setLightThreshold(float f2) {
        this.lightThreshold = f2;
    }

    public void setLogOn(boolean z) {
        this.isLogOn = z;
    }

    public void setOpenAutoTrack(boolean z) {
        this.openAutoTrack = z;
    }

    public void setOpenCrashMonitor(boolean z) {
        this.isOpenCrashMonitor = z;
    }

    public void setOpenSDKMetrics(boolean z) {
        this.openSDKMetrics = z;
    }

    public void setOpenSensorMonitor(boolean z) {
        this.openSensorMonitor = z;
    }

    public void setReportApplist(boolean z) {
        this.reportApplist = z;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setUidProvider(OnStatisListener onStatisListener) {
        this.uidProvider = onStatisListener;
    }

    public void setVer(String str) {
        this.ver = str;
    }
}
