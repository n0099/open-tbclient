package d.a.m0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45395f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45396g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f45397h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45398i;
        public final /* synthetic */ String j;

        public a(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            this.f45394e = z;
            this.f45395f = callbackHandler;
            this.f45396g = str;
            this.f45397h = activity;
            this.f45398i = str2;
            this.j = str3;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                f.this.k(this.f45394e, this.f45395f, this.f45396g, this.f45397h, this.f45398i, "snsapi_userinfo", this.j);
            } else {
                this.f45395f.handleSchemeDispatchCallback(this.f45396g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45400f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45401g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45402h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45403i;

        public b(Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2) {
            this.f45399e = activity;
            this.f45400f = z;
            this.f45401g = str;
            this.f45402h = callbackHandler;
            this.f45403i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.d.a aVar) {
            d.a.m0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            d.a.m0.a.a2.e c2 = f.this.c();
            boolean e2 = c2 != null ? c2.j().e(this.f45399e) : false;
            if (!aVar.F()) {
                if (!e2 && !this.f45400f) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f45401g);
                }
                d.a.m0.a.e2.c.d.m(aVar, this.f45402h, this.f45403i);
                return;
            }
            if (e2 && !this.f45400f) {
                k.M("success", 3, this.f45401g);
            }
            this.f45402h.handleSchemeDispatchCallback(this.f45403i, UnitedSchemeUtility.wrapCallbackParams(aVar.f45555g, 0).toString());
        }
    }

    public f(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getUserInfo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.a.m0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.a.m0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.a.m0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        }
        Activity x = context instanceof Activity ? (Activity) context : eVar.x();
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            d.a.m0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
            return false;
        }
        String optString2 = optParamsAsJo.optString("invokeFrom");
        if (!eVar.j().e(context)) {
            k.M("show", 3, optString2);
        }
        String f2 = d.a.m0.a.t1.g.b.f(optParamsAsJo.optString("__plugin__", null));
        d.a.m0.a.m.b j = eVar.j();
        boolean i2 = d.a.m0.a.e2.c.d.i(optParamsAsJo);
        if (!j.e(context) && i2) {
            j.f(x, null, new a(i2, callbackHandler, optString, x, f2, optString2));
        } else {
            k(i2, callbackHandler, optString, x, f2, "snsapi_userinfo", optString2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, String str4) {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        d.a.m0.a.e2.d.a.C(activity, str3, str2, z, "getUserInfoApi", new b(activity, Q != null ? Q.j().e(activity) : false, str4, callbackHandler, str));
    }
}
