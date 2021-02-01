package io.reactivex.subjects;

import io.reactivex.q;
import io.reactivex.u;
/* loaded from: classes5.dex */
public abstract class b<T> extends q<T> implements u<T> {
    public final b<T> eKO() {
        return this instanceof a ? this : new a(this);
    }
}
