package d.a.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.y0.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44671f;

        public a(q qVar, String str, JSONObject jSONObject) {
            this.f44670e = str;
            this.f44671f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.n.e.l(this.f44670e, this.f44671f);
        }
    }

    public q(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/openStatisticEvent");
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        b.a J = d.a.h0.a.r1.d.e().p().J();
        d.a.h0.a.i2.v.d(jSONObject, "launchId", J.U());
        d.a.h0.a.i2.v.d(jSONObject, "scheme", J.V());
        d.a.h0.a.i2.v.d(jSONObject, "appid", J.G());
        d.a.h0.a.i2.v.d(jSONObject, "swan", d.a.h0.a.b2.b.g(J.f0(), J.F()));
        d.a.h0.a.i2.v.d(jSONObject, "packageVersion", J.n1());
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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
            optParamsAsJo.putOpt("propagation", d.a.h0.a.i2.v.d(optParamsAsJo.optJSONObject("propagation"), "source", d.a.h0.a.r1.d.e().p().J().S()));
        } catch (JSONException e2) {
            if (a0.f44398b) {
                e2.printStackTrace();
            }
        }
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("content");
        if (optJSONObject != null) {
            j(optJSONObject.optJSONObject("ext"));
        }
        d.a.h0.a.c0.c.g("OpenStatisticEvent", "OpenStat : " + optParamsAsJo);
        d.a.h0.a.i2.p.k(new a(this, optString, optParamsAsJo), "OpenStatisticEvent");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
