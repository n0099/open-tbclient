package d.a.m0.a.q1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.m0.a.g;
import d.a.m0.a.h0.g.k;
import d.a.m0.a.v2.o0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends k {

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.a.h0.j.a {
        public a() {
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public boolean c(String str) {
            if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                Map<String, String> t = o0.t(o0.o(str));
                if (t != null && t.get("statusCode") != null) {
                    try {
                        e.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        e.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), null);
                    }
                } else {
                    e.a().onPayResult(6, null);
                }
                k.L2();
                return true;
            }
            return super.c(str);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [d.a.m0.a.p.e.c] */
    @Override // d.a.m0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
        inflate.findViewById(d.a.m0.a.f.ai_apps_title_bar_root).setVisibility(8);
        d.a.m0.a.p.e.e m = m();
        this.C0 = m;
        m.Z(M2());
        this.D0 = this.C0.u();
        this.C0.loadUrl(this.E0);
        this.C0.l((FrameLayout) inflate.findViewById(d.a.m0.a.f.aiapps_webView_container), this.D0.covertToView());
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    @Override // d.a.m0.a.h0.g.k
    public d.a.m0.a.h0.j.d M2() {
        return new a();
    }

    @Override // d.a.m0.a.h0.g.k
    public d.a.m0.a.p.e.e m() {
        return d.a.m0.a.h0.u.g.N().X().g(q());
    }
}
