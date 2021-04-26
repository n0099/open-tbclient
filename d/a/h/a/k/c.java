package d.a.h.a.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.webkit.sdk.WebViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f41035a;

    public static ActivityManager.RunningAppProcessInfo a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo;
            }
        }
        return null;
    }

    public static String b(Context context) {
        ActivityManager.RunningAppProcessInfo a2;
        if (TextUtils.isEmpty(f41035a) && (a2 = a(context)) != null) {
            f41035a = a2.processName;
        }
        return f41035a;
    }

    public static boolean c(Context context) {
        String b2 = b(context);
        return b2 != null && b2.equals(WebViewFactory.CHROMIUM_HOST_APP);
    }
}
