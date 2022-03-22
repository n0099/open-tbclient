package com.yy.hiidostatis.defs.interf;

import java.util.Map;
/* loaded from: classes7.dex */
public interface IMetricsAPI {

    /* loaded from: classes7.dex */
    public interface IReportListener {
        void onReportResult(int i);
    }

    void reportCount(int i, String str, String str2, long j);

    void reportCount(int i, String str, String str2, long j, int i2);

    void reportReturnCode(int i, String str, long j, String str2);

    void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map);

    void reportSrcData(int i, String str, String str2, long j, Map<String, String> map);
}
