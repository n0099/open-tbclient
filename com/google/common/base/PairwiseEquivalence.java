package com.google.common.base;

import d.h.c.a.n;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
    public static final long serialVersionUID = 1;
    public final Equivalence<? super T> elementEquivalence;

    public PairwiseEquivalence(Equivalence<? super T> equivalence) {
        n.p(equivalence);
        this.elementEquivalence = equivalence;
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ boolean doEquivalent(Object obj, Object obj2) {
        return doEquivalent((Iterable) ((Iterable) obj), (Iterable) ((Iterable) obj2));
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ int doHash(Object obj) {
        return doHash((Iterable) ((Iterable) obj));
    }

    public boolean equals(Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it = iterable.iterator();
        Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int doHash(Iterable<T> iterable) {
        int i = 78721;
        for (T t : iterable) {
            i = (i * 24943) + this.elementEquivalence.hash(t);
        }
        return i;
    }
}
