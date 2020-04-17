package io.reactivex.internal.operators.flowable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class a<T, R> extends io.reactivex.g<R> {
    protected final io.reactivex.g<T> mRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(io.reactivex.g<T> gVar) {
        this.mRJ = (io.reactivex.g) io.reactivex.internal.functions.a.h(gVar, "source is null");
    }
}
