package d.b.g0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.a.w0.c.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46578e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46579f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46580g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46581h;
        public final /* synthetic */ CallbackHandler i;

        public a(JSONObject jSONObject, d.b.g0.a.r1.e eVar, Context context, String str, CallbackHandler callbackHandler) {
            this.f46578e = jSONObject;
            this.f46579f = eVar;
            this.f46580g = context;
            this.f46581h = str;
            this.i = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.e eVar) {
            String str;
            if (eVar == null || eVar.f46770d || eVar.j != 1 || TextUtils.isEmpty(eVar.o.optString("web_url"))) {
                str = "";
            } else {
                String optString = eVar.o.optString("web_url");
                String optString2 = this.f46578e.optString("path");
                if (!TextUtils.isEmpty(optString2)) {
                    if (!optString.endsWith("/")) {
                        optString = optString + "/";
                    }
                    if (optString2.startsWith("/")) {
                        optString2 = optString2.substring(1);
                    }
                    optString = optString + optString2;
                }
                str = i0.a(i0.a(optString, "_swebfr", "1"), "hostname", d.b.g0.a.w0.a.k().g());
            }
            if (!k0.D() && TextUtils.isEmpty(str)) {
                str = d.b.g0.c.g.c.e().g(this.f46579f.B(), this.f46579f.h(), this.f46578e.optString("path"));
            }
            String str2 = str;
            if (a0.f46287b) {
                Log.d("ShareAction", "final share url is " + str2);
            }
            z.this.n(str2, this.f46580g, this.f46581h, this.i, this.f46578e, this.f46579f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46583f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46584g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46585h;
        public final /* synthetic */ String i;

        public b(Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            this.f46582e = context;
            this.f46583f = callbackHandler;
            this.f46584g = str;
            this.f46585h = jSONObject;
            this.i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            z.this.m(this.f46582e, this.f46583f, this.f46584g, this.f46585h, d.b.g0.a.v1.c.c.h(hVar), this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46586a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46587b;

        public c(CallbackHandler callbackHandler, String str) {
            this.f46586a = callbackHandler;
            this.f46587b = str;
        }

        @Override // d.b.g0.a.w0.c.i.a
        public void a() {
            z.this.o(this.f46586a, this.f46587b, false);
        }

        @Override // d.b.g0.a.w0.c.i.a
        public void b() {
            z.this.o(this.f46586a, this.f46587b, true);
        }
    }

    public z(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/share");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (context != null && eVar != null) {
            if (eVar.Z()) {
                if (a0.f46287b) {
                    Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.b.g0.a.c0.c.b("Share", "params invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.b("Share", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            try {
                a2.put("iconUrl", a2.optString("imageUrl", ""));
            } catch (JSONException e2) {
                if (a0.f46287b) {
                    Log.d("ShareAction", e2.toString());
                }
            }
            eVar.R().e("mapp_i_share_update_weburl", new a(a2, eVar, context, optString, callbackHandler));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b("Share", "context or swanApp is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
        return false;
    }

    public final void m(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z, String str2) {
        String optString = jSONObject.optString("shareUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("linkUrl", str2);
            }
            if (!TextUtils.isEmpty(optString) && (i0.o(optString) || z)) {
                jSONObject.put("linkUrl", optString);
            }
            if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                jSONObject.put("pannel", optJSONArray);
            }
        } catch (JSONException e2) {
            if (a0.f46287b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        p(context, callbackHandler, str, jSONObject);
    }

    public final void n(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull d.b.g0.a.r1.e eVar) {
        String optString = jSONObject.optString("shareUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("pannel");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("defaultPannel");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            if (optJSONArray2 != null) {
                try {
                    if (optJSONArray2.length() > 0) {
                        jSONObject.put("pannel", optJSONArray2);
                    }
                } catch (JSONException e2) {
                    if (a0.f46287b) {
                        Log.d("ShareAction", e2.toString());
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("linkUrl", str);
            }
            if (TextUtils.isEmpty(optString)) {
                p(context, callbackHandler, str2, jSONObject);
                return;
            } else if (i0.o(optString)) {
                jSONObject.put("linkUrl", optString);
                p(context, callbackHandler, str2, jSONObject);
                return;
            }
        }
        eVar.R().g(context, "mapp_i_share_update_linkurl", new b(context, callbackHandler, str2, jSONObject, str));
    }

    public final void o(CallbackHandler callbackHandler, String str, boolean z) {
        if (callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
        } catch (JSONException e2) {
            if (a0.f46287b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        int i = z ? 0 : 1001;
        d.b.g0.a.c0.c.g("Share", "result=" + z);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
    }

    public final void p(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        jSONObject.remove("defaultPannel");
        jSONObject.remove("shareUrl");
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null) {
            String S = O.J().S();
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                d.b.g0.a.i2.v.d(optJSONObject, "source", S);
            } else {
                d.b.g0.a.i2.v.d(jSONObject, "categoryInfo", d.b.g0.a.i2.v.d(null, "source", S));
            }
        }
        d.b.g0.a.w0.a.M().a(context, jSONObject, new c(callbackHandler, str));
    }
}
