package com.kwad.sdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, Class<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends T> a;

        /* renamed from: b  reason: collision with root package name */
        public final T f59663b;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835167, "Lcom/kwad/sdk/utils/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835167, "Lcom/kwad/sdk/utils/s;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        a.put(Byte.class, Byte.TYPE);
        a.put(Character.class, Character.TYPE);
        a.put(Short.class, Short.TYPE);
        a.put(Integer.class, Integer.TYPE);
        a.put(Float.class, Float.TYPE);
        a.put(Long.class, Long.TYPE);
        a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, str, objArr)) == null) ? (T) a(cls, str, a(objArr)).invoke(null, b(objArr)) : (T) invokeLLL.objValue;
    }

    public static <T> T a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, str)) == null) {
            try {
                return (T) b(obj, str);
            } catch (Throwable th) {
                throw a(th);
            }
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, obj, str, objArr)) == null) {
            try {
                return (T) b(obj, str, objArr);
            } catch (Throwable th) {
                throw a(th);
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, objArr)) == null) {
            try {
                return (T) a(Class.forName(str), str2, objArr);
            } catch (Throwable th) {
                throw a(th);
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static RuntimeException a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, th)) == null) ? th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th) : (RuntimeException) invokeL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            } else if (cls.getSuperclass() != null) {
                return a((Class<?>) cls.getSuperclass(), str, clsArr);
            } else {
                throw new NoSuchMethodException();
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, methodArr, str, clsArr)) == null) {
            if (str != null) {
                for (Method method : methodArr) {
                    if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                        return method;
                    }
                }
                return null;
            }
            throw new NullPointerException("Method name must not be null.");
        }
        return (Method) invokeLLL.objValue;
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, clsArr, clsArr2)) == null) {
            if (clsArr == null) {
                return clsArr2 == null || clsArr2.length == 0;
            } else if (clsArr2 == null) {
                return clsArr.length == 0;
            } else if (clsArr.length != clsArr2.length) {
                return false;
            } else {
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (!clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!a.containsKey(clsArr[i2]) || !a.get(clsArr[i2]).equals(a.get(clsArr2[i2])))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Class<?>[] a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, objArr)) == null) {
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj == null || !(obj instanceof a)) {
                    clsArr[i2] = obj == null ? null : obj.getClass();
                } else {
                    clsArr[i2] = ((a) obj).a;
                }
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public static <T> T b(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, str)) == null) {
            Class<?> cls = obj.getClass();
            Field field = null;
            while (field == null) {
                try {
                    field = cls.getDeclaredField(str);
                    field.setAccessible(true);
                    continue;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    continue;
                }
                if (cls == null) {
                    throw new NoSuchFieldException();
                }
            }
            field.setAccessible(true);
            return (T) field.get(obj);
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, obj, str, objArr)) == null) ? (T) a(obj.getClass(), str, a(objArr)).invoke(obj, b(objArr)) : (T) invokeLLL.objValue;
    }

    public static Object[] b(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, objArr)) == null) {
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            Object[] objArr2 = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj == null || !(obj instanceof a)) {
                    objArr2[i2] = obj;
                } else {
                    objArr2[i2] = ((a) obj).f59663b;
                }
            }
            return objArr2;
        }
        return (Object[]) invokeL.objValue;
    }
}
