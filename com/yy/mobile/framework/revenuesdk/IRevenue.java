package com.yy.mobile.framework.revenuesdk;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IEventReporter;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
@Keep
/* loaded from: classes8.dex */
public interface IRevenue {
    IAppPayService getAppPayService();

    IEventReporter getEventReporter();

    IPayReporter getPayReporter();

    void updateConfig(RevenueConfig revenueConfig);
}
