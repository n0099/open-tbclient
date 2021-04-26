package d.a.h0.a.r.a.k.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.h0.a.e0.l.i;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.p.d.e;
import d.a.h0.i.n;
/* loaded from: classes2.dex */
public class c extends i {

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.a.e0.n.a {
        public a() {
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
        public boolean b(String str) {
            return super.b(str);
        }
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.e0.n.d F2() {
        return new a();
    }

    @Override // d.a.h0.a.e0.l.i
    public void G2() {
        FragmentActivity f2 = f();
        if (f2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(f2, this.i0, M2(), d.a.h0.a.w0.a.y(), new d.a.h0.a.j2.g.b());
        new d.a.h0.a.c1.a(this.j0, this).z();
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public boolean I() {
        d.a.h0.a.p.d.c cVar = this.z0;
        if (cVar != null && cVar.canGoBack()) {
            this.z0.goBack();
            return true;
        }
        d.a().b(1);
        return false;
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public void L1(View view) {
        super.L1(view);
        this.i0.setRightZoneVisibility(true);
    }

    public final int M2() {
        return T1() ? 18 : 12;
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public boolean S1() {
        return true;
    }

    @Override // d.a.h0.a.e0.l.i
    public e l() {
        return d.a.h0.a.e0.w.d.L().V().e(m());
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.h0.a.p.d.c] */
    @Override // d.a.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
        L1(inflate);
        e l = l();
        this.y0 = l;
        l.X(F2());
        this.z0 = this.y0.s();
        this.y0.loadUrl(this.A0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(f.aiapps_webView_container);
        this.y0.k(frameLayout, this.z0.covertToView());
        C2(frameLayout);
        return K1() ? N1(inflate) : inflate;
    }
}
