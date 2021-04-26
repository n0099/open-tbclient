package i.a.a.e.l;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes7.dex */
public class a {
    public static IAppPayService a(int i2, int i3) {
        IRevenue revenue = RevenueManager.instance().getRevenue(i2, i3);
        if (revenue == null) {
            d.r.b.a.a.f.d.d.e("CommonUtils", "getAppPayService null iRevenue", new Object[0]);
            return null;
        }
        return revenue.getAppPayService();
    }
}
