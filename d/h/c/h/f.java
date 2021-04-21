package d.h.c.h;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import d.h.c.a.i;
import d.h.c.a.k;
import d.h.c.a.n;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final c f67191a;

    /* loaded from: classes6.dex */
    public static class a extends g {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f67192b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Type f67193c;

        public a(Map map, Type type) {
            this.f67192b = map;
            this.f67193c = type;
        }

        @Override // d.h.c.h.g
        public void b(Class<?> cls) {
            if (this.f67193c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f67193c);
        }

        @Override // d.h.c.h.g
        public void c(GenericArrayType genericArrayType) {
            Type type = this.f67193c;
            if (type instanceof WildcardType) {
                return;
            }
            Type j = Types.j(type);
            n.k(j != null, "%s is not an array type.", this.f67193c);
            f.g(this.f67192b, genericArrayType.getGenericComponentType(), j);
        }

        @Override // d.h.c.h.g
        public void d(ParameterizedType parameterizedType) {
            Type type = this.f67193c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) f.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                f.g(this.f67192b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            n.l(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f67193c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            n.l(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                f.g(this.f67192b, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        }

        @Override // d.h.c.h.g
        public void e(TypeVariable<?> typeVariable) {
            this.f67192b.put(new d(typeVariable), this.f67193c);
        }

        @Override // d.h.c.h.g
        public void f(WildcardType wildcardType) {
            Type type = this.f67193c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                n.l(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f67193c);
                for (int i = 0; i < upperBounds.length; i++) {
                    f.g(this.f67192b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    f.g(this.f67192b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends g {

        /* renamed from: b  reason: collision with root package name */
        public final Map<d, Type> f67194b = Maps.p();

        public static ImmutableMap<d, Type> g(Type type) {
            n.p(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.f67194b);
        }

        @Override // d.h.c.h.g
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // d.h.c.h.g
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            n.w(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new d(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // d.h.c.h.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // d.h.c.h.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(d dVar, Type type) {
            if (this.f67194b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f67194b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f67194b.get(d.c(type2));
            }
            this.f67194b.put(dVar, type);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final TypeVariable<?> f67198a;

        public d(TypeVariable<?> typeVariable) {
            n.p(typeVariable);
            this.f67198a = typeVariable;
        }

        public static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable<?> typeVariable) {
            return this.f67198a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f67198a.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f67198a);
            }
            return false;
        }

        public int hashCode() {
            return k.b(this.f67198a.getGenericDeclaration(), this.f67198a.getName());
        }

        public String toString() {
            return this.f67198a.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: b  reason: collision with root package name */
        public static final e f67199b = new e();

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f67200a;

        /* loaded from: classes6.dex */
        public class a extends e {

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ TypeVariable f67201c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f67201c = typeVariable;
            }

            @Override // d.h.c.h.f.e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f67201c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            n.p(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
                }
                return Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        public TypeVariable<?> b(Type[] typeArr) {
            return Types.l(e.class, "capture#" + this.f67200a.incrementAndGet() + "-of ? extends " + i.f(Typography.amp).e(typeArr), typeArr);
        }

        public final Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final e d(TypeVariable<?> typeVariable) {
            return new a(this, this.f67200a, typeVariable);
        }

        public final e e() {
            return new e(this.f67200a);
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger atomicInteger) {
            this.f67200a = atomicInteger;
        }
    }

    public /* synthetic */ f(c cVar, a aVar) {
        this(cVar);
    }

    public static f d(Type type) {
        return new f().o(b.g(type));
    }

    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    public static f f(Type type) {
        return new f().o(b.g(e.f67199b.a(type)));
    }

    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        return Types.k(j(genericArrayType.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    public Type j(Type type) {
        n.p(type);
        if (type instanceof TypeVariable) {
            return this.f67191a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    public final Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = j(typeArr[i]);
        }
        return typeArr2;
    }

    public Type[] l(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = j(typeArr[i]);
        }
        return typeArr;
    }

    public final WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public f n(Type type, Type type2) {
        HashMap p = Maps.p();
        n.p(type);
        n.p(type2);
        g(p, type, type2);
        return o(p);
    }

    public f o(Map<d, ? extends Type> map) {
        return new f(this.f67191a.c(map));
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final ImmutableMap<d, Type> f67195a;

        /* loaded from: classes6.dex */
        public class a extends c {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TypeVariable f67196b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f67197c;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f67196b = typeVariable;
                this.f67197c = cVar2;
            }

            @Override // d.h.c.h.f.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f67196b.getGenericDeclaration()) ? typeVariable : this.f67197c.b(typeVariable, cVar);
            }
        }

        public c() {
            this.f67195a = ImmutableMap.of();
        }

        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f67195a.get(new d(typeVariable));
            if (type == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 0) {
                    return typeVariable;
                }
                Type[] k = new f(cVar, null).k(bounds);
                return (Types.c.f31245a && Arrays.equals(bounds, k)) ? typeVariable : Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), k);
            }
            return new f(cVar, null).j(type);
        }

        public final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.f(this.f67195a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                n.k(!key.a(value), "Type variable %s bound to itself", key);
                builder.c(key, value);
            }
            return new c(builder.a());
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            this.f67195a = immutableMap;
        }
    }

    public f() {
        this.f67191a = new c();
    }

    public f(c cVar) {
        this.f67191a = cVar;
    }
}
