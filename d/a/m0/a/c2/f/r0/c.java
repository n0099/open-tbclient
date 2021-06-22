package d.a.m0.a.c2.f.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
/* loaded from: classes3.dex */
public class c extends e {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f45043f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f45044g;

        public a(CallbackHandler callbackHandler, d dVar, d.a.m0.a.p.e.b bVar) {
            this.f45042e = callbackHandler;
            this.f45043f = dVar;
            this.f45044g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.p(iVar, this.f45042e, this.f45043f.f44632i);
                this.f45043f.o = null;
            } else {
                d dVar = this.f45043f;
                dVar.q = false;
                c.this.m(this.f45042e, (SwanAppSlaveManager) this.f45044g, dVar);
            }
            if (this.f45044g.X(this.f45043f)) {
                return;
            }
            d.a.m0.a.e0.d.b("updateWebView", "update webview widget fail");
            this.f45042e.handleSchemeDispatchCallback(this.f45043f.f44632i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/updateWebView");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("UpdateWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.a.m0.a.e0.d.b("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.a.m0.a.e0.d.b("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.a.m0.a.p.e.b bVar = (d.a.m0.a.p.e.b) d.a.m0.a.g1.f.V().B(h2.f44630g);
            if (bVar == null) {
                d.a.m0.a.e0.d.b("updateWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.T().g(context, "scope_webview_extra_operation", new a(callbackHandler, h2, bVar));
            } else if (!bVar.X(h2)) {
                d.a.m0.a.e0.d.b("updateWebView", "update webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
