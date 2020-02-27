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
    private static volatile Resources nWg;
    private static SoftReference<tv.chushou.widget.a.a.a> nWh;

    public static void d(Resources resources) {
        nWg = resources;
    }

    public static Resources getResources() {
        return nWg;
    }

    public static String getString(@StringRes int i) {
        return nWg.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nWg.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nWg.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nWg.getDrawable(i);
    }

    public static int Oe(@DimenRes int i) {
        return nWg.getDimensionPixelSize(i);
    }

    public static int S(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bK(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int SN(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int SO(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dQi() {
        return b.C0805b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dQj() {
        if (nWh != null && nWh.get() != null) {
            return nWh.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0805b.commonres_placeholder_bg));
        nWh = new SoftReference<>(aVar);
        return aVar;
    }
}
