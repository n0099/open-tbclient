package com.bytedance.sdk.openadsdk.preload.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Type[] f31915a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Serializable, GenericArrayType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Type f31916a;

        public a(Type type) {
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
            this.f31916a = b.d(type);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof GenericArrayType) && b.a((Type) this, (Type) ((GenericArrayType) obj)) : invokeL.booleanValue;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31916a : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31916a.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return b.f(this.f31916a) + "[]";
            }
            return (String) invokeV.objValue;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0361b implements Serializable, ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Type f31917a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f31918b;

        /* renamed from: c  reason: collision with root package name */
        public final Type[] f31919c;

        public C0361b(Type type, Type type2, Type... typeArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type, type2, typeArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(z);
            }
            this.f31917a = type == null ? null : b.d(type);
            this.f31918b = b.d(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f31919c = typeArr2;
            int length = typeArr2.length;
            for (int i4 = 0; i4 < length; i4++) {
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(this.f31919c[i4]);
                b.h(this.f31919c[i4]);
                Type[] typeArr3 = this.f31919c;
                typeArr3[i4] = b.d(typeArr3[i4]);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof ParameterizedType) && b.a((Type) this, (Type) ((ParameterizedType) obj)) : invokeL.booleanValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (Type[]) this.f31919c.clone() : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31917a : (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31918b : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Arrays.hashCode(this.f31919c) ^ this.f31918b.hashCode()) ^ b.a((Object) this.f31917a) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int length = this.f31919c.length;
                if (length == 0) {
                    return b.f(this.f31918b);
                }
                StringBuilder sb = new StringBuilder((length + 1) * 30);
                sb.append(b.f(this.f31918b));
                sb.append("<");
                sb.append(b.f(this.f31919c[0]));
                for (int i2 = 1; i2 < length; i2++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(b.f(this.f31919c[i2]));
                }
                sb.append(">");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Serializable, WildcardType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Type f31921a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f31922b;

        public c(Type[] typeArr, Type[] typeArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeArr, typeArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr2.length <= 1);
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr2[0]);
                b.h(typeArr2[0]);
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr[0] == Object.class);
                this.f31922b = b.d(typeArr2[0]);
                this.f31921a = Object.class;
                return;
            }
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr[0]);
            b.h(typeArr[0]);
            this.f31922b = null;
            this.f31921a = b.d(typeArr[0]);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof WildcardType) && b.a((Type) this, (Type) ((WildcardType) obj)) : invokeL.booleanValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Type type = this.f31922b;
                return type != null ? new Type[]{type} : b.f31915a;
            }
            return (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Type[]{this.f31921a} : (Type[]) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Type type = this.f31922b;
                return (type != null ? type.hashCode() + 31 : 1) ^ (this.f31921a.hashCode() + 31);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f31922b != null) {
                    return "? super " + b.f(this.f31922b);
                } else if (this.f31921a == Object.class) {
                    return "?";
                } else {
                    return "? extends " + b.f(this.f31921a);
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639650671, "Lcom/bytedance/sdk/openadsdk/preload/a/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639650671, "Lcom/bytedance/sdk/openadsdk/preload/a/b/b;");
                return;
            }
        }
        f31915a = new Type[0];
    }

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, type, type2, typeArr)) == null) ? new C0361b(type, type2, typeArr) : (ParameterizedType) invokeLLL.objValue;
    }

    public static WildcardType b(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, type)) == null) {
            return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f31915a);
        }
        return (WildcardType) invokeL.objValue;
    }

    public static WildcardType c(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, type)) == null) {
            return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
        }
        return (WildcardType) invokeL.objValue;
    }

    public static Type d(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, type)) == null) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                return cls.isArray() ? new a(d(cls.getComponentType())) : cls;
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return new C0361b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
            } else if (type instanceof GenericArrayType) {
                return new a(((GenericArrayType) type).getGenericComponentType());
            } else {
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
                }
                return type;
            }
        }
        return (Type) invokeL.objValue;
    }

    public static Class<?> e(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, type)) == null) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(rawType instanceof Class);
                return (Class) rawType;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    return e(((WildcardType) type).getUpperBounds()[0]);
                }
                String name = type == null ? StringUtil.NULL_STRING : type.getClass().getName();
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
            }
        }
        return (Class) invokeL.objValue;
    }

    public static String f(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, type)) == null) ? type instanceof Class ? ((Class) type).getName() : type.toString() : (String) invokeL.objValue;
    }

    public static Type g(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, type)) == null) {
            if (type instanceof GenericArrayType) {
                return ((GenericArrayType) type).getGenericComponentType();
            }
            return ((Class) type).getComponentType();
        }
        return (Type) invokeL.objValue;
    }

    public static void h(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, type) == null) {
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
        }
    }

    public static GenericArrayType a(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, type)) == null) ? new a(type) : (GenericArrayType) invokeL.objValue;
    }

    public static boolean a(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static boolean a(Type type, Type type2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, type, type2)) == null) {
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
                    return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (type2 instanceof GenericArrayType) {
                    return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
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

    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, type, cls, cls2)) == null) {
            if (type instanceof WildcardType) {
                type = ((WildcardType) type).getUpperBounds()[0];
            }
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(cls2.isAssignableFrom(cls));
            return a(type, cls, a(type, cls, cls2));
        }
        return (Type) invokeLLL.objValue;
    }

    public static Type[] b(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, type, cls)) == null) {
            if (type == Properties.class) {
                return new Type[]{String.class, String.class};
            }
            Type b2 = b(type, cls, Map.class);
            return b2 instanceof ParameterizedType ? ((ParameterizedType) b2).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        return (Type[]) invokeLL.objValue;
    }

    public static int a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, type, cls, cls2)) == null) {
            if (cls2 == cls) {
                return type;
            }
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (interfaces[i2] == cls2) {
                        return cls.getGenericInterfaces()[i2];
                    }
                    if (cls2.isAssignableFrom(interfaces[i2])) {
                        return a(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
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
                        return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return (Type) invokeLLL.objValue;
    }

    public static Type a(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, type, cls)) == null) {
            Type b2 = b(type, cls, Collection.class);
            if (b2 instanceof WildcardType) {
                b2 = ((WildcardType) b2).getUpperBounds()[0];
            }
            if (b2 instanceof ParameterizedType) {
                return ((ParameterizedType) b2).getActualTypeArguments()[0];
            }
            return Object.class;
        }
        return (Type) invokeLL.objValue;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, type, cls, type2)) == null) ? a(type, cls, type2, new HashSet()) : (Type) invokeLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0004 */
    public static Type a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, type, cls, type2, collection)) == null) {
            while (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                if (collection.contains(typeVariable)) {
                    return type2;
                }
                collection.add(typeVariable);
                type2 = a(type, cls, (TypeVariable<?>) typeVariable);
                if (type2 == typeVariable) {
                    return type2;
                }
            }
            if (type2 instanceof Class) {
                Class cls2 = (Class) type2;
                if (cls2.isArray()) {
                    Class<?> componentType = cls2.getComponentType();
                    Type a2 = a(type, cls, componentType, collection);
                    return componentType == a2 ? cls2 : a(a2);
                }
            }
            if (type2 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type2;
                Type genericComponentType = genericArrayType.getGenericComponentType();
                Type a3 = a(type, cls, genericComponentType, collection);
                return genericComponentType == a3 ? genericArrayType : a(a3);
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type a4 = a(type, cls, ownerType, collection);
                boolean z = a4 != ownerType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Type a5 = a(type, cls, actualTypeArguments[i2], collection);
                    if (a5 != actualTypeArguments[i2]) {
                        if (!z) {
                            actualTypeArguments = (Type[]) actualTypeArguments.clone();
                            z = true;
                        }
                        actualTypeArguments[i2] = a5;
                    }
                }
                return z ? a(a4, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
            }
            boolean z2 = type2 instanceof WildcardType;
            WildcardType wildcardType = type2;
            if (z2) {
                WildcardType wildcardType2 = (WildcardType) type2;
                Type[] lowerBounds = wildcardType2.getLowerBounds();
                Type[] upperBounds = wildcardType2.getUpperBounds();
                if (lowerBounds.length == 1) {
                    Type a6 = a(type, cls, lowerBounds[0], collection);
                    wildcardType = wildcardType2;
                    if (a6 != lowerBounds[0]) {
                        return c(a6);
                    }
                } else {
                    wildcardType = wildcardType2;
                    if (upperBounds.length == 1) {
                        Type a7 = a(type, cls, upperBounds[0], collection);
                        wildcardType = wildcardType2;
                        if (a7 != upperBounds[0]) {
                            return b(a7);
                        }
                    }
                }
            }
            return wildcardType;
        }
        return (Type) invokeLLLL.objValue;
    }

    public static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, type, cls, typeVariable)) == null) {
            Class<?> a2 = a(typeVariable);
            if (a2 == null) {
                return typeVariable;
            }
            Type a3 = a(type, cls, a2);
            return a3 instanceof ParameterizedType ? ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)] : typeVariable;
        }
        return (Type) invokeLLL.objValue;
    }

    public static int a(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, objArr, obj)) == null) {
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
            }
            throw new NoSuchElementException();
        }
        return invokeLL.intValue;
    }

    public static Class<?> a(TypeVariable<?> typeVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, typeVariable)) == null) {
            Object genericDeclaration = typeVariable.getGenericDeclaration();
            if (genericDeclaration instanceof Class) {
                return (Class) genericDeclaration;
            }
            return null;
        }
        return (Class) invokeL.objValue;
    }
}
