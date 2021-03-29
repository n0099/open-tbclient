package d.b.c.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.afd.videopaster.view.VideoPasterContentView;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.c.m.f.a;
import d.b.i0.r2.t;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f42507a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f42508b;

    /* renamed from: c  reason: collision with root package name */
    public View f42509c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.m.f.a f42510d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0557d f42511e;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.m.e.a f42513g;

    /* renamed from: h  reason: collision with root package name */
    public Context f42514h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.m.g.b f42512f = new d.b.c.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.c.m.f.a.b
        public void a(int i, String str) {
            d.this.f42513g = null;
        }

        @Override // d.b.c.m.f.a.b
        public void b(d.b.c.m.e.a aVar) {
            d.this.f42513g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f42512f.k(d.this.q());
            if (d.this.f42511e != null) {
                d.this.f42511e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f42512f.j(d.this.q());
            d.b.i0.i1.o.h.c.h(d.this.f42513g);
            if (d.this.f42513g != null) {
                int d2 = t.d(d.this.f42514h, d.this.f42513g.i, d.this.f42513g.f42520g, d.this.f42513g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f42512f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f42512f.e(d.this.q());
            d.b.i0.i1.o.h.c.h(d.this.f42513g);
            if (d.this.f42513g != null) {
                int d2 = t.d(d.this.f42514h, d.this.f42513g.i, d.this.f42513g.f42520g, d.this.f42513g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void e() {
            d.this.f42512f.b(d.this.q());
            d.b.i0.i1.o.h.c.h(d.this.f42513g);
            if (d.this.f42513g != null) {
                int d2 = t.d(d.this.f42514h, d.this.f42513g.i, d.this.f42513g.f42520g, d.this.f42513g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements VideoPasterContentView.i {
        public c() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void b() {
            d.this.v();
            if (d.this.f42511e != null) {
                d.this.f42511e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i;
            boolean z = true;
            if (d.this.f42508b.s()) {
                i = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i = 1;
            } else {
                i = 2;
            }
            if (d.this.f42511e != null) {
                if (i == 0 || i == 1) {
                    d.this.M(i);
                } else {
                    z = false;
                }
                if (d.this.f42511e.c()) {
                    return;
                }
                if (d.this.p) {
                    d.this.p = false;
                } else if (z) {
                } else {
                    d.this.M(i);
                }
            }
        }
    }

    /* renamed from: d.b.c.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0557d {
        void a();

        void b();

        boolean c();

        void d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f42514h = context;
        this.f42507a = viewGroup;
        d.b.c.m.f.a aVar = new d.b.c.m.f.a();
        this.f42510d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f42508b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f42508b.setContentViewCallback(new c());
        View view = new View(this.f42514h);
        this.f42509c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.b.c.m.g.a aVar, int i) {
        if (t.p(i)) {
            this.f42512f.l(aVar, i);
        }
    }

    public void B() {
        C();
        this.i = false;
    }

    public final void C() {
        this.f42510d.i();
        this.f42508b.x();
        this.f42507a.removeView(this.f42508b);
        this.f42507a.removeView(this.f42509c);
    }

    public void D(int i) {
        VideoPasterContentView videoPasterContentView = this.f42508b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i);
        }
    }

    public void E() {
        this.f42508b.A();
        if (s()) {
            int curDuration = this.f42508b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f42512f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0557d interfaceC0557d) {
        this.f42511e = interfaceC0557d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f42508b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f42514h) == 1 && i == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f42510d.f()) {
            return false;
        }
        this.i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f42510d.e();
        if (e2 == null) {
            return false;
        }
        d.b.c.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f42510d.i();
            return false;
        } else if (pasterData.c()) {
            this.f42512f.i(q());
            this.f42510d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f42510d.i();
            return false;
        } else {
            this.f42507a.removeView(this.f42509c);
            this.f42507a.addView(this.f42509c);
            this.f42507a.removeView(this.f42508b);
            this.f42507a.addView(this.f42508b);
            ViewGroup viewGroup = this.f42507a;
            if (viewGroup instanceof FrameLayout) {
                this.f42508b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f42508b.setLayoutParams(layoutParams);
            }
            this.f42508b.setData(pasterData);
            this.k = this.f42508b.getCurDuration();
            if (!r()) {
                this.f42512f.i(q());
                d.b.i0.i1.o.h.c.g(this.f42513g);
            }
            this.f42508b.E(z, z2, str);
            InterfaceC0557d interfaceC0557d = this.f42511e;
            if (interfaceC0557d != null) {
                interfaceC0557d.d();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f42508b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.b.c.m.a aVar) {
        d.b.c.m.f.a aVar2 = this.f42510d;
        if (aVar2 == null || aVar2.f() || this.f42510d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.d() + 1;
        this.f42510d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f42508b.getCurDuration();
        if (s() && !H()) {
            this.f42512f.g(q());
        }
        this.f42508b.D();
    }

    public final void M(int i) {
        this.f42512f.c(q(), i);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i == 2) {
            this.f42512f.g(q());
        }
    }

    public boolean a() {
        return this.i;
    }

    public d.b.c.m.g.a q() {
        d.b.c.m.g.a aVar = new d.b.c.m.g.a();
        aVar.f42538g = this.k;
        aVar.f42536e = this.f42508b.getTotalDuration();
        aVar.f42537f = this.f42508b.getCurDuration();
        aVar.f42534c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f42514h) == 1) {
            aVar.f42539h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f42514h) == 2) {
            aVar.f42539h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f42514h) == 0) {
            aVar.f42539h = 2;
        } else {
            aVar.f42539h = -1;
        }
        d.b.c.m.e.a aVar2 = this.f42513g;
        if (aVar2 != null) {
            aVar.i = aVar2.a();
            d.b.c.m.e.a aVar3 = this.f42513g;
            aVar.j = aVar3.f42519f;
            aVar.f42535d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f42508b.q();
    }

    public boolean s() {
        return this.f42508b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f42508b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0557d interfaceC0557d = this.f42511e;
        if (interfaceC0557d != null) {
            interfaceC0557d.b();
        }
    }

    public final void v() {
        this.f42512f.f(q());
        C();
    }

    public void w() {
        this.f42510d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f42508b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f42508b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.b.c.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f42512f.d(q());
    }
}
