package d.a.h0.a.c2.e.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c0.c;
import d.a.h0.a.c2.e.a;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.c.m.k;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.c2.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0609a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41804b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f41805c;

        public C0609a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar) {
            this.f41803a = unitedSchemeEntity;
            this.f41804b = callbackHandler;
            this.f41805c = kVar;
        }

        @Override // d.a.h0.a.c2.e.a.c
        public void a(float f2, int i2) {
            c.g("compass", "handle compass change, angle:" + f2 + ",accuracy: " + i2);
            a.this.k(this.f41803a, this.f41804b, this.f41805c, f2, i2);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/startCompass");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("compass", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "startCompass --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            c.b("compass", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "startCompass --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f44398b) {
                    Log.d("SwanAppAction", "startCompass --- params is empty");
                }
                c.b("compass", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f44398b) {
                    Log.d("SwanAppAction", "startCompass --- cb is empty");
                }
                c.b("compass", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.g("compass", "init");
            k kVar = new k("compassChange", optParamsAsJo, optString);
            d.a.h0.a.c2.e.a i2 = d.a.h0.a.c2.e.a.i();
            i2.l(context);
            i2.o(new C0609a(unitedSchemeEntity, callbackHandler, kVar));
            c.g("compass", "start listen compass");
            i2.p();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            kVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar, float f2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("direction", f2);
            jSONObject.put("accuracy", d.a.h0.a.c2.e.a.h(i2));
            if (a0.f44398b) {
                Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
            }
            kVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            c.b("compass", "handle compass,json error，" + e2.toString());
            kVar.e(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
