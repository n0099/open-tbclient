package org.apache.commons.lang3.reflect;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
/* loaded from: classes9.dex */
public class TypeUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final WildcardType WILDCARD_ALL;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type componentType;

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj == this || ((obj instanceof GenericArrayType) && TypeUtils.equals((GenericArrayType) this, (Type) ((GenericArrayType) obj))) : invokeL.booleanValue;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.componentType : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.componentType.hashCode() | 1072 : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TypeUtils.toString(this) : (String) invokeV.objValue;
        }

        public GenericArrayTypeImpl(Type type) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.componentType = type;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<?> raw;
        public final Type[] typeArguments;
        public final Type useOwner;

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj == this || ((obj instanceof ParameterizedType) && TypeUtils.equals((ParameterizedType) this, (Type) ((ParameterizedType) obj))) : invokeL.booleanValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (Type[]) this.typeArguments.clone() : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.useOwner : (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.raw : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((((this.raw.hashCode() | 1136) << 4) | ObjectUtils.hashCode(this.useOwner)) << 8) | Arrays.hashCode(this.typeArguments) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TypeUtils.toString(this) : (String) invokeV.objValue;
        }

        public ParameterizedTypeImpl(Class<?> cls, Type type, Type[] typeArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, type, typeArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.raw = cls;
            this.useOwner = type;
            this.typeArguments = (Type[]) typeArr.clone();
        }
    }

    /* loaded from: classes9.dex */
    public static class WildcardTypeBuilder implements Builder<WildcardType> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Type[] lowerBounds;
        public Type[] upperBounds;

        public WildcardTypeBuilder withLowerBounds(Type... typeArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, typeArr)) == null) {
                this.lowerBounds = typeArr;
                return this;
            }
            return (WildcardTypeBuilder) invokeL.objValue;
        }

        public WildcardTypeBuilder withUpperBounds(Type... typeArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, typeArr)) == null) {
                this.upperBounds = typeArr;
                return this;
            }
            return (WildcardTypeBuilder) invokeL.objValue;
        }

        public WildcardTypeBuilder() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.apache.commons.lang3.builder.Builder
        public WildcardType build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WildcardTypeImpl(this.upperBounds, this.lowerBounds) : (WildcardType) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class WildcardTypeImpl implements WildcardType {
        public static /* synthetic */ Interceptable $ic;
        public static final Type[] EMPTY_BOUNDS;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type[] lowerBounds;
        public final Type[] upperBounds;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1043934707, "Lorg/apache/commons/lang3/reflect/TypeUtils$WildcardTypeImpl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1043934707, "Lorg/apache/commons/lang3/reflect/TypeUtils$WildcardTypeImpl;");
                    return;
                }
            }
            EMPTY_BOUNDS = new Type[0];
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj == this || ((obj instanceof WildcardType) && TypeUtils.equals((WildcardType) this, (Type) ((WildcardType) obj))) : invokeL.booleanValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (Type[]) this.lowerBounds.clone() : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (Type[]) this.upperBounds.clone() : (Type[]) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((Arrays.hashCode(this.upperBounds) | 18688) << 8) | Arrays.hashCode(this.lowerBounds) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TypeUtils.toString(this) : (String) invokeV.objValue;
        }

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeArr, typeArr2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.upperBounds = (Type[]) ObjectUtils.defaultIfNull(typeArr, EMPTY_BOUNDS);
            this.lowerBounds = (Type[]) ObjectUtils.defaultIfNull(typeArr2, EMPTY_BOUNDS);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1290009743, "Lorg/apache/commons/lang3/reflect/TypeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1290009743, "Lorg/apache/commons/lang3/reflect/TypeUtils;");
                return;
            }
        }
        WILDCARD_ALL = wildcardType().withUpperBounds(Object.class).build();
    }

    public TypeUtils() {
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

    public static StringBuilder appendAllTo(StringBuilder sb, String str, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, sb, str, typeArr)) == null) {
            Validate.notEmpty(Validate.noNullElements(typeArr));
            if (typeArr.length > 0) {
                sb.append(toString(typeArr[0]));
                for (int i2 = 1; i2 < typeArr.length; i2++) {
                    sb.append(str);
                    sb.append(toString(typeArr[i2]));
                }
            }
            return sb;
        }
        return (StringBuilder) invokeLLL.objValue;
    }

    public static String classToString(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            StringBuilder sb = new StringBuilder();
            if (cls.getEnclosingClass() != null) {
                sb.append(classToString(cls.getEnclosingClass()));
                sb.append('.');
                sb.append(cls.getSimpleName());
            } else {
                sb.append(cls.getName());
            }
            if (cls.getTypeParameters().length > 0) {
                sb.append('<');
                appendAllTo(sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, cls.getTypeParameters());
                sb.append('>');
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean containsTypeVariables(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, type)) == null) {
            if (type instanceof TypeVariable) {
                return true;
            }
            if (type instanceof Class) {
                return ((Class) type).getTypeParameters().length > 0;
            } else if (type instanceof ParameterizedType) {
                for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                    if (containsTypeVariables(type2)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return containsTypeVariables(getImplicitLowerBounds(wildcardType)[0]) || containsTypeVariables(getImplicitUpperBounds(wildcardType)[0]);
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> cls, ParameterizedType parameterizedType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cls, parameterizedType)) == null) {
            Validate.notNull(cls, "cls is null", new Object[0]);
            Validate.notNull(parameterizedType, "superType is null", new Object[0]);
            Class<?> rawType = getRawType(parameterizedType);
            if (isAssignable((Type) cls, rawType)) {
                if (cls.equals(rawType)) {
                    return getTypeArguments(parameterizedType, rawType, (Map<TypeVariable<?>, Type>) null);
                }
                Type closestParentType = getClosestParentType(cls, rawType);
                if (closestParentType instanceof Class) {
                    return determineTypeArguments((Class) closestParentType, parameterizedType);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) closestParentType;
                Map<TypeVariable<?>, Type> determineTypeArguments = determineTypeArguments(getRawType(parameterizedType2), parameterizedType);
                mapTypeVariablesToArguments(cls, parameterizedType2, determineTypeArguments);
                return determineTypeArguments;
            }
            return null;
        }
        return (Map) invokeLL.objValue;
    }

    public static boolean equals(Type type, Type type2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, type, type2)) == null) {
            if (ObjectUtils.equals(type, type2)) {
                return true;
            }
            if (type instanceof ParameterizedType) {
                return equals((ParameterizedType) type, type2);
            }
            if (type instanceof GenericArrayType) {
                return equals((GenericArrayType) type, type2);
            }
            if (type instanceof WildcardType) {
                return equals((WildcardType) type, type2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Type[] extractTypeArgumentsFrom(Map<TypeVariable<?>, Type> map, TypeVariable<?>[] typeVariableArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, map, typeVariableArr)) == null) {
            Type[] typeArr = new Type[typeVariableArr.length];
            int length = typeVariableArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                TypeVariable<?> typeVariable = typeVariableArr[i2];
                Validate.isTrue(map.containsKey(typeVariable), "missing argument mapping for %s", toString(typeVariable));
                typeArr[i3] = map.get(typeVariable);
                i2++;
                i3++;
            }
            return typeArr;
        }
        return (Type[]) invokeLL.objValue;
    }

    public static GenericArrayType genericArrayType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, type)) == null) ? new GenericArrayTypeImpl((Type) Validate.notNull(type, "componentType is null", new Object[0])) : (GenericArrayType) invokeL.objValue;
    }

    public static String genericArrayTypeToString(GenericArrayType genericArrayType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, genericArrayType)) == null) ? String.format("%s[]", toString(genericArrayType.getGenericComponentType())) : (String) invokeL.objValue;
    }

    public static Type getArrayComponentType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, type)) == null) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    return cls.getComponentType();
                }
                return null;
            } else if (type instanceof GenericArrayType) {
                return ((GenericArrayType) type).getGenericComponentType();
            } else {
                return null;
            }
        }
        return (Type) invokeL.objValue;
    }

    public static Type getClosestParentType(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Type[] genericInterfaces;
        Class<?> cls3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, cls, cls2)) == null) {
            if (cls2.isInterface()) {
                Type type = null;
                for (Type type2 : cls.getGenericInterfaces()) {
                    if (type2 instanceof ParameterizedType) {
                        cls3 = getRawType((ParameterizedType) type2);
                    } else if (type2 instanceof Class) {
                        cls3 = (Class) type2;
                    } else {
                        throw new IllegalStateException("Unexpected generic interface type found: " + type2);
                    }
                    if (isAssignable((Type) cls3, cls2) && isAssignable(type, (Type) cls3)) {
                        type = type2;
                    }
                }
                if (type != null) {
                    return type;
                }
            }
            return cls.getGenericSuperclass();
        }
        return (Type) invokeLL.objValue;
    }

    public static Type[] getImplicitBounds(TypeVariable<?> typeVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, typeVariable)) == null) {
            Validate.notNull(typeVariable, "typeVariable is null", new Object[0]);
            Type[] bounds = typeVariable.getBounds();
            return bounds.length == 0 ? new Type[]{Object.class} : normalizeUpperBounds(bounds);
        }
        return (Type[]) invokeL.objValue;
    }

    public static Type[] getImplicitLowerBounds(WildcardType wildcardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, wildcardType)) == null) {
            Validate.notNull(wildcardType, "wildcardType is null", new Object[0]);
            Type[] lowerBounds = wildcardType.getLowerBounds();
            return lowerBounds.length == 0 ? new Type[]{null} : lowerBounds;
        }
        return (Type[]) invokeL.objValue;
    }

    public static Type[] getImplicitUpperBounds(WildcardType wildcardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, wildcardType)) == null) {
            Validate.notNull(wildcardType, "wildcardType is null", new Object[0]);
            Type[] upperBounds = wildcardType.getUpperBounds();
            return upperBounds.length == 0 ? new Type[]{Object.class} : normalizeUpperBounds(upperBounds);
        }
        return (Type[]) invokeL.objValue;
    }

    public static Class<?> getRawType(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, parameterizedType)) == null) {
            Type rawType = parameterizedType.getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
        }
        return (Class) invokeL.objValue;
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, parameterizedType)) == null) ? getTypeArguments(parameterizedType, getRawType(parameterizedType), (Map<TypeVariable<?>, Type>) null) : (Map) invokeL.objValue;
    }

    public static boolean isArrayType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, type)) == null) ? (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray()) : invokeL.booleanValue;
    }

    public static boolean isAssignable(Type type, Type type2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, type, type2)) == null) ? isAssignable(type, type2, (Map<TypeVariable<?>, Type>) null) : invokeLL.booleanValue;
    }

    public static boolean isInstance(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, obj, type)) == null) {
            if (type == null) {
                return false;
            }
            if (obj == null) {
                return ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
            }
            return isAssignable(obj.getClass(), type, (Map<TypeVariable<?>, Type>) null);
        }
        return invokeLL.booleanValue;
    }

    public static <T> void mapTypeVariablesToArguments(Class<T> cls, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, cls, parameterizedType, map) == null) {
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                mapTypeVariablesToArguments(cls, (ParameterizedType) ownerType, map);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeParameters = getRawType(parameterizedType).getTypeParameters();
            List asList = Arrays.asList(cls.getTypeParameters());
            for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                TypeVariable<Class<?>> typeVariable = typeParameters[i2];
                Type type = actualTypeArguments[i2];
                if (asList.contains(type) && map.containsKey(typeVariable)) {
                    map.put((TypeVariable) type, map.get(typeVariable));
                }
            }
        }
    }

    public static Type[] normalizeUpperBounds(Type[] typeArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, typeArr)) == null) {
            Validate.notNull(typeArr, "null value specified for bounds array", new Object[0]);
            if (typeArr.length < 2) {
                return typeArr;
            }
            HashSet hashSet = new HashSet(typeArr.length);
            for (Type type : typeArr) {
                int length = typeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    Type type2 = typeArr[i2];
                    if (type != type2 && isAssignable(type2, type, (Map<TypeVariable<?>, Type>) null)) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    hashSet.add(type);
                }
            }
            return (Type[]) hashSet.toArray(new Type[hashSet.size()]);
        }
        return (Type[]) invokeL.objValue;
    }

    public static final ParameterizedType parameterize(Class<?> cls, Type... typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, cls, typeArr)) == null) ? parameterizeWithOwner((Type) null, cls, typeArr) : (ParameterizedType) invokeLL.objValue;
    }

    public static final ParameterizedType parameterizeWithOwner(Type type, Class<?> cls, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65579, null, type, cls, typeArr)) == null) {
            Validate.notNull(cls, "raw class is null", new Object[0]);
            if (cls.getEnclosingClass() == null) {
                Validate.isTrue(type == null, "no owner allowed for top-level %s", cls);
                type = null;
            } else if (type == null) {
                type = cls.getEnclosingClass();
            } else {
                Validate.isTrue(isAssignable(type, cls.getEnclosingClass()), "%s is invalid owner type for parameterized %s", type, cls);
            }
            Validate.noNullElements(typeArr, "null type argument at index %s", new Object[0]);
            Validate.isTrue(cls.getTypeParameters().length == typeArr.length, "invalid number of type parameters specified: expected %d, got %d", Integer.valueOf(cls.getTypeParameters().length), Integer.valueOf(typeArr.length));
            return new ParameterizedTypeImpl(cls, type, typeArr);
        }
        return (ParameterizedType) invokeLLL.objValue;
    }

    public static String parameterizedTypeToString(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, parameterizedType)) == null) {
            StringBuilder sb = new StringBuilder();
            Type ownerType = parameterizedType.getOwnerType();
            Class cls = (Class) parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (ownerType == null) {
                sb.append(cls.getName());
            } else {
                if (ownerType instanceof Class) {
                    sb.append(((Class) ownerType).getName());
                } else {
                    sb.append(ownerType.toString());
                }
                sb.append('.');
                sb.append(cls.getSimpleName());
            }
            sb.append('<');
            appendAllTo(sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, actualTypeArguments).append('>');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Type substituteTypeVariables(Type type, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, type, map)) == null) {
            if (!(type instanceof TypeVariable) || map == null) {
                return type;
            }
            Type type2 = map.get(type);
            if (type2 != null) {
                return type2;
            }
            throw new IllegalArgumentException("missing assignment type for type variable " + type);
        }
        return (Type) invokeLL.objValue;
    }

    public static String toLongString(TypeVariable<?> typeVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, typeVariable)) == null) {
            Validate.notNull(typeVariable, "var is null", new Object[0]);
            StringBuilder sb = new StringBuilder();
            Object genericDeclaration = typeVariable.getGenericDeclaration();
            if (genericDeclaration instanceof Class) {
                Class<?> cls = (Class) genericDeclaration;
                while (cls.getEnclosingClass() != null) {
                    sb.insert(0, cls.getSimpleName()).insert(0, '.');
                    cls = cls.getEnclosingClass();
                }
                sb.insert(0, cls.getName());
            } else if (genericDeclaration instanceof Type) {
                sb.append(toString((Type) genericDeclaration));
            } else {
                sb.append(genericDeclaration);
            }
            sb.append(':');
            sb.append(typeVariableToString(typeVariable));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String toString(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, type)) == null) {
            Validate.notNull(type);
            if (type instanceof Class) {
                return classToString((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return parameterizedTypeToString((ParameterizedType) type);
            }
            if (type instanceof WildcardType) {
                return wildcardTypeToString((WildcardType) type);
            }
            if (type instanceof TypeVariable) {
                return typeVariableToString((TypeVariable) type);
            }
            if (type instanceof GenericArrayType) {
                return genericArrayTypeToString((GenericArrayType) type);
            }
            throw new IllegalArgumentException(ObjectUtils.identityToString(type));
        }
        return (String) invokeL.objValue;
    }

    public static String typeVariableToString(TypeVariable<?> typeVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, typeVariable)) == null) {
            StringBuilder sb = new StringBuilder(typeVariable.getName());
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length > 0 && (bounds.length != 1 || !Object.class.equals(bounds[0]))) {
                sb.append(" extends ");
                appendAllTo(sb, " & ", typeVariable.getBounds());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, map)) == null) {
            Validate.notNull(map, "typeVarAssigns is null", new Object[0]);
            for (Map.Entry<TypeVariable<?>, Type> entry : map.entrySet()) {
                Type value = entry.getValue();
                for (Type type : getImplicitBounds(entry.getKey())) {
                    if (!isAssignable(value, substituteTypeVariables(type, map), map)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Type[] unrollBounds(Map<TypeVariable<?>, Type> map, Type[] typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65586, null, map, typeArr)) == null) {
            int i2 = 0;
            while (i2 < typeArr.length) {
                Type unrollVariables = unrollVariables(map, typeArr[i2]);
                if (unrollVariables == null) {
                    typeArr = (Type[]) ArrayUtils.remove((Object[]) typeArr, i2);
                    i2--;
                } else {
                    typeArr[i2] = unrollVariables;
                }
                i2++;
            }
            return typeArr;
        }
        return (Type[]) invokeLL.objValue;
    }

    public static Type unrollVariableAssignments(TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        Type type;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, null, typeVariable, map)) == null) {
            while (true) {
                type = map.get(typeVariable);
                if (!(type instanceof TypeVariable) || type.equals(typeVariable)) {
                    break;
                }
                typeVariable = (TypeVariable) type;
            }
            return type;
        }
        return (Type) invokeLL.objValue;
    }

    public static Type unrollVariables(Map<TypeVariable<?>, Type> map, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, map, type)) == null) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            if (containsTypeVariables(type)) {
                if (type instanceof TypeVariable) {
                    return unrollVariables(map, map.get(type));
                }
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getOwnerType() != null) {
                        HashMap hashMap = new HashMap(map);
                        hashMap.putAll(getTypeArguments(parameterizedType));
                        map = hashMap;
                    }
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                        Type unrollVariables = unrollVariables(map, actualTypeArguments[i2]);
                        if (unrollVariables != null) {
                            actualTypeArguments[i2] = unrollVariables;
                        }
                    }
                    return parameterizeWithOwner(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), actualTypeArguments);
                } else if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    return wildcardType().withUpperBounds(unrollBounds(map, wildcardType.getUpperBounds())).withLowerBounds(unrollBounds(map, wildcardType.getLowerBounds())).build();
                }
            }
            return type;
        }
        return (Type) invokeLL.objValue;
    }

    public static WildcardTypeBuilder wildcardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? new WildcardTypeBuilder() : (WildcardTypeBuilder) invokeV.objValue;
    }

    public static String wildcardTypeToString(WildcardType wildcardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, wildcardType)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('?');
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length <= 1 && (lowerBounds.length != 1 || lowerBounds[0] == null)) {
                if (upperBounds.length > 1 || (upperBounds.length == 1 && !Object.class.equals(upperBounds[0]))) {
                    sb.append(" extends ");
                    appendAllTo(sb, " & ", upperBounds);
                }
            } else {
                sb.append(" super ");
                appendAllTo(sb, " & ", lowerBounds);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static <T> Typed<T> wrap(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, type)) == null) ? new Typed<T>(type) { // from class: org.apache.commons.lang3.reflect.TypeUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Type val$type;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {type};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$type = type;
            }

            @Override // org.apache.commons.lang3.reflect.Typed
            public Type getType() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$type : (Type) invokeV.objValue;
            }
        } : (Typed) invokeL.objValue;
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, type, cls)) == null) ? getTypeArguments(type, cls, (Map<TypeVariable<?>, Type>) null) : (Map) invokeLL.objValue;
    }

    public static boolean isAssignable(Type type, Type type2, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, type, type2, map)) == null) {
            if (type2 != null && !(type2 instanceof Class)) {
                if (type2 instanceof ParameterizedType) {
                    return isAssignable(type, (ParameterizedType) type2, map);
                }
                if (type2 instanceof GenericArrayType) {
                    return isAssignable(type, (GenericArrayType) type2, map);
                }
                if (type2 instanceof WildcardType) {
                    return isAssignable(type, (WildcardType) type2, map);
                }
                if (type2 instanceof TypeVariable) {
                    return isAssignable(type, (TypeVariable<?>) type2, map);
                }
                throw new IllegalStateException("found an unhandled type: " + type2);
            }
            return isAssignable(type, (Class<?>) type2);
        }
        return invokeLLL.booleanValue;
    }

    public static final ParameterizedType parameterize(Class<?> cls, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, cls, map)) == null) {
            Validate.notNull(cls, "raw class is null", new Object[0]);
            Validate.notNull(map, "typeArgMappings is null", new Object[0]);
            return parameterizeWithOwner((Type) null, cls, extractTypeArgumentsFrom(map, cls.getTypeParameters()));
        }
        return (ParameterizedType) invokeLL.objValue;
    }

    public static <T> Typed<T> wrap(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65591, null, cls)) == null) ? wrap((Type) cls) : (Typed) invokeL.objValue;
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, type, cls, map)) == null) {
            if (type instanceof Class) {
                return getTypeArguments((Class<?>) type, cls, map);
            }
            if (type instanceof ParameterizedType) {
                return getTypeArguments((ParameterizedType) type, cls, map);
            }
            if (type instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                if (cls.isArray()) {
                    cls = cls.getComponentType();
                }
                return getTypeArguments(genericComponentType, cls, map);
            }
            int i2 = 0;
            if (type instanceof WildcardType) {
                Type[] implicitUpperBounds = getImplicitUpperBounds((WildcardType) type);
                int length = implicitUpperBounds.length;
                while (i2 < length) {
                    Type type2 = implicitUpperBounds[i2];
                    if (isAssignable(type2, cls)) {
                        return getTypeArguments(type2, cls, map);
                    }
                    i2++;
                }
                return null;
            } else if (type instanceof TypeVariable) {
                Type[] implicitBounds = getImplicitBounds((TypeVariable) type);
                int length2 = implicitBounds.length;
                while (i2 < length2) {
                    Type type3 = implicitBounds[i2];
                    if (isAssignable(type3, cls)) {
                        return getTypeArguments(type3, cls, map);
                    }
                    i2++;
                }
                return null;
            } else {
                throw new IllegalStateException("found an unhandled type: " + type);
            }
        }
        return (Map) invokeLLL.objValue;
    }

    public static Class<?> getRawType(Type type, Type type2) {
        InterceptResult invokeLL;
        Map<TypeVariable<?>, Type> typeArguments;
        Type type3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, type, type2)) == null) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                return getRawType((ParameterizedType) type);
            }
            if (type instanceof TypeVariable) {
                if (type2 == null) {
                    return null;
                }
                GenericDeclaration genericDeclaration = ((TypeVariable) type).getGenericDeclaration();
                if (!(genericDeclaration instanceof Class) || (typeArguments = getTypeArguments(type2, (Class) genericDeclaration)) == null || (type3 = typeArguments.get(type)) == null) {
                    return null;
                }
                return getRawType(type3, type2);
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType(), type2), 0).getClass();
            } else {
                if (type instanceof WildcardType) {
                    return null;
                }
                throw new IllegalArgumentException("unknown type: " + type);
            }
        }
        return (Class) invokeLL.objValue;
    }

    public static boolean equals(ParameterizedType parameterizedType, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, parameterizedType, type)) == null) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type;
                if (equals(parameterizedType.getRawType(), parameterizedType2.getRawType()) && equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
                    return equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean equals(GenericArrayType genericArrayType, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, genericArrayType, type)) == null) ? (type instanceof GenericArrayType) && equals(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType()) : invokeLL.booleanValue;
    }

    public static final ParameterizedType parameterizeWithOwner(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, null, type, cls, map)) == null) {
            Validate.notNull(cls, "raw class is null", new Object[0]);
            Validate.notNull(map, "typeArgMappings is null", new Object[0]);
            return parameterizeWithOwner(type, cls, extractTypeArgumentsFrom(map, cls.getTypeParameters()));
        }
        return (ParameterizedType) invokeLLL.objValue;
    }

    public static boolean isAssignable(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, type, cls)) == null) {
            if (type == null) {
                return cls == null || !cls.isPrimitive();
            } else if (cls == null) {
                return false;
            } else {
                if (cls.equals(type)) {
                    return true;
                }
                if (type instanceof Class) {
                    return ClassUtils.isAssignable((Class) type, cls);
                }
                if (type instanceof ParameterizedType) {
                    return isAssignable((Type) getRawType((ParameterizedType) type), cls);
                }
                if (type instanceof TypeVariable) {
                    for (Type type2 : ((TypeVariable) type).getBounds()) {
                        if (isAssignable(type2, cls)) {
                            return true;
                        }
                    }
                    return false;
                } else if (type instanceof GenericArrayType) {
                    if (cls.equals(Object.class)) {
                        return true;
                    }
                    return cls.isArray() && isAssignable(((GenericArrayType) type).getGenericComponentType(), cls.getComponentType());
                } else if (type instanceof WildcardType) {
                    return false;
                } else {
                    throw new IllegalStateException("found an unhandled type: " + type);
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean equals(WildcardType wildcardType, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, wildcardType, type)) == null) {
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                return equals(getImplicitLowerBounds(wildcardType), getImplicitLowerBounds(wildcardType2)) && equals(getImplicitUpperBounds(wildcardType), getImplicitUpperBounds(wildcardType2));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean equals(Type[] typeArr, Type[] typeArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, typeArr, typeArr2)) == null) {
            if (typeArr.length == typeArr2.length) {
                for (int i2 = 0; i2 < typeArr.length; i2++) {
                    if (!equals(typeArr[i2], typeArr2[i2])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Map<TypeVariable<?>, Type> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, parameterizedType, cls, map)) == null) {
            Class<?> rawType = getRawType(parameterizedType);
            if (isAssignable((Type) rawType, cls)) {
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType instanceof ParameterizedType) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
                    hashMap = getTypeArguments(parameterizedType2, getRawType(parameterizedType2), map);
                } else {
                    hashMap = map == null ? new HashMap<>() : new HashMap(map);
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = rawType.getTypeParameters();
                for (int i2 = 0; i2 < typeParameters.length; i2++) {
                    Type type = actualTypeArguments[i2];
                    TypeVariable<Class<?>> typeVariable = typeParameters[i2];
                    if (hashMap.containsKey(type)) {
                        type = hashMap.get(type);
                    }
                    hashMap.put(typeVariable, type);
                }
                return cls.equals(rawType) ? hashMap : getTypeArguments(getClosestParentType(rawType, cls), cls, hashMap);
            }
            return null;
        }
        return (Map) invokeLLL.objValue;
    }

    public static boolean isAssignable(Type type, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, type, parameterizedType, map)) == null) {
            if (type == null) {
                return true;
            }
            if (parameterizedType == null) {
                return false;
            }
            if (parameterizedType.equals(type)) {
                return true;
            }
            Class<?> rawType = getRawType(parameterizedType);
            Map<TypeVariable<?>, Type> typeArguments = getTypeArguments(type, rawType, (Map<TypeVariable<?>, Type>) null);
            if (typeArguments == null) {
                return false;
            }
            if (typeArguments.isEmpty()) {
                return true;
            }
            Map<TypeVariable<?>, Type> typeArguments2 = getTypeArguments(parameterizedType, rawType, map);
            for (TypeVariable<?> typeVariable : typeArguments2.keySet()) {
                Type unrollVariableAssignments = unrollVariableAssignments(typeVariable, typeArguments2);
                Type unrollVariableAssignments2 = unrollVariableAssignments(typeVariable, typeArguments);
                if (unrollVariableAssignments != null || !(unrollVariableAssignments2 instanceof Class)) {
                    if (unrollVariableAssignments2 != null && !unrollVariableAssignments.equals(unrollVariableAssignments2) && (!(unrollVariableAssignments instanceof WildcardType) || !isAssignable(unrollVariableAssignments2, unrollVariableAssignments, map))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Class<?> cls, Class<?> cls2, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, null, cls, cls2, map)) == null) {
            if (isAssignable((Type) cls, cls2)) {
                if (cls.isPrimitive()) {
                    if (cls2.isPrimitive()) {
                        return new HashMap();
                    }
                    cls = ClassUtils.primitiveToWrapper(cls);
                }
                HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
                return cls2.equals(cls) ? hashMap : getTypeArguments(getClosestParentType(cls, cls2), cls2, hashMap);
            }
            return null;
        }
        return (Map) invokeLLL.objValue;
    }

    public static boolean isAssignable(Type type, GenericArrayType genericArrayType, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, type, genericArrayType, map)) == null) {
            if (type == null) {
                return true;
            }
            if (genericArrayType == null) {
                return false;
            }
            if (genericArrayType.equals(type)) {
                return true;
            }
            Type genericComponentType = genericArrayType.getGenericComponentType();
            if (type instanceof Class) {
                Class cls = (Class) type;
                return cls.isArray() && isAssignable(cls.getComponentType(), genericComponentType, map);
            } else if (type instanceof GenericArrayType) {
                return isAssignable(((GenericArrayType) type).getGenericComponentType(), genericComponentType, map);
            } else {
                if (type instanceof WildcardType) {
                    for (Type type2 : getImplicitUpperBounds((WildcardType) type)) {
                        if (isAssignable(type2, genericArrayType)) {
                            return true;
                        }
                    }
                    return false;
                } else if (type instanceof TypeVariable) {
                    for (Type type3 : getImplicitBounds((TypeVariable) type)) {
                        if (isAssignable(type3, genericArrayType)) {
                            return true;
                        }
                    }
                    return false;
                } else if (type instanceof ParameterizedType) {
                    return false;
                } else {
                    throw new IllegalStateException("found an unhandled type: " + type);
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isAssignable(Type type, WildcardType wildcardType, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65572, null, type, wildcardType, map)) == null) {
            if (type == null) {
                return true;
            }
            if (wildcardType == null) {
                return false;
            }
            if (wildcardType.equals(type)) {
                return true;
            }
            Type[] implicitUpperBounds = getImplicitUpperBounds(wildcardType);
            Type[] implicitLowerBounds = getImplicitLowerBounds(wildcardType);
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] implicitUpperBounds2 = getImplicitUpperBounds(wildcardType2);
                Type[] implicitLowerBounds2 = getImplicitLowerBounds(wildcardType2);
                for (Type type2 : implicitUpperBounds) {
                    Type substituteTypeVariables = substituteTypeVariables(type2, map);
                    for (Type type3 : implicitUpperBounds2) {
                        if (!isAssignable(type3, substituteTypeVariables, map)) {
                            return false;
                        }
                    }
                }
                for (Type type4 : implicitLowerBounds) {
                    Type substituteTypeVariables2 = substituteTypeVariables(type4, map);
                    for (Type type5 : implicitLowerBounds2) {
                        if (!isAssignable(substituteTypeVariables2, type5, map)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            for (Type type6 : implicitUpperBounds) {
                if (!isAssignable(type, substituteTypeVariables(type6, map), map)) {
                    return false;
                }
            }
            for (Type type7 : implicitLowerBounds) {
                if (!isAssignable(substituteTypeVariables(type7, map), type, map)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isAssignable(Type type, TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65571, null, type, typeVariable, map)) == null) {
            if (type == null) {
                return true;
            }
            if (typeVariable == null) {
                return false;
            }
            if (typeVariable.equals(type)) {
                return true;
            }
            if (type instanceof TypeVariable) {
                for (Type type2 : getImplicitBounds((TypeVariable) type)) {
                    if (isAssignable(type2, typeVariable, map)) {
                        return true;
                    }
                }
            }
            if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
                return false;
            }
            throw new IllegalStateException("found an unhandled type: " + type);
        }
        return invokeLLL.booleanValue;
    }
}
