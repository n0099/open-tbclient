package d.a.l0.a.x1;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.l0.a.x1.c;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b extends d.a.l0.a.v1.a.a.a {
    @Override // d.a.l0.a.v1.a.a.a
    public void b(Bundle params) {
        c.a b2;
        c.a b3;
        Intrinsics.checkNotNullParameter(params, "params");
        String string = params.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
        String string2 = params.getString("swanId");
        String string3 = params.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        String string4 = params.getString("hostName");
        if (ProcessUtils.isMainProcess()) {
            if (string != null && (b3 = c.f45762c.b()) != null) {
                b3.a(string, string3, string4);
            }
            if (string2 == null || (b2 = c.f45762c.b()) == null) {
                return;
            }
            b2.b(string2, string3, string4);
        }
    }
}
