package d.b.g0.a.w0.b;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.k;
import d.b.g0.a.r1.n.b;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
@Singleton
@Service
/* loaded from: classes3.dex */
public class e implements d.b.g0.k.a {
    @Override // d.b.g0.k.a
    public CookieManager a() {
        return d.b.g0.a.w0.a.m().a();
    }

    @Override // d.b.g0.k.a
    public String b() {
        return SwanAppNetworkUtils.g();
    }

    @Override // d.b.g0.k.a
    public int c() {
        return 60000;
    }

    @Override // d.b.g0.k.a
    public List<Interceptor> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.g0.a.g1.m.c());
        return arrayList;
    }

    @Override // d.b.g0.k.a
    public void e(String str, HttpRequestBuilder httpRequestBuilder) {
        if (d.b.g0.a.b0.c.t(str)) {
            httpRequestBuilder.setHeader("x-u-id", d.b.g0.q.b.b(AppRuntime.getAppContext()).a());
            try {
                httpRequestBuilder.setHeader("x-c2-id", d.b.g0.a.w0.a.O().c(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // d.b.g0.k.a
    public Context f() {
        return AppRuntime.getAppContext();
    }

    @Override // d.b.g0.k.a
    public int g() {
        b.a h2 = h();
        if (h2 != null) {
            return h2.f45768a;
        }
        return -1;
    }

    @Override // d.b.g0.k.a
    public int getReadTimeout() {
        return 60000;
    }

    public final b.a h() {
        b.a aVar;
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            if (k.f45050a) {
                Log.e("SwanNetworkImpl", "swanapp is null");
            }
            return null;
        }
        SwanAppConfigData D = O.D();
        if (D == null || (aVar = D.f12618g) == null) {
            if (k.f45050a) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
            }
            return null;
        }
        return aVar;
    }

    @Override // d.b.g0.k.a
    public boolean isDebug() {
        return k.f45050a;
    }
}
