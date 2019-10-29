package com.tb.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class o<V, O> implements m<V, O> {
    final V fI;
    final List<com.tb.airbnb.lottie.a.a<V>> fu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.tb.airbnb.lottie.a.a<V>> list, V v) {
        this.fu = list;
        this.fI = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O k(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.fu.isEmpty();
    }

    public O ca() {
        return k(this.fI);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.fI);
        if (!this.fu.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.fu.toArray()));
        }
        return sb.toString();
    }
}
