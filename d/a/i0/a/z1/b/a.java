package d.a.i0.a.z1.b;

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
import d.a.i0.a.f;
import d.a.i0.a.h0.g.d;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.c0;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f45863a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45864b;

    /* renamed from: d.a.i0.a.z1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0919a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.w2.d.b f45865e;

        public RunnableC0919a(d.a.i0.a.w2.d.b bVar) {
            this.f45865e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            d.a.i0.a.w2.d.b bVar = this.f45865e;
            if (bVar == null || (e2 = bVar.e()) == null) {
                return;
            }
            e2.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f45866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f45867f;

        public b(d dVar, View view) {
            this.f45866e = dVar;
            this.f45867f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            d.a.i0.a.w2.d.b F1 = this.f45866e.F1();
            if (F1 != null && (e2 = F1.e()) != null) {
                e2.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.f45867f.findViewById(f.ai_apps_fragment_base_view);
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
        public final /* synthetic */ Activity f45868e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45869f;

        public c(Activity activity, boolean z) {
            this.f45868e = activity;
            this.f45869f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45868e.getWindow().clearFlags(2048);
            a.l(a.d(this.f45868e), this.f45869f);
        }
    }

    static {
        Color.parseColor("#80000000");
        f45864b = h();
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            return;
        }
        TextUtils.equals(Build.MANUFACTURER, "Meizu");
    }

    public static View b() {
        g W = d.a.i0.a.g1.f.V().W();
        d m = W != null ? W.m() : null;
        if (m != null) {
            return m.I1();
        }
        return null;
    }

    public static LinearLayout c() {
        d.a.i0.a.o2.b.a t = d.a.i0.a.u.e.g.g.t();
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
        g W = d.a.i0.a.g1.f.V().W();
        if (W == null || (b0 = (m = W.m()).b0()) == null) {
            return;
        }
        q0.X(new b(m, b0));
    }

    public static boolean g(View view) {
        return (!f45864b || view == null || view.findViewById(f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static boolean h() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        return f45863a ? z & c0.b("sp_key_immersion_switch", z) : z;
    }

    public static void i(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(d.a.i0.a.c.aiapps_dialog_immersion_status_bar_color);
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
        j(d.a.i0.a.g1.f.V().getActivity(), 100L, z);
    }

    public static void l(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(d.a.i0.a.v2.f.c());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static void m() {
        g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        q0.X(new RunnableC0919a(W.m().F1()));
    }
}
