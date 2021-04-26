package d.f.b.a.j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f65450a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f65451b = new Object();

    public static String a() {
        if (f65450a != null) {
            return f65450a;
        }
        synchronized (f65451b) {
            if (f65450a != null) {
                return f65450a;
            }
            f65450a = b(d.f.b.a.c.d().provideContext());
            return f65450a;
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
