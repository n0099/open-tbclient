package d.b.g0.a.o1;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.b.g0.a.o1.c;
/* loaded from: classes2.dex */
public final class b extends d.b.g0.a.n1.a.a.a {
    @Override // d.b.g0.a.n1.a.a.a
    public void b(Bundle bundle) {
        c.a b2;
        c.a b3;
        String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
        String string2 = bundle.getString("swanId");
        String string3 = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        String string4 = bundle.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (b3 = c.f45429b.b()) != null) {
                b3.a(string, string3, string4);
            }
            if (string2 == null || (b2 = c.f45429b.b()) == null) {
                return;
            }
            b2.b(string2, string3, string4);
        }
    }
}
