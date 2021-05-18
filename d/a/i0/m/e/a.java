package d.a.i0.m.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import d.a.i0.m.c.c;
import d.a.i0.m.c.d;
import d.a.i0.m.c.e;
import d.a.i0.m.c.f;
import d.a.i0.m.c.g;
import d.a.i0.m.c.h;
import d.a.i0.m.c.i;
import d.a.i0.m.c.j;
import d.a.i0.m.d.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.http.client.methods.HttpPut;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public class a extends HttpManager {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47805b = d.a.i0.m.b.c();

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f47806c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47807a;

    /* renamed from: d.a.i0.m.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1063a extends ResponseCallback {
        public C1063a(a aVar) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            return response;
        }
    }

    public a() {
        super(d.a.i0.m.b.b().getAppContext());
        this.f47807a = true;
        this.f47807a = d.a.i0.m.b.a();
    }

    public static a g() {
        if (f47806c == null) {
            synchronized (a.class) {
                if (f47806c == null) {
                    f47806c = new a();
                    f47806c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                }
            }
        }
        return f47806c;
    }

    public static a h(Context context) {
        return g();
    }

    public d.a.i0.m.c.a a() {
        return new d.a.i0.m.c.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public d.a.i0.m.c.b deleteRequest() {
        return new d.a.i0.m.c.b(this);
    }

    public boolean c() {
        return this.f47807a;
    }

    public void d(d.a.i0.m.d.a aVar) {
        aVar.f47794b = "GET";
        s(aVar);
    }

    public void e(d.a.i0.m.d.a aVar) {
        aVar.f47794b = "POST";
        s(aVar);
    }

    public void f(d.a.i0.m.d.a aVar) {
        aVar.f47794b = HttpPut.METHOD_NAME;
        s(aVar);
    }

    public OkHttpClient.Builder i() {
        return getOkHttpClient().newBuilder();
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> k = d.a.i0.m.b.b().k();
        if (k == null || k.size() <= 0) {
            return initClient;
        }
        OkHttpClient.Builder newBuilder = initClient.newBuilder();
        for (Interceptor interceptor : k) {
            newBuilder.addNetworkInterceptor(interceptor);
        }
        return newBuilder.build();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: j */
    public c getRequest() {
        return new c(this);
    }

    public final ResponseCallback k() {
        return new C1063a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: l */
    public d headerRequest() {
        return new d(this);
    }

    public final boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f47805b) {
                Log.e("SwanHttpManager", "url is empty");
                return true;
            }
            return true;
        }
        return false;
    }

    public e n() {
        return new e(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: o */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public i putRequest() {
        return new i(this);
    }

    public void s(@NonNull d.a.i0.m.d.a aVar) {
        if (aVar.f47797e == null) {
            aVar.f47797e = k();
        }
        if (m(aVar.f47793a)) {
            aVar.f47797e.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder a2 = b.a(aVar);
        t(a2, aVar);
        a2.build().executeAsync(aVar.f47797e);
    }

    public void t(HttpRequestBuilder httpRequestBuilder, d.a.i0.m.d.a aVar) {
        if (httpRequestBuilder != null && aVar != null) {
            httpRequestBuilder.url(aVar.f47793a);
            Map<String, String> map = aVar.f47795c;
            if (map != null && map.size() > 0) {
                httpRequestBuilder.headers(aVar.f47795c);
            }
            if (aVar.f47798f) {
                httpRequestBuilder.userAgent(d.a.i0.m.b.b().a());
            }
            if (aVar.f47799g) {
                httpRequestBuilder.cookieManager(d.a.i0.m.b.b().g());
            }
            if (aVar.f47800h) {
                a.C1062a b2 = aVar.b();
                if (b2 == null) {
                    u(httpRequestBuilder);
                } else {
                    w(httpRequestBuilder, b2);
                }
            }
            Object obj = aVar.f47801i;
            if (obj != null) {
                httpRequestBuilder.tag(obj);
            }
            if (aVar.k != 0) {
                httpRequestBuilder.enableStat(true);
                httpRequestBuilder.requestFrom(aVar.j);
                httpRequestBuilder.requestSubFrom(aVar.k);
            }
        } else if (f47805b) {
            Log.e("SwanHttpManager", "setNetworkConfig fail");
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder) {
        int l = d.a.i0.m.b.b().l();
        if (l > 0) {
            httpRequestBuilder.connectionTimeout(l);
        }
        int readTimeout = d.a.i0.m.b.b().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int h2 = d.a.i0.m.b.b().h();
        if (h2 > 0) {
            httpRequestBuilder.writeTimeout(h2);
        }
    }

    public void v(OkHttpClient.Builder builder) {
        int l = d.a.i0.m.b.b().l();
        if (l > 0) {
            builder.connectTimeout(l, TimeUnit.MILLISECONDS);
        }
        int readTimeout = d.a.i0.m.b.b().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int h2 = d.a.i0.m.b.b().h();
        if (h2 > 0) {
            builder.writeTimeout(h2, TimeUnit.MILLISECONDS);
        }
    }

    public final void w(HttpRequestBuilder httpRequestBuilder, @NonNull a.C1062a c1062a) {
        int i2 = c1062a.f47802a;
        if (i2 <= 0) {
            i2 = d.a.i0.m.b.b().l();
        }
        if (i2 > 0) {
            httpRequestBuilder.connectionTimeout(i2);
        }
        int i3 = c1062a.f47803b;
        if (i3 <= 0) {
            i3 = d.a.i0.m.b.b().getReadTimeout();
        }
        if (i3 > 0) {
            httpRequestBuilder.readTimeout(i3);
        }
        int i4 = c1062a.f47804c;
        if (i4 <= 0) {
            i4 = d.a.i0.m.b.b().h();
        }
        if (i4 > 0) {
            httpRequestBuilder.writeTimeout(i4);
        }
    }

    public j x() {
        return new j(this);
    }
}
