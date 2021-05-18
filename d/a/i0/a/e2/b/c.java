package d.a.i0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f41424g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41425h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41426i;

        public a(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            this.f41422e = callbackHandler;
            this.f41423f = str;
            this.f41424g = activity;
            this.f41425h = str2;
            this.f41426i = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                if (a0.f40775b) {
                    Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                }
                c.this.m(this.f41422e, this.f41423f, this.f41424g, this.f41425h, this.f41426i);
                return;
            }
            d.a.i0.a.e0.d.h("SwanAppAction", "onCallback: no permission scope_mobile_api");
            k.O(this.f41426i, "fail", "onCallback: no permission ");
            this.f41422e.handleSchemeDispatchCallback(this.f41423f, UnitedSchemeUtility.wrapCallbackParams(402).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f41428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41429g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41430h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41431i;
        public final /* synthetic */ String j;

        public b(Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3) {
            this.f41427e = activity;
            this.f41428f = z;
            this.f41429g = str;
            this.f41430h = callbackHandler;
            this.f41431i = str2;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.d.a aVar) {
            d.a.i0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            d.a.i0.a.a2.e c2 = c.this.c();
            if (!aVar.E()) {
                if (c2 != null && !c2.j().e(this.f41427e) && !this.f41428f) {
                    k.M("fail", 2, this.f41429g);
                }
                if (a0.f40775b) {
                    Log.i("SwanAppAction", "onCallback: no open datamobile");
                }
                d.a.i0.a.e2.c.d.m(aVar, this.f41430h, this.f41431i);
                k.O(this.j, "fail", "onCallback: no open data");
                return;
            }
            d.a.i0.a.e0.d.h("SwanAppAction", "onCallback: got open datamobile");
            if (c2 != null && c2.j().e(this.f41427e) && !this.f41428f) {
                k.M("success", 2, this.f41429g);
            }
            k.N(this.j, "success");
            this.f41430h.handleSchemeDispatchCallback(this.f41431i, UnitedSchemeUtility.wrapCallbackParams(aVar.f41597g, 0).toString());
        }
    }

    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumber");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
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
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
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
        boolean e2 = d.a.i0.a.a2.d.g().r().j().e(activity);
        k.N(str3, "checkScope");
        d.a.i0.a.e2.d.a.C(activity, "mobile", null, false, str3, new b(activity, e2, str2, callbackHandler, str, str3));
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        k.N(str3, "checkScope");
        d.a.i0.a.a2.d.g().r().T().g(c(), "scope_mobile_api", new a(callbackHandler, str, activity, str2, str3));
    }
}
