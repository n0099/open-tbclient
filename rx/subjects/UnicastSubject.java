package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.e;
import rx.exceptions.OnErrorThrowable;
import rx.f;
import rx.internal.operators.NotificationLite;
import rx.internal.util.a.ae;
import rx.internal.util.a.x;
import rx.internal.util.a.y;
import rx.j;
import rx.k;
/* loaded from: classes15.dex */
public final class UnicastSubject<T> extends c<T, T> {
    final State<T> qxB;

    public static <T> UnicastSubject<T> a(int i, rx.functions.a aVar) {
        return new UnicastSubject<>(new State(i, aVar));
    }

    private UnicastSubject(State<T> state) {
        super(state);
        this.qxB = state;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qxB.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qxB.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qxB.onCompleted();
    }

    /* loaded from: classes15.dex */
    static final class State<T> extends AtomicLong implements d.a<T>, e<T>, f, k {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<j<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<rx.functions.a> terminateOnce;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public State(int i, rx.functions.a aVar) {
            Queue<Object> xVar;
            this.terminateOnce = aVar != null ? new AtomicReference<>(aVar) : null;
            if (i > 1) {
                xVar = ae.eOw() ? new y<>(i) : new rx.internal.util.atomic.f<>(i);
            } else {
                xVar = ae.eOw() ? new x<>() : new rx.internal.util.atomic.e<>();
            }
            this.queue = xVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.next(t));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                j<? super T> jVar = this.subscriber.get();
                try {
                    jVar.onNext(t);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, jVar, t);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            boolean z;
            if (!this.done) {
                doTerminate();
                this.error = th;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        z = this.caughtUp ? false : true;
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            boolean z;
            if (!this.done) {
                doTerminate();
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        z = this.caughtUp ? false : true;
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j > 0) {
                rx.internal.operators.a.e(this, j);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public void call(j<? super T> jVar) {
            if (this.subscriber.compareAndSet(null, jVar)) {
                jVar.add(this);
                jVar.setProducer(this);
                return;
            }
            jVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
            if (r1 == false) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
            if (r8.isEmpty() == false) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
            r10.caughtUp = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
            r10.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void replay() {
            long j;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                Queue<Object> queue = this.queue;
                while (true) {
                    j<? super T> jVar = this.subscriber.get();
                    boolean z = false;
                    if (jVar != null) {
                        if (!checkTerminated(this.done, queue.isEmpty(), jVar)) {
                            long j2 = get();
                            z = j2 == Long.MAX_VALUE;
                            long j3 = 0;
                            while (true) {
                                j = j3;
                                if (j2 == 0) {
                                    break;
                                }
                                boolean z2 = this.done;
                                Object poll = queue.poll();
                                boolean z3 = poll == null;
                                if (!checkTerminated(z2, z3, jVar)) {
                                    if (z3) {
                                        break;
                                    }
                                    Object obj = (Object) NotificationLite.getValue(poll);
                                    try {
                                        jVar.onNext(obj);
                                        j2--;
                                        j3 = 1 + j;
                                    } catch (Throwable th) {
                                        queue.clear();
                                        rx.exceptions.a.O(th);
                                        jVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (!z && j != 0) {
                                addAndGet(-j);
                            }
                        } else {
                            return;
                        }
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            break;
                        }
                        this.missed = false;
                    }
                }
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (!this.emitting) {
                    this.emitting = true;
                    this.queue.clear();
                }
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.done;
        }

        boolean checkTerminated(boolean z, boolean z2, j<? super T> jVar) {
            if (jVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    jVar.onError(th);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
                    return true;
                }
            }
            return false;
        }

        void doTerminate() {
            rx.functions.a aVar;
            AtomicReference<rx.functions.a> atomicReference = this.terminateOnce;
            if (atomicReference != null && (aVar = atomicReference.get()) != null && atomicReference.compareAndSet(aVar, null)) {
                aVar.call();
            }
        }
    }
}
