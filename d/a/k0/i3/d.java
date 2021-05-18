package d.a.k0.i3;

import com.baidu.adp.lib.util.BdLog;
import d.a.j0.z0.k0;
/* loaded from: classes5.dex */
public class d {
    public static void a() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new k0());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
