package d.a.h0.g.d.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.h0.g.d.e;
import d.a.h0.g.d.f;
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
    public String f46254d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f46255e = null;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f46256f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f46257g;

    /* renamed from: d.a.h0.g.d.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0930a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public T f46258a;

        public C0930a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (d.a.h0.g.d.a.f46216a) {
                Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
            }
            if (TextUtils.equals(str, "recovery")) {
                if (!e.l().k().b()) {
                    a.this.f46256f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                    return;
                }
                e.l().k().a();
                a.this.h(true);
                a.this.o();
                return;
            }
            e.l().k().k();
            a aVar = a.this;
            if (!aVar.f46260a) {
                if (aVar.f46256f != null) {
                    a.this.f46256f.onSuccess(this.f46258a, i2);
                    a.this.f46257g = 0;
                }
            } else if (aVar.f46261b == 1) {
                f.a("application");
                if (a.this.f46256f != null) {
                    a.this.f46256f.onSuccess(this.f46258a, i2);
                }
                a.this.f46257g = 0;
            } else if (a.l(aVar) >= 3) {
                ResponseCallback responseCallback = a.this.f46256f;
                responseCallback.onFail(new IOException("request fail : " + this.f46258a));
                a.this.f46257g = 0;
            } else {
                a aVar2 = a.this;
                aVar2.p(aVar2.f46254d, a.this.f46255e, a.this.f46256f);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.d.a.f46216a) {
                Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
            }
            if (a.this.f46256f != null) {
                a.this.f46256f.onFail(exc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            Headers headers = response.headers();
            if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                e.l().k().s(0);
                return "recovery";
            }
            a aVar = a.this;
            if (!aVar.f46260a) {
                if (aVar.f46256f != null) {
                    this.f46258a = (T) a.this.f46256f.parseResponse(response, i2);
                    return "";
                }
                return "";
            }
            ResponseBody body = response.body();
            String f2 = a.this.f(body.bytes());
            if (d.a.h0.g.d.a.f46216a) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + f2);
            }
            if (a.this.f46261b == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(f2, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                if (a.this.f46256f != null) {
                    this.f46258a = (T) a.this.f46256f.parseResponse(build, i2);
                }
            }
            return f2;
        }
    }

    public static /* synthetic */ int l(a aVar) {
        int i2 = aVar.f46257g;
        aVar.f46257g = i2 + 1;
        return i2;
    }

    @Override // d.a.h0.g.d.i.b
    public String b() {
        return "POST";
    }

    @Override // d.a.h0.g.d.i.b
    public void d(IOException iOException) {
        ResponseCallback<T> responseCallback = this.f46256f;
        if (responseCallback != null) {
            responseCallback.onFail(iOException);
        }
    }

    @Override // d.a.h0.g.d.i.b
    public void e(int i2) {
        if (d.a.h0.g.d.a.f46216a) {
            Log.d("BDTLS", "onRequestError=" + i2);
        }
        ResponseCallback<T> responseCallback = this.f46256f;
        if (responseCallback != null) {
            responseCallback.onFail(new Exception("request error  code : " + i2));
        }
    }

    @Override // d.a.h0.g.d.i.b
    public void g(byte[] bArr) {
        String str = this.f46254d;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.f46260a) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (d.a.h0.g.d.a.f46216a) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        d.a.h0.k.e.a.f().postByteRequest().mediaType("application/json").url(str).cookieManager(d.a.h0.a.w0.a.m().a()).headers(hashMap).content(bArr).build().executeAsync(new C0930a());
    }

    public final void o() {
        p(this.f46254d, this.f46255e, this.f46256f);
    }

    public void p(String str, String str2, ResponseCallback<T> responseCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46254d = str;
        this.f46255e = str2;
        this.f46256f = responseCallback;
        if (d.a.h0.g.d.a.f46216a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f46255e);
    }
}
