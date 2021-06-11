package d.a.l0.c.a.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import d.a.l0.a.e2.c.h;
import d.a.l0.c.a.f;
import d.a.l0.c.a.g;
import d.a.l0.m.d.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes3.dex */
public class b<T> extends c {

    /* renamed from: d  reason: collision with root package name */
    public String f50171d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f50172e = null;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f50173f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f50174g;

    /* renamed from: h  reason: collision with root package name */
    public a.C1129a f50175h;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public T f50176a;

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (d.a.l0.c.a.a.f50123a) {
                Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
            }
            if (TextUtils.equals(str, "recovery")) {
                if (!g.l().m().b()) {
                    b.this.f50173f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                    return;
                }
                g.l().m().a();
                b.this.i(true);
                b.this.p();
                return;
            }
            g.l().m().k();
            b bVar = b.this;
            if (!bVar.f50178a) {
                if (bVar.f50173f != null) {
                    b.this.f50173f.onSuccess(this.f50176a, i2);
                    b.this.f50174g = 0;
                }
            } else if (bVar.f50179b == 1) {
                f.a("application");
                if (b.this.f50173f != null) {
                    b.this.f50173f.onSuccess(this.f50176a, i2);
                }
                b.this.f50174g = 0;
            } else if (b.m(bVar) >= 3) {
                ResponseCallback responseCallback = b.this.f50173f;
                responseCallback.onFail(new IOException("request fail : " + this.f50176a));
                b.this.f50174g = 0;
            } else {
                b bVar2 = b.this;
                bVar2.q(bVar2.f50171d, b.this.f50172e, b.this.f50173f);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.l0.c.a.a.f50123a) {
                Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
            }
            if (b.this.f50173f != null) {
                b.this.f50173f.onFail(exc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            Headers headers = response.headers();
            String str = headers.get("Bdtls");
            if (headers != null && TextUtils.equals(str, "recovery")) {
                g.l().m().s(0);
                return "recovery";
            }
            b bVar = b.this;
            if (!bVar.f50178a) {
                if (bVar.f50173f != null) {
                    this.f50176a = (T) b.this.f50173f.parseResponse(response, i2);
                    return "";
                }
                return "";
            }
            ResponseBody body = response.body();
            String g2 = b.this.g(body.bytes());
            if (d.a.l0.c.a.a.f50123a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
            }
            if (b.this.f50179b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(g2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                if (b.this.f50173f != null) {
                    this.f50176a = (T) b.this.f50173f.parseResponse(build, i2);
                }
            }
            return g2;
        }
    }

    public static /* synthetic */ int m(b bVar) {
        int i2 = bVar.f50174g;
        bVar.f50174g = i2 + 1;
        return i2;
    }

    @Override // d.a.l0.c.a.k.c
    public String b() {
        return "POST";
    }

    @Override // d.a.l0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback = this.f50173f;
        if (responseCallback != null) {
            responseCallback.onFail(iOException);
        }
    }

    @Override // d.a.l0.c.a.k.c
    public void f(int i2) {
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BDTLS", "onRequestError=" + i2);
        }
        ResponseCallback<T> responseCallback = this.f50173f;
        if (responseCallback != null) {
            responseCallback.onFail(new Exception("request error  code : " + i2));
        }
    }

    @Override // d.a.l0.c.a.k.c
    public void h(byte[] bArr) {
        String str = this.f50171d;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.f50178a) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        h a2 = d.a.l0.a.c1.a.p().a();
        PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.l0.m.e.a.g().postByteRequest();
        a.C1129a c1129a = this.f50175h;
        if (c1129a != null) {
            postByteRequest.connectionTimeout(c1129a.f51652a).readTimeout(this.f50175h.f51653b).writeTimeout(this.f50175h.f51654c);
        }
        postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a());
    }

    public final void p() {
        q(this.f50171d, this.f50172e, this.f50173f);
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f50171d = str;
        this.f50172e = str2;
        this.f50173f = responseCallback;
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f50172e);
    }
}
