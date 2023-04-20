package rx.subjects;

import com.baidu.tieba.a2b;
import com.baidu.tieba.d4b;
import com.baidu.tieba.d5b;
import com.baidu.tieba.e4b;
import com.baidu.tieba.e5b;
import com.baidu.tieba.f6b;
import com.baidu.tieba.i2b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.z1b;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends f6b<T, T> {
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements p1b, o1b<T>, n1b.a<T>, u1b {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<t1b<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<a2b> terminateOnce;

        public State(int i, a2b a2bVar) {
            AtomicReference<a2b> atomicReference;
            Queue<Object> d4bVar;
            Queue<Object> queue;
            if (a2bVar != null) {
                atomicReference = new AtomicReference<>(a2bVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (k5b.b()) {
                    queue = new e5b<>(i);
                } else {
                    queue = new e4b<>(i);
                }
            } else {
                if (k5b.b()) {
                    d4bVar = new d5b<>();
                } else {
                    d4bVar = new d4b<>();
                }
                queue = d4bVar;
            }
            this.queue = queue;
        }

        public void call(t1b<? super T> t1bVar) {
            if (this.subscriber.compareAndSet(null, t1bVar)) {
                t1bVar.b(this);
                t1bVar.f(this);
                return;
            }
            t1bVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.o1b
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

        @Override // com.baidu.tieba.p1b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    i2b.b(this, j);
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

        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t1b) ((t1b) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, t1b<? super T> t1bVar) {
            if (t1bVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    t1bVar.onError(th);
                    return true;
                } else if (z2) {
                    t1bVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            a2b a2bVar;
            AtomicReference<a2b> atomicReference = this.terminateOnce;
            if (atomicReference != null && (a2bVar = atomicReference.get()) != null && atomicReference.compareAndSet(a2bVar, null)) {
                a2bVar.call();
            }
        }

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.o1b
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

        @Override // com.baidu.tieba.u1b
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

        @Override // com.baidu.tieba.o1b
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
                t1b<? super T> t1bVar = this.subscriber.get();
                try {
                    t1bVar.onNext(t);
                } catch (Throwable th) {
                    z1b.g(th, t1bVar, t);
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
                    t1b<? super T> t1bVar = this.subscriber.get();
                    if (t1bVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), t1bVar)) {
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
                            if (checkTerminated(z3, z2, t1bVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                t1bVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                z1b.e(th);
                                t1bVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.o1b
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.o1b
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> D(int i, a2b a2bVar) {
        return new UnicastSubject<>(new State(i, a2bVar));
    }

    @Override // com.baidu.tieba.o1b
    public void onCompleted() {
        this.b.onCompleted();
    }
}
