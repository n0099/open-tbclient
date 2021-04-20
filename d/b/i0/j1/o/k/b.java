package d.b.i0.j1.o.k;

import android.graphics.Color;
/* loaded from: classes4.dex */
public class b {
    public static boolean a(int i) {
        return i == Integer.MAX_VALUE;
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
