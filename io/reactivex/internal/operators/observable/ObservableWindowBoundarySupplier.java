package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.observable.a<T, q<T>> {
    final int capacityHint;
    final Callable<? extends t<B>> other;

    @Override // io.reactivex.q
    public void a(u<? super q<T>> uVar) {
        this.source.subscribe(new WindowBoundaryMainObserver(uVar, this.capacityHint, this.other));
    }

    /* loaded from: classes5.dex */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements io.reactivex.disposables.b, u<T>, Runnable {
        static final a<Object, Object> BOUNDARY_DISPOSED = new a<>(null);
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final u<? super q<T>> downstream;
        final Callable<? extends t<B>> other;
        io.reactivex.disposables.b upstream;
        UnicastSubject<T> window;
        final AtomicReference<a<T, B>> boundaryObserver = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        WindowBoundaryMainObserver(u<? super q<T>> uVar, int i, Callable<? extends t<B>> callable) {
            this.downstream = uVar;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            disposeBoundary();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$a<T, B>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeBoundary() {
            io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) this.boundaryObserver.getAndSet(BOUNDARY_DISPOSED);
            if (bVar != null && bVar != BOUNDARY_DISPOSED) {
                bVar.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        void innerNext(a<T, B> aVar) {
            this.boundaryObserver.compareAndSet(aVar, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        void innerError(Throwable th) {
            this.upstream.dispose();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete() {
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.subjects.UnicastSubject<T> */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            if (getAndIncrement() == 0) {
                u<? super q<T>> uVar = this.downstream;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i = 1;
                while (this.windows.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.window;
                    boolean z = this.done;
                    if (z && atomicThrowable.get() != null) {
                        mpscLinkedQueue.clear();
                        Throwable terminate = atomicThrowable.terminate();
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onError(terminate);
                        }
                        uVar.onError(terminate);
                        return;
                    }
                    Object poll = mpscLinkedQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (terminate2 == null) {
                            if (unicastSubject != 0) {
                                this.window = null;
                                unicastSubject.onComplete();
                            }
                            uVar.onComplete();
                            return;
                        }
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onError(terminate2);
                        }
                        uVar.onError(terminate2);
                        return;
                    } else if (!z2) {
                        if (poll != NEXT_WINDOW) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != 0) {
                                this.window = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.stopWindows.get()) {
                                UnicastSubject<T> b = UnicastSubject.b(this.capacityHint, this);
                                this.window = b;
                                this.windows.getAndIncrement();
                                try {
                                    t tVar = (t) io.reactivex.internal.functions.a.h(this.other.call(), "The other Callable returned a null ObservableSource");
                                    a<T, B> aVar = new a<>(this);
                                    if (this.boundaryObserver.compareAndSet(null, aVar)) {
                                        tVar.subscribe(aVar);
                                        uVar.onNext(b);
                                    }
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.I(th);
                                    atomicThrowable.addThrowable(th);
                                    this.done = true;
                                }
                            }
                        }
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
                mpscLinkedQueue.clear();
                this.window = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T, B> extends io.reactivex.observers.a<B> {
        boolean done;
        final WindowBoundaryMainObserver<T, B> nxL;

        a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.nxL = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.u
        public void onNext(B b) {
            if (!this.done) {
                this.done = true;
                dispose();
                this.nxL.innerNext(this);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.nxL.innerError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.nxL.innerComplete();
            }
        }
    }
}
