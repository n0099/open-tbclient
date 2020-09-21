package io.reactivex.internal.operators.flowable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public abstract class a<T, R> extends io.reactivex.g<R> {
    protected final io.reactivex.g<T> owE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(io.reactivex.g<T> gVar) {
        this.owE = (io.reactivex.g) io.reactivex.internal.functions.a.k(gVar, "source is null");
    }
}
