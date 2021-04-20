package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import f.b.x.f.a;
import f.b.x.i.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class BlockingObservableIterable$BlockingObservableIterator<T> extends AtomicReference<b> implements o<T>, Iterator<T>, b {
    public static final long serialVersionUID = 6695226475494099826L;
    public final Condition condition;
    public volatile boolean done;
    public Throwable error;
    public final Lock lock;
    public final a<T> queue;

    public BlockingObservableIterable$BlockingObservableIterator(int i) {
        this.queue = new a<>(i);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            boolean z = this.done;
            boolean isEmpty = this.queue.isEmpty();
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    throw ExceptionHelper.c(th);
                }
                if (isEmpty) {
                    return false;
                }
            }
            if (!isEmpty) {
                return true;
            }
            try {
                c.a();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    this.condition.await();
                }
                this.lock.unlock();
            } catch (InterruptedException e2) {
                DisposableHelper.dispose(this);
                signalConsumer();
                throw ExceptionHelper.c(e2);
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            return this.queue.poll();
        }
        throw new NoSuchElementException();
    }

    @Override // f.b.o
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        signalConsumer();
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.queue.offer(t);
        signalConsumer();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
