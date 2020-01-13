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
/* loaded from: classes4.dex */
public class c {
    private static volatile Resources nVm;
    private static SoftReference<tv.chushou.widget.a.a.a> nVn;

    public static void d(Resources resources) {
        nVm = resources;
    }

    public static Resources getResources() {
        return nVm;
    }

    public static String getString(@StringRes int i) {
        return nVm.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nVm.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nVm.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nVm.getDrawable(i);
    }

    public static int Ob(@DimenRes int i) {
        return nVm.getDimensionPixelSize(i);
    }

    public static int S(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bL(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int SC(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int SD(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dOT() {
        return b.C0797b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dOU() {
        if (nVn != null && nVn.get() != null) {
            return nVn.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0797b.commonres_placeholder_bg));
        nVn = new SoftReference<>(aVar);
        return aVar;
    }
}
