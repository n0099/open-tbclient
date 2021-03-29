package d.b.g0.a.r.a.k.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.g0.a.e0.l.i;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.p.d.e;
import d.b.g0.i.n;
/* loaded from: classes2.dex */
public class c extends i {

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.a.e0.n.a {
        public a() {
        }

        @Override // d.b.g0.a.e0.n.a, d.b.g0.a.e0.n.d
        public boolean b(String str) {
            return super.b(str);
        }
    }

    @Override // d.b.g0.a.e0.l.i
    public d.b.g0.a.e0.n.d G2() {
        return new a();
    }

    @Override // d.b.g0.a.e0.l.i
    public void H2() {
        FragmentActivity f2 = f();
        if (f2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(f2, this.i0, N2(), d.b.g0.a.w0.a.y(), new d.b.g0.a.j2.g.b());
        new d.b.g0.a.c1.a(this.j0, this).z();
    }

    @Override // d.b.g0.a.e0.l.i, d.b.g0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        this.i0.setRightZoneVisibility(true);
    }

    public final int N2() {
        return U1() ? 18 : 12;
    }

    @Override // d.b.g0.a.e0.l.i, d.b.g0.a.e0.l.c
    public boolean T1() {
        return true;
    }

    @Override // d.b.g0.a.e0.l.i
    public e n() {
        return d.b.g0.a.e0.w.d.L().V().e(l());
    }

    @Override // d.b.g0.a.e0.l.i, d.b.g0.a.e0.l.c
    public boolean v() {
        d.b.g0.a.p.d.c cVar = this.z0;
        if (cVar != null && cVar.canGoBack()) {
            this.z0.goBack();
            return true;
        }
        d.a().b(1);
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.b.g0.a.p.d.c] */
    @Override // d.b.g0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
        M1(inflate);
        e n = n();
        this.y0 = n;
        n.P(G2());
        this.z0 = this.y0.getWebView();
        this.y0.loadUrl(this.A0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(f.aiapps_webView_container);
        this.y0.m(frameLayout, this.z0.covertToView());
        D2(frameLayout);
        return L1() ? O1(inflate) : inflate;
    }
}
