package d.a.k0.q0.m2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import d.a.k0.q0.m2.b;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f58797a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f58798b;

    /* renamed from: c  reason: collision with root package name */
    public g f58799c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.q0.m2.b f58800d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.m0.o.a f58801e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f58802f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f58803g = new b();

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.k0.q0.m2.b.a
        public void onStateChanged(int i2) {
            if (i2 == 1) {
                if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                if (f.this.f58801e == null) {
                    f.this.f58801e = new d.a.j0.m0.o.a("anim_switch_trans_frs");
                }
                f.this.f58801e.b();
            } else if (i2 != 2) {
                if (i2 == 0) {
                    f.this.j();
                }
            } else {
                f.this.k();
                if (f.this.f58801e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                f.this.f58801e.c();
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
        this.f58797a = context;
        this.f58798b = viewGroup;
        g gVar = new g(context);
        this.f58799c = gVar;
        d.a.k0.q0.m2.b a2 = c.a(gVar, intent);
        this.f58800d = a2;
        a2.b(this.f58802f);
    }

    public static boolean i(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    public final void f() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58803g);
        if (this.f58800d.a() == 1) {
            d.a.c.e.m.e.a().postDelayed(this.f58803g, 10L);
            return;
        }
        k();
        this.f58800d.c();
    }

    public final void g() {
        View findViewById;
        ViewGroup viewGroup = this.f58798b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f58798b.getChildAt(0).setVisibility(8);
        }
        ViewGroup viewGroup2 = this.f58798b;
        if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void h() {
        if (this.f58798b == null) {
            return;
        }
        f();
    }

    public final void j() {
        ViewParent parent = this.f58799c.f58806a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f58799c.f58806a);
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f58803g);
    }

    public final void k() {
        ViewGroup viewGroup = this.f58798b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f58798b.getChildAt(0).setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f58798b;
        if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
            return;
        }
        this.f58798b.findViewById(16908290).setVisibility(0);
    }

    public void l() {
        if (this.f58798b == null) {
            return;
        }
        j();
        this.f58798b.addView(this.f58799c.f58806a);
        g();
        this.f58800d.d();
    }
}
