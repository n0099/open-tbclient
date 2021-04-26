package d.a.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.w0.c.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44708e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44709f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44710g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44711h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44712i;

        public a(JSONObject jSONObject, d.a.h0.a.r1.e eVar, Context context, String str, CallbackHandler callbackHandler) {
            this.f44708e = jSONObject;
            this.f44709f = eVar;
            this.f44710g = context;
            this.f44711h = str;
            this.f44712i = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.e eVar) {
            String str;
            if (eVar == null || eVar.f44913d || eVar.j != 1 || TextUtils.isEmpty(eVar.o.optString("web_url"))) {
                str = "";
            } else {
                String optString = eVar.o.optString("web_url");
                String optString2 = this.f44708e.optString("path");
                if (!TextUtils.isEmpty(optString2)) {
                    if (!optString.endsWith("/")) {
                        optString = optString + "/";
                    }
                    if (optString2.startsWith("/")) {
                        optString2 = optString2.substring(1);
                    }
                    optString = optString + optString2;
                }
                str = i0.a(i0.a(optString, "_swebfr", "1"), "hostname", d.a.h0.a.w0.a.k().f());
            }
            if (!k0.D() && TextUtils.isEmpty(str)) {
                str = d.a.h0.c.g.c.e().g(this.f44709f.B(), this.f44709f.j(), this.f44708e.optString("path"));
            }
            String str2 = str;
            if (a0.f44398b) {
                Log.d("ShareAction", "final share url is " + str2);
            }
            z.this.n(str2, this.f44710g, this.f44711h, this.f44712i, this.f44708e, this.f44709f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44714f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44715g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44716h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44717i;

        public b(Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            this.f44713e = context;
            this.f44714f = callbackHandler;
            this.f44715g = str;
            this.f44716h = jSONObject;
            this.f44717i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            z.this.m(this.f44713e, this.f44714f, this.f44715g, this.f44716h, d.a.h0.a.v1.c.c.h(hVar), this.f44717i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44719b;

        public c(CallbackHandler callbackHandler, String str) {
            this.f44718a = callbackHandler;
            this.f44719b = str;
        }

        @Override // d.a.h0.a.w0.c.i.a
        public void a() {
            z.this.o(this.f44718a, this.f44719b, false);
        }

        @Override // d.a.h0.a.w0.c.i.a
        public void b() {
            z.this.o(this.f44718a, this.f44719b, true);
        }
    }

    public z(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/share");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (context != null && eVar != null) {
            if (eVar.Z()) {
                if (a0.f44398b) {
                    Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.h0.a.c0.c.b("Share", "params invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.c0.c.b("Share", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            try {
                a2.put("iconUrl", a2.optString("imageUrl", ""));
            } catch (JSONException e2) {
                if (a0.f44398b) {
                    Log.d("ShareAction", e2.toString());
                }
            }
            eVar.R().e("mapp_i_share_update_weburl", new a(a2, eVar, context, optString, callbackHandler));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b("Share", "context or swanApp is null");
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
            if (a0.f44398b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        p(context, callbackHandler, str, jSONObject);
    }

    public final void n(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull d.a.h0.a.r1.e eVar) {
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
                    if (a0.f44398b) {
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
            if (a0.f44398b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        int i2 = z ? 0 : 1001;
        d.a.h0.a.c0.c.g("Share", "result=" + z);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i2).toString());
    }

    public final void p(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        jSONObject.remove("defaultPannel");
        jSONObject.remove("shareUrl");
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O != null) {
            String S = O.J().S();
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                d.a.h0.a.i2.v.d(optJSONObject, "source", S);
            } else {
                d.a.h0.a.i2.v.d(jSONObject, "categoryInfo", d.a.h0.a.i2.v.d(null, "source", S));
            }
        }
        d.a.h0.a.w0.a.M().a(context, jSONObject, new c(callbackHandler, str));
    }
}
