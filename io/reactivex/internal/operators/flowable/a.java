package io.reactivex.internal.operators.flowable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public abstract class a<T, R> extends io.reactivex.g<R> {
    protected final io.reactivex.g<T> pDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(io.reactivex.g<T> gVar) {
        this.pDq = (io.reactivex.g) io.reactivex.internal.functions.a.l(gVar, "source is null");
    }
}
