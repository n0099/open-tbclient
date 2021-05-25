package d.a.l0.a.z1.a;

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
    public static String f46015f;

    /* renamed from: a  reason: collision with root package name */
    public final b f46016a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46017b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46018c;

    /* renamed from: d  reason: collision with root package name */
    public View f46019d;

    /* renamed from: e  reason: collision with root package name */
    public View f46020e;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f46021a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f46022b;

        /* renamed from: c  reason: collision with root package name */
        public final int f46023c;

        /* renamed from: d  reason: collision with root package name */
        public final int f46024d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f46025e;

        /* renamed from: f  reason: collision with root package name */
        public final float f46026f;

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
            return this.f46023c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.f46025e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.f46024d;
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
            return this.f46021a;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(c.f46015f)) {
                    return false;
                }
                if ("0".equals(c.f46015f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean j() {
            return this.f46022b;
        }

        public boolean k() {
            return this.f46026f >= 600.0f || this.f46025e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f46025e = resources.getConfiguration().orientation == 1;
            this.f46026f = g(activity);
            this.f46021a = b(resources, "status_bar_height");
            a(activity);
            this.f46023c = d(activity);
            this.f46024d = f(activity);
            this.f46022b = this.f46023c > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f46015f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f46015f = null;
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
                this.f46017b = obtainStyledAttributes.getBoolean(0, false);
                this.f46018c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f46017b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f46018c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f46017b, this.f46018c);
        this.f46016a = bVar;
        if (!bVar.j()) {
            this.f46018c = false;
        }
        if (this.f46017b) {
            d(activity, viewGroup);
        }
        if (this.f46018c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.f46017b) {
            this.f46019d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f46020e = new View(context);
        if (this.f46016a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f46016a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f46016a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.f46020e.setLayoutParams(layoutParams);
        this.f46020e.setBackgroundColor(-1728053248);
        this.f46020e.setVisibility(8);
        viewGroup.addView(this.f46020e);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        this.f46019d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f46016a.h());
        layoutParams.gravity = 48;
        if (this.f46018c && !this.f46016a.k()) {
            layoutParams.rightMargin = this.f46016a.e();
        }
        this.f46019d.setLayoutParams(layoutParams);
        this.f46019d.setBackgroundColor(-1728053248);
        this.f46019d.setVisibility(8);
        viewGroup.addView(this.f46019d);
    }
}
