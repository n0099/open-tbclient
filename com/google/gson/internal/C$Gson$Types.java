package com.google.gson.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
/* renamed from: com.google.gson.internal.$Gson$Types  reason: invalid class name */
/* loaded from: classes7.dex */
public final class C$Gson$Types {
    public static /* synthetic */ Interceptable $ic;
    public static final Type[] EMPTY_TYPE_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* loaded from: classes7.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.componentType = C$Gson$Types.canonicalize(type);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.componentType;
            }
            return (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.componentType.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return C$Gson$Types.typeToString(this.componentType) + "[]";
            }
            return (String) invokeV.objValue;
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    /* loaded from: classes7.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type ownerType;
        public final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Type canonicalize;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type, type2, typeArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z2 = true;
                if (!Modifier.isStatic(cls.getModifiers()) && cls.getEnclosingClass() != null) {
                    z = false;
                } else {
                    z = true;
                }
                if (type == null && !z) {
                    z2 = false;
                }
                C$Gson$Preconditions.checkArgument(z2);
            }
            if (type == null) {
                canonicalize = null;
            } else {
                canonicalize = C$Gson$Types.canonicalize(type);
            }
            this.ownerType = canonicalize;
            this.rawType = C$Gson$Types.canonicalize(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i3 = 0; i3 < length; i3++) {
                C$Gson$Preconditions.checkNotNull(this.typeArguments[i3]);
                C$Gson$Types.checkNotPrimitive(this.typeArguments[i3]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i3] = C$Gson$Types.canonicalize(typeArr3[i3]);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (Type[]) this.typeArguments.clone();
            }
            return (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.ownerType;
            }
            return (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.rawType;
            }
            return (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int length = this.typeArguments.length;
                if (length == 0) {
                    return C$Gson$Types.typeToString(this.rawType);
                }
                StringBuilder sb = new StringBuilder((length + 1) * 30);
                sb.append(C$Gson$Types.typeToString(this.rawType));
                sb.append("<");
                sb.append(C$Gson$Types.typeToString(this.typeArguments[0]));
                for (int i = 1; i < length; i++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(C$Gson$Types.typeToString(this.typeArguments[i]));
                }
                sb.append(">");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    /* loaded from: classes7.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type lowerBound;
        public final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeArr, typeArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (typeArr2.length <= 1) {
                z = true;
            } else {
                z = false;
            }
            C$Gson$Preconditions.checkArgument(z);
            if (typeArr.length == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            C$Gson$Preconditions.checkArgument(z2);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.checkNotPrimitive(typeArr2[0]);
                C$Gson$Preconditions.checkArgument(typeArr[0] == Object.class);
                this.lowerBound = C$Gson$Types.canonicalize(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            C$Gson$Preconditions.checkNotNull(typeArr[0]);
            C$Gson$Types.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(typeArr[0]);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Type type = this.lowerBound;
                return type != null ? new Type[]{type} : C$Gson$Types.EMPTY_TYPE_ARRAY;
            }
            return (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Type[]{this.upperBound} : (Type[]) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Type type = this.lowerBound;
                if (type != null) {
                    i = type.hashCode() + 31;
                } else {
                    i = 1;
                }
                return i ^ (this.upperBound.hashCode() + 31);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.lowerBound != null) {
                    return "? super " + C$Gson$Types.typeToString(this.lowerBound);
                } else if (this.upperBound == Object.class) {
                    return "?";
                } else {
                    return "? extends " + C$Gson$Types.typeToString(this.upperBound);
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448616385, "Lcom/google/gson/internal/$Gson$Types;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448616385, "Lcom/google/gson/internal/$Gson$Types;");
                return;
            }
        }
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    public C$Gson$Types() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, type)) == null) {
            return new GenericArrayTypeImpl(type);
        }
        return (GenericArrayType) invokeL.objValue;
    }

    public static void checkNotPrimitive(Type type) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, type) == null) {
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                z = false;
            } else {
                z = true;
            }
            C$Gson$Preconditions.checkArgument(z);
        }
    }

    public static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, typeVariable)) == null) {
            Object genericDeclaration = typeVariable.getGenericDeclaration();
            if (genericDeclaration instanceof Class) {
                return (Class) genericDeclaration;
            }
            return null;
        }
        return (Class) invokeL.objValue;
    }

    public static Type getArrayComponentType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, type)) == null) {
            if (type instanceof GenericArrayType) {
                return ((GenericArrayType) type).getGenericComponentType();
            }
            return ((Class) type).getComponentType();
        }
        return (Type) invokeL.objValue;
    }

    public static int hashCodeOrZero(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, obj)) == null) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static WildcardType subtypeOf(Type type) {
        InterceptResult invokeL;
        Type[] typeArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, type)) == null) {
            if (type instanceof WildcardType) {
                typeArr = ((WildcardType) type).getUpperBounds();
            } else {
                typeArr = new Type[]{type};
            }
            return new WildcardTypeImpl(typeArr, EMPTY_TYPE_ARRAY);
        }
        return (WildcardType) invokeL.objValue;
    }

    public static String typeToString(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, type)) == null) {
            if (type instanceof Class) {
                return ((Class) type).getName();
            }
            return type.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Type canonicalize(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, type)) == null) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    return new GenericArrayTypeImpl(canonicalize(cls.getComponentType()));
                }
                return cls;
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
            } else if (type instanceof GenericArrayType) {
                return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
            } else {
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
                }
                return type;
            }
        }
        return (Type) invokeL.objValue;
    }

    public static Class<?> getRawType(Type type) {
        InterceptResult invokeL;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, type)) == null) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                C$Gson$Preconditions.checkArgument(rawType instanceof Class);
                return (Class) rawType;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    return getRawType(((WildcardType) type).getUpperBounds()[0]);
                }
                if (type == null) {
                    name = StringUtil.NULL_STRING;
                } else {
                    name = type.getClass().getName();
                }
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
            }
        }
        return (Class) invokeL.objValue;
    }

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, obj2)) == null) {
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, objArr, obj)) == null) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
            }
            throw new NoSuchElementException();
        }
        return invokeLL.intValue;
    }

    public static boolean equals(Type type, Type type2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, type, type2)) == null) {
            if (type == type2) {
                return true;
            }
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                if (equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                    return true;
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            } else if (type instanceof WildcardType) {
                if (!(type2 instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                    return true;
                }
                return false;
            } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, type, cls)) == null) {
            Type supertype = getSupertype(type, cls, Collection.class);
            if (supertype instanceof WildcardType) {
                supertype = ((WildcardType) supertype).getUpperBounds()[0];
            }
            if (supertype instanceof ParameterizedType) {
                return ((ParameterizedType) supertype).getActualTypeArguments()[0];
            }
            return Object.class;
        }
        return (Type) invokeLL.objValue;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, type, cls)) == null) {
            if (type == Properties.class) {
                return new Type[]{String.class, String.class};
            }
            Type supertype = getSupertype(type, cls, Map.class);
            return supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        return (Type[]) invokeLL.objValue;
    }

    public static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, type, cls, cls2)) == null) {
            if (cls2 == cls) {
                return type;
            }
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        return getGenericSupertype(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return (Type) invokeLLL.objValue;
    }

    public static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, type, cls, cls2)) == null) {
            if (type instanceof WildcardType) {
                type = ((WildcardType) type).getUpperBounds()[0];
            }
            C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
            return resolve(type, cls, getGenericSupertype(type, cls, cls2));
        }
        return (Type) invokeLLL.objValue;
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, type, type2, typeArr)) == null) {
            return new ParameterizedTypeImpl(type, type2, typeArr);
        }
        return (ParameterizedType) invokeLLL.objValue;
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, type, cls, type2)) == null) {
            return resolve(type, cls, type2, new HashSet());
        }
        return (Type) invokeLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0004 */
    public static Type resolve(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        boolean z;
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65554, null, type, cls, type2, collection)) == null) {
            while (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                if (collection.contains(typeVariable)) {
                    return type2;
                }
                collection.add(typeVariable);
                type2 = resolveTypeVariable(type, cls, typeVariable);
                if (type2 == typeVariable) {
                    return type2;
                }
            }
            if (type2 instanceof Class) {
                Class cls2 = (Class) type2;
                if (cls2.isArray()) {
                    Class<?> componentType = cls2.getComponentType();
                    Type resolve = resolve(type, cls, componentType, collection);
                    if (componentType != resolve) {
                        return arrayOf(resolve);
                    }
                    return cls2;
                }
            }
            if (type2 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type2;
                Type genericComponentType = genericArrayType.getGenericComponentType();
                Type resolve2 = resolve(type, cls, genericComponentType, collection);
                if (genericComponentType != resolve2) {
                    return arrayOf(resolve2);
                }
                return genericArrayType;
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type resolve3 = resolve(type, cls, ownerType, collection);
                if (resolve3 != ownerType) {
                    z = true;
                } else {
                    z = false;
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                for (int i = 0; i < length; i++) {
                    Type resolve4 = resolve(type, cls, actualTypeArguments[i], collection);
                    if (resolve4 != actualTypeArguments[i]) {
                        if (!z) {
                            actualTypeArguments = (Type[]) actualTypeArguments.clone();
                            z = true;
                        }
                        actualTypeArguments[i] = resolve4;
                    }
                }
                if (z) {
                    return newParameterizedTypeWithOwner(resolve3, parameterizedType.getRawType(), actualTypeArguments);
                }
                return parameterizedType;
            }
            boolean z2 = type2 instanceof WildcardType;
            WildcardType wildcardType = type2;
            if (z2) {
                WildcardType wildcardType2 = (WildcardType) type2;
                Type[] lowerBounds = wildcardType2.getLowerBounds();
                Type[] upperBounds = wildcardType2.getUpperBounds();
                if (lowerBounds.length == 1) {
                    Type resolve5 = resolve(type, cls, lowerBounds[0], collection);
                    wildcardType = wildcardType2;
                    if (resolve5 != lowerBounds[0]) {
                        return supertypeOf(resolve5);
                    }
                } else {
                    wildcardType = wildcardType2;
                    if (upperBounds.length == 1) {
                        Type resolve6 = resolve(type, cls, upperBounds[0], collection);
                        wildcardType = wildcardType2;
                        if (resolve6 != upperBounds[0]) {
                            return subtypeOf(resolve6);
                        }
                    }
                }
            }
            return wildcardType;
        }
        return (Type) invokeLLLL.objValue;
    }

    public static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, type, cls, typeVariable)) == null) {
            Class<?> declaringClassOf = declaringClassOf(typeVariable);
            if (declaringClassOf == null) {
                return typeVariable;
            }
            Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
            if (genericSupertype instanceof ParameterizedType) {
                return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
            }
            return typeVariable;
        }
        return (Type) invokeLLL.objValue;
    }

    public static WildcardType supertypeOf(Type type) {
        InterceptResult invokeL;
        Type[] typeArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, type)) == null) {
            if (type instanceof WildcardType) {
                typeArr = ((WildcardType) type).getLowerBounds();
            } else {
                typeArr = new Type[]{type};
            }
            return new WildcardTypeImpl(new Type[]{Object.class}, typeArr);
        }
        return (WildcardType) invokeL.objValue;
    }
}
