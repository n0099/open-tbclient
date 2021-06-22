package d.a.m0.a.s.a.k.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.h0.g.k;
import d.a.m0.a.p.e.e;
import d.a.m0.k.n;
/* loaded from: classes2.dex */
public class c extends k {

    /* loaded from: classes2.dex */
    public class a extends d.a.m0.a.h0.j.a {
        public a() {
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public boolean c(String str) {
            return super.c(str);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.m0.a.p.e.c] */
    @Override // d.a.m0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
        Q1(inflate);
        e m = m();
        this.C0 = m;
        m.Z(M2());
        this.D0 = this.C0.u();
        this.C0.loadUrl(this.E0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(f.aiapps_webView_container);
        this.C0.l(frameLayout, this.D0.covertToView());
        J2(frameLayout);
        return P1() ? S1(inflate) : inflate;
    }

    @Override // d.a.m0.a.h0.g.k, d.a.m0.a.h0.g.d
    public boolean K() {
        d.a.m0.a.p.e.c cVar = this.D0;
        if (cVar != null && cVar.canGoBack()) {
            this.D0.goBack();
            return true;
        }
        d.a().b(1);
        return false;
    }

    @Override // d.a.m0.a.h0.g.k
    public d.a.m0.a.h0.j.d M2() {
        return new a();
    }

    @Override // d.a.m0.a.h0.g.k
    public void N2() {
        FragmentActivity h2 = h();
        if (h2 == null || this.o0 != null) {
            return;
        }
        this.o0 = new n(h2, this.n0, T2(), d.a.m0.a.c1.a.G(), new d.a.m0.a.w2.h.b());
        new d.a.m0.a.j1.a(this.o0, this).z();
    }

    @Override // d.a.m0.a.h0.g.k, d.a.m0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        this.n0.setRightZoneVisibility(true);
    }

    public final int T2() {
        return Y1() ? 18 : 12;
    }

    @Override // d.a.m0.a.h0.g.k, d.a.m0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    @Override // d.a.m0.a.h0.g.k
    public e m() {
        return d.a.m0.a.h0.u.g.N().X().d(q());
    }
}
