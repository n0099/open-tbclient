package org.aspectj.lang;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes9.dex */
public class Aspects {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASPECTOF = "aspectOf";
    public static final Class[] EMPTY_CLASS_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public static final String HASASPECT = "hasAspect";
    public static final Class[] PEROBJECT_CLASS_ARRAY;
    public static final Class[] PERTYPEWITHIN_CLASS_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(20200365, "Lorg/aspectj/lang/Aspects;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(20200365, "Lorg/aspectj/lang/Aspects;");
                return;
            }
        }
        EMPTY_CLASS_ARRAY = new Class[0];
        PEROBJECT_CLASS_ARRAY = new Class[]{Object.class};
        PERTYPEWITHIN_CLASS_ARRAY = new Class[]{Class.class};
        EMPTY_OBJECT_ARRAY = new Object[0];
    }

    public Aspects() {
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

    public static <T> T aspectOf(Class<T> cls) throws NoAspectBoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            try {
                return (T) getSingletonOrThreadAspectOf(cls).invoke(null, EMPTY_OBJECT_ARRAY);
            } catch (InvocationTargetException e2) {
                throw new NoAspectBoundException(cls.getName(), e2);
            } catch (Exception e3) {
                throw new NoAspectBoundException(cls.getName(), e3);
            }
        }
        return (T) invokeL.objValue;
    }

    public static Method checkAspectOf(Method method, Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, method, cls)) == null) {
            method.setAccessible(true);
            if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            throw new NoSuchMethodException(cls.getName() + ".aspectOf(..) is not accessible public static");
        }
        return (Method) invokeLL.objValue;
    }

    public static Method checkHasAspect(Method method, Class cls) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, method, cls)) == null) {
            method.setAccessible(true);
            if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            throw new NoSuchMethodException(cls.getName() + ".hasAspect(..) is not accessible public static");
        }
        return (Method) invokeLL.objValue;
    }

    public static Method getPerObjectAspectOf(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) ? checkAspectOf(cls.getDeclaredMethod("aspectOf", PEROBJECT_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getPerObjectHasAspect(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) ? checkHasAspect(cls.getDeclaredMethod("hasAspect", PEROBJECT_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getPerTypeWithinAspectOf(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? checkAspectOf(cls.getDeclaredMethod("aspectOf", PERTYPEWITHIN_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getPerTypeWithinHasAspect(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cls)) == null) ? checkHasAspect(cls.getDeclaredMethod("hasAspect", PERTYPEWITHIN_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getSingletonOrThreadAspectOf(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? checkAspectOf(cls.getDeclaredMethod("aspectOf", EMPTY_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getSingletonOrThreadHasAspect(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) ? checkHasAspect(cls.getDeclaredMethod("hasAspect", EMPTY_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static boolean hasAspect(Class<?> cls) throws NoAspectBoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) {
            try {
                return ((Boolean) getSingletonOrThreadHasAspect(cls).invoke(null, EMPTY_OBJECT_ARRAY)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean hasAspect(Class<?> cls, Object obj) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, cls, obj)) == null) {
            try {
                return ((Boolean) getPerObjectHasAspect(cls).invoke(null, obj)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasAspect(Class<?> cls, Class<?> cls2) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, cls, cls2)) == null) {
            try {
                return ((Boolean) getPerTypeWithinHasAspect(cls).invoke(null, cls2)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <T> T aspectOf(Class<T> cls, Object obj) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, obj)) == null) {
            try {
                return (T) getPerObjectAspectOf(cls).invoke(null, obj);
            } catch (InvocationTargetException e2) {
                throw new NoAspectBoundException(cls.getName(), e2);
            } catch (Exception e3) {
                throw new NoAspectBoundException(cls.getName(), e3);
            }
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T aspectOf(Class<T> cls, Class<?> cls2) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, cls2)) == null) {
            try {
                return (T) getPerTypeWithinAspectOf(cls).invoke(null, cls2);
            } catch (InvocationTargetException e2) {
                throw new NoAspectBoundException(cls.getName(), e2);
            } catch (Exception e3) {
                throw new NoAspectBoundException(cls.getName(), e3);
            }
        }
        return (T) invokeLL.objValue;
    }
}
