package d.a.i0.a.n2.i.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.n2.i.a;
import d.a.i0.a.u.e.o.l;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.i0.a.n2.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0767a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f43679c;

        public C0767a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar) {
            this.f43677a = unitedSchemeEntity;
            this.f43678b = callbackHandler;
            this.f43679c = lVar;
        }

        @Override // d.a.i0.a.n2.i.a.b
        public void a(float[] fArr) {
            if (fArr == null || fArr.length != 3) {
                return;
            }
            a.this.k(this.f43677a, this.f43678b, this.f43679c, fArr);
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/startDeviceMotion");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        int i2;
        if (eVar == null) {
            d.b("StartDeviceMotionAction", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            return false;
        } else if (context == null) {
            d.b("StartDeviceMotionAction", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b("StartDeviceMotionAction", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b("StartDeviceMotionAction", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("interval");
            if (IMTrackDatabase.UiEnum.TABLE_NAME.equals(optString2)) {
                i2 = 2;
            } else {
                i2 = "game".equals(optString2) ? 1 : 3;
            }
            d.g("StartDeviceMotionAction", "startSensor===");
            l lVar = new l("deviceMotionChange", optParamsAsJo, optString);
            if (!d.a.i0.a.n2.i.a.h().l(i2, new C0767a(unitedSchemeEntity, callbackHandler, lVar))) {
                d.b("StartDeviceMotionAction", "start system sensor fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            lVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar, float[] fArr) {
        JSONObject jSONObject = new JSONObject();
        double[] dArr = new double[3];
        double d2 = fArr[0] - 1.5707963267948966d;
        if (d2 < 0.0d) {
            d2 += 6.283185307179586d;
        }
        dArr[0] = Math.toDegrees(d2);
        dArr[1] = Math.toDegrees(-fArr[2]);
        dArr[2] = Math.toDegrees(-fArr[1]);
        if (a0.f40775b) {
            Log.i("SwanAppAction", "deviceMotionChange: " + Arrays.toString(dArr));
        }
        try {
            jSONObject.put("alpha", (float) dArr[0]);
            jSONObject.put("beta", (float) dArr[1]);
            jSONObject.put("gamma", (float) dArr[2]);
            lVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            d.b("StartDeviceMotionAction", "handle orientation,json error，" + e2.toString());
            lVar.e(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
