package d.a.m0.a.h0.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.view.SwanAppActionBar;
import d.a.m0.a.h0.g.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends d.a.m0.a.h0.g.d {
    public static final boolean I0 = d.a.m0.a.k.f46983a;
    public d.a.m0.a.p.e.e C0;
    public d.a.m0.a.p.e.c D0;
    public String E0;
    public String F0;
    public String G0;
    public boolean H0 = true;

    /* loaded from: classes3.dex */
    public class a extends SwanAppWebViewWidget {
        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean R1() {
            return k.this.H0;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.h0.j.a {
        public b() {
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public void a(String str) {
            if (k.this.K2(str) && k.this.G0 != null) {
                k kVar = k.this;
                kVar.n0.setTitle(kVar.G0);
                return;
            }
            k.this.n0.setTitle(str);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.D0.canGoBack()) {
                k.this.D0.goBack();
            } else {
                k.this.c2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.l1.b f45884a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f45885b = new JSONObject();

        public d(String str) {
            this.f45884a = d.a.m0.a.l1.b.e(str, str);
        }

        public d a(boolean z) {
            try {
                this.f45885b.put("should_check_domain", z);
            } catch (JSONException e2) {
                if (k.I0) {
                    e2.printStackTrace();
                }
            }
            return this;
        }

        public void b() {
            this.f45884a.f47142f = this.f45885b.toString();
            k.Q2("default_webview", this.f45884a);
        }
    }

    public static boolean L2() {
        g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.e0.d.g("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        d.a.m0.a.e0.d.g("SwanAppWebViewFragment", "page closed! ");
        g.b h2 = W.h();
        h2.n(g.f45862i, g.f45861h);
        h2.g();
        h2.a();
        return true;
    }

    public static d O2(String str) {
        return new d(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static k P2(d.a.m0.a.l1.b bVar, String str) {
        char c2;
        k fVar;
        switch (str.hashCode()) {
            case -1750679182:
                if (str.equals("allianceLogin")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -130826522:
                if (str.equals("allianceChooseAddress")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 113553927:
                if (str.equals("wxPay")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 570452084:
                if (str.equals("adLanding")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1221126139:
                if (str.equals("default_webview")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1339472410:
                if (str.equals("qrCodePay")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            fVar = new d.a.m0.a.q1.f();
        } else if (c2 == 1) {
            fVar = new SwanAppAdLandingFragment();
        } else if (c2 == 2) {
            fVar = new k();
        } else if (c2 == 3) {
            fVar = new d.a.m0.a.s.a.e();
        } else if (c2 == 4) {
            fVar = new d.a.m0.a.s.a.k.a.c();
        } else if (c2 != 5) {
            if (I0) {
                Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
            }
            fVar = null;
        } else {
            fVar = new d.a.m0.a.q1.c();
        }
        if (fVar != null) {
            fVar.S2(bVar);
        }
        return fVar;
    }

    public static boolean Q2(String str, d.a.m0.a.l1.b bVar) {
        g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.e0.d.g("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        d.a.m0.a.e0.d.g("SwanAppWebViewFragment", "open page url=" + bVar.f47143g);
        g.b h2 = W.h();
        h2.n(g.f45860g, g.f45862i);
        h2.k(str, bVar).b();
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.m0.a.p.e.c] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.m0.a.g.aiapps_webview_fragment, viewGroup, false);
        Q1(inflate);
        d.a.m0.a.p.e.e m = m();
        this.C0 = m;
        m.Z(M2());
        this.D0 = this.C0.u();
        this.C0.loadUrl(this.E0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(d.a.m0.a.f.aiapps_webView_container);
        this.C0.l(frameLayout, this.D0.covertToView());
        J2(frameLayout);
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    public void J2(FrameLayout frameLayout) {
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean K() {
        d.a.m0.a.p.e.c cVar = this.D0;
        if (cVar == null || !cVar.canGoBack()) {
            return false;
        }
        this.D0.goBack();
        return true;
    }

    public final boolean K2(String str) {
        return TextUtils.equals(this.E0, str) || TextUtils.equals(this.E0.replace("http://", "").replace("https://", ""), str);
    }

    public d.a.m0.a.h0.j.d M2() {
        return new b();
    }

    public void N2() {
    }

    @Override // d.a.m0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        l2(-1);
        t2(-16777216);
        SwanAppActionBar swanAppActionBar = this.n0;
        String str = this.G0;
        if (str == null) {
            str = "";
        }
        swanAppActionBar.setTitle(str);
        this.n0.setRightZoneVisibility(false);
        p2(true);
        this.n0.setLeftBackViewClickListener(new c());
    }

    public final void R2() {
        Bundle n = n();
        if (n != null) {
            this.E0 = n.getString("url");
            String string = n.getString("params");
            this.F0 = string;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.F0);
                this.G0 = jSONObject.optString("fallback_title", null);
                this.H0 = jSONObject.optBoolean("should_check_domain", true);
            } catch (JSONException e2) {
                if (I0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void S2(d.a.m0.a.l1.b bVar) {
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", bVar.f47143g);
            bundle.putString("params", bVar.f47142f);
            j1(bundle);
        }
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public void e2() {
        this.C0.U();
        N2();
        this.o0.q(d.a.m0.a.c1.a.H().a(), E1());
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        d.a.m0.a.p.e.e eVar = this.C0;
        if (eVar != null) {
            return eVar.isSlidable(motionEvent);
        }
        return true;
    }

    public d.a.m0.a.p.e.e m() {
        return new a(q());
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        R2();
        if (I0) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        d.a.m0.a.p.e.e eVar = this.C0;
        if (eVar != null) {
            eVar.destroy();
            this.C0 = null;
        }
        super.onDestroy();
    }
}
