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
/* loaded from: classes9.dex */
public interface IStatisApi extends IStatisAPI {
    void addActAdditionListener(ActListener actListener);

    MetricsWorker addMetricsWorker(String str, long j);

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

    void reportAction(long j, String str, String str2, String str3);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportAppList(long j, String str, String str2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportAppList(long j, String str, String str2, String str3);

    void reportAppsflyer(String str);

    void reportCount(int i, String str, String str2, long j);

    void reportCount(int i, String str, String str2, long j, int i2);

    void reportCount(String str, int i, String str2, String str3, long j);

    void reportCount(String str, int i, String str2, String str3, long j, int i2);

    void reportCountEvent(long j, String str, double d);

    void reportCountEvent(long j, String str, double d, String str2);

    void reportCountEvent(long j, String str, double d, String str2, Property property);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportCrash(long j, String str);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportCrash(long j, Throwable th);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportCrashInner(long j, Throwable th);

    void reportCustomContent(long j, String str, String str2);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportDevice(long j, StatisContent statisContent, IStatisAPI.ReportResult reportResult);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    boolean reportDevice(long j);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    boolean reportDevice(long j, StatisContent statisContent);

    void reportDo(long j);

    void reportDo5(long j);

    void reportDoShort(long j, Map<String, String> map);

    void reportError(long j, String str, String str2, String str3);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportEvent(long j, String str);

    void reportFailure(long j, String str, String str2, String str3, String str4, String str5);

    void reportFeedback(long j, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult);

    void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportInstall(int i, IStatisAPI.ReportResult reportResult);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportInstall(int i, Packer.OnSavedListener onSavedListener);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    boolean reportInstall(int i);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportLanuch(long j, String str, StatisContent statisContent);

    void reportLocation(long j, double d, double d2, double d3, IStatisAPI.ReportResult reportResult);

    void reportLogin(long j);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportPage(long j, String str);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportPageState(long j, String str, long j2);

    void reportPushToken(long j, String str);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportRecentAppList(long j, String str, String str2);

    void reportReg(String str, String str2, String str3, Map<String, String> map);

    void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map);

    void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map);

    void reportRun(long j);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void reportSdkList(long j, String str);

    void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5);

    void reportSrcData(int i, String str, String str2, long j, Map<String, String> map);

    void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map);

    void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2);

    void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3);

    void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z);

    void reportSuccess(long j, String str, String str2, long j2, String str3);

    void reportTimesEvent(long j, String str);

    void reportTimesEvent(long j, String str, String str2);

    void reportTimesEvent(long j, String str, String str2, Property property);

    void reportUrlScheme(String str, String str2, int i, String str3, String str4);

    void setAbroad(boolean z);

    void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate);

    void setBusinessType(int i);

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    void setSession(String str);

    void setTestServer(String str);
}
