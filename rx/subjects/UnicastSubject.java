package rx.subjects;

import com.baidu.tieba.a5c;
import com.baidu.tieba.d1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.t3c;
import com.baidu.tieba.t4c;
import com.baidu.tieba.u3c;
import com.baidu.tieba.u4c;
import com.baidu.tieba.v5c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.z0c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends v5c<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements z0c, y0c<T>, x0c.a<T>, e1c {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<d1c<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<k1c> terminateOnce;

        public State(int i, k1c k1cVar) {
            AtomicReference<k1c> atomicReference;
            Queue<Object> t3cVar;
            Queue<Object> queue;
            if (k1cVar != null) {
                atomicReference = new AtomicReference<>(k1cVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (a5c.b()) {
                    queue = new u4c<>(i);
                } else {
                    queue = new u3c<>(i);
                }
            } else {
                if (a5c.b()) {
                    t3cVar = new t4c<>();
                } else {
                    t3cVar = new t3c<>();
                }
                queue = t3cVar;
            }
            this.queue = queue;
        }

        public void call(d1c<? super T> d1cVar) {
            if (this.subscriber.compareAndSet(null, d1cVar)) {
                d1cVar.b(this);
                d1cVar.f(this);
                return;
            }
            d1cVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.y0c
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

        @Override // com.baidu.tieba.z0c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    t1c.b(this, j);
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

        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((d1c) ((d1c) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, d1c<? super T> d1cVar) {
            if (d1cVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    d1cVar.onError(th);
                    return true;
                } else if (z2) {
                    d1cVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            k1c k1cVar;
            AtomicReference<k1c> atomicReference = this.terminateOnce;
            if (atomicReference != null && (k1cVar = atomicReference.get()) != null && atomicReference.compareAndSet(k1cVar, null)) {
                k1cVar.call();
            }
        }

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.y0c
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

        @Override // com.baidu.tieba.e1c
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

        @Override // com.baidu.tieba.y0c
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
                d1c<? super T> d1cVar = this.subscriber.get();
                try {
                    d1cVar.onNext(t);
                } catch (Throwable th) {
                    j1c.g(th, d1cVar, t);
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
                    d1c<? super T> d1cVar = this.subscriber.get();
                    if (d1cVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), d1cVar)) {
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
                            if (checkTerminated(z3, z2, d1cVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                d1cVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                j1c.e(th);
                                d1cVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.y0c
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.y0c
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, k1c k1cVar) {
        return new UnicastSubject<>(new State(i, k1cVar));
    }

    @Override // com.baidu.tieba.y0c
    public void onCompleted() {
        this.b.onCompleted();
    }
}
