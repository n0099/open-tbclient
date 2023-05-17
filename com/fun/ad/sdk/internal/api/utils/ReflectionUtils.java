package com.fun.ad.sdk.internal.api.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes9.dex */
public class ReflectionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ReflectionUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object getField(Object obj, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, strArr)) == null) {
            if (obj == null || strArr == null || strArr.length == 0) {
                return null;
            }
            for (String str : strArr) {
                obj = getField(str, obj);
                if (obj == null) {
                    return null;
                }
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public static Object getField(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, obj)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                Field declaredField = obj.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, clsArr, objArr)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                return obj.getClass().getDeclaredMethod(str, clsArr).invoke(obj, objArr);
            } catch (Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static void traverseAllField(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, obj) == null) {
            LogPrinter.d();
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            int length = declaredFields.length;
            for (int i = 0; i < length; i++) {
                String name = declaredFields[i].getName();
                try {
                    boolean isAccessible = declaredFields[i].isAccessible();
                    declaredFields[i].setAccessible(true);
                    try {
                        Object obj2 = declaredFields[i].get(obj);
                        LogPrinter.d("field : " + name + ", value : " + obj2, new Object[0]);
                    } catch (IllegalAccessException unused) {
                    }
                    declaredFields[i].setAccessible(isAccessible);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
    }

    public static Object findField(String str, Object obj) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, obj)) == null) {
            if (obj != null) {
                try {
                    Class<?> cls = obj.getClass();
                    while (cls != null) {
                        for (Field field : cls.getDeclaredFields()) {
                            if (TextUtils.equals(str, field.getType().getName())) {
                                field.setAccessible(true);
                                return field.get(obj);
                            }
                        }
                        cls = cls.getSuperclass();
                        if (cls == Object.class) {
                            return null;
                        }
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
