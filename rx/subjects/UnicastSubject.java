package rx.subjects;

import com.baidu.tieba.bab;
import com.baidu.tieba.bbb;
import com.baidu.tieba.cab;
import com.baidu.tieba.cbb;
import com.baidu.tieba.d8b;
import com.baidu.tieba.dcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.ibb;
import com.baidu.tieba.j7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p7b;
import com.baidu.tieba.u7b;
import com.baidu.tieba.v7b;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes10.dex */
public final class UnicastSubject<T> extends dcb<T, T> {
    public final State<T> b;

    /* loaded from: classes10.dex */
    public static final class State<T> extends AtomicLong implements k7b, j7b<T>, i7b.a<T>, p7b {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<o7b<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<v7b> terminateOnce;

        public State(int i, v7b v7bVar) {
            AtomicReference<v7b> atomicReference;
            Queue<Object> babVar;
            Queue<Object> queue;
            if (v7bVar != null) {
                atomicReference = new AtomicReference<>(v7bVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (ibb.b()) {
                    queue = new cbb<>(i);
                } else {
                    queue = new cab<>(i);
                }
            } else {
                if (ibb.b()) {
                    babVar = new bbb<>();
                } else {
                    babVar = new bab<>();
                }
                queue = babVar;
            }
            this.queue = queue;
        }

        public void call(o7b<? super T> o7bVar) {
            if (this.subscriber.compareAndSet(null, o7bVar)) {
                o7bVar.b(this);
                o7bVar.f(this);
                return;
            }
            o7bVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.j7b
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

        @Override // com.baidu.tieba.k7b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    d8b.b(this, j);
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

        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((o7b) ((o7b) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, o7b<? super T> o7bVar) {
            if (o7bVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    o7bVar.onError(th);
                    return true;
                } else if (z2) {
                    o7bVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            v7b v7bVar;
            AtomicReference<v7b> atomicReference = this.terminateOnce;
            if (atomicReference != null && (v7bVar = atomicReference.get()) != null && atomicReference.compareAndSet(v7bVar, null)) {
                v7bVar.call();
            }
        }

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.j7b
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

        @Override // com.baidu.tieba.p7b
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

        @Override // com.baidu.tieba.j7b
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
                o7b<? super T> o7bVar = this.subscriber.get();
                try {
                    o7bVar.onNext(t);
                } catch (Throwable th) {
                    u7b.g(th, o7bVar, t);
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
                    o7b<? super T> o7bVar = this.subscriber.get();
                    if (o7bVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), o7bVar)) {
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
                            if (checkTerminated(z3, z2, o7bVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                o7bVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                u7b.e(th);
                                o7bVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.j7b
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.j7b
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> H(int i, v7b v7bVar) {
        return new UnicastSubject<>(new State(i, v7bVar));
    }

    @Override // com.baidu.tieba.j7b
    public void onCompleted() {
        this.b.onCompleted();
    }
}
