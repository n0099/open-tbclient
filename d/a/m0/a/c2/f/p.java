package d.a.m0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44930e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44931f;

        public a(p pVar, String str, JSONObject jSONObject) {
            this.f44930e = str;
            this.f44931f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.e.m(this.f44930e, this.f44931f);
        }
    }

    public p(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openStatisticEvent");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("bizId", "-1");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
            return false;
        }
        try {
            optParamsAsJo.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            optParamsAsJo.putOpt("eventType", "0");
            optParamsAsJo.putOpt("propagation", d.a.m0.a.v2.w.f(optParamsAsJo.optJSONObject("propagation"), "source", d.a.m0.a.a2.d.g().r().L().T()));
        } catch (JSONException e2) {
            if (a0.f44733b) {
                e2.printStackTrace();
            }
        }
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("content");
        if (optJSONObject != null) {
            d.a.m0.a.j2.o.r(optJSONObject.optJSONObject("ext"));
        }
        d.a.m0.a.e0.d.g("OpenStatisticEvent", "OpenStat : " + optParamsAsJo);
        d.a.m0.a.v2.q.j(new a(this, optString, optParamsAsJo), "OpenStatisticEvent");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
