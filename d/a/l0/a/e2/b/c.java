package d.a.l0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f41598g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41599h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41600i;

        public a(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            this.f41596e = callbackHandler;
            this.f41597f = str;
            this.f41598g = activity;
            this.f41599h = str2;
            this.f41600i = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                if (a0.f40949b) {
                    Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                }
                c.this.m(this.f41596e, this.f41597f, this.f41598g, this.f41599h, this.f41600i);
                return;
            }
            d.a.l0.a.e0.d.h("SwanAppAction", "onCallback: no permission scope_mobile_api");
            k.O(this.f41600i, "fail", "onCallback: no permission ");
            this.f41596e.handleSchemeDispatchCallback(this.f41597f, UnitedSchemeUtility.wrapCallbackParams(402).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f41602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41603g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41604h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41605i;
        public final /* synthetic */ String j;

        public b(Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3) {
            this.f41601e = activity;
            this.f41602f = z;
            this.f41603g = str;
            this.f41604h = callbackHandler;
            this.f41605i = str2;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.d.a aVar) {
            d.a.l0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            d.a.l0.a.a2.e c2 = c.this.c();
            if (!aVar.E()) {
                if (c2 != null && !c2.j().e(this.f41601e) && !this.f41602f) {
                    k.M("fail", 2, this.f41603g);
                }
                if (a0.f40949b) {
                    Log.i("SwanAppAction", "onCallback: no open datamobile");
                }
                d.a.l0.a.e2.c.d.m(aVar, this.f41604h, this.f41605i);
                k.O(this.j, "fail", "onCallback: no open data");
                return;
            }
            d.a.l0.a.e0.d.h("SwanAppAction", "onCallback: got open datamobile");
            if (c2 != null && c2.j().e(this.f41601e) && !this.f41602f) {
                k.M("success", 2, this.f41603g);
            }
            k.N(this.j, "success");
            this.f41604h.handleSchemeDispatchCallback(this.f41605i, UnitedSchemeUtility.wrapCallbackParams(aVar.f41771g, 0).toString());
        }
    }

    public c(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumber");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
            k.O(str, "fail", "empty cb");
            return false;
        }
        SwanAppActivity x = d.a.l0.a.a2.d.g().x();
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            k.O(str, "fail", "the context is not an activity");
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
        boolean e2 = d.a.l0.a.a2.d.g().r().j().e(activity);
        k.N(str3, "checkScope");
        d.a.l0.a.e2.d.a.C(activity, "mobile", null, false, str3, new b(activity, e2, str2, callbackHandler, str, str3));
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        k.N(str3, "checkScope");
        d.a.l0.a.a2.d.g().r().T().g(c(), "scope_mobile_api", new a(callbackHandler, str, activity, str2, str3));
    }
}
