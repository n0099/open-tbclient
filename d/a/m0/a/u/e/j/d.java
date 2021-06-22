package d.a.m0.a.u.e.j;

import android.os.Build;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8NetFunctionTable;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestSettings;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.m0.a.a2.n.c;
import d.a.m0.a.j2.c;
import d.a.m0.a.k;
import d.a.m0.a.v2.j;
import d.a.m0.a.v2.q;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48823a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static int f48824b = -1;

    /* loaded from: classes2.dex */
    public static class a implements ValueCallback<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ V8Engine f48825a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NetRequest f48826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f48827c;

        public a(V8Engine v8Engine, NetRequest netRequest, boolean z) {
            this.f48825a = v8Engine;
            this.f48826b = netRequest;
            this.f48827c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Long l) {
            boolean netRequest = this.f48825a.setNetRequest(this.f48826b);
            if (netRequest) {
                int unused = d.f48824b = 1;
            } else {
                if (this.f48827c) {
                    d.d();
                    d.a.m0.a.e0.d.h("ChromeNetManager", "[ERROR] swan chromeNet config fail!!!");
                }
                int unused2 = d.f48824b = 0;
            }
            d.f(netRequest);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(10016);
            bVar.l(Build.MODEL);
            bVar.h(Build.BRAND);
            bVar.m();
        }
    }

    public static boolean b() {
        if (f48824b == -1) {
            f48824b = j.a() ? 1 : 0;
        }
        return f48824b == 1;
    }

    public static void c(@NonNull V8Engine v8Engine) {
        if (!b()) {
            d.a.m0.a.e0.d.h("ChromeNetManager", "Not Used ChromeNet");
            return;
        }
        NetRequest netRequest = new NetRequest();
        NetRequestSettings netRequestSettings = new NetRequestSettings();
        netRequestSettings.mTimeout = 60000;
        netRequestSettings.mShouldNeverClearReferer = true;
        netRequestSettings.mLoadDoNotSendCookies = true;
        netRequest.setRequestInterceptor(new c());
        netRequest.setRedirectInterceptor(new i());
        netRequest.addObserver(new e());
        netRequest.setNetRequestSettings(netRequestSettings);
        boolean e2 = e();
        f48824b = e2 ? 1 : 0;
        V8NetFunctionTable.addOnCronetThreadInitializedListener(new a(v8Engine, netRequest, e2));
    }

    public static void d() {
        q.e().execute(new b());
    }

    public static boolean e() {
        return d.a.m0.a.k2.g.h.a().getBoolean("key_chrome_net_last_usage_enabled", false);
    }

    public static void f(boolean z) {
        d.a.m0.a.k2.g.h.a().putBoolean("key_chrome_net_last_usage_enabled", z);
    }

    public static void g(@Nullable SwanAppConfigData swanAppConfigData) {
        c.a aVar;
        int i2;
        d.a.m0.a.h0.l.a P;
        NetRequest n0;
        NetRequestSettings netRequestSettings;
        if (!b() || swanAppConfigData == null || (aVar = swanAppConfigData.f11396h) == null || (i2 = aVar.f44570b) <= 0 || (P = d.a.m0.a.h0.u.g.N().P()) == null || !(P.g() instanceof d.a.m0.a.l0.a) || (n0 = ((d.a.m0.a.l0.a) P.g()).n0()) == null || (netRequestSettings = n0.getNetRequestSettings()) == null) {
            return;
        }
        netRequestSettings.mTimeout = i2;
        if (f48823a) {
            Log.d("ChromeNetManager", "settings.mTimeout=" + i2);
        }
    }
}
