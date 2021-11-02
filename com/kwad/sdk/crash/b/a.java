package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.crash.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, th)) == null) {
            ArrayList arrayList = new ArrayList(5);
            for (int i2 = 0; i2 < 5; i2++) {
                arrayList.add(th.getStackTrace());
                th = th.getCause();
                if (th == null) {
                    break;
                }
            }
            return a(arrayList);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(@NonNull List<StackTraceElement[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            for (StackTraceElement[] stackTraceElementArr : list) {
                if (a(stackTraceElementArr)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, stackTraceElementArr)) == null) {
            if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
                return false;
            }
            String[] b2 = d.a().b();
            if (b2 == null || b2.length == 0) {
                return true;
            }
            boolean z = false;
            for (String str : b2) {
                z = a(stackTraceElementArr, str);
                if (z) {
                    break;
                }
            }
            if (z) {
                for (String str2 : d.a().c()) {
                    if (b(stackTraceElementArr, str2)) {
                        return false;
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, stackTraceElementArr, str)) == null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className) && className.contains(str)) {
                    com.kwad.sdk.core.d.a.a("ExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, stackTraceElementArr, str)) == null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className) && className.contains(str)) {
                    com.kwad.sdk.core.d.a.a("ExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
