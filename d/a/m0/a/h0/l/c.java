package d.a.m0.a.h0.l;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class c extends SwanAppWebViewManager implements Object<NgWebView>, a {
    public static final boolean B = k.f46983a;
    public final String A;

    public c(Context context) {
        super(context);
        this.A = d.a.m0.a.h0.l.g.e.b();
    }

    @Override // d.a.m0.a.h0.l.a
    public void D(d.a.m0.a.h0.u.a aVar) {
        if (aVar == null) {
            return;
        }
        if (B) {
            Log.d("SwanAppMasterManager", "pathList item: " + aVar.f46386b);
        }
        this.f10848f.getSettings().setCodeCacheSetting(d.a.m0.a.h0.d.b.a("appjs", aVar.f46386b));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.m0.a.p.e.d
    public String b() {
        return this.A;
    }

    @Override // d.a.m0.a.h0.l.a
    public d.a.m0.a.h0.f.a g() {
        return u();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.m0.a.p.e.d
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.m0.a.p.e.d
    public void onJSLoaded() {
        g.N().m0(true);
    }

    @Override // d.a.m0.a.h0.l.a
    public void r(int i2) {
    }
}
