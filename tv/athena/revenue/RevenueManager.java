package tv.athena.revenue;

import androidx.annotation.Keep;
import com.baidu.tieba.pbc;
import com.baidu.tieba.qbc;
import com.baidu.tieba.rgc;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.List;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
@Keep
/* loaded from: classes2.dex */
public class RevenueManager implements pbc {
    public final String TAG;
    public pbc revenueService;

    /* loaded from: classes2.dex */
    public static class b {
        public static final RevenueManager a = new RevenueManager();
    }

    public RevenueManager() {
        this.TAG = "RevenueManager";
        RLog.info("RevenueManager", "create RevenueManager");
        this.revenueService = new rgc();
    }

    public static RevenueManager instance() {
        return b.a;
    }

    @Override // com.baidu.tieba.pbc
    public List<IRevenue> getAllRevenue() {
        RLog.debug("RevenueManager", "getAllRevenue");
        return this.revenueService.getAllRevenue();
    }

    @Override // com.baidu.tieba.pbc
    public void addLogDelegate(IRLogDelegate iRLogDelegate) {
        RLog.info("RevenueManager", "addLogDelegate");
        this.revenueService.addLogDelegate(iRLogDelegate);
    }

    @Override // com.baidu.tieba.pbc
    public void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        String str;
        if (middleRevenueConfig != null) {
            str = middleRevenueConfig.toString();
        } else {
            str = "config null";
        }
        RLog.info("RevenueManager", "addRevenueConfig config:" + str);
        this.revenueService.addRevenueConfig(middleRevenueConfig);
    }

    @Override // com.baidu.tieba.pbc
    public IMiddleRevenue getMiddleRevenue(int i, int i2) {
        RLog.debug("RevenueManager", "getMiddleRevenue");
        return this.revenueService.getMiddleRevenue(i, i2);
    }

    @Override // com.baidu.tieba.pbc
    public IRevenue getRevenue(int i, int i2) {
        return this.revenueService.getRevenue(i, i2);
    }

    @Override // com.baidu.tieba.pbc
    public qbc getYYPayMiddleService(int i, int i2) {
        return this.revenueService.getYYPayMiddleService(i, i2);
    }

    @Override // com.baidu.tieba.pbc
    public void removeRevenueConfig(int i, int i2) {
        RLog.info("RevenueManager", "removeRevenueConfig appId=" + i + " useChannel=" + i2);
        this.revenueService.removeRevenueConfig(i, i2);
    }

    @Override // com.baidu.tieba.pbc
    public void updateMiddleRevenueConfig(int i, int i2, Long l, String str) {
        RLog.info("RevenueManager", "updateMiddleRevenueConfig");
        this.revenueService.updateMiddleRevenueConfig(i, i2, l, str);
    }
}
