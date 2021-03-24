package d.b.g0.g.d.i;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b {
    public static final boolean k = k.f45050a;

    /* renamed from: d  reason: collision with root package name */
    public Callback f48072d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48073e;

    /* renamed from: f  reason: collision with root package name */
    public String f48074f;

    /* renamed from: g  reason: collision with root package name */
    public String f48075g;

    /* renamed from: h  reason: collision with root package name */
    public String f48076h;
    public String i;
    public int j;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {
        public a() {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.d.a.f48027a) {
                Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
            }
            if (c.this.f48072d != null) {
                if (exc instanceof IOException) {
                    c.this.f48072d.onFailure(null, (IOException) exc);
                } else {
                    c.this.f48072d.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            c.this.m(null, response);
            return response;
        }
    }

    public c(e eVar, JSONObject jSONObject, String str, Callback callback) {
        this.f48072d = callback;
        this.f48074f = str;
        l(jSONObject);
        c(this.f48073e.optString("method"));
    }

    @Override // d.b.g0.g.d.i.b
    public void d(IOException iOException) {
        Callback callback = this.f48072d;
        if (callback != null) {
            callback.onFailure(null, iOException);
        }
    }

    @Override // d.b.g0.g.d.i.b
    public void e(int i) {
        if (d.b.g0.g.d.a.f48027a) {
            Log.d("BdtlsRequestApi", "onRequestError=" + i);
        }
        Callback callback = this.f48072d;
        if (callback != null) {
            callback.onFailure(null, new IOException("request error  code : " + i));
        }
    }

    @Override // d.b.g0.g.d.i.b
    public void g(byte[] bArr) {
        JSONObject jSONObject;
        HttpRequest httpRequest;
        Callback callback;
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.f48073e.toString());
            try {
                Uri parse = Uri.parse(this.f48076h);
                String path = parse.getPath();
                String query = parse.getQuery();
                if (TextUtils.isEmpty(this.i)) {
                    str = "https://mbd.baidu.com/bdtls";
                } else {
                    str = this.i + "/bdtls";
                }
                StringBuilder sb = new StringBuilder(str + "/" + this.f48075g);
                String str3 = "";
                if (TextUtils.isEmpty(path)) {
                    path = "";
                }
                sb.append(path);
                if (!TextUtils.isEmpty(query)) {
                    str3 = "?" + query;
                }
                sb.append(str3);
                if (k) {
                    Log.d("BdtlsRequestApi", "bdtls url is : " + sb.toString());
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                if (this.f48069a) {
                    if (TextUtils.equals(b(), "GET")) {
                        str2 = Base64.encodeToString(bArr, 2);
                    } else {
                        jSONObject.putOpt("data", bArr);
                        str2 = "Bdtls";
                    }
                    optJSONObject.put("Bdtls", str2);
                }
                jSONObject.putOpt("header", optJSONObject);
                jSONObject.putOpt("url", sb.toString());
            } catch (JSONException e2) {
                e = e2;
                jSONObject2 = jSONObject;
                if (k) {
                    Log.e("BdtlsRequestApi", "Bdtls request data is invalid", e);
                }
                jSONObject = jSONObject2;
                httpRequest = (HttpRequest) d.b.g0.a.t.c.h.b.t(jSONObject, this.f48074f).first;
                if (httpRequest == null) {
                    callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                }
                k(httpRequest);
            }
        } catch (JSONException e3) {
            e = e3;
        }
        httpRequest = (HttpRequest) d.b.g0.a.t.c.h.b.t(jSONObject, this.f48074f).first;
        if (httpRequest == null && (callback = this.f48072d) != null) {
            callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
        }
        k(httpRequest);
    }

    public final void k(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return;
        }
        httpRequest.executeAsync(new a());
    }

    public final void l(JSONObject jSONObject) {
        this.f48073e = jSONObject;
        this.f48076h = jSONObject.optString("url");
        JSONObject optJSONObject = this.f48073e.optJSONObject("ext");
        if (optJSONObject != null) {
            this.i = optJSONObject.optString("customHost");
        }
    }

    public final void m(Call call, Response response) throws IOException {
        Headers headers = response.headers();
        if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
            d.b.g0.g.d.e.l().k().s(0);
            if (d.b.g0.g.d.e.l().k().b()) {
                d.b.g0.g.d.e.l().k().a();
                h(true);
                o();
                return;
            }
            this.f48072d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
            return;
        }
        d.b.g0.g.d.e.l().k().k();
        if (this.f48069a) {
            ResponseBody body = response.body();
            String f2 = f(body.bytes());
            if (d.b.g0.g.d.a.f48027a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + f2);
            }
            if (this.f48070b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(f2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                Callback callback = this.f48072d;
                if (callback != null) {
                    callback.onResponse(call, build);
                }
                this.j = 0;
                return;
            } else if (this.j < 3) {
                o();
                return;
            } else {
                this.f48072d.onFailure(call, new IOException("Url or serviceId is invalid"));
                this.j = 0;
                return;
            }
        }
        Callback callback2 = this.f48072d;
        if (callback2 != null) {
            callback2.onResponse(call, response);
        }
    }

    public void n(String str) {
        this.f48075g = str;
        JSONObject jSONObject = this.f48073e;
        a(jSONObject != null ? jSONObject.optString("data") : "");
    }

    public final void o() {
        this.j++;
        n(this.f48075g);
    }
}
