package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class p {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(ProcessUtils.CMD_LINE_NAME);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return "";
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused) {
                HMSLog.e("CommFun", "get current app processes IOException!");
                return "";
            } catch (Exception e) {
                HMSLog.e("CommFun", "get current app processes exception!" + e.getMessage());
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            String b = b(context);
            a = b;
            if (!TextUtils.isEmpty(b)) {
                return a;
            }
            String a2 = a();
            a = a2;
            return a2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName != null) {
                        HMSLog.i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                        return runningAppProcessInfo.processName;
                    }
                }
                return "";
            }
            HMSLog.w("CommFun", "get running app processes null!");
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int i = HwBuildEx.VERSION.EMUI_SDK_INT;
            HMSLog.d("CommFun", "Emui Api Level:" + i);
            if (i > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        String parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                parent = context.createDeviceProtectedStorageContext().getDataDir() + "";
            } else {
                parent = context.getFilesDir().getParent();
            }
            if (TextUtils.isEmpty(parent)) {
                HMSLog.e("CommFun", "get storage root path of the current user failed.");
            }
            return parent;
        }
        return (String) invokeL.objValue;
    }

    public static long d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
            } catch (Exception unused) {
                HMSLog.e("CommFun", "get nc versionCode error");
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && d(context) < 110001400) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
