package tv.athena.revenue;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
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
        public static final RevenueManager f72902a = new RevenueManager();
    }

    public static RevenueManager instance() {
        return b.f72902a;
    }

    @Override // i.a.a.b.a
    public void addLogDelegate(IRLogDelegate iRLogDelegate) {
        RLog.info("RevenueManager", "addLogDelegate");
        this.revenueService.addLogDelegate(iRLogDelegate);
    }

    @Override // i.a.a.b.a
    public void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        String middleRevenueConfig2 = middleRevenueConfig != null ? middleRevenueConfig.toString() : "config null";
        RLog.info("RevenueManager", "addRevenueConfig config:" + middleRevenueConfig2);
        this.revenueService.addRevenueConfig(middleRevenueConfig);
    }

    @Override // i.a.a.b.a
    public List<IRevenue> getAllRevenue() {
        RLog.debug("RevenueManager", "getAllRevenue");
        return this.revenueService.getAllRevenue();
    }

    @Override // i.a.a.b.a
    public IMiddleRevenue getMiddleRevenue(int i2, int i3) {
        RLog.debug("RevenueManager", "getMiddleRevenue");
        return this.revenueService.getMiddleRevenue(i2, i3);
    }

    @Override // i.a.a.b.a
    public IRevenue getRevenue(int i2, int i3) {
        RLog.debug("RevenueManager", "getRevenue");
        return this.revenueService.getRevenue(i2, i3);
    }

    @Override // i.a.a.b.a
    public void removeRevenueConfig(int i2, int i3) {
        RLog.info("RevenueManager", "removeRevenueConfig appId=" + i2 + " useChannel=" + i3);
        this.revenueService.removeRevenueConfig(i2, i3);
    }

    @Override // i.a.a.b.a
    public void updateMiddleRevenueConfig(int i2, int i3, Long l, String str) {
        RLog.info("RevenueManager", "updateMiddleRevenueConfig");
        this.revenueService.updateMiddleRevenueConfig(i2, i3, l, str);
    }

    public RevenueManager() {
        this.TAG = "RevenueManager";
        RLog.info("RevenueManager", "RevenueManager construct");
        this.revenueService = new i.a.a.f.b();
    }
}
