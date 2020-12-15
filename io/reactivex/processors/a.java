package io.reactivex.processors;

import io.reactivex.g;
import io.reactivex.j;
/* loaded from: classes9.dex */
public abstract class a<T> extends g<T> implements j<T>, org.a.a<T, T> {
    public final a<T> eDw() {
        return this instanceof b ? this : new b(this);
    }
}
