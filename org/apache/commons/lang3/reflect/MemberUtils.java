package org.apache.commons.lang3.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;
/* loaded from: classes3.dex */
public abstract class MemberUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCESS_TEST = 7;
    public static final Class<?>[] ORDERED_PRIMITIVE_TYPES;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class Executable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean isVarArgs;
        public final Class<?>[] parameterTypes;

        public Executable(Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {method};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.parameterTypes = method.getParameterTypes();
            this.isVarArgs = method.isVarArgs();
        }

        public static Executable of(Method method) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, method)) == null) ? new Executable(method) : (Executable) invokeL.objValue;
        }

        public Class<?>[] getParameterTypes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.parameterTypes : (Class[]) invokeV.objValue;
        }

        public boolean isVarArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isVarArgs : invokeV.booleanValue;
        }

        public static Executable of(Constructor<?> constructor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, constructor)) == null) ? new Executable(constructor) : (Executable) invokeL.objValue;
        }

        public Executable(Constructor<?> constructor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constructor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parameterTypes = constructor.getParameterTypes();
            this.isVarArgs = constructor.isVarArgs();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-581423215, "Lorg/apache/commons/lang3/reflect/MemberUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-581423215, "Lorg/apache/commons/lang3/reflect/MemberUtils;");
                return;
            }
        }
        ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    }

    public MemberUtils() {
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

    public static int compareConstructorFit(Constructor<?> constructor, Constructor<?> constructor2, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, constructor, constructor2, clsArr)) == null) ? compareParameterTypes(Executable.of(constructor), Executable.of(constructor2), clsArr) : invokeLLL.intValue;
    }

    public static int compareMethodFit(Method method, Method method2, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, method, method2, clsArr)) == null) ? compareParameterTypes(Executable.of(method), Executable.of(method2), clsArr) : invokeLLL.intValue;
    }

    public static int compareParameterTypes(Executable executable, Executable executable2, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, executable, executable2, clsArr)) == null) {
            float totalTransformationCost = getTotalTransformationCost(clsArr, executable);
            float totalTransformationCost2 = getTotalTransformationCost(clsArr, executable2);
            if (totalTransformationCost < totalTransformationCost2) {
                return -1;
            }
            return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
        }
        return invokeLLL.intValue;
    }

    public static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, cls2)) == null) {
            if (cls2.isPrimitive()) {
                return getPrimitivePromotionCost(cls, cls2);
            }
            float f2 = 0.0f;
            while (true) {
                if (cls != null && !cls2.equals(cls)) {
                    if (cls2.isInterface() && ClassUtils.isAssignable(cls, cls2)) {
                        f2 += 0.25f;
                        break;
                    }
                    f2 += 1.0f;
                    cls = cls.getSuperclass();
                } else {
                    break;
                }
            }
            return cls == null ? f2 + 1.5f : f2;
        }
        return invokeLL.floatValue;
    }

    public static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, cls2)) == null) {
            if (cls.isPrimitive()) {
                f2 = 0.0f;
            } else {
                cls = ClassUtils.wrapperToPrimitive(cls);
                f2 = 0.1f;
            }
            int i2 = 0;
            while (cls != cls2) {
                Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
                if (i2 >= clsArr.length) {
                    break;
                }
                if (cls == clsArr[i2]) {
                    f2 += 0.1f;
                    if (i2 < clsArr.length - 1) {
                        cls = clsArr[i2 + 1];
                    }
                }
                i2++;
            }
            return f2;
        }
        return invokeLL.floatValue;
    }

    public static float getTotalTransformationCost(Class<?>[] clsArr, Executable executable) {
        InterceptResult invokeLL;
        float objectTransformationCost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, clsArr, executable)) == null) {
            Class<?>[] parameterTypes = executable.getParameterTypes();
            boolean isVarArgs = executable.isVarArgs();
            int length = parameterTypes.length;
            if (isVarArgs) {
                length--;
            }
            long j2 = length;
            if (clsArr.length < j2) {
                return Float.MAX_VALUE;
            }
            boolean z = false;
            float f2 = 0.0f;
            for (int i2 = 0; i2 < j2; i2++) {
                f2 += getObjectTransformationCost(clsArr[i2], parameterTypes[i2]);
            }
            if (isVarArgs) {
                boolean z2 = clsArr.length < parameterTypes.length;
                if (clsArr.length == parameterTypes.length && clsArr[clsArr.length - 1].isArray()) {
                    z = true;
                }
                Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
                if (z2) {
                    objectTransformationCost = getObjectTransformationCost(componentType, Object.class);
                } else if (z) {
                    objectTransformationCost = getObjectTransformationCost(clsArr[clsArr.length - 1].getComponentType(), componentType);
                } else {
                    for (int length2 = parameterTypes.length - 1; length2 < clsArr.length; length2++) {
                        f2 += getObjectTransformationCost(clsArr[length2], componentType) + 0.001f;
                    }
                    return f2;
                }
                return f2 + objectTransformationCost + 0.001f;
            }
            return f2;
        }
        return invokeLL.floatValue;
    }

    public static boolean isAccessible(Member member) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, member)) == null) ? (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true : invokeL.booleanValue;
    }

    public static boolean isMatchingConstructor(Constructor<?> constructor, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, constructor, clsArr)) == null) ? isMatchingExecutable(Executable.of(constructor), clsArr) : invokeLL.booleanValue;
    }

    public static boolean isMatchingExecutable(Executable executable, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, executable, clsArr)) == null) {
            Class<?>[] parameterTypes = executable.getParameterTypes();
            if (executable.isVarArgs()) {
                int i2 = 0;
                while (i2 < parameterTypes.length - 1 && i2 < clsArr.length) {
                    if (!ClassUtils.isAssignable(clsArr[i2], parameterTypes[i2], true)) {
                        return false;
                    }
                    i2++;
                }
                Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
                while (i2 < clsArr.length) {
                    if (!ClassUtils.isAssignable(clsArr[i2], componentType, true)) {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
            return ClassUtils.isAssignable(clsArr, parameterTypes, true);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isMatchingMethod(Method method, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, method, clsArr)) == null) ? isMatchingExecutable(Executable.of(method), clsArr) : invokeLL.booleanValue;
    }

    public static boolean isPackageAccess(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? (i2 & 7) == 0 : invokeI.booleanValue;
    }

    public static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, accessibleObject)) == null) {
            if (accessibleObject != null && !accessibleObject.isAccessible()) {
                Member member = (Member) accessibleObject;
                if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                    try {
                        accessibleObject.setAccessible(true);
                        return true;
                    } catch (SecurityException unused) {
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
