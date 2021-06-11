package d.a.l0.a.c2.f.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.h0.g.g;
/* loaded from: classes3.dex */
public class a extends e {

    /* renamed from: d.a.l0.a.c2.f.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0647a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44930e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f44931f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f44932g;

        public C0647a(CallbackHandler callbackHandler, d dVar, d.a.l0.a.p.e.b bVar) {
            this.f44930e = callbackHandler;
            this.f44931f = dVar;
            this.f44932g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.p(iVar, this.f44930e, this.f44931f.f44524i);
                this.f44931f.o = null;
            } else {
                d dVar = this.f44931f;
                dVar.q = false;
                a.this.m(this.f44930e, (SwanAppSlaveManager) this.f44932g, dVar);
            }
            if (this.f44932g.y(this.f44931f)) {
                a.this.o();
                return;
            }
            d.a.l0.a.e0.d.b("insertWebView", "insert webview widget fail");
            this.f44930e.handleSchemeDispatchCallback(this.f44931f.f44524i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/insertWebView");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.a.l0.a.e0.d.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.a.l0.a.e0.d.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.a.l0.a.p.e.b bVar = (d.a.l0.a.p.e.b) d.a.l0.a.g1.f.V().B(h2.f44522g);
            if (bVar == null) {
                d.a.l0.a.e0.d.b("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.T().g(context, "scope_webview_extra_operation", new C0647a(callbackHandler, h2, bVar));
            } else if (!bVar.y(h2)) {
                d.a.l0.a.e0.d.b("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                o();
            }
            d.a.l0.a.e0.d.g("insertWebView", "insert webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    public final void o() {
        d.a.l0.a.h0.g.f o;
        g W = d.a.l0.a.g1.f.V().W();
        if (W == null || (o = W.o()) == null) {
            return;
        }
        d.a.l0.a.e0.d.g("insertWebView", "disable navigationStyle custom");
        o.X2();
    }
}
