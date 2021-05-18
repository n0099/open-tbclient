package d.a.i0.a.h1.c;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.v2.n0;
/* loaded from: classes3.dex */
public class d {
    public static int a(String str, int i2) {
        long parseLong;
        if (TextUtils.isEmpty(str)) {
            d.a.i0.a.e0.d.l("map", "color string is empty, use default " + Integer.toHexString(i2));
            return i2;
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
            d.a.i0.a.e0.d.l("map", "parse color error, use default " + Integer.toHexString(i2));
            return i2;
        }
    }

    public static float b(double d2) {
        return (float) (d2 * n0.l(AppRuntime.getAppContext()));
    }
}
