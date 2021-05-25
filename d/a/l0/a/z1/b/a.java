package d.a.l0.a.z1.b;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.protobuf.CodedInputStream;
import d.a.l0.a.f;
import d.a.l0.a.h0.g.d;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.c0;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f46039a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46040b;

    /* renamed from: d.a.l0.a.z1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0930a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.w2.d.b f46041e;

        public RunnableC0930a(d.a.l0.a.w2.d.b bVar) {
            this.f46041e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            d.a.l0.a.w2.d.b bVar = this.f46041e;
            if (bVar == null || (e2 = bVar.e()) == null) {
                return;
            }
            e2.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f46042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f46043f;

        public b(d dVar, View view) {
            this.f46042e = dVar;
            this.f46043f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            d.a.l0.a.w2.d.b F1 = this.f46042e.F1();
            if (F1 != null && (e2 = F1.e()) != null) {
                e2.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.f46043f.findViewById(f.ai_apps_fragment_base_view);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            linearLayout.setLayoutParams(layoutParams);
            FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(f.ai_apps_fragment_content);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams2);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46045f;

        public c(Activity activity, boolean z) {
            this.f46044e = activity;
            this.f46045f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46044e.getWindow().clearFlags(2048);
            a.l(a.d(this.f46044e), this.f46045f);
        }
    }

    static {
        Color.parseColor("#80000000");
        f46040b = h();
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            return;
        }
        TextUtils.equals(Build.MANUFACTURER, "Meizu");
    }

    public static View b() {
        g W = d.a.l0.a.g1.f.V().W();
        d m = W != null ? W.m() : null;
        if (m != null) {
            return m.I1();
        }
        return null;
    }

    public static LinearLayout c() {
        d.a.l0.a.o2.b.a t = d.a.l0.a.u.e.g.g.t();
        if (t != null) {
            return t.m();
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
        d m;
        View b0;
        g W = d.a.l0.a.g1.f.V().W();
        if (W == null || (b0 = (m = W.m()).b0()) == null) {
            return;
        }
        q0.X(new b(m, b0));
    }

    public static boolean g(View view) {
        return (!f46040b || view == null || view.findViewById(f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static boolean h() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        return f46039a ? z & c0.b("sp_key_immersion_switch", z) : z;
    }

    public static void i(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(d.a.l0.a.c.aiapps_dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static void j(Activity activity, long j, boolean z) {
        q0.Y(new c(activity, z), j);
    }

    public static void k(boolean z) {
        j(d.a.l0.a.g1.f.V().getActivity(), 100L, z);
    }

    public static void l(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(d.a.l0.a.v2.f.c());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static void m() {
        g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        q0.X(new RunnableC0930a(W.m().F1()));
    }
}
