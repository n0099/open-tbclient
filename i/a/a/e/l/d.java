package i.a.a.e.l;

import java.math.RoundingMode;
import java.text.DecimalFormat;
/* loaded from: classes8.dex */
public class d {
    public static String a(double d2) {
        long j = (long) d2;
        if (d2 == ((double) j)) {
            return String.valueOf(j);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(d2);
    }

    public static double b(String str) {
        if (str == null || str.length() == 0) {
            return 0.0d;
        }
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
            d.r.b.a.a.f.d.d.e("StringUtils", "safeParseDouble " + str, new Object[0]);
            return 0.0d;
        }
    }
}
