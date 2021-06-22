package d.a.m0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45380e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45381f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f45382g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45383h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45384i;

        public a(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            this.f45380e = callbackHandler;
            this.f45381f = str;
            this.f45382g = activity;
            this.f45383h = str2;
            this.f45384i = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                if (a0.f44733b) {
                    Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                }
                c.this.m(this.f45380e, this.f45381f, this.f45382g, this.f45383h, this.f45384i);
                return;
            }
            d.a.m0.a.e0.d.h("SwanAppAction", "onCallback: no permission scope_mobile_api");
            k.O(this.f45384i, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no permission ");
            this.f45380e.handleSchemeDispatchCallback(this.f45381f, UnitedSchemeUtility.wrapCallbackParams(402).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45386f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45387g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45388h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45389i;
        public final /* synthetic */ String j;

        public b(Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3) {
            this.f45385e = activity;
            this.f45386f = z;
            this.f45387g = str;
            this.f45388h = callbackHandler;
            this.f45389i = str2;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.d.a aVar) {
            d.a.m0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            d.a.m0.a.a2.e c2 = c.this.c();
            if (!aVar.E()) {
                if (c2 != null && !c2.j().e(this.f45385e) && !this.f45386f) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 2, this.f45387g);
                }
                if (a0.f44733b) {
                    Log.i("SwanAppAction", "onCallback: no open datamobile");
                }
                d.a.m0.a.e2.c.d.m(aVar, this.f45388h, this.f45389i);
                k.O(this.j, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no open data");
                return;
            }
            d.a.m0.a.e0.d.h("SwanAppAction", "onCallback: got open datamobile");
            if (c2 != null && c2.j().e(this.f45385e) && !this.f45386f) {
                k.M("success", 2, this.f45387g);
            }
            k.N(this.j, "success");
            this.f45388h.handleSchemeDispatchCallback(this.f45389i, UnitedSchemeUtility.wrapCallbackParams(aVar.f45555g, 0).toString());
        }
    }

    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumber");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("invokeFrom");
        String str = optString.equals("component") ? "getPhoneNumberButton" : "getPhoneNumberApi";
        k.N(str, "create");
        String optString2 = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            k.O(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
            return false;
        }
        SwanAppActivity x = d.a.m0.a.a2.d.g().x();
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            k.O(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
            return false;
        }
        if (!eVar.j().e(context)) {
            k.M("show", 2, optString);
        }
        if (optParamsAsJo.optString("invokeFrom").equals(RetrieveTaskManager.KEY)) {
            n(callbackHandler, optString2, x, optString, str);
        } else {
            m(callbackHandler, optString2, x, optString, str);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void m(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        boolean e2 = d.a.m0.a.a2.d.g().r().j().e(activity);
        k.N(str3, "checkScope");
        d.a.m0.a.e2.d.a.C(activity, "mobile", null, false, str3, new b(activity, e2, str2, callbackHandler, str, str3));
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        k.N(str3, "checkScope");
        d.a.m0.a.a2.d.g().r().T().g(c(), "scope_mobile_api", new a(callbackHandler, str, activity, str2, str3));
    }
}
