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
/* loaded from: classes5.dex */
public final class C$Gson$Types {
    public static /* synthetic */ Interceptable $ic;
    public static final Type[] EMPTY_TYPE_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* loaded from: classes5.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj) : invokeL.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.componentType.hashCode() : invokeV.intValue;
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
    /* loaded from: classes5.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type ownerType;
        public final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
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
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                C$Gson$Preconditions.checkArgument(z);
            }
            this.ownerType = type == null ? null : C$Gson$Types.canonicalize(type);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj) : invokeL.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ownerType : (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rawType : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType) : invokeV.intValue;
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
    /* loaded from: classes5.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type lowerBound;
        public final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
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
            C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            C$Gson$Preconditions.checkArgument(typeArr.length == 1);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj) : invokeL.booleanValue;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Type type = this.lowerBound;
                return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, type)) == null) ? new GenericArrayTypeImpl(type) : (GenericArrayType) invokeL.objValue;
    }

    public static Type canonicalize(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, type)) == null) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(canonicalize(cls.getComponentType())) : cls;
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

    public static void checkNotPrimitive(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, type) == null) {
            C$Gson$Preconditions.checkArgument(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
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

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
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
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                    return equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (type2 instanceof GenericArrayType) {
                    return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
                }
                return false;
            } else if (type instanceof WildcardType) {
                if (type2 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    WildcardType wildcardType2 = (WildcardType) type2;
                    return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
                }
                return false;
            } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
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

    public static Class<?> getRawType(Type type) {
        InterceptResult invokeL;
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
                String name = type == null ? StringUtil.NULL_STRING : type.getClass().getName();
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
            }
        }
        return (Class) invokeL.objValue;
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

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, type, type2, typeArr)) == null) ? new ParameterizedTypeImpl(type, type2, typeArr) : (ParameterizedType) invokeLLL.objValue;
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, type, cls, type2)) == null) ? resolve(type, cls, type2, new HashSet()) : (Type) invokeLLL.objValue;
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
            return genericSupertype instanceof ParameterizedType ? ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)] : typeVariable;
        }
        return (Type) invokeLLL.objValue;
    }

    public static WildcardType subtypeOf(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, type)) == null) {
            return new WildcardTypeImpl(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, EMPTY_TYPE_ARRAY);
        }
        return (WildcardType) invokeL.objValue;
    }

    public static WildcardType supertypeOf(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, type)) == null) {
            return new WildcardTypeImpl(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
        }
        return (WildcardType) invokeL.objValue;
    }

    public static String typeToString(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, type)) == null) ? type instanceof Class ? ((Class) type).getName() : type.toString() : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0004 */
    public static Type resolve(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
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
                    return componentType == resolve ? cls2 : arrayOf(resolve);
                }
            }
            if (type2 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type2;
                Type genericComponentType = genericArrayType.getGenericComponentType();
                Type resolve2 = resolve(type, cls, genericComponentType, collection);
                return genericComponentType == resolve2 ? genericArrayType : arrayOf(resolve2);
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type resolve3 = resolve(type, cls, ownerType, collection);
                boolean z = resolve3 != ownerType;
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
                return z ? newParameterizedTypeWithOwner(resolve3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
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
}
