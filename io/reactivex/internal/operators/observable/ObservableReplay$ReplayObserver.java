package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.o;
import f.b.t.b;
import f.b.x.e.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableReplay$ReplayObserver<T> extends AtomicReference<b> implements o<T>, b {
    public static final ObservableReplay$InnerDisposable[] EMPTY = new ObservableReplay$InnerDisposable[0];
    public static final ObservableReplay$InnerDisposable[] TERMINATED = new ObservableReplay$InnerDisposable[0];
    public static final long serialVersionUID = -533785617179540163L;
    public final h<T> buffer;
    public boolean done;
    public final AtomicReference<ObservableReplay$InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
    public final AtomicBoolean shouldConnect = new AtomicBoolean();

    public ObservableReplay$ReplayObserver(h<T> hVar) {
        this.buffer = hVar;
    }

    public boolean add(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr2;
        do {
            observableReplay$InnerDisposableArr = this.observers.get();
            if (observableReplay$InnerDisposableArr == TERMINATED) {
                return false;
            }
            int length = observableReplay$InnerDisposableArr.length;
            observableReplay$InnerDisposableArr2 = new ObservableReplay$InnerDisposable[length + 1];
            System.arraycopy(observableReplay$InnerDisposableArr, 0, observableReplay$InnerDisposableArr2, 0, length);
            observableReplay$InnerDisposableArr2[length] = observableReplay$InnerDisposable;
        } while (!this.observers.compareAndSet(observableReplay$InnerDisposableArr, observableReplay$InnerDisposableArr2));
        return true;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.observers.set(TERMINATED);
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.observers.get() == TERMINATED;
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.buffer.complete();
        replayFinal();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (!this.done) {
            this.done = true;
            this.buffer.error(th);
            replayFinal();
            return;
        }
        a.f(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        this.buffer.next(t);
        replay();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            replay();
        }
    }

    public void remove(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr2;
        do {
            observableReplay$InnerDisposableArr = this.observers.get();
            int length = observableReplay$InnerDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (observableReplay$InnerDisposableArr[i2].equals(observableReplay$InnerDisposable)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                observableReplay$InnerDisposableArr2 = EMPTY;
            } else {
                ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr3 = new ObservableReplay$InnerDisposable[length - 1];
                System.arraycopy(observableReplay$InnerDisposableArr, 0, observableReplay$InnerDisposableArr3, 0, i);
                System.arraycopy(observableReplay$InnerDisposableArr, i + 1, observableReplay$InnerDisposableArr3, i, (length - i) - 1);
                observableReplay$InnerDisposableArr2 = observableReplay$InnerDisposableArr3;
            }
        } while (!this.observers.compareAndSet(observableReplay$InnerDisposableArr, observableReplay$InnerDisposableArr2));
    }

    public void replay() {
        for (ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable : this.observers.get()) {
            this.buffer.replay(observableReplay$InnerDisposable);
        }
    }

    public void replayFinal() {
        for (ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable : this.observers.getAndSet(TERMINATED)) {
            this.buffer.replay(observableReplay$InnerDisposable);
        }
    }
}
