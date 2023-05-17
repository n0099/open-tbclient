package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\rJ3\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IPayMetricsStatisticsApi;", "Lkotlin/Any;", "", "scode", "", "uri", "countName", "", "count", "", "reportCount", "(ILjava/lang/String;Ljava/lang/String;J)V", "times", "(ILjava/lang/String;Ljava/lang/String;JI)V", "timeConsumption", "code", "reportReturnCode", "(ILjava/lang/String;JLjava/lang/String;)V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface IPayMetricsStatisticsApi {
    void reportCount(int i, String str, String str2, long j);

    void reportCount(int i, String str, String str2, long j, int i2);

    void reportReturnCode(int i, String str, long j, String str2);
}
