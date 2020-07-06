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
    private static volatile Resources ojV;
    private static SoftReference<tv.chushou.widget.a.a.a> ojW;

    public static void b(Resources resources) {
        ojV = resources;
    }

    public static Resources getResources() {
        return ojV;
    }

    public static String getString(@StringRes int i) {
        return ojV.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return ojV.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return ojV.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return ojV.getDrawable(i);
    }

    public static int Ly(@DimenRes int i) {
        return ojV.getDimensionPixelSize(i);
    }

    public static int D(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float aW(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int Ta(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int Tb(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dWz() {
        return b.C0933b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dWA() {
        if (ojW != null && ojW.get() != null) {
            return ojW.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0933b.commonres_placeholder_bg));
        ojW = new SoftReference<>(aVar);
        return aVar;
    }
}
