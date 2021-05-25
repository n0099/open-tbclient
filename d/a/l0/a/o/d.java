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
    public d.a.l0.a.o.b f43863c;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final UnitedSchemeEntity f43864a;

        /* renamed from: b  reason: collision with root package name */
        public final CallbackHandler f43865b;

        public a(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f43864a = unitedSchemeEntity;
            this.f43865b = callbackHandler;
        }

        @Override // d.a.l0.a.o.a
        public void a(int i2) {
            UnitedSchemeUtility.callCallback(this.f43865b, this.f43864a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final CallbackHandler f43866a;

        /* renamed from: b  reason: collision with root package name */
        public final String f43867b;

        public b(d dVar, CallbackHandler callbackHandler, String str) {
            this.f43866a = callbackHandler;
            this.f43867b = str;
        }

        @Override // d.a.l0.a.o.c
        public void a(JSONObject jSONObject) {
            if (TextUtils.isEmpty(this.f43867b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("rewardedVideoAdClose", hashMap));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event", IntentConfig.CLOSE);
                jSONObject2.put("result", jSONObject);
                this.f43866a.handleSchemeDispatchCallback(this.f43867b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.a.l0.a.o.c
        public void b() {
            if (TextUtils.isEmpty(this.f43867b)) {
                d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("rewardedVideoAdLoad", new HashMap()));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "load");
                this.f43866a.handleSchemeDispatchCallback(this.f43867b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.a.l0.a.o.c
        public void c(JSONObject jSONObject) {
            if (TextUtils.isEmpty(this.f43867b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("rewardedVideoAdError", hashMap));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event", "error");
                jSONObject2.put("result", jSONObject);
                this.f43866a.handleSchemeDispatchCallback(this.f43867b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public d(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/rewardedVideoAd");
        this.f43863c = null;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
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
        if (this.f43863c == null) {
            this.f43863c = new f(a2, bVar, aVar);
        }
        if (TextUtils.equals(optString2, "show")) {
            this.f43863c.a(a2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, "load")) {
            this.f43863c.b(a2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }
}
