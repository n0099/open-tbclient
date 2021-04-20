package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.a.o;
import java.io.Serializable;
/* loaded from: classes6.dex */
public abstract class Equivalence<T> {

    /* loaded from: classes6.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        public static final Equals INSTANCE = new Equals();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes6.dex */
    public static final class EquivalentToPredicate<T> implements o<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final Equivalence<T> equivalence;
        public final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence, T t) {
            n.p(equivalence);
            this.equivalence = equivalence;
            this.target = t;
        }

        @Override // d.g.c.a.o
        public boolean apply(T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        @Override // d.g.c.a.o
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EquivalentToPredicate) {
                EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
                return this.equivalence.equals(equivalentToPredicate.equivalence) && k.a(this.target, equivalentToPredicate.target);
            }
            return false;
        }

        public int hashCode() {
            return k.b(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Identity extends Equivalence<Object> implements Serializable {
        public static final Identity INSTANCE = new Identity();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class Wrapper<T> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Equivalence<? super T> equivalence;
        public final T reference;

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        /* JADX DEBUG: Type inference failed for r3v4. Raw type applied. Possible types: T, ? super T */
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Wrapper) {
                Wrapper wrapper = (Wrapper) obj;
                if (this.equivalence.equals(wrapper.equivalence)) {
                    return this.equivalence.equivalent((T) this.reference, (T) wrapper.reference);
                }
                return false;
            }
            return false;
        }

        public T get() {
            return this.reference;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        public int hashCode() {
            return this.equivalence.hash((T) this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + SmallTailInfo.EMOTION_SUFFIX;
        }

        public Wrapper(Equivalence<? super T> equivalence, T t) {
            n.p(equivalence);
            this.equivalence = equivalence;
            this.reference = t;
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(T t, T t2);

    public abstract int doHash(T t);

    public final boolean equivalent(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final o<T> equivalentTo(T t) {
        return new EquivalentToPredicate(this, t);
    }

    public final int hash(T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(g<F, ? extends T> gVar) {
        return new FunctionalEquivalence(gVar, this);
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(S s) {
        return new Wrapper<>(s);
    }
}
