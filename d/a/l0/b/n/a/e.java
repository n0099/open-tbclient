package d.a.l0.b.n.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f50000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50001f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50002g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50003h;

        public a(Context context, CallbackHandler callbackHandler, String str, String str2) {
            this.f50000e = context;
            this.f50001f = callbackHandler;
            this.f50002g = str;
            this.f50003h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            e.this.l(iVar, this.f50000e, this.f50001f, this.f50002g, this.f50003h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50007g;

        public b(e eVar, String str, CallbackHandler callbackHandler, String str2) {
            this.f50005e = str;
            this.f50006f = callbackHandler;
            this.f50007g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle != null && !TextUtils.isEmpty(bundle.getString(this.f50005e))) {
                String string = bundle.getString(this.f50005e);
                d.a.l0.a.e0.d.g("GetStokenAction", "stoken=" + string);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("stoken", string);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e2) {
                    if (a0.f44625b) {
                        Log.d("SwanAppAction", e2.getMessage());
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.f50006f.handleSchemeDispatchCallback(this.f50007g, wrapCallbackParams.toString());
                return;
            }
            this.f50006f.handleSchemeDispatchCallback(this.f50007g, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is invalid").toString());
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getStoken");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("tpl");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("GetStokenAction", "empty tpl");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty tpl");
            return false;
        }
        String optString2 = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            eVar.T().g(context, "mapp_i_get_stoken", new a(context, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void l(i<b.e> iVar, Context context, CallbackHandler callbackHandler, String str, String str2) {
        if (!d.a.l0.a.e2.c.d.h(iVar)) {
            d.a.l0.a.e2.c.d.p(iVar, callbackHandler, str);
        } else if (TextUtils.isEmpty(d.a.l0.b.j.a.i(context))) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bduss is invalid").toString());
        } else {
            d.a.l0.b.j.a.t(context, new b(this, str2, callbackHandler, str), str2);
        }
    }
}
