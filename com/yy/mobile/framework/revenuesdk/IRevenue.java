package com.yy.mobile.framework.revenuesdk;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
@Keep
/* loaded from: classes6.dex */
public interface IRevenue {
    IAppPayService getAppPayService();

    ISDKReporter getSDKReporter();

    void updateConfig(RevenueConfig revenueConfig);
}
