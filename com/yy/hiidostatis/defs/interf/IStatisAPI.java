package com.yy.hiidostatis.defs.interf;

import android.content.Context;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.message.Packer;
/* loaded from: classes10.dex */
public interface IStatisAPI {

    /* loaded from: classes10.dex */
    public interface ReportResult {
        void onReportResult(boolean z);
    }

    IStatisAPI create();

    Long getLaunchTime();

    StatisOption getOption();

    String getSession();

    void init(Context context, StatisOption statisOption);

    void reportAppList(long j, String str, String str2);

    void reportAppList(long j, String str, String str2, String str3);

    void reportCrash(long j, String str);

    void reportCrash(long j, Throwable th);

    void reportCrashInner(long j, Throwable th);

    void reportDevice(long j, StatisContent statisContent, ReportResult reportResult);

    @Deprecated
    boolean reportDevice(long j);

    @Deprecated
    boolean reportDevice(long j, StatisContent statisContent);

    void reportEvent(long j, String str);

    @Deprecated
    void reportInstall(int i, ReportResult reportResult);

    void reportInstall(int i, Packer.OnSavedListener onSavedListener);

    @Deprecated
    boolean reportInstall(int i);

    void reportLanuch(long j, String str, StatisContent statisContent);

    void reportPage(long j, String str);

    void reportPageState(long j, String str, long j2);

    void reportRecentAppList(long j, String str, String str2);

    void reportSdkList(long j, String str);

    void setSession(String str);
}
