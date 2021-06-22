package d.a.m0.a.z1.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
@SuppressLint({"ObsoleteSdkInt"})
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static String f49797f;

    /* renamed from: a  reason: collision with root package name */
    public final b f49798a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49799b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49800c;

    /* renamed from: d  reason: collision with root package name */
    public View f49801d;

    /* renamed from: e  reason: collision with root package name */
    public View f49802e;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f49803a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f49804b;

        /* renamed from: c  reason: collision with root package name */
        public final int f49805c;

        /* renamed from: d  reason: collision with root package name */
        public final int f49806d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f49807e;

        /* renamed from: f  reason: collision with root package name */
        public final float f49808f;

        @TargetApi(14)
        public final int a(Context context) {
            if (Build.VERSION.SDK_INT >= 14) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16843499, typedValue, true);
                return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
            return 0;
        }

        public final int b(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int c() {
            return this.f49805c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.f49807e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.f49806d;
        }

        @TargetApi(14)
        public final int f(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        @SuppressLint({"NewApi"})
        public final float g(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f2 = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f2, displayMetrics.heightPixels / f2);
        }

        public int h() {
            return this.f49803a;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(c.f49797f)) {
                    return false;
                }
                if ("0".equals(c.f49797f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean j() {
            return this.f49804b;
        }

        public boolean k() {
            return this.f49808f >= 600.0f || this.f49807e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f49807e = resources.getConfiguration().orientation == 1;
            this.f49808f = g(activity);
            this.f49803a = b(resources, "status_bar_height");
            a(activity);
            this.f49805c = d(activity);
            this.f49806d = f(activity);
            this.f49804b = this.f49805c > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f49797f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f49797f = null;
            }
        }
    }

    @TargetApi(19)
    public c(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f49799b = obtainStyledAttributes.getBoolean(0, false);
                this.f49800c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f49799b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f49800c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f49799b, this.f49800c);
        this.f49798a = bVar;
        if (!bVar.j()) {
            this.f49800c = false;
        }
        if (this.f49799b) {
            d(activity, viewGroup);
        }
        if (this.f49800c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.f49799b) {
            this.f49801d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f49802e = new View(context);
        if (this.f49798a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f49798a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f49798a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.f49802e.setLayoutParams(layoutParams);
        this.f49802e.setBackgroundColor(-1728053248);
        this.f49802e.setVisibility(8);
        viewGroup.addView(this.f49802e);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        this.f49801d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f49798a.h());
        layoutParams.gravity = 48;
        if (this.f49800c && !this.f49798a.k()) {
            layoutParams.rightMargin = this.f49798a.e();
        }
        this.f49801d.setLayoutParams(layoutParams);
        this.f49801d.setBackgroundColor(-1728053248);
        this.f49801d.setVisibility(8);
        viewGroup.addView(this.f49801d);
    }
}
