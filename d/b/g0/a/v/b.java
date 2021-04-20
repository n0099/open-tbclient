package d.b.g0.a.v;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.v;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f47044c;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.v.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47045a;

        public a(CallbackHandler callbackHandler) {
            this.f47045a = callbackHandler;
        }

        @Override // d.b.g0.a.v.a
        public void onSuccess(String str, String str2, String str3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scanType", str2);
                jSONObject.put("charSet", str3);
                jSONObject.put("result", str);
                c.g("scanCode", jSONObject.toString());
                this.f47045a.handleSchemeDispatchCallback(b.this.f47044c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                if (a0.f46680b) {
                    e2.printStackTrace();
                }
                c.g("scanCode", "scanCode exec fail");
                this.f47045a.handleSchemeDispatchCallback(b.this.f47044c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/scanCode");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.g("scanCode", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
            this.f47044c = optString;
            if (TextUtils.isEmpty(optString)) {
                c.g("scanCode", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.b.g0.a.w0.a.K().a(eVar.n(), new a(callbackHandler));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
