package d.b.i0.h3;

import com.baidu.adp.lib.util.BdLog;
import d.b.h0.z0.k0;
/* loaded from: classes.dex */
public class d {
    public static void a() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new k0());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
