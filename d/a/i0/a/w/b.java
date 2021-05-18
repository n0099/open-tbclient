package d.a.i0.a.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f45334c;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.w.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45335a;

        public a(CallbackHandler callbackHandler) {
            this.f45335a = callbackHandler;
        }

        @Override // d.a.i0.a.w.a
        public void a(String str, String str2, String str3) {
            if (str == null) {
                str = "";
                str3 = str;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("scanType", str2);
                jSONObject.put("charSet", str3);
                jSONObject.put("result", str);
                d.g("scanCode", jSONObject.toString());
                this.f45335a.handleSchemeDispatchCallback(b.this.f45334c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
                d.g("scanCode", "scanCode exec fail");
                this.f45335a.handleSchemeDispatchCallback(b.this.f45334c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public b(e eVar) {
        super(eVar, "/swanAPI/scanCode");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.g("scanCode", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            this.f45334c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.g("scanCode", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.i0.a.c1.a.V().a(eVar.x(), new a(callbackHandler));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
