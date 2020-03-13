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
    private static volatile Resources nWt;
    private static SoftReference<tv.chushou.widget.a.a.a> nWu;

    public static void d(Resources resources) {
        nWt = resources;
    }

    public static Resources getResources() {
        return nWt;
    }

    public static String getString(@StringRes int i) {
        return nWt.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nWt.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nWt.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nWt.getDrawable(i);
    }

    public static int Oe(@DimenRes int i) {
        return nWt.getDimensionPixelSize(i);
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
    public static int dQl() {
        return b.C0805b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dQm() {
        if (nWu != null && nWu.get() != null) {
            return nWu.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0805b.commonres_placeholder_bg));
        nWu = new SoftReference<>(aVar);
        return aVar;
    }
}
