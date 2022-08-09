package com.yy.mobile.framework.revenuesdk;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
@Keep
/* loaded from: classes8.dex */
public interface IRevenue {
    IAppPayService getAppPayService();

    IPayEventStatistics getPayEventStatistic();

    IPayServiceStatistics getPayServiceStatistics();

    void updateConfig(RevenueConfig revenueConfig);
}
