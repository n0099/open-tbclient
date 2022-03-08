package com.yy.hiidostatis.defs;

import android.content.Context;
import com.yy.hiidostatis.api.MetricsWorker;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.message.Packer;
import java.util.Date;
import java.util.Map;
/* loaded from: classes8.dex */
public interface IStatisApi extends IStatisAPI {
    void addActAdditionListener(ActListener actListener);

    MetricsWorker addMetricsWorker(String str, long j2);

    void exit();

    void generateSession();

    HiidoSdkAdditionDelegate getAdditionParamsDelegate();

    Context getContext();

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    Long getLaunchTime();

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    StatisOption getOption();

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    String getSession();

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void init(Context context, StatisOption statisOption);

    void removeActAdditionListener(ActListener actListener);

    void reportAction(long j2, String str, String str2, String str3);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportAppList(long j2, String str, String str2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportAppList(long j2, String str, String str2, String str3);

    void reportAppsflyer(String str);

    void reportCount(int i2, String str, String str2, long j2);

    void reportCount(int i2, String str, String str2, long j2, int i3);

    void reportCount(String str, int i2, String str2, String str3, long j2);

    void reportCount(String str, int i2, String str2, String str3, long j2, int i3);

    void reportCountEvent(long j2, String str, double d2);

    void reportCountEvent(long j2, String str, double d2, String str2);

    void reportCountEvent(long j2, String str, double d2, String str2, Property property);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportCrash(long j2, String str);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportCrash(long j2, Throwable th);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportCrashInner(long j2, Throwable th);

    void reportCustomContent(long j2, String str, String str2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportDevice(long j2, StatisContent statisContent, IStatisAPI.ReportResult reportResult);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    boolean reportDevice(long j2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    boolean reportDevice(long j2, StatisContent statisContent);

    void reportDo(long j2);

    void reportDo5(long j2);

    void reportDoShort(long j2, Map<String, String> map);

    void reportError(long j2, String str, String str2, String str3);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportEvent(long j2, String str);

    void reportFailure(long j2, String str, String str2, String str3, String str4, String str5);

    void reportFeedback(long j2, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult);

    void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportInstall(int i2, IStatisAPI.ReportResult reportResult);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportInstall(int i2, Packer.OnSavedListener onSavedListener);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    boolean reportInstall(int i2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportLanuch(long j2, String str, StatisContent statisContent);

    void reportLocation(long j2, double d2, double d3, double d4, IStatisAPI.ReportResult reportResult);

    void reportLogin(long j2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportPage(long j2, String str);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportPageState(long j2, String str, long j3);

    void reportPushToken(long j2, String str);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportRecentAppList(long j2, String str, String str2);

    void reportReg(String str, String str2, String str3, Map<String, String> map);

    void reportReturnCode(int i2, String str, long j2, String str2, Map<String, String> map);

    void reportReturnCode(String str, int i2, String str2, long j2, String str3, Map<String, String> map);

    void reportRun(long j2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportSdkList(long j2, String str);

    void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5);

    void reportSrcData(int i2, String str, String str2, long j2, Map<String, String> map);

    void reportSrcData(String str, int i2, String str2, String str3, long j2, Map<String, String> map);

    void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2);

    void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3);

    void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z);

    void reportSuccess(long j2, String str, String str2, long j3, String str3);

    void reportTimesEvent(long j2, String str);

    void reportTimesEvent(long j2, String str, String str2);

    void reportTimesEvent(long j2, String str, String str2, Property property);

    void reportUrlScheme(String str, String str2, int i2, String str3, String str4);

    void setAbroad(boolean z);

    void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate);

    void setBusinessType(int i2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void setSession(String str);

    void setTestServer(String str);
}
