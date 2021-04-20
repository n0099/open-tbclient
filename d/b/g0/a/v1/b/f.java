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
        public final /* synthetic */ boolean f47085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47087g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f47088h;
        public final /* synthetic */ String i;

        public a(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2) {
            this.f47085e = z;
            this.f47086f = callbackHandler;
            this.f47087g = str;
            this.f47088h = activity;
            this.i = str2;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                f.this.k(this.f47085e, this.f47086f, this.f47087g, this.f47088h, this.i, "snsapi_userinfo");
            } else {
                this.f47086f.handleSchemeDispatchCallback(this.f47087g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47090f;

        public b(f fVar, CallbackHandler callbackHandler, String str) {
            this.f47089e = callbackHandler;
            this.f47090f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            d.b.g0.a.c0.c.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (!aVar.y()) {
                d.b.g0.a.v1.c.c.l(aVar, this.f47089e, this.f47090f);
            } else {
                this.f47089e.handleSchemeDispatchCallback(this.f47090f, UnitedSchemeUtility.wrapCallbackParams(aVar.f47231g, 0).toString());
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
