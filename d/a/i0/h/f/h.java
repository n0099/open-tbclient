package d.a.i0.h.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.down.retry.HttpRetryStatistic;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class h extends d.a.i0.a.h0.e.d {
    public static final boolean E = k.f43025a;
    public View D;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.a.h0.b {
        public a(h hVar) {
        }

        @Override // d.a.i0.a.h0.b
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

    @Override // d.a.i0.a.h0.e.d, d.a.i0.a.p.e.a
    public void E() {
        i.h(false);
        this.D = null;
        super.E();
    }

    @Override // d.a.i0.a.h0.e.d, d.a.i0.a.p.e.a
    public void I(View view) {
        this.D = view;
    }

    @Override // d.a.i0.a.h0.e.d, d.a.i0.a.p.e.a
    public void R(boolean z) {
        if (u().getVisibility() == (z ? 0 : 8)) {
            return;
        }
        if (E) {
            Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
        }
        if (z) {
            d.a.i0.a.g1.f.V().m("console", c.i(true));
        }
        if (this.D != null) {
            this.D.setVisibility(z ? 4 : 0);
        }
        super.R(z);
    }

    @Override // d.a.i0.a.h0.e.d, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public String b() {
        return "console";
    }

    @Override // d.a.i0.a.h0.e.d, d.a.i0.a.p.e.a
    public void g0(String str, String str2) {
        i.g(str, str2);
    }

    @Override // d.a.i0.a.h0.e.d
    public void g1() {
        u().setVisibility(8);
        u().setBackgroundColor(0);
        i.c();
        i1();
        String i2 = d.m().i();
        if (E) {
            Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i2);
        }
        loadUrl(i2);
    }

    public final void i1() {
        c(new a(this));
    }
}
