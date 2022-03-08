package org.apache.commons.lang3.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes9.dex */
public class ConstructorUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConstructorUtils() {
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

    public static <T> Constructor<T> getAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            Validate.notNull(cls, "class cannot be null", new Object[0]);
            try {
                return getAccessibleConstructor(cls.getConstructor(clsArr));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Constructor<?>[] constructors;
        Constructor<T> accessibleConstructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, clsArr)) == null) {
            Validate.notNull(cls, "class cannot be null", new Object[0]);
            try {
                Constructor<T> constructor = cls.getConstructor(clsArr);
                MemberUtils.setAccessibleWorkaround(constructor);
                return constructor;
            } catch (NoSuchMethodException unused) {
                Constructor<T> constructor2 = null;
                for (Constructor<?> constructor3 : cls.getConstructors()) {
                    if (MemberUtils.isMatchingConstructor(constructor3, clsArr) && (accessibleConstructor = getAccessibleConstructor(constructor3)) != null) {
                        MemberUtils.setAccessibleWorkaround(accessibleConstructor);
                        if (constructor2 == null || MemberUtils.compareConstructorFit(accessibleConstructor, constructor2, clsArr) < 0) {
                            constructor2 = accessibleConstructor;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, objArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return (T) invokeConstructor(cls, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, objArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            return (T) invokeExactConstructor(cls, nullToEmpty, ClassUtils.toClass(nullToEmpty));
        }
        return (T) invokeLL.objValue;
    }

    public static boolean isAccessible(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
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

    public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> constructor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, constructor)) == null) {
            Validate.notNull(constructor, "constructor cannot be null", new Object[0]);
            if (MemberUtils.isAccessible(constructor) && isAccessible(constructor.getDeclaringClass())) {
                return constructor;
            }
            return null;
        }
        return (Constructor) invokeL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, objArr, clsArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, ArrayUtils.nullToEmpty(clsArr));
            if (matchingAccessibleConstructor != null) {
                if (matchingAccessibleConstructor.isVarArgs()) {
                    nullToEmpty = MethodUtils.getVarArgs(nullToEmpty, matchingAccessibleConstructor.getParameterTypes());
                }
                return (T) matchingAccessibleConstructor.newInstance(nullToEmpty);
            }
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) invokeLLL.objValue;
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, objArr, clsArr)) == null) {
            Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
            Constructor accessibleConstructor = getAccessibleConstructor(cls, ArrayUtils.nullToEmpty(clsArr));
            if (accessibleConstructor != null) {
                return (T) accessibleConstructor.newInstance(nullToEmpty);
            }
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) invokeLLL.objValue;
    }
}
