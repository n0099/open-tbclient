package com.google.common.reflect;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import d.g.c.a.g;
import d.g.c.a.i;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.f0;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class Types {

    /* renamed from: a  reason: collision with root package name */
    public static final g<Type, String> f31584a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final i f31585b = i.g(StringUtil.ARRAY_ELEMENT_SEPARATOR).i(StringUtil.NULL_STRING);

    /* loaded from: classes6.dex */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        public static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* loaded from: classes6.dex */
        public class a<T> {
        }

        /* loaded from: classes6.dex */
        public static class b extends a<String> {
        }

        public static ClassOwnership detectJvmBehavior() {
            ClassOwnership[] values;
            ParameterizedType parameterizedType = (ParameterizedType) b.class.getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        public abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        public static final long serialVersionUID = 0;
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return k.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.t(this.componentType) + "[]";
        }
    }

    /* loaded from: classes6.dex */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                n.p(type);
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
                }
                return type;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.i((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                n.p(type);
                return type;
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        },
        JAVA9 { // from class: com.google.common.reflect.Types.JavaVersion.4
            @Override // com.google.common.reflect.Types.JavaVersion
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA8.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                return JavaVersion.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA8.usedInGenericType(type);
            }
        };
        
        public static final JavaVersion CURRENT;

        /* loaded from: classes6.dex */
        public static class a extends d.g.c.h.d<Map.Entry<String, int[][]>> {
        }

        /* loaded from: classes6.dex */
        public static class b extends d.g.c.h.d<int[]> {
        }

        static {
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new a().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = JAVA8;
                } else {
                    CURRENT = JAVA9;
                }
            } else if (new b().capture() instanceof Class) {
                CURRENT = JAVA7;
            } else {
                CURRENT = JAVA6;
            }
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type type);

        public String typeName(Type type) {
            return Types.t(type);
        }

        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.h(usedInGenericType(type));
            }
            return builder.j();
        }

        public abstract Type usedInGenericType(Type type);

        /* synthetic */ JavaVersion(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableList<Type> argumentsList;
        public final Type ownerType;
        public final Class<?> rawType;

        public ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            n.p(cls);
            n.d(typeArr.length == cls.getTypeParameters().length);
            Types.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) obj;
                return getRawType().equals(parameterizedType.getRawType()) && k.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.s(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null && JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName()) {
                sb.append(JavaVersion.CURRENT.typeName(this.ownerType));
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
            }
            sb.append(this.rawType.getName());
            sb.append(Typography.less);
            sb.append(Types.f31585b.c(f0.n(this.argumentsList, Types.f31584a)));
            sb.append(Typography.greater);
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableList<Type> lowerBounds;
        public final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.g(typeArr, "lower bound for wildcard");
            Types.g(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.s(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.s(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            c1<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(it.next()));
            }
            for (Type type : Types.h(this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.CURRENT.typeName(type));
            }
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements g<Type, String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public String apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends d.g.c.h.g {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f31586b;

        public b(AtomicReference atomicReference) {
            this.f31586b = atomicReference;
        }

        @Override // d.g.c.h.g
        public void b(Class<?> cls) {
            this.f31586b.set(cls.getComponentType());
        }

        @Override // d.g.c.h.g
        public void c(GenericArrayType genericArrayType) {
            this.f31586b.set(genericArrayType.getGenericComponentType());
        }

        @Override // d.g.c.h.g
        public void e(TypeVariable<?> typeVariable) {
            this.f31586b.set(Types.q(typeVariable.getBounds()));
        }

        @Override // d.g.c.h.g
        public void f(WildcardType wildcardType) {
            this.f31586b.set(Types.q(wildcardType.getUpperBounds()));
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<X> {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f31587a = !c.class.getTypeParameters()[0].equals(Types.l(c.class, "X", new Type[0]));
    }

    /* loaded from: classes6.dex */
    public static final class d<D extends GenericDeclaration> {

        /* renamed from: a  reason: collision with root package name */
        public final D f31588a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31589b;

        /* renamed from: c  reason: collision with root package name */
        public final ImmutableList<Type> f31590c;

        public d(D d2, String str, Type[] typeArr) {
            Types.g(typeArr, "bound for type variable");
            n.p(d2);
            this.f31588a = d2;
            n.p(str);
            this.f31589b = str;
            this.f31590c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f31588a;
        }

        public String b() {
            return this.f31589b;
        }

        public boolean equals(Object obj) {
            if (c.f31587a) {
                if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof e)) {
                    d dVar = ((e) Proxy.getInvocationHandler(obj)).f31592e;
                    return this.f31589b.equals(dVar.b()) && this.f31588a.equals(dVar.a()) && this.f31590c.equals(dVar.f31590c);
                }
                return false;
            } else if (obj instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f31589b.equals(typeVariable.getName()) && this.f31588a.equals(typeVariable.getGenericDeclaration());
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.f31588a.hashCode() ^ this.f31589b.hashCode();
        }

        public String toString() {
            return this.f31589b;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements InvocationHandler {

        /* renamed from: f  reason: collision with root package name */
        public static final ImmutableMap<String, Method> f31591f;

        /* renamed from: e  reason: collision with root package name */
        public final d<?> f31592e;

        static {
            Method[] methods;
            ImmutableMap.b builder = ImmutableMap.builder();
            for (Method method : d.class.getMethods()) {
                if (method.getDeclaringClass().equals(d.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.c(method.getName(), method);
                }
            }
            f31591f = builder.a();
        }

        public e(d<?> dVar) {
            this.f31592e = dVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f31591f.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.f31592e, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2.getCause();
                }
            }
            throw new UnsupportedOperationException(name);
        }
    }

    public static void g(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                n.l(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    public static Iterable<Type> h(Iterable<Type> iterable) {
        return f0.d(iterable, Predicates.g(Predicates.d(Object.class)));
    }

    public static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    public static Type j(Type type) {
        n.p(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type k(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            n.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return r(k(lowerBounds[0]));
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            n.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
            return p(k(upperBounds[0]));
        }
        return JavaVersion.CURRENT.newArrayType(type);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> l(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d2, str, typeArr);
    }

    public static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static ParameterizedType n(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        n.p(typeArr);
        n.k(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> o(D d2, String str, Type[] typeArr) {
        return (TypeVariable) d.g.c.h.c.a(TypeVariable.class, new e(new d(d2, str, typeArr)));
    }

    public static WildcardType p(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type j = j(type);
            if (j != null) {
                if (j instanceof Class) {
                    Class cls = (Class) j;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(j);
            }
        }
        return null;
    }

    public static WildcardType r(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
