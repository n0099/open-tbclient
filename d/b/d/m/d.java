package d.b.d.m;

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
import d.b.d.m.f.a;
import d.b.i0.s2.w;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f43097a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f43098b;

    /* renamed from: c  reason: collision with root package name */
    public View f43099c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.d.m.f.a f43100d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0586d f43101e;

    /* renamed from: g  reason: collision with root package name */
    public d.b.d.m.e.a f43103g;

    /* renamed from: h  reason: collision with root package name */
    public Context f43104h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.d.m.g.b f43102f = new d.b.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.d.m.f.a.b
        public void a(int i, String str) {
            d.this.f43103g = null;
        }

        @Override // d.b.d.m.f.a.b
        public void b(d.b.d.m.e.a aVar) {
            d.this.f43103g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f43102f.k(d.this.q());
            if (d.this.f43101e != null) {
                d.this.f43101e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f43102f.j(d.this.q());
            d.b.i0.j1.o.h.c.h(d.this.f43103g);
            if (d.this.f43103g != null) {
                int d2 = w.d(d.this.f43104h, d.this.f43103g.i, d.this.f43103g.f43110g, d.this.f43103g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f43102f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f43102f.e(d.this.q());
            d.b.i0.j1.o.h.c.h(d.this.f43103g);
            if (d.this.f43103g != null) {
                int d2 = w.d(d.this.f43104h, d.this.f43103g.i, d.this.f43103g.f43110g, d.this.f43103g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f43102f.b(d.this.q());
            d.b.i0.j1.o.h.c.h(d.this.f43103g);
            if (d.this.f43103g != null) {
                int d2 = w.d(d.this.f43104h, d.this.f43103g.i, d.this.f43103g.f43110g, d.this.f43103g.q);
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
            if (d.this.f43101e != null) {
                d.this.f43101e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i;
            boolean z = true;
            if (d.this.f43098b.s()) {
                i = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i = 1;
            } else {
                i = 2;
            }
            if (d.this.f43101e != null) {
                if (i == 0 || i == 1) {
                    d.this.M(i);
                } else {
                    z = false;
                }
                if (d.this.f43101e.c()) {
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

    /* renamed from: d.b.d.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0586d {
        void a();

        void b();

        boolean c();

        void d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f43104h = context;
        this.f43097a = viewGroup;
        d.b.d.m.f.a aVar = new d.b.d.m.f.a();
        this.f43100d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f43098b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f43098b.setContentViewCallback(new c());
        View view = new View(this.f43104h);
        this.f43099c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.b.d.m.g.a aVar, int i) {
        if (w.p(i)) {
            this.f43102f.l(aVar, i);
        }
    }

    public void B() {
        C();
        this.i = false;
    }

    public final void C() {
        this.f43100d.i();
        this.f43098b.x();
        this.f43097a.removeView(this.f43098b);
        this.f43097a.removeView(this.f43099c);
    }

    public void D(int i) {
        VideoPasterContentView videoPasterContentView = this.f43098b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i);
        }
    }

    public void E() {
        this.f43098b.A();
        if (s()) {
            int curDuration = this.f43098b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f43102f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0586d interfaceC0586d) {
        this.f43101e = interfaceC0586d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f43098b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f43104h) == 1 && i == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f43100d.f()) {
            return false;
        }
        this.i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f43100d.e();
        if (e2 == null) {
            return false;
        }
        d.b.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f43100d.i();
            return false;
        } else if (pasterData.c()) {
            this.f43102f.i(q());
            this.f43100d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f43100d.i();
            return false;
        } else {
            this.f43097a.removeView(this.f43099c);
            this.f43097a.addView(this.f43099c);
            this.f43097a.removeView(this.f43098b);
            this.f43097a.addView(this.f43098b);
            ViewGroup viewGroup = this.f43097a;
            if (viewGroup instanceof FrameLayout) {
                this.f43098b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f43098b.setLayoutParams(layoutParams);
            }
            this.f43098b.setData(pasterData);
            this.k = this.f43098b.getCurDuration();
            if (!r()) {
                this.f43102f.i(q());
                d.b.i0.j1.o.h.c.g(this.f43103g);
            }
            this.f43098b.E(z, z2, str);
            InterfaceC0586d interfaceC0586d = this.f43101e;
            if (interfaceC0586d != null) {
                interfaceC0586d.d();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f43098b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.b.d.m.a aVar) {
        d.b.d.m.f.a aVar2 = this.f43100d;
        if (aVar2 == null || aVar2.f() || this.f43100d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.d() + 1;
        this.f43100d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f43098b.getCurDuration();
        if (s() && !H()) {
            this.f43102f.g(q());
        }
        this.f43098b.D();
    }

    public final void M(int i) {
        this.f43102f.c(q(), i);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i == 2) {
            this.f43102f.g(q());
        }
    }

    public boolean a() {
        return this.i;
    }

    public d.b.d.m.g.a q() {
        d.b.d.m.g.a aVar = new d.b.d.m.g.a();
        aVar.f43128g = this.k;
        aVar.f43126e = this.f43098b.getTotalDuration();
        aVar.f43127f = this.f43098b.getCurDuration();
        aVar.f43124c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f43104h) == 1) {
            aVar.f43129h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f43104h) == 2) {
            aVar.f43129h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f43104h) == 0) {
            aVar.f43129h = 2;
        } else {
            aVar.f43129h = -1;
        }
        d.b.d.m.e.a aVar2 = this.f43103g;
        if (aVar2 != null) {
            aVar.i = aVar2.a();
            d.b.d.m.e.a aVar3 = this.f43103g;
            aVar.j = aVar3.f43109f;
            aVar.f43125d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f43098b.q();
    }

    public boolean s() {
        return this.f43098b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f43098b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0586d interfaceC0586d = this.f43101e;
        if (interfaceC0586d != null) {
            interfaceC0586d.b();
        }
    }

    public final void v() {
        this.f43102f.f(q());
        C();
    }

    public void w() {
        this.f43100d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f43098b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f43098b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.b.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f43102f.d(q());
    }
}
