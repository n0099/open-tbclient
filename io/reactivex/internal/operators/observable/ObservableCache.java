package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.f;
import io.reactivex.q;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableCache<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final AtomicBoolean once;
    final a<T> state;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(uVar, this.state);
        uVar.onSubscribe(replayDisposable);
        this.state.a(replayDisposable);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
        replayDisposable.replay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends f implements u<T> {
        static final ReplayDisposable[] nxi = new ReplayDisposable[0];
        static final ReplayDisposable[] nxj = new ReplayDisposable[0];
        volatile boolean isConnected;
        boolean nvR;
        final q<? extends T> nxd;
        final SequentialDisposable nxh;
        final AtomicReference<ReplayDisposable<T>[]> observers;

        public boolean a(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.observers.get();
                if (replayDisposableArr == nxj) {
                    return false;
                }
                int length = replayDisposableArr.length;
                replayDisposableArr2 = new ReplayDisposable[length + 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
                replayDisposableArr2[length] = replayDisposable;
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
            return true;
        }

        public void b(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.observers.get();
                int length = replayDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayDisposableArr[i2].equals(replayDisposable)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            replayDisposableArr2 = nxi;
                        } else {
                            replayDisposableArr2 = new ReplayDisposable[length - 1];
                            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, i);
                            System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.nxh.update(bVar);
        }

        public void connect() {
            this.nxd.subscribe(this);
            this.isConnected = true;
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.nvR) {
                add(NotificationLite.next(t));
                for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (!this.nvR) {
                this.nvR = true;
                add(NotificationLite.error(th));
                this.nxh.dispose();
                for (ReplayDisposable<T> replayDisposable : this.observers.getAndSet(nxj)) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.nvR) {
                this.nvR = true;
                add(NotificationLite.complete());
                this.nxh.dispose();
                for (ReplayDisposable<T> replayDisposable : this.observers.getAndSet(nxj)) {
                    replayDisposable.replay();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 7058506693698832024L;
        volatile boolean cancelled;
        final u<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final a<T> state;

        ReplayDisposable(u<? super T> uVar, a<T> aVar) {
            this.child = uVar;
            this.state = aVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() == 0) {
                u<? super T> uVar = this.child;
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (!this.cancelled) {
                        int size = this.state.size();
                        if (size != 0) {
                            Object[] objArr = this.currentBuffer;
                            if (objArr == null) {
                                objArr = this.state.dIu();
                                this.currentBuffer = objArr;
                            }
                            int length = objArr.length - 1;
                            int i3 = this.index;
                            Object[] objArr2 = objArr;
                            int i4 = this.currentIndexInBuffer;
                            while (i3 < size) {
                                if (!this.cancelled) {
                                    if (i4 == length) {
                                        objArr2 = (Object[]) objArr2[length];
                                        i4 = 0;
                                    }
                                    if (!NotificationLite.accept(objArr2[i4], uVar)) {
                                        i4++;
                                        i3++;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (!this.cancelled) {
                                this.index = i3;
                                this.currentIndexInBuffer = i4;
                                this.currentBuffer = objArr2;
                            } else {
                                return;
                            }
                        }
                        i = addAndGet(-i2);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
