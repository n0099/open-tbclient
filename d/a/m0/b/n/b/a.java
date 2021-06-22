package d.a.m0.b.n.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.a2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e0.d;
import d.a.m0.a.n1.i;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends i {

    /* renamed from: d.a.m0.b.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1009a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50141f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50142g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50143h;

        public RunnableC1009a(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
            this.f50140e = eVar;
            this.f50141f = unitedSchemeEntity;
            this.f50142g = callbackHandler;
            this.f50143h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.C(this.f50140e, this.f50141f, this.f50142g, this.f50143h);
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/adRequest");
    }

    @Override // d.a.m0.a.n1.i
    public boolean A(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        q.i(new RunnableC1009a(eVar, unitedSchemeEntity, callbackHandler, str), "execRequest");
        return true;
    }

    public final void C(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        String optString = a2.optString("cb");
        try {
            String optString2 = a2.optString("url");
            D(a2, optString2, o0.q(optString2));
            unitedSchemeEntity.putParams("params", a2.toString());
            if (super.A(eVar, unitedSchemeEntity, callbackHandler, str)) {
                return;
            }
            d.b("AdRequest", "request fail");
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } catch (JSONException unused) {
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void D(JSONObject jSONObject, String str, boolean z) throws JSONException {
        HttpUrl parse;
        JSONObject optJSONObject;
        String str2;
        String l;
        if (jSONObject == null || TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null || (optJSONObject = jSONObject.optJSONObject("extParams")) == null) {
            return;
        }
        if (z) {
            str2 = o();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("header");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            j(optJSONObject2, str2);
            jSONObject.put("header", optJSONObject2);
        } else {
            str2 = "";
        }
        if (a0.f44733b) {
            Log.d("AdRequestAction", "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2);
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (TextUtils.equals(optString, "cuid")) {
                l = d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b());
            } else {
                l = (TextUtils.equals(optString, "baiduid") && z) ? o0.l(str2, "BAIDUID") : "";
            }
            if (TextUtils.isEmpty(l)) {
                l = "";
            }
            d.g("AdRequest", "key=" + next + ", value=" + l);
            newBuilder.addQueryParameter(next, l);
        }
        jSONObject.put("url", newBuilder.build().toString());
    }
}
