package rx.subjects;

import com.baidu.tieba.bpb;
import com.baidu.tieba.bqb;
import com.baidu.tieba.cpb;
import com.baidu.tieba.cqb;
import com.baidu.tieba.dnb;
import com.baidu.tieba.drb;
import com.baidu.tieba.imb;
import com.baidu.tieba.iqb;
import com.baidu.tieba.jmb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.umb;
import com.baidu.tieba.vmb;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends drb<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements kmb, jmb<T>, imb.a<T>, pmb {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<omb<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<vmb> terminateOnce;

        public State(int i, vmb vmbVar) {
            AtomicReference<vmb> atomicReference;
            Queue<Object> bpbVar;
            Queue<Object> queue;
            if (vmbVar != null) {
                atomicReference = new AtomicReference<>(vmbVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (iqb.b()) {
                    queue = new cqb<>(i);
                } else {
                    queue = new cpb<>(i);
                }
            } else {
                if (iqb.b()) {
                    bpbVar = new bqb<>();
                } else {
                    bpbVar = new bpb<>();
                }
                queue = bpbVar;
            }
            this.queue = queue;
        }

        public void call(omb<? super T> ombVar) {
            if (this.subscriber.compareAndSet(null, ombVar)) {
                ombVar.b(this);
                ombVar.f(this);
                return;
            }
            ombVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.jmb
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

        @Override // com.baidu.tieba.kmb
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    dnb.b(this, j);
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

        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((omb) ((omb) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, omb<? super T> ombVar) {
            if (ombVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    ombVar.onError(th);
                    return true;
                } else if (z2) {
                    ombVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            vmb vmbVar;
            AtomicReference<vmb> atomicReference = this.terminateOnce;
            if (atomicReference != null && (vmbVar = atomicReference.get()) != null && atomicReference.compareAndSet(vmbVar, null)) {
                vmbVar.call();
            }
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.jmb
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

        @Override // com.baidu.tieba.pmb
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

        @Override // com.baidu.tieba.jmb
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
                omb<? super T> ombVar = this.subscriber.get();
                try {
                    ombVar.onNext(t);
                } catch (Throwable th) {
                    umb.g(th, ombVar, t);
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
                    omb<? super T> ombVar = this.subscriber.get();
                    if (ombVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), ombVar)) {
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
                            if (checkTerminated(z3, z2, ombVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                ombVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                umb.e(th);
                                ombVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.jmb
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.jmb
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> H(int i, vmb vmbVar) {
        return new UnicastSubject<>(new State(i, vmbVar));
    }

    @Override // com.baidu.tieba.jmb
    public void onCompleted() {
        this.b.onCompleted();
    }
}
