package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class lj9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755527018, "Lcom/repackage/lj9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755527018, "Lcom/repackage/lj9;");
                return;
            }
        }
        b = new Object();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a != null) {
                return a;
            }
            synchronized (b) {
                if (a != null) {
                    return a;
                }
                a = b(cj9.getContext().provideContext());
                return a;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }
}
