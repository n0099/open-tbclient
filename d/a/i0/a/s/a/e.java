package d.a.i0.a.s.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.i0.a.h0.g.k;
import d.a.i0.k.n;
/* loaded from: classes2.dex */
public class e extends k {

    /* loaded from: classes2.dex */
    public class a extends d.a.i0.a.h0.j.a {
        public a() {
        }

        @Override // d.a.i0.a.h0.j.a, d.a.i0.a.h0.j.d
        public boolean c(String str) {
            return super.c(str);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.i0.a.p.e.c] */
    @Override // d.a.i0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.i0.a.g.aiapps_webview_fragment, viewGroup, false);
        Q1(inflate);
        d.a.i0.a.p.e.e m = m();
        this.x0 = m;
        m.Z(M2());
        this.y0 = this.x0.u();
        this.x0.loadUrl(this.z0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(d.a.i0.a.f.aiapps_webView_container);
        this.x0.l(frameLayout, this.y0.covertToView());
        J2(frameLayout);
        return P1() ? S1(inflate) : inflate;
    }

    @Override // d.a.i0.a.h0.g.k, d.a.i0.a.h0.g.d
    public boolean K() {
        d.a.i0.a.p.e.c cVar = this.y0;
        if (cVar != null && cVar.canGoBack()) {
            this.y0.goBack();
            return true;
        }
        T2();
        f.f44406d.a(g.d(), g.a());
        return false;
    }

    @Override // d.a.i0.a.h0.g.k
    public d.a.i0.a.h0.j.d M2() {
        return new a();
    }

    @Override // d.a.i0.a.h0.g.k
    public void N2() {
        FragmentActivity h2 = h();
        if (h2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(h2, this.i0, U2(), d.a.i0.a.c1.a.G(), new d.a.i0.a.w2.h.b());
        new d.a.i0.a.j1.a(this.j0, this).z();
    }

    @Override // d.a.i0.a.h0.g.k, d.a.i0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        this.i0.setRightZoneVisibility(true);
    }

    public final void T2() {
        d.a.i0.a.m.a d2;
        if (f.f44406d.c() || (d2 = f.f44406d.d()) == null) {
            return;
        }
        d2.onResult(-2);
    }

    public final int U2() {
        return Y1() ? 18 : 12;
    }

    @Override // d.a.i0.a.h0.g.k, d.a.i0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    @Override // d.a.i0.a.h0.g.k
    public d.a.i0.a.p.e.e m() {
        return d.a.i0.a.h0.u.g.N().X().c(q());
    }

    @Override // d.a.i0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        T2();
        super.onDestroy();
    }
}
