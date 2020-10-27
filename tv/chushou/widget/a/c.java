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
    private static volatile Resources qcY;
    private static SoftReference<tv.chushou.widget.a.a.a> qcZ;

    public static void d(Resources resources) {
        qcY = resources;
    }

    public static Resources getResources() {
        return qcY;
    }

    public static String getString(@StringRes int i) {
        return qcY.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return qcY.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return qcY.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return qcY.getDrawable(i);
    }

    public static int Rx(@DimenRes int i) {
        return qcY.getDimensionPixelSize(i);
    }

    public static int L(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float by(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int ZS(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int ZT(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int eDP() {
        return b.C1093b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable eDQ() {
        if (qcZ != null && qcZ.get() != null) {
            return qcZ.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C1093b.commonres_placeholder_bg));
        qcZ = new SoftReference<>(aVar);
        return aVar;
    }
}
