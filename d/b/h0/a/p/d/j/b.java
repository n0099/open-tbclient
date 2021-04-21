package d.b.h0.a.p.d.j;

import android.content.Context;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.swan.games.view.webview.GameWebViewManager;
import d.b.h0.a.p.c.a1;
import d.b.h0.a.p.d.e;
import d.b.h0.a.p.d.f;
import d.b.h0.a.r.a.i;
import d.b.h0.g.f.h;
/* loaded from: classes2.dex */
public class b implements a1 {
    @Override // d.b.h0.a.p.c.a1
    public e a(Context context) {
        return new i(context);
    }

    @Override // d.b.h0.a.p.c.a1
    public f b(Context context) {
        return new GameWebViewManager(context);
    }

    @Override // d.b.h0.a.p.c.a1
    public d.b.h0.a.p.d.a c(Context context) {
        return new d.b.h0.a.e0.j.d(context);
    }

    @Override // d.b.h0.a.p.c.a1
    public d.b.h0.a.p.d.a d(Context context) {
        return new h(context);
    }

    @Override // d.b.h0.a.p.c.a1
    public e e(Context context) {
        return new d.b.h0.a.r.a.k.a.b(context);
    }

    @Override // d.b.h0.a.p.c.a1
    public d.b.h0.a.e0.o.a f(Context context, int i) {
        return new d.b.h0.a.e0.o.b().a(context, i);
    }

    @Override // d.b.h0.a.p.c.a1
    public d.b.h0.a.p.d.b g(Context context) {
        return new SwanAppSlaveManager(context);
    }

    @Override // d.b.h0.a.p.c.a1
    public e h(Context context) {
        return new SwanAppSimpleH5Widget(context);
    }

    public e i(Context context) {
        return new d.b.h0.a.q.e(context);
    }
}
