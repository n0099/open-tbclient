package d.a.m0.a.x;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.f;
import d.a.m0.a.v2.e1.b;
import d.a.m0.a.v2.p0;
import d.a.m0.a.v2.w;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.m0.a.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0961a implements b<Map<String, f>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49520e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49521f;

        public C0961a(CallbackHandler callbackHandler, String str) {
            this.f49520e = callbackHandler;
            this.f49521f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, f> map) {
            if (map != null) {
                a.this.l(this.f49521f, this.f49520e, map);
            } else {
                this.f49520e.handleSchemeDispatchCallback(this.f49521f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/getLaunchAppInfo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        k(optString, callbackHandler);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(String str, CallbackHandler callbackHandler) {
        d.a.m0.a.n1.q.c.a.h(new C0961a(callbackHandler, str));
    }

    public final void l(String str, CallbackHandler callbackHandler, Map<String, f> map) {
        f fVar = map.get("scope_open_app");
        if (fVar == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return;
        }
        boolean z = fVar.f45481d;
        int c2 = p0.c();
        long e2 = p0.e();
        List<String> list = fVar.f45486i;
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
            if (a0.f44733b) {
                Log.i("GetBehaviorInfoAction", "launchCount:" + c2 + " visitDuration:" + e2 + " forbidden:" + z + " ext:" + jSONArray.toString());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e3) {
            if (a0.f44733b) {
                e3.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }
}
