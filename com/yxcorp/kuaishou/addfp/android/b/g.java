package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? TextUtils.isEmpty(str) ? "KWE_N" : str : (String) invokeL.objValue;
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof UnknownHostException) {
                    return "UnknownHostException";
                }
                try {
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return "";
                }
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            a = z;
        }
    }

    public static boolean a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, strArr)) == null) {
            try {
                for (String str : strArr) {
                    if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                e a2 = com.yxcorp.kuaishou.addfp.c.a.a.a(str, false);
                return !TextUtils.isEmpty(a2.b) ? a2.b : (TextUtils.isEmpty(a2.c) || !a2.c.contains("denied")) ? TextUtils.isEmpty(a2.b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }
}
