package d.b.g0.a.q1.a;

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
/* loaded from: classes2.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static String f45514f;

    /* renamed from: a  reason: collision with root package name */
    public final b f45515a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45516b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45517c;

    /* renamed from: d  reason: collision with root package name */
    public View f45518d;

    /* renamed from: e  reason: collision with root package name */
    public View f45519e;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f45520a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f45521b;

        /* renamed from: c  reason: collision with root package name */
        public final int f45522c;

        /* renamed from: d  reason: collision with root package name */
        public final int f45523d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f45524e;

        /* renamed from: f  reason: collision with root package name */
        public final float f45525f;

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
            return this.f45522c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.f45524e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.f45523d;
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
            return this.f45520a;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.f45514f)) {
                    return false;
                }
                if ("0".equals(d.f45514f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean j() {
            return this.f45521b;
        }

        public boolean k() {
            return this.f45525f >= 600.0f || this.f45524e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f45524e = resources.getConfiguration().orientation == 1;
            this.f45525f = g(activity);
            this.f45520a = b(resources, "status_bar_height");
            a(activity);
            this.f45522c = d(activity);
            this.f45523d = f(activity);
            this.f45521b = this.f45522c > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f45514f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f45514f = null;
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
                this.f45516b = obtainStyledAttributes.getBoolean(0, false);
                this.f45517c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f45516b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f45517c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f45516b, this.f45517c);
        this.f45515a = bVar;
        if (!bVar.j()) {
            this.f45517c = false;
        }
        if (this.f45516b) {
            d(activity, viewGroup);
        }
        if (this.f45517c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.f45516b) {
            this.f45518d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f45519e = new View(context);
        if (this.f45515a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f45515a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f45515a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.f45519e.setLayoutParams(layoutParams);
        this.f45519e.setBackgroundColor(-1728053248);
        this.f45519e.setVisibility(8);
        viewGroup.addView(this.f45519e);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        this.f45518d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f45515a.h());
        layoutParams.gravity = 48;
        if (this.f45517c && !this.f45515a.k()) {
            layoutParams.rightMargin = this.f45515a.e();
        }
        this.f45518d.setLayoutParams(layoutParams);
        this.f45518d.setBackgroundColor(-1728053248);
        this.f45518d.setVisibility(8);
        viewGroup.addView(this.f45518d);
    }
}
