package d.a.l0.h.y;

import android.annotation.SuppressLint;
import com.baidu.searchbox.http.HttpManager;
import d.a.l0.a.a2.e;
import d.a.l0.a.a2.n.c;
import d.a.l0.a.n1.o.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public class b extends HttpManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47731a;

    public b() {
        super(d.a.l0.a.c1.a.b());
    }

    public static b c() {
        if (f47731a == null) {
            synchronized (b.class) {
                if (f47731a == null) {
                    f47731a = new b();
                }
            }
        }
        return f47731a;
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
        c.a aVar;
        if (e.i() == null) {
            return super.initClient();
        }
        d.a.l0.h.c0.a.a aVar2 = (d.a.l0.h.c0.a.a) e.i().I();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i2 = 60000;
        if (aVar2 != null && (aVar = aVar2.f40779a) != null) {
            i2 = aVar.f40785a;
            newBuilder.connectTimeout(aVar.f40786b, TimeUnit.MILLISECONDS);
            newBuilder.addNetworkInterceptor(new d());
        }
        long j = i2;
        newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
        OkHttpClient build = newBuilder.build();
        build.dispatcher().setMaxRequests(10);
        return build;
    }
}
