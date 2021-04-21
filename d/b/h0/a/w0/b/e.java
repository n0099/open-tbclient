package d.b.h0.a.w0.b;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.k;
import d.b.h0.a.r1.n.b;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
@Singleton
@Service
/* loaded from: classes2.dex */
public class e implements d.b.h0.k.a {
    @Override // d.b.h0.k.a
    public CookieManager a() {
        return d.b.h0.a.w0.a.m().a();
    }

    @Override // d.b.h0.k.a
    public String b() {
        return SwanAppNetworkUtils.g();
    }

    @Override // d.b.h0.k.a
    public int c() {
        return 60000;
    }

    @Override // d.b.h0.k.a
    public List<Interceptor> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.h0.a.g1.m.c());
        return arrayList;
    }

    @Override // d.b.h0.k.a
    public void e(String str, HttpRequestBuilder httpRequestBuilder) {
        if (d.b.h0.a.b0.c.t(str)) {
            httpRequestBuilder.setHeader("x-u-id", d.b.h0.q.b.b(AppRuntime.getAppContext()).a());
            try {
                httpRequestBuilder.setHeader("x-c2-id", d.b.h0.a.w0.a.O().c(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // d.b.h0.k.a
    public int f() {
        b.a g2 = g();
        if (g2 != null) {
            return g2.f46490a;
        }
        return -1;
    }

    public final b.a g() {
        b.a aVar;
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            if (k.f45772a) {
                Log.e("SwanNetworkImpl", "swanapp is null");
            }
            return null;
        }
        SwanAppConfigData D = O.D();
        if (D == null || (aVar = D.f12288g) == null) {
            if (k.f45772a) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
            }
            return null;
        }
        return aVar;
    }

    @Override // d.b.h0.k.a
    public Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    @Override // d.b.h0.k.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // d.b.h0.k.a
    public boolean isDebug() {
        return k.f45772a;
    }
}
