package com.yy.hiidostatis.defs.interf;

import java.util.Map;
/* loaded from: classes8.dex */
public interface IMetricsAPI {

    /* loaded from: classes8.dex */
    public interface IReportListener {
        void onReportResult(int i2);
    }

    void reportCount(int i2, String str, String str2, long j2);

    void reportCount(int i2, String str, String str2, long j2, int i3);

    void reportReturnCode(int i2, String str, long j2, String str2);

    void reportReturnCode(int i2, String str, long j2, String str2, Map<String, String> map);

    void reportSrcData(int i2, String str, String str2, long j2, Map<String, String> map);
}
