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
/* loaded from: classes3.dex */
public interface HiidoApi {
    void addActAdditionListener(ActListener actListener);

    MetricsWorker addMetricsWorker(String str, long j2);

    void appRun();

    void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener);

    void beginSession(String str, String str2, long j2, Map<String, Long> map);

    void closeSession(String str);

    StatisAPI createNewStatisApi();

    boolean flushSession(String str, String str2);

    boolean flushSessionAll(String str, Set<String> set);

    String getAppId();

    String getAppKey();

    Context getContext();

    String getDeviceId(Context context);

    String getFrom();

    @Deprecated
    String getHdid(Context context);

    void getHdid(Context context, HiidoSDK.HdidReceiver hdidReceiver);

    String getMac(Context context);

    OnStatisListener getOnStatisListener();

    String getOnlineConfigParams(Context context, String str);

    StatisOption getStatisOption();

    void onPause(Activity activity, HiidoSDK.PageActionReportOption pageActionReportOption);

    void onPause(String str, HiidoSDK.PageActionReportOption pageActionReportOption);

    void onResume(long j2, Activity activity);

    void onResume(long j2, String str);

    void onScreenMonitor(MotionEvent motionEvent);

    void onScreenPause(String str);

    void onScreenResume(String str);

    boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2);

    boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2);

    boolean registerActivityLifecycleMonitor(Context context);

    void removeActAdditionListerner(ActListener actListener);

    void reportAppsflyer(String str);

    void reportCount(int i2, String str, String str2, long j2);

    void reportCount(int i2, String str, String str2, long j2, int i3);

    void reportCount(String str, int i2, String str2, String str3, long j2, int i3);

    void reportCountEvent(long j2, String str, double d2);

    void reportCountEvent(long j2, String str, double d2, String str2);

    void reportCountEvent(long j2, String str, double d2, String str2, Property property);

    void reportCrash(long j2, String str);

    void reportCrash(long j2, Throwable th);

    void reportCustomContent(long j2, String str, String str2);

    void reportErrorEvent(long j2, String str, String str2, String str3);

    void reportFailure(long j2, String str, String str2, String str3, String str4, String str5);

    boolean reportFeedBack(String str, String str2, String str3);

    void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5);

    void reportLocation(double d2, double d3, double d4);

    void reportLogin(long j2);

    void reportPushToken(String str);

    void reportReg(String str, String str2, String str3, Map<String, String> map);

    void reportReturnCode(int i2, String str, long j2, String str2, Map<String, String> map);

    void reportReturnCode(String str, int i2, String str2, long j2, String str3, Map<String, String> map);

    void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5);

    void reportSrcData(int i2, String str, String str2, long j2, Map<String, String> map);

    void reportSrcData(String str, int i2, String str2, String str3, long j2, Map<String, String> map);

    void reportStatisticContent(String str, StatisContent statisContent);

    void reportStatisticContent(String str, StatisContent statisContent, boolean z);

    void reportStatisticContentTemporary(String str, StatisContent statisContent);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z);

    void reportSuccess(long j2, String str, String str2, long j3, String str3);

    void reportTimesEvent(long j2, String str);

    void reportTimesEvent(long j2, String str, String str2);

    void reportTimesEvent(long j2, String str, String str2, Property property);

    void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate);

    void setBdCuid(String str);

    void setCurPageParam(String str);

    void setHeartbeatField(String str, String str2);

    void setOnLineConfigListener(OnLineConfigListener onLineConfigListener);

    void updateOnlineConfigs(Context context);
}
