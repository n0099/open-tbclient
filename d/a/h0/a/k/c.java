package d.a.h0.a.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:8:0x001b A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:5:0x0005, B:6:0x0015, B:8:0x001b, B:10:0x002d, B:12:0x0031), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, context, str)) != null) {
            return invokeLL.booleanValue;
        }
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
