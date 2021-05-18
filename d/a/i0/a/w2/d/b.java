package d.a.i0.a.w2.d;

import android.annotation.SuppressLint;
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
import d.a.i0.a.c;
import d.a.i0.a.f;
import d.a.i0.a.v2.n0;
import d.a.i0.a.w2.d.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45482i = j();
    public static int j;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Activity f45483a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f45484b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public View f45485c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public View f45486d;

    /* renamed from: e  reason: collision with root package name */
    public int f45487e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45488f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.w2.d.a f45489g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnSystemUiVisibilityChangeListener f45490h;

    /* loaded from: classes3.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
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
        return ((int) (((i2 & 255) * f2) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f2) + 0.5d)) << 16) | (-16777216) | (((int) ((((i2 >> 8) & 255) * f2) + 0.5d)) << 8);
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public final d.a.i0.a.w2.d.a b(int i2, int i3, boolean z, boolean z2, boolean z3) {
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
        this.f45489g = b(f2, g(f2), false, false, true);
    }

    @NonNull
    public d.a.i0.a.w2.d.a d() {
        if (this.f45489g == null) {
            c();
        }
        return this.f45489g;
    }

    @Nullable
    public View e() {
        return this.f45486d;
    }

    public final int f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f45483a.getResources().getColor(c.aiapps_statusbar_immersion_bg);
        }
        return this.f45483a.getResources().getColor(c.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    public final int g(int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return a(i2, 45);
    }

    public final View h(@NonNull d.a.i0.a.w2.d.a aVar) {
        if (aVar.f45474g) {
            View view = this.f45486d;
            if (view != null) {
                if (aVar.f45472e) {
                    return view;
                }
                this.f45484b.removeView(view);
                this.f45486d = null;
                return null;
            } else if (!aVar.f45472e) {
                this.f45486d = null;
                return null;
            } else {
                int u = n0.u();
                View view2 = new View(this.f45483a);
                view2.setTag("IMMERSION_VIEW");
                view2.setId(f.immersion_custom_statusbar_view);
                this.f45484b.addView(view2, new ViewGroup.LayoutParams(-1, u));
                this.f45486d = view2;
                return view2;
            }
        }
        return null;
    }

    public boolean i() {
        return this.f45488f;
    }

    public void k() {
        this.f45489g = null;
        this.f45487e = 1;
    }

    public void l() {
        o(d());
    }

    public void m(int i2, boolean z, boolean z2) {
        n(i2, z, true, z2);
    }

    public void n(int i2, boolean z, boolean z2, boolean z3) {
        d.a.i0.a.w2.d.a b2;
        if (f45482i) {
            if (i2 == 1) {
                if (this.f45487e != 1) {
                    k();
                }
                this.f45487e = i2;
                b2 = d();
            } else {
                this.f45487e = i2;
                b2 = b(i2, g(i2), z3, z, z2);
                this.f45489g = b2;
            }
            this.f45488f = z;
            o(b2);
        }
    }

    public final void o(@NonNull d.a.i0.a.w2.d.a aVar) {
        if (j == 2) {
            p(aVar);
        } else {
            r();
            s(aVar);
        }
        View view = this.f45485c;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (aVar.f45473f) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = n0.u();
            }
            this.f45485c.setLayoutParams(layoutParams);
        }
    }

    public final void p(d.a.i0.a.w2.d.a aVar) {
        try {
            Window window = this.f45483a.getWindow();
            window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, aVar.f45471d ? i2 | i3 : (~i2) & i3);
            window.setAttributes(attributes);
            int i4 = aVar.f45469b;
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

    @SuppressLint({"PrivateApi"})
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

    @SuppressLint({"ObsoleteSdkInt"})
    public final void r() {
        Window window = this.f45483a.getWindow();
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
        q(window, d().f45471d);
    }

    @SuppressLint({"InlinedApi"})
    public final void s(d.a.i0.a.w2.d.a aVar) {
        Window window = this.f45483a.getWindow();
        boolean z = aVar.f45470c;
        int i2 = aVar.f45471d ? 13312 : 5120;
        int i3 = !aVar.f45472e ? i2 & (-257) : i2 | 256;
        int i4 = aVar.f45469b;
        if (i4 == 1) {
            i4 = f();
        }
        window.getDecorView().setSystemUiVisibility(i3);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aVar.f45468a);
        }
        View h2 = h(aVar);
        if (h2 != null) {
            h2.setBackgroundColor(i4);
        }
        if (this.f45490h == null) {
            this.f45490h = new a(this);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.f45490h);
        }
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.f45487e = 1;
        this.f45483a = activity;
        this.f45484b = viewGroup;
        this.f45485c = viewGroup.getChildAt(0);
    }
}
