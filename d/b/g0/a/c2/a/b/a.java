package d.b.g0.a.c2.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c0.c;
import d.b.g0.a.c2.a.a;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.c.m.a;
import d.b.g0.a.t.c.m.k;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.a.c2.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0634a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43763a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43764b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f43765c;

        public C0634a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar) {
            this.f43763a = unitedSchemeEntity;
            this.f43764b = callbackHandler;
            this.f43765c = kVar;
        }

        @Override // d.b.g0.a.c2.a.a.b
        public void a(double[] dArr) {
            if (dArr != null && dArr.length == 3) {
                c.g("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                a.this.k(this.f43763a, this.f43764b, this.f43765c, dArr);
                return;
            }
            c.b("accelerometer", "illegal accelerometers");
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/startAccelerometer");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("accelerometer", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46288b) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            c.b("accelerometer", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f46288b) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f46288b) {
                    Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                }
                c.b("accelerometer", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f46288b) {
                    Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                }
                c.b("accelerometer", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.g("accelerometer", " init ");
            k kVar = new k("accelerometerChange", optParamsAsJo, optString);
            d.b.g0.a.c2.a.a g2 = d.b.g0.a.c2.a.a.g();
            g2.h(context, a.b.a(optParamsAsJo.optString("interval")));
            g2.k(new C0634a(unitedSchemeEntity, callbackHandler, kVar));
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
