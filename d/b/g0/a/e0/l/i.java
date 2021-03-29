package d.b.g0.a.e0.l;

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
import d.b.g0.a.e0.l.f;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d.b.g0.a.e0.l.c {
    public static final boolean E0 = k.f45051a;
    public String A0;
    public String B0;
    public String C0;
    public boolean D0 = true;
    public d.b.g0.a.p.d.e y0;
    public d.b.g0.a.p.d.c z0;

    /* loaded from: classes2.dex */
    public class a extends SwanAppWebViewWidget {
        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean G1() {
            return i.this.D0;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.a.e0.n.a {
        public b() {
        }

        @Override // d.b.g0.a.e0.n.a, d.b.g0.a.e0.n.d
        public void a(String str) {
            if (i.this.E2(str) && i.this.C0 != null) {
                i iVar = i.this;
                iVar.i0.setTitle(iVar.C0);
                return;
            }
            i.this.i0.setTitle(str);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.z0.canGoBack()) {
                i.this.z0.goBack();
            } else {
                i.this.Y1();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.a.e1.b f44030a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f44031b = new JSONObject();

        public d(String str) {
            this.f44030a = d.b.g0.a.e1.b.c(str, str);
        }

        public d a(boolean z) {
            try {
                this.f44031b.put("should_check_domain", z);
            } catch (JSONException e2) {
                if (i.E0) {
                    e2.printStackTrace();
                }
            }
            return this;
        }

        public d b(String str) {
            try {
                this.f44031b.put("fallback_title", str);
            } catch (JSONException e2) {
                if (i.E0) {
                    e2.printStackTrace();
                }
            }
            return this;
        }

        public void c() {
            this.f44030a.f44363b = this.f44031b.toString();
            i.K2("default_webview", this.f44030a);
        }
    }

    public static boolean F2() {
        f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.g("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        d.b.g0.a.c0.c.g("SwanAppWebViewFragment", "page closed! ");
        f.b h2 = W.h();
        h2.n(f.i, f.f44014h);
        h2.g();
        h2.a();
        return true;
    }

    public static d I2(String str) {
        return new d(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static i J2(d.b.g0.a.e1.b bVar, String str) {
        char c2;
        i fVar;
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
            fVar = new d.b.g0.a.i1.f();
        } else if (c2 == 1) {
            fVar = new SwanAppAdLandingFragment();
        } else if (c2 == 2) {
            fVar = new i();
        } else if (c2 == 3) {
            fVar = new d.b.g0.a.r.a.e();
        } else if (c2 == 4) {
            fVar = new d.b.g0.a.r.a.k.a.c();
        } else if (c2 != 5) {
            if (E0) {
                Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
            }
            fVar = null;
        } else {
            fVar = new d.b.g0.a.i1.c();
        }
        if (fVar != null) {
            fVar.M2(bVar);
        }
        return fVar;
    }

    public static boolean K2(String str, d.b.g0.a.e1.b bVar) {
        f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.g("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        d.b.g0.a.c0.c.g("SwanAppWebViewFragment", "open page url=" + bVar.f44364c);
        f.b h2 = W.h();
        h2.n(f.f44013g, f.i);
        h2.k(str, bVar).b();
        return true;
    }

    public void D2(FrameLayout frameLayout) {
    }

    public final boolean E2(String str) {
        return TextUtils.equals(this.A0, str) || TextUtils.equals(this.A0.replace("http://", "").replace("https://", ""), str);
    }

    public d.b.g0.a.e0.n.d G2() {
        return new b();
    }

    public void H2() {
    }

    public final void L2() {
        Bundle j = j();
        if (j != null) {
            this.A0 = j.getString("url");
            String string = j.getString("params");
            this.B0 = string;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.B0);
                this.C0 = jSONObject.optString("fallback_title", null);
                this.D0 = jSONObject.optBoolean("should_check_domain", true);
            } catch (JSONException e2) {
                if (E0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        g2(-1);
        o2(-16777216);
        SwanAppActionBar swanAppActionBar = this.i0;
        String str = this.C0;
        if (str == null) {
            str = "";
        }
        swanAppActionBar.setTitle(str);
        this.i0.setRightZoneVisibility(false);
        k2(true);
        this.i0.setLeftBackViewClickListener(new c());
    }

    public void M2(d.b.g0.a.e1.b bVar) {
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", bVar.f44364c);
            bundle.putString("params", bVar.f44363b);
            d1(bundle);
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
        this.y0.I();
        H2();
        this.j0.q(d.b.g0.a.w0.a.z().a(), z1());
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        d.b.g0.a.p.d.e eVar = this.y0;
        if (eVar != null) {
            return eVar.isSlidable(motionEvent);
        }
        return true;
    }

    public d.b.g0.a.p.d.e n() {
        return new a(l());
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L2();
        if (E0) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        d.b.g0.a.p.d.e eVar = this.y0;
        if (eVar != null) {
            eVar.destroy();
            this.y0 = null;
        }
        super.onDestroy();
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        d.b.g0.a.p.d.c cVar = this.z0;
        if (cVar == null || !cVar.canGoBack()) {
            return false;
        }
        this.z0.goBack();
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.b.g0.a.p.d.c] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.g0.a.g.aiapps_webview_fragment, viewGroup, false);
        M1(inflate);
        d.b.g0.a.p.d.e n = n();
        this.y0 = n;
        n.P(G2());
        this.z0 = this.y0.getWebView();
        this.y0.loadUrl(this.A0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(d.b.g0.a.f.aiapps_webView_container);
        this.y0.m(frameLayout, this.z0.covertToView());
        D2(frameLayout);
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }
}
