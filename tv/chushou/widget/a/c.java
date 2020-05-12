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
    private static volatile Resources nrX;
    private static SoftReference<tv.chushou.widget.a.a.a> nrY;

    public static void b(Resources resources) {
        nrX = resources;
    }

    public static Resources getResources() {
        return nrX;
    }

    public static String getString(@StringRes int i) {
        return nrX.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nrX.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nrX.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nrX.getDrawable(i);
    }

    public static int JE(@DimenRes int i) {
        return nrX.getDimensionPixelSize(i);
    }

    public static int C(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float aR(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int Qg(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int Qh(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dJH() {
        return b.C0850b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dJI() {
        if (nrY != null && nrY.get() != null) {
            return nrY.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0850b.commonres_placeholder_bg));
        nrY = new SoftReference<>(aVar);
        return aVar;
    }
}
