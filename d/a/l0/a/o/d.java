package d.a.l0.a.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.c2.f.a0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.o.b f47539c;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final UnitedSchemeEntity f47540a;

        /* renamed from: b  reason: collision with root package name */
        public final CallbackHandler f47541b;

        public a(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f47540a = unitedSchemeEntity;
            this.f47541b = callbackHandler;
        }

        @Override // d.a.l0.a.o.a
        public void a(int i2) {
            UnitedSchemeUtility.callCallback(this.f47541b, this.f47540a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final CallbackHandler f47542a;

        /* renamed from: b  reason: collision with root package name */
        public final String f47543b;

        public b(d dVar, CallbackHandler callbackHandler, String str) {
            this.f47542a = callbackHandler;
            this.f47543b = str;
        }

        @Override // d.a.l0.a.o.c
        public void a(JSONObject jSONObject) {
            if (TextUtils.isEmpty(this.f47543b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("rewardedVideoAdClose", hashMap));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event", IntentConfig.CLOSE);
                jSONObject2.put("result", jSONObject);
                this.f47542a.handleSchemeDispatchCallback(this.f47543b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.a.l0.a.o.c
        public void b() {
            if (TextUtils.isEmpty(this.f47543b)) {
                d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("rewardedVideoAdLoad", new HashMap()));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "load");
                this.f47542a.handleSchemeDispatchCallback(this.f47543b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.a.l0.a.o.c
        public void c(JSONObject jSONObject) {
            if (TextUtils.isEmpty(this.f47543b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("rewardedVideoAdError", hashMap));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event", "error");
                jSONObject2.put("result", jSONObject);
                this.f47542a.handleSchemeDispatchCallback(this.f47543b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public d(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/rewardedVideoAd");
        this.f47539c = null;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = a2.optString("cb");
        String optString2 = a2.optString("action");
        b bVar = new b(this, callbackHandler, optString);
        a aVar = new a(this, unitedSchemeEntity, callbackHandler);
        if (this.f47539c == null) {
            this.f47539c = new f(a2, bVar, aVar);
        }
        if (TextUtils.equals(optString2, "show")) {
            this.f47539c.a(a2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, "load")) {
            this.f47539c.b(a2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }
}
