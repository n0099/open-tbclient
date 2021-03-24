package d.b.g0.a.a1.c;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.i2.h0;
/* loaded from: classes3.dex */
public class d {
    public static int a(String str, int i) {
        long parseLong;
        if (TextUtils.isEmpty(str)) {
            d.b.g0.a.c0.c.l("map", "color string is empty, use default " + Integer.toHexString(i));
            return i;
        }
        try {
            if (str.charAt(0) == '#') {
                String substring = str.substring(1);
                if (substring.length() != 6 && substring.length() != 8) {
                    throw new IllegalArgumentException("char count not right");
                }
                if (substring.length() == 6) {
                    parseLong = Long.parseLong(substring, 16) | (-16777216);
                } else {
                    parseLong = Long.parseLong(substring.substring(6) + substring.substring(0, 6), 16);
                }
                return (int) parseLong;
            }
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            d.b.g0.a.c0.c.l("map", "parse color error, use default " + Integer.toHexString(i));
            return i;
        }
    }

    public static float b(double d2) {
        double j = h0.j(AppRuntime.getAppContext());
        Double.isNaN(j);
        return (float) (d2 * j);
    }
}
