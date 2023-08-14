package rx.subjects;

import com.baidu.tieba.a1c;
import com.baidu.tieba.b5c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.u3c;
import com.baidu.tieba.u4c;
import com.baidu.tieba.v3c;
import com.baidu.tieba.v4c;
import com.baidu.tieba.w5c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.z0c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends w5c<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements a1c, z0c<T>, y0c.a<T>, f1c {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<e1c<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<l1c> terminateOnce;

        public State(int i, l1c l1cVar) {
            AtomicReference<l1c> atomicReference;
            Queue<Object> u3cVar;
            Queue<Object> queue;
            if (l1cVar != null) {
                atomicReference = new AtomicReference<>(l1cVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (b5c.b()) {
                    queue = new v4c<>(i);
                } else {
                    queue = new v3c<>(i);
                }
            } else {
                if (b5c.b()) {
                    u3cVar = new u4c<>();
                } else {
                    u3cVar = new u3c<>();
                }
                queue = u3cVar;
            }
            this.queue = queue;
        }

        public void call(e1c<? super T> e1cVar) {
            if (this.subscriber.compareAndSet(null, e1cVar)) {
                e1cVar.b(this);
                e1cVar.f(this);
                return;
            }
            e1cVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.z0c
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

        @Override // com.baidu.tieba.a1c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    u1c.b(this, j);
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

        @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((e1c) ((e1c) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, e1c<? super T> e1cVar) {
            if (e1cVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    e1cVar.onError(th);
                    return true;
                } else if (z2) {
                    e1cVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            l1c l1cVar;
            AtomicReference<l1c> atomicReference = this.terminateOnce;
            if (atomicReference != null && (l1cVar = atomicReference.get()) != null && atomicReference.compareAndSet(l1cVar, null)) {
                l1cVar.call();
            }
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.z0c
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

        @Override // com.baidu.tieba.f1c
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

        @Override // com.baidu.tieba.z0c
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
                e1c<? super T> e1cVar = this.subscriber.get();
                try {
                    e1cVar.onNext(t);
                } catch (Throwable th) {
                    k1c.g(th, e1cVar, t);
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
                    e1c<? super T> e1cVar = this.subscriber.get();
                    if (e1cVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), e1cVar)) {
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
                            if (checkTerminated(z3, z2, e1cVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                e1cVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                k1c.e(th);
                                e1cVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.z0c
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.z0c
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, l1c l1cVar) {
        return new UnicastSubject<>(new State(i, l1cVar));
    }

    @Override // com.baidu.tieba.z0c
    public void onCompleted() {
        this.b.onCompleted();
    }
}
