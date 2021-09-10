package com.dxmpay.apollon.utils.reflect;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.h.a.a;
import c.f.a.h.a.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class FieldUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Field> f69456a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1876489374, "Lcom/dxmpay/apollon/utils/reflect/FieldUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1876489374, "Lcom/dxmpay/apollon/utils/reflect/FieldUtils;");
                return;
            }
        }
        f69456a = new HashMap();
    }

    public FieldUtils() {
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

    public static String a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
            return cls.toString() + "#" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static Field b(Class<?> cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Field field;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, cls, str, z)) == null) {
            b.a(cls != null, "The class must not be null", new Object[0]);
            b.a(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
            String a2 = a(cls, str);
            synchronized (f69456a) {
                field = f69456a.get(a2);
            }
            if (field != null) {
                if (z && !field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            }
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    declaredField = cls2.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    if (z) {
                        declaredField.setAccessible(true);
                    } else {
                        continue;
                    }
                }
                synchronized (f69456a) {
                    f69456a.put(a2, declaredField);
                }
                return declaredField;
            }
            Field field2 = null;
            for (Class<?> cls3 : Utils.getAllInterfaces(cls)) {
                try {
                    Field field3 = cls3.getField(str);
                    b.a(field2 == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    field2 = field3;
                } catch (NoSuchFieldException unused2) {
                }
            }
            synchronized (f69456a) {
                f69456a.put(a2, field2);
            }
            return field2;
        }
        return (Field) invokeLLZ.objValue;
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, z)) == null) {
            b.a(cls != null, "The class must not be null", new Object[0]);
            b.a(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!a.h(declaredField)) {
                    if (!z) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
        return (Field) invokeLLZ.objValue;
    }

    public static Field getField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, cls, str)) == null) ? b(cls, str, true) : (Field) invokeLL.objValue;
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, field, obj, z)) == null) {
            b.a(field != null, "The field must not be null", new Object[0]);
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                a.g(field);
            }
            return field.get(obj);
        }
        return invokeLLZ.objValue;
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, field, z)) == null) {
            b.a(field != null, "The field must not be null", new Object[0]);
            b.a(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
            return readField(field, (Object) null, z);
        }
        return invokeLZ.objValue;
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, obj, str, obj2) == null) {
            b.a(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, true);
            b.a(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(declaredField, obj, obj2, false);
        }
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{field, obj, obj2, Boolean.valueOf(z)}) == null) {
            b.a(field != null, "The field must not be null", new Object[0]);
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                a.g(field);
            }
            field.set(obj, obj2);
        }
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65554, null, field, obj, z) == null) {
            b.a(field != null, "The field must not be null", new Object[0]);
            b.a(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
            writeField(field, (Object) null, obj, z);
        }
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, str)) == null) {
            Field b2 = b(cls, str, true);
            b.a(b2 != null, "Cannot locate field '%s' on %s", str, cls);
            return readStaticField(b2, true);
        }
        return invokeLL.objValue;
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, field, obj)) == null) ? readField(field, obj, true) : invokeLL.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, obj, str, obj2) == null) {
            writeField(obj, str, obj2, true);
        }
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, cls, str, obj) == null) {
            Field b2 = b(cls, str, true);
            b.a(b2 != null, "Cannot locate field %s on %s", str, cls);
            writeStaticField(b2, obj, true);
        }
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, str)) == null) {
            b.a(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field b2 = b(cls, str, true);
            b.a(b2 != null, "Cannot locate field %s on %s", str, cls);
            return readField(b2, obj, false);
        }
        return invokeLL.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{obj, str, obj2, Boolean.valueOf(z)}) == null) {
            b.a(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field b2 = b(cls, str, true);
            b.a(b2 != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(b2, obj, obj2, z);
        }
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, obj, str, z)) == null) {
            b.a(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field b2 = b(cls, str, z);
            b.a(b2 != null, "Cannot locate field %s on %s", str, cls);
            return readField(b2, obj, z);
        }
        return invokeLLZ.objValue;
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, field, obj, obj2) == null) {
            writeField(field, obj, obj2, true);
        }
    }
}
