package d.a.l0.a.n2.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.n2.a.a;
import d.a.l0.a.u.e.o.a;
import d.a.l0.a.u.e.o.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.n2.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0769a implements a.InterfaceC0768a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43779a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43780b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f43781c;

        public C0769a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar) {
            this.f43779a = unitedSchemeEntity;
            this.f43780b = callbackHandler;
            this.f43781c = lVar;
        }

        @Override // d.a.l0.a.n2.a.a.InterfaceC0768a
        public void a(double[] dArr) {
            if (dArr != null && dArr.length == 3) {
                d.g("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                a.this.k(this.f43779a, this.f43780b, this.f43781c, dArr);
                return;
            }
            d.b("accelerometer", "illegal accelerometers");
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/startAccelerometer");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.b("accelerometer", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b("accelerometer", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f40949b) {
                    Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                }
                d.b("accelerometer", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f40949b) {
                    Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                }
                d.b("accelerometer", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.g("accelerometer", " init ");
            l lVar = new l("accelerometerChange", optParamsAsJo, optString);
            d.a.l0.a.n2.a.a a2 = d.a.l0.a.n2.a.a.a();
            a2.b(context, a.b.a(optParamsAsJo.optString("interval")));
            a2.e(new C0769a(unitedSchemeEntity, callbackHandler, lVar));
            a2.f();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            lVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar, double[] dArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", dArr[0]);
            jSONObject.put("y", dArr[1]);
            jSONObject.put("z", dArr[2]);
            lVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            d.b("accelerometer", "handle compass,json error，" + e2.toString());
            lVar.e(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
