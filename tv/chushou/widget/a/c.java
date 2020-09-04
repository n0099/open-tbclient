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
    private static volatile Resources oMN;
    private static SoftReference<tv.chushou.widget.a.a.a> oMO;

    public static void b(Resources resources) {
        oMN = resources;
    }

    public static Resources getResources() {
        return oMN;
    }

    public static String getString(@StringRes int i) {
        return oMN.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return oMN.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return oMN.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return oMN.getDrawable(i);
    }

    public static int Ov(@DimenRes int i) {
        return oMN.getDimensionPixelSize(i);
    }

    public static int H(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float bb(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int WP(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int WQ(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int emi() {
        return b.C1006b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable emj() {
        if (oMO != null && oMO.get() != null) {
            return oMO.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C1006b.commonres_placeholder_bg));
        oMO = new SoftReference<>(aVar);
        return aVar;
    }
}
