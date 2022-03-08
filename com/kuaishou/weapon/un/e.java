package com.kuaishou.weapon.un;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    public static Class<?> a(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, classLoader, str)) == null) {
            try {
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException e2) {
                l1.a(e2);
                return null;
            }
        }
        return (Class) invokeLL.objValue;
    }

    public static Field a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
            try {
                Field field = cls.getField(str);
                if (field != null) {
                    return field;
                }
            } catch (Throwable th) {
                l1.a(th);
            }
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (NoSuchFieldException e2) {
                    l1.a(e2);
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchFieldException();
        }
        return (Field) invokeLL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                if (method != null) {
                    return method;
                }
            } catch (Throwable th) {
                l1.a(th);
            }
            while (cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException e2) {
                    l1.a(e2);
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchMethodException();
        }
        return (Method) invokeLLL.objValue;
    }

    public static boolean a(Activity activity, Activity activity2) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, activity2)) == null) {
            if (activity == null || activity2 == null) {
                return false;
            }
            for (Class<Activity> cls = Activity.class; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        field.set(activity2, field.getName().equals("mWindow") ? activity.getWindow() : field.get(activity));
                    } catch (Throwable th) {
                        l1.a(th);
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Class<?> cls, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, obj, obj2)) == null) {
            if (obj == null || obj2 == null) {
                return false;
            }
            while (cls != null && cls != Object.class) {
                for (Field field : cls.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        field.set(obj2, field.get(obj));
                    } catch (Throwable th) {
                        l1.a(th);
                    }
                }
                cls = cls.getSuperclass();
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static Field b(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, str)) == null) {
            try {
                return a(cls, str);
            } catch (NoSuchFieldException e2) {
                l1.a(e2);
                return null;
            }
        }
        return (Field) invokeLL.objValue;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            try {
                method = a(cls, str, clsArr);
                try {
                    method.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    e = e2;
                    l1.a(e);
                    return method;
                }
            } catch (NoSuchMethodException e3) {
                e = e3;
                method = null;
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }
}
