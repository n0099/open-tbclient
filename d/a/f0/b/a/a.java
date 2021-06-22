package d.a.f0.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f43526a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f43527b;

    public static int a() {
        Context a2 = e.a();
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) a2.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return -1;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance;
            }
        }
        return 0;
    }

    public static String b() {
        String str = f43526a;
        if (str == null) {
            synchronized (a.class) {
                str = f43526a;
                if (str == null) {
                    Context a2 = e.a();
                    String d2 = d();
                    if (d2 == null && (d2 = c(a2)) == null) {
                        d2 = a2.getPackageName();
                    }
                    f43526a = d2;
                    str = d2;
                }
            }
        }
        return str;
    }

    public static String c(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static String d() {
        ?? r2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ProcessUtils.CMD_LINE_NAME))));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            r2 = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e3) {
                e3.printStackTrace();
                return readLine;
            }
        } catch (Exception e4) {
            e = e4;
            r2 = null;
            bufferedReader3 = bufferedReader;
            h("MultiProcess", e);
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            bufferedReader2 = r2;
            return bufferedReader2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != 0) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static int e() {
        int i2 = f43527b;
        if (i2 == 0) {
            String b2 = b();
            String packageName = e.a().getPackageName();
            i2 = (TextUtils.equals(b2, packageName) || (b2.startsWith(packageName) && !b2.contains(":"))) ? i2 | 1 | 2 : i2 | 4;
            f43527b = i2;
        }
        return i2;
    }

    public static boolean f() {
        return (e() & 1) != 0;
    }

    public static boolean g() {
        return (e() & 2) != 0;
    }

    public static void h(String str, Exception exc) {
    }
}
