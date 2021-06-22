package d.a.m0.c.a.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import d.a.m0.a.e2.c.h;
import d.a.m0.c.a.f;
import d.a.m0.c.a.g;
import d.a.m0.m.d.a;
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
    public String f50279d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f50280e = null;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f50281f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f50282g;

    /* renamed from: h  reason: collision with root package name */
    public a.C1132a f50283h;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public T f50284a;

        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
            }
            if (TextUtils.equals(str, "recovery")) {
                if (!g.l().m().b()) {
                    b.this.f50281f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                    return;
                }
                g.l().m().a();
                b.this.i(true);
                b.this.p();
                return;
            }
            g.l().m().k();
            b bVar = b.this;
            if (!bVar.f50286a) {
                if (bVar.f50281f != null) {
                    b.this.f50281f.onSuccess(this.f50284a, i2);
                    b.this.f50282g = 0;
                }
            } else if (bVar.f50287b == 1) {
                f.a("application");
                if (b.this.f50281f != null) {
                    b.this.f50281f.onSuccess(this.f50284a, i2);
                }
                b.this.f50282g = 0;
            } else if (b.m(bVar) >= 3) {
                ResponseCallback responseCallback = b.this.f50281f;
                responseCallback.onFail(new IOException("request fail : " + this.f50284a));
                b.this.f50282g = 0;
            } else {
                b bVar2 = b.this;
                bVar2.q(bVar2.f50279d, b.this.f50280e, b.this.f50281f);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
            }
            if (b.this.f50281f != null) {
                b.this.f50281f.onFail(exc);
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
            if (!bVar.f50286a) {
                if (bVar.f50281f != null) {
                    this.f50284a = (T) b.this.f50281f.parseResponse(response, i2);
                    return "";
                }
                return "";
            }
            ResponseBody body = response.body();
            String g2 = b.this.g(body.bytes());
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
            }
            if (b.this.f50287b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(g2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                if (b.this.f50281f != null) {
                    this.f50284a = (T) b.this.f50281f.parseResponse(build, i2);
                }
            }
            return g2;
        }
    }

    public static /* synthetic */ int m(b bVar) {
        int i2 = bVar.f50282g;
        bVar.f50282g = i2 + 1;
        return i2;
    }

    @Override // d.a.m0.c.a.k.c
    public String b() {
        return "POST";
    }

    @Override // d.a.m0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback = this.f50281f;
        if (responseCallback != null) {
            responseCallback.onFail(iOException);
        }
    }

    @Override // d.a.m0.c.a.k.c
    public void f(int i2) {
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "onRequestError=" + i2);
        }
        ResponseCallback<T> responseCallback = this.f50281f;
        if (responseCallback != null) {
            responseCallback.onFail(new Exception("request error  code : " + i2));
        }
    }

    @Override // d.a.m0.c.a.k.c
    public void h(byte[] bArr) {
        String str = this.f50279d;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.f50286a) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        h a2 = d.a.m0.a.c1.a.p().a();
        PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.m0.m.e.a.g().postByteRequest();
        a.C1132a c1132a = this.f50283h;
        if (c1132a != null) {
            postByteRequest.connectionTimeout(c1132a.f51760a).readTimeout(this.f50283h.f51761b).writeTimeout(this.f50283h.f51762c);
        }
        postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a());
    }

    public final void p() {
        q(this.f50279d, this.f50280e, this.f50281f);
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f50279d = str;
        this.f50280e = str2;
        this.f50281f = responseCallback;
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f50280e);
    }
}
