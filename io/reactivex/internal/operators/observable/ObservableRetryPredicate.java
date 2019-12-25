package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.b.j;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class ObservableRetryPredicate<T> extends a<T, T> {
    final long count;
    final j<? super Throwable> predicate;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        uVar.onSubscribe(sequentialDisposable);
        new RepeatObserver(uVar, this.count, this.predicate, sequentialDisposable, this.source).subscribeNext();
    }

    /* loaded from: classes4.dex */
    static final class RepeatObserver<T> extends AtomicInteger implements u<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final u<? super T> actual;
        final j<? super Throwable> predicate;
        long remaining;
        final SequentialDisposable sa;
        final t<? extends T> source;

        RepeatObserver(u<? super T> uVar, long j, j<? super Throwable> jVar, SequentialDisposable sequentialDisposable, t<? extends T> tVar) {
            this.actual = uVar;
            this.sa = sequentialDisposable;
            this.source = tVar;
            this.predicate = jVar;
            this.remaining = j;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.sa.update(bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            long j = this.remaining;
            if (j != Format.OFFSET_SAMPLE_RELATIVE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (!this.predicate.test(th)) {
                    this.actual.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.I(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.actual.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.sa.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
