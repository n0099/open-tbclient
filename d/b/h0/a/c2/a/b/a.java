package d.b.h0.a.c2.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.c0.c;
import d.b.h0.a.c2.a.a;
import d.b.h0.a.r1.e;
import d.b.h0.a.t.c.m.a;
import d.b.h0.a.t.c.m.k;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.c2.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0666a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44485b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f44486c;

        public C0666a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar) {
            this.f44484a = unitedSchemeEntity;
            this.f44485b = callbackHandler;
            this.f44486c = kVar;
        }

        @Override // d.b.h0.a.c2.a.a.b
        public void a(double[] dArr) {
            if (dArr != null && dArr.length == 3) {
                c.g("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                a.this.k(this.f44484a, this.f44485b, this.f44486c, dArr);
                return;
            }
            c.b("accelerometer", "illegal accelerometers");
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/startAccelerometer");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("accelerometer", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            c.b("accelerometer", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f47009b) {
                    Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                }
                c.b("accelerometer", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f47009b) {
                    Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                }
                c.b("accelerometer", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.g("accelerometer", " init ");
            k kVar = new k("accelerometerChange", optParamsAsJo, optString);
            d.b.h0.a.c2.a.a g2 = d.b.h0.a.c2.a.a.g();
            g2.h(context, a.b.a(optParamsAsJo.optString("interval")));
            g2.k(new C0666a(unitedSchemeEntity, callbackHandler, kVar));
            g2.l();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            kVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar, double[] dArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", dArr[0]);
            jSONObject.put("y", dArr[1]);
            jSONObject.put("z", dArr[2]);
            kVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            c.b("accelerometer", "handle compass,json error，" + e2.toString());
            kVar.e(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
