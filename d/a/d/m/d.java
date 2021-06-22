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
import d.a.o0.t2.y;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f43336a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f43337b;

    /* renamed from: c  reason: collision with root package name */
    public View f43338c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f43339d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0576d f43340e;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f43342g;

    /* renamed from: h  reason: collision with root package name */
    public Context f43343h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43344i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f43341f = new d.a.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            d.this.f43342g = null;
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            d.this.f43342g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f43341f.j(d.this.q());
            d.a.o0.k1.o.h.c.h(d.this.f43342g);
            if (d.this.f43342g != null) {
                int d2 = y.d(d.this.f43343h, d.this.f43342g.f43352i, d.this.f43342g.f43350g, d.this.f43342g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f43341f.k(d.this.q());
            if (d.this.f43340e != null) {
                d.this.f43340e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f43341f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f43341f.e(d.this.q());
            d.a.o0.k1.o.h.c.h(d.this.f43342g);
            if (d.this.f43342g != null) {
                int d2 = y.d(d.this.f43343h, d.this.f43342g.f43352i, d.this.f43342g.f43350g, d.this.f43342g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f43341f.b(d.this.q());
            d.a.o0.k1.o.h.c.h(d.this.f43342g);
            if (d.this.f43342g != null) {
                int d2 = y.d(d.this.f43343h, d.this.f43342g.f43352i, d.this.f43342g.f43350g, d.this.f43342g.q);
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
            if (d.this.f43340e != null) {
                d.this.f43340e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            boolean z = true;
            if (d.this.f43337b.s()) {
                i2 = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (d.this.f43340e != null) {
                if (i2 == 0 || i2 == 1) {
                    d.this.M(i2);
                } else {
                    z = false;
                }
                if (d.this.f43340e.d()) {
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
    public interface InterfaceC0576d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f43343h = context;
        this.f43336a = viewGroup;
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f43339d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f43337b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f43337b.setContentViewCallback(new c());
        View view = new View(this.f43343h);
        this.f43338c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        if (y.p(i2)) {
            this.f43341f.l(aVar, i2);
        }
    }

    public void B() {
        C();
        this.f43344i = false;
    }

    public final void C() {
        this.f43339d.i();
        this.f43337b.x();
        this.f43336a.removeView(this.f43337b);
        this.f43336a.removeView(this.f43338c);
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView = this.f43337b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i2);
        }
    }

    public void E() {
        this.f43337b.A();
        if (s()) {
            int curDuration = this.f43337b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f43341f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0576d interfaceC0576d) {
        this.f43340e = interfaceC0576d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f43337b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f43343h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f43339d.f()) {
            return false;
        }
        this.f43344i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f43339d.e();
        if (e2 == null) {
            return false;
        }
        d.a.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f43339d.i();
            return false;
        } else if (pasterData.c()) {
            this.f43341f.i(q());
            this.f43339d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f43339d.i();
            return false;
        } else {
            this.f43336a.removeView(this.f43338c);
            this.f43336a.addView(this.f43338c);
            this.f43336a.removeView(this.f43337b);
            this.f43336a.addView(this.f43337b);
            ViewGroup viewGroup = this.f43336a;
            if (viewGroup instanceof FrameLayout) {
                this.f43337b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f43337b.setLayoutParams(layoutParams);
            }
            this.f43337b.setData(pasterData);
            this.k = this.f43337b.getCurDuration();
            if (!r()) {
                this.f43341f.i(q());
                d.a.o0.k1.o.h.c.g(this.f43342g);
            }
            this.f43337b.E(z, z2, str);
            InterfaceC0576d interfaceC0576d = this.f43340e;
            if (interfaceC0576d != null) {
                interfaceC0576d.c();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f43337b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2 = this.f43339d;
        if (aVar2 == null || aVar2.f() || this.f43339d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f43339d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f43337b.getCurDuration();
        if (s() && !H()) {
            this.f43341f.g(q());
        }
        this.f43337b.D();
    }

    public final void M(int i2) {
        this.f43341f.c(q(), i2);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
            this.f43341f.g(q());
        }
    }

    public boolean a() {
        return this.f43344i;
    }

    public d.a.d.m.g.a q() {
        d.a.d.m.g.a aVar = new d.a.d.m.g.a();
        aVar.f43369g = this.k;
        aVar.f43367e = this.f43337b.getTotalDuration();
        aVar.f43368f = this.f43337b.getCurDuration();
        aVar.f43365c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f43343h) == 1) {
            aVar.f43370h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f43343h) == 2) {
            aVar.f43370h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f43343h) == 0) {
            aVar.f43370h = 2;
        } else {
            aVar.f43370h = -1;
        }
        d.a.d.m.e.a aVar2 = this.f43342g;
        if (aVar2 != null) {
            aVar.f43371i = aVar2.a();
            d.a.d.m.e.a aVar3 = this.f43342g;
            aVar.j = aVar3.f43349f;
            aVar.f43366d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f43337b.q();
    }

    public boolean s() {
        return this.f43337b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f43337b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0576d interfaceC0576d = this.f43340e;
        if (interfaceC0576d != null) {
            interfaceC0576d.a();
        }
    }

    public final void v() {
        this.f43341f.f(q());
        C();
    }

    public void w() {
        this.f43339d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f43337b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f43337b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.a.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f43341f.d(q());
    }
}
