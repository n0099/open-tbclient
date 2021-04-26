package i.a.a.e.k;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.f.f.b;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes7.dex */
public class a {
    public static b a(int i2, int i3) {
        IRevenue revenue = RevenueManager.instance().getRevenue(i2, i3);
        if (revenue == null) {
            d.e("UIStatisticReporter", "getSDKReporter error revenue null", new Object[0]);
            return null;
        }
        return revenue.getSDKReporter();
    }

    public static void b(int i2, int i3, String str) {
        b a2 = a(i2, i3);
        if (a2 == null) {
            d.e("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
        } else {
            a2.c(str);
        }
    }

    public static void c(int i2, int i3, String str, String str2) {
        b a2 = a(i2, i3);
        if (a2 == null) {
            d.e("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
        } else {
            a2.a(str, str2);
        }
    }
}
