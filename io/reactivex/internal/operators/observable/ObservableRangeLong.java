package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.q;
import io.reactivex.u;
/* loaded from: classes3.dex */
public final class ObservableRangeLong extends q<Long> {
    private final long count;
    private final long start;

    @Override // io.reactivex.q
    protected void a(u<? super Long> uVar) {
        RangeDisposable rangeDisposable = new RangeDisposable(uVar, this.start, this.start + this.count);
        uVar.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }

    /* loaded from: classes3.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final u<? super Long> actual;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(u<? super Long> uVar, long j, long j2) {
            this.actual = uVar;
            this.index = j;
            this.end = j2;
        }

        void run() {
            if (!this.fused) {
                u<? super Long> uVar = this.actual;
                long j = this.end;
                for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                    uVar.onNext(Long.valueOf(j2));
                }
                if (get() == 0) {
                    lazySet(1);
                    uVar.onComplete();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.a.f
        public Long poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.fused = true;
                return 1;
            }
            return 0;
        }
    }
}
