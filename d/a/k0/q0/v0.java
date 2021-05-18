package d.a.k0.q0;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import d.a.k0.f0.a;
/* loaded from: classes4.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f59560a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59561b;

    /* renamed from: c  reason: collision with root package name */
    public r f59562c;

    /* renamed from: d  reason: collision with root package name */
    public Context f59563d;
    public d.a.k0.f0.b j;

    /* renamed from: e  reason: collision with root package name */
    public int f59564e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f59565f = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59567h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59568i = true;
    public final Handler.Callback k = new a();
    public final Handler l = new Handler(this.k);
    public a.b m = new b();

    /* renamed from: g  reason: collision with root package name */
    public boolean f59566g = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if ((i2 == 1 || i2 == 2) && v0.this.g()) {
                v0.this.l.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            int i3 = message.what;
            if (i3 == 1) {
                v0.this.s();
                return true;
            } else if (i3 == 2) {
                v0.this.r();
                return true;
            } else if (i3 != 3) {
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

        @Override // d.a.k0.f0.a.b
        public void a(int i2, int i3) {
            if (e(i3)) {
                v0.this.k(true);
                v0.this.f();
            }
            if (v0.this.f59562c != null) {
                v0.this.f59562c.j1(false);
            }
        }

        @Override // d.a.k0.f0.a.b
        public void b(int i2, int i3) {
            if (e(i3)) {
                v0.this.k(false);
                v0.this.m();
            }
            if (v0.this.f59562c != null) {
                v0.this.f59562c.j1(true);
            }
        }

        @Override // d.a.k0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.k0.f0.a.b
        public void d(int i2, int i3) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 1.0f;
        }
    }

    public v0(Context context, r rVar, d.a.k0.q0.o2.h hVar) {
        this.f59563d = context;
        this.f59562c = rVar;
        this.f59561b = rVar.c0();
        this.f59560a = rVar.e0();
        c();
        d.a.k0.f0.b bVar = new d.a.k0.f0.b(context);
        this.j = bVar;
        bVar.d(this.m);
    }

    public final void c() {
        r rVar = this.f59562c;
        if (rVar == null || rVar.k0() == null) {
            return;
        }
        View k0 = this.f59562c.k0();
        if (this.f59566g && k0.getLayoutParams() != null) {
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

    public d.a.k0.f0.b e() {
        return this.j;
    }

    public void f() {
        if (this.f59567h && this.f59568i && this.f59560a != null && this.f59564e >= this.f59565f) {
            n();
        }
    }

    public boolean g() {
        return h(this.f59560a);
    }

    public final boolean h(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void i(boolean z) {
        this.f59567h = z;
    }

    public final void j(boolean z, boolean z2) {
        r rVar = this.f59562c;
        if (rVar == null) {
            return;
        }
        rVar.f1(z, z2);
    }

    public void k(boolean z) {
    }

    public final void l(boolean z) {
        r rVar = this.f59562c;
        if (rVar == null || rVar.k0() == null) {
            return;
        }
        View k0 = this.f59562c.k0();
        if (this.f59566g && z && k0.getVisibility() != 0) {
            k0.setVisibility(0);
        } else if (z || k0.getVisibility() == 8) {
        } else {
            k0.setVisibility(8);
        }
    }

    public void m() {
        if (this.f59567h && this.f59568i && this.f59560a != null) {
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
        if (this.f59560a == null || (rVar = this.f59562c) == null || rVar.i0() == null || !this.f59562c.i0().c()) {
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
        if (this.f59560a == null || (rVar = this.f59562c) == null || rVar.i0() == null || this.f59562c.i0().c()) {
            return;
        }
        j(true, true);
    }
}
