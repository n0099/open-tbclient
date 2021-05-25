package d.a.l0.a.p.e.j;

import android.content.Context;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import d.a.l0.a.h0.k.f;
import d.a.l0.a.p.d.l1;
import d.a.l0.a.p.e.e;
import d.a.l0.a.s.a.i;
/* loaded from: classes2.dex */
public class b implements l1 {
    @Override // d.a.l0.a.p.d.l1
    public d.a.l0.a.p.e.a a(Context context) {
        return new d.a.l0.a.h0.e.d(context);
    }

    @Override // d.a.l0.a.p.d.l1
    public f b() {
        return new f();
    }

    @Override // d.a.l0.a.p.d.l1
    public e c(Context context) {
        return new i(context);
    }

    @Override // d.a.l0.a.p.d.l1
    public e d(Context context) {
        return new d.a.l0.a.s.a.k.a.b(context);
    }

    @Override // d.a.l0.a.p.d.l1
    public d.a.l0.a.h0.l.a e(Context context, int i2) {
        return new d.a.l0.a.h0.l.b().a(context, i2);
    }

    @Override // d.a.l0.a.p.d.l1
    public d.a.l0.a.p.e.b f(Context context) {
        return new SwanAppSlaveManager(context);
    }

    @Override // d.a.l0.a.p.d.l1
    public e g(Context context) {
        return new SwanAppSimpleH5Widget(context);
    }

    public e h(Context context) {
        return new d.a.l0.a.q.d(context);
    }
}
