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
import d.a.j0.s2.x;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f40491a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f40492b;

    /* renamed from: c  reason: collision with root package name */
    public View f40493c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f40494d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0530d f40495e;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f40497g;

    /* renamed from: h  reason: collision with root package name */
    public Context f40498h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40499i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f40496f = new d.a.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            d.this.f40497g = null;
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            d.this.f40497g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f40496f.j(d.this.q());
            d.a.j0.j1.o.h.c.h(d.this.f40497g);
            if (d.this.f40497g != null) {
                int d2 = x.d(d.this.f40498h, d.this.f40497g.f40507i, d.this.f40497g.f40505g, d.this.f40497g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f40496f.k(d.this.q());
            if (d.this.f40495e != null) {
                d.this.f40495e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f40496f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f40496f.e(d.this.q());
            d.a.j0.j1.o.h.c.h(d.this.f40497g);
            if (d.this.f40497g != null) {
                int d2 = x.d(d.this.f40498h, d.this.f40497g.f40507i, d.this.f40497g.f40505g, d.this.f40497g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f40496f.b(d.this.q());
            d.a.j0.j1.o.h.c.h(d.this.f40497g);
            if (d.this.f40497g != null) {
                int d2 = x.d(d.this.f40498h, d.this.f40497g.f40507i, d.this.f40497g.f40505g, d.this.f40497g.q);
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
            if (d.this.f40495e != null) {
                d.this.f40495e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            boolean z = true;
            if (d.this.f40492b.s()) {
                i2 = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (d.this.f40495e != null) {
                if (i2 == 0 || i2 == 1) {
                    d.this.M(i2);
                } else {
                    z = false;
                }
                if (d.this.f40495e.d()) {
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
    public interface InterfaceC0530d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f40498h = context;
        this.f40491a = viewGroup;
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f40494d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f40492b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f40492b.setContentViewCallback(new c());
        View view = new View(this.f40498h);
        this.f40493c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        if (x.p(i2)) {
            this.f40496f.l(aVar, i2);
        }
    }

    public void B() {
        C();
        this.f40499i = false;
    }

    public final void C() {
        this.f40494d.i();
        this.f40492b.x();
        this.f40491a.removeView(this.f40492b);
        this.f40491a.removeView(this.f40493c);
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView = this.f40492b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i2);
        }
    }

    public void E() {
        this.f40492b.A();
        if (s()) {
            int curDuration = this.f40492b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f40496f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0530d interfaceC0530d) {
        this.f40495e = interfaceC0530d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f40492b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f40498h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f40494d.f()) {
            return false;
        }
        this.f40499i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f40494d.e();
        if (e2 == null) {
            return false;
        }
        d.a.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f40494d.i();
            return false;
        } else if (pasterData.c()) {
            this.f40496f.i(q());
            this.f40494d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f40494d.i();
            return false;
        } else {
            this.f40491a.removeView(this.f40493c);
            this.f40491a.addView(this.f40493c);
            this.f40491a.removeView(this.f40492b);
            this.f40491a.addView(this.f40492b);
            ViewGroup viewGroup = this.f40491a;
            if (viewGroup instanceof FrameLayout) {
                this.f40492b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f40492b.setLayoutParams(layoutParams);
            }
            this.f40492b.setData(pasterData);
            this.k = this.f40492b.getCurDuration();
            if (!r()) {
                this.f40496f.i(q());
                d.a.j0.j1.o.h.c.g(this.f40497g);
            }
            this.f40492b.E(z, z2, str);
            InterfaceC0530d interfaceC0530d = this.f40495e;
            if (interfaceC0530d != null) {
                interfaceC0530d.c();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f40492b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2 = this.f40494d;
        if (aVar2 == null || aVar2.f() || this.f40494d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f40494d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f40492b.getCurDuration();
        if (s() && !H()) {
            this.f40496f.g(q());
        }
        this.f40492b.D();
    }

    public final void M(int i2) {
        this.f40496f.c(q(), i2);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
            this.f40496f.g(q());
        }
    }

    public boolean a() {
        return this.f40499i;
    }

    public d.a.d.m.g.a q() {
        d.a.d.m.g.a aVar = new d.a.d.m.g.a();
        aVar.f40524g = this.k;
        aVar.f40522e = this.f40492b.getTotalDuration();
        aVar.f40523f = this.f40492b.getCurDuration();
        aVar.f40520c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f40498h) == 1) {
            aVar.f40525h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f40498h) == 2) {
            aVar.f40525h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f40498h) == 0) {
            aVar.f40525h = 2;
        } else {
            aVar.f40525h = -1;
        }
        d.a.d.m.e.a aVar2 = this.f40497g;
        if (aVar2 != null) {
            aVar.f40526i = aVar2.a();
            d.a.d.m.e.a aVar3 = this.f40497g;
            aVar.j = aVar3.f40504f;
            aVar.f40521d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f40492b.q();
    }

    public boolean s() {
        return this.f40492b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f40492b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0530d interfaceC0530d = this.f40495e;
        if (interfaceC0530d != null) {
            interfaceC0530d.a();
        }
    }

    public final void v() {
        this.f40496f.f(q());
        C();
    }

    public void w() {
        this.f40494d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f40492b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f40492b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.a.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f40496f.d(q());
    }
}
