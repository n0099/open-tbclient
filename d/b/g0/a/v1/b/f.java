package d.b.g0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46693f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46694g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f46695h;
        public final /* synthetic */ String i;

        public a(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2) {
            this.f46692e = z;
            this.f46693f = callbackHandler;
            this.f46694g = str;
            this.f46695h = activity;
            this.i = str2;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                f.this.k(this.f46692e, this.f46693f, this.f46694g, this.f46695h, this.i, "snsapi_userinfo");
            } else {
                this.f46693f.handleSchemeDispatchCallback(this.f46694g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46697f;

        public b(f fVar, CallbackHandler callbackHandler, String str) {
            this.f46696e = callbackHandler;
            this.f46697f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            d.b.g0.a.c0.c.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (!aVar.y()) {
                d.b.g0.a.v1.c.c.l(aVar, this.f46696e, this.f46697f);
            } else {
                this.f46696e.handleSchemeDispatchCallback(this.f46697f, UnitedSchemeUtility.wrapCallbackParams(aVar.f46838g, 0).toString());
            }
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/getUserInfo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.b.g0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.b.g0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.b.g0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        }
        Activity n = context instanceof Activity ? (Activity) context : eVar.n();
        if (n == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            d.b.g0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
            return false;
        }
        String e2 = d.b.g0.a.l1.g.b.e(optParamsAsJo.optString("__plugin__", null));
        d.b.g0.a.m.b z = eVar.z();
        boolean i = d.b.g0.a.v1.c.c.i(optParamsAsJo);
        if (!z.e(context) && i) {
            z.f(n, null, new a(i, callbackHandler, optString, n, e2));
        } else {
            k(i, callbackHandler, optString, n, e2, "snsapi_userinfo");
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        d.b.g0.a.v1.d.a.v(activity, str3, str2, z, new b(this, callbackHandler, str));
    }
}
