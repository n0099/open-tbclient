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
/* loaded from: classes3.dex */
public class c extends e {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f44935f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f44936g;

        public a(CallbackHandler callbackHandler, d dVar, d.a.l0.a.p.e.b bVar) {
            this.f44934e = callbackHandler;
            this.f44935f = dVar;
            this.f44936g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.p(iVar, this.f44934e, this.f44935f.f44524i);
                this.f44935f.o = null;
            } else {
                d dVar = this.f44935f;
                dVar.q = false;
                c.this.m(this.f44934e, (SwanAppSlaveManager) this.f44936g, dVar);
            }
            if (this.f44936g.X(this.f44935f)) {
                return;
            }
            d.a.l0.a.e0.d.b("updateWebView", "update webview widget fail");
            this.f44934e.handleSchemeDispatchCallback(this.f44935f.f44524i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public c(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/updateWebView");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("UpdateWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.a.l0.a.e0.d.b("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.a.l0.a.e0.d.b("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.a.l0.a.p.e.b bVar = (d.a.l0.a.p.e.b) d.a.l0.a.g1.f.V().B(h2.f44522g);
            if (bVar == null) {
                d.a.l0.a.e0.d.b("updateWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.T().g(context, "scope_webview_extra_operation", new a(callbackHandler, h2, bVar));
            } else if (!bVar.X(h2)) {
                d.a.l0.a.e0.d.b("updateWebView", "update webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
