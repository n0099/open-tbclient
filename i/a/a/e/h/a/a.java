package i.a.a.e.h.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f68069a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68070b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f68071c;

    /* renamed from: d  reason: collision with root package name */
    public final int f68072d;

    /* renamed from: e  reason: collision with root package name */
    public final int f68073e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f68074f;

    /* renamed from: g  reason: collision with root package name */
    public final float f68075g;

    public a(Activity activity) {
        Resources resources = activity.getResources();
        this.f68074f = resources.getConfiguration().orientation == 1;
        this.f68075g = h(activity);
        this.f68069a = c(resources, "status_bar_height");
        this.f68070b = b(activity);
        this.f68072d = e(activity);
        this.f68073e = g(activity);
        this.f68071c = this.f68072d > 0;
    }

    @TargetApi(14)
    public static boolean j(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i3 - displayMetrics2.widthPixels > 0 || i2 - displayMetrics2.heightPixels > 0;
    }

    public int a() {
        return this.f68070b;
    }

    @TargetApi(14)
    public final int b(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public final int c(Resources resources, String str) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            int parseInt = Integer.parseInt(cls.getField(str).get(cls.newInstance()).toString());
            if (parseInt > 0) {
                return resources.getDimensionPixelSize(parseInt);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int d() {
        return this.f68072d;
    }

    @TargetApi(14)
    public final int e(Context context) {
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT < 14 || !j((Activity) context)) {
            return 0;
        }
        return c(resources, this.f68074f ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    public int f() {
        return this.f68073e;
    }

    @TargetApi(14)
    public final int g(Context context) {
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT < 14 || !j((Activity) context)) {
            return 0;
        }
        return c(resources, "navigation_bar_width");
    }

    @SuppressLint({"NewApi"})
    public final float h(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        float f2 = displayMetrics.density;
        return Math.min(displayMetrics.widthPixels / f2, displayMetrics.heightPixels / f2);
    }

    public int i() {
        return this.f68069a;
    }

    public boolean k() {
        return this.f68071c;
    }

    public boolean l() {
        return this.f68075g >= 600.0f || this.f68074f;
    }
}
