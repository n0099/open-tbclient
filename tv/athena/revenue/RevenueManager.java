package tv.athena.revenue;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import d.r.b.a.a.f.d.d;
import i.a.a.f.c;
import java.util.List;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
@Keep
/* loaded from: classes8.dex */
public class RevenueManager implements i.a.a.b.a {
    public final String TAG;
    public i.a.a.b.a revenueService;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final RevenueManager f69548a = new RevenueManager();
    }

    public static RevenueManager instance() {
        return b.f69548a;
    }

    @Override // i.a.a.b.a
    public void addLogDelegate(IRLogDelegate iRLogDelegate) {
        d.b("RevenueManager", "addLogDelegate");
        this.revenueService.addLogDelegate(iRLogDelegate);
    }

    @Override // i.a.a.b.a
    public void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        d.b("RevenueManager", "initRevenue");
        this.revenueService.addRevenueConfig(middleRevenueConfig);
    }

    @Override // i.a.a.b.a
    public List<IRevenue> getAllRevenue() {
        d.b("RevenueManager", "getAllRevenue");
        return this.revenueService.getAllRevenue();
    }

    @Override // i.a.a.b.a
    public IMiddleRevenue getMiddleRevenue(int i2, int i3) {
        d.b("RevenueManager", "getMiddleRevenue");
        return this.revenueService.getMiddleRevenue(i2, i3);
    }

    @Override // i.a.a.b.a
    public IRevenue getRevenue(int i2, int i3) {
        d.b("RevenueManager", "getRevenue");
        return this.revenueService.getRevenue(i2, i3);
    }

    @Override // i.a.a.b.a
    public void removeRevenueConfig(int i2, int i3) {
        this.revenueService.removeRevenueConfig(i2, i3);
    }

    @Override // i.a.a.b.a
    public void subscribeBroadcast(long j, long j2) {
        d.b("RevenueManager", "subscribeBroadcast");
        this.revenueService.subscribeBroadcast(j, j2);
    }

    @Override // i.a.a.b.a
    public void unSubscribeBroadcast(long j, long j2) {
        d.b("RevenueManager", "unSubscribeBroadcast");
        this.revenueService.unSubscribeBroadcast(j, j2);
    }

    @Override // i.a.a.b.a
    public void updateMiddleRevenueConfig(int i2, int i3, Long l, String str) {
        d.b("RevenueManager", "updateMiddleRevenueConfig");
        this.revenueService.updateMiddleRevenueConfig(i2, i3, l, str);
    }

    public RevenueManager() {
        this.TAG = "RevenueManager";
        d.b("RevenueManager", "RevenueManager construct");
        this.revenueService = new c();
    }
}
