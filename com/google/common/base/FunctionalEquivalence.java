package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.k;
import d.h.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    public static final long serialVersionUID = 0;
    public final g<F, ? extends T> function;
    public final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(g<F, ? extends T> gVar, Equivalence<T> equivalence) {
        n.p(gVar);
        this.function = gVar;
        n.p(equivalence);
        this.resultEquivalence = equivalence;
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f2, F f3) {
        return this.resultEquivalence.equivalent(this.function.apply(f2), this.function.apply(f3));
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F f2) {
        return this.resultEquivalence.hash(this.function.apply(f2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionalEquivalence) {
            FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
            return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return k.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + SmallTailInfo.EMOTION_SUFFIX;
    }
}
