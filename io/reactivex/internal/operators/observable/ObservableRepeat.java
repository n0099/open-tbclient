package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class ObservableRepeat<T> extends a<T, T> {
    final long count;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        uVar.onSubscribe(sequentialDisposable);
        if (this.count != Format.OFFSET_SAMPLE_RELATIVE) {
            j = this.count - 1;
        }
        new RepeatObserver(uVar, j, sequentialDisposable, this.source).subscribeNext();
    }

    /* loaded from: classes4.dex */
    static final class RepeatObserver<T> extends AtomicInteger implements u<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final u<? super T> actual;
        long remaining;
        final SequentialDisposable sd;
        final t<? extends T> source;

        RepeatObserver(u<? super T> uVar, long j, SequentialDisposable sequentialDisposable, t<? extends T> tVar) {
            this.actual = uVar;
            this.sd = sequentialDisposable;
            this.source = tVar;
            this.remaining = j;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.sd.replace(bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            long j = this.remaining;
            if (j != Format.OFFSET_SAMPLE_RELATIVE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.sd.isDisposed()) {
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
