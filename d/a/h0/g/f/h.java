package d.a.h0.g.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.down.retry.HttpRetryStatistic;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class h extends d.a.h0.a.e0.j.d {
    public static final boolean E = k.f43101a;
    public View D;

    /* loaded from: classes3.dex */
    public class a extends d.a.h0.a.e0.g {
        public a(h hVar) {
        }

        @Override // d.a.h0.a.e0.g
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

    @Override // d.a.h0.a.e0.j.d, d.a.h0.a.p.d.a
    public void D() {
        i.h(false);
        this.D = null;
        super.D();
    }

    @Override // d.a.h0.a.e0.j.d, d.a.h0.a.p.d.a
    public void G(View view) {
        this.D = view;
    }

    @Override // d.a.h0.a.e0.j.d, d.a.h0.a.p.d.a
    public void P(boolean z) {
        if (s().getVisibility() == (z ? 0 : 8)) {
            return;
        }
        if (E) {
            Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
        }
        if (z) {
            d.a.h0.a.z0.f.V().o("console", c.c(true));
        }
        if (this.D != null) {
            this.D.setVisibility(z ? 4 : 0);
        }
        super.P(z);
    }

    @Override // d.a.h0.a.e0.j.d
    public void a1() {
        s().setVisibility(8);
        s().setBackgroundColor(0);
        i.c();
        c1();
        String i2 = d.m().i();
        if (E) {
            Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i2);
        }
        loadUrl(i2);
    }

    @Override // d.a.h0.a.e0.j.d, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public String c() {
        return "console";
    }

    public final void c1() {
        d(new a(this));
    }

    @Override // d.a.h0.a.e0.j.d, d.a.h0.a.p.d.a
    public void e0(String str, String str2) {
        i.g(str, str2);
    }
}
