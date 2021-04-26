package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
/* loaded from: classes7.dex */
public final class ObservableRange extends Observable<Integer> {
    public final long end;
    public final int start;

    /* loaded from: classes7.dex */
    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        public static final long serialVersionUID = 396518478098735504L;
        public final Observer<? super Integer> actual;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(Observer<? super Integer> observer, long j, long j2) {
            this.actual = observer;
            this.index = j;
            this.end = j2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 1) != 0) {
                this.fused = true;
                return 1;
            }
            return 0;
        }

        public void run() {
            if (this.fused) {
                return;
            }
            Observer<? super Integer> observer = this.actual;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                observer.onNext(Integer.valueOf((int) j2));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Integer poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i2, int i3) {
        this.start = i2;
        this.end = i2 + i3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, this.start, this.end);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
