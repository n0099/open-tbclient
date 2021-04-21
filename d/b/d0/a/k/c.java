package d.b.d0.a.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
/* loaded from: classes2.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:6:0x0017 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x0001, B:4:0x0011, B:6:0x0017, B:8:0x0029, B:10:0x002d), top: B:17:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str) {
        try {
        } catch (Exception unused) {
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            String str2 = runningAppProcessInfo.processName;
            int myPid = Process.myPid();
            if (str2.equals(str) || runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
            while (r4.hasNext()) {
            }
        }
    }
}
