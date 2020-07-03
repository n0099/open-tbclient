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
    private static volatile Resources ojS;
    private static SoftReference<tv.chushou.widget.a.a.a> ojT;

    public static void b(Resources resources) {
        ojS = resources;
    }

    public static Resources getResources() {
        return ojS;
    }

    public static String getString(@StringRes int i) {
        return ojS.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return ojS.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return ojS.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return ojS.getDrawable(i);
    }

    public static int Ly(@DimenRes int i) {
        return ojS.getDimensionPixelSize(i);
    }

    public static int D(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float aW(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int SZ(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int Ta(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dWv() {
        return b.C0932b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dWw() {
        if (ojT != null && ojT.get() != null) {
            return ojT.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0932b.commonres_placeholder_bg));
        ojT = new SoftReference<>(aVar);
        return aVar;
    }
}
