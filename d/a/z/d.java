package d.a.z;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes2.dex */
public class d {
    public static void a(Bundle bundle) {
        if (bundle == null) {
            a.h(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.h(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e2) {
            a.h(3, e2.getMessage());
        }
    }

    public static void b(Bundle bundle) {
        b.a().g(bundle);
    }

    public static void c() {
        if (ProcessUtils.isMainProcess()) {
            b.a().h("");
        }
    }
}
