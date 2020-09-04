package io.reactivex.processors;

import io.reactivex.g;
import io.reactivex.j;
/* loaded from: classes7.dex */
public abstract class a<T> extends g<T> implements j<T>, org.b.a<T, T> {
    public final a<T> efG() {
        return this instanceof b ? this : new b(this);
    }
}
