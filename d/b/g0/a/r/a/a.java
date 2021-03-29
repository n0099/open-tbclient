package d.b.g0.a.r.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import d.b.g0.a.i2.i0;
/* loaded from: classes2.dex */
public class a {
    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        CookieManager.getInstance().setCookie(Domains.BAIDU, i0.j(Domains.BAIDU, "OPENBDUSS", str, 31449600L));
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }

    public static void b(Context context, String str) {
        if (ProcessUtils.isMainProcess()) {
            a(context, str);
        } else {
            c(context, str);
        }
    }

    public static void c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bduss", str);
        DelegateUtils.callOnMainWithContentProvider(context, b.class, bundle);
    }
}
