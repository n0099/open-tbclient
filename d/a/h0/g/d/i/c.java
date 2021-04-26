package d.a.h0.g.d.i;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
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
    public static final boolean k = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public Callback f46263d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f46264e;

    /* renamed from: f  reason: collision with root package name */
    public String f46265f;

    /* renamed from: g  reason: collision with root package name */
    public String f46266g;

    /* renamed from: h  reason: collision with root package name */
    public String f46267h;

    /* renamed from: i  reason: collision with root package name */
    public String f46268i;
    public int j;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {
        public a() {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.d.a.f46216a) {
                Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
            }
            if (c.this.f46263d != null) {
                if (exc instanceof IOException) {
                    c.this.f46263d.onFailure(null, (IOException) exc);
                } else {
                    c.this.f46263d.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            c.this.m(null, response);
            return response;
        }
    }

    public c(e eVar, JSONObject jSONObject, String str, Callback callback) {
        this.f46263d = callback;
        this.f46265f = str;
        l(jSONObject);
        c(this.f46264e.optString("method"));
    }

    @Override // d.a.h0.g.d.i.b
    public void d(IOException iOException) {
        Callback callback = this.f46263d;
        if (callback != null) {
            callback.onFailure(null, iOException);
        }
    }

    @Override // d.a.h0.g.d.i.b
    public void e(int i2) {
        if (d.a.h0.g.d.a.f46216a) {
            Log.d("BdtlsRequestApi", "onRequestError=" + i2);
        }
        Callback callback = this.f46263d;
        if (callback != null) {
            callback.onFailure(null, new IOException("request error  code : " + i2));
        }
    }

    @Override // d.a.h0.g.d.i.b
    public void g(byte[] bArr) {
        JSONObject jSONObject;
        HttpRequest httpRequest;
        Callback callback;
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.f46264e.toString());
            try {
                Uri parse = Uri.parse(this.f46267h);
                String path = parse.getPath();
                String query = parse.getQuery();
                if (TextUtils.isEmpty(this.f46268i)) {
                    str = "https://mbd.baidu.com/bdtls";
                } else {
                    str = this.f46268i + "/bdtls";
                }
                StringBuilder sb = new StringBuilder(str + "/" + this.f46266g);
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
                if (this.f46260a) {
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
                httpRequest = (HttpRequest) d.a.h0.a.t.c.h.b.t(jSONObject, this.f46265f).first;
                if (httpRequest == null) {
                    callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                }
                k(httpRequest);
            }
        } catch (JSONException e3) {
            e = e3;
        }
        httpRequest = (HttpRequest) d.a.h0.a.t.c.h.b.t(jSONObject, this.f46265f).first;
        if (httpRequest == null && (callback = this.f46263d) != null) {
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
        this.f46264e = jSONObject;
        this.f46267h = jSONObject.optString("url");
        JSONObject optJSONObject = this.f46264e.optJSONObject("ext");
        if (optJSONObject != null) {
            this.f46268i = optJSONObject.optString("customHost");
        }
    }

    public final void m(Call call, Response response) throws IOException {
        Headers headers = response.headers();
        if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
            d.a.h0.g.d.e.l().k().s(0);
            if (d.a.h0.g.d.e.l().k().b()) {
                d.a.h0.g.d.e.l().k().a();
                h(true);
                o();
                return;
            }
            this.f46263d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
            return;
        }
        d.a.h0.g.d.e.l().k().k();
        if (this.f46260a) {
            ResponseBody body = response.body();
            String f2 = f(body.bytes());
            if (d.a.h0.g.d.a.f46216a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + f2);
            }
            if (this.f46261b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(f2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                Callback callback = this.f46263d;
                if (callback != null) {
                    callback.onResponse(call, build);
                }
                this.j = 0;
                return;
            } else if (this.j < 3) {
                o();
                return;
            } else {
                this.f46263d.onFailure(call, new IOException("Url or serviceId is invalid"));
                this.j = 0;
                return;
            }
        }
        Callback callback2 = this.f46263d;
        if (callback2 != null) {
            callback2.onResponse(call, response);
        }
    }

    public void n(String str) {
        this.f46266g = str;
        JSONObject jSONObject = this.f46264e;
        a(jSONObject != null ? jSONObject.optString("data") : "");
    }

    public final void o() {
        this.j++;
        n(this.f46266g);
    }
}
