package com.huawei.hms.framework.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class ContainerUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";
    public transient /* synthetic */ FieldHolder $fh;

    public ContainerUtils() {
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

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, map2)) == null) {
            if (map == map2) {
                return true;
            }
            boolean z = false;
            if (map == null || map2 == null || map.size() != map2.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (map2.get(next.getKey()) != next.getValue()) {
                    z = true;
                    break;
                }
            }
            return !z;
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            return toString(map).hashCode();
        }
        return invokeL.intValue;
    }

    public static <K> String toString(List<K> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (K k : list) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(k.toString());
                i = i2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static <K, V> String toString(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey().toString());
                sb.append("=");
                sb.append(entry.getValue().toString());
                i = i2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static <K> String toString(Set<K> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, set)) == null) {
            if (set == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (K k : set) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(k.toString());
                i = i2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
