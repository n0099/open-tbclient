package d.a.i0.a.z1.a;

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
    public static String f45839f;

    /* renamed from: a  reason: collision with root package name */
    public final b f45840a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45841b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45842c;

    /* renamed from: d  reason: collision with root package name */
    public View f45843d;

    /* renamed from: e  reason: collision with root package name */
    public View f45844e;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f45845a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f45846b;

        /* renamed from: c  reason: collision with root package name */
        public final int f45847c;

        /* renamed from: d  reason: collision with root package name */
        public final int f45848d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f45849e;

        /* renamed from: f  reason: collision with root package name */
        public final float f45850f;

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
            return this.f45847c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.f45849e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.f45848d;
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
            return this.f45845a;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(c.f45839f)) {
                    return false;
                }
                if ("0".equals(c.f45839f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public boolean j() {
            return this.f45846b;
        }

        public boolean k() {
            return this.f45850f >= 600.0f || this.f45849e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f45849e = resources.getConfiguration().orientation == 1;
            this.f45850f = g(activity);
            this.f45845a = b(resources, "status_bar_height");
            a(activity);
            this.f45847c = d(activity);
            this.f45848d = f(activity);
            this.f45846b = this.f45847c > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f45839f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f45839f = null;
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
                this.f45841b = obtainStyledAttributes.getBoolean(0, false);
                this.f45842c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f45841b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f45842c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f45841b, this.f45842c);
        this.f45840a = bVar;
        if (!bVar.j()) {
            this.f45842c = false;
        }
        if (this.f45841b) {
            d(activity, viewGroup);
        }
        if (this.f45842c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        if (this.f45841b) {
            this.f45843d.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f45844e = new View(context);
        if (this.f45840a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f45840a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f45840a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.f45844e.setLayoutParams(layoutParams);
        this.f45844e.setBackgroundColor(-1728053248);
        this.f45844e.setVisibility(8);
        viewGroup.addView(this.f45844e);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        this.f45843d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f45840a.h());
        layoutParams.gravity = 48;
        if (this.f45842c && !this.f45840a.k()) {
            layoutParams.rightMargin = this.f45840a.e();
        }
        this.f45843d.setLayoutParams(layoutParams);
        this.f45843d.setBackgroundColor(-1728053248);
        this.f45843d.setVisibility(8);
        viewGroup.addView(this.f45843d);
    }
}
