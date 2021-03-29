package d.b.g0.g.d.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.g0.g.d.e;
import d.b.g0.g.d.f;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes3.dex */
public class a<T> extends b {

    /* renamed from: d  reason: collision with root package name */
    public String f48064d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f48065e = null;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f48066f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f48067g;

    /* renamed from: d.b.g0.g.d.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0959a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public T f48068a;

        public C0959a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            if (d.b.g0.g.d.a.f48028a) {
                Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
            }
            if (TextUtils.equals(str, "recovery")) {
                if (!e.l().k().b()) {
                    a.this.f48066f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                    return;
                }
                e.l().k().a();
                a.this.h(true);
                a.this.o();
                return;
            }
            e.l().k().k();
            a aVar = a.this;
            if (!aVar.f48070a) {
                if (aVar.f48066f != null) {
                    a.this.f48066f.onSuccess(this.f48068a, i);
                    a.this.f48067g = 0;
                }
            } else if (aVar.f48071b == 1) {
                f.a("application");
                if (a.this.f48066f != null) {
                    a.this.f48066f.onSuccess(this.f48068a, i);
                }
                a.this.f48067g = 0;
            } else if (a.l(aVar) >= 3) {
                ResponseCallback responseCallback = a.this.f48066f;
                responseCallback.onFail(new IOException("request fail : " + this.f48068a));
                a.this.f48067g = 0;
            } else {
                a aVar2 = a.this;
                aVar2.p(aVar2.f48064d, a.this.f48065e, a.this.f48066f);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.d.a.f48028a) {
                Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
            }
            if (a.this.f48066f != null) {
                a.this.f48066f.onFail(exc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            Headers headers = response.headers();
            if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                e.l().k().s(0);
                return "recovery";
            }
            a aVar = a.this;
            if (!aVar.f48070a) {
                if (aVar.f48066f != null) {
                    this.f48068a = (T) a.this.f48066f.parseResponse(response, i);
                    return "";
                }
                return "";
            }
            ResponseBody body = response.body();
            String f2 = a.this.f(body.bytes());
            if (d.b.g0.g.d.a.f48028a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + f2);
            }
            if (a.this.f48071b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(f2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                if (a.this.f48066f != null) {
                    this.f48068a = (T) a.this.f48066f.parseResponse(build, i);
                }
            }
            return f2;
        }
    }

    public static /* synthetic */ int l(a aVar) {
        int i = aVar.f48067g;
        aVar.f48067g = i + 1;
        return i;
    }

    @Override // d.b.g0.g.d.i.b
    public String b() {
        return "POST";
    }

    @Override // d.b.g0.g.d.i.b
    public void d(IOException iOException) {
        ResponseCallback<T> responseCallback = this.f48066f;
        if (responseCallback != null) {
            responseCallback.onFail(iOException);
        }
    }

    @Override // d.b.g0.g.d.i.b
    public void e(int i) {
        if (d.b.g0.g.d.a.f48028a) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        ResponseCallback<T> responseCallback = this.f48066f;
        if (responseCallback != null) {
            responseCallback.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // d.b.g0.g.d.i.b
    public void g(byte[] bArr) {
        String str = this.f48064d;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.f48070a) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (d.b.g0.g.d.a.f48028a) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        d.b.g0.k.e.a.f().postByteRequest().mediaType("application/json").url(str).cookieManager(d.b.g0.a.w0.a.m().a()).headers(hashMap).content(bArr).build().executeAsync(new C0959a());
    }

    public final void o() {
        p(this.f48064d, this.f48065e, this.f48066f);
    }

    public void p(String str, String str2, ResponseCallback<T> responseCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f48064d = str;
        this.f48065e = str2;
        this.f48066f = responseCallback;
        if (d.b.g0.g.d.a.f48028a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f48065e);
    }
}
