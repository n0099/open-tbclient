package d.a.h0.b.m.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.b.m.f.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC0883b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45590c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45591d;

        public a(c cVar, Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f45588a = context;
            this.f45589b = jSONObject;
            this.f45590c = callbackHandler;
            this.f45591d = str;
        }

        @Override // d.a.h0.b.m.f.b.InterfaceC0883b
        public void onResult(boolean z) {
            if (z) {
                b.d(this.f45588a);
            }
            try {
                this.f45589b.put("canceled", z);
            } catch (JSONException e2) {
                if (a0.f44398b) {
                    e2.printStackTrace();
                }
            }
            this.f45590c.handleSchemeDispatchCallback(this.f45591d, UnitedSchemeUtility.wrapCallbackParams(this.f45589b, 0).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/guidePushSetting");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("GuidePushSettingAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.h0.a.c0.c.b("GuidePushSettingAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(optParamsAsJo.optString("source"))) {
            d.a.h0.a.c0.c.b("GuidePushSettingAction", "openPushGuide source empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            d.a.h0.a.c0.c.b("GuidePushSettingAction", "illegal context");
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
                if (a0.f44398b) {
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
                if (a0.f44398b) {
                    e3.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }

    public final b.InterfaceC0883b k(Context context, JSONObject jSONObject, String str, CallbackHandler callbackHandler) {
        return new a(this, context, jSONObject, callbackHandler, str);
    }
}
