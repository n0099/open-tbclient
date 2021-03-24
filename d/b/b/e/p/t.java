package d.b.b.e.p;

import android.graphics.Paint;
/* loaded from: classes.dex */
public class t {
    public static int a(float f2, Paint paint, String str, int i) {
        if (f2 == 0.0f || i == 0 || str == null || str.isEmpty()) {
            return 0;
        }
        return Math.min((int) Math.ceil(paint.measureText(str) / f2), i);
    }

    public static boolean b(float f2, Paint paint, String str, int i) {
        float measureText;
        float f3 = 0.0f;
        if (f2 != 0.0f && i != 0 && str != null && !str.isEmpty() && paint != null) {
            if (!str.contains("\n")) {
                return paint.measureText(str) >= f2 * ((float) i);
            }
            String[] split = str.split("\n");
            if (split.length > i) {
                return true;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < i && split.length > i3; i3++) {
                if (i3 < i - 1) {
                    measureText = paint.measureText(split[i3]);
                    int ceil = (int) Math.ceil(measureText / f2);
                    i2 += ceil;
                    if (i2 < 5) {
                        measureText = ceil * f2;
                    }
                } else {
                    measureText = paint.measureText(split[i3]);
                    i2++;
                }
                f3 += measureText;
                if (i2 >= 5) {
                    return f3 >= f2 * ((float) i);
                }
            }
        }
        return false;
    }
}
