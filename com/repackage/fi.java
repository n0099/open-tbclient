package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Object obj, Field field) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, obj, field)) == null) {
            Object obj2 = null;
            if (obj == null || field == null) {
                return null;
            }
            boolean isAccessible = field.isAccessible();
            try {
                field.setAccessible(true);
                obj2 = field.get(obj);
                field.setAccessible(isAccessible);
                return obj2;
            } catch (Throwable unused) {
                return obj2;
            }
        }
        return invokeLL.objValue;
    }

    public static Field b(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, cls2)) == null) {
            if (cls == null) {
                return null;
            }
            while (cls != Object.class) {
                try {
                    for (Field field : cls.getDeclaredFields()) {
                        if (cls2.isAssignableFrom(field.getType())) {
                            return field;
                        }
                    }
                    continue;
                } catch (Throwable unused) {
                }
                cls = cls.getSuperclass();
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static List<Field> c(Object obj, Class<?> cls) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, cls)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.getType().isAssignableFrom(cls)) {
                    arrayList.add(field);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
