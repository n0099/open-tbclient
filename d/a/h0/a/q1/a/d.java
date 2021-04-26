package d.a.h0.a.q1.a;

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
    public static String f43584f;

    /* renamed from: a  reason: collision with root package name */
    public final b f43585a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43586b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43587c;

    /* renamed from: d  reason: collision with root package name */
    public View f43588d;

    /* renamed from: e  reason: collision with root package name */
    public View f43589e;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f43590a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f43591b;

        /* renamed from: c  reason: collision with root package name */
        public final int f43592c;

        /* renamed from: d  reason: collision with root package name */
        public final int f43593d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f43594e;

        /* renamed from: f  reason: collision with root package name */
        public final float f43595f;

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
            return this.f43592c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.f43594e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.f43593d;
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
            return this.f43590a;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.f43584f)) {
                    return false;
                }
                if ("0".equals(d.f43584f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean j() {
            return this.f43591b;
        }

        public boolean k() {
            return this.f43595f >= 600.0f || this.f43594e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f43594e = resources.getConfiguration().orientation == 1;
            this.f43595f = g(activity);
            this.f43590a = b(resources, "status_bar_height");
            a(activity);
            this.f43592c = d(activity);
            this.f43593d = f(activity);
            this.f43591b = this.f43592c > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f43584f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f43584f = null;
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
                this.f43586b = obtainStyledAttributes.getBoolean(0, false);
                this.f43587c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f43586b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f43587c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f43586b, this.f43587c);
        this.f43585a = bVar;
        if (!bVar.j()) {
            this.f43587c = false;
        }
        if (this.f43586b) {
            d(activity, viewGroup);
        }
        if (this.f43587c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.f43586b) {
            this.f43588d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f43589e = new View(context);
        if (this.f43585a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f43585a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f43585a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.f43589e.setLayoutParams(layoutParams);
        this.f43589e.setBackgroundColor(-1728053248);
        this.f43589e.setVisibility(8);
        viewGroup.addView(this.f43589e);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        this.f43588d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f43585a.h());
        layoutParams.gravity = 48;
        if (this.f43587c && !this.f43585a.k()) {
            layoutParams.rightMargin = this.f43585a.e();
        }
        this.f43588d.setLayoutParams(layoutParams);
        this.f43588d.setBackgroundColor(-1728053248);
        this.f43588d.setVisibility(8);
        viewGroup.addView(this.f43588d);
    }
}
