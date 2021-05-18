package i.a.a.d;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.giftapi.IGiftService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
/* loaded from: classes8.dex */
public final class c implements IMiddleRevenue {

    /* renamed from: a  reason: collision with root package name */
    public final a f68746a;

    /* renamed from: b  reason: collision with root package name */
    public final b f68747b;

    /* renamed from: c  reason: collision with root package name */
    public final IRevenue f68748c;

    public c(MiddleRevenueConfig middleRevenueConfig, IRevenue iRevenue) {
        this.f68748c = iRevenue;
        IGiftService giftService = iRevenue.getGiftService();
        Intrinsics.checkExpressionValueIsNotNull(giftService, "revenue.giftService");
        this.f68746a = new a(middleRevenueConfig, giftService);
        IAppPayService appPayService = this.f68748c.getAppPayService();
        Intrinsics.checkExpressionValueIsNotNull(appPayService, "revenue.appPayService");
        this.f68747b = new b(middleRevenueConfig, appPayService);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        return this.f68747b;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IGiftService getGiftService() {
        return this.f68746a;
    }

    @Override // tv.athena.revenue.api.IMiddleRevenue
    public IMiddlePayService getMiddlePayService() {
        return this.f68747b;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public d.r.b.a.a.f.f.b getSDKReporter() {
        return null;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void sendHeartBeat(long j, String str) {
        this.f68748c.sendHeartBeat(j, str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(d.r.b.a.a.b bVar) {
        this.f68748c.updateConfig(bVar);
    }
}
