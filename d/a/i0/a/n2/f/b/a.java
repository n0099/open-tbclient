package d.a.i0.a.n2.f.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.n2.f.a;
import d.a.i0.a.u.e.o.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.i0.a.n2.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0762a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f43635c;

        public C0762a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar) {
            this.f43633a = unitedSchemeEntity;
            this.f43634b = callbackHandler;
            this.f43635c = lVar;
        }

        @Override // d.a.i0.a.n2.f.a.c
        public void a(float f2, int i2) {
            d.g("compass", "handle compass change, angle:" + f2 + ",accuracy: " + i2);
            a.this.k(this.f43633a, this.f43634b, this.f43635c, f2, i2);
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/startCompass");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.b("compass", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f40775b) {
                Log.d("SwanAppAction", "startCompass --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b("compass", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f40775b) {
                Log.d("SwanAppAction", "startCompass --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f40775b) {
                    Log.d("SwanAppAction", "startCompass --- params is empty");
                }
                d.b("compass", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f40775b) {
                    Log.d("SwanAppAction", "startCompass --- cb is empty");
                }
                d.b("compass", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.g("compass", "init");
            l lVar = new l("compassChange", optParamsAsJo, optString);
            d.a.i0.a.n2.f.a i2 = d.a.i0.a.n2.f.a.i();
            i2.l(context);
            i2.o(new C0762a(unitedSchemeEntity, callbackHandler, lVar));
            d.g("compass", "start listen compass");
            i2.p();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            lVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar, float f2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("direction", f2);
            jSONObject.put("accuracy", d.a.i0.a.n2.f.a.h(i2));
            if (a0.f40775b) {
                Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
            }
            lVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            d.b("compass", "handle compass,json error，" + e2.toString());
            lVar.e(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
