package d.b.i0.c3;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
/* loaded from: classes5.dex */
public class c {
    public static int a(int i, float f2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((i >>> 24) * f2)) << 24);
    }

    public static int b(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        if ((fArr[0] < 0.0f || fArr[0] >= 60.0f) && ((fArr[0] < 120.0f || fArr[0] >= 180.0f) && fArr[0] < 240.0f && fArr[0] >= 300.0f)) {
            fArr[0] = fArr[0] + 15.0f;
        } else {
            fArr[0] = fArr[0] - 15.0f;
        }
        return Color.HSVToColor(fArr);
    }

    public static int c(String str) {
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
