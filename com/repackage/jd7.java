package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class jd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(List<T> list, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, list, t) == null) || h(list)) {
            return;
        }
        try {
            list.add(t);
        } catch (Exception e) {
            BdLog.e(e);
            l(e);
        }
    }

    public static <T> void b(List<T> list, T t, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, list, t, i) == null) || h(list) || i < 0 || i > list.size()) {
            return;
        }
        try {
            list.add(i, t);
        } catch (Exception e) {
            BdLog.e(e);
            l(e);
        }
    }

    public static void c(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || e(list)) {
            return;
        }
        try {
            list.clear();
        } catch (Exception e) {
            BdLog.e(e);
            l(e);
        }
    }

    public static <T> T d(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, list, i)) == null) {
            if (!e(list) && g(list, i)) {
                try {
                    return list.get(i);
                } catch (Exception e) {
                    BdLog.e(e);
                    l(e);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLI.objValue;
    }

    public static boolean e(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (h(list) || list.isEmpty()) {
                BdLog.e("list is empty");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            if (h(map) || map.isEmpty()) {
                BdLog.e("map is empty");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, list, i)) == null) ? !h(list) && i >= 0 && i < list.size() : invokeLI.booleanValue;
    }

    public static boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static void i(List list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, list, i) == null) && !e(list) && g(list, i)) {
            try {
                list.remove(i);
            } catch (Exception e) {
                BdLog.e(e);
                l(e);
            }
        }
    }

    public static <T> boolean j(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, t)) == null) {
            if (e(list)) {
                return false;
            }
            try {
                return list.remove(t);
            } catch (Exception e) {
                BdLog.e(e);
                l(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static int k(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (!h(list) && !list.isEmpty()) {
                try {
                    return list.size();
                } catch (Exception e) {
                    BdLog.e(e);
                    l(e);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void l(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, exc) == null) && BdBaseApplication.getInst().isDebugMode() && (exc instanceof RuntimeException)) {
            throw ((RuntimeException) exc);
        }
    }
}
