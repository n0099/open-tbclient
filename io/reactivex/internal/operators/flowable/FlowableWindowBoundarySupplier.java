package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.flowable.a<T, io.reactivex.g<T>> {
    final int capacityHint;
    final Callable<? extends org.a.b<B>> other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super io.reactivex.g<T>> cVar) {
        this.nvK.a((j) new WindowBoundaryMainSubscriber(cVar, this.capacityHint, this.other));
    }

    /* loaded from: classes5.dex */
    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        static final a<Object, Object> BOUNDARY_DISPOSED = new a<>(null);
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final org.a.c<? super io.reactivex.g<T>> downstream;
        long emitted;
        final Callable<? extends org.a.b<B>> other;
        org.a.d upstream;
        UnicastProcessor<T> window;
        final AtomicReference<a<T, B>> boundarySubscriber = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();

        WindowBoundaryMainSubscriber(org.a.c<? super io.reactivex.g<T>> cVar, int i, Callable<? extends org.a.b<B>> callable) {
            this.downstream = cVar;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            disposeBoundary();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        @Override // org.a.d
        public void request(long j) {
            io.reactivex.internal.util.b.a(this.requested, j);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$a<T, B>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeBoundary() {
            io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) this.boundarySubscriber.getAndSet(BOUNDARY_DISPOSED);
            if (bVar != null && bVar != BOUNDARY_DISPOSED) {
                bVar.dispose();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }

        void innerNext(a<T, B> aVar) {
            this.boundarySubscriber.compareAndSet(aVar, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        void innerError(Throwable th) {
            this.upstream.cancel();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete() {
            this.upstream.cancel();
            this.done = true;
            drain();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.processors.UnicastProcessor<T> */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            if (getAndIncrement() == 0) {
                org.a.c<? super io.reactivex.g<T>> cVar = this.downstream;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                long j = this.emitted;
                int i = 1;
                while (this.windows.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.window;
                    boolean z = this.done;
                    if (z && atomicThrowable.get() != null) {
                        mpscLinkedQueue.clear();
                        Throwable terminate = atomicThrowable.terminate();
                        if (unicastProcessor != 0) {
                            this.window = null;
                            unicastProcessor.onError(terminate);
                        }
                        cVar.onError(terminate);
                        return;
                    }
                    Object poll = mpscLinkedQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (terminate2 == null) {
                            if (unicastProcessor != 0) {
                                this.window = null;
                                unicastProcessor.onComplete();
                            }
                            cVar.onComplete();
                            return;
                        }
                        if (unicastProcessor != 0) {
                            this.window = null;
                            unicastProcessor.onError(terminate2);
                        }
                        cVar.onError(terminate2);
                        return;
                    } else if (!z2) {
                        if (poll != NEXT_WINDOW) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != 0) {
                                this.window = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.stopWindows.get()) {
                                if (j != this.requested.get()) {
                                    UnicastProcessor<T> a = UnicastProcessor.a(this.capacityHint, this);
                                    this.window = a;
                                    this.windows.getAndIncrement();
                                    try {
                                        org.a.b bVar = (org.a.b) io.reactivex.internal.functions.a.h(this.other.call(), "The other Callable returned a null Publisher");
                                        a<T, B> aVar = new a<>(this);
                                        if (this.boundarySubscriber.compareAndSet(null, aVar)) {
                                            bVar.subscribe(aVar);
                                            j++;
                                            cVar.onNext(a);
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.I(th);
                                        atomicThrowable.addThrowable(th);
                                        this.done = true;
                                    }
                                } else {
                                    this.upstream.cancel();
                                    disposeBoundary();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.done = true;
                                }
                            }
                            j = j;
                        }
                    } else {
                        this.emitted = j;
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
    public static final class a<T, B> extends io.reactivex.subscribers.a<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B> nwH;

        a(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.nwH = windowBoundaryMainSubscriber;
        }

        @Override // org.a.c
        public void onNext(B b) {
            if (!this.done) {
                this.done = true;
                dispose();
                this.nwH.innerNext(this);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.nwH.innerError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.nwH.innerComplete();
            }
        }
    }
}
