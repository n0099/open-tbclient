package io.reactivex.subjects;

import io.reactivex.q;
import io.reactivex.u;
/* loaded from: classes17.dex */
public abstract class b<T> extends q<T> implements u<T> {
    public final b<T> eBm() {
        return this instanceof a ? this : new a(this);
    }
}
