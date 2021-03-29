package d.b.g0.a.t1.k.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
/* loaded from: classes2.dex */
public class a extends e {

    /* renamed from: d.b.g0.a.t1.k.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0847a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f46552f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p.d.b f46553g;

        public C0847a(CallbackHandler callbackHandler, d dVar, d.b.g0.a.p.d.b bVar) {
            this.f46551e = callbackHandler;
            this.f46552f = dVar;
            this.f46553g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f46551e, this.f46552f.i);
                this.f46552f.o = null;
            } else {
                d dVar = this.f46552f;
                dVar.q = false;
                a.this.m(this.f46551e, (SwanAppSlaveManager) this.f46553g, dVar);
            }
            if (this.f46553g.U(this.f46552f)) {
                a.this.o();
                return;
            }
            d.b.g0.a.c0.c.b("insertWebView", "insert webview widget fail");
            this.f46551e.handleSchemeDispatchCallback(this.f46552f.i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/insertWebView");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.b.g0.a.c0.c.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.b.g0.a.c0.c.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.b.g0.a.p.d.b bVar = (d.b.g0.a.p.d.b) d.b.g0.a.z0.f.V().j(h2.f43114g);
            if (bVar == null) {
                d.b.g0.a.c0.c.b("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.R().g(context, "scope_webview_extra_operation", new C0847a(callbackHandler, h2, bVar));
            } else if (!bVar.U(h2)) {
                d.b.g0.a.c0.c.b("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                o();
            }
            d.b.g0.a.c0.c.g("insertWebView", "insert webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    public final void o() {
        d.b.g0.a.e0.l.e o;
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null || (o = W.o()) == null) {
            return;
        }
        d.b.g0.a.c0.c.g("insertWebView", "disable navigationStyle custom");
        o.P2();
    }
}
