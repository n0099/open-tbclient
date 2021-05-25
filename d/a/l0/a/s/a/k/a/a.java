package d.a.l0.a.s.a.k.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.h0.g.k;
import d.a.l0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.s.a.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0815a implements Runnable {
        public RunnableC0815a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.L2();
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/setSelectedAddressSync");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.g("SetSelectedAddressSync", "framework error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            String optString = optParamsAsJo.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                d.a.l0.a.e0.d.g("SetSelectedAddressSync", "error no" + optString);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error no" + optString);
                return false;
            }
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                j(optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.l0.a.e0.d.g("SetSelectedAddressSync", "address data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "data is empty");
            return false;
        }
        d.a.l0.a.e0.d.g("SetSelectedAddressSync", "empty params");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
        return false;
    }

    public final void j(JSONObject jSONObject) {
        d.a().c(jSONObject);
        q0.X(new RunnableC0815a(this));
    }
}
