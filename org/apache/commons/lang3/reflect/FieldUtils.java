package org.apache.commons.lang3.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes9.dex */
public class FieldUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FieldUtils() {
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

    public static Field[] getAllFields(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            List<Field> allFieldsList = getAllFieldsList(cls);
            return (Field[]) allFieldsList.toArray(new Field[allFieldsList.size()]);
        }
        return (Field[]) invokeL.objValue;
    }

    public static List<Field> getAllFieldsList(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
            ArrayList arrayList = new ArrayList();
            while (cls != null) {
                for (Field field : cls.getDeclaredFields()) {
                    arrayList.add(field);
                }
                cls = cls.getSuperclass();
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Field getDeclaredField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) ? getDeclaredField(cls, str, false) : (Field) invokeLL.objValue;
    }

    public static Field getField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, str)) == null) {
            Field field = getField(cls, str, false);
            MemberUtils.setAccessibleWorkaround(field);
            return field;
        }
        return (Field) invokeLL.objValue;
    }

    public static List<Field> getFieldsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, cls, cls2)) == null) {
            Validate.isTrue(cls2 != null, "The annotation class must not be null", new Object[0]);
            List<Field> allFieldsList = getAllFieldsList(cls);
            ArrayList arrayList = new ArrayList();
            for (Field field : allFieldsList) {
                if (field.getAnnotation(cls2) != null) {
                    arrayList.add(field);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cls, cls2)) == null) {
            List<Field> fieldsListWithAnnotation = getFieldsListWithAnnotation(cls, cls2);
            return (Field[]) fieldsListWithAnnotation.toArray(new Field[fieldsListWithAnnotation.size()]);
        }
        return (Field[]) invokeLL.objValue;
    }

    public static Object readDeclaredField(Object obj, String str) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, obj, str)) == null) ? readDeclaredField(obj, str, false) : invokeLL.objValue;
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, str)) == null) ? readDeclaredStaticField(cls, str, false) : invokeLL.objValue;
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, field, obj)) == null) ? readField(field, obj, false) : invokeLL.objValue;
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, field)) == null) ? readStaticField(field, false) : invokeL.objValue;
    }

    public static void removeFinalModifier(Field field) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, field) == null) {
            removeFinalModifier(field, true);
        }
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, obj, str, obj2) == null) {
            writeDeclaredField(obj, str, obj2, false);
        }
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, cls, str, obj) == null) {
            writeDeclaredStaticField(cls, str, obj, false);
        }
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, field, obj, obj2) == null) {
            writeField(field, obj, obj2, false);
        }
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, field, obj) == null) {
            writeStaticField(field, obj, false);
        }
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, z)) == null) {
            Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
            Validate.isTrue(StringUtils.isNotBlank(str), "The field name must not be blank/empty", new Object[0]);
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!MemberUtils.isAccessible(declaredField)) {
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

    public static Object readDeclaredField(Object obj, String str, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, obj, str, z)) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, z);
            Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls, str);
            return readField(declaredField, obj, false);
        }
        return invokeLLZ.objValue;
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, null, cls, str, z)) == null) {
            Field declaredField = getDeclaredField(cls, str, z);
            Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            return readStaticField(declaredField, false);
        }
        return invokeLLZ.objValue;
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65552, null, field, obj, z)) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                MemberUtils.setAccessibleWorkaround(field);
            }
            return field.get(obj);
        }
        return invokeLLZ.objValue;
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65556, null, field, z)) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
            return readField(field, (Object) null, z);
        }
        return invokeLZ.objValue;
    }

    public static void removeFinalModifier(Field field, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65558, null, field, z) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            try {
                if (Modifier.isFinal(field.getModifiers())) {
                    Field declaredField = Field.class.getDeclaredField("modifiers");
                    boolean z2 = z && !declaredField.isAccessible();
                    if (z2) {
                        declaredField.setAccessible(true);
                    }
                    declaredField.setInt(field, field.getModifiers() & (-17));
                    if (z2) {
                        declaredField.setAccessible(false);
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{obj, str, obj2, Boolean.valueOf(z)}) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, z);
            Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(declaredField, obj, obj2, false);
        }
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{cls, str, obj, Boolean.valueOf(z)}) == null) {
            Field declaredField = getDeclaredField(cls, str, z);
            Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(declaredField, (Object) null, obj, false);
        }
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{field, obj, obj2, Boolean.valueOf(z)}) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                MemberUtils.setAccessibleWorkaround(field);
            }
            field.set(obj, obj2);
        }
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65570, null, field, obj, z) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
            writeField(field, (Object) null, obj, z);
        }
    }

    public static Field getField(Class<?> cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, cls, str, z)) == null) {
            Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
            Validate.isTrue(StringUtils.isNotBlank(str), "The field name must not be blank/empty", new Object[0]);
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
                return declaredField;
            }
            Field field = null;
            for (Class<?> cls3 : ClassUtils.getAllInterfaces(cls)) {
                try {
                    Field field2 = cls3.getField(str);
                    Validate.isTrue(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    field = field2;
                } catch (NoSuchFieldException unused2) {
                }
            }
            return field;
        }
        return (Field) invokeLLZ.objValue;
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, cls, str)) == null) ? readStaticField(cls, str, false) : invokeLL.objValue;
    }

    public static Object readStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65554, null, cls, str, z)) == null) {
            Field field = getField(cls, str, z);
            Validate.isTrue(field != null, "Cannot locate field '%s' on %s", str, cls);
            return readStaticField(field, false);
        }
        return invokeLLZ.objValue;
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, obj, str)) == null) ? readField(obj, str, false) : invokeLL.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, obj, str, obj2) == null) {
            writeField(obj, str, obj2, false);
        }
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65567, null, cls, str, obj) == null) {
            writeStaticField(cls, str, obj, false);
        }
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65550, null, obj, str, z)) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z);
            Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
            return readField(field, obj, false);
        }
        return invokeLLZ.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{obj, str, obj2, Boolean.valueOf(z)}) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z);
            Validate.isTrue(field != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(field, obj, obj2, false);
        }
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{cls, str, obj, Boolean.valueOf(z)}) == null) {
            Field field = getField(cls, str, z);
            Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
            writeStaticField(field, obj, false);
        }
    }
}
