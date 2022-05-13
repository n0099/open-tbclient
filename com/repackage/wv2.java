package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class wv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755188002, "Lcom/repackage/wv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755188002, "Lcom/repackage/wv2;");
                return;
            }
        }
        a = eh1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean a(Context context, @NonNull xv2 xv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, xv2Var)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            xv2Var.b(2, "method should be called after setActivityRef");
            if (a) {
                throw new IllegalStateException("this method should be called after setActivityRef");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull xv2 xv2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, xv2Var)) == null) {
            if (ph4.a(context, str)) {
                xv2Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull xv2 xv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, xv2Var)) == null) {
            if (arrayList == null || arrayList.isEmpty()) {
                xv2Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static ArrayList<String> d(@NonNull Context context, @NonNull String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : strArr) {
                if (!ph4.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i, @NonNull Context context, @NonNull xv2 xv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i), context, xv2Var}) == null) && a(context, xv2Var) && !b(context, str, xv2Var)) {
            g(context, strArr, i, xv2Var);
        }
    }

    @Deprecated
    public static void f(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull xv2 xv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65542, null, context, strArr, i, xv2Var) == null) && a(context, xv2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, xv2Var)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, (String[]) d.toArray(new String[0]), new sv2(i, xv2Var));
        }
    }

    public static void g(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull xv2 xv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65543, null, context, strArr, i, xv2Var) == null) && a(context, xv2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, xv2Var)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, (String[]) d.toArray(new String[0]), new tv2(context, i, xv2Var));
        }
    }

    public static void h(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull xv2 xv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65544, null, strArr, i, context, xv2Var) == null) && a(context, xv2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, xv2Var)) {
                return;
            }
            g(context, (String[]) d.toArray(new String[0]), i, xv2Var);
        }
    }

    @Deprecated
    public static void requestPermissions(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull xv2 xv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65545, null, strArr, i, context, xv2Var) == null) && a(context, xv2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, xv2Var)) {
                return;
            }
            f(context, (String[]) d.toArray(new String[0]), i, xv2Var);
        }
    }
}
