package d.a.h0.a.t1.k.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import d.a.h0.a.j0.j.b;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import h.d;
import h.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44497f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44498g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44499h;

        public a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            this.f44496e = callbackHandler;
            this.f44497f = str;
            this.f44498g = unitedSchemeEntity;
            this.f44499h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                b.this.m(this.f44498g, this.f44496e, this.f44499h, this.f44497f);
            } else {
                d.a.h0.a.v1.c.c.o(hVar, this.f44496e, this.f44497f);
            }
        }
    }

    /* renamed from: d.a.h0.a.t1.k.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0808b implements h.n.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0679b f44502f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44503g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44504h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44505i;

        public C0808b(b bVar, String str, b.C0679b c0679b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            this.f44501e = str;
            this.f44502f = c0679b;
            this.f44503g = callbackHandler;
            this.f44504h = unitedSchemeEntity;
            this.f44505i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            e h2;
            d.a.h0.a.n1.c.e.a x;
            if (bool.booleanValue()) {
                if (!TextUtils.isEmpty(this.f44501e) && (h2 = e.h()) != null && (x = h2.x()) != null) {
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(this.f44501e);
                    swanAppDeleteInfo.b(d.a.h0.a.j0.j.c.l(this.f44502f).c());
                    x.M(8, swanAppDeleteInfo);
                }
                d.a.h0.a.c0.c.g("history", "remove success");
                if (a0.f44398b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.f44501e);
                }
                UnitedSchemeUtility.safeCallback(this.f44503g, this.f44504h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f44505i);
                return;
            }
            d.a.h0.a.c0.c.l("history", "execute fail --- no match app id");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
            }
            UnitedSchemeUtility.safeCallback(this.f44503g, this.f44504h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f44505i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f<String, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0679b f44506e;

        public c(b bVar, b.C0679b c0679b) {
            this.f44506e = c0679b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            return Boolean.valueOf(d.a.h0.a.g0.d.b.g(AppRuntime.getAppContext().getContentResolver(), str, false, this.f44506e));
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/deleteHistory");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("history", "none swanApp");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.h0.a.c0.c.b("history", "empty joParams");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("history", "empty cb");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
            return false;
        }
        String optString2 = optParamsAsJo.optString("appid");
        if (TextUtils.isEmpty(optString2)) {
            d.a.h0.a.c0.c.b("history", "empty appId");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty appId");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
            return false;
        }
        eVar.R().g(context, "mapp_i_delete_history", new a(callbackHandler, optString, unitedSchemeEntity, optString2));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        d.a.h0.a.c0.c.g("history", "start remove history");
        d.a.h0.a.j0.j.c k = d.a.h0.a.j0.j.c.k();
        k.m(4);
        b.C0679b j = k.j();
        d.i(str).D(Schedulers.io()).k(new c(this, j)).o(h.l.b.a.b()).B(new C0808b(this, str, j, callbackHandler, unitedSchemeEntity, str2));
    }
}
