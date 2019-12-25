package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class a<T, R> extends g<R> {
    protected final g<T> mTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(g<T> gVar) {
        this.mTG = (g) io.reactivex.internal.functions.a.h(gVar, "source is null");
    }
}
