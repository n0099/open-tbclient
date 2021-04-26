package d.a.h0.a.i1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.h0.a.e0.l.i;
import d.a.h0.a.g;
import d.a.h0.a.i2.i0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends i {

    /* loaded from: classes3.dex */
    public class a extends d.a.h0.a.e0.n.a {
        public a() {
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
        public boolean b(String str) {
            if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                Map<String, String> r = i0.r(i0.n(str));
                if (r != null && r.get("statusCode") != null) {
                    try {
                        e.a().onPayResult(Integer.valueOf(r.get("statusCode")).intValue(), URLDecoder.decode(r.get("result"), "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        e.a().onPayResult(Integer.valueOf(r.get("statusCode")).intValue(), null);
                    }
                } else {
                    e.a().onPayResult(6, null);
                }
                i.E2();
                return true;
            }
            return super.b(str);
        }
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.e0.n.d F2() {
        return new a();
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.p.d.e l() {
        return d.a.h0.a.e0.w.d.L().V().h(m());
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [d.a.h0.a.p.d.c] */
    @Override // d.a.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
        inflate.findViewById(d.a.h0.a.f.ai_apps_title_bar_root).setVisibility(8);
        d.a.h0.a.p.d.e l = l();
        this.y0 = l;
        l.X(F2());
        this.z0 = this.y0.s();
        this.y0.loadUrl(this.A0);
        this.y0.k((FrameLayout) inflate.findViewById(d.a.h0.a.f.aiapps_webView_container), this.z0.covertToView());
        if (K1()) {
            inflate = N1(inflate);
        }
        return u1(inflate, this);
    }
}
