package d.a.i0.c.a.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import d.a.i0.a.k;
import d.a.i0.a.u.e.j.g;
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
public class d extends c {
    public static final boolean k = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public Callback f46331d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f46332e;

    /* renamed from: f  reason: collision with root package name */
    public String f46333f;

    /* renamed from: g  reason: collision with root package name */
    public String f46334g;

    /* renamed from: h  reason: collision with root package name */
    public String f46335h;

    /* renamed from: i  reason: collision with root package name */
    public String f46336i;
    public int j;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {
        public a() {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.c.a.a.f46273a) {
                Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
            }
            if (d.this.f46331d != null) {
                if (exc instanceof IOException) {
                    d.this.f46331d.onFailure(null, (IOException) exc);
                } else {
                    d.this.f46331d.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            d.this.n(null, response);
            return response;
        }
    }

    public d(d.a.i0.a.a2.e eVar, JSONObject jSONObject, String str, Callback callback) {
        this.f46331d = callback;
        this.f46333f = str;
        m(jSONObject);
        d(this.f46332e.optString("method"));
    }

    @Override // d.a.i0.c.a.k.c
    public void e(IOException iOException) {
        Callback callback = this.f46331d;
        if (callback != null) {
            callback.onFailure(null, iOException);
        }
    }

    @Override // d.a.i0.c.a.k.c
    public void f(int i2) {
        if (d.a.i0.c.a.a.f46273a) {
            Log.d("BdtlsRequestApi", "onRequestError=" + i2);
        }
        Callback callback = this.f46331d;
        if (callback != null) {
            callback.onFailure(null, new IOException("request error  code : " + i2));
        }
    }

    @Override // d.a.i0.c.a.k.c
    public void h(byte[] bArr) {
        JSONObject jSONObject;
        HttpRequest httpRequest;
        Callback callback;
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.f46332e.toString());
            try {
                Uri parse = Uri.parse(this.f46335h);
                String path = parse.getPath();
                String query = parse.getQuery();
                if (TextUtils.isEmpty(this.f46336i)) {
                    str = d.a.i0.c.a.b.f46275b;
                } else {
                    str = this.f46336i + "/bdtls";
                }
                StringBuilder sb = new StringBuilder(str + "/" + this.f46334g);
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
                if (this.f46328a) {
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
                httpRequest = (HttpRequest) g.u(jSONObject, this.f46333f).first;
                if (httpRequest == null) {
                    callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                }
                l(httpRequest);
            }
        } catch (JSONException e3) {
            e = e3;
        }
        httpRequest = (HttpRequest) g.u(jSONObject, this.f46333f).first;
        if (httpRequest == null && (callback = this.f46331d) != null) {
            callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
        }
        l(httpRequest);
    }

    public final void l(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return;
        }
        httpRequest.executeAsync(new a());
    }

    public final void m(JSONObject jSONObject) {
        this.f46332e = jSONObject;
        this.f46335h = jSONObject.optString("url");
        JSONObject optJSONObject = this.f46332e.optJSONObject("ext");
        if (optJSONObject != null) {
            this.f46336i = optJSONObject.optString("customHost");
        }
    }

    public final void n(Call call, Response response) throws IOException {
        Headers headers = response.headers();
        if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
            d.a.i0.c.a.g.l().m().s(0);
            if (d.a.i0.c.a.g.l().m().b()) {
                d.a.i0.c.a.g.l().m().a();
                i(true);
                p();
                return;
            }
            this.f46331d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
            return;
        }
        d.a.i0.c.a.g.l().m().k();
        if (this.f46328a) {
            ResponseBody body = response.body();
            String g2 = g(body.bytes());
            if (d.a.i0.c.a.a.f46273a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
            }
            if (this.f46329b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(g2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                Callback callback = this.f46331d;
                if (callback != null) {
                    callback.onResponse(call, build);
                }
                this.j = 0;
                return;
            } else if (this.j < 3) {
                p();
                return;
            } else {
                this.f46331d.onFailure(call, new IOException("Url or serviceId is invalid"));
                this.j = 0;
                return;
            }
        }
        Callback callback2 = this.f46331d;
        if (callback2 != null) {
            callback2.onResponse(call, response);
        }
    }

    public void o(String str) {
        this.f46334g = str;
        JSONObject jSONObject = this.f46332e;
        a(jSONObject != null ? jSONObject.optString("data") : "");
    }

    public final void p() {
        this.j++;
        o(this.f46334g);
    }
}
