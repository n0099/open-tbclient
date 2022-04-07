package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.GDTADManager;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class SystemUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SystemUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String buildNewPathByProcessName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtil.isEmpty(str)) {
                return str;
            }
            String processName = GDTADManager.getInstance().getProcessName();
            if (StringUtil.isEmpty(processName)) {
                return str;
            }
            boolean endsWith = processName.endsWith("_");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(endsWith ? "" : "_");
            sb.append(Md5Util.encode(processName));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getProcessName(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningAppProcessInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (next.pid == myPid) {
                        return next.processName;
                    }
                    continue;
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
