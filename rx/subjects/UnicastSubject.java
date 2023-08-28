package rx.subjects;

import com.baidu.tieba.b8c;
import com.baidu.tieba.c8c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.mac;
import com.baidu.tieba.mbc;
import com.baidu.tieba.nac;
import com.baidu.tieba.nbc;
import com.baidu.tieba.occ;
import com.baidu.tieba.p7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.tbc;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends occ<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements r7c, q7c<T>, p7c.a<T>, w7c {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<v7c<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<c8c> terminateOnce;

        public State(int i, c8c c8cVar) {
            AtomicReference<c8c> atomicReference;
            Queue<Object> macVar;
            Queue<Object> queue;
            if (c8cVar != null) {
                atomicReference = new AtomicReference<>(c8cVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (tbc.b()) {
                    queue = new nbc<>(i);
                } else {
                    queue = new nac<>(i);
                }
            } else {
                if (tbc.b()) {
                    macVar = new mbc<>();
                } else {
                    macVar = new mac<>();
                }
                queue = macVar;
            }
            this.queue = queue;
        }

        public void call(v7c<? super T> v7cVar) {
            if (this.subscriber.compareAndSet(null, v7cVar)) {
                v7cVar.b(this);
                v7cVar.f(this);
                return;
            }
            v7cVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.q7c
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

        @Override // com.baidu.tieba.r7c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    m8c.b(this, j);
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

        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((v7c) ((v7c) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, v7c<? super T> v7cVar) {
            if (v7cVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    v7cVar.onError(th);
                    return true;
                } else if (z2) {
                    v7cVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            c8c c8cVar;
            AtomicReference<c8c> atomicReference = this.terminateOnce;
            if (atomicReference != null && (c8cVar = atomicReference.get()) != null && atomicReference.compareAndSet(c8cVar, null)) {
                c8cVar.call();
            }
        }

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.q7c
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

        @Override // com.baidu.tieba.w7c
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

        @Override // com.baidu.tieba.q7c
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
                v7c<? super T> v7cVar = this.subscriber.get();
                try {
                    v7cVar.onNext(t);
                } catch (Throwable th) {
                    b8c.g(th, v7cVar, t);
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
                    v7c<? super T> v7cVar = this.subscriber.get();
                    if (v7cVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), v7cVar)) {
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
                            if (checkTerminated(z3, z2, v7cVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                v7cVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                b8c.e(th);
                                v7cVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.q7c
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.q7c
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, c8c c8cVar) {
        return new UnicastSubject<>(new State(i, c8cVar));
    }

    @Override // com.baidu.tieba.q7c
    public void onCompleted() {
        this.b.onCompleted();
    }
}
