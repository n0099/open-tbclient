package com.google.common.collect;

import java.io.Serializable;
/* loaded from: classes6.dex */
public final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Ordering<? super T> ordering;

    public NullsLastOrdering(Ordering<? super T> ordering) {
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.ordering.compare(t, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsLastOrdering) {
            return this.ordering.equals(((NullsLastOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        return this.ordering + ".nullsLast()";
    }
}
