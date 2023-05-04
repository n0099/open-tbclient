package rx.subjects;

import com.baidu.tieba.b8b;
import com.baidu.tieba.b9b;
import com.baidu.tieba.c8b;
import com.baidu.tieba.c9b;
import com.baidu.tieba.dab;
import com.baidu.tieba.e6b;
import com.baidu.tieba.i9b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.v5b;
import com.baidu.tieba.w5b;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends dab<T, T> {
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements l5b, k5b<T>, j5b.a<T>, q5b {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<p5b<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<w5b> terminateOnce;

        public State(int i, w5b w5bVar) {
            AtomicReference<w5b> atomicReference;
            Queue<Object> b8bVar;
            Queue<Object> queue;
            if (w5bVar != null) {
                atomicReference = new AtomicReference<>(w5bVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (i9b.b()) {
                    queue = new c9b<>(i);
                } else {
                    queue = new c8b<>(i);
                }
            } else {
                if (i9b.b()) {
                    b8bVar = new b9b<>();
                } else {
                    b8bVar = new b8b<>();
                }
                queue = b8bVar;
            }
            this.queue = queue;
        }

        public void call(p5b<? super T> p5bVar) {
            if (this.subscriber.compareAndSet(null, p5bVar)) {
                p5bVar.b(this);
                p5bVar.f(this);
                return;
            }
            p5bVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.k5b
        public void onError(Throwable th) {
            if (!this.done) {
                doTerminate();
                this.error = th;
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(th);
            }
        }

        @Override // com.baidu.tieba.l5b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    e6b.b(this, j);
                    replay();
                    return;
                } else if (this.done) {
                    replay();
                    return;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("n >= 0 required");
        }

        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((p5b) ((p5b) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, p5b<? super T> p5bVar) {
            if (p5bVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    p5bVar.onError(th);
                    return true;
                } else if (z2) {
                    p5bVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            w5b w5bVar;
            AtomicReference<w5b> atomicReference = this.terminateOnce;
            if (atomicReference != null && (w5bVar = atomicReference.get()) != null && atomicReference.compareAndSet(w5bVar, null)) {
                w5bVar.call();
            }
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.k5b
        public void onCompleted() {
            if (!this.done) {
                doTerminate();
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (this.emitting) {
                    return;
                }
                this.emitting = true;
                this.queue.clear();
            }
        }

        @Override // com.baidu.tieba.k5b
        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.h(t));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                p5b<? super T> p5bVar = this.subscriber.get();
                try {
                    p5bVar.onNext(t);
                } catch (Throwable th) {
                    v5b.g(th, p5bVar, t);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x007f, code lost:
            if (r6 == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
            if (r0.isEmpty() == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
            r14.caughtUp = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
            r14.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008c, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void replay() {
            boolean z;
            boolean z2;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                Queue<Object> queue = this.queue;
                while (true) {
                    p5b<? super T> p5bVar = this.subscriber.get();
                    if (p5bVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), p5bVar)) {
                            return;
                        }
                        long j = get();
                        if (j == Long.MAX_VALUE) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j2 = 0;
                        while (j != 0) {
                            boolean z3 = this.done;
                            Object poll = queue.poll();
                            if (poll == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (checkTerminated(z3, z2, p5bVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                p5bVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                v5b.e(th);
                                p5bVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                                return;
                            }
                        }
                        if (!z && j2 != 0) {
                            addAndGet(-j2);
                        }
                    } else {
                        z = false;
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
    }

    public UnicastSubject(State<T> state) {
        super(state);
        this.b = state;
    }

    @Override // com.baidu.tieba.k5b
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.k5b
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> F(int i, w5b w5bVar) {
        return new UnicastSubject<>(new State(i, w5bVar));
    }

    @Override // com.baidu.tieba.k5b
    public void onCompleted() {
        this.b.onCompleted();
    }
}
