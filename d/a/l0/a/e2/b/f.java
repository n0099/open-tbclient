package d.a.l0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f41610e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41611f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41612g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f41613h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41614i;
        public final /* synthetic */ String j;

        public a(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            this.f41610e = z;
            this.f41611f = callbackHandler;
            this.f41612g = str;
            this.f41613h = activity;
            this.f41614i = str2;
            this.j = str3;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                f.this.k(this.f41610e, this.f41611f, this.f41612g, this.f41613h, this.f41614i, "snsapi_userinfo", this.j);
            } else {
                this.f41611f.handleSchemeDispatchCallback(this.f41612g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41615e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f41616f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41617g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41618h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41619i;

        public b(Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2) {
            this.f41615e = activity;
            this.f41616f = z;
            this.f41617g = str;
            this.f41618h = callbackHandler;
            this.f41619i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.d.a aVar) {
            d.a.l0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            d.a.l0.a.a2.e c2 = f.this.c();
            boolean e2 = c2 != null ? c2.j().e(this.f41615e) : false;
            if (!aVar.F()) {
                if (!e2 && !this.f41616f) {
                    k.M("fail", 3, this.f41617g);
                }
                d.a.l0.a.e2.c.d.m(aVar, this.f41618h, this.f41619i);
                return;
            }
            if (e2 && !this.f41616f) {
                k.M("success", 3, this.f41617g);
            }
            this.f41618h.handleSchemeDispatchCallback(this.f41619i, UnitedSchemeUtility.wrapCallbackParams(aVar.f41771g, 0).toString());
        }
    }

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getUserInfo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.a.l0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.a.l0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.a.l0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        }
        Activity x = context instanceof Activity ? (Activity) context : eVar.x();
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            d.a.l0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
            return false;
        }
        String optString2 = optParamsAsJo.optString("invokeFrom");
        if (!eVar.j().e(context)) {
            k.M("show", 3, optString2);
        }
        String f2 = d.a.l0.a.t1.g.b.f(optParamsAsJo.optString("__plugin__", null));
        d.a.l0.a.m.b j = eVar.j();
        boolean i2 = d.a.l0.a.e2.c.d.i(optParamsAsJo);
        if (!j.e(context) && i2) {
            j.f(x, null, new a(i2, callbackHandler, optString, x, f2, optString2));
        } else {
            k(i2, callbackHandler, optString, x, f2, "snsapi_userinfo", optString2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, String str4) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        d.a.l0.a.e2.d.a.C(activity, str3, str2, z, "getUserInfoApi", new b(activity, Q != null ? Q.j().e(activity) : false, str4, callbackHandler, str));
    }
}
