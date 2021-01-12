package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class a<T, R> extends g<R> {
    protected final g<T> qdR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(g<T> gVar) {
        this.qdR = (g) io.reactivex.internal.functions.a.m(gVar, "source is null");
    }
}
