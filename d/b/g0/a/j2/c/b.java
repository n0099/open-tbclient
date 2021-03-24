package d.b.g0.a.j2.c;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.protobuf.CodedInputStream;
import d.b.g0.a.c;
import d.b.g0.a.f;
import d.b.g0.a.i2.h0;
import d.b.g0.a.j2.c.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class b {
    public static final boolean i = j();
    public static int j;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Activity f44979a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f44980b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public View f44981c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public View f44982d;

    /* renamed from: e  reason: collision with root package name */
    public int f44983e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44984f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.j2.c.a f44985g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnSystemUiVisibilityChangeListener f44986h;

    /* loaded from: classes3.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
        }
    }

    static {
        j = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            j = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            j = 2;
        }
    }

    public b(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public static int a(int i2, int i3) {
        if (i3 == 0) {
            return i2;
        }
        float f2 = 1.0f - (i3 / 255.0f);
        double d2 = ((i2 >> 16) & 255) * f2;
        Double.isNaN(d2);
        int i4 = (int) (d2 + 0.5d);
        double d3 = ((i2 >> 8) & 255) * f2;
        Double.isNaN(d3);
        double d4 = (i2 & 255) * f2;
        Double.isNaN(d4);
        return ((int) (d4 + 0.5d)) | (i4 << 16) | (-16777216) | (((int) (d3 + 0.5d)) << 8);
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public final d.b.g0.a.j2.c.a b(int i2, int i3, boolean z, boolean z2, boolean z3) {
        a.b b2 = a.b.b();
        b2.i(z);
        b2.h(true);
        b2.g(false);
        b2.f(i3);
        b2.e(i2);
        b2.c(z2);
        b2.d(z3);
        return b2.a();
    }

    public final void c() {
        int f2 = f();
        this.f44985g = b(f2, g(f2), false, false, true);
    }

    @NonNull
    public d.b.g0.a.j2.c.a d() {
        if (this.f44985g == null) {
            c();
        }
        return this.f44985g;
    }

    @Nullable
    public View e() {
        return this.f44982d;
    }

    public final int f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f44979a.getResources().getColor(c.aiapps_statusbar_immersion_bg);
        }
        return this.f44979a.getResources().getColor(c.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    public final int g(int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return a(i2, 45);
    }

    public final View h(@NonNull d.b.g0.a.j2.c.a aVar) {
        if (aVar.f44971g) {
            View view = this.f44982d;
            if (view != null) {
                if (aVar.f44969e) {
                    return view;
                }
                this.f44980b.removeView(view);
                this.f44982d = null;
                return null;
            } else if (!aVar.f44969e) {
                this.f44982d = null;
                return null;
            } else {
                int s = h0.s();
                View view2 = new View(this.f44979a);
                view2.setTag("IMMERSION_VIEW");
                view2.setId(f.immersion_custom_statusbar_view);
                this.f44980b.addView(view2, new ViewGroup.LayoutParams(-1, s));
                this.f44982d = view2;
                return view2;
            }
        }
        return null;
    }

    public boolean i() {
        return this.f44984f;
    }

    public void k() {
        this.f44985g = null;
        this.f44983e = 1;
    }

    public void l() {
        o(d());
    }

    public void m(int i2, boolean z, boolean z2) {
        n(i2, z, true, z2);
    }

    public void n(int i2, boolean z, boolean z2, boolean z3) {
        d.b.g0.a.j2.c.a b2;
        if (i) {
            if (i2 == 1) {
                if (this.f44983e != 1) {
                    k();
                }
                this.f44983e = i2;
                b2 = d();
            } else {
                this.f44983e = i2;
                b2 = b(i2, g(i2), z3, z, z2);
                this.f44985g = b2;
            }
            this.f44984f = z;
            o(b2);
        }
    }

    public final void o(@NonNull d.b.g0.a.j2.c.a aVar) {
        if (j == 2) {
            p(aVar);
        } else {
            r();
            s(aVar);
        }
        View view = this.f44981c;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (aVar.f44970f) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = h0.s();
            }
            this.f44981c.setLayoutParams(layoutParams);
        }
    }

    public final void p(d.b.g0.a.j2.c.a aVar) {
        try {
            Window window = this.f44979a.getWindow();
            window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, aVar.f44968d ? i2 | i3 : (i2 ^ (-1)) & i3);
            window.setAttributes(attributes);
            int i4 = aVar.f44966b;
            if (i4 == 1) {
                i4 = f();
            }
            View h2 = h(aVar);
            if (h2 != null) {
                h2.setBackgroundColor(i4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean q(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i2));
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final void r() {
        Window window = this.f44979a.getWindow();
        window.clearFlags(1024);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (i2 >= 19) {
                window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                return;
            }
            return;
        }
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        if (j != 1) {
            return;
        }
        q(window, d().f44968d);
    }

    public final void s(d.b.g0.a.j2.c.a aVar) {
        Window window = this.f44979a.getWindow();
        boolean z = aVar.f44967c;
        int i2 = aVar.f44968d ? 13312 : 5120;
        int i3 = !aVar.f44969e ? i2 & (-257) : i2 | 256;
        int i4 = aVar.f44966b;
        if (i4 == 1) {
            i4 = f();
        }
        window.getDecorView().setSystemUiVisibility(i3);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aVar.f44965a);
        }
        View h2 = h(aVar);
        if (h2 != null) {
            h2.setBackgroundColor(i4);
        }
        if (this.f44986h == null) {
            this.f44986h = new a(this);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.f44986h);
        }
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.f44983e = 1;
        this.f44979a = activity;
        this.f44980b = viewGroup;
        this.f44981c = viewGroup.getChildAt(0);
    }
}
