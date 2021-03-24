package d.b.g0.a.i2;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes3.dex */
public class o0 {

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CookieManager.getInstance().setCookie(Domains.BAIDU, i0.j(Domains.BAIDU, "SP_FW_VER", d.b.g0.a.b2.b.f(0), 2937600L));
            CookieManager.getInstance().setCookie(Domains.BAIDU, i0.j(Domains.BAIDU, "SG_FW_VER", d.b.g0.a.b2.b.f(1), 2937600L));
            o0.b();
        }
    }

    public static void a() {
        p.k(new a(), "SwanJsVersionCookieManager");
    }

    public static void b() {
        if (c.f()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
