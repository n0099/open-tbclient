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
    private static volatile Resources osD;
    private static SoftReference<tv.chushou.widget.a.a.a> osE;

    public static void b(Resources resources) {
        osD = resources;
    }

    public static Resources getResources() {
        return osD;
    }

    public static String getString(@StringRes int i) {
        return osD.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return osD.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return osD.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return osD.getDrawable(i);
    }

    public static int LS(@DimenRes int i) {
        return osD.getDimensionPixelSize(i);
    }

    public static int D(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float aV(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int TL(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int TM(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dZW() {
        return b.C0948b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dZX() {
        if (osE != null && osE.get() != null) {
            return osE.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0948b.commonres_placeholder_bg));
        osE = new SoftReference<>(aVar);
        return aVar;
    }
}
