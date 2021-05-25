package d.a.l0.a.s.a.k.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.h0.g.k;
import d.a.l0.a.p.e.e;
import d.a.l0.k.n;
/* loaded from: classes2.dex */
public class c extends k {

    /* loaded from: classes2.dex */
    public class a extends d.a.l0.a.h0.j.a {
        public a() {
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public boolean c(String str) {
            return super.c(str);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.l0.a.p.e.c] */
    @Override // d.a.l0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
        Q1(inflate);
        e m = m();
        this.x0 = m;
        m.Z(M2());
        this.y0 = this.x0.u();
        this.x0.loadUrl(this.z0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(f.aiapps_webView_container);
        this.x0.l(frameLayout, this.y0.covertToView());
        J2(frameLayout);
        return P1() ? S1(inflate) : inflate;
    }

    @Override // d.a.l0.a.h0.g.k, d.a.l0.a.h0.g.d
    public boolean K() {
        d.a.l0.a.p.e.c cVar = this.y0;
        if (cVar != null && cVar.canGoBack()) {
            this.y0.goBack();
            return true;
        }
        d.a().b(1);
        return false;
    }

    @Override // d.a.l0.a.h0.g.k
    public d.a.l0.a.h0.j.d M2() {
        return new a();
    }

    @Override // d.a.l0.a.h0.g.k
    public void N2() {
        FragmentActivity h2 = h();
        if (h2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(h2, this.i0, T2(), d.a.l0.a.c1.a.G(), new d.a.l0.a.w2.h.b());
        new d.a.l0.a.j1.a(this.j0, this).z();
    }

    @Override // d.a.l0.a.h0.g.k, d.a.l0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        this.i0.setRightZoneVisibility(true);
    }

    public final int T2() {
        return Y1() ? 18 : 12;
    }

    @Override // d.a.l0.a.h0.g.k, d.a.l0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    @Override // d.a.l0.a.h0.g.k
    public e m() {
        return d.a.l0.a.h0.u.g.N().X().d(q());
    }
}
