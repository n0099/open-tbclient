package d.a.i0.a.c2.f.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
/* loaded from: classes3.dex */
public class c extends e {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41084e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f41085f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f41086g;

        public a(CallbackHandler callbackHandler, d dVar, d.a.i0.a.p.e.b bVar) {
            this.f41084e = callbackHandler;
            this.f41085f = dVar;
            this.f41086g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.p(iVar, this.f41084e, this.f41085f.f40674i);
                this.f41085f.o = null;
            } else {
                d dVar = this.f41085f;
                dVar.q = false;
                c.this.m(this.f41084e, (SwanAppSlaveManager) this.f41086g, dVar);
            }
            if (this.f41086g.X(this.f41085f)) {
                return;
            }
            d.a.i0.a.e0.d.b("updateWebView", "update webview widget fail");
            this.f41084e.handleSchemeDispatchCallback(this.f41085f.f40674i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/updateWebView");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("UpdateWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.a.i0.a.e0.d.b("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.a.i0.a.e0.d.b("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.a.i0.a.p.e.b bVar = (d.a.i0.a.p.e.b) d.a.i0.a.g1.f.V().B(h2.f40672g);
            if (bVar == null) {
                d.a.i0.a.e0.d.b("updateWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.T().g(context, "scope_webview_extra_operation", new a(callbackHandler, h2, bVar));
            } else if (!bVar.X(h2)) {
                d.a.i0.a.e0.d.b("updateWebView", "update webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
