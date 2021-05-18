package d.a.i0.a.h0.e;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.i0.a.e0.e;
import d.a.i0.a.k;
import d.a.i0.a.p.b.a.f;
import d.a.i0.a.v2.x;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends SwanAppWebViewManager implements d.a.i0.a.p.e.a<NgWebView> {
    public static final boolean C = k.f43025a;
    public Context A;
    public boolean B;

    public d(Context context) {
        super(context);
        this.B = false;
        this.A = context;
        g1();
    }

    @Override // d.a.i0.a.p.e.a
    public void E() {
        d.a.i0.a.e0.d.k(false);
        ViewParent parent = u().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(u());
        }
        destroy();
    }

    @Override // d.a.i0.a.p.e.a
    public void H(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        l(viewGroup, u());
    }

    @Override // d.a.i0.a.p.e.a
    public void I(View view) {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    @Override // d.a.i0.a.p.e.a
    public void R(boolean z) {
        u().setVisibility(z ? 0 : 8);
    }

    public final void V() {
        Context context = this.A;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
    }

    @Override // d.a.i0.a.p.e.a
    public void W() {
        R(u().getVisibility() != 0);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public String b() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public void destroy() {
        V();
        super.destroy();
    }

    public final void e1(boolean z) {
        if (C) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.B || z) {
            d.a.i0.n.i.m.d dVar = new d.a.i0.n.i.m.d("sconsole-core", e.c(), e.b(), 2);
            f h2 = d.a.i0.a.c1.b.h();
            d.a.i0.n.b.e(dVar, h2 != null ? h2.d() : null);
            this.B = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public void f0() {
        super.f0();
    }

    public final boolean f1(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (viewGroup.getChildAt(i2) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.i0.a.p.e.a
    public void g0(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        d.a.i0.a.g1.f.V().m("console", new d.a.i0.a.o0.d.b("searchboxSConsole", hashMap));
    }

    public void g1() {
        u().setVisibility(8);
        u().setBackgroundColor(0);
        File file = new File(e.a(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            e1(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        e.d();
        e1(true);
    }

    public final void l(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || f1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }
}
