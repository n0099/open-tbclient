package d.a.l0.c.a.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import d.a.l0.a.k;
import d.a.l0.a.u.e.j.g;
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
    public static final boolean k = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public Callback f50181d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f50182e;

    /* renamed from: f  reason: collision with root package name */
    public String f50183f;

    /* renamed from: g  reason: collision with root package name */
    public String f50184g;

    /* renamed from: h  reason: collision with root package name */
    public String f50185h;

    /* renamed from: i  reason: collision with root package name */
    public String f50186i;
    public int j;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {
        public a() {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.l0.c.a.a.f50123a) {
                Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
            }
            if (d.this.f50181d != null) {
                if (exc instanceof IOException) {
                    d.this.f50181d.onFailure(null, (IOException) exc);
                } else {
                    d.this.f50181d.onFailure(null, new IOException(exc));
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

    public d(d.a.l0.a.a2.e eVar, JSONObject jSONObject, String str, Callback callback) {
        this.f50181d = callback;
        this.f50183f = str;
        m(jSONObject);
        d(this.f50182e.optString("method"));
    }

    @Override // d.a.l0.c.a.k.c
    public void e(IOException iOException) {
        Callback callback = this.f50181d;
        if (callback != null) {
            callback.onFailure(null, iOException);
        }
    }

    @Override // d.a.l0.c.a.k.c
    public void f(int i2) {
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BdtlsRequestApi", "onRequestError=" + i2);
        }
        Callback callback = this.f50181d;
        if (callback != null) {
            callback.onFailure(null, new IOException("request error  code : " + i2));
        }
    }

    @Override // d.a.l0.c.a.k.c
    public void h(byte[] bArr) {
        JSONObject jSONObject;
        HttpRequest httpRequest;
        Callback callback;
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.f50182e.toString());
            try {
                Uri parse = Uri.parse(this.f50185h);
                String path = parse.getPath();
                String query = parse.getQuery();
                if (TextUtils.isEmpty(this.f50186i)) {
                    str = d.a.l0.c.a.b.f50125b;
                } else {
                    str = this.f50186i + "/bdtls";
                }
                StringBuilder sb = new StringBuilder(str + "/" + this.f50184g);
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
                if (this.f50178a) {
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
                httpRequest = (HttpRequest) g.u(jSONObject, this.f50183f).first;
                if (httpRequest == null) {
                    callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                }
                l(httpRequest);
            }
        } catch (JSONException e3) {
            e = e3;
        }
        httpRequest = (HttpRequest) g.u(jSONObject, this.f50183f).first;
        if (httpRequest == null && (callback = this.f50181d) != null) {
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
        this.f50182e = jSONObject;
        this.f50185h = jSONObject.optString("url");
        JSONObject optJSONObject = this.f50182e.optJSONObject("ext");
        if (optJSONObject != null) {
            this.f50186i = optJSONObject.optString("customHost");
        }
    }

    public final void n(Call call, Response response) throws IOException {
        Headers headers = response.headers();
        if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
            d.a.l0.c.a.g.l().m().s(0);
            if (d.a.l0.c.a.g.l().m().b()) {
                d.a.l0.c.a.g.l().m().a();
                i(true);
                p();
                return;
            }
            this.f50181d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
            return;
        }
        d.a.l0.c.a.g.l().m().k();
        if (this.f50178a) {
            ResponseBody body = response.body();
            String g2 = g(body.bytes());
            if (d.a.l0.c.a.a.f50123a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
            }
            if (this.f50179b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(g2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                Callback callback = this.f50181d;
                if (callback != null) {
                    callback.onResponse(call, build);
                }
                this.j = 0;
                return;
            } else if (this.j < 3) {
                p();
                return;
            } else {
                this.f50181d.onFailure(call, new IOException("Url or serviceId is invalid"));
                this.j = 0;
                return;
            }
        }
        Callback callback2 = this.f50181d;
        if (callback2 != null) {
            callback2.onResponse(call, response);
        }
    }

    public void o(String str) {
        this.f50184g = str;
        JSONObject jSONObject = this.f50182e;
        a(jSONObject != null ? jSONObject.optString("data") : "");
    }

    public final void p() {
        this.j++;
        o(this.f50184g);
    }
}
