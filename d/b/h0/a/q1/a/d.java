package d.b.h0.a.q1.a;

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
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static String f46235f;

    /* renamed from: a  reason: collision with root package name */
    public final b f46236a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46237b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46238c;

    /* renamed from: d  reason: collision with root package name */
    public View f46239d;

    /* renamed from: e  reason: collision with root package name */
    public View f46240e;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f46241a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f46242b;

        /* renamed from: c  reason: collision with root package name */
        public final int f46243c;

        /* renamed from: d  reason: collision with root package name */
        public final int f46244d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f46245e;

        /* renamed from: f  reason: collision with root package name */
        public final float f46246f;

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
            return this.f46243c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.f46245e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.f46244d;
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
            return this.f46241a;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.f46235f)) {
                    return false;
                }
                if ("0".equals(d.f46235f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean j() {
            return this.f46242b;
        }

        public boolean k() {
            return this.f46246f >= 600.0f || this.f46245e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f46245e = resources.getConfiguration().orientation == 1;
            this.f46246f = g(activity);
            this.f46241a = b(resources, "status_bar_height");
            a(activity);
            this.f46243c = d(activity);
            this.f46244d = f(activity);
            this.f46242b = this.f46243c > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f46235f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f46235f = null;
            }
        }
    }

    @TargetApi(19)
    public d(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f46237b = obtainStyledAttributes.getBoolean(0, false);
                this.f46238c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f46237b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f46238c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f46237b, this.f46238c);
        this.f46236a = bVar;
        if (!bVar.j()) {
            this.f46238c = false;
        }
        if (this.f46237b) {
            d(activity, viewGroup);
        }
        if (this.f46238c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.f46237b) {
            this.f46239d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f46240e = new View(context);
        if (this.f46236a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f46236a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f46236a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.f46240e.setLayoutParams(layoutParams);
        this.f46240e.setBackgroundColor(-1728053248);
        this.f46240e.setVisibility(8);
        viewGroup.addView(this.f46240e);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        this.f46239d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f46236a.h());
        layoutParams.gravity = 48;
        if (this.f46238c && !this.f46236a.k()) {
            layoutParams.rightMargin = this.f46236a.e();
        }
        this.f46239d.setLayoutParams(layoutParams);
        this.f46239d.setBackgroundColor(-1728053248);
        this.f46239d.setVisibility(8);
        viewGroup.addView(this.f46239d);
    }
}
