package d.b.g0.g.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.down.retry.HttpRetryStatistic;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class h extends d.b.g0.a.e0.j.d {
    public static final boolean E = k.f45050a;
    public View D;

    /* loaded from: classes3.dex */
    public class a extends d.b.g0.a.e0.g {
        public a(h hVar) {
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (h.E) {
                Log.e("SwanGameConsoleManager", "onPageFinished");
            }
            i.a();
        }
    }

    public h(Context context) {
        super(context);
    }

    @Override // d.b.g0.a.e0.j.d, d.b.g0.a.p.d.a
    public void D(boolean z) {
        if (getWebView().getVisibility() == (z ? 0 : 8)) {
            return;
        }
        if (E) {
            Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
        }
        if (z) {
            d.b.g0.a.z0.f.V().z("console", c.c(true));
        }
        if (this.D != null) {
            this.D.setVisibility(z ? 4 : 0);
        }
        super.D(z);
    }

    @Override // d.b.g0.a.e0.j.d, d.b.g0.a.p.d.a
    public void X(String str, String str2) {
        i.g(str, str2);
    }

    @Override // d.b.g0.a.e0.j.d
    public void Z0() {
        getWebView().setVisibility(8);
        getWebView().setBackgroundColor(0);
        i.c();
        b1();
        String i = d.m().i();
        if (E) {
            Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i);
        }
        loadUrl(i);
    }

    public final void b1() {
        e(new a(this));
    }

    @Override // d.b.g0.a.e0.j.d, com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public String c() {
        return "console";
    }

    @Override // d.b.g0.a.e0.j.d, d.b.g0.a.p.d.a
    public void l() {
        i.h(false);
        this.D = null;
        super.l();
    }

    @Override // d.b.g0.a.e0.j.d, d.b.g0.a.p.d.a
    public void p(View view) {
        this.D = view;
    }
}
