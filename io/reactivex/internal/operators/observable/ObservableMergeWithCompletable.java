package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableMergeWithCompletable<T> extends a<T, T> {
    final e other;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(uVar);
        uVar.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.other.a(mergeWithObserver.otherObserver);
    }

    /* loaded from: classes5.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -4592979584110982903L;
        final u<? super T> actual;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<io.reactivex.disposables.b> mainDisposable = new AtomicReference<>();
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicThrowable error = new AtomicThrowable();

        MergeWithObserver(u<? super T> uVar) {
            this.actual = uVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            io.reactivex.internal.util.e.a(this.actual, t, this, this.error);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.e.a((u<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.e.a(this.actual, this, this.error);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        void otherError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.e.a((u<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.e.a(this.actual, this, this.error);
            }
        }

        /* loaded from: classes5.dex */
        static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements c {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
