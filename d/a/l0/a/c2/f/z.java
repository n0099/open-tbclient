package d.a.l0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c1.d.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.s0;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f41289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41290f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f41291g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41292h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41293i;

        public a(JSONObject jSONObject, d.a.l0.a.a2.e eVar, Context context, String str, CallbackHandler callbackHandler) {
            this.f41289e = jSONObject;
            this.f41290f = eVar;
            this.f41291g = context;
            this.f41292h = str;
            this.f41293i = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.f fVar) {
            String str;
            if (fVar == null || fVar.f41697d || fVar.j != 1 || TextUtils.isEmpty(fVar.o.optString("web_url"))) {
                str = "";
            } else {
                String optString = fVar.o.optString("web_url");
                String optString2 = this.f41289e.optString("path");
                if (!TextUtils.isEmpty(optString2)) {
                    if (!optString.endsWith("/")) {
                        optString = optString + "/";
                    }
                    if (optString2.startsWith("/")) {
                        optString2 = optString2.substring(1);
                    }
                    optString = optString + optString2;
                }
                str = o0.a(o0.a(optString, "_swebfr", "1"), "hostname", d.a.l0.a.c1.a.m().a());
            }
            if (!q0.G() && TextUtils.isEmpty(str)) {
                str = d.a.l0.d.g.c.e().g(this.f41290f.D(), this.f41290f.l(), this.f41289e.optString("path"));
            }
            String str2 = str;
            if (a0.f40949b) {
                Log.d("ShareAction", "final share url is " + str2);
            }
            z.this.p(str2, this.f41291g, this.f41292h, this.f41293i, this.f41289e, this.f41290f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41295f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41296g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f41297h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41298i;

        public b(Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            this.f41294e = context;
            this.f41295f = callbackHandler;
            this.f41296g = str;
            this.f41297h = jSONObject;
            this.f41298i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            z.this.n(this.f41294e, this.f41295f, this.f41296g, this.f41297h, d.a.l0.a.e2.c.d.h(iVar), this.f41298i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41299a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41300b;

        public c(CallbackHandler callbackHandler, String str) {
            this.f41299a = callbackHandler;
            this.f41300b = str;
        }

        @Override // d.a.l0.a.c1.d.i.a
        public void a() {
            z.this.q(this.f41299a, this.f41300b, false);
        }

        @Override // d.a.l0.a.c1.d.i.a
        public void b() {
            z.this.q(this.f41299a, this.f41300b, true);
        }
    }

    public z(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/share");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (context != null && eVar != null) {
            if (eVar.d0()) {
                if (a0.f40949b) {
                    Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.l0.a.e0.d.b("Share", "params invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.l0.a.e0.d.b("Share", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                return false;
            }
            try {
                a2.put("iconUrl", a2.optString("imageUrl", ""));
            } catch (JSONException e2) {
                if (a0.f40949b) {
                    Log.d("ShareAction", e2.toString());
                }
            }
            eVar.T().e("mapp_i_share_update_weburl", new a(a2, eVar, context, optString, callbackHandler));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.l0.a.e0.d.b("Share", "context or swanApp is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
        return false;
    }

    public String m(String str) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return null;
        }
        return d.a.l0.a.k2.b.M(str, Q.f40749f);
    }

    public final void n(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z, String str2) {
        String optString = jSONObject.optString("shareUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("linkUrl", str2);
            }
            if (!TextUtils.isEmpty(optString) && (o0.q(optString) || z)) {
                jSONObject.put("customShareUrl", true);
                jSONObject.put("linkUrl", optString);
            }
            if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                jSONObject.put("pannel", optJSONArray);
            }
        } catch (JSONException e2) {
            if (a0.f40949b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        r(context, callbackHandler, str, jSONObject);
    }

    public final JSONObject o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String m;
        Uri a2;
        Uri a3;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("imageUrl");
        if (optString.startsWith("bdfile")) {
            String m2 = m(optString);
            if (m2 == null) {
                return jSONObject;
            }
            try {
                jSONObject.putOpt("imageUrl", s0.a(d.a.l0.a.g1.f.V().getActivity(), new File(m2)).toString());
            } catch (JSONException e2) {
                if (a0.f40949b) {
                    e2.printStackTrace();
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            return jSONObject;
        }
        String optString2 = optJSONObject.optString("img_show");
        if (optString2.startsWith("bdfile")) {
            String m3 = m(optString2);
            if (m3 == null || (a3 = s0.a(d.a.l0.a.g1.f.V().getActivity(), new File(m3))) == null) {
                return jSONObject;
            }
            try {
                optJSONObject.putOpt("img_show", a3.toString());
                optJSONObject2.putOpt("info", optJSONObject);
                jSONObject.putOpt("command", optJSONObject2);
            } catch (JSONException e3) {
                if (a0.f40949b) {
                    e3.printStackTrace();
                }
            }
        }
        String optString3 = optJSONObject.optString("img_save");
        if (!optString3.startsWith("bdfile") || (m = m(optString3)) == null || (a2 = s0.a(d.a.l0.a.g1.f.V().getActivity(), new File(m))) == null) {
            return jSONObject;
        }
        try {
            optJSONObject.putOpt("img_save", a2.toString());
            optJSONObject2.putOpt("info", optJSONObject);
            jSONObject.putOpt("command", optJSONObject2);
        } catch (JSONException e4) {
            if (a0.f40949b) {
                e4.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final void p(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull d.a.l0.a.a2.e eVar) {
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
                    if (a0.f40949b) {
                        Log.d("ShareAction", e2.toString());
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("linkUrl", str);
            }
            if (TextUtils.isEmpty(optString)) {
                r(context, callbackHandler, str2, jSONObject);
                return;
            } else if (o0.q(optString)) {
                jSONObject.put("linkUrl", optString);
                jSONObject.put("customShareUrl", true);
                r(context, callbackHandler, str2, jSONObject);
                return;
            }
        }
        eVar.T().g(context, "mapp_i_share_update_linkurl", new b(context, callbackHandler, str2, jSONObject, str));
    }

    public final void q(CallbackHandler callbackHandler, String str, boolean z) {
        if (callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
        } catch (JSONException e2) {
            if (a0.f40949b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        int i2 = z ? 0 : 1001;
        d.a.l0.a.e0.d.g("Share", "result=" + z);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i2).toString());
    }

    public final void r(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        jSONObject.remove("defaultPannel");
        jSONObject.remove("shareUrl");
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q != null) {
            String T = Q.L().T();
            String a2 = d.a.l0.a.q0.a.a();
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                d.a.l0.a.v2.w.f(optJSONObject, "source", T);
                if (!TextUtils.isEmpty(a2)) {
                    d.a.l0.a.v2.w.f(optJSONObject, "nid", a2);
                }
            } else {
                JSONObject f2 = d.a.l0.a.v2.w.f(null, "source", T);
                if (!TextUtils.isEmpty(a2)) {
                    d.a.l0.a.v2.w.f(f2, "nid", a2);
                }
                d.a.l0.a.v2.w.f(jSONObject, "categoryInfo", f2);
            }
        }
        d.a.l0.a.c1.a.Y().a(context, o(jSONObject), new c(callbackHandler, str));
    }
}
