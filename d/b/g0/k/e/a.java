package d.b.g0.k.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import d.b.g0.k.c.c;
import d.b.g0.k.c.d;
import d.b.g0.k.c.e;
import d.b.g0.k.c.f;
import d.b.g0.k.c.g;
import d.b.g0.k.c.h;
import d.b.g0.k.c.i;
import d.b.g0.k.c.j;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a extends HttpManager {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48886a = d.b.g0.k.b.b();

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f48887b;

    /* renamed from: d.b.g0.k.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1016a extends ResponseCallback {
        public C1016a(a aVar) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f48886a) {
                Log.e("SwanHttpManager", "request is fail");
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            if (a.f48886a) {
                Log.w("SwanHttpManager", "response is ignore");
            }
            return response;
        }
    }

    public a() {
        super(d.b.g0.k.b.a().f());
    }

    public static a f() {
        if (f48887b == null) {
            synchronized (a.class) {
                if (f48887b == null) {
                    f48887b = new a();
                }
            }
        }
        return f48887b;
    }

    public static a g(Context context) {
        return f();
    }

    public d.b.g0.k.c.a b() {
        return new d.b.g0.k.c.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: c */
    public d.b.g0.k.c.b deleteRequest() {
        return new d.b.g0.k.c.b(this);
    }

    public void d(d.b.g0.k.d.a aVar) {
        aVar.f48879b = "GET";
        r(aVar);
    }

    public void e(d.b.g0.k.d.a aVar) {
        aVar.f48879b = "POST";
        r(aVar);
    }

    public OkHttpClient.Builder h() {
        return getOkHttpClient().newBuilder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: i */
    public c getRequest() {
        return new c(this);
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> d2 = d.b.g0.k.b.a().d();
        if (d2 == null || d2.size() <= 0) {
            return initClient;
        }
        OkHttpClient.Builder newBuilder = initClient.newBuilder();
        for (Interceptor interceptor : d2) {
            newBuilder.addNetworkInterceptor(interceptor);
        }
        return newBuilder.build();
    }

    public final ResponseCallback j() {
        return new C1016a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: k */
    public d headerRequest() {
        return new d(this);
    }

    public final boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f48886a) {
                Log.e("SwanHttpManager", "url is empty");
                return true;
            }
            return true;
        }
        return false;
    }

    public e m() {
        return new e(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: n */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: o */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public i putRequest() {
        return new i(this);
    }

    public void r(@NonNull d.b.g0.k.d.a aVar) {
        if (aVar.f48882e == null) {
            aVar.f48882e = j();
        }
        if (l(aVar.f48878a)) {
            aVar.f48882e.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder a2 = b.a(aVar);
        s(a2, aVar);
        a2.build().executeAsync(aVar.f48882e);
    }

    public void s(HttpRequestBuilder httpRequestBuilder, d.b.g0.k.d.a aVar) {
        if (httpRequestBuilder != null && aVar != null) {
            httpRequestBuilder.url(aVar.f48878a);
            Map<String, String> map = aVar.f48880c;
            if (map != null && map.size() > 0) {
                httpRequestBuilder.headers(aVar.f48880c);
            }
            if (aVar.f48883f) {
                httpRequestBuilder.userAgent(d.b.g0.k.b.a().b());
            }
            if (aVar.f48884g) {
                httpRequestBuilder.cookieManager(d.b.g0.k.b.a().a());
            }
            if (aVar.f48885h) {
                t(httpRequestBuilder);
            }
            Object obj = aVar.i;
            if (obj != null) {
                httpRequestBuilder.tag(obj);
            }
        } else if (f48886a) {
            Log.e("SwanHttpManager", "setNetworkConfig fail");
        }
    }

    public void t(HttpRequestBuilder httpRequestBuilder) {
        int g2 = d.b.g0.k.b.a().g();
        if (g2 > 0) {
            httpRequestBuilder.connectionTimeout(g2);
        }
        int readTimeout = d.b.g0.k.b.a().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int c2 = d.b.g0.k.b.a().c();
        if (c2 > 0) {
            httpRequestBuilder.writeTimeout(c2);
        }
    }

    public void u(OkHttpClient.Builder builder) {
        int g2 = d.b.g0.k.b.a().g();
        if (g2 > 0) {
            builder.connectTimeout(g2, TimeUnit.MILLISECONDS);
        }
        int readTimeout = d.b.g0.k.b.a().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int c2 = d.b.g0.k.b.a().c();
        if (c2 > 0) {
            builder.writeTimeout(c2, TimeUnit.MILLISECONDS);
        }
    }

    public j v() {
        return new j(this);
    }
}
