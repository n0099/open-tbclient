package com.yy.hiidostatis.api;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import com.yy.hiidostatis.message.module.sessionreport.EventValue;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class NotInitHiidoApi implements HiidoApi {
    @Override // com.yy.hiidostatis.api.HiidoApi
    public void addActAdditionListener(ActListener actListener) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public MetricsWorker addMetricsWorker(String str, long j) {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appRun() {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void beginSession(String str, String str2, long j, Map<String, Long> map) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void closeSession(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisAPI createNewStatisApi() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSession(String str, String str2) {
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSessionAll(String str, Set<String> set) {
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppId() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppKey() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public Context getContext() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getDeviceId(Context context) {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getFrom() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getHdid(Context context) {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void getHdid(Context context, HiidoSDK.HdidReceiver hdidReceiver) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getMac(Context context) {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public OnStatisListener getOnStatisListener() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getOnlineConfigParams(Context context, String str) {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisOption getStatisOption() {
        return null;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(Activity activity, HiidoSDK.PageActionReportOption pageActionReportOption) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(String str, HiidoSDK.PageActionReportOption pageActionReportOption) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j, Activity activity) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j, String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenMonitor(MotionEvent motionEvent) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenPause(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenResume(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean registerActivityLifecycleMonitor(Context context) {
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void removeActAdditionListerner(ActListener actListener) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportAppsflyer(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i, String str, String str2, long j) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d, String str2) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(long j, String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(long j, Throwable th) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCustomContent(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportErrorEvent(long j, String str, String str2, String str3) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean reportFeedBack(String str, String str2, String str3) {
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLocation(double d, double d2, double d3) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLogin(long j) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportPushToken(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str, String str2, Property property) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setBdCuid(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setCurPageParam(String str) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setHeartbeatField(String str, String str2) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setOnLineConfigListener(OnLineConfigListener onLineConfigListener) {
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void updateOnlineConfigs(Context context) {
    }
}
