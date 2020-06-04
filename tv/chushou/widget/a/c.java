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
    private static volatile Resources nOe;
    private static SoftReference<tv.chushou.widget.a.a.a> nOf;

    public static void b(Resources resources) {
        nOe = resources;
    }

    public static Resources getResources() {
        return nOe;
    }

    public static String getString(@StringRes int i) {
        return nOe.getString(i);
    }

    public static String getString(@StringRes int i, Object... objArr) {
        return nOe.getString(i, objArr);
    }

    public static int getColor(@ColorRes int i) {
        return nOe.getColor(i);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return nOe.getDrawable(i);
    }

    public static int Kr(@DimenRes int i) {
        return nOe.getDimensionPixelSize(i);
    }

    public static int B(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float aQ(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @DrawableRes
    public static int Sn(String str) {
        return "female".equals(str) ? b.c.commonres_female_big : b.c.commonres_male_big;
    }

    @DrawableRes
    public static int So(String str) {
        return "female".equals(str) ? b.c.commonres_female_no_border : b.c.commonres_male_no_border;
    }

    @DrawableRes
    public static int dRP() {
        return b.C0913b.commonres_placeholder_bg;
    }

    @NonNull
    public static Drawable dRQ() {
        if (nOf != null && nOf.get() != null) {
            return nOf.get().getConstantState().newDrawable();
        }
        tv.chushou.widget.a.a.a aVar = new tv.chushou.widget.a.a.a(BitmapFactory.decodeResource(getResources(), b.c.commonres_placeholder_icon), getColor(b.C0913b.commonres_placeholder_bg));
        nOf = new SoftReference<>(aVar);
        return aVar;
    }
}
