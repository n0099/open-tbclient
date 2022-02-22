package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.lang3.ArrayUtils;
/* loaded from: classes5.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean appendStatics;
    public boolean appendTransients;
    public String[] excludeFieldNames;
    public Class<?> upToClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionToStringBuilder(Object obj) {
        super(checkNotNull(obj));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    public static Object checkNotNull(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj != null) {
                return obj;
            }
            throw new IllegalArgumentException("The Object passed in should not be null.");
        }
        return invokeL.objValue;
    }

    public static String[] toNoNullStringArray(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, collection)) == null) {
            if (collection == null) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            return toNoNullStringArray(collection.toArray());
        }
        return (String[]) invokeL.objValue;
    }

    public static String toString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? toString(obj, null, false, false, null) : (String) invokeL.objValue;
    }

    public static String toStringExclude(Object obj, Collection<String> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, collection)) == null) ? toStringExclude(obj, toNoNullStringArray(collection)) : (String) invokeLL.objValue;
    }

    public boolean accept(Field field) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, field)) == null) {
            if (field.getName().indexOf(36) != -1) {
                return false;
            }
            if (!Modifier.isTransient(field.getModifiers()) || isAppendTransients()) {
                if (!Modifier.isStatic(field.getModifiers()) || isAppendStatics()) {
                    String[] strArr = this.excludeFieldNames;
                    return (strArr == null || Arrays.binarySearch(strArr, field.getName()) < 0) && !field.isAnnotationPresent(ToStringExclude.class);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void appendFieldsIn(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls) == null) {
            if (cls.isArray()) {
                reflectionAppendArray(getObject());
                return;
            }
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                String name = field.getName();
                if (accept(field)) {
                    try {
                        append(name, getValue(field));
                    } catch (IllegalAccessException e2) {
                        throw new InternalError("Unexpected IllegalAccessException: " + e2.getMessage());
                    }
                }
            }
        }
    }

    public String[] getExcludeFieldNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (String[]) this.excludeFieldNames.clone() : (String[]) invokeV.objValue;
    }

    public Class<?> getUpToClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.upToClass : (Class) invokeV.objValue;
    }

    public Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, field)) == null) ? field.get(getObject()) : invokeL.objValue;
    }

    public boolean isAppendStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.appendStatics : invokeV.booleanValue;
    }

    public boolean isAppendTransients() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.appendTransients : invokeV.booleanValue;
    }

    public ReflectionToStringBuilder reflectionAppendArray(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, obj);
            return this;
        }
        return (ReflectionToStringBuilder) invokeL.objValue;
    }

    public void setAppendStatics(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.appendStatics = z;
        }
    }

    public void setAppendTransients(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.appendTransients = z;
        }
    }

    public ReflectionToStringBuilder setExcludeFieldNames(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, strArr)) == null) {
            if (strArr == null) {
                this.excludeFieldNames = null;
            } else {
                String[] noNullStringArray = toNoNullStringArray(strArr);
                this.excludeFieldNames = noNullStringArray;
                Arrays.sort(noNullStringArray);
            }
            return this;
        }
        return (ReflectionToStringBuilder) invokeL.objValue;
    }

    public void setUpToClass(Class<?> cls) {
        Object object;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cls) == null) {
            if (cls != null && (object = getObject()) != null && !cls.isInstance(object)) {
                throw new IllegalArgumentException("Specified class is not a superclass of the object");
            }
            this.upToClass = cls;
        }
    }

    public static String toString(Object obj, ToStringStyle toStringStyle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, toStringStyle)) == null) ? toString(obj, toStringStyle, false, false, null) : (String) invokeLL.objValue;
    }

    public static String toStringExclude(Object obj, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, obj, strArr)) == null) ? new ReflectionToStringBuilder(obj).setExcludeFieldNames(strArr).toString() : (String) invokeLL.objValue;
    }

    public static String[] toNoNullStringArray(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, objArr)) == null) {
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                if (obj != null) {
                    arrayList.add(obj.toString());
                }
            }
            return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        return (String[]) invokeL.objValue;
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, obj, toStringStyle, z)) == null) ? toString(obj, toStringStyle, z, false, null) : (String) invokeLLZ.objValue;
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{obj, toStringStyle, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? toString(obj, toStringStyle, z, z2, null) : (String) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        super(checkNotNull(obj), toStringStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, toStringStyle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (ToStringStyle) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, Class<? super T> cls) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{t, toStringStyle, Boolean.valueOf(z), Boolean.valueOf(z2), cls})) == null) ? new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2).toString() : (String) invokeCommon.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringBuilder
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (getObject() == null) {
                return getStyle().getNullText();
            }
            Class<?> cls = getObject().getClass();
            appendFieldsIn(cls);
            while (cls.getSuperclass() != null && cls != getUpToClass()) {
                cls = cls.getSuperclass();
                appendFieldsIn(cls);
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(checkNotNull(obj), toStringStyle, stringBuffer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, toStringStyle, stringBuffer};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (ToStringStyle) objArr2[1], (StringBuffer) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(checkNotNull(t), toStringStyle, stringBuffer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, toStringStyle, stringBuffer, cls, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (ToStringStyle) objArr2[1], (StringBuffer) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
    }
}
