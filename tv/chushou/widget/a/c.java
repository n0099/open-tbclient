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
/* loaded from: classes6.dex */
public class c {
    private static volatile Resources plJ;
    private static SoftReference<tv.chushou.widget.a.a.a> plK;

    public static void d(Resources resources) {
        plJ = resources;
    }

    public static Resources getResources() {
        return plJ;
    }

    public static String getString(@StringRes int i) {
        return plJ.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return plJ.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return plJ.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return plJ.getDrawable(i);
    }

    public static int PG(@DimenRes int i) {
        return plJ.getDimensionPixelSize(i);
    }

    public static int J(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bh(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int Yf(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int Yg(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int etR() {
        return b.C1021b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable etS() {
        if (plK != null && plK.get() != null) {
            return plK.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C1021b.commonres_placeholder_bg));
        plK = new SoftReference<>(aVar);
        return aVar;
    }
}
