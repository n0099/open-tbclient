package d.a.d.m;

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
import d.a.d.m.f.a;
import d.a.k0.s2.y;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f39736a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f39737b;

    /* renamed from: c  reason: collision with root package name */
    public View f39738c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f39739d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0517d f39740e;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f39742g;

    /* renamed from: h  reason: collision with root package name */
    public Context f39743h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39744i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f39741f = new d.a.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            d.this.f39742g = null;
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            d.this.f39742g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f39741f.j(d.this.q());
            d.a.k0.j1.o.h.c.h(d.this.f39742g);
            if (d.this.f39742g != null) {
                int d2 = y.d(d.this.f39743h, d.this.f39742g.f39752i, d.this.f39742g.f39750g, d.this.f39742g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f39741f.k(d.this.q());
            if (d.this.f39740e != null) {
                d.this.f39740e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f39741f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f39741f.e(d.this.q());
            d.a.k0.j1.o.h.c.h(d.this.f39742g);
            if (d.this.f39742g != null) {
                int d2 = y.d(d.this.f39743h, d.this.f39742g.f39752i, d.this.f39742g.f39750g, d.this.f39742g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f39741f.b(d.this.q());
            d.a.k0.j1.o.h.c.h(d.this.f39742g);
            if (d.this.f39742g != null) {
                int d2 = y.d(d.this.f39743h, d.this.f39742g.f39752i, d.this.f39742g.f39750g, d.this.f39742g.q);
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
        public void a() {
            d.this.v();
            if (d.this.f39740e != null) {
                d.this.f39740e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            boolean z = true;
            if (d.this.f39737b.s()) {
                i2 = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (d.this.f39740e != null) {
                if (i2 == 0 || i2 == 1) {
                    d.this.M(i2);
                } else {
                    z = false;
                }
                if (d.this.f39740e.d()) {
                    return;
                }
                if (d.this.p) {
                    d.this.p = false;
                } else if (z) {
                } else {
                    d.this.M(i2);
                }
            }
        }
    }

    /* renamed from: d.a.d.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0517d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f39743h = context;
        this.f39736a = viewGroup;
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f39739d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f39737b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f39737b.setContentViewCallback(new c());
        View view = new View(this.f39743h);
        this.f39738c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        if (y.p(i2)) {
            this.f39741f.l(aVar, i2);
        }
    }

    public void B() {
        C();
        this.f39744i = false;
    }

    public final void C() {
        this.f39739d.i();
        this.f39737b.x();
        this.f39736a.removeView(this.f39737b);
        this.f39736a.removeView(this.f39738c);
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView = this.f39737b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i2);
        }
    }

    public void E() {
        this.f39737b.A();
        if (s()) {
            int curDuration = this.f39737b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f39741f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0517d interfaceC0517d) {
        this.f39740e = interfaceC0517d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f39737b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f39743h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f39739d.f()) {
            return false;
        }
        this.f39744i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f39739d.e();
        if (e2 == null) {
            return false;
        }
        d.a.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f39739d.i();
            return false;
        } else if (pasterData.c()) {
            this.f39741f.i(q());
            this.f39739d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f39739d.i();
            return false;
        } else {
            this.f39736a.removeView(this.f39738c);
            this.f39736a.addView(this.f39738c);
            this.f39736a.removeView(this.f39737b);
            this.f39736a.addView(this.f39737b);
            ViewGroup viewGroup = this.f39736a;
            if (viewGroup instanceof FrameLayout) {
                this.f39737b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f39737b.setLayoutParams(layoutParams);
            }
            this.f39737b.setData(pasterData);
            this.k = this.f39737b.getCurDuration();
            if (!r()) {
                this.f39741f.i(q());
                d.a.k0.j1.o.h.c.g(this.f39742g);
            }
            this.f39737b.E(z, z2, str);
            InterfaceC0517d interfaceC0517d = this.f39740e;
            if (interfaceC0517d != null) {
                interfaceC0517d.c();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f39737b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2 = this.f39739d;
        if (aVar2 == null || aVar2.f() || this.f39739d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f39739d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f39737b.getCurDuration();
        if (s() && !H()) {
            this.f39741f.g(q());
        }
        this.f39737b.D();
    }

    public final void M(int i2) {
        this.f39741f.c(q(), i2);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
            this.f39741f.g(q());
        }
    }

    public boolean a() {
        return this.f39744i;
    }

    public d.a.d.m.g.a q() {
        d.a.d.m.g.a aVar = new d.a.d.m.g.a();
        aVar.f39769g = this.k;
        aVar.f39767e = this.f39737b.getTotalDuration();
        aVar.f39768f = this.f39737b.getCurDuration();
        aVar.f39765c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f39743h) == 1) {
            aVar.f39770h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f39743h) == 2) {
            aVar.f39770h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f39743h) == 0) {
            aVar.f39770h = 2;
        } else {
            aVar.f39770h = -1;
        }
        d.a.d.m.e.a aVar2 = this.f39742g;
        if (aVar2 != null) {
            aVar.f39771i = aVar2.a();
            d.a.d.m.e.a aVar3 = this.f39742g;
            aVar.j = aVar3.f39749f;
            aVar.f39766d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f39737b.q();
    }

    public boolean s() {
        return this.f39737b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f39737b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0517d interfaceC0517d = this.f39740e;
        if (interfaceC0517d != null) {
            interfaceC0517d.a();
        }
    }

    public final void v() {
        this.f39741f.f(q());
        C();
    }

    public void w() {
        this.f39739d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f39737b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f39737b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.a.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f39741f.d(q());
    }
}
