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
    private static volatile Resources nMU;
    private static SoftReference<tv.chushou.widget.a.a.a> nMV;

    public static void b(Resources resources) {
        nMU = resources;
    }

    public static Resources getResources() {
        return nMU;
    }

    public static String getString(@StringRes int i) {
        return nMU.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nMU.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nMU.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nMU.getDrawable(i);
    }

    public static int Kp(@DimenRes int i) {
        return nMU.getDimensionPixelSize(i);
    }

    public static int B(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float aQ(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int Sm(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int Sn(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dRB() {
        return b.C0912b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dRC() {
        if (nMV != null && nMV.get() != null) {
            return nMV.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0912b.commonres_placeholder_bg));
        nMV = new SoftReference<>(aVar);
        return aVar;
    }
}
