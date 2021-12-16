package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class bh {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, Class<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends T> a;

        /* renamed from: a  reason: collision with other field name */
        public final T f157a;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56378694, "Lcom/xiaomi/push/bh;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56378694, "Lcom/xiaomi/push/bh;");
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0014 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0014 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Class<? extends java.lang.Object>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public static <T> T a(Class<? extends Object> cls, Object obj, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, obj, str)) == null) {
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
                if (cls == 0) {
                    throw new NoSuchFieldException();
                }
            }
            field.setAccessible(true);
            return (T) field.get(obj);
        }
        return (T) invokeLLL.objValue;
    }

    public static <T> T a(Class<? extends Object> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
            try {
                return (T) a(cls, (Object) null, str);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Meet exception when call getStaticField '");
                sb.append(str);
                sb.append("' in ");
                sb.append(cls != null ? cls.getSimpleName() : "");
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(e2);
                sb.toString();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, objArr)) == null) ? (T) a(cls, str, a(objArr)).invoke(null, m228a(objArr)) : (T) invokeLLL.objValue;
    }

    public static <T> T a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str)) == null) {
            try {
                return (T) a((Class<? extends Object>) obj.getClass(), obj, str);
            } catch (Exception e2) {
                String str2 = "Meet exception when call getField '" + str + "' in " + obj + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2;
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, obj, str, objArr)) == null) {
            try {
                return (T) b(obj, str, objArr);
            } catch (Exception e2) {
                String str2 = "Meet exception when call Method '" + str + "' in " + obj + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2;
                return null;
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static <T> T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            try {
                return (T) a((Class<? extends Object>) t.a(null, str), (Object) null, str2);
            } catch (Exception e2) {
                String str3 = "Meet exception when call getStaticField '" + str2 + "' in " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2;
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, objArr)) == null) {
            try {
                return (T) a(t.a(null, str), str2, objArr);
            } catch (Exception e2) {
                String str3 = "Meet exception when call Method '" + str2 + "' in " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2;
                return null;
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, cls, str, clsArr)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, methodArr, str, clsArr)) == null) {
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

    public static void a(Object obj, String str, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, obj, str, obj2) == null) {
            try {
                b(obj, str, obj2);
            } catch (Exception e2) {
                String str2 = "Meet exception when call setField '" + str + "' in " + obj + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2;
            }
        }
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, clsArr, clsArr2)) == null) {
            if (clsArr == null) {
                return clsArr2 == null || clsArr2.length == 0;
            } else if (clsArr2 == null) {
                return clsArr.length == 0;
            } else if (clsArr.length != clsArr2.length) {
                return false;
            } else {
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (clsArr2[i2] != null && !clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!a.containsKey(clsArr[i2]) || !a.get(clsArr[i2]).equals(a.get(clsArr2[i2])))) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, objArr)) == null) {
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

    /* renamed from: a  reason: collision with other method in class */
    public static Object[] m228a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, objArr)) == null) {
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            Object[] objArr2 = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj == null || !(obj instanceof a)) {
                    objArr2[i2] = obj;
                } else {
                    objArr2[i2] = ((a) obj).f157a;
                }
            }
            return objArr2;
        }
        return (Object[]) invokeL.objValue;
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, obj, str, objArr)) == null) ? (T) a(obj.getClass(), str, a(objArr)).invoke(obj, m228a(objArr)) : (T) invokeLLL.objValue;
    }

    public static void b(Object obj, String str, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, obj, str, obj2) == null) {
            Class<?> cls = obj.getClass();
            Field field = null;
            while (field == null) {
                try {
                    field = cls.getDeclaredField(str);
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
            field.set(obj, obj2);
        }
    }
}
