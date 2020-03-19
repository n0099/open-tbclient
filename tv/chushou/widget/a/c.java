package tv.chushou.widget.a;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.TypedValue;
import java.lang.ref.SoftReference;
import tv.chushou.widget.a.b;
/* loaded from: classes5.dex */
public class c {
    private static volatile Resources nYg;
    private static SoftReference<tv.chushou.widget.a.a.a> nYh;

    public static void d(Resources resources) {
        nYg = resources;
    }

    public static Resources getResources() {
        return nYg;
    }

    public static String getString(@StringRes int i) {
        return nYg.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nYg.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nYg.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nYg.getDrawable(i);
    }

    public static int Ok(@DimenRes int i) {
        return nYg.getDimensionPixelSize(i);
    }

    public static int S(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bK(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int SO(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int SP(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dQL() {
        return b.C0806b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dQM() {
        if (nYh != null && nYh.get() != null) {
            return nYh.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0806b.commonres_placeholder_bg));
        nYh = new SoftReference<>(aVar);
        return aVar;
    }
}
