package d.a.i0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f41436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f41439h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41440i;
        public final /* synthetic */ String j;

        public a(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            this.f41436e = z;
            this.f41437f = callbackHandler;
            this.f41438g = str;
            this.f41439h = activity;
            this.f41440i = str2;
            this.j = str3;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                f.this.k(this.f41436e, this.f41437f, this.f41438g, this.f41439h, this.f41440i, "snsapi_userinfo", this.j);
            } else {
                this.f41437f.handleSchemeDispatchCallback(this.f41438g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f41442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41443g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41444h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41445i;

        public b(Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2) {
            this.f41441e = activity;
            this.f41442f = z;
            this.f41443g = str;
            this.f41444h = callbackHandler;
            this.f41445i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.d.a aVar) {
            d.a.i0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            d.a.i0.a.a2.e c2 = f.this.c();
            boolean e2 = c2 != null ? c2.j().e(this.f41441e) : false;
            if (!aVar.F()) {
                if (!e2 && !this.f41442f) {
                    k.M("fail", 3, this.f41443g);
                }
                d.a.i0.a.e2.c.d.m(aVar, this.f41444h, this.f41445i);
                return;
            }
            if (e2 && !this.f41442f) {
                k.M("success", 3, this.f41443g);
            }
            this.f41444h.handleSchemeDispatchCallback(this.f41445i, UnitedSchemeUtility.wrapCallbackParams(aVar.f41597g, 0).toString());
        }
    }

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getUserInfo");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.a.i0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.a.i0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.a.i0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        }
        Activity x = context instanceof Activity ? (Activity) context : eVar.x();
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            d.a.i0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
            return false;
        }
        String optString2 = optParamsAsJo.optString("invokeFrom");
        if (!eVar.j().e(context)) {
            k.M("show", 3, optString2);
        }
        String f2 = d.a.i0.a.t1.g.b.f(optParamsAsJo.optString("__plugin__", null));
        d.a.i0.a.m.b j = eVar.j();
        boolean i2 = d.a.i0.a.e2.c.d.i(optParamsAsJo);
        if (!j.e(context) && i2) {
            j.f(x, null, new a(i2, callbackHandler, optString, x, f2, optString2));
        } else {
            k(i2, callbackHandler, optString, x, f2, "snsapi_userinfo", optString2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, String str4) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        d.a.i0.a.e2.d.a.C(activity, str3, str2, z, "getUserInfoApi", new b(activity, Q != null ? Q.j().e(activity) : false, str4, callbackHandler, str));
    }
}
