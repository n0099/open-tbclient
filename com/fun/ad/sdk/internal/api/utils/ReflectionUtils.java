package com.fun.ad.sdk.internal.api.utils;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class ReflectionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ReflectionUtils() {
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
                                try {
                                    return field.get(obj);
                                } catch (IllegalAccessException e2) {
                                    e2.printStackTrace();
                                    return null;
                                }
                            }
                        }
                        cls = cls.getSuperclass();
                        if (cls == Object.class) {
                            break;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, obj, str, clsArr, objArr)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                return obj.getClass().getDeclaredMethod(str, clsArr).invoke(obj, objArr);
            } catch (Exception e2) {
                LogPrinter.e(e2);
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static void traverseAllField(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, obj) == null) {
            LogPrinter.d();
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            int length = declaredFields.length;
            for (int i2 = 0; i2 < length; i2++) {
                String name = declaredFields[i2].getName();
                try {
                    boolean isAccessible = declaredFields[i2].isAccessible();
                    declaredFields[i2].setAccessible(true);
                    try {
                        Object obj2 = declaredFields[i2].get(obj);
                        LogPrinter.d("field : " + name + ", value : " + obj2, new Object[0]);
                    } catch (IllegalAccessException unused) {
                    }
                    declaredFields[i2].setAccessible(isAccessible);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
    }
}
