package d.b.g0.g.w;

import com.baidu.searchbox.http.HttpManager;
import d.b.g0.a.r1.e;
import d.b.g0.a.r1.n.b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes3.dex */
public class b extends HttpManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48595a;

    public b() {
        super(d.b.g0.a.w0.a.c());
    }

    public static b c() {
        if (f48595a == null) {
            synchronized (b.class) {
                if (f48595a == null) {
                    f48595a = new b();
                }
            }
        }
        return f48595a;
    }

    public static b d() {
        b bVar = new b();
        bVar.setHttpDnsEnable(c().getHttpDnsEnable());
        return bVar;
    }

    public void a(Request request, List<Interceptor> list, Callback callback) {
        if (request == null) {
            return;
        }
        OkHttpClient.Builder newBuilder = getOkHttpClient().newBuilder();
        if (list != null && !list.isEmpty()) {
            for (Interceptor interceptor : list) {
                if (interceptor != null) {
                    newBuilder.addInterceptor(interceptor);
                }
            }
        }
        newBuilder.build().newCall(request).enqueue(callback);
    }

    public void b(Request request, Callback callback) {
        if (request != null) {
            getOkHttpClient().newCall(request).enqueue(callback);
        }
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        b.a aVar;
        if (e.y() == null) {
            return super.initClient();
        }
        d.b.g0.g.z.a.a G = e.y().G();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (G != null && (aVar = G.f48694b) != null) {
            i = aVar.f45768a;
            newBuilder.connectTimeout(aVar.f45769b, TimeUnit.MILLISECONDS);
            newBuilder.addNetworkInterceptor(new d.b.g0.a.g1.m.d());
        }
        long j = i;
        newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
        OkHttpClient build = newBuilder.build();
        build.dispatcher().setMaxRequests(10);
        return build;
    }
}
