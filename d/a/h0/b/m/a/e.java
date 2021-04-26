package d.a.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45524f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45525g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45526h;

        public a(Context context, CallbackHandler callbackHandler, String str, String str2) {
            this.f45523e = context;
            this.f45524f = callbackHandler;
            this.f45525g = str;
            this.f45526h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            e.this.l(hVar, this.f45523e, this.f45524f, this.f45525g, this.f45526h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45529f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45530g;

        public b(e eVar, String str, CallbackHandler callbackHandler, String str2) {
            this.f45528e = str;
            this.f45529f = callbackHandler;
            this.f45530g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle != null && !TextUtils.isEmpty(bundle.getString(this.f45528e))) {
                String string = bundle.getString(this.f45528e);
                d.a.h0.a.c0.c.g("GetStokenAction", "stoken=" + string);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("stoken", string);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e2) {
                    if (a0.f44398b) {
                        Log.d("SwanAppAction", e2.getMessage());
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.f45529f.handleSchemeDispatchCallback(this.f45530g, wrapCallbackParams.toString());
                return;
            }
            this.f45529f.handleSchemeDispatchCallback(this.f45530g, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is invalid").toString());
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/getStoken");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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
            d.a.h0.a.c0.c.b("GetStokenAction", "empty tpl");
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
            eVar.R().g(context, "mapp_i_get_stoken", new a(context, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void l(d.a.h0.a.v1.c.h<b.e> hVar, Context context, CallbackHandler callbackHandler, String str, String str2) {
        if (!d.a.h0.a.v1.c.c.h(hVar)) {
            d.a.h0.a.v1.c.c.o(hVar, callbackHandler, str);
        } else if (TextUtils.isEmpty(d.a.h0.b.i.a.i(context))) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bduss is invalid").toString());
        } else {
            d.a.h0.b.i.a.t(context, new b(this, str2, callbackHandler, str), str2);
        }
    }
}
