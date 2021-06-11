package d.a.l0.h.o;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.a.l0.a.h0.m.l;
import d.a.l0.a.p.b.a.g;
import d.a.l0.h.s.a;
import java.io.File;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements g {
    @Override // d.a.l0.a.p.b.a.g
    public SwanCoreVersion n() {
        return c.m().s();
    }

    @Override // d.a.l0.a.p.b.a.g
    public d.a.l0.a.t0.c o(SwanAppActivity swanAppActivity, String str) {
        return new d(swanAppActivity, str);
    }

    @Override // d.a.l0.a.p.b.a.g
    public l p(d.a.l0.a.v2.e1.b<Exception> bVar) {
        return new d.a.l0.h.p.b.a(bVar);
    }

    @Override // d.a.l0.a.p.b.a.g
    public void q(Intent intent) {
        c.m().z(intent);
    }

    @Override // d.a.l0.a.p.b.a.g
    public View r(d.a.l0.a.h0.g.d dVar) {
        if (dVar instanceof d.a.l0.h.n.a) {
            return ((d.a.l0.h.n.a) dVar).h3();
        }
        return null;
    }

    @Override // d.a.l0.a.p.b.a.g
    public void release() {
        c.C();
    }

    @Override // d.a.l0.a.p.b.a.g
    public void s(V8ExceptionInfo v8ExceptionInfo) {
        DuMixGameSurfaceView r = c.m().r();
        if (r != null) {
            r.q(v8ExceptionInfo);
        }
    }

    @Override // d.a.l0.a.p.b.a.g
    public ExtensionCore t() {
        return c.m().k();
    }

    @Override // d.a.l0.a.p.b.a.g
    public d.a.l0.a.p0.d.b u() {
        return d.a.l0.h.m.a.i();
    }

    @Override // d.a.l0.a.p.b.a.g
    public int v(String str, long j) {
        d.a.l0.h.c0.a.a a2;
        if (TextUtils.isEmpty(str) || (a2 = d.a.l0.h.c0.a.a.a(d.a.l0.t.d.D(new File(a.d.h(str, String.valueOf(j)), "game.json")))) == null) {
            return 0;
        }
        return a2.f50931b;
    }

    @Override // d.a.l0.a.p.b.a.g
    public void w(String str, boolean z) {
        d.a.l0.h.l0.a.a().d(str, z);
    }
}
