package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class a<T, R> extends g<R> {
    protected final g<T> qoY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(g<T> gVar) {
        this.qoY = (g) io.reactivex.internal.functions.a.n(gVar, "source is null");
    }
}
