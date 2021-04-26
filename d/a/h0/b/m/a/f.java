package d.a.h0.b.m.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45531e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45532f;

        public a(CallbackHandler callbackHandler, String str) {
            this.f45531e = callbackHandler;
            this.f45532f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.e eVar) {
            if (eVar == null || eVar.f44913d) {
                f.this.n(false, null, this.f45531e, this.f45532f, 10005, "system deny");
                d.a.h0.a.z1.h.q(10005, eVar);
                return;
            }
            f.this.p(eVar, this.f45531e, this.f45532f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.c.e f45534e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45535f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45536g;

        public b(d.a.h0.a.v1.c.e eVar, CallbackHandler callbackHandler, String str) {
            this.f45534e = eVar;
            this.f45535f = callbackHandler;
            this.f45536g = str;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (a0.f44398b) {
                Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i2);
            }
            if (i2 == -2) {
                f.this.n(false, null, this.f45535f, this.f45536g, 20050002, "user did cancel login");
            } else if (i2 != 0) {
                f.this.n(false, null, this.f45535f, this.f45536g, 20050003, "user fail to login");
            } else {
                f.this.o(this.f45534e.f44912c, d.a.h0.a.z0.f.V().getActivity(), this.f45535f, this.f45536g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45538e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45539f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f45538e = callbackHandler;
            this.f45539f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<a.b> hVar) {
            a.b bVar;
            if (hVar == null || !hVar.c() || (bVar = hVar.f44952a) == null || bVar.f44957c == null) {
                f.this.n(true, null, this.f45538e, this.f45539f, 20050004, "user fail to get mobile information");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", hVar.f44952a.f44957c.optString("data"));
                jSONObject.put("iv", hVar.f44952a.f44957c.optString("iv"));
                f.this.n(true, jSONObject, this.f45538e, this.f45539f, 0, "success");
            } catch (JSONException unused) {
            }
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumberByLogin");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty params");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        d.a.h0.a.m.b i2 = d.a.h0.a.r1.d.e().p().i();
        if (i2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
            return false;
        }
        if (i2.e(context)) {
            n(true, null, callbackHandler, optString, 20050001, "user already login");
        } else {
            eVar.R().e("login_with_mobile", new a(callbackHandler, optString));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void n(boolean z, JSONObject jSONObject, CallbackHandler callbackHandler, String str, int i2, String str2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("loginState", z);
            if (jSONObject != null) {
                jSONObject2.put("mobile", jSONObject);
            }
            jSONObject3 = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, i2, str2);
        } catch (JSONException unused) {
        }
        callbackHandler.handleSchemeDispatchCallback(str, jSONObject3.toString());
    }

    public final void o(boolean z, FragmentActivity fragmentActivity, CallbackHandler callbackHandler, String str) {
        if (z) {
            d.a.h0.a.v1.c.i.a a2 = d.a.h0.a.r1.d.e().w().a().b().a(fragmentActivity, z, "login_with_mobile", null);
            a2.p(new c(callbackHandler, str));
            a2.a();
            return;
        }
        n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
    }

    public final void p(d.a.h0.a.v1.c.e eVar, CallbackHandler callbackHandler, String str) {
        new d.a.h0.b.m.d.a().h(new b(eVar, callbackHandler, str));
    }
}
