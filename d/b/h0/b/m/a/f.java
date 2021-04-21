package d.b.h0.b.m.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48088f;

        public a(CallbackHandler callbackHandler, String str) {
            this.f48087e = callbackHandler;
            this.f48088f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.e eVar) {
            if (eVar == null || eVar.f47492d) {
                f.this.n(false, null, this.f48087e, this.f48088f, 10005, "system deny");
                d.b.h0.a.z1.h.q(10005, eVar);
                return;
            }
            f.this.p(eVar, this.f48087e, this.f48088f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.v1.c.e f48090e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48091f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48092g;

        public b(d.b.h0.a.v1.c.e eVar, CallbackHandler callbackHandler, String str) {
            this.f48090e = eVar;
            this.f48091f = callbackHandler;
            this.f48092g = str;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (a0.f47009b) {
                Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i);
            }
            if (i == -2) {
                f.this.n(false, null, this.f48091f, this.f48092g, 20050002, "user did cancel login");
            } else if (i != 0) {
                f.this.n(false, null, this.f48091f, this.f48092g, 20050003, "user fail to login");
            } else {
                f.this.o(this.f48090e.f47491c, d.b.h0.a.z0.f.V().getActivity(), this.f48091f, this.f48092g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48095f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f48094e = callbackHandler;
            this.f48095f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<a.b> hVar) {
            a.b bVar;
            if (hVar == null || !hVar.c() || (bVar = hVar.f47529a) == null || bVar.f47534c == null) {
                f.this.n(true, null, this.f48094e, this.f48095f, 20050004, "user fail to get mobile information");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", hVar.f47529a.f47534c.optString("data"));
                jSONObject.put("iv", hVar.f47529a.f47534c.optString("iv"));
                f.this.n(true, jSONObject, this.f48094e, this.f48095f, 0, "success");
            } catch (JSONException unused) {
            }
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumberByLogin");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
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
        d.b.h0.a.m.b z = d.b.h0.a.r1.d.e().s().z();
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
            d.b.h0.a.v1.c.i.a a2 = d.b.h0.a.r1.d.e().o().a().a().a(fragmentActivity, z, "login_with_mobile", null);
            a2.p(new c(callbackHandler, str));
            a2.a();
            return;
        }
        n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
    }

    public final void p(d.b.h0.a.v1.c.e eVar, CallbackHandler callbackHandler, String str) {
        new d.b.h0.b.m.d.a().h(new b(eVar, callbackHandler, str));
    }
}
