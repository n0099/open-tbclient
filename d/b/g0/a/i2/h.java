package d.b.g0.a.i2;

import androidx.annotation.ColorInt;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class h {
    public static boolean a(@ColorInt int i) {
        double d2 = (16711680 & i) >> 16;
        Double.isNaN(d2);
        double d3 = (65280 & i) >> 8;
        Double.isNaN(d3);
        double d4 = (d2 * 0.299d) + (d3 * 0.587d);
        double d5 = i & 255;
        Double.isNaN(d5);
        return ((int) (d4 + (d5 * 0.114d))) >= 220;
    }

    public static String b(String str) {
        return V8Engine.toColorRGBA(str);
    }
}
