package com.google.common.collect;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.k;
import d.h.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    public static final long serialVersionUID = 0;
    public final g<F, ? extends T> function;
    public final Ordering<T> ordering;

    public ByFunctionOrdering(g<F, ? extends T> gVar, Ordering<T> ordering) {
        n.p(gVar);
        this.function = gVar;
        n.p(ordering);
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f2, F f3) {
        return this.ordering.compare(this.function.apply(f2), this.function.apply(f3));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByFunctionOrdering) {
            ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
            return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
        }
        return false;
    }

    public int hashCode() {
        return k.b(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + SmallTailInfo.EMOTION_SUFFIX;
    }
}
