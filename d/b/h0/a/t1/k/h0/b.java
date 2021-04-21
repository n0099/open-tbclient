package d.b.h0.a.t1.k.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import d.b.h0.a.j0.j.b;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import h.d;
import h.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47106h;

        public a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            this.f47103e = callbackHandler;
            this.f47104f = str;
            this.f47105g = unitedSchemeEntity;
            this.f47106h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                b.this.m(this.f47105g, this.f47103e, this.f47106h, this.f47104f);
            } else {
                d.b.h0.a.v1.c.c.o(hVar, this.f47103e, this.f47104f);
            }
        }
    }

    /* renamed from: d.b.h0.a.t1.k.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0869b implements h.n.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47107e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0740b f47108f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47109g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47110h;
        public final /* synthetic */ String i;

        public C0869b(b bVar, String str, b.C0740b c0740b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            this.f47107e = str;
            this.f47108f = c0740b;
            this.f47109g = callbackHandler;
            this.f47110h = unitedSchemeEntity;
            this.i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            e y;
            d.b.h0.a.n1.c.e.a q;
            if (bool.booleanValue()) {
                if (!TextUtils.isEmpty(this.f47107e) && (y = e.y()) != null && (q = y.q()) != null) {
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(this.f47107e);
                    swanAppDeleteInfo.b(d.b.h0.a.j0.j.c.l(this.f47108f).c());
                    q.M(8, swanAppDeleteInfo);
                }
                d.b.h0.a.c0.c.g("history", "remove success");
                if (a0.f47009b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.f47107e);
                }
                UnitedSchemeUtility.safeCallback(this.f47109g, this.f47110h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.i);
                return;
            }
            d.b.h0.a.c0.c.l("history", "execute fail --- no match app id");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
            }
            UnitedSchemeUtility.safeCallback(this.f47109g, this.f47110h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f<String, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0740b f47111e;

        public c(b bVar, b.C0740b c0740b) {
            this.f47111e = c0740b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            return Boolean.valueOf(d.b.h0.a.g0.d.b.g(AppRuntime.getAppContext().getContentResolver(), str, false, this.f47111e));
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/deleteHistory");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("history", "none swanApp");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.h0.a.c0.c.b("history", "empty joParams");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("history", "empty cb");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
            return false;
        }
        String optString2 = optParamsAsJo.optString("appid");
        if (TextUtils.isEmpty(optString2)) {
            d.b.h0.a.c0.c.b("history", "empty appId");
            if (a0.f47009b) {
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
        d.b.h0.a.c0.c.g("history", "start remove history");
        d.b.h0.a.j0.j.c k = d.b.h0.a.j0.j.c.k();
        k.m(4);
        b.C0740b j = k.j();
        d.j(str).F(Schedulers.io()).l(new c(this, j)).p(h.l.b.a.b()).D(new C0869b(this, str, j, callbackHandler, unitedSchemeEntity, str2));
    }
}
