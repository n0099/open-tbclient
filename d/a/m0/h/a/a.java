package d.a.m0.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.h;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.p.b.a.n;
import d.a.m0.a.z1.b.f.e;
import d.a.m0.f.i.l.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements f {
    @Override // d.a.m0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        g W = d.a.m0.a.g1.f.V().W();
        Context appContext = AppRuntime.getAppContext();
        if (W == null) {
            if (appContext != null) {
                e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            return;
        }
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(str, str);
        e2.i(jSONObject.toString());
        g.b i2 = W.i("adLanding");
        i2.n(g.f45860g, g.f45862i);
        i2.k("adLanding", e2).b();
    }

    @Override // d.a.m0.f.i.l.f
    public boolean b() {
        return d.b();
    }

    @Override // d.a.m0.f.i.l.f
    public boolean c(View view) {
        return d.c(view);
    }

    @Override // d.a.m0.f.i.l.f
    public boolean d(View view, d.a.m0.f.i.i.a aVar) {
        return d.a(view, new d.a.m0.a.l1.e.a.a(aVar.d(), aVar.e(), aVar.f(), aVar.c()));
    }

    @Override // d.a.m0.f.i.l.f
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        if (b()) {
            SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            d.a.m0.a.g1.f.V().X().g(true);
        }
    }

    @Override // d.a.m0.f.i.l.f
    public boolean f(View view, d.a.m0.f.i.i.a aVar) {
        n X = d.a.m0.a.g1.f.V().X();
        return X != null && X.a(view, new d.a.m0.a.l1.e.a.a(aVar.d(), aVar.e(), aVar.f(), aVar.c()));
    }

    @Override // d.a.m0.f.i.l.f
    public boolean removeView(View view) {
        return d.d(view);
    }
}
