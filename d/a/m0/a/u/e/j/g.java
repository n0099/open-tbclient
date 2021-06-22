package d.a.m0.a.u.e.j;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.facebook.common.internal.Sets;
import d.a.m0.a.j2.k;
import d.a.m0.a.u.c.d;
import d.a.m0.a.v2.q0;
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
public class g extends d.a.m0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f48831d = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f48832e = Sets.newHashSet("json", "string");

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f48833f = Sets.newHashSet("text", "arraybuffer");

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f48834g = Sets.newHashSet("REFERER", "USER-AGENT");

    /* loaded from: classes2.dex */
    public class a implements d.b {
        public a(g gVar) {
        }

        @Override // d.a.m0.a.u.c.d.b
        public d.a.m0.a.u.h.b a(d.a.m0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("cancelTag");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.m0.a.u.h.b(202, "illegal cancelTag");
            }
            SwanAppNetworkUtils.a(d.a.m0.m.e.a.g().getOkHttpClient(), optString);
            return new d.a.m0.a.u.h.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f48835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48836f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48837g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48838h;

        public b(d.a.m0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
            this.f48835e = eVar;
            this.f48836f = jSONObject;
            this.f48837g = str;
            this.f48838h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.F(this.f48835e, this.f48836f, this.f48837g, this.f48838h);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements StatResponseCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f48841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48842g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48843h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f48844i;
        public final /* synthetic */ e j;

        public c(g gVar, String str, HttpUrl httpUrl, String str2, int i2, long j, e eVar) {
            this.f48840e = str;
            this.f48841f = httpUrl;
            this.f48842g = str2;
            this.f48843h = i2;
            this.f48844i = j;
            this.j = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            k.z(this.f48842g, this.f48843h, null, this.f48844i, System.currentTimeMillis());
            if (exc instanceof IOException) {
                this.j.onFailure(null, (IOException) exc);
            } else {
                this.j.onFailure(null, new IOException("request fail"));
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            d.a.m0.a.h0.q.b.g().u(this.f48840e, this.f48841f, networkStatRecord);
            k.z(this.f48842g, this.f48843h, networkStatRecord, this.f48844i, System.currentTimeMillis());
            this.j.onResponse(null, response);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.m0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48845e;

        public d(String str) {
            this.f48845e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            g.this.d(this.f48845e, new d.a.m0.a.u.h.b(1001, str));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.a2.e f48847a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f48848b;

        /* renamed from: c  reason: collision with root package name */
        public String f48849c;

        /* renamed from: d  reason: collision with root package name */
        public String f48850d;

        /* renamed from: e  reason: collision with root package name */
        public f f48851e;

        /* renamed from: f  reason: collision with root package name */
        public String f48852f;

        /* renamed from: g  reason: collision with root package name */
        public long f48853g = System.currentTimeMillis();

        public e(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
            this.f48847a = eVar;
            this.f48848b = jSONObject;
            this.f48849c = str;
            this.f48850d = str2;
            this.f48851e = fVar;
            this.f48852f = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Request", "onFailure: " + iOException.getMessage());
            }
            int G = this.f48847a.N().G();
            String l = k.l();
            String f2 = q0.n().f();
            SwanAppNetworkUtils.a(d.a.m0.m.e.a.g().getOkHttpClient(), this.f48850d);
            g.this.d(this.f48852f, new d.a.m0.a.u.h.b(1001, iOException.getMessage()));
            k.K(0, this.f48849c, G, iOException.getMessage(), l, f2, this.f48853g, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (!k.n(this.f48849c)) {
                d.a.m0.a.l2.b.l().x(this.f48849c, response.headers("Set-cookie"));
            }
            String B = g.B(this.f48848b);
            String D = g.D(this.f48848b);
            int G = this.f48847a.N().G();
            long currentTimeMillis = System.currentTimeMillis();
            String l = k.l();
            String f2 = q0.n().f();
            try {
                long C = g.C(response);
                if (C <= Config.FULL_TRACE_LOG_LIMIT) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", h.g(response.headers()));
                    g.J(jSONObject, response.body(), B, D);
                    if (this.f48851e != null) {
                        this.f48851e.a(jSONObject);
                    }
                    g.this.d(this.f48852f, new d.a.m0.a.u.h.b(0, jSONObject, true));
                } else {
                    g.K(this.f48847a, this.f48849c, C, currentTimeMillis);
                    g.this.d(this.f48852f, new d.a.m0.a.u.h.b(201, "response json length over limits"));
                }
            } catch (IOException | JSONException e2) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    Log.d("Api-Request", Log.getStackTraceString(e2));
                }
                g.this.d(this.f48852f, new d.a.m0.a.u.h.b(201, e2.getMessage()));
            }
            int code = response.code();
            String message = response.message();
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Request", "onResponse: respCode: " + code + ", url=" + this.f48849c + ", msg=" + message);
            }
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("TAG", response.headers().toString());
            }
            k.K(code, this.f48849c, G, message, l, f2, this.f48853g, System.currentTimeMillis());
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(JSONObject jSONObject);
    }

    public g(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    @NonNull
    public static String B(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("dataType");
        return TextUtils.isEmpty(optString) ? "json" : !f48832e.contains(optString) ? "string" : optString;
    }

    public static long C(Response response) {
        if (response.body() != null) {
            return response.body().contentLength();
        }
        return 0L;
    }

    @NonNull
    public static String D(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("responseType");
        return !f48833f.contains(optString) ? "text" : optString;
    }

    public static boolean G(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().startsWith(PreferencesUtil.LEFT_MOUNT);
    }

    public static boolean H(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.trim().startsWith(StringUtil.ARRAY_START) && str.trim().endsWith("}")) || (str.trim().startsWith(PreferencesUtil.LEFT_MOUNT) && str.trim().endsWith(PreferencesUtil.RIGHT_MOUNT));
    }

    public static Object I(@NonNull JSONObject jSONObject, @Nullable String str) {
        Object opt = jSONObject.opt("data");
        if (TextUtils.equals(str, "base64")) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Request", "buildRequest: request with base64Data");
            }
            if (opt instanceof String) {
                opt = Base64.decode((String) opt, 2);
            } else if (d.a.m0.a.u.c.d.f48594c) {
                StringBuilder sb = new StringBuilder();
                sb.append("buildRequest: base64Data is illegal ");
                sb.append(opt == null);
                throw new RuntimeException(sb.toString());
            }
        } else if (opt instanceof JsArrayBuffer) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Request", "buildRequest: request with arrayBuffer");
            }
            opt = ((JsArrayBuffer) opt).buffer();
            if (d.a.m0.a.u.c.d.f48594c && opt == null) {
                throw new RuntimeException("buildRequest: request with a null buffer");
            }
        }
        if (d.a.m0.a.u.c.d.f48594c) {
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
    public static void J(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
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
                if (H(str3)) {
                    str3 = G(str3) ? new JSONArray(str3) : new JSONObject(str3);
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void K(d.a.m0.a.a2.e eVar, String str, long j, long j2) {
        if (eVar == null || TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(5L);
        aVar.h(39L);
        d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(eVar.L());
        dVar.q(k.m(d.a.m0.a.a2.d.g().l()));
        dVar.m(d.a.m0.a.a2.d.g().getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionUrl", str);
            jSONObject.put("exceptionAppID", eVar.D());
            jSONObject.put("exceptionLength", j);
            jSONObject.put("exceptionRequestTime", j2);
            jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
            dVar.e(jSONObject);
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e2.printStackTrace();
            }
        }
        k.L(dVar);
    }

    public static void O(String str, @NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            String str2 = "";
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !f48834g.contains(next.toUpperCase())) {
                    String f2 = q0.f(jSONObject.optString(next));
                    if (TextUtils.isEmpty(f2)) {
                        f2 = "";
                    }
                    if (map != null) {
                        map.put(next.toLowerCase(), f2);
                    }
                    if ("Cookie".equalsIgnoreCase(next)) {
                        str2 = f2;
                    }
                    httpRequestBuilder.addHeader(next, f2);
                }
            }
            s(httpRequestBuilder, str, str2);
            return;
        }
        s(httpRequestBuilder, str, "");
    }

    @NonNull
    public static d.a.m0.a.u.h.b P(int i2) {
        String str = "illegal request";
        int i3 = 202;
        if (i2 == 0) {
            i3 = 0;
            str = "";
        } else if (i2 != 1) {
            if (i2 == 2) {
                str = "request url header must be https or wss";
            } else if (i2 == 3) {
                str = "request:fail parameter error: arrayBuffer of data exceed size limit.";
            } else if (i2 == 4) {
                str = "HTTP method is invalid";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new d.a.m0.a.u.h.b(i3);
        }
        return new d.a.m0.a.u.h.b(i3, str);
    }

    public static void s(@NonNull HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        if (k.n(str)) {
            return;
        }
        String f2 = d.a.m0.a.l2.b.l().f(str, str2);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        httpRequestBuilder.setHeader("Cookie", f2);
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Request", "addCookiesToHeader cookie: " + f2);
        }
    }

    @NonNull
    public static HttpUrl t(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Request", "appendQueryTo: hint jsonToString");
            }
            try {
                obj = new JSONObject((String) obj);
            } catch (JSONException unused) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    throw new RuntimeException("appendQueryTo: illegal json str");
                }
            }
        }
        if (!(obj instanceof JSONObject)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.w("Api-Request", "appendQueryTo: data cannot be " + obj.getClass().getSimpleName());
            }
            return httpUrl;
        }
        if (d.a.m0.a.u.c.d.f48594c) {
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

    /* JADX WARN: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<HttpRequest, Integer> u(@Nullable JSONObject jSONObject, @Nullable String str) {
        int i2;
        String str2;
        RequestBody y;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            HttpUrl f2 = h.f(jSONObject.optString("url"));
            if (f2 == null) {
                return new Pair<>(null, 0);
            }
            String httpUrl = f2.toString();
            String optString = jSONObject.optString("__plugin__");
            boolean optBoolean = jSONObject.optBoolean("ping", false);
            if (optBoolean) {
                i2 = 0;
            } else {
                i2 = d.a.m0.a.b2.a.b.c("request", httpUrl, optString);
                if (i2 != 0) {
                    return new Pair<>(null, Integer.valueOf(i2));
                }
            }
            String optString2 = jSONObject.optString("method");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "GET";
            }
            String upperCase = optString2.toUpperCase();
            if (!f48831d.contains(upperCase)) {
                return new Pair<>(null, 4);
            }
            HashMap hashMap = new HashMap();
            d.a.m0.m.d.a aVar = new d.a.m0.m.d.a();
            aVar.f51752b = upperCase;
            HttpRequestBuilder a2 = d.a.m0.m.e.b.a(aVar);
            O(httpUrl, a2, jSONObject.optJSONObject("header"), hashMap);
            a2.setHeader("Referer", h.d());
            if (!TextUtils.isEmpty(optString)) {
                a2.setHeader("X-SWAN-HOSTSIGN", d.a.m0.a.t1.g.a.b(d.a.m0.a.t1.g.b.h(optString)));
            }
            String optString3 = jSONObject.optString("__requestDataType__");
            Object I = I(jSONObject, optString3);
            if (I instanceof byte[]) {
                int length = ((byte[]) I).length;
                str2 = optString3;
                if (length > Config.FULL_TRACE_LOG_LIMIT) {
                    if (d.a.m0.a.u.c.d.f48594c) {
                        Log.d("Api-Request", "buildRequest: ArrayBuffer大小超过上限 " + length);
                    }
                    return new Pair<>(null, 3);
                }
            } else {
                str2 = optString3;
            }
            boolean z = I != null;
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                f2 = t(f2, I, str2);
            } else {
                String str3 = str2;
                if (z || HttpMethod.requiresRequestBody(upperCase)) {
                    y = y(I, hashMap, str3);
                    if (!HttpMethod.requiresRequestBody(upperCase) && y == null) {
                        return new Pair<>(null, Integer.valueOf(i2));
                    }
                    if (a2 instanceof HttpCommonRequestBuilder) {
                        ((HttpCommonRequestBuilder) a2).requestBody(y);
                    }
                    aVar.f51751a = f2.toString();
                    aVar.f51756f = true;
                    aVar.f51757g = false;
                    aVar.f51758h = true;
                    aVar.f51759i = str;
                    aVar.k = 3;
                    d.a.m0.m.e.a.g().t(a2, aVar);
                    HttpRequest build = a2.build();
                    if (!optBoolean) {
                        build = d.a.m0.a.n1.o.c.e(build, "request", optString);
                    }
                    d.a.m0.a.h0.q.b.g().l(str, f2);
                    return new Pair<>(build, Integer.valueOf(i2));
                }
            }
            y = null;
            if (!HttpMethod.requiresRequestBody(upperCase)) {
            }
            if (a2 instanceof HttpCommonRequestBuilder) {
            }
            aVar.f51751a = f2.toString();
            aVar.f51756f = true;
            aVar.f51757g = false;
            aVar.f51758h = true;
            aVar.f51759i = str;
            aVar.k = 3;
            d.a.m0.m.e.a.g().t(a2, aVar);
            HttpRequest build2 = a2.build();
            if (!optBoolean) {
            }
            d.a.m0.a.h0.q.b.g().l(str, f2);
            return new Pair<>(build2, Integer.valueOf(i2));
        }
        return new Pair<>(null, 0);
    }

    public static RequestBody x(MediaType mediaType, @NonNull byte[] bArr) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Request", "createArrayBufferBody: " + bArr.length);
        }
        return RequestBody.create(mediaType, bArr);
    }

    @Nullable
    public static RequestBody y(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        String str2 = map.get("content-type");
        boolean isEmpty = TextUtils.isEmpty(str2);
        String str3 = StringUtil.NULL_STRING;
        if (isEmpty) {
            if (d.a.m0.a.u.c.d.f48594c) {
                StringBuilder sb = new StringBuilder();
                sb.append("createBody: content-type: ");
                sb.append(d.a.m0.a.n1.f.f47477a);
                sb.append(" data: ");
                if (obj != null) {
                    str3 = obj.getClass().getSimpleName();
                }
                sb.append(str3);
                Log.d("Api-Request", sb.toString());
            }
            if (obj instanceof byte[]) {
                return x(d.a.m0.a.n1.f.f47477a, (byte[]) obj);
            }
            return RequestBody.create(d.a.m0.a.n1.f.f47477a, obj != null ? obj.toString() : "");
        }
        MediaType parse = MediaType.parse(str2);
        if (d.a.m0.a.n1.f.f47477a.equals(parse)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("createBody: content-type: ");
                sb2.append(d.a.m0.a.n1.f.f47477a);
                sb2.append(" data: ");
                if (obj != null) {
                    str3 = obj.getClass().getSimpleName();
                }
                sb2.append(str3);
                Log.d("Api-Request", sb2.toString());
            }
            if (obj instanceof byte[]) {
                return x(d.a.m0.a.n1.f.f47477a, (byte[]) obj);
            }
            return RequestBody.create(d.a.m0.a.n1.f.f47477a, obj != null ? obj.toString() : "");
        }
        return z(obj, parse, str);
    }

    public static RequestBody z(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        FormBody.Builder builder = new FormBody.Builder();
        if (obj instanceof byte[]) {
            return x(mediaType, (byte[]) obj);
        }
        if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Request", "createFormBody: hint jsonToString");
            }
            try {
                obj = new JSONObject((String) obj);
            } catch (JSONException unused) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    throw new RuntimeException("createFormBody: illegal json str");
                }
            }
        }
        if (obj != null && obj.toString().length() != 0) {
            if (obj instanceof String) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    Log.d("Api-Request", "createFormBody: content-type: " + mediaType + " data: String");
                }
                return RequestBody.create(mediaType, (String) obj);
            }
            if (d.a.m0.a.u.c.d.f48594c) {
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
            return d.a.m0.a.n1.d.a(builder.build(), mediaType);
        }
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Request", "createFormBody: with empty data");
        }
        return builder.build();
    }

    public void A(d.a.m0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
        if (d.a.m0.a.r1.l.e.l()) {
            F(eVar, jSONObject, str, str2);
        } else {
            ExecutorUtilsExt.postOnElastic(new b(eVar, jSONObject, str, str2), "doRequest", 0);
        }
    }

    public final void E(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, f fVar, @NonNull String str2) {
        HttpUrl url = httpRequest.getOkRequest().url();
        String httpUrl = url.toString();
        if (w(eVar, jSONObject, httpUrl, str, fVar, str2)) {
            return;
        }
        httpRequest.executeStat(new c(this, str, url, httpUrl, eVar.N().G(), System.currentTimeMillis(), new e(eVar, jSONObject, httpUrl, str, fVar, str2)));
    }

    public final void F(d.a.m0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
        Pair<HttpRequest, Integer> u = u(jSONObject, str);
        HttpRequest httpRequest = (HttpRequest) u.first;
        if (httpRequest == null) {
            d(str2, P(((Integer) u.second).intValue()));
        } else {
            E(eVar, jSONObject, httpRequest, str, null, str2);
        }
    }

    public d.a.m0.a.u.h.b L(JsObject jsObject) {
        Pair<d.a.m0.a.u.h.a, JSONObject> n = d.a.m0.a.u.c.d.n(jsObject);
        if (!((d.a.m0.a.u.h.a) n.first).isSuccess()) {
            return (d.a.m0.a.u.h.b) n.first;
        }
        JSONObject jSONObject = (JSONObject) n.second;
        if (jSONObject == null) {
            return (d.a.m0.a.u.h.b) d.a.m0.a.u.h.a.f49019a;
        }
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Request", "request with JsObject => JSONObject : " + jSONObject.toString());
        }
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return new d.a.m0.a.u.h.b(1001, "swan app is null");
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("Api-Request", "callback is null");
            return new d.a.m0.a.u.h.b(1001, "callback is null");
        }
        return M(i2, jSONObject, optString);
    }

    public final d.a.m0.a.u.h.b M(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(jSONObject.optString("url"))) {
            d.a.m0.a.e0.d.b("Api-Request", "illegal url");
            return new d.a.m0.a.u.h.b(1001, "illegal url");
        }
        String a2 = h.a(eVar.f44533f);
        JSONObject c2 = h.c(a2);
        d.a.m0.a.u.f.a.d().c(new d.a.m0.a.u.f.b.g.c(this, eVar, jSONObject, a2, str));
        return new d.a.m0.a.u.h.b(0, c2);
    }

    public d.a.m0.a.u.h.b N(@NonNull JSONObject jSONObject) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Request", "request with JSONObject: " + jSONObject);
        }
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return new d.a.m0.a.u.h.b(1001, "swan app is null");
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("Api-Request", "callback is null");
            return new d.a.m0.a.u.h.b(202, "callback is null");
        }
        return M(i2, jSONObject, optString);
    }

    public d.a.m0.a.u.h.b v(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Request", "start cancelRequest");
        }
        return j(str, false, new a(this));
    }

    public final boolean w(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
        return d.a.m0.a.c1.a.d().i(eVar, jSONObject, str, str2, new e(eVar, jSONObject, str, str2, fVar, str3), new d(str3));
    }
}
