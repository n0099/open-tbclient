package d.b.g0.g.w.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.facebook.common.internal.Sets;
import d.b.g0.a.g1.f;
import d.b.g0.a.z1.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class c extends d.b.g0.g.w.a {
    public static final Set<String> l = Sets.newHashSet("text", "arraybuffer");
    public static final Set<String> m = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    /* loaded from: classes3.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49008a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f49009b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49010c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.w.b f49011d;

        public a(String str, long j, String str2, d.b.g0.g.w.b bVar) {
            this.f49008a = str;
            this.f49009b = j;
            this.f49010c = str2;
            this.f49011d = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f49011d.cancelTag(c.this.f48979g);
            c.this.Z(this.f49008a, 0, iOException.getMessage(), this.f49009b);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful()) {
                c.this.Z(this.f49008a, response.code(), response.message(), this.f49009b);
                return;
            }
            try {
                JSEvent jSEvent = new JSEvent("headersReceived");
                jSEvent.data = new e(c.this.L(response.headers()));
                c.this.dispatchEvent(jSEvent);
            } catch (JSONException e2) {
                if (d.b.g0.g.w.a.i) {
                    e2.printStackTrace();
                }
            }
            String str = this.f49010c;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3556653) {
                if (hashCode == 1154818009 && str.equals("arraybuffer")) {
                    c2 = 0;
                }
            } else if (str.equals("text")) {
                c2 = 1;
            }
            if (c2 != 0) {
                c.this.a0(this.f49008a, response);
            } else {
                c.this.Y(this.f49008a, response);
            }
            int code = response.code();
            String message = response.message();
            if (d.b.g0.g.w.a.i) {
                Log.d("RequestTask", "onResponse: id:" + c.this.f48979g + ",respCode: " + code + ", url=" + this.f49008a + ", msg=" + message);
            }
            h.F(code, this.f49008a, 1, message, this.f49009b, System.currentTimeMillis());
        }
    }

    public c(d.b.g0.g.i.b bVar, d.b.g0.g.e.d.c cVar) {
        super(bVar, cVar);
        this.f48977e = 1;
    }

    @NonNull
    public static String X(@NonNull d.b.g0.g.e.d.c cVar) {
        String lowerCase = cVar.B("responseType").toLowerCase();
        return !l.contains(lowerCase) ? "text" : lowerCase;
    }

    @Override // d.b.g0.g.w.a
    public void F(String str, int i, String str2) {
        super.F(str, i, str2);
        d.b.g0.g.c0.c.h(str, i, str2, SwanAppNetworkUtils.h(null));
    }

    public final Request U() {
        String C = C();
        if (TextUtils.isEmpty(C)) {
            if (d.b.g0.g.w.a.i) {
                Log.d("RequestTask", "buildRequest url =" + C);
            }
            return null;
        }
        String B = this.f48978f.B("method");
        if (TextUtils.isEmpty(B)) {
            B = "GET";
        }
        String upperCase = B.toUpperCase();
        if (!m.contains(upperCase)) {
            F(C, -1, "request:method is invalid");
            return null;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        J(builder, this.f48978f.w("header"), hashMap, true);
        if (d.b.g0.g.w.a.i) {
            Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
        }
        Object C2 = this.f48978f.C("data", null);
        if (C2 == null) {
            C2 = this.f48978f.t("data", null);
        }
        boolean z = C2 != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            return builder.url(C).method(upperCase, null).tag(this.f48979g).build();
        }
        RequestBody V = (z || HttpMethod.requiresRequestBody(upperCase)) ? V(C2, hashMap) : null;
        if (HttpMethod.requiresRequestBody(upperCase) && V == null) {
            return null;
        }
        return builder.url(C).method(upperCase, V).tag(this.f48979g).build();
    }

    @Nullable
    public final RequestBody V(Object obj, Map<String, String> map) {
        String str = map.get("content-type");
        MediaType mediaType = f.f44910a;
        if (!TextUtils.isEmpty(str)) {
            mediaType = MediaType.parse(str);
        }
        if (obj instanceof JsArrayBuffer) {
            byte[] buffer = ((JsArrayBuffer) obj).buffer();
            if (buffer == null) {
                return RequestBody.create(mediaType, "");
            }
            return RequestBody.create(mediaType, buffer);
        } else if (obj instanceof String) {
            if (d.b.g0.g.w.a.i) {
                Log.d("RequestTask", "createBody = " + obj);
            }
            return RequestBody.create(mediaType, (String) obj);
        } else {
            return RequestBody.create(mediaType, "");
        }
    }

    public void W(Request request) {
        String X = X(this.f48978f);
        String httpUrl = request.url().toString();
        if (d.b.g0.a.r1.e.y() == null) {
            F("", -1, "request:swanApp is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        h.x(httpUrl, 1, null);
        d.b.g0.g.w.b V = d.b.g0.a.r1.e.y().V();
        V.b(request, new a(httpUrl, currentTimeMillis, X, V));
    }

    public final void Y(String str, Response response) {
        byte[] bytes;
        if (response == null) {
            return;
        }
        try {
            d.b.g0.g.w.g.a aVar = new d.b.g0.g.w.g.a();
            aVar.statusCode = response.code();
            aVar.header = L(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                aVar.data = new JsArrayBuffer(bytes, bytes.length);
            }
            G(aVar);
        } catch (IOException | JSONException e2) {
            if (d.b.g0.g.w.a.i) {
                Log.d("RequestTask", Log.getStackTraceString(e2));
            }
            F(str, -1, e2.getMessage());
        }
    }

    public final void Z(String str, int i, String str2, long j) {
        if (d.b.g0.g.w.a.i) {
            Log.d("RequestTask", "onFailure: " + str2);
        }
        if (ResponseException.CANCELED.equalsIgnoreCase(str2)) {
            str2 = "request:fail abort";
        }
        String str3 = str2;
        F(str, i, str3);
        if (SwanAppNetworkUtils.h(null)) {
            h.F(i, str, 1, str3, j, System.currentTimeMillis());
        }
    }

    public final void a0(String str, Response response) {
        if (response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            d dVar = new d();
            dVar.statusCode = response.code();
            dVar.header = L(response.headers());
            if (body != null) {
                dVar.data = body.string();
                if (d.b.g0.g.w.a.i) {
                    Log.d("RequestTask", "onStringResponse = " + dVar.data);
                }
            }
            G(dVar);
        } catch (IOException | JSONException e2) {
            if (d.b.g0.g.w.a.i) {
                Log.d("RequestTask", Log.getStackTraceString(e2));
            }
            F(str, -1, e2.getMessage());
        }
    }

    public void start() {
        Request U;
        if (this.f48978f == null || (U = U()) == null) {
            return;
        }
        W(U);
    }
}
