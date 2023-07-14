package rx.subjects;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.q4c;
import com.baidu.tieba.q5c;
import com.baidu.tieba.r4c;
import com.baidu.tieba.r5c;
import com.baidu.tieba.s6c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.v1c;
import com.baidu.tieba.w1c;
import com.baidu.tieba.x5c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends s6c<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements w1c, v1c<T>, u1c.a<T>, b2c {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<a2c<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<h2c> terminateOnce;

        public State(int i, h2c h2cVar) {
            AtomicReference<h2c> atomicReference;
            Queue<Object> q4cVar;
            Queue<Object> queue;
            if (h2cVar != null) {
                atomicReference = new AtomicReference<>(h2cVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (x5c.b()) {
                    queue = new r5c<>(i);
                } else {
                    queue = new r4c<>(i);
                }
            } else {
                if (x5c.b()) {
                    q4cVar = new q5c<>();
                } else {
                    q4cVar = new q4c<>();
                }
                queue = q4cVar;
            }
            this.queue = queue;
        }

        public void call(a2c<? super T> a2cVar) {
            if (this.subscriber.compareAndSet(null, a2cVar)) {
                a2cVar.b(this);
                a2cVar.f(this);
                return;
            }
            a2cVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.v1c
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

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    q2c.b(this, j);
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

        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((a2c) ((a2c) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, a2c<? super T> a2cVar) {
            if (a2cVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    a2cVar.onError(th);
                    return true;
                } else if (z2) {
                    a2cVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            h2c h2cVar;
            AtomicReference<h2c> atomicReference = this.terminateOnce;
            if (atomicReference != null && (h2cVar = atomicReference.get()) != null && atomicReference.compareAndSet(h2cVar, null)) {
                h2cVar.call();
            }
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.v1c
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

        @Override // com.baidu.tieba.b2c
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

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.i(t));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                a2c<? super T> a2cVar = this.subscriber.get();
                try {
                    a2cVar.onNext(t);
                } catch (Throwable th) {
                    g2c.g(th, a2cVar, t);
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
                    a2c<? super T> a2cVar = this.subscriber.get();
                    if (a2cVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), a2cVar)) {
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
                            if (checkTerminated(z3, z2, a2cVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                a2cVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                g2c.e(th);
                                a2cVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.v1c
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.v1c
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, h2c h2cVar) {
        return new UnicastSubject<>(new State(i, h2cVar));
    }

    @Override // com.baidu.tieba.v1c
    public void onCompleted() {
        this.b.onCompleted();
    }
}
