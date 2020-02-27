package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.u;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {
    final Callable<U> bufferSupplier;
    final int count;
    final int skip;

    @Override // io.reactivex.q
    protected void a(u<? super U> uVar) {
        if (this.skip == this.count) {
            a aVar = new a(uVar, this.count, this.bufferSupplier);
            if (aVar.dJn()) {
                this.source.subscribe(aVar);
                return;
            }
            return;
        }
        this.source.subscribe(new BufferSkipObserver(uVar, this.count, this.skip, this.bufferSupplier));
    }

    /* loaded from: classes7.dex */
    static final class a<T, U extends Collection<? super T>> implements io.reactivex.disposables.b, u<T> {
        final u<? super U> actual;
        U buffer;
        final Callable<U> bufferSupplier;
        final int count;
        io.reactivex.disposables.b s;
        int size;

        a(u<? super U> uVar, int i, Callable<U> callable) {
            this.actual = uVar;
            this.count = i;
            this.bufferSupplier = callable;
        }

        boolean dJn() {
            try {
                this.buffer = (U) io.reactivex.internal.functions.a.h(this.bufferSupplier.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.buffer = null;
                if (this.s == null) {
                    EmptyDisposable.error(th, this.actual);
                } else {
                    this.s.dispose();
                    this.actual.onError(th);
                }
                return false;
            }
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            U u = this.buffer;
            if (u != null) {
                u.add(t);
                int i = this.size + 1;
                this.size = i;
                if (i >= this.count) {
                    this.actual.onNext(u);
                    this.size = 0;
                    dJn();
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            U u = this.buffer;
            if (u != null) {
                this.buffer = null;
                if (!u.isEmpty()) {
                    this.actual.onNext(u);
                }
                this.actual.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -8223395059921494546L;
        final u<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;
        io.reactivex.disposables.b s;
        final int skip;

        BufferSkipObserver(u<? super U> uVar, int i, int i2, Callable<U> callable) {
            this.actual = uVar;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.ArrayDeque<U extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.u
        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) io.reactivex.internal.functions.a.h(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }
    }
}
