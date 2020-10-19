package io.reactivex.internal.operators.observable;

import io.reactivex.q;
import io.reactivex.t;
/* loaded from: classes17.dex */
abstract class a<T, U> extends q<U> {
    protected final t<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(t<T> tVar) {
        this.source = tVar;
    }
}
