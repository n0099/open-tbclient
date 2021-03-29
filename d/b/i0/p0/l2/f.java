package d.b.i0.p0.l2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import d.b.i0.p0.l2.b;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f57847a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57848b;

    /* renamed from: c  reason: collision with root package name */
    public g f57849c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p0.l2.b f57850d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.m0.o.a f57851e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f57852f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f57853g = new b();

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.i0.p0.l2.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                if (f.this.f57851e == null) {
                    f.this.f57851e = new d.b.h0.m0.o.a("anim_switch_trans_frs");
                }
                f.this.f57851e.b();
            } else if (i != 2) {
                if (i == 0) {
                    f.this.j();
                }
            } else {
                f.this.k();
                if (f.this.f57851e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                f.this.f57851e.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f();
        }
    }

    public f(Context context, ViewGroup viewGroup, Intent intent) {
        this.f57847a = context;
        this.f57848b = viewGroup;
        g gVar = new g(context);
        this.f57849c = gVar;
        d.b.i0.p0.l2.b a2 = c.a(gVar, intent);
        this.f57850d = a2;
        a2.b(this.f57852f);
    }

    public static boolean i(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    public final void f() {
        d.b.b.e.m.e.a().removeCallbacks(this.f57853g);
        if (this.f57850d.a() == 1) {
            d.b.b.e.m.e.a().postDelayed(this.f57853g, 10L);
            return;
        }
        k();
        this.f57850d.c();
    }

    public final void g() {
        View findViewById;
        ViewGroup viewGroup = this.f57848b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f57848b.getChildAt(0).setVisibility(8);
        }
        ViewGroup viewGroup2 = this.f57848b;
        if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void h() {
        if (this.f57848b == null) {
            return;
        }
        f();
    }

    public final void j() {
        ViewParent parent = this.f57849c.f57856a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f57849c.f57856a);
        }
        d.b.b.e.m.e.a().removeCallbacks(this.f57853g);
    }

    public final void k() {
        ViewGroup viewGroup = this.f57848b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f57848b.getChildAt(0).setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f57848b;
        if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
            return;
        }
        this.f57848b.findViewById(16908290).setVisibility(0);
    }

    public void l() {
        if (this.f57848b == null) {
            return;
        }
        j();
        this.f57848b.addView(this.f57849c.f57856a);
        g();
        this.f57850d.d();
    }
}
