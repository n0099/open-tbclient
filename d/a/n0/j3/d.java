package d.a.n0.j3;

import com.baidu.adp.lib.util.BdLog;
import d.a.m0.z0.k0;
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
