package i.a.a.e.m;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes8.dex */
public class a {
    public static ISDKReporter a(int i2, int i3) {
        IRevenue revenue = RevenueManager.instance().getRevenue(i2, i3);
        if (revenue == null) {
            RLog.error("UIStatisticReporter", "getSDKReporter error revenue null", new Object[0]);
            return null;
        }
        return revenue.getSDKReporter();
    }

    public static void b(int i2, int i3, String str) {
        ISDKReporter a2 = a(i2, i3);
        if (a2 == null) {
            RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
        } else {
            a2.reportUiEvent(str);
        }
    }

    public static void c(int i2, int i3, String str, String str2) {
        ISDKReporter a2 = a(i2, i3);
        if (a2 == null) {
            RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
        } else {
            a2.reportUiEvent(str, str2);
        }
    }

    public static void d(int i2, int i3, String str, String str2, String str3, String str4) {
        ISDKReporter a2 = a(i2, i3);
        if (a2 == null) {
            RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
        } else {
            a2.reportUvEvent(str, str2, str3, str4);
        }
    }
}
