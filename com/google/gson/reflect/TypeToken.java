package com.google.gson.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class TypeToken<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int hashCode;
    public final Class<? super T> rawType;
    public final Type type;

    public TypeToken() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(superclassTypeParameter);
        this.hashCode = this.type.hashCode();
    }

    public static AssertionError buildUnexpectedTypeError(Type type, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, type, clsArr)) == null) {
            StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
            for (Class<?> cls : clsArr) {
                sb.append(cls.getName());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("but got: ");
            sb.append(type.getClass().getName());
            sb.append(", for type token: ");
            sb.append(type.toString());
            sb.append('.');
            return new AssertionError(sb.toString());
        }
        return (AssertionError) invokeLL.objValue;
    }

    public static TypeToken<?> get(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, type)) == null) ? new TypeToken<>(type) : (TypeToken) invokeL.objValue;
    }

    public static TypeToken<?> getArray(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, type)) == null) ? new TypeToken<>(C$Gson$Types.arrayOf(type)) : (TypeToken) invokeL.objValue;
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, type, typeArr)) == null) ? new TypeToken<>(C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr)) : (TypeToken) invokeLL.objValue;
    }

    public static Type getSuperclassTypeParameter(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof Class)) {
                return C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            }
            throw new RuntimeException("Missing type parameter.");
        }
        return (Type) invokeL.objValue;
    }

    public static boolean matches(Type type, Type type2, Map<String, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, type, type2, map)) == null) ? type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName()))) : invokeLLL.booleanValue;
    }

    public static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, parameterizedType, parameterizedType2, map)) == null) {
            if (parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                    if (!matches(actualTypeArguments[i2], actualTypeArguments2[i2], map)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof TypeToken) && C$Gson$Types.equals(this.type, ((TypeToken) obj).type) : invokeL.booleanValue;
    }

    public final Class<? super T> getRawType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.rawType : (Class) invokeV.objValue;
    }

    public final Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type : (Type) invokeV.objValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hashCode : invokeV.intValue;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) ? isAssignableFrom((Type) cls) : invokeL.booleanValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? C$Gson$Types.typeToString(this.type) : (String) invokeV.objValue;
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) ? new TypeToken<>(cls) : (TypeToken) invokeL.objValue;
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, type)) == null) {
            if (type == null) {
                return false;
            }
            if (this.type.equals(type)) {
                return true;
            }
            Type type2 = this.type;
            if (type2 instanceof Class) {
                return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type));
            }
            if (type2 instanceof ParameterizedType) {
                return isAssignableFrom(type, (ParameterizedType) type2, new HashMap());
            }
            if (type2 instanceof GenericArrayType) {
                return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type)) && isAssignableFrom(type, (GenericArrayType) this.type);
            }
            throw buildUnexpectedTypeError(type2, Class.class, ParameterizedType.class, GenericArrayType.class);
        }
        return invokeL.booleanValue;
    }

    public TypeToken(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Type canonicalize = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.type = canonicalize;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(canonicalize);
        this.hashCode = this.type.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, typeToken)) == null) ? isAssignableFrom(typeToken.getType()) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0028 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, type, genericArrayType)) == null) {
            Type genericComponentType = genericArrayType.getGenericComponentType();
            if (genericComponentType instanceof ParameterizedType) {
                if (type instanceof GenericArrayType) {
                    type = ((GenericArrayType) type).getGenericComponentType();
                } else if (type instanceof Class) {
                    type = (Class) type;
                    while (type.isArray()) {
                        type = type.getComponentType();
                    }
                }
                return isAssignableFrom(type, (ParameterizedType) genericComponentType, new HashMap());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, type, parameterizedType, map)) == null) {
            if (type == null) {
                return false;
            }
            if (parameterizedType.equals(type)) {
                return true;
            }
            Class<?> rawType = C$Gson$Types.getRawType(type);
            ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
            if (parameterizedType2 != null) {
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = rawType.getTypeParameters();
                for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                    Type type2 = actualTypeArguments[i2];
                    TypeVariable<Class<?>> typeVariable = typeParameters[i2];
                    while (type2 instanceof TypeVariable) {
                        type2 = map.get(((TypeVariable) type2).getName());
                    }
                    map.put(typeVariable.getName(), type2);
                }
                if (typeEquals(parameterizedType2, parameterizedType, map)) {
                    return true;
                }
            }
            for (Type type3 : rawType.getGenericInterfaces()) {
                if (isAssignableFrom(type3, parameterizedType, new HashMap(map))) {
                    return true;
                }
            }
            return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new HashMap(map));
        }
        return invokeLLL.booleanValue;
    }
}
