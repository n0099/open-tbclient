package io.reactivex.processors;

import io.reactivex.g;
import io.reactivex.j;
/* loaded from: classes17.dex */
public abstract class a<T> extends g<T> implements j<T>, org.a.a<T, T> {
    public final a<T> exo() {
        return this instanceof b ? this : new b(this);
    }
}
