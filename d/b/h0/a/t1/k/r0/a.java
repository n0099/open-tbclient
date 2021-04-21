package d.b.h0.a.t1.k.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public class a extends e {

    /* renamed from: d.b.h0.a.t1.k.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0879a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f47273f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.p.d.b f47274g;

        public C0879a(CallbackHandler callbackHandler, d dVar, d.b.h0.a.p.d.b bVar) {
            this.f47272e = callbackHandler;
            this.f47273f = dVar;
            this.f47274g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                d.b.h0.a.v1.c.c.o(hVar, this.f47272e, this.f47273f.i);
                this.f47273f.o = null;
            } else {
                d dVar = this.f47273f;
                dVar.q = false;
                a.this.m(this.f47272e, (SwanAppSlaveManager) this.f47274g, dVar);
            }
            if (this.f47274g.V(this.f47273f)) {
                a.this.o();
                return;
            }
            d.b.h0.a.c0.c.b("insertWebView", "insert webview widget fail");
            this.f47272e.handleSchemeDispatchCallback(this.f47273f.i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/insertWebView");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.b.h0.a.c0.c.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.b.h0.a.c0.c.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.b.h0.a.p.d.b bVar = (d.b.h0.a.p.d.b) d.b.h0.a.z0.f.V().j(h2.f43835g);
            if (bVar == null) {
                d.b.h0.a.c0.c.b("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.R().g(context, "scope_webview_extra_operation", new C0879a(callbackHandler, h2, bVar));
            } else if (!bVar.V(h2)) {
                d.b.h0.a.c0.c.b("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                o();
            }
            d.b.h0.a.c0.c.g("insertWebView", "insert webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    public final void o() {
        d.b.h0.a.e0.l.e o;
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null || (o = W.o()) == null) {
            return;
        }
        d.b.h0.a.c0.c.g("insertWebView", "disable navigationStyle custom");
        o.P2();
    }
}
