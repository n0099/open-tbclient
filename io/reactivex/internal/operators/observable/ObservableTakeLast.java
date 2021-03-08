package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.ArrayDeque;
/* loaded from: classes6.dex */
public final class ObservableTakeLast<T> extends a<T, T> {
    final int count;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new TakeLastObserver(uVar, this.count));
    }

    /* loaded from: classes6.dex */
    static final class TakeLastObserver<T> extends ArrayDeque<T> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 7240042530241604978L;
        final u<? super T> actual;
        volatile boolean cancelled;
        final int count;
        io.reactivex.disposables.b s;

        TakeLastObserver(u<? super T> uVar, int i) {
            this.actual = uVar;
            this.count = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            u<? super T> uVar = this.actual;
            while (!this.cancelled) {
                Object obj = (T) poll();
                if (obj == null) {
                    if (!this.cancelled) {
                        uVar.onComplete();
                        return;
                    }
                    return;
                }
                uVar.onNext(obj);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }
}
