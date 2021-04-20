package d.b.i0.q0.m2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import d.b.i0.q0.m2.b;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f59556a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59557b;

    /* renamed from: c  reason: collision with root package name */
    public g f59558c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q0.m2.b f59559d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.m0.o.a f59560e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f59561f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59562g = new b();

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.i0.q0.m2.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                if (f.this.f59560e == null) {
                    f.this.f59560e = new d.b.h0.m0.o.a("anim_switch_trans_frs");
                }
                f.this.f59560e.b();
            } else if (i != 2) {
                if (i == 0) {
                    f.this.j();
                }
            } else {
                f.this.k();
                if (f.this.f59560e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                f.this.f59560e.c();
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
        this.f59556a = context;
        this.f59557b = viewGroup;
        g gVar = new g(context);
        this.f59558c = gVar;
        d.b.i0.q0.m2.b a2 = c.a(gVar, intent);
        this.f59559d = a2;
        a2.b(this.f59561f);
    }

    public static boolean i(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    public final void f() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59562g);
        if (this.f59559d.a() == 1) {
            d.b.c.e.m.e.a().postDelayed(this.f59562g, 10L);
            return;
        }
        k();
        this.f59559d.c();
    }

    public final void g() {
        View findViewById;
        ViewGroup viewGroup = this.f59557b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f59557b.getChildAt(0).setVisibility(8);
        }
        ViewGroup viewGroup2 = this.f59557b;
        if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void h() {
        if (this.f59557b == null) {
            return;
        }
        f();
    }

    public final void j() {
        ViewParent parent = this.f59558c.f59565a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f59558c.f59565a);
        }
        d.b.c.e.m.e.a().removeCallbacks(this.f59562g);
    }

    public final void k() {
        ViewGroup viewGroup = this.f59557b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f59557b.getChildAt(0).setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f59557b;
        if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
            return;
        }
        this.f59557b.findViewById(16908290).setVisibility(0);
    }

    public void l() {
        if (this.f59557b == null) {
            return;
        }
        j();
        this.f59557b.addView(this.f59558c.f59565a);
        g();
        this.f59559d.d();
    }
}
