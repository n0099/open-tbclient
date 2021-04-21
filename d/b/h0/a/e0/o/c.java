package d.b.h0.a.e0.o;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import d.b.h0.a.e0.i.a;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class c extends SwanAppWebViewManager implements Object<NgWebView>, a {
    public static final boolean B = k.f45772a;
    public final String A;

    public c(Context context) {
        super(context);
        this.A = d.b.h0.a.e0.o.f.a.b();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void F0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.h0.a.p.d.d
    public String c() {
        return this.A;
    }

    @Override // d.b.h0.a.e0.o.a
    public d.b.h0.a.e0.k.a g() {
        return F();
    }

    @Override // d.b.h0.a.e0.o.a
    public void j(d.b.h0.a.e0.w.a aVar) {
        if (aVar != null && a.b.h(0)) {
            if (B) {
                Log.d("SwanAppMasterManager", "pathList item: " + aVar.f45031b);
            }
            this.f11823f.getSettings().setCodeCacheSetting(d.b.h0.a.e0.i.b.a("appjs", aVar.f45031b));
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.h0.a.p.d.d
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.h0.a.p.d.d
    public void onJSLoaded() {
        d.b.h0.a.e0.w.d.L().g0(true);
    }
}
