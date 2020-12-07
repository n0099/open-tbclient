package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class a<T, R> extends g<R> {
    protected final g<T> pFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(g<T> gVar) {
        this.pFg = (g) io.reactivex.internal.functions.a.m(gVar, "source is null");
    }
}
