package d.b.i0.p0;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import d.b.i0.f0.a;
/* loaded from: classes4.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f58619a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58620b;

    /* renamed from: c  reason: collision with root package name */
    public r f58621c;

    /* renamed from: d  reason: collision with root package name */
    public Context f58622d;
    public d.b.i0.f0.b j;

    /* renamed from: e  reason: collision with root package name */
    public int f58623e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f58624f = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58626h = true;
    public boolean i = true;
    public final Handler.Callback k = new a();
    public final Handler l = new Handler(this.k);
    public a.b m = new b();

    /* renamed from: g  reason: collision with root package name */
    public boolean f58625g = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if ((i == 1 || i == 2) && v0.this.g()) {
                v0.this.l.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            int i2 = message.what;
            if (i2 == 1) {
                v0.this.s();
                return true;
            } else if (i2 == 2) {
                v0.this.r();
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                v0.this.q();
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            if (e(i2)) {
                v0.this.k(true);
                v0.this.f();
            }
            if (v0.this.f58621c != null) {
                v0.this.f58621c.j1(false);
            }
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            if (e(i2)) {
                v0.this.k(false);
                v0.this.m();
            }
            if (v0.this.f58621c != null) {
                v0.this.f58621c.j1(true);
            }
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 1.0f;
        }
    }

    public v0(Context context, r rVar, d.b.i0.p0.n2.h hVar) {
        this.f58622d = context;
        this.f58621c = rVar;
        this.f58620b = rVar.c0();
        this.f58619a = rVar.e0();
        c();
        d.b.i0.f0.b bVar = new d.b.i0.f0.b(context);
        this.j = bVar;
        bVar.d(this.m);
    }

    public final void c() {
        r rVar = this.f58621c;
        if (rVar == null || rVar.k0() == null) {
            return;
        }
        View k0 = this.f58621c.k0();
        if (this.f58625g && k0.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = k0.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            k0.setLayoutParams(layoutParams);
            l(true);
            return;
        }
        l(false);
    }

    public void d() {
        this.l.removeCallbacksAndMessages(null);
    }

    public d.b.i0.f0.b e() {
        return this.j;
    }

    public void f() {
        if (this.f58626h && this.i && this.f58619a != null && this.f58623e >= this.f58624f) {
            n();
        }
    }

    public boolean g() {
        return h(this.f58619a);
    }

    public final boolean h(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void i(boolean z) {
        this.f58626h = z;
    }

    public final void j(boolean z, boolean z2) {
        r rVar = this.f58621c;
        if (rVar == null) {
            return;
        }
        rVar.f1(z, z2);
    }

    public void k(boolean z) {
    }

    public final void l(boolean z) {
        r rVar = this.f58621c;
        if (rVar == null || rVar.k0() == null) {
            return;
        }
        View k0 = this.f58621c.k0();
        if (this.f58625g && z && k0.getVisibility() != 0) {
            k0.setVisibility(0);
        } else if (z || k0.getVisibility() == 8) {
        } else {
            k0.setVisibility(8);
        }
    }

    public void m() {
        if (this.f58626h && this.i && this.f58619a != null) {
            o();
        }
    }

    public void n() {
        this.l.removeMessages(1);
        if (this.l.hasMessages(2)) {
            return;
        }
        this.l.sendEmptyMessageDelayed(2, 110L);
    }

    public void o() {
        this.l.removeMessages(2);
        if (this.l.hasMessages(1)) {
            return;
        }
        this.l.sendEmptyMessageDelayed(1, 60L);
    }

    public void p(boolean z, boolean z2) {
        r rVar;
        if (this.f58619a == null || (rVar = this.f58621c) == null || rVar.i0() == null || !this.f58621c.i0().d()) {
            return;
        }
        j(false, true);
    }

    public void q() {
        p(false, true);
    }

    public void r() {
        p(false, false);
    }

    public void s() {
        r rVar;
        if (this.f58619a == null || (rVar = this.f58621c) == null || rVar.i0() == null || this.f58621c.i0().d()) {
            return;
        }
        j(true, true);
    }
}
