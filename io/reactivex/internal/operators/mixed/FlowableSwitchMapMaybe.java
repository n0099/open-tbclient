package io.reactivex.internal.operators.mixed;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableSwitchMapMaybe<T, R> extends g<R> {
    final boolean delayErrors;
    final h<? super T, ? extends o<? extends R>> mapper;
    final g<T> nvK;

    @Override // io.reactivex.g
    protected void a(c<? super R> cVar) {
        this.nvK.a((j) new SwitchMapMaybeSubscriber(cVar, this.mapper, this.delayErrors));
    }

    /* loaded from: classes5.dex */
    static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements j<T>, d {
        static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final c<? super R> downstream;
        long emitted;
        final h<? super T, ? extends o<? extends R>> mapper;
        d upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();

        SwitchMapMaybeSubscriber(c<? super R> cVar, h<? super T, ? extends o<? extends R>> hVar, boolean z) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.dispose();
            }
            try {
                o oVar = (o) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                oVar.a(switchMapMaybeObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = (SwitchMapMaybeObserver) this.inner.getAndSet(INNER_DISPOSED);
            if (switchMapMaybeObserver != null && switchMapMaybeObserver != INNER_DISPOSED) {
                switchMapMaybeObserver.dispose();
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

        void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null) && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    disposeInner();
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                drain();
            }
        }

        /* JADX DEBUG: Type inference failed for r0v8. Raw type applied. Possible types: R, ? super R */
        void drain() {
            if (getAndIncrement() == 0) {
                c<? super R> cVar = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
                AtomicLong atomicLong = this.requested;
                long j = this.emitted;
                int i = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() != null && !this.delayErrors) {
                        cVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                    boolean z2 = switchMapMaybeObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            cVar.onError(terminate);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    } else if (!z2 && switchMapMaybeObserver.item != null && j != atomicLong.get()) {
                        atomicReference.compareAndSet(switchMapMaybeObserver, null);
                        cVar.onNext((R) switchMapMaybeObserver.item);
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
        /* loaded from: classes5.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements m<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapMaybeSubscriber<?, R> parent;

            SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.parent = switchMapMaybeSubscriber;
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
