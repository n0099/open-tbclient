package d.a.h0.a.e0.j;

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
import d.a.h0.a.i2.w;
import d.a.h0.a.k;
import d.a.h0.g.f.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends SwanAppWebViewManager implements d.a.h0.a.p.d.a<NgWebView> {
    public static final boolean C = k.f43101a;
    public Context A;
    public boolean B;

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.g.f.k.a {
        public a(d dVar) {
        }

        @Override // d.a.h0.g.f.k.a
        @NonNull
        public File a() {
            return d.a.h0.g.f.d.m().d();
        }

        @Override // d.a.h0.g.f.k.a
        public void b(@NonNull String str) {
            f.c(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.g.f.b {
        public b(d dVar) {
        }

        @Override // d.a.h0.g.f.b
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
        a1();
    }

    @Override // d.a.h0.a.p.d.a
    public void D() {
        d.a.h0.a.c0.c.k(false);
        ViewParent parent = s().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(s());
        }
        destroy();
    }

    @Override // d.a.h0.a.p.d.a
    public void E(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        k(viewGroup, s());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void F0() {
    }

    @Override // d.a.h0.a.p.d.a
    public void G(View view) {
    }

    @Override // d.a.h0.a.p.d.a
    public void P(boolean z) {
        s().setVisibility(z ? 0 : 8);
    }

    public final void R() {
        Context context = this.A;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        w.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
    }

    @Override // d.a.h0.a.p.d.a
    public void T() {
        P(s().getVisibility() != 0);
    }

    public final void Y0(boolean z) {
        if (C) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.B || z) {
            d.a.h0.l.c.c(new d.a.h0.l.l.k.d("sconsole-core", f.a(), 2), new d.a.h0.g.f.j.a(new a(this), new b(this)));
            this.B = true;
        }
    }

    public final boolean Z0(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (viewGroup.getChildAt(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public void a1() {
        s().setVisibility(8);
        s().setBackgroundColor(0);
        File file = new File(d.a.h0.g.f.d.m().d(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            Y0(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.b();
        Y0(true);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public String c() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void d0() {
        super.d0();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void destroy() {
        R();
        super.destroy();
    }

    @Override // d.a.h0.a.p.d.a
    public void e0(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        d.a.h0.a.z0.f.V().o("console", new d.a.h0.a.k0.b.b("searchboxSConsole", hashMap));
    }

    public final void k(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || Z0(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }
}
