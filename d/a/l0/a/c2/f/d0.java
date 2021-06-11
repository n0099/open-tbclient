package d.a.l0.a.c2.f;

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
public class d0 extends d.a.l0.a.n1.a {

    /* renamed from: e  reason: collision with root package name */
    public int f44628e;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44629a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44630b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44631c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44632d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44633e;

        public a(CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            this.f44629a = callbackHandler;
            this.f44630b = str;
            this.f44631c = str2;
            this.f44632d = str3;
            this.f44633e = str4;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.g1.f.V().S();
            this.f44629a.handleSchemeDispatchCallback(this.f44631c, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
            d0.this.q(this.f44633e);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            d.a.l0.a.g1.f.V().S();
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            d0.this.z(response, this.f44629a, this.f44630b, this.f44631c, this.f44632d, this.f44633e);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.n1.p.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f44635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44637c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44638d;

        public b(long j, String str, String str2, CallbackHandler callbackHandler) {
            this.f44635a = j;
            this.f44636b = str;
            this.f44637c = str2;
            this.f44638d = callbackHandler;
        }

        @Override // d.a.l0.a.n1.p.a
        public void a(long j) {
            d0.this.x(this.f44635a, j, this.f44636b, this.f44637c, this.f44638d);
        }
    }

    public d0(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/uploadFile");
        this.f44628e = 0;
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

    public final void B(MultipartBody.Builder builder, String str, String str2, d.a.l0.a.n1.c cVar) {
        if (builder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || cVar == null) {
            return;
        }
        builder.addFormDataPart(str, str2, cVar);
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
        String V = d.a.l0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String a3 = d.a.l0.a.u.e.j.h.a(V);
        String valueOf = String.valueOf(System.currentTimeMillis());
        Request w = w(a2, optString, a3, valueOf, eVar, callbackHandler);
        if (w == null) {
            unitedSchemeEntity.result = t(this.f44628e);
            q(valueOf);
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("header");
        d.a.l0.a.n1.o.b bVar = new d.a.l0.a.n1.o.b();
        HashMap<String, String> m = d.a.l0.a.n1.a.m(optJSONObject, true);
        String optString4 = a2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString4)) {
            d.a.l0.n.h.h h2 = d.a.l0.a.t1.g.b.h(optString4);
            if (m == null) {
                m = new HashMap<>();
            }
            m.put("X-SWAN-HOSTSIGN", d.a.l0.a.t1.g.a.b(h2));
        }
        HashMap<String, String> hashMap = m;
        hashMap.putAll(d.a.l0.a.n1.o.c.a("uploadFile", a2.optString("__plugin__")));
        bVar.a(hashMap);
        d.a.l0.a.g1.f.V().b0();
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(w.url().toString(), w.body(), new a(callbackHandler, optString, optString3, optString2, valueOf));
        aVar.f51645c = hashMap;
        aVar.f51651i = w.tag();
        aVar.f51648f = true;
        aVar.f51649g = false;
        aVar.f51650h = true;
        aVar.k = 2;
        d.a.l0.m.e.a.g().e(aVar);
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
    public final Request w(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable d.a.l0.a.a2.e eVar, @Nullable CallbackHandler callbackHandler) {
        HttpUrl f2;
        String str4;
        if (jSONObject == null || (f2 = d.a.l0.a.u.e.j.h.f(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = f2.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        int c2 = d.a.l0.a.b2.a.b.c("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
        this.f44628e = c2;
        if (c2 != 0) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString) || d.a.l0.t.d.w(optString)) {
            return null;
        }
        String a2 = d.a.l0.a.g1.f.V().I().a(optString);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        File file = new File(a2);
        if (file.exists() && file.isFile()) {
            long length = file.length();
            if (length > 524288000) {
                if (a0.f44625b) {
                    Log.i("UploadFileAction", "file over size: " + (length / 1048576) + " MB.");
                }
                this.f44628e = 5;
                return null;
            }
            String optString2 = jSONObject.optString("name", "");
            if (TextUtils.isEmpty(optString2)) {
                return null;
            }
            if (!jSONObject.has("formData") || (jSONObject.opt("formData") instanceof JSONObject)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("formData");
                this.f47363c.put(str3, 0L);
                String name = file.getName();
                if (!TextUtils.isEmpty(name)) {
                    str4 = d.a.l0.a.v2.s.d(d.a.l0.a.v2.s.b(name));
                }
                str4 = IMAudioTransRequest.CONTENT_TYPE;
                d.a.l0.a.n1.c cVar = new d.a.l0.a.n1.c(file, str4, new b(length, str, str3, callbackHandler));
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
                    if (a0.f44625b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f47363c.put(str2, Long.valueOf(System.currentTimeMillis()));
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
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
        } finally {
            q(str4);
        }
    }
}
