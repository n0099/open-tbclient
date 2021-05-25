package d.a.l0.a.c2.f.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.d;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.n0.l.b;
import h.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41051e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41052f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41053g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41054h;

        public a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            this.f41051e = callbackHandler;
            this.f41052f = str;
            this.f41053g = unitedSchemeEntity;
            this.f41054h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.h(iVar)) {
                b.this.m(this.f41053g, this.f41051e, this.f41054h, this.f41052f);
            } else {
                d.p(iVar, this.f41051e, this.f41052f);
            }
        }
    }

    /* renamed from: d.a.l0.a.c2.f.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0582b implements h.n.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41056e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0763b f41057f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41058g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41059h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41060i;

        public C0582b(b bVar, String str, b.C0763b c0763b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            this.f41056e = str;
            this.f41057f = c0763b;
            this.f41058g = callbackHandler;
            this.f41059h = unitedSchemeEntity;
            this.f41060i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            e i2;
            d.a.l0.a.v1.c.e.a z;
            if (bool.booleanValue()) {
                if (!TextUtils.isEmpty(this.f41056e) && (i2 = e.i()) != null && (z = i2.z()) != null) {
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(this.f41056e);
                    swanAppDeleteInfo.b(d.a.l0.a.n0.l.c.m(this.f41057f).c());
                    z.O(8, swanAppDeleteInfo);
                }
                d.a.l0.a.e0.d.g("history", "remove success");
                if (a0.f40949b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.f41056e);
                }
                UnitedSchemeUtility.safeCallback(this.f41058g, this.f41059h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f41060i);
                return;
            }
            d.a.l0.a.e0.d.l("history", "execute fail --- no match app id");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
            }
            UnitedSchemeUtility.safeCallback(this.f41058g, this.f41059h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f41060i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f<String, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0763b f41061e;

        public c(b bVar, b.C0763b c0763b) {
            this.f41061e = c0763b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            return Boolean.valueOf(d.a.l0.a.j0.c.b.f(AppRuntime.getAppContext().getContentResolver(), str, false, this.f41061e));
        }
    }

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/deleteHistory");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.b("history", "none swanApp");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.l0.a.e0.d.b("history", "empty joParams");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("history", "empty cb");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
            return false;
        }
        String optString2 = optParamsAsJo.optString("appid");
        if (TextUtils.isEmpty(optString2)) {
            d.a.l0.a.e0.d.b("history", "empty appId");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty appId");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
            return false;
        }
        eVar.T().g(context, "mapp_i_delete_history", new a(callbackHandler, optString, unitedSchemeEntity, optString2));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        d.a.l0.a.e0.d.g("history", "start remove history");
        d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
        l.n(4);
        b.C0763b k = l.k();
        h.d.i(str).D(Schedulers.io()).k(new c(this, k)).o(h.l.b.a.b()).B(new C0582b(this, str, k, callbackHandler, unitedSchemeEntity, str2));
    }
}
