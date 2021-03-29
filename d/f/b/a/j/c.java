package d.f.b.a.j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f66043a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f66044b = new Object();

    public static String a() {
        if (f66043a != null) {
            return f66043a;
        }
        synchronized (f66044b) {
            if (f66043a != null) {
                return f66043a;
            }
            f66043a = b(d.f.b.a.c.d().provideContext());
            return f66043a;
        }
    }

    public static String b(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
