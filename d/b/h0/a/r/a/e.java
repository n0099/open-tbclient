package d.b.h0.a.r.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.h0.i.n;
/* loaded from: classes2.dex */
public class e extends d.b.h0.a.e0.l.i {

    /* loaded from: classes2.dex */
    public class a extends d.b.h0.a.e0.n.a {
        public a() {
        }

        @Override // d.b.h0.a.e0.n.a, d.b.h0.a.e0.n.d
        public boolean b(String str) {
            return super.b(str);
        }
    }

    @Override // d.b.h0.a.e0.l.i
    public d.b.h0.a.e0.n.d G2() {
        return new a();
    }

    @Override // d.b.h0.a.e0.l.i
    public void H2() {
        FragmentActivity f2 = f();
        if (f2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(f2, this.i0, O2(), d.b.h0.a.w0.a.y(), new d.b.h0.a.j2.g.b());
        new d.b.h0.a.c1.a(this.j0, this).z();
    }

    @Override // d.b.h0.a.e0.l.i, d.b.h0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        this.i0.setRightZoneVisibility(true);
    }

    public final void N2() {
        d.b.h0.a.m.a c2;
        if (f.f46418d.b() || (c2 = f.f46418d.c()) == null) {
            return;
        }
        c2.onResult(-2);
    }

    public final int O2() {
        return U1() ? 18 : 12;
    }

    @Override // d.b.h0.a.e0.l.i, d.b.h0.a.e0.l.c
    public boolean T1() {
        return true;
    }

    @Override // d.b.h0.a.e0.l.i
    public d.b.h0.a.p.d.e n() {
        return d.b.h0.a.e0.w.d.L().V().a(l());
    }

    @Override // d.b.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        N2();
        super.onDestroy();
    }

    @Override // d.b.h0.a.e0.l.i, d.b.h0.a.e0.l.c
    public boolean v() {
        d.b.h0.a.p.d.c cVar = this.z0;
        if (cVar != null && cVar.canGoBack()) {
            this.z0.goBack();
            return true;
        }
        N2();
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.b.h0.a.p.d.c] */
    @Override // d.b.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.h0.a.g.aiapps_webview_fragment, viewGroup, false);
        M1(inflate);
        d.b.h0.a.p.d.e n = n();
        this.y0 = n;
        n.P(G2());
        this.z0 = this.y0.F();
        this.y0.loadUrl(this.A0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(d.b.h0.a.f.aiapps_webView_container);
        this.y0.m(frameLayout, this.z0.covertToView());
        D2(frameLayout);
        return L1() ? O1(inflate) : inflate;
    }
}
