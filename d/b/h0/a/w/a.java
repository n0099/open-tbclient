package d.b.h0.a.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.j0;
import d.b.h0.a.i2.u0.b;
import d.b.h0.a.i2.v;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.e;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0902a implements b<Map<String, e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47572f;

        public C0902a(CallbackHandler callbackHandler, String str) {
            this.f47571e = callbackHandler;
            this.f47572f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Map<String, e> map) {
            if (map != null) {
                a.this.l(this.f47572f, this.f47571e, map);
            } else {
                this.f47571e.handleSchemeDispatchCallback(this.f47572f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getLaunchAppInfo");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        k(optString, callbackHandler);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(String str, CallbackHandler callbackHandler) {
        d.b.h0.a.g1.o.c.a.h(new C0902a(callbackHandler, str));
    }

    public final void l(String str, CallbackHandler callbackHandler, Map<String, e> map) {
        e eVar = map.get("scope_open_app");
        if (eVar == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return;
        }
        boolean z = eVar.f47492d;
        int c2 = j0.c();
        long e2 = j0.e();
        List<String> list = eVar.i;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : list) {
                jSONArray.put(str2);
            }
            jSONObject.put("launchCount", c2);
            jSONObject.put("visitDuration", e2);
            jSONObject.put("forbidden", z);
            jSONObject.put("ext", jSONArray);
            if (a0.f47009b) {
                Log.i("GetBehaviorInfoAction", "launchCount:" + c2 + " visitDuration:" + e2 + " forbidden:" + z + " ext:" + jSONArray.toString());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e3) {
            if (a0.f47009b) {
                e3.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }
}
