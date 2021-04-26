package com.google.common.collect;

import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final NaturalOrdering INSTANCE = new NaturalOrdering();
    public static final long serialVersionUID = 0;

    /* renamed from: e  reason: collision with root package name */
    public transient Ordering<Comparable> f32033e;

    /* renamed from: f  reason: collision with root package name */
    public transient Ordering<Comparable> f32034f;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = (Ordering<S>) this.f32033e;
        if (ordering == null) {
            Ordering<S> nullsFirst = super.nullsFirst();
            this.f32033e = nullsFirst;
            return nullsFirst;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = (Ordering<S>) this.f32034f;
        if (ordering == null) {
            Ordering<S> nullsLast = super.nullsLast();
            this.f32034f = nullsLast;
            return nullsLast;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        n.p(comparable);
        n.p(comparable2);
        return comparable.compareTo(comparable2);
    }
}
