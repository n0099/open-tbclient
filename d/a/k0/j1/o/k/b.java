package d.a.k0.j1.o.k;

import android.graphics.Color;
/* loaded from: classes4.dex */
public class b {
    public static boolean a(int i2) {
        return i2 == Integer.MAX_VALUE;
    }

    public static int b(String str) {
        if (str != null) {
            if (str.length() != 0) {
                try {
                    if (!str.startsWith("#")) {
                        str = "#" + str;
                    }
                } catch (Exception unused) {
                    return Integer.MAX_VALUE;
                }
            }
            return Color.parseColor(str);
        }
        return Integer.MAX_VALUE;
    }
}
