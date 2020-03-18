package io.reactivex.internal.operators.mixed;

import com.google.android.exoplayer2.Format;
import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class FlowableSwitchMapSingle<T, R> extends g<R> {
    final boolean delayErrors;
    final h<? super T, ? extends aa<? extends R>> mapper;
    final g<T> nyr;

    @Override // io.reactivex.g
    protected void a(c<? super R> cVar) {
        this.nyr.a((j) new SwitchMapSingleSubscriber(cVar, this.mapper, this.delayErrors));
    }

    /* loaded from: classes7.dex */
    static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements j<T>, d {
        static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final c<? super R> downstream;
        long emitted;
        final h<? super T, ? extends aa<? extends R>> mapper;
        d upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();

        SwitchMapSingleSubscriber(c<? super R> cVar, h<? super T, ? extends aa<? extends R>> hVar, boolean z) {
            this.downstream = cVar;
            this.mapper = hVar;
            this.delayErrors = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T t) {
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.dispose();
            }
            try {
                aa aaVar = (aa) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                aaVar.a(switchMapSingleObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.upstream.cancel();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(th);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapSingleObserver<Object> switchMapSingleObserver = (SwitchMapSingleObserver) this.inner.getAndSet(INNER_DISPOSED);
            if (switchMapSingleObserver != null && switchMapSingleObserver != INNER_DISPOSED) {
                switchMapSingleObserver.dispose();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            b.a(this.requested, j);
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
        }

        void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (this.inner.compareAndSet(switchMapSingleObserver, null) && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    disposeInner();
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        /* JADX DEBUG: Type inference failed for r0v8. Raw type applied. Possible types: R, ? super R */
        void drain() {
            if (getAndIncrement() == 0) {
                c<? super R> cVar = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
                AtomicLong atomicLong = this.requested;
                long j = this.emitted;
                int i = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() != null && !this.delayErrors) {
                        cVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                    boolean z2 = switchMapSingleObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            cVar.onError(terminate);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    } else if (!z2 && switchMapSingleObserver.item != null && j != atomicLong.get()) {
                        atomicReference.compareAndSet(switchMapSingleObserver, null);
                        cVar.onNext((R) switchMapSingleObserver.item);
                        j = 1 + j;
                    } else {
                        this.emitted = j;
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements y<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapSingleSubscriber<?, R> parent;

            SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                this.parent = switchMapSingleSubscriber;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
