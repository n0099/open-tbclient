package d.a.l0.a.c2.f.f0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.k;
import d.a.l0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f40989c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40990d;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f40993g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f40994h;

        public a(CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
            this.f40991e = callbackHandler;
            this.f40992f = str;
            this.f40993g = eVar;
            this.f40994h = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.p(iVar, this.f40991e, this.f40992f);
                b.this.l(this.f40993g, this.f40994h, this.f40991e, this.f40992f);
                return;
            }
            b.this.k(this.f40993g, this.f40994h, this.f40991e, this.f40992f);
        }
    }

    public b(d.a.l0.a.c2.e eVar, String str) {
        super(eVar, str);
        this.f40989c = null;
        this.f40990d = false;
    }

    public static void m(String str, String str2, String str3) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        b.a L = Q.L();
        eVar.f43185a = k.m(L.G());
        eVar.f43189e = str3;
        eVar.f43186b = DI.BD.FAVOR;
        eVar.f43190f = Q.D();
        SwanCoreVersion i0 = L.i0();
        String O = Q.O();
        String str4 = i0 != null ? i0.swanCoreVersionName : "";
        eVar.a("appName", O);
        eVar.a("isFavor", str);
        eVar.a("favorBy", str2);
        eVar.a("swan", str4);
        d.a.l0.a.j2.b.i("2571", "89", eVar.f());
    }

    @Override // d.a.l0.a.c2.f.a0
    public final boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.b("favorite", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
        String optString = d2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("favorite", "none cb");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.f40990d = d2.optBoolean("isFavorButton", false);
        if (!j(eVar, unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
            return false;
        }
        String optString2 = d2.optString("slaveId");
        String U = d.a.l0.a.g1.f.V().U();
        if (TextUtils.equals(optString2, d.a.l0.a.g1.f.V().D()) && (TextUtils.equals(U, "pages/swan-news-showcase/index") || TextUtils.equals(U, "pages/swan-operate-news/index"))) {
            k(eVar, unitedSchemeEntity, callbackHandler, optString);
        } else if (!o(unitedSchemeEntity)) {
            eVar.T().g(context, this.f40990d ? "scope_favorite_button" : "mapp_favorite", new a(callbackHandler, optString, eVar, unitedSchemeEntity));
        } else {
            k(eVar, unitedSchemeEntity, callbackHandler, optString);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public abstract boolean j(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public void l(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
    }

    public void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", "0");
        } catch (JSONException e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    public boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        return false;
    }
}
