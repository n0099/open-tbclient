package com.google.common.reflect;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Types;
import d.g.c.a.i;
import d.g.c.a.n;
import d.g.c.a.o;
import d.g.c.c.a0;
import d.g.c.c.c1;
import d.g.c.c.q;
import d.g.c.h.b;
import d.g.c.h.f;
import d.g.c.h.g;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class TypeToken<T> extends d.g.c.h.d<T> implements Serializable {
    public static final long serialVersionUID = 3637540370352322684L;
    public transient d.g.c.h.f covariantTypeResolver;
    public transient d.g.c.h.f invariantTypeResolver;
    public final Type runtimeType;

    /* loaded from: classes6.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        public static final long serialVersionUID = 0;

        /* renamed from: e  reason: collision with root package name */
        public transient ImmutableSet<TypeToken<? super T>> f31133e;

        public ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.f31143b.a().c(TypeToken.this.getRawTypes()));
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.reflect.TypeToken.TypeSet, d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f31133e;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> f2 = q.d(f.f31142a.a().d(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
                this.f31133e = f2;
                return f2;
            }
            return immutableSet;
        }
    }

    /* loaded from: classes6.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        public static final long serialVersionUID = 0;

        public SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* loaded from: classes6.dex */
    public enum TypeFilter implements o<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.TypeFilter, d.g.c.a.o
            public boolean apply(TypeToken<?> typeToken) {
                return ((typeToken.runtimeType instanceof TypeVariable) || (typeToken.runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.TypeFilter, d.g.c.a.o
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        @Override // d.g.c.a.o
        public abstract /* synthetic */ boolean apply(T t);

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends b.C1840b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // d.g.c.h.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // d.g.c.h.a
        public String toString() {
            return a() + "." + super.toString();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends b.a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // d.g.c.h.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // d.g.c.h.b.a
        public Type[] b() {
            d.g.c.h.f invariantTypeResolver = TypeToken.this.getInvariantTypeResolver();
            Type[] b2 = super.b();
            invariantTypeResolver.l(b2);
            return b2;
        }

        @Override // d.g.c.h.a
        public String toString() {
            return a() + "(" + i.g(StringUtil.ARRAY_ELEMENT_SEPARATOR).e(b()) + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends g {
        public c() {
        }

        @Override // d.g.c.h.g
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // d.g.c.h.g
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // d.g.c.h.g
        public void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // d.g.c.h.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* loaded from: classes6.dex */
    public class d extends g {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f31139b;

        public d(TypeToken typeToken, ImmutableSet.a aVar) {
            this.f31139b = aVar;
        }

        @Override // d.g.c.h.g
        public void b(Class<?> cls) {
            this.f31139b.a(cls);
        }

        @Override // d.g.c.h.g
        public void c(GenericArrayType genericArrayType) {
            this.f31139b.a(Types.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // d.g.c.h.g
        public void d(ParameterizedType parameterizedType) {
            this.f31139b.a((Class) parameterizedType.getRawType());
        }

        @Override // d.g.c.h.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // d.g.c.h.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final Type[] f31140a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31141b;

        public e(Type[] typeArr, boolean z) {
            this.f31140a = typeArr;
            this.f31141b = z;
        }

        public boolean a(Type type) {
            for (Type type2 : this.f31140a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.f31141b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f31141b;
        }

        public boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.f31140a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z = this.f31141b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f31141b;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class f<K> {

        /* renamed from: a  reason: collision with root package name */
        public static final f<TypeToken<?>> f31142a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final f<Class<?>> f31143b = new b();

        /* loaded from: classes6.dex */
        public static class a extends f<TypeToken<?>> {
            public a() {
                super(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends f<Class<?>> {
            public b() {
                super(null);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.f
            public /* bridge */ /* synthetic */ Class f(Class<?> cls) {
                Class<?> cls2 = cls;
                j(cls2);
                return cls2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            public Class<?> j(Class<?> cls) {
                return cls;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* loaded from: classes6.dex */
        public class c extends e<K> {
            public c(f fVar, f fVar2) {
                super(fVar2);
            }

            @Override // com.google.common.reflect.TypeToken.f
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.a builder = ImmutableList.builder();
                for (K k : iterable) {
                    if (!f(k).isInterface()) {
                        builder.h(k);
                    }
                }
                return super.c(builder.j());
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Iterable<? extends K> e(K k) {
                return ImmutableSet.of();
            }
        }

        /* loaded from: classes6.dex */
        public static class d extends Ordering<K> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Comparator f31144e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f31145f;

            public d(Comparator comparator, Map map) {
                this.f31144e = comparator;
                this.f31145f = map;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Comparator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k, K k2) {
                return this.f31144e.compare(this.f31145f.get(k), this.f31145f.get(k2));
            }
        }

        /* loaded from: classes6.dex */
        public static class e<K> extends f<K> {

            /* renamed from: c  reason: collision with root package name */
            public final f<K> f31146c;

            public e(f<K> fVar) {
                super(null);
                this.f31146c = fVar;
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Class<?> f(K k) {
                return this.f31146c.f(k);
            }

            @Override // com.google.common.reflect.TypeToken.f
            public K g(K k) {
                return this.f31146c.g(k);
            }
        }

        public f() {
        }

        public static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new d(comparator, map).immutableSortedCopy(map.keySet());
        }

        public final f<K> a() {
            return new c(this, this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        public final int b(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k).isInterface();
            int i = isInterface;
            for (K k2 : e(k)) {
                i = Math.max(i, b(k2, map));
            }
            K g2 = g(k);
            int i2 = i;
            if (g2 != null) {
                i2 = Math.max(i, b(g2, map));
            }
            int i3 = i2 + 1;
            map.put(k, Integer.valueOf(i3));
            return i3;
        }

        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap p = Maps.p();
            for (K k : iterable) {
                b(k, p);
            }
            return h(p, Ordering.natural().reverse());
        }

        public final ImmutableList<K> d(K k) {
            return c(ImmutableList.of(k));
        }

        public abstract Iterable<? extends K> e(K k);

        public abstract Class<?> f(K k);

        public abstract K g(K k);

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    public static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.h(of);
            }
        }
        return builder.j();
    }

    public static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return canonicalizeWildcardType(typeVariable, (WildcardType) type);
        }
        return canonicalizeWildcardsInType(type);
    }

    public static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] upperBounds;
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    public static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            actualTypeArguments[i] = canonicalizeTypeArg(typeParameters[i], actualTypeArguments[i]);
        }
        return Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    public static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.k(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    public static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? super ?> */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        n.s(componentType, "%s isn't a super type of %s", cls, this);
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(cls.getComponentType()).runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.g.c.h.f getCovariantTypeResolver() {
        d.g.c.h.f fVar = this.covariantTypeResolver;
        if (fVar == null) {
            d.g.c.h.f d2 = d.g.c.h.f.d(this.runtimeType);
            this.covariantTypeResolver = d2;
            return d2;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.g.c.h.f getInvariantTypeResolver() {
        d.g.c.h.f fVar = this.invariantTypeResolver;
        if (fVar == null) {
            d.g.c.h.f f2 = d.g.c.h.f.f(this.runtimeType);
            this.invariantTypeResolver = f2;
            return f2;
        }
        return fVar;
    }

    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a builder = ImmutableSet.builder();
        new d(this, builder).a(this.runtimeType);
        return builder.l();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (type instanceof WildcardType) {
            WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
            return every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
        }
        return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (someRawTypeIsSubclassOf(rawType)) {
            TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < typeParameters.length; i++) {
                if (!of(getCovariantTypeResolver().j(typeParameters[i])).is(actualTypeArguments[i], typeParameters[i])) {
                    return false;
                }
            }
            return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
        }
        return false;
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isWrapper() {
        return d.g.c.g.a.b().contains(this.runtimeType);
    }

    public static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> of = of(getCovariantTypeResolver().j(type));
        of.covariantTypeResolver = this.covariantTypeResolver;
        of.invariantTypeResolver = this.invariantTypeResolver;
        return of;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if (!(this.runtimeType instanceof Class) || (cls.getTypeParameters().length != 0 && getRawType().getTypeParameters().length == 0)) {
            TypeToken genericType = toGenericType(cls);
            return new d.g.c.h.f().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
        }
        return cls;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        c1<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.k(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
            return of((Class) cls);
        }
        return (TypeToken<? extends T>) of(Types.n(type, cls, typeParameters));
    }

    public final d.g.c.h.b<T, T> constructor(Constructor<?> constructor) {
        n.l(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type j = Types.j(this.runtimeType);
        if (j == null) {
            return null;
        }
        return of(j);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.h(resolveSupertype(type2));
        }
        return builder.j();
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        n.k(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        n.l(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        n.l(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        n.l(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            return getArraySupertype(cls);
        }
        return (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final d.g.c.h.b<T, Object> method(Method method) {
        n.l(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        n.p(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.t(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(d.g.c.g.a.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(d.g.c.h.e<X> eVar, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new d.g.c.h.f().o(ImmutableMap.of(new f.d(eVar.f67043a), typeToken.runtimeType)).j(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(d.g.c.g.a.d((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new d.g.c.h.f().j(this.runtimeType));
    }

    /* loaded from: classes6.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        public static final long serialVersionUID = 0;

        /* renamed from: e  reason: collision with root package name */
        public final transient TypeToken<T>.TypeSet f31134e;

        /* renamed from: f  reason: collision with root package name */
        public transient ImmutableSet<TypeToken<? super T>> f31135f;

        /* loaded from: classes6.dex */
        public class a implements o<Class<?>> {
            public a(InterfaceSet interfaceSet) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.a.o
            /* renamed from: a */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }
        }

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.f31134e = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return q.d(f.f31143b.c(TypeToken.this.getRawTypes())).c(new a(this)).f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.reflect.TypeToken.TypeSet, d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f31135f;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> f2 = q.d(this.f31134e).c(TypeFilter.INTERFACE_ONLY).f();
                this.f31135f = f2;
                return f2;
            }
            return immutableSet;
        }
    }

    /* loaded from: classes6.dex */
    public class TypeSet extends a0<TypeToken<? super T>> implements Serializable {
        public static final long serialVersionUID = 0;
        public transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.f31143b.c(TypeToken.this.getRawTypes()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> f2 = q.d(f.f31142a.d(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
                this.types = f2;
                return f2;
            }
            return immutableSet;
        }
    }

    public TypeToken() {
        Type capture = capture();
        this.runtimeType = capture;
        n.A(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        n.p(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        } else if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        } else {
            if (type instanceof Class) {
                return someRawTypeIsSubclassOf((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return isSubtypeOfParameterizedType((ParameterizedType) type);
            }
            if (type instanceof GenericArrayType) {
                return isSubtypeOfArrayType((GenericArrayType) type);
            }
            return false;
        }
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = d.g.c.h.f.d(cls).j(capture);
        }
    }

    public final <X> TypeToken<T> where(d.g.c.h.e<X> eVar, Class<X> cls) {
        return where(eVar, of((Class) cls));
    }

    public TypeToken(Type type) {
        n.p(type);
        this.runtimeType = type;
    }
}
