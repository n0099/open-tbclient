package d.b.g0.a.c1.c;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.i2.g0;
import d.b.g0.a.z0.f;
/* loaded from: classes2.dex */
public class b {
    public static int a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 100 : 118;
                }
                return 112;
            }
            return 100;
        }
        return 82;
    }

    public static int b() {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(d.b.g0.a.w0.a.c(), d.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            return callOnMainWithContentProvider.mResult.getInt("font_size_level", 1);
        }
        return 1;
    }

    public static int c() {
        return b() + 1;
    }

    public static boolean d() {
        return g0.b("3.200.101");
    }

    public static boolean e() {
        SwanAppConfigData I = f.V().I();
        if (I == null) {
            return false;
        }
        return TextUtils.equals("none", I.f12616d.n);
    }

    public static void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i);
        d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(22, bundle));
    }
}
