package d.b.g0.a.c2.g.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c0.c;
import d.b.g0.a.c2.g.a;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.c.m.k;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.a.c2.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0653a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44197a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44198b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f44199c;

        public C0653a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar) {
            this.f44197a = unitedSchemeEntity;
            this.f44198b = callbackHandler;
            this.f44199c = kVar;
        }

        @Override // d.b.g0.a.c2.g.a.b
        public void a(float[] fArr) {
            if (fArr == null || fArr.length != 3) {
                return;
            }
            a.this.k(this.f44197a, this.f44198b, this.f44199c, fArr);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/startDeviceMotion");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        int i;
        if (eVar == null) {
            c.b("StartDeviceMotionAction", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            return false;
        } else if (context == null) {
            c.b("StartDeviceMotionAction", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.b("StartDeviceMotionAction", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.b("StartDeviceMotionAction", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("interval");
            if (IMTrackDatabase.UiEnum.TABLE_NAME.equals(optString2)) {
                i = 2;
            } else {
                i = "game".equals(optString2) ? 1 : 3;
            }
            c.g("StartDeviceMotionAction", "startSensor===");
            k kVar = new k("deviceMotionChange", optParamsAsJo, optString);
            if (!d.b.g0.a.c2.g.a.h().l(i, new C0653a(unitedSchemeEntity, callbackHandler, kVar))) {
                c.b("StartDeviceMotionAction", "start system sensor fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            kVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar, float[] fArr) {
        JSONObject jSONObject = new JSONObject();
        double[] dArr = new double[3];
        double d2 = fArr[0] - 1.5707963267948966d;
        if (d2 < 0.0d) {
            d2 += 6.283185307179586d;
        }
        dArr[0] = Math.toDegrees(d2);
        dArr[1] = Math.toDegrees(-fArr[2]);
        dArr[2] = Math.toDegrees(-fArr[1]);
        if (a0.f46680b) {
            Log.i("SwanAppAction", "deviceMotionChange: " + Arrays.toString(dArr));
        }
        try {
            jSONObject.put("alpha", (float) dArr[0]);
            jSONObject.put("beta", (float) dArr[1]);
            jSONObject.put("gamma", (float) dArr[2]);
            kVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            c.b("StartDeviceMotionAction", "handle orientation,json error，" + e2.toString());
            kVar.e(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
