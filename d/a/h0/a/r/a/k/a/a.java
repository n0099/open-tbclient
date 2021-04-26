package d.a.h0.a.r.a.k.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.e0.l.i;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.r.a.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0745a implements Runnable {
        public RunnableC0745a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.E2();
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/setSelectedAddressSync");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.g("SetSelectedAddressSync", "framework error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            String optString = optParamsAsJo.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                d.a.h0.a.c0.c.g("SetSelectedAddressSync", "error no" + optString);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error no" + optString);
                return false;
            }
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                j(optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.h0.a.c0.c.g("SetSelectedAddressSync", "address data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "data is empty");
            return false;
        }
        d.a.h0.a.c0.c.g("SetSelectedAddressSync", "empty params");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
        return false;
    }

    public final void j(JSONObject jSONObject) {
        d.a().c(jSONObject);
        k0.T(new RunnableC0745a(this));
    }
}
