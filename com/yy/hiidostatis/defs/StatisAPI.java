package com.yy.hiidostatis.defs;

import android.content.Context;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.config.ABNameDefine;
import com.yy.hiidostatis.config.ABTestHandler;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.MessageConfigFactory;
import java.util.Date;
import java.util.Map;
/* loaded from: classes7.dex */
public class StatisAPI implements IStatisAPI {
    public IStatisApi sApi = new StatisAPINull();

    public void addActAdditionListener(ActListener actListener) {
        this.sApi.addActAdditionListener(actListener);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        return this;
    }

    public void exit() {
        this.sApi.exit();
    }

    public void generateSession() {
        this.sApi.generateSession();
    }

    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        return this.sApi.getAdditionParamsDelegate();
    }

    public Context getContext() {
        return this.sApi.getContext();
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        return this.sApi.getLaunchTime();
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        return this.sApi.getOption();
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        return this.sApi.getSession();
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        ABTestHandler.initInstance(context);
        if (ABTestHandler.getAbBoolean(ABNameDefine.NEW_PACKER_MODULE)) {
            MessageConfig generate = MessageConfigFactory.generate(context, statisOption.getAppkey());
            generate.setFrom(statisOption.getFrom());
            generate.setAppId(statisOption.getAppId());
            generate.setVer(statisOption.getVer());
            StatisAPINew statisAPINew = new StatisAPINew(generate);
            statisAPINew.onInitSuccess();
            this.sApi = statisAPINew;
            return;
        }
        StatisAPIOld statisAPIOld = new StatisAPIOld();
        this.sApi = statisAPIOld;
        statisAPIOld.init(context, statisOption);
    }

    public void removeActAdditionListener(ActListener actListener) {
        this.sApi.addActAdditionListener(actListener);
    }

    public void reportAction(long j, String str, String str2, String str3) {
        this.sApi.reportAction(j, str, str2, str3);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2) {
        this.sApi.reportAppList(j, str, str2);
    }

    public void reportAppsflyer(String str) {
        this.sApi.reportAppsflyer(str);
    }

    public void reportCountEvent(long j, String str, double d2) {
        this.sApi.reportCountEvent(j, str, d2);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, String str) {
        this.sApi.reportCrash(j, str);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j, Throwable th) {
        this.sApi.reportCrashInner(j, th);
    }

    public void reportCustomContent(long j, String str, String str2) {
        this.sApi.reportCustomContent(j, str, str2);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j, StatisContent statisContent) {
        return this.sApi.reportDevice(j, statisContent);
    }

    public void reportDo(long j) {
        this.sApi.reportDo(j);
    }

    public void reportDo5(long j) {
        this.sApi.reportDo5(j);
    }

    public void reportDoShort(long j, Map<String, String> map) {
        this.sApi.reportDoShort(j, map);
    }

    public void reportError(long j, String str, String str2, String str3) {
        this.sApi.reportError(j, str, str2, str3);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j, String str) {
        this.sApi.reportEvent(j, str);
    }

    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        this.sApi.reportFailure(j, str, str2, str3, str4, str5);
    }

    public void reportFeedback(long j, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        this.sApi.reportFeedback(j, str, str2, str3, str4, reportResult);
    }

    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5) {
        this.sApi.reportIM(str, str2, str3, date, date2, str4, i2, str5);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, IStatisAPI.ReportResult reportResult) {
        this.sApi.reportInstall(i2, reportResult);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j, String str, StatisContent statisContent) {
        this.sApi.reportLanuch(j, str, statisContent);
    }

    public void reportLocation(long j, double d2, double d3, double d4, IStatisAPI.ReportResult reportResult) {
        this.sApi.reportLocation(j, d2, d3, d4, reportResult);
    }

    public void reportLogin(long j) {
        this.sApi.reportLogin(j);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j, String str) {
        this.sApi.reportPage(j, str);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j, String str, long j2) {
        this.sApi.reportPageState(j, str, j2);
    }

    public void reportPushToken(long j, String str) {
        this.sApi.reportPushToken(j, str);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j, String str, String str2) {
        this.sApi.reportRecentAppList(j, str, str2);
    }

    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        this.sApi.reportReg(str, str2, str3, map);
    }

    public void reportRun(long j) {
        this.sApi.reportRun(j);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j, String str) {
        this.sApi.reportSdkList(j, str);
    }

    public void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5) {
        this.sApi.reportShare(str, i2, str2, shareType, str3, str4, str5);
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        this.sApi.reportStatisticContent(str, statisContent, z, z2);
    }

    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        this.sApi.reportStatisticContentTemporary(str, statisContent, z, z2);
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        this.sApi.reportStatisticContentWithNoComm(context, str, statisContent);
    }

    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        this.sApi.reportSuccess(j, str, str2, j2, str3);
    }

    public void reportTimesEvent(long j, String str) {
        this.sApi.reportTimesEvent(j, str);
    }

    public void reportUrlScheme(String str, String str2, int i2, String str3, String str4) {
        this.sApi.reportUrlScheme(str, str2, i2, str3, str4);
    }

    public void setAbroad(boolean z) {
        this.sApi.setAbroad(z);
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        this.sApi.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
    }

    public void setBusinessType(int i2) {
        this.sApi.setBusinessType(i2);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        this.sApi.setSession(str);
    }

    public void setTestServer(String str) {
        this.sApi.setTestServer(str);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2, String str3) {
        this.sApi.reportAppList(j, str, str2, str3);
    }

    public void reportCountEvent(long j, String str, double d2, String str2) {
        this.sApi.reportCountEvent(j, str, d2, str2);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, Throwable th) {
        this.sApi.reportCrash(j, th);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j) {
        return this.sApi.reportDevice(j);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, Packer.OnSavedListener onSavedListener) {
        this.sApi.reportInstall(i2, onSavedListener);
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        this.sApi.reportStatisticContent(str, statisContent, z, z2, z3);
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        this.sApi.reportStatisticContentWithNoComm(context, str, statisContent, z);
    }

    public void reportTimesEvent(long j, String str, String str2) {
        this.sApi.reportTimesEvent(j, str, str2);
    }

    public void reportCountEvent(long j, String str, double d2, String str2, Property property) {
        this.sApi.reportCountEvent(j, str, d2, str2, property);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        this.sApi.reportDevice(j, statisContent, reportResult);
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i2) {
        return this.sApi.reportInstall(i2);
    }

    public void reportTimesEvent(long j, String str, String str2, Property property) {
        this.sApi.reportTimesEvent(j, str, str2, property);
    }
}
