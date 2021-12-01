package com.yy.hiidostatis.defs.interf;

import android.content.Context;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.message.Packer;
/* loaded from: classes3.dex */
public interface IStatisAPI {

    /* loaded from: classes3.dex */
    public interface ReportResult {
        void onReportResult(boolean z);
    }

    IStatisAPI create();

    Long getLaunchTime();

    StatisOption getOption();

    String getSession();

    void init(Context context, StatisOption statisOption);

    void reportAppList(long j2, String str, String str2);

    void reportAppList(long j2, String str, String str2, String str3);

    void reportCrash(long j2, String str);

    void reportCrash(long j2, Throwable th);

    void reportCrashInner(long j2, Throwable th);

    void reportDevice(long j2, StatisContent statisContent, ReportResult reportResult);

    @Deprecated
    boolean reportDevice(long j2);

    @Deprecated
    boolean reportDevice(long j2, StatisContent statisContent);

    void reportEvent(long j2, String str);

    @Deprecated
    void reportInstall(int i2, ReportResult reportResult);

    void reportInstall(int i2, Packer.OnSavedListener onSavedListener);

    @Deprecated
    boolean reportInstall(int i2);

    void reportLanuch(long j2, String str, StatisContent statisContent);

    void reportPage(long j2, String str);

    void reportPageState(long j2, String str, long j3);

    void reportRecentAppList(long j2, String str, String str2);

    void reportSdkList(long j2, String str);

    void setSession(String str);
}
