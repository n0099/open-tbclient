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
    private static volatile Resources qnW;
    private static SoftReference<tv.chushou.widget.a.a.a> qnX;

    public static void d(Resources resources) {
        qnW = resources;
    }

    public static Resources getResources() {
        return qnW;
    }

    public static String getString(@StringRes int i) {
        return qnW.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return qnW.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return qnW.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return qnW.getDrawable(i);
    }

    public static int oG(@DimenRes int i) {
        return qnW.getDimensionPixelSize(i);
    }

    public static int M(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bI(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int aah(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int aai(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int eHF() {
        return b.C1116b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable eHG() {
        if (qnX != null && qnX.get() != null) {
            return qnX.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C1116b.commonres_placeholder_bg));
        qnX = new SoftReference<>(aVar);
        return aVar;
    }
}
