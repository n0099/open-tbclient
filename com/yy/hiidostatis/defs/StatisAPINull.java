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
public class StatisAPINull implements IStatisApi {
    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void addActAdditionListener(ActListener actListener) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public MetricsWorker addMetricsWorker(String str, long j) {
        return null;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        return this;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void exit() {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void generateSession() {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        return null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public Context getContext() {
        return null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        return null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        return null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        return null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void removeActAdditionListener(ActListener actListener) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAction(long j, String str, String str2, String str3) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2, String str3) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAppsflyer(String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i, String str, String str2, long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i, String str2, String str3, long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, Throwable th) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j, Throwable th) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCustomContent(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j) {
        return false;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j, StatisContent statisContent) {
        return false;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo(long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo5(long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDoShort(long j, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportError(long j, String str, String str2, String str3) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j, String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFeedback(long j, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, IStatisAPI.ReportResult reportResult) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, Packer.OnSavedListener onSavedListener) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i) {
        return false;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j, String str, StatisContent statisContent) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLocation(long j, double d, double d2, double d3, IStatisAPI.ReportResult reportResult) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLogin(long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j, String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j, String str, long j2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportPushToken(long j, String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportRun(long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j, String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2, Property property) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportUrlScheme(String str, String str2, int i, String str3, String str4) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAbroad(boolean z) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setBusinessType(int i) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setTestServer(String str) {
    }
}
