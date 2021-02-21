package io.reactivex.internal.operators.observable;

import io.reactivex.b.d;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class ObservableSequenceEqualSingle<T> extends w<Boolean> {
    final int bufferSize;
    final d<? super T, ? super T> comparer;
    final t<? extends T> first;
    final t<? extends T> second;

    @Override // io.reactivex.w
    public void b(y<? super Boolean> yVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(yVar, this.bufferSize, this.first, this.second, this.comparer);
        yVar.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }

    /* loaded from: classes5.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -6178010334400373240L;
        final y<? super Boolean> actual;
        volatile boolean cancelled;
        final d<? super T, ? super T> comparer;
        final t<? extends T> first;
        final a<T>[] observers;
        final ArrayCompositeDisposable resources;
        final t<? extends T> second;
        T v1;
        T v2;

        EqualCoordinator(y<? super Boolean> yVar, int i, t<? extends T> tVar, t<? extends T> tVar2, d<? super T, ? super T> dVar) {
            this.actual = yVar;
            this.first = tVar;
            this.second = tVar2;
            this.comparer = dVar;
            this.observers = r0;
            a<T>[] aVarArr = {new a<>(this, 0, i), new a<>(this, 1, i)};
            this.resources = new ArrayCompositeDisposable(2);
        }

        boolean setDisposable(io.reactivex.disposables.b bVar, int i) {
            return this.resources.setResource(i, bVar);
        }

        void subscribe() {
            a<T>[] aVarArr = this.observers;
            this.first.subscribe(aVarArr[0]);
            this.second.subscribe(aVarArr[1]);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    a<T>[] aVarArr = this.observers;
                    aVarArr[0].queue.clear();
                    aVarArr[1].queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancel(io.reactivex.internal.queue.a<T> aVar, io.reactivex.internal.queue.a<T> aVar2) {
            this.cancelled = true;
            aVar.clear();
            aVar2.clear();
        }

        /* JADX DEBUG: Type inference failed for r10v1. Raw type applied. Possible types: T, ? super T */
        /* JADX DEBUG: Type inference failed for r11v0. Raw type applied. Possible types: T, ? super T */
        void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                a<T>[] aVarArr = this.observers;
                a<T> aVar = aVarArr[0];
                io.reactivex.internal.queue.a<T> aVar2 = aVar.queue;
                a<T> aVar3 = aVarArr[1];
                io.reactivex.internal.queue.a<T> aVar4 = aVar3.queue;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = aVar.done;
                    if (z && (th2 = aVar.error) != null) {
                        cancel(aVar2, aVar4);
                        this.actual.onError(th2);
                        return;
                    }
                    boolean z2 = aVar3.done;
                    if (z2 && (th = aVar3.error) != null) {
                        cancel(aVar2, aVar4);
                        this.actual.onError(th);
                        return;
                    }
                    if (this.v1 == null) {
                        this.v1 = aVar2.poll();
                    }
                    boolean z3 = this.v1 == null;
                    if (this.v2 == null) {
                        this.v2 = aVar4.poll();
                    }
                    boolean z4 = this.v2 == null;
                    if (z && z2 && z3 && z4) {
                        this.actual.onSuccess(true);
                        return;
                    } else if (z && z2 && z3 != z4) {
                        cancel(aVar2, aVar4);
                        this.actual.onSuccess(false);
                        return;
                    } else {
                        if (!z3 && !z4) {
                            try {
                                if (!this.comparer.j((T) this.v1, (T) this.v2)) {
                                    cancel(aVar2, aVar4);
                                    this.actual.onSuccess(false);
                                    return;
                                }
                                this.v1 = null;
                                this.v2 = null;
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.N(th3);
                                cancel(aVar2, aVar4);
                                this.actual.onError(th3);
                                return;
                            }
                        }
                        if (z3 || z4) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    }
                }
                aVar2.clear();
                aVar4.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> implements u<T> {
        volatile boolean done;
        Throwable error;
        final int index;
        final EqualCoordinator<T> qqg;
        final io.reactivex.internal.queue.a<T> queue;

        a(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.qqg = equalCoordinator;
            this.index = i;
            this.queue = new io.reactivex.internal.queue.a<>(i2);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.qqg.setDisposable(bVar, this.index);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.queue.offer(t);
            this.qqg.drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.qqg.drain();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            this.qqg.drain();
        }
    }
}
