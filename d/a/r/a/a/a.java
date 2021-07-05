package d.a.r.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(T[] tArr, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tArr, t)) == null) ? c(tArr, t) != -1 : invokeLL.booleanValue;
    }

    public static boolean b(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static <T> int c(T[] tArr, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tArr, t)) == null) {
            if (tArr == null) {
                return -1;
            }
            for (int i2 = 0; i2 < tArr.length; i2++) {
                if (b(tArr[i2], t)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static Object d(Class cls, Object[] objArr, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, objArr, obj)) == null) {
            Object newInstance = Array.newInstance(cls, objArr.length + 1);
            Array.set(newInstance, 0, obj);
            for (int i2 = 1; i2 < objArr.length + 1; i2++) {
                Array.set(newInstance, i2, objArr[i2 - 1]);
            }
            return newInstance;
        }
        return invokeLLL.objValue;
    }
}
