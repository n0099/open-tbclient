package d.a.i0.b.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.a;
import d.a.i0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46158e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46159f;

        public a(CallbackHandler callbackHandler, String str) {
            this.f46158e = callbackHandler;
            this.f46159f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.f fVar) {
            if (fVar == null || fVar.f41523d) {
                f.this.n(false, null, this.f46158e, this.f46159f, 10005, "system deny");
                k.p(10005, fVar);
                return;
            }
            f.this.p(fVar, this.f46158e, this.f46159f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.e2.c.f f46161e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46162f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46163g;

        public b(d.a.i0.a.e2.c.f fVar, CallbackHandler callbackHandler, String str) {
            this.f46161e = fVar;
            this.f46162f = callbackHandler;
            this.f46163g = str;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (a0.f40775b) {
                Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i2);
            }
            if (i2 == -2) {
                f.this.n(false, null, this.f46162f, this.f46163g, 20050002, "user did cancel login");
            } else if (i2 != 0) {
                f.this.n(false, null, this.f46162f, this.f46163g, 20050003, "user fail to login");
            } else {
                f.this.o(this.f46161e.f41522c, d.a.i0.a.g1.f.V().getActivity(), this.f46162f, this.f46163g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.a.v2.e1.b<i<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46166f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f46165e = callbackHandler;
            this.f46166f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<a.b> iVar) {
            a.b bVar;
            if (iVar == null || !iVar.c() || (bVar = iVar.f41562a) == null || bVar.f41567c == null) {
                f.this.n(true, null, this.f46165e, this.f46166f, 20050004, "user fail to get mobile information");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", iVar.f41562a.f41567c.optString("data"));
                jSONObject.put("iv", iVar.f41562a.f41567c.optString("iv"));
                f.this.n(true, jSONObject, this.f46165e, this.f46166f, 0, "success");
            } catch (JSONException unused) {
            }
        }
    }

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumberByLogin");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
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
        d.a.i0.a.m.b j = d.a.i0.a.a2.d.g().r().j();
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
            return false;
        }
        if (j.e(context)) {
            n(true, null, callbackHandler, optString, 20050001, "user already login");
        } else {
            eVar.T().e("login_with_mobile", new a(callbackHandler, optString));
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
            d.a.i0.a.e2.c.j.a a2 = d.a.i0.a.a2.d.g().y().a().b().a(fragmentActivity, z, "login_with_mobile", null);
            a2.p(new c(callbackHandler, str));
            a2.a();
            return;
        }
        n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
    }

    public final void p(d.a.i0.a.e2.c.f fVar, CallbackHandler callbackHandler, String str) {
        new d.a.i0.b.n.d.a().h(new b(fVar, callbackHandler, str));
    }
}
