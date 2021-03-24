package d.b.g0.b.m.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.internal.ETAG;
import d.b.g0.a.c0.c;
import d.b.g0.a.g1.i;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.p;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends i {

    /* renamed from: d.b.g0.b.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0906a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f47396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47397f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47398g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47399h;

        public RunnableC0906a(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
            this.f47396e = eVar;
            this.f47397f = unitedSchemeEntity;
            this.f47398g = callbackHandler;
            this.f47399h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.C(this.f47396e, this.f47397f, this.f47398g, this.f47399h);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/adRequest");
    }

    @Override // d.b.g0.a.g1.i
    public boolean A(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        p.j(new RunnableC0906a(eVar, unitedSchemeEntity, callbackHandler, str), "execRequest");
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
        if (a0.f46287b) {
            Log.d("AdRequestAction", "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2);
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (TextUtils.equals(optString, "cuid")) {
                k = d.b.g0.a.w0.a.O().c(d.b.g0.a.w0.a.c());
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
