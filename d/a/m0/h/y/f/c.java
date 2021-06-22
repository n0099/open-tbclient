package d.a.m0.h.y.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.facebook.common.internal.Sets;
import d.a.m0.a.j2.k;
import d.a.m0.a.n1.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
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
public class c extends d.a.m0.h.y.a {
    public static final Set<String> l = Sets.newHashSet("text", "arraybuffer");
    public static final Set<String> m = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    /* loaded from: classes3.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f51534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51535c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.y.b f51536d;

        public a(String str, long j, String str2, d.a.m0.h.y.b bVar) {
            this.f51533a = str;
            this.f51534b = j;
            this.f51535c = str2;
            this.f51536d = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f51536d.cancelTag(c.this.f51504g);
            c.this.Y(this.f51533a, 0, iOException.getMessage(), this.f51534b);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful()) {
                c.this.Y(this.f51533a, response.code(), response.message(), this.f51534b);
                return;
            }
            try {
                JSEvent jSEvent = new JSEvent("headersReceived");
                jSEvent.data = new e(c.this.K(response.headers()));
                c.this.dispatchEvent(jSEvent);
            } catch (JSONException e2) {
                if (d.a.m0.h.y.a.f51501i) {
                    e2.printStackTrace();
                }
            }
            String str = this.f51535c;
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
                c.this.Z(this.f51533a, response);
            } else {
                c.this.X(this.f51533a, response);
            }
            int code = response.code();
            String message = response.message();
            if (d.a.m0.h.y.a.f51501i) {
                Log.d("RequestTask", "onResponse: id:" + c.this.f51504g + ",respCode: " + code + ", url=" + this.f51533a + ", msg=" + message);
            }
            k.J(code, this.f51533a, 1, message, this.f51534b, System.currentTimeMillis());
        }
    }

    public c(d.a.m0.a.l0.c cVar, d.a.m0.a.y.b.a aVar) {
        super(cVar, aVar);
        this.f51502e = 1;
    }

    @NonNull
    public static String W(@NonNull d.a.m0.a.y.b.a aVar) {
        String lowerCase = aVar.C("responseType").toLowerCase(Locale.US);
        return !l.contains(lowerCase) ? "text" : lowerCase;
    }

    @Override // d.a.m0.h.y.a
    public void E(String str, int i2, String str2) {
        super.E(str, i2, str2);
        d.a.m0.h.f0.e.h(str, i2, str2, SwanAppNetworkUtils.i(null));
    }

    public final Request T() {
        String B = B();
        if (TextUtils.isEmpty(B)) {
            if (d.a.m0.h.y.a.f51501i) {
                Log.d("RequestTask", "buildRequest url =" + B);
            }
            return null;
        }
        String C = this.f51503f.C("method");
        if (TextUtils.isEmpty(C)) {
            C = "GET";
        }
        String upperCase = C.toUpperCase(Locale.US);
        if (!m.contains(upperCase)) {
            E(B, -1, "request:method is invalid");
            return null;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        I(builder, this.f51503f.x("header"), hashMap, true);
        if (d.a.m0.h.y.a.f51501i) {
            Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
        }
        Object D = this.f51503f.D("data", null);
        if (D == null) {
            D = this.f51503f.u("data", null);
        }
        boolean z = D != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            return builder.url(B).method(upperCase, null).tag(this.f51504g).build();
        }
        RequestBody U = (z || HttpMethod.requiresRequestBody(upperCase)) ? U(D, hashMap) : null;
        if (HttpMethod.requiresRequestBody(upperCase) && U == null) {
            return null;
        }
        return builder.url(B).method(upperCase, U).tag(this.f51504g).build();
    }

    @Nullable
    public final RequestBody U(Object obj, Map<String, String> map) {
        String str = map.get("content-type");
        MediaType mediaType = f.f47477a;
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
            if (d.a.m0.h.y.a.f51501i) {
                Log.d("RequestTask", "createBody = " + obj);
            }
            return RequestBody.create(mediaType, (String) obj);
        } else {
            return RequestBody.create(mediaType, "");
        }
    }

    public void V(Request request) {
        String W = W(this.f51503f);
        String httpUrl = request.url().toString();
        if (d.a.m0.a.a2.e.i() == null) {
            E("", -1, "request:swanApp is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        k.y(httpUrl, 1, null);
        d.a.m0.h.y.b bVar = (d.a.m0.h.y.b) d.a.m0.a.a2.e.i().X();
        bVar.b(request, new a(httpUrl, currentTimeMillis, W, bVar));
    }

    public final void X(String str, Response response) {
        byte[] bytes;
        if (response == null) {
            return;
        }
        try {
            d.a.m0.h.y.f.a aVar = new d.a.m0.h.y.f.a();
            aVar.statusCode = response.code();
            aVar.header = K(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                aVar.data = new JsArrayBuffer(bytes, bytes.length);
            }
            F(aVar);
        } catch (IOException | JSONException e2) {
            if (d.a.m0.h.y.a.f51501i) {
                Log.d("RequestTask", Log.getStackTraceString(e2));
            }
            E(str, -1, e2.getMessage());
        }
    }

    public final void Y(String str, int i2, String str2, long j) {
        if (d.a.m0.h.y.a.f51501i) {
            Log.d("RequestTask", "onFailure: " + str2);
        }
        if (ResponseException.CANCELED.equalsIgnoreCase(str2)) {
            str2 = "request:fail abort";
        }
        String str3 = str2;
        E(str, i2, str3);
        if (SwanAppNetworkUtils.i(null)) {
            k.J(i2, str, 1, str3, j, System.currentTimeMillis());
        }
    }

    public final void Z(String str, Response response) {
        if (response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            d dVar = new d();
            dVar.statusCode = response.code();
            dVar.header = K(response.headers());
            if (body != null) {
                dVar.data = body.string();
                if (d.a.m0.h.y.a.f51501i) {
                    Log.d("RequestTask", "onStringResponse = " + dVar.data);
                }
            }
            F(dVar);
        } catch (IOException | JSONException e2) {
            if (d.a.m0.h.y.a.f51501i) {
                Log.d("RequestTask", Log.getStackTraceString(e2));
            }
            E(str, -1, e2.getMessage());
        }
    }

    public void start() {
        Request T;
        if (this.f51503f == null || (T = T()) == null) {
            return;
        }
        V(T);
    }
}
