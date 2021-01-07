package com.ksad.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<com.ksad.lottie.e.a<V>> f8348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new com.ksad.lottie.e.a(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<com.ksad.lottie.e.a<V>> list) {
        this.f8348a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f8348a.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.f8348a.toArray()));
        }
        return sb.toString();
    }
}
