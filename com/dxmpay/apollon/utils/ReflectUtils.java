package com.dxmpay.apollon.utils;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class ReflectUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f69452a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f69453b;

    /* loaded from: classes9.dex */
    public class NULL {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NULL(ReflectUtils reflectUtils) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reflectUtils};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f69454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ReflectUtils f69455f;

        public a(ReflectUtils reflectUtils, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reflectUtils, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69455f = reflectUtils;
            this.f69454e = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                try {
                    return ReflectUtils.on(this.f69455f.f69452a).call(name, objArr).get();
                } catch (RuntimeException e2) {
                    if (this.f69454e) {
                        Map map = (Map) this.f69455f.f69452a;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(ReflectUtils.k(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(ReflectUtils.k(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(ReflectUtils.k(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e2;
                }
            }
            return invokeLLL.objValue;
        }
    }

    public ReflectUtils(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69452a = cls;
        this.f69453b = true;
    }

    public static ReflectUtils a(Constructor<?> constructor, Object... objArr) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, constructor, objArr)) == null) {
            try {
                return on(((Constructor) accessible(constructor)).newInstance(objArr));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeLL.objValue;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            if (t == null) {
                return null;
            }
            if (t instanceof Member) {
                Member member = (Member) t;
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return t;
                }
            }
            if (!t.isAccessible()) {
                t.setAccessible(true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public static ReflectUtils b(Method method, Object obj, Object... objArr) throws RuntimeException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, method, obj, objArr)) == null) {
            try {
                accessible(method);
                if (method.getReturnType() == Void.TYPE) {
                    method.invoke(obj, objArr);
                    return on(obj);
                }
                return on(method.invoke(obj, objArr));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeLLL.objValue;
    }

    public static Class<?> c(String str, ClassLoader classLoader) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, classLoader)) == null) {
            try {
                return Class.forName(str, true, classLoader);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Class) invokeLL.objValue;
    }

    public static Object e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? obj instanceof ReflectUtils ? ((ReflectUtils) obj).get() : obj : invokeL.objValue;
    }

    public static Class<?>[] j(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, objArr)) == null) {
            if (objArr == null) {
                return new Class[0];
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                clsArr[i2] = obj == null ? NULL.class : obj.getClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            int length = str.length();
            if (length == 0) {
                return "";
            }
            if (length == 1) {
                return str.toLowerCase();
            }
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }
        return (String) invokeL.objValue;
    }

    public static Class<?> m(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Class) invokeL.objValue;
    }

    public static ReflectUtils on(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? on(m(str)) : (ReflectUtils) invokeL.objValue;
    }

    public static Class<?> wrapper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            if (cls.isPrimitive()) {
                if (Boolean.TYPE == cls) {
                    return Boolean.class;
                }
                if (Integer.TYPE == cls) {
                    return Integer.class;
                }
                if (Long.TYPE == cls) {
                    return Long.class;
                }
                if (Short.TYPE == cls) {
                    return Short.class;
                }
                if (Byte.TYPE == cls) {
                    return Byte.class;
                }
                if (Double.TYPE == cls) {
                    return Double.class;
                }
                if (Float.TYPE == cls) {
                    return Float.class;
                }
                if (Character.TYPE == cls) {
                    return Character.class;
                }
                return Void.TYPE == cls ? Void.class : cls;
            }
            return cls;
        }
        return (Class) invokeL.objValue;
    }

    public <P> P as(Class<P> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this, this.f69452a instanceof Map)) : (P) invokeL.objValue;
    }

    public ReflectUtils call(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? call(str, new Object[0]) : (ReflectUtils) invokeL.objValue;
    }

    public ReflectUtils create() throws RuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? create(new Object[0]) : (ReflectUtils) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof ReflectUtils) {
                return this.f69452a.equals(((ReflectUtils) obj).get());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ReflectUtils field(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return on(n(str).get(this.f69452a));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeL.objValue;
    }

    public Map<String, ReflectUtils> fields() {
        InterceptResult invokeV;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Class<?> type = type();
            do {
                for (Field field : type.getDeclaredFields()) {
                    if ((!this.f69453b) ^ Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!linkedHashMap.containsKey(name)) {
                            linkedHashMap.put(name, field(name));
                        }
                    }
                }
                type = type.getSuperclass();
            } while (type != null);
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final Method g(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, clsArr)) == null) {
            Class<?> type = type();
            try {
                return type.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                do {
                    try {
                        return type.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused2) {
                        type = type.getSuperclass();
                        if (type == null) {
                            throw new NoSuchMethodException();
                        }
                    }
                } while (type == null);
                throw new NoSuchMethodException();
            }
        }
        return (Method) invokeLL.objValue;
    }

    public <T> T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (T) this.f69452a : (T) invokeV.objValue;
    }

    public final boolean h(Method method, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, method, str, clsArr)) == null) ? method.getName().equals(str) && i(method.getParameterTypes(), clsArr) : invokeLLL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f69452a.hashCode() : invokeV.intValue;
    }

    public final boolean i(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, clsArr, clsArr2)) == null) {
            if (clsArr.length == clsArr2.length) {
                for (int i2 = 0; i2 < clsArr2.length; i2++) {
                    if (clsArr2[i2] != NULL.class && !wrapper(clsArr[i2]).isAssignableFrom(wrapper(clsArr2[i2]))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final Method l(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Method[] methods;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, clsArr)) == null) {
            Class<?> type = type();
            for (Method method : type.getMethods()) {
                if (h(method, str, clsArr)) {
                    return method;
                }
            }
            do {
                for (Method method2 : type.getDeclaredMethods()) {
                    if (h(method2, str, clsArr)) {
                        return method2;
                    }
                }
                type = type.getSuperclass();
            } while (type != null);
            throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
        }
        return (Method) invokeLL.objValue;
    }

    public final Field n(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Class<?> type = type();
            try {
                return type.getField(str);
            } catch (NoSuchFieldException e2) {
                do {
                    try {
                        return (Field) accessible(type.getDeclaredField(str));
                    } catch (NoSuchFieldException unused) {
                        type = type.getSuperclass();
                        if (type != null) {
                            throw new RuntimeException(e2);
                        }
                    }
                } while (type != null);
                throw new RuntimeException(e2);
            }
        }
        return (Field) invokeL.objValue;
    }

    public ReflectUtils set(String str, Object obj) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, obj)) == null) {
            try {
                Field n = n(str);
                n.setAccessible(true);
                n.set(this.f69452a, e(obj));
                return this;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f69452a.toString() : (String) invokeV.objValue;
    }

    public Class<?> type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f69453b) {
                return (Class) this.f69452a;
            }
            return this.f69452a.getClass();
        }
        return (Class) invokeV.objValue;
    }

    public static ReflectUtils on(String str, ClassLoader classLoader) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, classLoader)) == null) ? on(c(str, classLoader)) : (ReflectUtils) invokeLL.objValue;
    }

    public ReflectUtils call(String str, Object... objArr) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr)) == null) {
            Class<?>[] j2 = j(objArr);
            try {
                try {
                    return b(g(str, j2), this.f69452a, objArr);
                } catch (NoSuchMethodException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (NoSuchMethodException unused) {
                return b(l(str, j2), this.f69452a, objArr);
            }
        }
        return (ReflectUtils) invokeLL.objValue;
    }

    public ReflectUtils create(Object... objArr) throws RuntimeException {
        InterceptResult invokeL;
        Constructor<?>[] declaredConstructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            Class<?>[] j2 = j(objArr);
            try {
                return a(type().getDeclaredConstructor(j2), objArr);
            } catch (NoSuchMethodException e2) {
                for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                    if (i(constructor.getParameterTypes(), j2)) {
                        return a(constructor, objArr);
                    }
                }
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeL.objValue;
    }

    public <T> T get(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? (T) field(str).get() : (T) invokeL.objValue;
    }

    public static ReflectUtils on(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) ? new ReflectUtils(cls) : (ReflectUtils) invokeL.objValue;
    }

    public ReflectUtils(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69452a = obj;
        this.f69453b = false;
    }

    public static ReflectUtils on(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, obj)) == null) ? new ReflectUtils(obj) : (ReflectUtils) invokeL.objValue;
    }
}
