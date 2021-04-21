package d.b.h0.b.m.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.b.m.f.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC0944b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48142a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48143b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48144c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f48145d;

        public a(c cVar, Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f48142a = context;
            this.f48143b = jSONObject;
            this.f48144c = callbackHandler;
            this.f48145d = str;
        }

        @Override // d.b.h0.b.m.f.b.InterfaceC0944b
        public void onResult(boolean z) {
            if (z) {
                b.d(this.f48142a);
            }
            try {
                this.f48143b.put("canceled", z);
            } catch (JSONException e2) {
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
            }
            this.f48144c.handleSchemeDispatchCallback(this.f48145d, UnitedSchemeUtility.wrapCallbackParams(this.f48143b, 0).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/guidePushSetting");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("GuidePushSettingAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.h0.a.c0.c.b("GuidePushSettingAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(optParamsAsJo.optString("source"))) {
            d.b.h0.a.c0.c.b("GuidePushSettingAction", "openPushGuide source empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            d.b.h0.a.c0.c.b("GuidePushSettingAction", "illegal context");
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
                if (a0.f47009b) {
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
                if (a0.f47009b) {
                    e3.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }

    public final b.InterfaceC0944b k(Context context, JSONObject jSONObject, String str, CallbackHandler callbackHandler) {
        return new a(this, context, jSONObject, callbackHandler, str);
    }
}
