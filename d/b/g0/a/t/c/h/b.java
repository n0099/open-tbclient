package d.b.g0.a.t.c.h;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.facebook.common.internal.Sets;
import d.b.g0.a.g1.f;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t.b.d;
import d.b.g0.a.z1.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f46085d = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f46086e = Sets.newHashSet("json", "string");

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f46087f = Sets.newHashSet("text", "arraybuffer");

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f46088g = Sets.newHashSet("REFERER", "USER-AGENT");

    /* loaded from: classes2.dex */
    public class a implements d.b {
        public a(b bVar) {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("cancelTag");
            if (TextUtils.isEmpty(optString)) {
                return new d.b.g0.a.t.e.b(202, "illegal cancelTag");
            }
            SwanAppNetworkUtils.a(d.b.g0.k.e.a.f().getOkHttpClient(), optString);
            return new d.b.g0.a.t.e.b(0);
        }
    }

    /* renamed from: d.b.g0.a.t.c.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0817b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46090f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46091g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46092h;

        public RunnableC0817b(JSONObject jSONObject, String str, String str2, d.b.g0.a.r1.e eVar) {
            this.f46089e = jSONObject;
            this.f46090f = str;
            this.f46091g = str2;
            this.f46092h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<HttpRequest, Integer> t = b.t(this.f46089e, this.f46090f);
            HttpRequest httpRequest = (HttpRequest) t.first;
            if (httpRequest == null) {
                b.this.c(this.f46091g, b.this.N(((Integer) t.second).intValue()));
                return;
            }
            b.this.D(this.f46092h, this.f46089e, httpRequest, this.f46090f, null, this.f46091g);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements StatResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46093a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f46094b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46095c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f46096d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f46097e;

        public c(b bVar, String str, HttpUrl httpUrl, String str2, int i, d dVar) {
            this.f46093a = str;
            this.f46094b = httpUrl;
            this.f46095c = str2;
            this.f46096d = i;
            this.f46097e = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.a.w0.a.N().d()) {
                h.x(this.f46095c, this.f46096d, null);
            }
            if (exc instanceof IOException) {
                this.f46097e.onFailure(null, (IOException) exc);
            } else {
                this.f46097e.onFailure(null, new IOException("request fail"));
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            d.b.g0.a.e0.s.a.e().n(this.f46093a, this.f46094b, networkStatRecord);
            if (d.b.g0.a.w0.a.N().d()) {
                h.x(this.f46095c, this.f46096d, networkStatRecord);
            }
            this.f46097e.onResponse(null, response);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.a.r1.e f46098a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f46099b;

        /* renamed from: c  reason: collision with root package name */
        public String f46100c;

        /* renamed from: d  reason: collision with root package name */
        public String f46101d;

        /* renamed from: e  reason: collision with root package name */
        public e f46102e;

        /* renamed from: f  reason: collision with root package name */
        public String f46103f;

        /* renamed from: g  reason: collision with root package name */
        public long f46104g = System.currentTimeMillis();

        public d(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, e eVar2, @NonNull String str3) {
            this.f46098a = eVar;
            this.f46099b = jSONObject;
            this.f46100c = str;
            this.f46101d = str2;
            this.f46102e = eVar2;
            this.f46103f = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "onFailure: " + iOException.getMessage());
            }
            int F = this.f46098a.L().F();
            String m = h.m();
            String d2 = k0.n().d();
            SwanAppNetworkUtils.a(d.b.g0.k.e.a.f().getOkHttpClient(), this.f46101d);
            b.this.c(this.f46103f, new d.b.g0.a.t.e.b(1001, iOException.getMessage()));
            h.G(0, this.f46100c, F, iOException.getMessage(), m, d2, this.f46104g, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String A = b.A(this.f46099b);
            String C = b.C(this.f46099b);
            int F = this.f46098a.L().F();
            long currentTimeMillis = System.currentTimeMillis();
            String m = h.m();
            String d2 = k0.n().d();
            try {
                long B = b.B(response);
                if (B <= Config.FULL_TRACE_LOG_LIMIT) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", d.b.g0.a.t.c.h.c.f(response.headers()));
                    b.H(jSONObject, response.body(), A, C);
                    if (this.f46102e != null) {
                        this.f46102e.a(jSONObject);
                    }
                    b.this.c(this.f46103f, new d.b.g0.a.t.e.b(0, jSONObject, true));
                } else {
                    b.I(this.f46098a, this.f46100c, B, currentTimeMillis);
                    b.this.c(this.f46103f, new d.b.g0.a.t.e.b(201, "response json length over limits"));
                }
            } catch (IOException | JSONException e2) {
                if (d.b.g0.a.t.b.d.f45929c) {
                    Log.d("Api-Request", Log.getStackTraceString(e2));
                }
                b.this.c(this.f46103f, new d.b.g0.a.t.e.b(201, e2.getMessage()));
            }
            int code = response.code();
            String message = response.message();
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "onResponse: respCode: " + code + ", url=" + this.f46100c + ", msg=" + message);
            }
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("TAG", response.headers().toString());
            }
            h.G(code, this.f46100c, F, message, m, d2, this.f46104g, System.currentTimeMillis());
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(JSONObject jSONObject);
    }

    public b(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    @NonNull
    public static String A(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("dataType");
        return TextUtils.isEmpty(optString) ? "json" : !f46086e.contains(optString) ? "string" : optString;
    }

    public static long B(Response response) {
        if (response.body() != null) {
            return response.body().contentLength();
        }
        return 0L;
    }

    @NonNull
    public static String C(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("responseType");
        return !f46087f.contains(optString) ? "text" : optString;
    }

    public static boolean E(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().startsWith("[");
    }

    public static boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.trim().startsWith(StringUtil.ARRAY_START) && str.trim().endsWith("}")) || (str.trim().startsWith("[") && str.trim().endsWith("]"));
    }

    public static Object G(@NonNull JSONObject jSONObject, @Nullable String str) {
        Object opt = jSONObject.opt("data");
        if (TextUtils.equals(str, "base64")) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "buildRequest: request with base64Data");
            }
            if (opt instanceof String) {
                opt = Base64.decode((String) opt, 2);
            } else if (d.b.g0.a.t.b.d.f45929c) {
                StringBuilder sb = new StringBuilder();
                sb.append("buildRequest: base64Data is illegal ");
                sb.append(opt == null);
                throw new RuntimeException(sb.toString());
            }
        } else if (opt instanceof JsArrayBuffer) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "buildRequest: request with arrayBuffer");
            }
            opt = ((JsArrayBuffer) opt).buffer();
            if (d.b.g0.a.t.b.d.f45929c && opt == null) {
                throw new RuntimeException("buildRequest: request with a null buffer");
            }
        }
        if (d.b.g0.a.t.b.d.f45929c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("parseRequestData: data: ");
            sb2.append(opt == null ? StringUtil.NULL_STRING : opt.getClass().getSimpleName());
            sb2.append(" requestDataType: ");
            sb2.append(str);
            Log.d("Api-Request", sb2.toString());
        }
        return opt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v9, types: [org.json.JSONArray] */
    public static void H(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        String str3;
        if (responseBody == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != 3556653) {
            if (hashCode == 1154818009 && str2.equals("arraybuffer")) {
                c2 = 0;
            }
        } else if (str2.equals("text")) {
            c2 = 1;
        }
        if (c2 != 0) {
            str3 = responseBody.string();
        } else {
            byte[] bytes = responseBody.bytes();
            str3 = bytes == null ? null : new String(Base64.encode(bytes, 2));
            str = "string";
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (TextUtils.equals(str, "json")) {
            try {
                if (F(str3)) {
                    str3 = E(str3) ? new JSONArray(str3) : new JSONObject(str3);
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void I(d.b.g0.a.r1.e eVar, String str, long j, long j2) {
        if (eVar == null || TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(5L);
        aVar.h(39L);
        d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
        dVar.p(aVar);
        dVar.r(eVar.J());
        dVar.q(h.n(d.b.g0.a.r1.d.e().h()));
        dVar.m(d.b.g0.a.r1.d.e().getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionUrl", str);
            jSONObject.put("exceptionAppID", eVar.B());
            jSONObject.put("exceptionLength", j);
            jSONObject.put("exceptionRequestTime", j2);
            jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
            dVar.e(jSONObject);
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
        }
        h.H(dVar);
    }

    public static void M(@NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject == null || jSONObject.length() < 1) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && !f46088g.contains(next.toUpperCase())) {
                String g2 = k0.g(jSONObject.optString(next));
                if (TextUtils.isEmpty(g2)) {
                    g2 = "";
                }
                if (map != null) {
                    map.put(next.toLowerCase(), g2);
                }
                httpRequestBuilder.addHeader(next, g2);
            }
        }
    }

    @NonNull
    public static HttpUrl s(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "appendQueryTo: hint jsonToString");
            }
            try {
                obj = new JSONObject((String) obj);
            } catch (JSONException unused) {
                if (d.b.g0.a.t.b.d.f45929c) {
                    throw new RuntimeException("appendQueryTo: illegal json str");
                }
            }
        }
        if (!(obj instanceof JSONObject)) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.w("Api-Request", "appendQueryTo: data cannot be " + obj.getClass().getSimpleName());
            }
            return httpUrl;
        }
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Request", "appendQueryTo with JSONObject");
        }
        boolean z = false;
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                String optString = jSONObject.optString(next);
                if (TextUtils.isEmpty(optString)) {
                    optString = "";
                }
                newBuilder.addQueryParameter(next, optString);
                z = true;
            }
        }
        return z ? newBuilder.build() : httpUrl;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<HttpRequest, Integer> t(@Nullable JSONObject jSONObject, @Nullable String str) {
        int i;
        int i2;
        RequestBody x;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            HttpUrl e2 = d.b.g0.a.t.c.h.c.e(jSONObject.optString("url"));
            if (e2 == null) {
                return new Pair<>(null, 0);
            }
            String url = e2.url().toString();
            String optString = jSONObject.optString("__plugin__");
            boolean optBoolean = jSONObject.optBoolean("ping", false);
            if (optBoolean) {
                i = 0;
            } else {
                i = d.b.g0.a.s1.a.b.c("request", url, optString);
                if (i != 0) {
                    return new Pair<>(null, Integer.valueOf(i));
                }
            }
            String optString2 = jSONObject.optString("method");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "GET";
            }
            String upperCase = optString2.toUpperCase();
            if (!f46085d.contains(upperCase)) {
                return new Pair<>(null, 4);
            }
            HashMap hashMap = new HashMap();
            d.b.g0.k.d.a aVar = new d.b.g0.k.d.a();
            aVar.f48880b = upperCase;
            HttpRequestBuilder a2 = d.b.g0.k.e.b.a(aVar);
            M(a2, jSONObject.optJSONObject("header"), hashMap);
            a2.setHeader("Referer", d.b.g0.a.t.c.h.c.d());
            if (!TextUtils.isEmpty(optString)) {
                a2.setHeader("X-SWAN-HOSTSIGN", d.b.g0.a.l1.g.a.b(d.b.g0.a.l1.g.b.g(optString)));
            }
            String optString3 = jSONObject.optString("__requestDataType__");
            Object G = G(jSONObject, optString3);
            if (G instanceof byte[]) {
                int length = ((byte[]) G).length;
                i2 = i;
                if (length > Config.FULL_TRACE_LOG_LIMIT) {
                    if (d.b.g0.a.t.b.d.f45929c) {
                        Log.d("Api-Request", "buildRequest: ArrayBuffer大小超过上限 " + length);
                    }
                    return new Pair<>(null, 3);
                }
            } else {
                i2 = i;
            }
            boolean z = G != null;
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                e2 = s(e2, G, optString3);
            } else if (z || HttpMethod.requiresRequestBody(upperCase)) {
                x = x(G, hashMap, optString3);
                if (!HttpMethod.requiresRequestBody(upperCase) && x == null) {
                    return new Pair<>(null, Integer.valueOf(i2));
                }
                if (a2 instanceof HttpCommonRequestBuilder) {
                    ((HttpCommonRequestBuilder) a2).requestBody(x);
                }
                aVar.f48879a = e2.toString();
                aVar.f48884f = true;
                aVar.f48885g = false;
                aVar.f48886h = true;
                aVar.i = str;
                d.b.g0.k.e.a.f().s(a2, aVar);
                HttpRequest build = a2.enableStat(true).build();
                if (!optBoolean) {
                    build = d.b.g0.a.g1.m.c.e(build, "request", optString);
                }
                d.b.g0.a.e0.s.a.e().g(str, e2);
                return new Pair<>(build, Integer.valueOf(i2));
            }
            x = null;
            if (!HttpMethod.requiresRequestBody(upperCase)) {
            }
            if (a2 instanceof HttpCommonRequestBuilder) {
            }
            aVar.f48879a = e2.toString();
            aVar.f48884f = true;
            aVar.f48885g = false;
            aVar.f48886h = true;
            aVar.i = str;
            d.b.g0.k.e.a.f().s(a2, aVar);
            HttpRequest build2 = a2.enableStat(true).build();
            if (!optBoolean) {
            }
            d.b.g0.a.e0.s.a.e().g(str, e2);
            return new Pair<>(build2, Integer.valueOf(i2));
        }
        return new Pair<>(null, 0);
    }

    public static RequestBody w(MediaType mediaType, @NonNull byte[] bArr) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Request", "createArrayBufferBody: " + bArr.length);
        }
        return RequestBody.create(mediaType, bArr);
    }

    @Nullable
    public static RequestBody x(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        String str2 = map.get("content-type");
        boolean isEmpty = TextUtils.isEmpty(str2);
        String str3 = StringUtil.NULL_STRING;
        if (isEmpty) {
            if (d.b.g0.a.t.b.d.f45929c) {
                StringBuilder sb = new StringBuilder();
                sb.append("createBody: content-type: ");
                sb.append(f.f44518a);
                sb.append(" data: ");
                if (obj != null) {
                    str3 = obj.getClass().getSimpleName();
                }
                sb.append(str3);
                Log.d("Api-Request", sb.toString());
            }
            if (obj instanceof byte[]) {
                return w(f.f44518a, (byte[]) obj);
            }
            return RequestBody.create(f.f44518a, obj != null ? obj.toString() : "");
        }
        MediaType parse = MediaType.parse(str2);
        if (f.f44518a.equals(parse)) {
            if (d.b.g0.a.t.b.d.f45929c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("createBody: content-type: ");
                sb2.append(f.f44518a);
                sb2.append(" data: ");
                if (obj != null) {
                    str3 = obj.getClass().getSimpleName();
                }
                sb2.append(str3);
                Log.d("Api-Request", sb2.toString());
            }
            if (obj instanceof byte[]) {
                return w(f.f44518a, (byte[]) obj);
            }
            return RequestBody.create(f.f44518a, obj != null ? obj.toString() : "");
        }
        return y(obj, parse, str);
    }

    public static RequestBody y(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        FormBody.Builder builder = new FormBody.Builder();
        if (obj instanceof byte[]) {
            return w(mediaType, (byte[]) obj);
        }
        if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "createFormBody: hint jsonToString");
            }
            try {
                obj = new JSONObject((String) obj);
            } catch (JSONException unused) {
                if (d.b.g0.a.t.b.d.f45929c) {
                    throw new RuntimeException("createFormBody: illegal json str");
                }
            }
        }
        if (obj != null && obj.toString().length() != 0) {
            if (obj instanceof String) {
                if (d.b.g0.a.t.b.d.f45929c) {
                    Log.d("Api-Request", "createFormBody: content-type: " + mediaType + " data: String");
                }
                return RequestBody.create(mediaType, (String) obj);
            }
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "createFormBody: content-type: " + mediaType + " data: " + obj.getClass().getSimpleName());
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        builder.add(next, jSONObject.optString(next));
                    }
                }
            }
            return d.b.g0.a.g1.d.a(builder.build(), mediaType);
        }
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Request", "createFormBody: with empty data");
        }
        return builder.build();
    }

    public final void D(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, e eVar2, @NonNull String str2) {
        HttpUrl url = httpRequest.getOkRequest().url();
        String httpUrl = url.toString();
        if (v(eVar, jSONObject, httpUrl, str, eVar2, str2)) {
            return;
        }
        int F = eVar.L().F();
        if (!d.b.g0.a.w0.a.N().d()) {
            h.x(httpUrl, F, null);
        }
        httpRequest.executeStat(new c(this, str, url, httpUrl, F, new d(eVar, jSONObject, httpUrl, str, eVar2, str2)));
    }

    public d.b.g0.a.t.e.b J(JsObject jsObject) {
        Pair<d.b.g0.a.t.e.a, JSONObject> m = d.b.g0.a.t.b.d.m(jsObject);
        if (!((d.b.g0.a.t.e.a) m.first).b()) {
            return (d.b.g0.a.t.e.b) m.first;
        }
        JSONObject jSONObject = (JSONObject) m.second;
        if (jSONObject == null) {
            return (d.b.g0.a.t.e.b) d.b.g0.a.t.e.a.f46214a;
        }
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Request", "request with JsObject => JSONObject : " + jSONObject.toString());
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-Request", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        return K(y, jSONObject, optString);
    }

    public final d.b.g0.a.t.e.b K(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(jSONObject.optString("url"))) {
            d.b.g0.a.c0.c.b("Api-Request", "illegal url");
            return new d.b.g0.a.t.e.b(1001, "illegal url");
        }
        String a2 = d.b.g0.a.t.c.h.c.a(eVar.f45740f);
        JSONObject c2 = d.b.g0.a.t.c.h.c.c(a2);
        z(eVar, jSONObject, a2, str);
        return new d.b.g0.a.t.e.b(0, c2);
    }

    public d.b.g0.a.t.e.b L(@NonNull JSONObject jSONObject) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Request", "request with JSONObject: " + jSONObject);
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-Request", "callback is null");
            return new d.b.g0.a.t.e.b(202, "callback is null");
        }
        return K(y, jSONObject, optString);
    }

    public final d.b.g0.a.t.e.b N(int i) {
        String str = "illegal request";
        int i2 = 202;
        if (i == 0) {
            i2 = 0;
            str = "";
        } else if (i != 1) {
            if (i == 2) {
                str = "request url header must be https or wss";
            } else if (i == 3) {
                str = "request:fail parameter error: arrayBuffer of data exceed size limit.";
            } else if (i == 4) {
                str = "HTTP method is invalid";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new d.b.g0.a.t.e.b(i2);
        }
        return new d.b.g0.a.t.e.b(i2, str);
    }

    public d.b.g0.a.t.e.b u(String str) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Request", "start cancelRequest");
        }
        return i(str, false, new a(this));
    }

    public final boolean v(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, e eVar2, @NonNull String str3) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
            return false;
        }
        String optString = optJSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
        if (TextUtils.isEmpty(optString)) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Request", "onFailure: serviceId is invalid");
            }
            c(str3, new d.b.g0.a.t.e.b(1001, "serviceId is invalid"));
            return true;
        }
        h.x(str, eVar.L().F(), null);
        new d.b.g0.g.d.i.c(eVar, jSONObject, str2, new d(eVar, jSONObject, str, str2, eVar2, str3)).n(optString);
        return true;
    }

    public final void z(d.b.g0.a.r1.e eVar, JSONObject jSONObject, String str, String str2) {
        ExecutorUtilsExt.postOnElastic(new RunnableC0817b(jSONObject, str, str2, eVar), "doRequest", 2);
    }
}
