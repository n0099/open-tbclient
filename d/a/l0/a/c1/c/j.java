package d.a.l0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a2.n.c;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
@Singleton
@Service
/* loaded from: classes3.dex */
public class j implements d.a.l0.m.a {
    @Override // d.a.l0.m.a
    public String a() {
        String g2 = SwanAppNetworkUtils.g();
        return (TextUtils.isEmpty(g2) && d.a.l0.m.e.a.g().c()) ? d.a.l0.a.s2.a.a() : g2;
    }

    public final c.a b() {
        c.a aVar;
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            if (d.a.l0.a.k.f43199a) {
                Log.e("SwanNetworkImpl", "swanapp is null");
            }
            return null;
        }
        SwanAppConfigData F = Q.F();
        if (F == null || (aVar = F.f11252h) == null) {
            if (d.a.l0.a.k.f43199a) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
            }
            return null;
        }
        return aVar;
    }

    @Override // d.a.l0.m.a
    public CookieManager g() {
        return d.a.l0.a.c1.a.p().a();
    }

    @Override // d.a.l0.m.a
    public Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    @Override // d.a.l0.m.a
    public int getReadTimeout() {
        return c.a.d(b());
    }

    @Override // d.a.l0.m.a
    public int h() {
        return c.a.d(b());
    }

    @Override // d.a.l0.m.a
    public boolean i() {
        d.a.l0.a.c1.a.Z().getSwitch("bbasm_framework_request_with_ua", true);
        return true;
    }

    @Override // d.a.l0.m.a
    public boolean isDebug() {
        return d.a.l0.a.k.f43199a;
    }

    @Override // d.a.l0.m.a
    public void j(String str, HttpRequestBuilder httpRequestBuilder) {
        if (d.a.l0.a.d0.c.u(str)) {
            httpRequestBuilder.setHeader("x-u-id", d.a.l0.u.b.b(AppRuntime.getAppContext()).a());
            try {
                httpRequestBuilder.setHeader("x-c2-id", d.a.l0.a.c1.a.a0().i(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // d.a.l0.m.a
    public List<Interceptor> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.l0.a.n1.o.c());
        return arrayList;
    }

    @Override // d.a.l0.m.a
    public int l() {
        return c.a.d(b());
    }
}
