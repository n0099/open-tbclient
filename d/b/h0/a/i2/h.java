package d.b.h0.a.i2;

import androidx.annotation.ColorInt;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class h {
    public static boolean a(@ColorInt int i) {
        return ((int) (((((double) ((16711680 & i) >> 16)) * 0.299d) + (((double) ((65280 & i) >> 8)) * 0.587d)) + (((double) (i & 255)) * 0.114d))) >= 220;
    }

    public static String b(String str) {
        return V8Engine.toColorRGBA(str);
    }
}
