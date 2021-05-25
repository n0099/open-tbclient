package d.a.l0.a.v2;

import androidx.annotation.ColorInt;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class i {
    public static boolean a(@ColorInt int i2) {
        return ((int) (((((double) ((16711680 & i2) >> 16)) * 0.299d) + (((double) ((65280 & i2) >> 8)) * 0.587d)) + (((double) (i2 & 255)) * 0.114d))) >= 220;
    }

    public static String b(String str) {
        return V8Engine.toColorRGBA(str);
    }
}
