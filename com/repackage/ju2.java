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
/* loaded from: classes6.dex */
public class ju2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755576246, "Lcom/repackage/ju2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755576246, "Lcom/repackage/ju2;");
                return;
            }
        }
        a = rf1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean a(Context context, @NonNull ku2 ku2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ku2Var)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            ku2Var.b(2, "method should be called after setActivityRef");
            if (a) {
                throw new IllegalStateException("this method should be called after setActivityRef");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull ku2 ku2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, ku2Var)) == null) {
            if (cg4.a(context, str)) {
                ku2Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull ku2 ku2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, ku2Var)) == null) {
            if (arrayList == null || arrayList.isEmpty()) {
                ku2Var.a("permission has already granted");
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
                if (!cg4.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i, @NonNull Context context, @NonNull ku2 ku2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i), context, ku2Var}) == null) && a(context, ku2Var) && !b(context, str, ku2Var)) {
            g(context, strArr, i, ku2Var);
        }
    }

    @Deprecated
    public static void f(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull ku2 ku2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65542, null, context, strArr, i, ku2Var) == null) && a(context, ku2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, ku2Var)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, (String[]) d.toArray(new String[0]), new fu2(i, ku2Var));
        }
    }

    public static void g(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull ku2 ku2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65543, null, context, strArr, i, ku2Var) == null) && a(context, ku2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, ku2Var)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i, (String[]) d.toArray(new String[0]), new gu2(context, i, ku2Var));
        }
    }

    public static void h(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull ku2 ku2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65544, null, strArr, i, context, ku2Var) == null) && a(context, ku2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, ku2Var)) {
                return;
            }
            g(context, (String[]) d.toArray(new String[0]), i, ku2Var);
        }
    }

    @Deprecated
    public static void requestPermissions(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull ku2 ku2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65545, null, strArr, i, context, ku2Var) == null) && a(context, ku2Var)) {
            ArrayList<String> d = d(context, strArr);
            if (c(d, ku2Var)) {
                return;
            }
            f(context, (String[]) d.toArray(new String[0]), i, ku2Var);
        }
    }
}
