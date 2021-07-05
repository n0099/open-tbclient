package d.a.r.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Field a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static Object b(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, str)) == null) {
            Field a2 = a(obj, str);
            if (a2 != null) {
                a2.setAccessible(true);
                try {
                    return a2.get(obj);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object c(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, clsArr, objArr)) == null) {
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static void d(Object obj, String str, Object obj2) {
        Field a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, obj, str, obj2) == null) || (a2 = a(obj, str)) == null) {
            return;
        }
        a2.setAccessible(true);
        try {
            a2.set(obj, obj2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
