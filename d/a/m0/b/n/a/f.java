package d.a.m0.b.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.a;
import d.a.m0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50117f;

        public a(CallbackHandler callbackHandler, String str) {
            this.f50116e = callbackHandler;
            this.f50117f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.f fVar) {
            if (fVar == null || fVar.f45481d) {
                f.this.n(false, null, this.f50116e, this.f50117f, 10005, "system deny");
                k.p(10005, fVar);
                return;
            }
            f.this.p(fVar, this.f50116e, this.f50117f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.e2.c.f f50119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50120f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50121g;

        public b(d.a.m0.a.e2.c.f fVar, CallbackHandler callbackHandler, String str) {
            this.f50119e = fVar;
            this.f50120f = callbackHandler;
            this.f50121g = str;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (a0.f44733b) {
                Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i2);
            }
            if (i2 == -2) {
                f.this.n(false, null, this.f50120f, this.f50121g, 20050002, "user did cancel login");
            } else if (i2 != 0) {
                f.this.n(false, null, this.f50120f, this.f50121g, 20050003, "user fail to login");
            } else {
                f.this.o(this.f50119e.f45480c, d.a.m0.a.g1.f.V().getActivity(), this.f50120f, this.f50121g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.v2.e1.b<i<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50124f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f50123e = callbackHandler;
            this.f50124f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<a.b> iVar) {
            a.b bVar;
            if (iVar == null || !iVar.c() || (bVar = iVar.f45520a) == null || bVar.f45525c == null) {
                f.this.n(true, null, this.f50123e, this.f50124f, 20050004, "user fail to get mobile information");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", iVar.f45520a.f45525c.optString("data"));
                jSONObject.put("iv", iVar.f45520a.f45525c.optString("iv"));
                f.this.n(true, jSONObject, this.f50123e, this.f50124f, 0, "success");
            } catch (JSONException unused) {
            }
        }
    }

    public f(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumberByLogin");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
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
        d.a.m0.a.m.b j = d.a.m0.a.a2.d.g().r().j();
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
            d.a.m0.a.e2.c.j.a a2 = d.a.m0.a.a2.d.g().y().a().b().a(fragmentActivity, z, "login_with_mobile", null);
            a2.p(new c(callbackHandler, str));
            a2.a();
            return;
        }
        n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
    }

    public final void p(d.a.m0.a.e2.c.f fVar, CallbackHandler callbackHandler, String str) {
        new d.a.m0.b.n.d.a().h(new b(fVar, callbackHandler, str));
    }
}
