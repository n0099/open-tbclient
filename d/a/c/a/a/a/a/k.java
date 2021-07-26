package d.a.c.a.a.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class a(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) {
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            throw new IllegalArgumentException(String.format("Don't know the wrapper type for primitive type %s.", cls));
        }
        return (Class) invokeL.objValue;
    }

    public static Object b(Class cls, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, objArr)) == null) ? (objArr == null || objArr.length <= 0) ? cls.newInstance() : e(cls, objArr) : invokeLL.objValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? new String(new d.a.c.a.a.c.a.a().a(bArr), "UTF-8") : (String) invokeL.objValue;
    }

    public static Method d(Class cls, String str, Class[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object e(Class cls, Object[] objArr) {
        InterceptResult invokeLL;
        Constructor<?>[] constructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, objArr)) == null) {
            Constructor<?> constructor = null;
            for (Constructor<?> constructor2 : cls.getConstructors()) {
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length >= objArr.length) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < objArr.length) {
                        Object obj = objArr[i2];
                        while (obj != null && i3 < parameterTypes.length) {
                            Class<?> cls2 = parameterTypes[i3];
                            if (cls2.isPrimitive()) {
                                cls2 = a(cls2);
                            }
                            if (cls2.isInstance(obj)) {
                                break;
                            }
                            i3++;
                        }
                        if (i3 == parameterTypes.length) {
                            break;
                        }
                        i3++;
                        i2++;
                    }
                    if (i2 != objArr.length) {
                        continue;
                    } else if (constructor == null || parameterTypes.length < constructor.getParameterTypes().length) {
                        constructor = constructor2;
                    } else if (parameterTypes.length == constructor.getParameterTypes().length) {
                        throw new IllegalArgumentException("Multiple consturctors match parameters");
                    }
                }
            }
            if (constructor != null) {
                return constructor.newInstance(objArr);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
