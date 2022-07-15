package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
/* renamed from: com.kuaishou.weapon.p0.ـ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0430 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0430() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m830() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return Debug.isDebuggerConnected();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m831(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1 : invokeL.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m832() {
        InterceptResult invokeV;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/status"));
            while (true) {
                try {
                    readLine = bufferedReader2.readLine();
                    if (!readLine.contains("TracerPid")) {
                        if (readLine == null) {
                            readLine = "";
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            String replace = readLine.replace("\t", " ");
            try {
                bufferedReader2.close();
            } catch (Exception unused4) {
            }
            return replace;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m833(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1) {
                        return true;
                    }
                } else if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1) {
                    return true;
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
