package d.a.h0.a.t1.k.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public class a extends e {

    /* renamed from: d.a.h0.a.t1.k.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0818a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f44680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p.d.b f44681g;

        public C0818a(CallbackHandler callbackHandler, d dVar, d.a.h0.a.p.d.b bVar) {
            this.f44679e = callbackHandler;
            this.f44680f = dVar;
            this.f44681g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.o(hVar, this.f44679e, this.f44680f.f41095i);
                this.f44680f.o = null;
            } else {
                d dVar = this.f44680f;
                dVar.q = false;
                a.this.m(this.f44679e, (SwanAppSlaveManager) this.f44681g, dVar);
            }
            if (this.f44681g.w(this.f44680f)) {
                a.this.o();
                return;
            }
            d.a.h0.a.c0.c.b("insertWebView", "insert webview widget fail");
            this.f44679e.handleSchemeDispatchCallback(this.f44680f.f41095i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/insertWebView");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.a.h0.a.c0.c.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(h2.n) && l(h2.n, h2.r)) {
            d.a.h0.a.c0.c.b("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            d.a.h0.a.p.d.b bVar = (d.a.h0.a.p.d.b) d.a.h0.a.z0.f.V().B(h2.f41093g);
            if (bVar == null) {
                d.a.h0.a.c0.c.b("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(h2.p, "quickPass")) {
                eVar.R().g(context, "scope_webview_extra_operation", new C0818a(callbackHandler, h2, bVar));
            } else if (!bVar.w(h2)) {
                d.a.h0.a.c0.c.b("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                o();
            }
            d.a.h0.a.c0.c.g("insertWebView", "insert webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    public final void o() {
        d.a.h0.a.e0.l.e o;
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null || (o = W.o()) == null) {
            return;
        }
        d.a.h0.a.c0.c.g("insertWebView", "disable navigationStyle custom");
        o.O2();
    }
}
