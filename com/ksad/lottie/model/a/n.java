package com.ksad.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.e.a<V>> f31466a;

    public n(V v) {
        this(Collections.singletonList(new com.ksad.lottie.e.a(v)));
    }

    public n(List<com.ksad.lottie.e.a<V>> list) {
        this.f31466a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f31466a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f31466a.toArray()));
        }
        return sb.toString();
    }
}
