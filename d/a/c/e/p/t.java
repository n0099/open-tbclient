package d.a.c.e.p;

import android.graphics.Paint;
/* loaded from: classes.dex */
public class t {
    public static int a(float f2, Paint paint, String str, int i2) {
        if (f2 == 0.0f || i2 == 0 || str == null || str.isEmpty()) {
            return 0;
        }
        return Math.min((int) Math.ceil(paint.measureText(str) / f2), i2);
    }

    public static boolean b(float f2, Paint paint, String str, int i2) {
        float measureText;
        float f3 = 0.0f;
        if (f2 != 0.0f && i2 != 0 && str != null && !str.isEmpty() && paint != null) {
            if (!str.contains("\n")) {
                return paint.measureText(str) >= f2 * ((float) i2);
            }
            String[] split = str.split("\n");
            if (split.length > i2) {
                return true;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2 && split.length > i4; i4++) {
                if (i4 < i2 - 1) {
                    measureText = paint.measureText(split[i4]);
                    int ceil = (int) Math.ceil(measureText / f2);
                    i3 += ceil;
                    if (i3 < 5) {
                        measureText = ceil * f2;
                    }
                } else {
                    measureText = paint.measureText(split[i4]);
                    i3++;
                }
                f3 += measureText;
                if (i3 >= 5) {
                    return f3 >= f2 * ((float) i2);
                }
            }
        }
        return false;
    }
}
