package com.yy.mobile.framework.revenuesdk;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatisticsApi;
@Keep
/* loaded from: classes2.dex */
public interface IRevenue {
    IAppPayService getAppPayService();

    IPayEventStatisticsApi getPayEventStatisticApi();

    IPayServiceStatisticsApi getPayServiceStatisticsApi();

    void updateConfig(RevenueConfig revenueConfig);
}
