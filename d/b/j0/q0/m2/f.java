package d.b.j0.q0.m2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import d.b.j0.q0.m2.b;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f59977a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59978b;

    /* renamed from: c  reason: collision with root package name */
    public g f59979c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.q0.m2.b f59980d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.m0.o.a f59981e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f59982f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59983g = new b();

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.j0.q0.m2.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                if (f.this.f59981e == null) {
                    f.this.f59981e = new d.b.i0.m0.o.a("anim_switch_trans_frs");
                }
                f.this.f59981e.b();
            } else if (i != 2) {
                if (i == 0) {
                    f.this.j();
                }
            } else {
                f.this.k();
                if (f.this.f59981e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    return;
                }
                f.this.f59981e.c();
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
        this.f59977a = context;
        this.f59978b = viewGroup;
        g gVar = new g(context);
        this.f59979c = gVar;
        d.b.j0.q0.m2.b a2 = c.a(gVar, intent);
        this.f59980d = a2;
        a2.b(this.f59982f);
    }

    public static boolean i(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    public final void f() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59983g);
        if (this.f59980d.a() == 1) {
            d.b.c.e.m.e.a().postDelayed(this.f59983g, 10L);
            return;
        }
        k();
        this.f59980d.c();
    }

    public final void g() {
        View findViewById;
        ViewGroup viewGroup = this.f59978b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f59978b.getChildAt(0).setVisibility(8);
        }
        ViewGroup viewGroup2 = this.f59978b;
        if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void h() {
        if (this.f59978b == null) {
            return;
        }
        f();
    }

    public final void j() {
        ViewParent parent = this.f59979c.f59986a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f59979c.f59986a);
        }
        d.b.c.e.m.e.a().removeCallbacks(this.f59983g);
    }

    public final void k() {
        ViewGroup viewGroup = this.f59978b;
        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
            this.f59978b.getChildAt(0).setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f59978b;
        if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
            return;
        }
        this.f59978b.findViewById(16908290).setVisibility(0);
    }

    public void l() {
        if (this.f59978b == null) {
            return;
        }
        j();
        this.f59978b.addView(this.f59979c.f59986a);
        g();
        this.f59980d.d();
    }
}
