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
    public ViewGroup f39552a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f39553b;

    /* renamed from: c  reason: collision with root package name */
    public View f39554c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f39555d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0517d f39556e;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f39558g;

    /* renamed from: h  reason: collision with root package name */
    public Context f39559h;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39560i = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f39557f = new d.a.d.m.g.b();

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            d.this.f39558g = null;
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            d.this.f39558g = aVar;
            d.this.z(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public b() {
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            d.this.f39557f.j(d.this.q());
            d.a.n0.k1.o.h.c.h(d.this.f39558g);
            if (d.this.f39558g != null) {
                int d2 = y.d(d.this.f39559h, d.this.f39558g.f39568i, d.this.f39558g.f39566g, d.this.f39558g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            d.this.f39557f.k(d.this.q());
            if (d.this.f39556e != null) {
                d.this.f39556e.b();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            d.this.o = true;
            d.this.u();
            d.this.f39557f.g(d.this.q());
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            d.this.f39557f.e(d.this.q());
            d.a.n0.k1.o.h.c.h(d.this.f39558g);
            if (d.this.f39558g != null) {
                int d2 = y.d(d.this.f39559h, d.this.f39558g.f39568i, d.this.f39558g.f39566g, d.this.f39558g.q);
                d dVar = d.this;
                dVar.A(dVar.q(), d2);
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            d.this.f39557f.b(d.this.q());
            d.a.n0.k1.o.h.c.h(d.this.f39558g);
            if (d.this.f39558g != null) {
                int d2 = y.d(d.this.f39559h, d.this.f39558g.f39568i, d.this.f39558g.f39566g, d.this.f39558g.q);
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
            if (d.this.f39556e != null) {
                d.this.f39556e.a();
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            boolean z = true;
            if (d.this.f39553b.s()) {
                i2 = 0;
            } else if (d.this.o) {
                d.this.o = false;
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (d.this.f39556e != null) {
                if (i2 == 0 || i2 == 1) {
                    d.this.M(i2);
                } else {
                    z = false;
                }
                if (d.this.f39556e.d()) {
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
        this.f39559h = context;
        this.f39552a = viewGroup;
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f39555d = aVar;
        aVar.j(new a());
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f39553b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b());
        this.f39553b.setContentViewCallback(new c());
        View view = new View(this.f39559h);
        this.f39554c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        if (y.p(i2)) {
            this.f39557f.l(aVar, i2);
        }
    }

    public void B() {
        C();
        this.f39560i = false;
    }

    public final void C() {
        this.f39555d.i();
        this.f39553b.x();
        this.f39552a.removeView(this.f39553b);
        this.f39552a.removeView(this.f39554c);
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView = this.f39553b;
        if (videoPasterContentView != null) {
            videoPasterContentView.z(i2);
        }
    }

    public void E() {
        this.f39553b.A();
        if (s()) {
            int curDuration = this.f39553b.getCurDuration();
            this.k = curDuration;
            this.m = curDuration;
            this.f39557f.h(q());
        }
    }

    public void F(boolean z) {
        this.p = z;
    }

    public void G(InterfaceC0517d interfaceC0517d) {
        this.f39556e = interfaceC0517d;
    }

    public final boolean H() {
        VideoPasterContentView videoPasterContentView = this.f39553b;
        if (videoPasterContentView != null) {
            int[] iArr = new int[2];
            videoPasterContentView.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.f39559h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public boolean I(boolean z, boolean z2, String str) {
        if (this.f39555d.f()) {
            return false;
        }
        this.f39560i = z2;
        this.j = str;
        VideoPasterResponseData e2 = this.f39555d.e();
        if (e2 == null) {
            return false;
        }
        d.a.d.m.e.a pasterData = e2.getPasterData();
        if (pasterData == null) {
            this.f39555d.i();
            return false;
        } else if (pasterData.c()) {
            this.f39557f.i(q());
            this.f39555d.i();
            return false;
        } else if (!pasterData.d()) {
            this.f39555d.i();
            return false;
        } else {
            this.f39552a.removeView(this.f39554c);
            this.f39552a.addView(this.f39554c);
            this.f39552a.removeView(this.f39553b);
            this.f39552a.addView(this.f39553b);
            ViewGroup viewGroup = this.f39552a;
            if (viewGroup instanceof FrameLayout) {
                this.f39553b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f39553b.setLayoutParams(layoutParams);
            }
            this.f39553b.setData(pasterData);
            this.k = this.f39553b.getCurDuration();
            if (!r()) {
                this.f39557f.i(q());
                d.a.n0.k1.o.h.c.g(this.f39558g);
            }
            this.f39553b.E(z, z2, str);
            InterfaceC0517d interfaceC0517d = this.f39556e;
            if (interfaceC0517d != null) {
                interfaceC0517d.c();
                return true;
            }
            return true;
        }
    }

    public void J() {
        VideoPasterContentView videoPasterContentView = this.f39553b;
        if (videoPasterContentView != null) {
            videoPasterContentView.B();
        }
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2 = this.f39555d;
        if (aVar2 == null || aVar2.f() || this.f39555d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f39555d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        this.l = this.f39553b.getCurDuration();
        if (s() && !H()) {
            this.f39557f.g(q());
        }
        this.f39553b.D();
    }

    public final void M(int i2) {
        this.f39557f.c(q(), i2);
        if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
            this.f39557f.g(q());
        }
    }

    public boolean a() {
        return this.f39560i;
    }

    public d.a.d.m.g.a q() {
        d.a.d.m.g.a aVar = new d.a.d.m.g.a();
        aVar.f39585g = this.k;
        aVar.f39583e = this.f39553b.getTotalDuration();
        aVar.f39584f = this.f39553b.getCurDuration();
        aVar.f39581c = this.n;
        if (UtilHelper.getRealScreenOrientation(this.f39559h) == 1) {
            aVar.f39586h = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.f39559h) == 2) {
            aVar.f39586h = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.f39559h) == 0) {
            aVar.f39586h = 2;
        } else {
            aVar.f39586h = -1;
        }
        d.a.d.m.e.a aVar2 = this.f39558g;
        if (aVar2 != null) {
            aVar.f39587i = aVar2.a();
            d.a.d.m.e.a aVar3 = this.f39558g;
            aVar.j = aVar3.f39565f;
            aVar.f39582d = aVar3.q;
            aVar.k = aVar3.s;
            aVar.l = aVar3.t;
        }
        return aVar;
    }

    public boolean r() {
        return this.f39553b.q();
    }

    public boolean s() {
        return this.f39553b.r();
    }

    public boolean t() {
        VideoPasterContentView videoPasterContentView = this.f39553b;
        return videoPasterContentView != null && videoPasterContentView.t();
    }

    public final void u() {
        C();
        InterfaceC0517d interfaceC0517d = this.f39556e;
        if (interfaceC0517d != null) {
            interfaceC0517d.a();
        }
    }

    public final void v() {
        this.f39557f.f(q());
        C();
    }

    public void w() {
        this.f39555d.h();
    }

    public void x() {
        VideoPasterContentView videoPasterContentView = this.f39553b;
        if (videoPasterContentView != null) {
            videoPasterContentView.v();
        }
    }

    public void y() {
        VideoPasterContentView videoPasterContentView = this.f39553b;
        if (videoPasterContentView != null) {
            videoPasterContentView.w();
        }
    }

    public final void z(d.a.d.m.e.a aVar) {
        if (aVar == null || !aVar.r) {
            return;
        }
        this.f39557f.d(q());
    }
}
