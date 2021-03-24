package com.bytedance.sdk.openadsdk.preload.a.b;

import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Type[] f29995a = new Type[0];

    /* loaded from: classes6.dex */
    public static final class a implements Serializable, GenericArrayType {

        /* renamed from: a  reason: collision with root package name */
        public final Type f29996a;

        public a(Type type) {
            this.f29996a = b.d(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.a((Type) this, (Type) ((GenericArrayType) obj));
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f29996a;
        }

        public int hashCode() {
            return this.f29996a.hashCode();
        }

        public String toString() {
            return b.f(this.f29996a) + "[]";
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0330b implements Serializable, ParameterizedType {

        /* renamed from: a  reason: collision with root package name */
        public final Type f29997a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f29998b;

        /* renamed from: c  reason: collision with root package name */
        public final Type[] f29999c;

        public C0330b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(z);
            }
            this.f29997a = type == null ? null : b.d(type);
            this.f29998b = b.d(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f29999c = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(this.f29999c[i]);
                b.h(this.f29999c[i]);
                Type[] typeArr3 = this.f29999c;
                typeArr3[i] = b.d(typeArr3[i]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.a((Type) this, (Type) ((ParameterizedType) obj));
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f29999c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f29997a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f29998b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f29999c) ^ this.f29998b.hashCode()) ^ b.a((Object) this.f29997a);
        }

        public String toString() {
            int length = this.f29999c.length;
            if (length == 0) {
                return b.f(this.f29998b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(b.f(this.f29998b));
            sb.append("<");
            sb.append(b.f(this.f29999c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(b.f(this.f29999c[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements Serializable, WildcardType {

        /* renamed from: a  reason: collision with root package name */
        public final Type f30001a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f30002b;

        public c(Type[] typeArr, Type[] typeArr2) {
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr2.length <= 1);
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr2[0]);
                b.h(typeArr2[0]);
                com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr[0] == Object.class);
                this.f30002b = b.d(typeArr2[0]);
                this.f30001a = Object.class;
                return;
            }
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(typeArr[0]);
            b.h(typeArr[0]);
            this.f30002b = null;
            this.f30001a = b.d(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.a((Type) this, (Type) ((WildcardType) obj));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f30002b;
            return type != null ? new Type[]{type} : b.f29995a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f30001a};
        }

        public int hashCode() {
            Type type = this.f30002b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f30001a.hashCode() + 31);
        }

        public String toString() {
            if (this.f30002b != null) {
                return "? super " + b.f(this.f30002b);
            } else if (this.f30001a == Object.class) {
                return "?";
            } else {
                return "? extends " + b.f(this.f30001a);
            }
        }
    }

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new C0330b(type, type2, typeArr);
    }

    public static WildcardType b(Type type) {
        return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f29995a);
    }

    public static WildcardType c(Type type) {
        return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(d(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0330b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
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

    public static Class<?> e(Type type) {
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

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type g(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static void h(Type type) {
        com.bytedance.sdk.openadsdk.preload.a.b.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Type type, Type type2) {
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

    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        com.bytedance.sdk.openadsdk.preload.a.b.a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b2 = b(type, cls, Map.class);
        return b2 instanceof ParameterizedType ? ((ParameterizedType) b2).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
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
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
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

    public static Type a(Type type, Class<?> cls) {
        Type b2 = b(type, cls, Collection.class);
        if (b2 instanceof WildcardType) {
            b2 = ((WildcardType) b2).getUpperBounds()[0];
        }
        if (b2 instanceof ParameterizedType) {
            return ((ParameterizedType) b2).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type type3;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            if (collection.contains(typeVariable)) {
                return type3;
            }
            collection.add(typeVariable);
            Type a2 = a(type, cls, (TypeVariable<?>) typeVariable);
            type3 = a2;
            if (a2 == typeVariable) {
                return a2;
            }
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type a3 = a(type, cls, componentType, collection);
                return componentType == a3 ? cls2 : a(a3);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type a4 = a(type, cls, genericComponentType, collection);
            return genericComponentType == a4 ? genericArrayType : a(a4);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type a5 = a(type, cls, ownerType, collection);
            boolean z = a5 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i = 0; i < length; i++) {
                Type a6 = a(type, cls, actualTypeArguments[i], collection);
                if (a6 != actualTypeArguments[i]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i] = a6;
                }
            }
            return z ? a(a5, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type3 instanceof WildcardType;
        WildcardType wildcardType = type3;
        if (z2) {
            WildcardType wildcardType2 = (WildcardType) type3;
            Type[] lowerBounds = wildcardType2.getLowerBounds();
            Type[] upperBounds = wildcardType2.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type a7 = a(type, cls, lowerBounds[0], collection);
                wildcardType = wildcardType2;
                if (a7 != lowerBounds[0]) {
                    return c(a7);
                }
            } else {
                wildcardType = wildcardType2;
                if (upperBounds.length == 1) {
                    Type a8 = a(type, cls, upperBounds[0], collection);
                    wildcardType = wildcardType2;
                    if (a8 != upperBounds[0]) {
                        return b(a8);
                    }
                }
            }
        }
        return wildcardType;
    }

    public static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a2 = a(typeVariable);
        if (a2 == null) {
            return typeVariable;
        }
        Type a3 = a(type, cls, a2);
        if (a3 instanceof ParameterizedType) {
            return ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)];
        }
        return typeVariable;
    }

    public static int a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }
}
