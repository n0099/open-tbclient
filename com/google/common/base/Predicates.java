package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.e;
import d.g.c.a.g;
import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.m;
import d.g.c.a.n;
import d.g.c.a.o;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
/* loaded from: classes6.dex */
public final class Predicates {

    /* loaded from: classes6.dex */
    public static class AndPredicate<T> implements o<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final List<? extends o<? super T>> components;

        @Override // d.g.c.a.o
        public boolean apply(T t) {
            for (int i2 = 0; i2 < this.components.size(); i2++) {
                if (!this.components.get(i2).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.h("and", this.components);
        }

        public AndPredicate(List<? extends o<? super T>> list) {
            this.components = list;
        }
    }

    /* loaded from: classes6.dex */
    public static class CompositionPredicate<A, B> implements o<A>, Serializable {
        public static final long serialVersionUID = 0;

        /* renamed from: f  reason: collision with root package name */
        public final g<A, ? extends B> f30890f;
        public final o<B> p;

        @Override // d.g.c.a.o
        public boolean apply(A a2) {
            return this.p.apply(this.f30890f.apply(a2));
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof CompositionPredicate) {
                CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
                return this.f30890f.equals(compositionPredicate.f30890f) && this.p.equals(compositionPredicate.p);
            }
            return false;
        }

        public int hashCode() {
            return this.f30890f.hashCode() ^ this.p.hashCode();
        }

        public String toString() {
            return this.p + "(" + this.f30890f + SmallTailInfo.EMOTION_SUFFIX;
        }

        public CompositionPredicate(o<B> oVar, g<A, ? extends B> gVar) {
            n.p(oVar);
            this.p = oVar;
            n.p(gVar);
            this.f30890f = gVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        public static final long serialVersionUID = 0;

        public ContainsPatternFromStringPredicate(String str) {
            super(m.a(str));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public static class ContainsPatternPredicate implements o<CharSequence>, Serializable {
        public static final long serialVersionUID = 0;
        public final e pattern;

        public ContainsPatternPredicate(e eVar) {
            n.p(eVar);
            this.pattern = eVar;
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof ContainsPatternPredicate) {
                ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
                return k.a(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) && this.pattern.flags() == containsPatternPredicate.pattern.flags();
            }
            return false;
        }

        public int hashCode() {
            return k.b(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        public String toString() {
            j.b b2 = j.b(this.pattern);
            b2.d("pattern", this.pattern.pattern());
            b2.b("pattern.flags", this.pattern.flags());
            String bVar = b2.toString();
            return "Predicates.contains(" + bVar + SmallTailInfo.EMOTION_SUFFIX;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.o
        public boolean apply(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).a();
        }
    }

    /* loaded from: classes6.dex */
    public static class InPredicate<T> implements o<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final Collection<?> target;

        @Override // d.g.c.a.o
        public boolean apply(T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + SmallTailInfo.EMOTION_SUFFIX;
        }

        public InPredicate(Collection<?> collection) {
            n.p(collection);
            this.target = collection;
        }
    }

    /* loaded from: classes6.dex */
    public static class InstanceOfPredicate implements o<Object>, Serializable {
        public static final long serialVersionUID = 0;
        public final Class<?> clazz;

        @Override // d.g.c.a.o
        public boolean apply(Object obj) {
            return this.clazz.isInstance(obj);
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.clazz == ((InstanceOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + SmallTailInfo.EMOTION_SUFFIX;
        }

        public InstanceOfPredicate(Class<?> cls) {
            n.p(cls);
            this.clazz = cls;
        }
    }

    /* loaded from: classes6.dex */
    public static class IsEqualToPredicate<T> implements o<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final T target;

        @Override // d.g.c.a.o
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + SmallTailInfo.EMOTION_SUFFIX;
        }

        public IsEqualToPredicate(T t) {
            this.target = t;
        }
    }

    /* loaded from: classes6.dex */
    public static class NotPredicate<T> implements o<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final o<T> predicate;

        public NotPredicate(o<T> oVar) {
            n.p(oVar);
            this.predicate = oVar;
        }

        @Override // d.g.c.a.o
        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public enum ObjectPredicate implements o<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicates.ObjectPredicate, d.g.c.a.o
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicates.ObjectPredicate, d.g.c.a.o
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicates.ObjectPredicate, d.g.c.a.o
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicates.ObjectPredicate, d.g.c.a.o
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        @Override // d.g.c.a.o
        public abstract /* synthetic */ boolean apply(T t);

        public <T> o<T> withNarrowedType() {
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static class OrPredicate<T> implements o<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final List<? extends o<? super T>> components;

        @Override // d.g.c.a.o
        public boolean apply(T t) {
            for (int i2 = 0; i2 < this.components.size(); i2++) {
                if (this.components.get(i2).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.h("or", this.components);
        }

        public OrPredicate(List<? extends o<? super T>> list) {
            this.components = list;
        }
    }

    /* loaded from: classes6.dex */
    public static class SubtypeOfPredicate implements o<Class<?>>, Serializable {
        public static final long serialVersionUID = 0;
        public final Class<?> clazz;

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.clazz == ((SubtypeOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + SmallTailInfo.EMOTION_SUFFIX;
        }

        public SubtypeOfPredicate(Class<?> cls) {
            n.p(cls);
            this.clazz = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.o
        public boolean apply(Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }
    }

    public static <T> o<T> b() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <A, B> o<A> c(o<B> oVar, g<A, ? extends B> gVar) {
        return new CompositionPredicate(oVar, gVar);
    }

    public static <T> o<T> d(T t) {
        return t == null ? f() : new IsEqualToPredicate(t);
    }

    public static <T> o<T> e(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <T> o<T> f() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> o<T> g(o<T> oVar) {
        return new NotPredicate(oVar);
    }

    public static String h(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
