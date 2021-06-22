package com.ksad.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.e.a<V>> f32096a;

    public n(V v) {
        this(Collections.singletonList(new com.ksad.lottie.e.a(v)));
    }

    public n(List<com.ksad.lottie.e.a<V>> list) {
        this.f32096a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f32096a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f32096a.toArray()));
        }
        return sb.toString();
    }
}
