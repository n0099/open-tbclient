package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.c;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {
    final int bufferSize;
    final t<? extends T> source;

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.bufferSize);
        this.source.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }

    /* loaded from: classes7.dex */
    static final class BlockingObservableIterator<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T>, Iterator<T> {
        private static final long serialVersionUID = 6695226475494099826L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        BlockingObservableIterator(int i) {
            this.queue = new io.reactivex.internal.queue.a<>(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw ExceptionHelper.N(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (isEmpty) {
                    try {
                        c.dLj();
                        this.lock.lock();
                        while (!this.done && this.queue.isEmpty()) {
                            this.condition.await();
                        }
                        this.lock.unlock();
                    } catch (InterruptedException e) {
                        DisposableHelper.dispose(this);
                        signalConsumer();
                        throw ExceptionHelper.N(e);
                    }
                } else {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
