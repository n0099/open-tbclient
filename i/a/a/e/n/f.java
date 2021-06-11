package i.a.a.e.n;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.text.DecimalFormat;
/* loaded from: classes8.dex */
public class f {
    public static String a(double d2) {
        long j = (long) d2;
        if (d2 == ((double) j)) {
            return String.valueOf(j);
        }
        return new DecimalFormat("#.##").format(d2);
    }

    public static double b(String str) {
        if (str == null || str.length() == 0) {
            return 0.0d;
        }
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
            RLog.error("StringUtils", "safeParseDouble " + str, new Object[0]);
            return 0.0d;
        }
    }
}
