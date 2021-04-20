package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.s;
import f.b.t.b;
import f.b.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<b> implements r<T>, b {
    public static final long serialVersionUID = 3258103020495908596L;
    public final r<? super R> actual;
    public final h<? super T, ? extends s<? extends R>> mapper;

    /* loaded from: classes7.dex */
    public static final class a<R> implements r<R> {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<b> f69092e;

        /* renamed from: f  reason: collision with root package name */
        public final r<? super R> f69093f;

        public a(AtomicReference<b> atomicReference, r<? super R> rVar) {
            this.f69092e = atomicReference;
            this.f69093f = rVar;
        }

        @Override // f.b.r
        public void onError(Throwable th) {
            this.f69093f.onError(th);
        }

        @Override // f.b.r
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this.f69092e, bVar);
        }

        @Override // f.b.r
        public void onSuccess(R r) {
            this.f69093f.onSuccess(r);
        }
    }

    public SingleFlatMap$SingleFlatMapCallback(r<? super R> rVar, h<? super T, ? extends s<? extends R>> hVar) {
        this.actual = rVar;
        this.mapper = hVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        try {
            s<? extends R> apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The single returned by the mapper is null");
            s<? extends R> sVar = apply;
            if (isDisposed()) {
                return;
            }
            sVar.a(new a(this, this.actual));
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.actual.onError(th);
        }
    }
}
