package d.b.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 extends d.b.h0.a.g1.a {

    /* renamed from: e  reason: collision with root package name */
    public int f47012e;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47013a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47014b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47015c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47016d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47017e;

        public a(CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            this.f47013a = callbackHandler;
            this.f47014b = str;
            this.f47015c = str2;
            this.f47016d = str3;
            this.f47017e = str4;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.h0.a.z0.f.V().S();
            this.f47013a.handleSchemeDispatchCallback(this.f47015c, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
            d0.this.q(this.f47017e);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            d.b.h0.a.z0.f.V().S();
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            d0.this.z(response, this.f47013a, this.f47014b, this.f47015c, this.f47016d, this.f47017e);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.g1.n.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f47019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47022d;

        public b(long j, String str, String str2, CallbackHandler callbackHandler) {
            this.f47019a = j;
            this.f47020b = str;
            this.f47021c = str2;
            this.f47022d = callbackHandler;
        }

        @Override // d.b.h0.a.g1.n.a
        public void a(long j) {
            d0.this.x(this.f47019a, j, this.f47020b, this.f47021c, this.f47022d);
        }
    }

    public d0(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/uploadFile");
        this.f47012e = 0;
    }

    public static void A(MultipartBody.Builder builder, JSONObject jSONObject) {
        if (builder == null || jSONObject == null || jSONObject.length() < 1) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    builder.addFormDataPart(next, optString);
                }
            }
        }
    }

    public final void B(MultipartBody.Builder builder, String str, String str2, d.b.h0.a.g1.c cVar) {
        if (builder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || cVar == null) {
            return;
        }
        builder.addFormDataPart(str, str2, cVar);
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String optString = a2.optString("onProgressUpdate");
        String optString2 = a2.optString("headersReceivedEvent");
        String optString3 = a2.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        String T = d.b.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String a3 = d.b.h0.a.t.c.h.c.a(T);
        String valueOf = String.valueOf(System.currentTimeMillis());
        Request w = w(a2, optString, a3, valueOf, eVar, callbackHandler);
        if (w == null) {
            unitedSchemeEntity.result = t(this.f47012e);
            q(valueOf);
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("header");
        d.b.h0.a.g1.m.b bVar = new d.b.h0.a.g1.m.b();
        HashMap<String, String> m = d.b.h0.a.g1.a.m(optJSONObject, true);
        String optString4 = a2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString4)) {
            d.b.h0.l.k.h g2 = d.b.h0.a.l1.g.b.g(optString4);
            if (m == null) {
                m = new HashMap<>();
            }
            m.put("X-SWAN-HOSTSIGN", d.b.h0.a.l1.g.a.b(g2));
        }
        HashMap<String, String> hashMap = m;
        hashMap.putAll(d.b.h0.a.g1.m.c.a("uploadFile", a2.optString("__plugin__")));
        bVar.a(hashMap);
        d.b.h0.a.z0.f.V().b0();
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a(w.url().toString(), w.body(), new a(callbackHandler, optString, optString3, optString2, valueOf));
        aVar.f49602c = hashMap;
        aVar.i = w.tag();
        aVar.f49605f = true;
        aVar.f49606g = false;
        aVar.f49607h = true;
        d.b.h0.k.e.a.f().e(aVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L46;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Request w(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable d.b.h0.a.r1.e eVar, @Nullable CallbackHandler callbackHandler) {
        HttpUrl e2;
        String str4;
        if (jSONObject == null || (e2 = d.b.h0.a.t.c.h.c.e(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = e2.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        int c2 = d.b.h0.a.s1.a.b.c("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
        this.f47012e = c2;
        if (c2 != 0) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString) || d.b.h0.p.d.o(optString)) {
            return null;
        }
        String m = d.b.h0.a.z0.f.V().y().m(optString);
        if (TextUtils.isEmpty(m)) {
            return null;
        }
        File file = new File(m);
        if (file.exists() && file.isFile()) {
            long length = file.length();
            if (length > 524288000) {
                if (a0.f47009b) {
                    Log.i("UploadFileAction", "file over size: " + (length / 1048576) + " MB.");
                }
                this.f47012e = 5;
                return null;
            }
            String optString2 = jSONObject.optString("name", "");
            if (TextUtils.isEmpty(optString2)) {
                return null;
            }
            if (!jSONObject.has("formData") || (jSONObject.opt("formData") instanceof JSONObject)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("formData");
                this.f45233c.put(str3, 0L);
                String name = file.getName();
                if (!TextUtils.isEmpty(name)) {
                    str4 = d.b.h0.a.i2.r.d(d.b.h0.a.i2.r.b(name));
                }
                str4 = IMAudioTransRequest.CONTENT_TYPE;
                d.b.h0.a.g1.c cVar = new d.b.h0.a.g1.c(file, str4, new b(length, str, str3, callbackHandler));
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                A(type, optJSONObject);
                B(type, optString2, file.getName(), cVar);
                return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
            }
            return null;
        }
        return null;
    }

    public final void x(long j, long j2, String str, String str2, CallbackHandler callbackHandler) {
        if (j <= 0 || j2 > j || j2 == 0 || TextUtils.isEmpty(str) || callbackHandler == null) {
            return;
        }
        int floor = (int) Math.floor((100 * j2) / j);
        if (System.currentTimeMillis() - p(str2) > 500 || floor == 100) {
            if (floor <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", floor);
                    jSONObject.put("totalBytesSent", j2);
                    jSONObject.put("totalBytesExpectedToSend", j);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e2) {
                    if (a0.f47009b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f45233c.put(str2, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void y(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
        if (responseBody == null) {
            return;
        }
        String string = responseBody.string();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            jSONObject.put("data", new JSONObject(string));
        } catch (JSONException unused) {
            jSONObject.put("data", string);
        }
    }

    public final void z(Response response, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
        try {
            try {
                r(str3, response.headers());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("statusCode", response.code());
                y(jSONObject, response.body());
                if (jSONObject.toString().length() > 26214400) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                }
            } catch (Exception e2) {
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
        } finally {
            q(str4);
        }
    }
}
