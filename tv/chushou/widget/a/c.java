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
    private static volatile Resources qmt;
    private static SoftReference<tv.chushou.widget.a.a.a> qmu;

    public static void d(Resources resources) {
        qmt = resources;
    }

    public static Resources getResources() {
        return qmt;
    }

    public static String getString(@StringRes int i) {
        return qmt.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return qmt.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return qmt.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return qmt.getDrawable(i);
    }

    public static int RS(@DimenRes int i) {
        return qmt.getDimensionPixelSize(i);
    }

    public static int N(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bA(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int aaw(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int aax(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int eHE() {
        return b.C1113b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable eHF() {
        if (qmu != null && qmu.get() != null) {
            return qmu.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C1113b.commonres_placeholder_bg));
        qmu = new SoftReference<>(aVar);
        return aVar;
    }
}
