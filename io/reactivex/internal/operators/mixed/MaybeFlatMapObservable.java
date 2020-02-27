package io.reactivex.internal.operators.mixed;

import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapObservable<T, R> extends q<R> {
    final h<? super T, ? extends t<? extends R>> mapper;
    final o<T> source;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(uVar, this.mapper);
        uVar.onSubscribe(flatMapObserver);
        this.source.a(flatMapObserver);
    }

    /* loaded from: classes7.dex */
    static final class FlatMapObserver<T, R> extends AtomicReference<b> implements b, m<T>, u<R> {
        private static final long serialVersionUID = -8948264376121066672L;
        final u<? super R> downstream;
        final h<? super T, ? extends t<? extends R>> mapper;

        FlatMapObserver(u<? super R> uVar, h<? super T, ? extends t<? extends R>> hVar) {
            this.downstream = uVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.u
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            try {
                ((t) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.downstream.onError(th);
            }
        }
    }
}
