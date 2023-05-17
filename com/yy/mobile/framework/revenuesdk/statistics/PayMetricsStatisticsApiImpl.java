package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatisticsApi;
/* loaded from: classes10.dex */
public class PayMetricsStatisticsApiImpl implements IPayMetricsStatisticsApi {
    public final String TAG = "MonitorReporter";

    public PayMetricsStatisticsApiImpl(RevenueConfig revenueConfig) {
        HiidoSDKApi.initHiidoSdk(revenueConfig);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatisticsApi
    public void reportCount(int i, String str, String str2, long j) {
        RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " count:" + j);
        HiidoSDKApi.reportCount(i, str, str2, j);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatisticsApi
    public void reportReturnCode(int i, String str, long j, String str2) {
        RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " code:" + str2);
        HiidoSDKApi.reportReturnCode(i, str, j, str2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatisticsApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
        RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " count:" + j);
        HiidoSDKApi.reportCount(i, str, str2, j);
    }
}
