package d.a.n0.r0.m2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import d.a.n0.r0.m2.b;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f62629a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f62630b;

    /* renamed from: c  reason: collision with root package name */
    public g f62631c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r0.m2.b f62632d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.m0.o.a f62633e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f62634f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f62635g = new b();

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.n0.r0.m2.b.a
        public void onStateChanged(int i2) {
            if (i2 == 1) {
                if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                if (f.this.f62633e == null) {
                    f.this.f62633e = new d.a.m0.m0.o.a("anim_switch_trans_frs");
                }
                f.this.f62633e.b();
            } else if (i2 != 2) {
                if (i2 == 0) {
                    f.this.j();
                }
            } else {
                f.this.k();
                if (f.this.f62633e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                f.this.f62633e.c();
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
        this.f62629a = context;
        this.f62630b = viewGroup;
        g gVar = new g(context);
        this.f62631c = gVar;
        d.a.n0.r0.m2.b a2 = c.a(gVar, intent);
        this.f62632d = a2;
        a2.b(this.f62634f);
    }

    public static boolean i(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    public final void f() {
        d.a.c.e.m.e.a().removeCallbacks(this.f62635g);
        if (this.f62632d.a() == 1) {
            d.a.c.e.m.e.a().postDelayed(this.f62635g, 10L);
            return;
        }
        k();
        this.f62632d.c();
    }

    public final void g() {
        View findViewById;
        ViewGroup viewGroup = this.f62630b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f62630b.getChildAt(0).setVisibility(8);
        }
        ViewGroup viewGroup2 = this.f62630b;
        if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void h() {
        if (this.f62630b == null) {
            return;
        }
        f();
    }

    public final void j() {
        ViewParent parent = this.f62631c.f62638a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f62631c.f62638a);
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f62635g);
    }

    public final void k() {
        ViewGroup viewGroup = this.f62630b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f62630b.getChildAt(0).setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f62630b;
        if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
            return;
        }
        this.f62630b.findViewById(16908290).setVisibility(0);
    }

    public void l() {
        if (this.f62630b == null) {
            return;
        }
        j();
        this.f62630b.addView(this.f62631c.f62638a);
        g();
        this.f62632d.d();
    }
}
