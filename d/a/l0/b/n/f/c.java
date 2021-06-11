package d.a.l0.b.n.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.b.n.f.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC1011b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f50057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50058b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50059c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f50060d;

        public a(c cVar, Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f50057a = context;
            this.f50058b = jSONObject;
            this.f50059c = callbackHandler;
            this.f50060d = str;
        }

        @Override // d.a.l0.b.n.f.b.InterfaceC1011b
        public void onResult(boolean z) {
            if (z) {
                b.d(this.f50057a);
            }
            try {
                this.f50058b.put("canceled", z);
            } catch (JSONException e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
            }
            this.f50059c.handleSchemeDispatchCallback(this.f50060d, UnitedSchemeUtility.wrapCallbackParams(this.f50058b, 0).toString());
        }
    }

    public c(e eVar) {
        super(eVar, "/swanAPI/guidePushSetting");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.b("GuidePushSettingAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b("GuidePushSettingAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(optParamsAsJo.optString("source"))) {
            d.b("GuidePushSettingAction", "openPushGuide source empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            d.b("GuidePushSettingAction", "illegal context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal context");
            return false;
        } else {
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            boolean b2 = b.b(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("authorized", b2);
            } catch (JSONException e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
            }
            if (b2) {
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } else {
                b.e(context, k(context, jSONObject, optString, callbackHandler));
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("authorized", b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                return true;
            } catch (JSONException e3) {
                if (a0.f44625b) {
                    e3.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }

    public final b.InterfaceC1011b k(Context context, JSONObject jSONObject, String str, CallbackHandler callbackHandler) {
        return new a(this, context, jSONObject, callbackHandler, str);
    }
}
