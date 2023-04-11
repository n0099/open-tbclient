package rx.subjects;

import com.baidu.tieba.a2b;
import com.baidu.tieba.c5b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.g1b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.v3b;
import com.baidu.tieba.v4b;
import com.baidu.tieba.w3b;
import com.baidu.tieba.w4b;
import com.baidu.tieba.x5b;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends x5b<T, T> {
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements h1b, g1b<T>, f1b.a<T>, m1b {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<l1b<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<s1b> terminateOnce;

        public State(int i, s1b s1bVar) {
            AtomicReference<s1b> atomicReference;
            Queue<Object> v3bVar;
            Queue<Object> queue;
            if (s1bVar != null) {
                atomicReference = new AtomicReference<>(s1bVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (c5b.b()) {
                    queue = new w4b<>(i);
                } else {
                    queue = new w3b<>(i);
                }
            } else {
                if (c5b.b()) {
                    v3bVar = new v4b<>();
                } else {
                    v3bVar = new v3b<>();
                }
                queue = v3bVar;
            }
            this.queue = queue;
        }

        public void call(l1b<? super T> l1bVar) {
            if (this.subscriber.compareAndSet(null, l1bVar)) {
                l1bVar.b(this);
                l1bVar.f(this);
                return;
            }
            l1bVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.g1b
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

        @Override // com.baidu.tieba.h1b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    a2b.b(this, j);
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

        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l1b) ((l1b) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, l1b<? super T> l1bVar) {
            if (l1bVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    l1bVar.onError(th);
                    return true;
                } else if (z2) {
                    l1bVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            s1b s1bVar;
            AtomicReference<s1b> atomicReference = this.terminateOnce;
            if (atomicReference != null && (s1bVar = atomicReference.get()) != null && atomicReference.compareAndSet(s1bVar, null)) {
                s1bVar.call();
            }
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.g1b
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

        @Override // com.baidu.tieba.m1b
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

        @Override // com.baidu.tieba.g1b
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
                l1b<? super T> l1bVar = this.subscriber.get();
                try {
                    l1bVar.onNext(t);
                } catch (Throwable th) {
                    r1b.g(th, l1bVar, t);
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
                    l1b<? super T> l1bVar = this.subscriber.get();
                    if (l1bVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), l1bVar)) {
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
                            if (checkTerminated(z3, z2, l1bVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                l1bVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                r1b.e(th);
                                l1bVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.g1b
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.g1b
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> D(int i, s1b s1bVar) {
        return new UnicastSubject<>(new State(i, s1bVar));
    }

    @Override // com.baidu.tieba.g1b
    public void onCompleted() {
        this.b.onCompleted();
    }
}
