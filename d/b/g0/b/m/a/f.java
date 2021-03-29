package d.b.g0.b.m.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47367f;

        public a(CallbackHandler callbackHandler, String str) {
            this.f47366e = callbackHandler;
            this.f47367f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.e eVar) {
            if (eVar == null || eVar.f46771d) {
                f.this.n(false, null, this.f47366e, this.f47367f, 10005, "system deny");
                d.b.g0.a.z1.h.q(10005, eVar);
                return;
            }
            f.this.p(eVar, this.f47366e, this.f47367f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.c.e f47369e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47370f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47371g;

        public b(d.b.g0.a.v1.c.e eVar, CallbackHandler callbackHandler, String str) {
            this.f47369e = eVar;
            this.f47370f = callbackHandler;
            this.f47371g = str;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (a0.f46288b) {
                Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i);
            }
            if (i == -2) {
                f.this.n(false, null, this.f47370f, this.f47371g, 20050002, "user did cancel login");
            } else if (i != 0) {
                f.this.n(false, null, this.f47370f, this.f47371g, 20050003, "user fail to login");
            } else {
                f.this.o(this.f47369e.f46770c, d.b.g0.a.z0.f.V().getActivity(), this.f47370f, this.f47371g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47374f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f47373e = callbackHandler;
            this.f47374f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<a.b> hVar) {
            a.b bVar;
            if (hVar == null || !hVar.c() || (bVar = hVar.f46808a) == null || bVar.f46813c == null) {
                f.this.n(true, null, this.f47373e, this.f47374f, 20050004, "user fail to get mobile information");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", hVar.f46808a.f46813c.optString("data"));
                jSONObject.put("iv", hVar.f46808a.f46813c.optString("iv"));
                f.this.n(true, jSONObject, this.f47373e, this.f47374f, 0, "success");
            } catch (JSONException unused) {
            }
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumberByLogin");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
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
        d.b.g0.a.m.b z = d.b.g0.a.r1.d.e().s().z();
        if (z == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
            return false;
        }
        if (z.e(context)) {
            n(true, null, callbackHandler, optString, 20050001, "user already login");
        } else {
            eVar.R().e("login_with_mobile", new a(callbackHandler, optString));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void n(boolean z, JSONObject jSONObject, CallbackHandler callbackHandler, String str, int i, String str2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("loginState", z);
            if (jSONObject != null) {
                jSONObject2.put("mobile", jSONObject);
            }
            jSONObject3 = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, i, str2);
        } catch (JSONException unused) {
        }
        callbackHandler.handleSchemeDispatchCallback(str, jSONObject3.toString());
    }

    public final void o(boolean z, FragmentActivity fragmentActivity, CallbackHandler callbackHandler, String str) {
        if (z) {
            d.b.g0.a.v1.c.i.a a2 = d.b.g0.a.r1.d.e().o().a().a().a(fragmentActivity, z, "login_with_mobile", null);
            a2.p(new c(callbackHandler, str));
            a2.a();
            return;
        }
        n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
    }

    public final void p(d.b.g0.a.v1.c.e eVar, CallbackHandler callbackHandler, String str) {
        new d.b.g0.b.m.d.a().h(new b(eVar, callbackHandler, str));
    }
}
