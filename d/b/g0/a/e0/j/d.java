package d.b.g0.a.e0.j;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import d.b.g0.a.i2.w;
import d.b.g0.a.k;
import d.b.g0.g.f.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends SwanAppWebViewManager implements d.b.g0.a.p.d.a<NgWebView> {
    public static final boolean C = k.f45051a;
    public Context A;
    public boolean B;

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.g.f.k.a {
        public a(d dVar) {
        }

        @Override // d.b.g0.g.f.k.a
        @NonNull
        public File a() {
            return d.b.g0.g.f.d.m().d();
        }

        @Override // d.b.g0.g.f.k.a
        public void b(@NonNull String str) {
            f.c(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.g.f.b {
        public b(d dVar) {
        }

        @Override // d.b.g0.g.f.b
        public void a(boolean z) {
            if (d.C) {
                Log.d("SwanAppConsoleManager", "download sConsole result: " + z);
            }
        }
    }

    public d(Context context) {
        super(context);
        this.B = false;
        this.A = context;
        Z0();
    }

    @Override // d.b.g0.a.p.d.a
    public void D(boolean z) {
        getWebView().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void E0() {
    }

    public final void I() {
        Context context = this.A;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        w.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
    }

    @Override // d.b.g0.a.p.d.a
    public void J() {
        D(getWebView().getVisibility() != 0);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void W() {
        super.W();
    }

    @Override // d.b.g0.a.p.d.a
    public void X(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        d.b.g0.a.z0.f.V().z("console", new d.b.g0.a.k0.b.b("searchboxSConsole", hashMap));
    }

    public final void X0(boolean z) {
        if (C) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.B || z) {
            d.b.g0.l.c.c(new d.b.g0.l.l.k.d("sconsole-core", f.a(), 2), new d.b.g0.g.f.j.a(new a(this), new b(this)));
            this.B = true;
        }
    }

    public final boolean Y0(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public void Z0() {
        getWebView().setVisibility(8);
        getWebView().setBackgroundColor(0);
        File file = new File(d.b.g0.g.f.d.m().d(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            X0(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.b();
        X0(true);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public String c() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void destroy() {
        I();
        super.destroy();
    }

    @Override // d.b.g0.a.p.d.a
    public void l() {
        d.b.g0.a.c0.c.k(false);
        ViewParent parent = getWebView().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(getWebView());
        }
        destroy();
    }

    public final void m(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || Y0(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // d.b.g0.a.p.d.a
    public void o(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        m(viewGroup, getWebView());
    }

    @Override // d.b.g0.a.p.d.a
    public void p(View view) {
    }
}
