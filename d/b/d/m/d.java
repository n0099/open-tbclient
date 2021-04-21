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
import d.b.j0.s2.w;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f43257a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f43258b;

    /* renamed from: c  reason: collision with root package name */
    public View f43259c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.d.m.f.a f43260d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0591d f43261e;

    /* renamed from: g  reason: collision with root package name */
    public d.b.d.m.e.a f43263g;

    /* renamed from: h  reason: collision with root package name */
    public Context f43264h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.d.m.g.b f43262f = new d.b.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.d.m.f.a.b
        public void a(int i, String str) {
            d.this.f43263g = null;
        }

        @Override // d.b.d.m.f.a.b
        public void b(d.b.d.m.e.a aVar) {
            d.this.f43263g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f43262f.k(d.this.q());
            if (d.this.f43261e != null) {
                d.this.f43261e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f43262f.j(d.this.q());
            d.b.j0.j1.o.h.c.h(d.this.f43263g);
            if (d.this.f43263g != null) {
                int d2 = w.d(d.this.f43264h, d.this.f43263g.i, d.this.f43263g.f43270g, d.this.f43263g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f43262f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f43262f.e(d.this.q());
            d.b.j0.j1.o.h.c.h(d.this.f43263g);
            if (d.this.f43263g != null) {
                int d2 = w.d(d.this.f43264h, d.this.f43263g.i, d.this.f43263g.f43270g, d.this.f43263g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f43262f.b(d.this.q());
            d.b.j0.j1.o.h.c.h(d.this.f43263g);
            if (d.this.f43263g != null) {
                int d2 = w.d(d.this.f43264h, d.this.f43263g.i, d.this.f43263g.f43270g, d.this.f43263g.q);
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
            if (d.this.f43261e != null) {
                d.this.f43261e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i;
            boolean z = true;
            if (d.this.f43258b.s()) {
                i = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i = 1;
            } else {
                i = 2;
            }
            if (d.this.f43261e != null) {
                if (i == 0 || i == 1) {
                    d.this.M(i);
                } else {
                    z = false;
                }
                if (d.this.f43261e.c()) {
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
    public interface InterfaceC0591d {
        void a();

        void b();

        boolean c();

        void d();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.f43264h = context;
        this.f43257a = viewGroup;
        d.b.d.m.f.a aVar = new d.b.d.m.f.a();
        this.f43260d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f43258b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f43258b.setContentViewCallback(new c());
        View view = new View(this.f43264h);
        this.f43259c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.b.d.m.g.a aVar, int i) {
        if (w.p(i)) {
            this.f43262f.l(aVar, i);
        }
    }

    public void B() {
        C();
        this.i = false;
    }

    public final void C() {
        this.f43260d.i();
        this.f43258b.x();
        this.f43257a.removeView(this.f43258b);
        this.f43257a.removeView(this.f43259c);
    }

    public void D(int i) {
        VideoPasterContentView videoPasterContentView = this.f43258b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i);
        }
    }

    public void E() {
        this.f43258b.A();
        if (s()) {
            int curDuration = this.f43258b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f43262f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0591d interfaceC0591d) {
        this.f43261e = interfaceC0591d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f43258b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f43264h) == 1 && i == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f43260d.f()) {
            return false;
        }
        this.i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f43260d.e();
        if (e2 == null) {
            return false;
        }
        d.b.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f43260d.i();
            return false;
        } else if (pasterData.c()) {
            this.f43262f.i(q());
            this.f43260d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f43260d.i();
            return false;
        } else {
            this.f43257a.removeView(this.f43259c);
            this.f43257a.addView(this.f43259c);
            this.f43257a.removeView(this.f43258b);
            this.f43257a.addView(this.f43258b);
            ViewGroup viewGroup = this.f43257a;
            if (viewGroup instanceof FrameLayout) {
                this.f43258b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f43258b.setLayoutParams(layoutParams);
            }
            this.f43258b.setData(pasterData);
            this.k = this.f43258b.getCurDuration();
            if (!r()) {
                this.f43262f.i(q());
                d.b.j0.j1.o.h.c.g(this.f43263g);
            }
            this.f43258b.E(z, z2, str);
            InterfaceC0591d interfaceC0591d = this.f43261e;
            if (interfaceC0591d != null) {
                interfaceC0591d.d();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f43258b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.b.d.m.a aVar) {
        d.b.d.m.f.a aVar2 = this.f43260d;
        if (aVar2 == null || aVar2.f() || this.f43260d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.d() + 1;
        this.f43260d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f43258b.getCurDuration();
        if (s() && !H()) {
            this.f43262f.g(q());
        }
        this.f43258b.D();
    }

    public final void M(int i) {
        this.f43262f.c(q(), i);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i == 2) {
            this.f43262f.g(q());
        }
    }

    public boolean a() {
        return this.i;
    }

    public d.b.d.m.g.a q() {
        d.b.d.m.g.a aVar = new d.b.d.m.g.a();
        aVar.f43288g = this.k;
        aVar.f43286e = this.f43258b.getTotalDuration();
        aVar.f43287f = this.f43258b.getCurDuration();
        aVar.f43284c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f43264h) == 1) {
            aVar.f43289h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f43264h) == 2) {
            aVar.f43289h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f43264h) == 0) {
            aVar.f43289h = 2;
        } else {
            aVar.f43289h = -1;
        }
        d.b.d.m.e.a aVar2 = this.f43263g;
        if (aVar2 != null) {
            aVar.i = aVar2.a();
            d.b.d.m.e.a aVar3 = this.f43263g;
            aVar.j = aVar3.f43269f;
            aVar.f43285d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f43258b.q();
    }

    public boolean s() {
        return this.f43258b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f43258b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0591d interfaceC0591d = this.f43261e;
        if (interfaceC0591d != null) {
            interfaceC0591d.b();
        }
    }

    public final void v() {
        this.f43262f.f(q());
        C();
    }

    public void w() {
        this.f43260d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f43258b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f43258b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.b.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f43262f.d(q());
    }
}
