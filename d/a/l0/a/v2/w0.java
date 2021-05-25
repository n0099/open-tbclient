package d.a.l0.a.v2;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes3.dex */
public class w0 {

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CookieManager.getInstance().setCookie(Domains.BAIDU, o0.k(Domains.BAIDU, "SP_FW_VER", d.a.l0.a.m2.b.h(0), 2937600L));
            CookieManager.getInstance().setCookie(Domains.BAIDU, o0.k(Domains.BAIDU, "SG_FW_VER", d.a.l0.a.m2.b.h(1), 2937600L));
            w0.b();
        }
    }

    public static void a() {
        q.j(new a(), "SwanJsVersionCookieManager");
    }

    public static void b() {
        if (d.f()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
