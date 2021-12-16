package org.aspectj.lang;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes4.dex */
public class Aspects14 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASPECTOF = "aspectOf";
    public static final Class[] EMPTY_CLASS_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public static final String HASASPECT = "hasAspect";
    public static final Class[] PEROBJECT_CLASS_ARRAY;
    public static final Class[] PERTYPEWITHIN_CLASS_ARRAY;
    public static /* synthetic */ Class class$java$lang$Class;
    public static /* synthetic */ Class class$java$lang$Object;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2062293654, "Lorg/aspectj/lang/Aspects14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2062293654, "Lorg/aspectj/lang/Aspects14;");
                return;
            }
        }
        EMPTY_CLASS_ARRAY = new Class[0];
        Class[] clsArr = new Class[1];
        Class cls = class$java$lang$Object;
        if (cls == null) {
            cls = class$("java.lang.Object");
            class$java$lang$Object = cls;
        }
        clsArr[0] = cls;
        PEROBJECT_CLASS_ARRAY = clsArr;
        Class[] clsArr2 = new Class[1];
        Class cls2 = class$java$lang$Class;
        if (cls2 == null) {
            cls2 = class$("java.lang.Class");
            class$java$lang$Class = cls2;
        }
        clsArr2[0] = cls2;
        PERTYPEWITHIN_CLASS_ARRAY = clsArr2;
        EMPTY_OBJECT_ARRAY = new Object[0];
    }

    public Aspects14() {
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

    public static Object aspectOf(Class cls) throws NoAspectBoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            try {
                return getSingletonOrThreadAspectOf(cls).invoke(null, EMPTY_OBJECT_ARRAY);
            } catch (InvocationTargetException e2) {
                throw new NoAspectBoundException(cls.getName(), e2);
            } catch (Exception e3) {
                throw new NoAspectBoundException(cls.getName(), e3);
            }
        }
        return invokeL.objValue;
    }

    public static Method checkAspectOf(Method method, Class cls) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, method, cls)) == null) {
            method.setAccessible(true);
            if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cls.getName());
            stringBuffer.append(".aspectOf(..) is not accessible public static");
            throw new NoSuchMethodException(stringBuffer.toString());
        }
        return (Method) invokeLL.objValue;
    }

    public static Method checkHasAspect(Method method, Class cls) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, method, cls)) == null) {
            method.setAccessible(true);
            if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cls.getName());
            stringBuffer.append(".hasAspect(..) is not accessible public static");
            throw new NoSuchMethodException(stringBuffer.toString());
        }
        return (Method) invokeLL.objValue;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Method getPerObjectAspectOf(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) ? checkAspectOf(cls.getDeclaredMethod("aspectOf", PEROBJECT_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getPerObjectHasAspect(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? checkHasAspect(cls.getDeclaredMethod("hasAspect", PEROBJECT_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getPerTypeWithinAspectOf(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cls)) == null) ? checkAspectOf(cls.getDeclaredMethod("aspectOf", PERTYPEWITHIN_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getPerTypeWithinHasAspect(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? checkHasAspect(cls.getDeclaredMethod("hasAspect", PERTYPEWITHIN_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getSingletonOrThreadAspectOf(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) ? checkAspectOf(cls.getDeclaredMethod("aspectOf", EMPTY_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static Method getSingletonOrThreadHasAspect(Class cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) ? checkHasAspect(cls.getDeclaredMethod("hasAspect", EMPTY_CLASS_ARRAY), cls) : (Method) invokeL.objValue;
    }

    public static boolean hasAspect(Class cls) throws NoAspectBoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cls)) == null) {
            try {
                return ((Boolean) getSingletonOrThreadHasAspect(cls).invoke(null, EMPTY_OBJECT_ARRAY)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean hasAspect(Class cls, Object obj) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, cls, obj)) == null) {
            try {
                return ((Boolean) getPerObjectHasAspect(cls).invoke(null, obj)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasAspect(Class cls, Class cls2) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, cls, cls2)) == null) {
            try {
                return ((Boolean) getPerTypeWithinHasAspect(cls).invoke(null, cls2)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Object aspectOf(Class cls, Object obj) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, obj)) == null) {
            try {
                return getPerObjectAspectOf(cls).invoke(null, obj);
            } catch (InvocationTargetException e2) {
                throw new NoAspectBoundException(cls.getName(), e2);
            } catch (Exception e3) {
                throw new NoAspectBoundException(cls.getName(), e3);
            }
        }
        return invokeLL.objValue;
    }

    public static Object aspectOf(Class cls, Class cls2) throws NoAspectBoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, cls2)) == null) {
            try {
                return getPerTypeWithinAspectOf(cls).invoke(null, cls2);
            } catch (InvocationTargetException e2) {
                throw new NoAspectBoundException(cls.getName(), e2);
            } catch (Exception e3) {
                throw new NoAspectBoundException(cls.getName(), e3);
            }
        }
        return invokeLL.objValue;
    }
}
