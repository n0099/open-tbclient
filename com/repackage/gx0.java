package com.repackage;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class gx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(List<T> list, T t, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65536, null, list, t, i) == null) && !f(list) && e(list, i)) {
            try {
                list.add(i, t);
            } catch (Exception e) {
                l(e);
            }
        }
    }

    public static <T> boolean b(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, t)) == null) {
            if (f(list)) {
                return false;
            }
            try {
                return list.add(t);
            } catch (Exception e) {
                l(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void c(Collection<T> collection, Collection<T> collection2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, collection, collection2) == null) || collection2 == 0 || collection == null) {
            return;
        }
        collection.addAll(collection2);
    }

    @Nullable
    public static <T> T d(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, list, i)) == null) {
            if (!g(list) && e(list, i)) {
                try {
                    return list.get(i);
                } catch (Exception e) {
                    l(e);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLI.objValue;
    }

    public static <T> boolean e(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i)) == null) {
            if (!f(list) && i >= 0) {
                try {
                    return i < list.size();
                } catch (Exception e) {
                    l(e);
                    return false;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static <T> boolean g(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) ? f(list) || list.isEmpty() : invokeL.booleanValue;
    }

    public static <K, V> boolean h(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) ? f(map) || map.isEmpty() : invokeL.booleanValue;
    }

    @Nullable
    public static <T> T i(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, list, i)) == null) {
            if (!g(list) && e(list, i)) {
                try {
                    return list.remove(i);
                } catch (Exception e) {
                    l(e);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLI.objValue;
    }

    public static <T> boolean j(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, t)) == null) {
            if (g(list)) {
                return false;
            }
            try {
                return list.remove(t);
            } catch (Exception e) {
                l(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <T> int k(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (f(list) || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }
        return invokeL.intValue;
    }

    public static void l(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, exc) == null) {
        }
    }
}
