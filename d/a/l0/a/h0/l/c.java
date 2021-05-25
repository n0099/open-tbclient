package d.a.l0.a.h0.l;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class c extends SwanAppWebViewManager implements Object<NgWebView>, a {
    public static final boolean B = k.f43199a;
    public final String A;

    public c(Context context) {
        super(context);
        this.A = d.a.l0.a.h0.l.g.e.b();
    }

    @Override // d.a.l0.a.h0.l.a
    public void D(d.a.l0.a.h0.u.a aVar) {
        if (aVar == null) {
            return;
        }
        if (B) {
            Log.d("SwanAppMasterManager", "pathList item: " + aVar.f42602b);
        }
        this.f10704f.getSettings().setCodeCacheSetting(d.a.l0.a.h0.d.b.a("appjs", aVar.f42602b));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public String b() {
        return this.A;
    }

    @Override // d.a.l0.a.h0.l.a
    public d.a.l0.a.h0.f.a g() {
        return u();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void onJSLoaded() {
        g.N().m0(true);
    }

    @Override // d.a.l0.a.h0.l.a
    public void r(int i2) {
    }
}
