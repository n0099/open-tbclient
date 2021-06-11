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
import d.a.n0.t2.y;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f43233a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f43234b;

    /* renamed from: c  reason: collision with root package name */
    public View f43235c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f43236d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0573d f43237e;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f43239g;

    /* renamed from: h  reason: collision with root package name */
    public Context f43240h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43241i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f43238f = new d.a.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            d.this.f43239g = null;
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            d.this.f43239g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f43238f.j(d.this.q());
            d.a.n0.k1.o.h.c.h(d.this.f43239g);
            if (d.this.f43239g != null) {
                int d2 = y.d(d.this.f43240h, d.this.f43239g.f43249i, d.this.f43239g.f43247g, d.this.f43239g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f43238f.k(d.this.q());
            if (d.this.f43237e != null) {
                d.this.f43237e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f43238f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f43238f.e(d.this.q());
            d.a.n0.k1.o.h.c.h(d.this.f43239g);
            if (d.this.f43239g != null) {
                int d2 = y.d(d.this.f43240h, d.this.f43239g.f43249i, d.this.f43239g.f43247g, d.this.f43239g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f43238f.b(d.this.q());
            d.a.n0.k1.o.h.c.h(d.this.f43239g);
            if (d.this.f43239g != null) {
                int d2 = y.d(d.this.f43240h, d.this.f43239g.f43249i, d.this.f43239g.f43247g, d.this.f43239g.q);
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
            if (d.this.f43237e != null) {
                d.this.f43237e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            boolean z = true;
            if (d.this.f43234b.s()) {
                i2 = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (d.this.f43237e != null) {
                if (i2 == 0 || i2 == 1) {
                    d.this.M(i2);
                } else {
                    z = false;
                }
                if (d.this.f43237e.d()) {
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
    public interface InterfaceC0573d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f43240h = context;
        this.f43233a = viewGroup;
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f43236d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f43234b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f43234b.setContentViewCallback(new c());
        View view = new View(this.f43240h);
        this.f43235c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        if (y.p(i2)) {
            this.f43238f.l(aVar, i2);
        }
    }

    public void B() {
        C();
        this.f43241i = false;
    }

    public final void C() {
        this.f43236d.i();
        this.f43234b.x();
        this.f43233a.removeView(this.f43234b);
        this.f43233a.removeView(this.f43235c);
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView = this.f43234b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i2);
        }
    }

    public void E() {
        this.f43234b.A();
        if (s()) {
            int curDuration = this.f43234b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f43238f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0573d interfaceC0573d) {
        this.f43237e = interfaceC0573d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f43234b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f43240h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f43236d.f()) {
            return false;
        }
        this.f43241i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f43236d.e();
        if (e2 == null) {
            return false;
        }
        d.a.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f43236d.i();
            return false;
        } else if (pasterData.c()) {
            this.f43238f.i(q());
            this.f43236d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f43236d.i();
            return false;
        } else {
            this.f43233a.removeView(this.f43235c);
            this.f43233a.addView(this.f43235c);
            this.f43233a.removeView(this.f43234b);
            this.f43233a.addView(this.f43234b);
            ViewGroup viewGroup = this.f43233a;
            if (viewGroup instanceof FrameLayout) {
                this.f43234b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f43234b.setLayoutParams(layoutParams);
            }
            this.f43234b.setData(pasterData);
            this.k = this.f43234b.getCurDuration();
            if (!r()) {
                this.f43238f.i(q());
                d.a.n0.k1.o.h.c.g(this.f43239g);
            }
            this.f43234b.E(z, z2, str);
            InterfaceC0573d interfaceC0573d = this.f43237e;
            if (interfaceC0573d != null) {
                interfaceC0573d.c();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f43234b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2 = this.f43236d;
        if (aVar2 == null || aVar2.f() || this.f43236d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f43236d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f43234b.getCurDuration();
        if (s() && !H()) {
            this.f43238f.g(q());
        }
        this.f43234b.D();
    }

    public final void M(int i2) {
        this.f43238f.c(q(), i2);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
            this.f43238f.g(q());
        }
    }

    public boolean a() {
        return this.f43241i;
    }

    public d.a.d.m.g.a q() {
        d.a.d.m.g.a aVar = new d.a.d.m.g.a();
        aVar.f43266g = this.k;
        aVar.f43264e = this.f43234b.getTotalDuration();
        aVar.f43265f = this.f43234b.getCurDuration();
        aVar.f43262c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f43240h) == 1) {
            aVar.f43267h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f43240h) == 2) {
            aVar.f43267h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f43240h) == 0) {
            aVar.f43267h = 2;
        } else {
            aVar.f43267h = -1;
        }
        d.a.d.m.e.a aVar2 = this.f43239g;
        if (aVar2 != null) {
            aVar.f43268i = aVar2.a();
            d.a.d.m.e.a aVar3 = this.f43239g;
            aVar.j = aVar3.f43246f;
            aVar.f43263d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f43234b.q();
    }

    public boolean s() {
        return this.f43234b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f43234b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0573d interfaceC0573d = this.f43237e;
        if (interfaceC0573d != null) {
            interfaceC0573d.a();
        }
    }

    public final void v() {
        this.f43238f.f(q());
        C();
    }

    public void w() {
        this.f43236d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f43234b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f43234b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.a.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f43238f.d(q());
    }
}
