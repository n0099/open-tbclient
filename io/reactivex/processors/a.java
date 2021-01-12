package io.reactivex.processors;

import io.reactivex.g;
import io.reactivex.j;
/* loaded from: classes5.dex */
public abstract class a<T> extends g<T> implements j<T>, org.a.a<T, T> {
    public final a<T> eIs() {
        return this instanceof b ? this : new b(this);
    }
}
