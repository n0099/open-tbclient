package rx.subjects;

import com.baidu.tieba.anb;
import com.baidu.tieba.gpb;
import com.baidu.tieba.gqb;
import com.baidu.tieba.hpb;
import com.baidu.tieba.hqb;
import com.baidu.tieba.inb;
import com.baidu.tieba.irb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.nqb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import com.baidu.tieba.zmb;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends irb<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements pmb, omb<T>, nmb.a<T>, umb {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<tmb<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<anb> terminateOnce;

        public State(int i, anb anbVar) {
            AtomicReference<anb> atomicReference;
            Queue<Object> gpbVar;
            Queue<Object> queue;
            if (anbVar != null) {
                atomicReference = new AtomicReference<>(anbVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (nqb.b()) {
                    queue = new hqb<>(i);
                } else {
                    queue = new hpb<>(i);
                }
            } else {
                if (nqb.b()) {
                    gpbVar = new gqb<>();
                } else {
                    gpbVar = new gpb<>();
                }
                queue = gpbVar;
            }
            this.queue = queue;
        }

        public void call(tmb<? super T> tmbVar) {
            if (this.subscriber.compareAndSet(null, tmbVar)) {
                tmbVar.b(this);
                tmbVar.f(this);
                return;
            }
            tmbVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.omb
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

        @Override // com.baidu.tieba.pmb
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    inb.b(this, j);
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

        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((tmb) ((tmb) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, tmb<? super T> tmbVar) {
            if (tmbVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    tmbVar.onError(th);
                    return true;
                } else if (z2) {
                    tmbVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            anb anbVar;
            AtomicReference<anb> atomicReference = this.terminateOnce;
            if (atomicReference != null && (anbVar = atomicReference.get()) != null && atomicReference.compareAndSet(anbVar, null)) {
                anbVar.call();
            }
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.omb
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

        @Override // com.baidu.tieba.umb
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

        @Override // com.baidu.tieba.omb
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
                tmb<? super T> tmbVar = this.subscriber.get();
                try {
                    tmbVar.onNext(t);
                } catch (Throwable th) {
                    zmb.g(th, tmbVar, t);
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
                    tmb<? super T> tmbVar = this.subscriber.get();
                    if (tmbVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), tmbVar)) {
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
                            if (checkTerminated(z3, z2, tmbVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                tmbVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                zmb.e(th);
                                tmbVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.omb
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.omb
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> H(int i, anb anbVar) {
        return new UnicastSubject<>(new State(i, anbVar));
    }

    @Override // com.baidu.tieba.omb
    public void onCompleted() {
        this.b.onCompleted();
    }
}
