package org.apache.commons.lang3.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes9.dex */
public class MethodUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MethodUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int distance(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, clsArr, clsArr2)) == null) {
            if (ClassUtils.isAssignable(clsArr, clsArr2, true)) {
                int i2 = 0;
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    if (!clsArr[i3].equals(clsArr2[i3])) {
                        i2 = (!ClassUtils.isAssignable(clsArr[i3], clsArr2[i3], true) || ClassUtils.isAssignable(clsArr[i3], clsArr2[i3], false)) ? i2 + 2 : i2 + 1;
                    }
                }
                return i2;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            try {
                return getAccessibleMethod(cls.getMethod(str, clsArr));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, clsArr)) == null) {
            while (cls != null) {
                Class<?>[] interfaces = cls.getInterfaces();
                for (int i2 = 0; i2 < interfaces.length; i2++) {
                    if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                        try {
                            return interfaces[i2].getDeclaredMethod(str, clsArr);
                        } catch (NoSuchMethodException unused) {
                            Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(interfaces[i2], str, clsArr);
                            if (accessibleMethodFromInterfaceNest != null) {
                                return accessibleMethodFromInterfaceNest;
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

    public static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, str, clsArr)) == null) {
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

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method[] methods;
        Method accessibleMethod;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                MemberUtils.setAccessibleWorkaround(method);
                return method;
            } catch (NoSuchMethodException unused) {
                Method method2 = null;
                for (Method method3 : cls.getMethods()) {
                    if (method3.getName().equals(str) && MemberUtils.isMatchingMethod(method3, clsArr) && (accessibleMethod = getAccessibleMethod(method3)) != null && (method2 == null || MemberUtils.compareMethodFit(accessibleMethod, method2, clsArr) < 0)) {
                        method2 = accessibleMethod;
                    }
                }
                if (method2 != null) {
                    MemberUtils.setAccessibleWorkaround(method2);
                }
                return method2;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method getMatchingMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            Validate.notNull(cls, "Null class not allowed.", new Object[0]);
            Validate.notEmpty(str, "Null or blank methodName not allowed.", new Object[0]);
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Class<?> cls2 : ClassUtils.getAllSuperclasses(cls)) {
                declaredMethods = (Method[]) ArrayUtils.addAll(declaredMethods, cls2.getDeclaredMethods());
            }
            Method method = null;
            for (Method method2 : declaredMethods) {
                if (str.equals(method2.getName()) && ArrayUtils.isEquals(clsArr, method2.getParameterTypes())) {
                    return method2;
                }
                if (str.equals(method2.getName()) && ClassUtils.isAssignable(clsArr, method2.getParameterTypes(), true) && (method == null || distance(clsArr, method2.getParameterTypes()) < distance(clsArr, method.getParameterTypes()))) {
                    method = method2;
                }
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cls, cls2)) == null) {
            Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
            Validate.isTrue(cls2 != null, "The annotation class must not be null", new Object[0]);
            Method[] methods = cls.getMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method : methods) {
                if (method.getAnnotation(cls2) != null) {
                    arrayList.add(method);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, cls, cls2)) == null) {
            List<Method> methodsListWithAnnotation = getMethodsListWithAnnotation(cls, cls2);
            return (Method[]) methodsListWithAnnotation.toArray(new Method[methodsListWithAnnotation.size()]);
        }
        return (Method[]) invokeLL.objValue;
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, method, interfaces)) == null) {
            Validate.notNull(method);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(method);
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> declaringClass = method.getDeclaringClass();
            Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
            it.next();
            while (it.hasNext()) {
                Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
                if (matchingAccessibleMethod != null) {
                    if (Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                        linkedHashSet.add(matchingAccessibleMethod);
                    } else {
                        Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                        int i2 = 0;
                        while (true) {
                            if (i2 < parameterTypes.length) {
                                if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i2]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i2]))) {
                                    break;
                                }
                                i2++;
                            } else {
                                linkedHashSet.add(matchingAccessibleMethod);
                                break;
                            }
                        }
                    }
                }
            }
            return linkedHashSet;
        }
        return (Set) invokeLL.objValue;
    }

    public static Object[] getVarArgs(Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, objArr, clsArr)) == null) {
            if (objArr.length == clsArr.length && objArr[objArr.length - 1].getClass().equals(clsArr[clsArr.length - 1])) {
                return objArr;
            }
            Object[] objArr2 = new Object[clsArr.length];
            System.arraycopy(objArr, 0, objArr2, 0, clsArr.length - 1);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            int length = (objArr.length - clsArr.length) + 1;
            Object newInstance = Array.newInstance(ClassUtils.primitiveToWrapper(componentType), length);
            System.arraycopy(objArr, clsArr.length - 1, newInstance, 0, length);
            if (componentType.isPrimitive()) {
                newInstance = ArrayUtils.toPrimitive(newInstance);
            }
            objArr2[clsArr.length - 1] = newInstance;
            return objArr2;
        }
        return (Object[]) invokeLL.objValue;
    }

    public static Object invokeExactMethod(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, str)) == null) ? invokeExactMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null) : invokeLL.objValue;
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, cls, str, objArr, clsArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
            if (accessibleMethod != null) {
                return accessibleMethod.invoke(null, nullToEmpty);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, obj, str)) == null) ? invokeMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[]) null) : invokeLL.objValue;
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, cls, str, objArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return invokeStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return invokeLLL.objValue;
    }

    public static Object[] toVarArgs(Method method, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, method, objArr)) == null) ? method.isVarArgs() ? getVarArgs(objArr, method.getParameterTypes()) : objArr : (Object[]) invokeLL.objValue;
    }

    public static Method getAccessibleMethod(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, method)) == null) {
            if (MemberUtils.isAccessible(method)) {
                Class<?> declaringClass = method.getDeclaringClass();
                if (Modifier.isPublic(declaringClass.getModifiers())) {
                    return method;
                }
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
                return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, obj, str, objArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return invokeExactMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, boolean z, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{obj, Boolean.valueOf(z), str})) == null) ? invokeMethod(obj, z, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null) : invokeCommon.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, obj, str, objArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return invokeMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65560, null, cls, str, objArr, clsArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
            if (matchingAccessibleMethod != null) {
                return matchingAccessibleMethod.invoke(null, toVarArgs(matchingAccessibleMethod, nullToEmpty));
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, obj, str, objArr, clsArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, ArrayUtils.nullToEmpty(clsArr));
            if (accessibleMethod != null) {
                return accessibleMethod.invoke(obj, nullToEmpty);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{obj, Boolean.valueOf(z), str, objArr})) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return invokeMethod(obj, z, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return invokeCommon.objValue;
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, cls, str, objArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return invokeExactStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeCommon;
        String str2;
        Method matchingAccessibleMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{obj, Boolean.valueOf(z), str, objArr, clsArr})) == null) {
            Class<?>[] nullToEmpty = ArrayUtils.nullToEmpty(clsArr);
            Object[] nullToEmpty2 = ArrayUtils.nullToEmpty(objArr);
            Method method = null;
            boolean z2 = false;
            try {
                if (z) {
                    str2 = "No such method: ";
                    matchingAccessibleMethod = getMatchingMethod(obj.getClass(), str, nullToEmpty);
                    if (matchingAccessibleMethod != null && !(z2 = matchingAccessibleMethod.isAccessible())) {
                        matchingAccessibleMethod.setAccessible(true);
                    }
                } else {
                    str2 = "No such accessible method: ";
                    matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
                }
                if (matchingAccessibleMethod != null) {
                    Object invoke = matchingAccessibleMethod.invoke(obj, toVarArgs(matchingAccessibleMethod, nullToEmpty2));
                    if (matchingAccessibleMethod != null && z && matchingAccessibleMethod.isAccessible() != z2) {
                        matchingAccessibleMethod.setAccessible(z2);
                    }
                    return invoke;
                }
                throw new NoSuchMethodException(str2 + str + "() on object: " + obj.getClass().getName());
            } catch (Throwable th) {
                if (0 != 0 && z && method.isAccessible()) {
                    method.setAccessible(false);
                }
                throw th;
            }
        }
        return invokeCommon.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, obj, str, objArr, clsArr)) == null) ? invokeMethod(obj, false, str, objArr, clsArr) : invokeLLLL.objValue;
    }
}
