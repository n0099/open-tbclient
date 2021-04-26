package d.a.h0.b.m.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.internal.ETAG;
import d.a.h0.a.c0.c;
import d.a.h0.a.g1.i;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.p;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends i {

    /* renamed from: d.a.h0.b.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0878a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f45563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45564f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45565g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45566h;

        public RunnableC0878a(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
            this.f45563e = eVar;
            this.f45564f = unitedSchemeEntity;
            this.f45565g = callbackHandler;
            this.f45566h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.C(this.f45563e, this.f45564f, this.f45565g, this.f45566h);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/adRequest");
    }

    @Override // d.a.h0.a.g1.i
    public boolean A(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        p.j(new RunnableC0878a(eVar, unitedSchemeEntity, callbackHandler, str), "execRequest");
        return true;
    }

    public final void C(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        String optString = a2.optString("cb");
        try {
            String optString2 = a2.optString("url");
            D(a2, optString2, i0.o(optString2));
            unitedSchemeEntity.putParams("params", a2.toString());
            if (super.A(eVar, unitedSchemeEntity, callbackHandler, str)) {
                return;
            }
            c.b("AdRequest", "request fail");
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } catch (JSONException unused) {
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void D(JSONObject jSONObject, String str, boolean z) throws JSONException {
        HttpUrl parse;
        JSONObject optJSONObject;
        String str2;
        String k;
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
        if (a0.f44398b) {
            Log.d("AdRequestAction", "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2);
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (TextUtils.equals(optString, "cuid")) {
                k = d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c());
            } else {
                k = (TextUtils.equals(optString, ETAG.KEY_BAIDU_ID) && z) ? i0.k(str2, "BAIDUID") : "";
            }
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            c.g("AdRequest", "key=" + next + ", value=" + k);
            newBuilder.addQueryParameter(next, k);
        }
        jSONObject.put("url", newBuilder.build().toString());
    }
}
