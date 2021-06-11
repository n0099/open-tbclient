package i.a.a.e.n;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes8.dex */
public class a {
    public static IAppPayService a(int i2, int i3) {
        IRevenue revenue = RevenueManager.instance().getRevenue(i2, i3);
        if (revenue == null) {
            RLog.error("CommonUtils", "getAppPayService null iRevenue", new Object[0]);
            return null;
        }
        return revenue.getAppPayService();
    }
}
