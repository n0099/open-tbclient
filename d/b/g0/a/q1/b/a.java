package d.b.g0.a.q1.b;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.protobuf.CodedInputStream;
import d.b.g0.a.f;
import d.b.g0.a.i2.a0;
import d.b.g0.a.i2.e;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.t.c.f.g;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f45538a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45539b;

    /* renamed from: d.b.g0.a.q1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0761a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.j2.c.b f45540e;

        public RunnableC0761a(d.b.g0.a.j2.c.b bVar) {
            this.f45540e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            d.b.g0.a.j2.c.b bVar = this.f45540e;
            if (bVar == null || (e2 = bVar.e()) == null) {
                return;
            }
            e2.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f45541e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f45542f;

        public b(d.b.g0.a.e0.l.c cVar, View view) {
            this.f45541e = cVar;
            this.f45542f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            d.b.g0.a.j2.c.b B1 = this.f45541e.B1();
            if (B1 != null && (e2 = B1.e()) != null) {
                e2.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.f45542f.findViewById(f.ai_apps_fragment_base_view);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            linearLayout.setLayoutParams(layoutParams);
            FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(f.ai_apps_fragment_content);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams2);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45544f;

        public c(Activity activity, boolean z) {
            this.f45543e = activity;
            this.f45544f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45543e.getWindow().clearFlags(2048);
            a.l(a.d(this.f45543e), this.f45544f);
        }
    }

    static {
        Color.parseColor("#80000000");
        f45539b = h();
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            return;
        }
        TextUtils.equals(Build.MANUFACTURER, "Meizu");
    }

    public static View b() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        d.b.g0.a.e0.l.c m = W != null ? W.m() : null;
        if (m != null) {
            return m.E1();
        }
        return null;
    }

    public static LinearLayout c() {
        d.b.g0.a.d2.b.a s = g.s();
        if (s != null) {
            return s.m();
        }
        return null;
    }

    public static ViewGroup d(Activity activity) {
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    public static boolean e(Dialog dialog) {
        return ((dialog.getWindow().getDecorView().getSystemUiVisibility() | dialog.getWindow().getAttributes().systemUiVisibility) & 2) != 0;
    }

    public static void f() {
        d.b.g0.a.e0.l.c m;
        View W;
        d.b.g0.a.e0.l.f W2 = d.b.g0.a.z0.f.V().W();
        if (W2 == null || (W = (m = W2.m()).W()) == null) {
            return;
        }
        k0.T(new b(m, W));
    }

    public static boolean g(View view) {
        return (!f45539b || view == null || view.findViewById(f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static boolean h() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        return f45538a ? z & a0.b("sp_key_immersion_switch", z) : z;
    }

    public static void i(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(d.b.g0.a.c.aiapps_dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static void j(Activity activity, long j, boolean z) {
        new Handler(Looper.getMainLooper()).postDelayed(new c(activity, z), j);
    }

    public static void k(boolean z) {
        j(d.b.g0.a.z0.f.V().getActivity(), 100L, z);
    }

    public static void l(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(e.c());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static void m() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            return;
        }
        k0.T(new RunnableC0761a(W.m().B1()));
    }
}
