package com.dxmpay.apollon.utils.reflect;

import androidx.core.view.InputDeviceCompat;
import c.f.a.h.a.a;
import c.f.a.h.a.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class MethodUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Method> f69457a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-928515119, "Lcom/dxmpay/apollon/utils/reflect/MethodUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-928515119, "Lcom/dxmpay/apollon/utils/reflect/MethodUtils;");
                return;
            }
        }
        f69457a = new HashMap();
    }

    public MethodUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.toString());
            sb.append("#");
            sb.append(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class<?> cls2 : clsArr) {
                    sb.append(cls2.toString());
                    sb.append("#");
                }
            } else {
                sb.append(Void.class.toString());
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static <T> Constructor<T> b(Constructor<T> constructor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, constructor)) == null) {
            b.a(constructor != null, "constructor cannot be null", new Object[0]);
            if (a.h(constructor) && d(constructor.getDeclaringClass())) {
                return constructor;
            }
            return null;
        }
        return (Constructor) invokeL.objValue;
    }

    public static Method c(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, method)) == null) {
            if (a.h(method)) {
                Class<?> declaringClass = method.getDeclaringClass();
                if (Modifier.isPublic(declaringClass.getModifiers())) {
                    return method;
                }
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method f2 = f(declaringClass, name, parameterTypes);
                return f2 == null ? e(declaringClass, name, parameterTypes) : f2;
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static boolean d(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cls)) == null) {
            while (cls != null) {
                if (!Modifier.isPublic(cls.getModifiers())) {
                    return false;
                }
                cls = cls.getEnclosingClass();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, str, clsArr)) == null) {
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                if (Modifier.isPublic(superclass.getModifiers())) {
                    try {
                        return superclass.getMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        return null;
                    }
                }
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method f(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            while (cls != null) {
                Class<?>[] interfaces = cls.getInterfaces();
                for (int i2 = 0; i2 < interfaces.length; i2++) {
                    if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                        try {
                            return interfaces[i2].getDeclaredMethod(str, clsArr);
                        } catch (NoSuchMethodException unused) {
                            Method f2 = f(interfaces[i2], str, clsArr);
                            if (f2 != null) {
                                return f2;
                            }
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method g(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Method[] methods;
        Method c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, cls, str, clsArr)) == null) {
            String a2 = a(cls, str, clsArr);
            synchronized (f69457a) {
                method = f69457a.get(a2);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            try {
                Method method2 = cls.getMethod(str, clsArr);
                a.g(method2);
                synchronized (f69457a) {
                    f69457a.put(a2, method2);
                }
                return method2;
            } catch (NoSuchMethodException unused) {
                Method method3 = null;
                for (Method method4 : cls.getMethods()) {
                    if (method4.getName().equals(str) && a.i(clsArr, method4.getParameterTypes(), true) && (c2 = c(method4)) != null && (method3 == null || a.b(c2.getParameterTypes(), method3.getParameterTypes(), clsArr) < 0)) {
                        method3 = c2;
                    }
                }
                if (method3 != null) {
                    a.g(method3);
                }
                synchronized (f69457a) {
                    f69457a.put(a2, method3);
                    return method3;
                }
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, clsArr)) == null) {
            String a2 = a(cls, str, clsArr);
            synchronized (f69457a) {
                method = f69457a.get(a2);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            Method c2 = c(cls.getMethod(str, clsArr));
            synchronized (f69457a) {
                f69457a.put(a2, c2);
            }
            return c2;
        }
        return (Method) invokeLLL.objValue;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Constructor<?>[] constructors;
        Constructor<T> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, clsArr)) == null) {
            b.a(cls != null, "class cannot be null", new Object[0]);
            try {
                Constructor<T> constructor = cls.getConstructor(clsArr);
                a.g(constructor);
                return constructor;
            } catch (NoSuchMethodException unused) {
                Constructor<T> constructor2 = null;
                for (Constructor<?> constructor3 : cls.getConstructors()) {
                    if (a.i(clsArr, constructor3.getParameterTypes(), true) && (b2 = b(constructor3)) != null) {
                        a.g(b2);
                        if (constructor2 == null || a.b(b2.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                            constructor2 = b2;
                        }
                    }
                }
                return constructor2;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, objArr)) == null) {
            Object[] e2 = Utils.e(objArr);
            return (T) invokeConstructor(cls, e2, Utils.d(e2));
        }
        return (T) invokeLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, obj, str, objArr, clsArr)) == null) {
            Class<?>[] c2 = Utils.c(clsArr);
            Object[] e2 = Utils.e(objArr);
            Method g2 = g(obj.getClass(), str, c2);
            if (g2 != null) {
                return g2.invoke(obj, e2);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, cls, str, objArr, clsArr)) == null) {
            Class<?>[] c2 = Utils.c(clsArr);
            Object[] e2 = Utils.e(objArr);
            Method g2 = g(cls, str, c2);
            if (g2 != null) {
                return g2.invoke(null, e2);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
        }
        return invokeLLLL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, cls, objArr, clsArr)) == null) {
            Object[] e2 = Utils.e(objArr);
            Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.c(clsArr));
            if (matchingAccessibleConstructor != null) {
                return (T) matchingAccessibleConstructor.newInstance(e2);
            }
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, obj, str, objArr)) == null) {
            Object[] e2 = Utils.e(objArr);
            return invokeMethod(obj, str, e2, Utils.d(e2));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, cls, str, objArr)) == null) {
            Object[] e2 = Utils.e(objArr);
            return invokeStaticMethod(cls, str, e2, Utils.d(e2));
        }
        return invokeLLL.objValue;
    }
}
