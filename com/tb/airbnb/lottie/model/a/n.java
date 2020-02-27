package com.tb.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.tb.airbnb.lottie.e.a<V>> gH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new com.tb.airbnb.lottie.e.a(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<com.tb.airbnb.lottie.e.a<V>> list) {
        this.gH = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.gH.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.gH.toArray()));
        }
        return sb.toString();
    }
}
