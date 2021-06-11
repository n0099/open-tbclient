package i.a.a.d;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
/* loaded from: classes8.dex */
public final class b implements IMiddleRevenue {

    /* renamed from: a  reason: collision with root package name */
    public final a f72046a;

    /* renamed from: b  reason: collision with root package name */
    public final IRevenue f72047b;

    public b(MiddleRevenueConfig middleRevenueConfig, IRevenue iRevenue) {
        this.f72047b = iRevenue;
        IAppPayService appPayService = this.f72047b.getAppPayService();
        Intrinsics.checkExpressionValueIsNotNull(appPayService, "revenue.appPayService");
        this.f72046a = new a(middleRevenueConfig, appPayService);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        return this.f72046a;
    }

    @Override // tv.athena.revenue.api.IMiddleRevenue
    public IMiddlePayService getMiddlePayService() {
        return this.f72046a;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public ISDKReporter getSDKReporter() {
        return null;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        this.f72047b.updateConfig(revenueConfig);
    }
}
