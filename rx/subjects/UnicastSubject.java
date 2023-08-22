package rx.subjects;

import com.baidu.tieba.a8c;
import com.baidu.tieba.k8c;
import com.baidu.tieba.kac;
import com.baidu.tieba.kbc;
import com.baidu.tieba.lac;
import com.baidu.tieba.lbc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.rbc;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.z7c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends mcc<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements p7c, o7c<T>, n7c.a<T>, u7c {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<t7c<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<a8c> terminateOnce;

        public State(int i, a8c a8cVar) {
            AtomicReference<a8c> atomicReference;
            Queue<Object> kacVar;
            Queue<Object> queue;
            if (a8cVar != null) {
                atomicReference = new AtomicReference<>(a8cVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (rbc.b()) {
                    queue = new lbc<>(i);
                } else {
                    queue = new lac<>(i);
                }
            } else {
                if (rbc.b()) {
                    kacVar = new kbc<>();
                } else {
                    kacVar = new kac<>();
                }
                queue = kacVar;
            }
            this.queue = queue;
        }

        public void call(t7c<? super T> t7cVar) {
            if (this.subscriber.compareAndSet(null, t7cVar)) {
                t7cVar.b(this);
                t7cVar.f(this);
                return;
            }
            t7cVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.o7c
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

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    k8c.b(this, j);
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

        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t7c) ((t7c) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, t7c<? super T> t7cVar) {
            if (t7cVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    t7cVar.onError(th);
                    return true;
                } else if (z2) {
                    t7cVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            a8c a8cVar;
            AtomicReference<a8c> atomicReference = this.terminateOnce;
            if (atomicReference != null && (a8cVar = atomicReference.get()) != null && atomicReference.compareAndSet(a8cVar, null)) {
                a8cVar.call();
            }
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.o7c
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

        @Override // com.baidu.tieba.u7c
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

        @Override // com.baidu.tieba.o7c
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
                t7c<? super T> t7cVar = this.subscriber.get();
                try {
                    t7cVar.onNext(t);
                } catch (Throwable th) {
                    z7c.g(th, t7cVar, t);
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
                    t7c<? super T> t7cVar = this.subscriber.get();
                    if (t7cVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), t7cVar)) {
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
                            if (checkTerminated(z3, z2, t7cVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                t7cVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                z7c.e(th);
                                t7cVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.o7c
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.o7c
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, a8c a8cVar) {
        return new UnicastSubject<>(new State(i, a8cVar));
    }

    @Override // com.baidu.tieba.o7c
    public void onCompleted() {
        this.b.onCompleted();
    }
}
