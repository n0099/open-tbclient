package rx.subjects;

import com.baidu.tieba.hdc;
import com.baidu.tieba.hfc;
import com.baidu.tieba.hgc;
import com.baidu.tieba.ifc;
import com.baidu.tieba.igc;
import com.baidu.tieba.jhc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.lcc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.ogc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.wcc;
import com.baidu.tieba.xcc;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends jhc<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements mcc, lcc<T>, kcc.a<T>, rcc {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<qcc<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<xcc> terminateOnce;

        public State(int i, xcc xccVar) {
            AtomicReference<xcc> atomicReference;
            Queue<Object> hfcVar;
            Queue<Object> queue;
            if (xccVar != null) {
                atomicReference = new AtomicReference<>(xccVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (ogc.b()) {
                    queue = new igc<>(i);
                } else {
                    queue = new ifc<>(i);
                }
            } else {
                if (ogc.b()) {
                    hfcVar = new hgc<>();
                } else {
                    hfcVar = new hfc<>();
                }
                queue = hfcVar;
            }
            this.queue = queue;
        }

        public void call(qcc<? super T> qccVar) {
            if (this.subscriber.compareAndSet(null, qccVar)) {
                qccVar.b(this);
                qccVar.f(this);
                return;
            }
            qccVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.lcc
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

        @Override // com.baidu.tieba.mcc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    hdc.b(this, j);
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

        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((qcc) ((qcc) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, qcc<? super T> qccVar) {
            if (qccVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    qccVar.onError(th);
                    return true;
                } else if (z2) {
                    qccVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            xcc xccVar;
            AtomicReference<xcc> atomicReference = this.terminateOnce;
            if (atomicReference != null && (xccVar = atomicReference.get()) != null && atomicReference.compareAndSet(xccVar, null)) {
                xccVar.call();
            }
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.lcc
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

        @Override // com.baidu.tieba.rcc
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

        @Override // com.baidu.tieba.lcc
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
                qcc<? super T> qccVar = this.subscriber.get();
                try {
                    qccVar.onNext(t);
                } catch (Throwable th) {
                    wcc.g(th, qccVar, t);
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
                    qcc<? super T> qccVar = this.subscriber.get();
                    if (qccVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), qccVar)) {
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
                            if (checkTerminated(z3, z2, qccVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                qccVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                wcc.e(th);
                                qccVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.lcc
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.lcc
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, xcc xccVar) {
        return new UnicastSubject<>(new State(i, xccVar));
    }

    @Override // com.baidu.tieba.lcc
    public void onCompleted() {
        this.b.onCompleted();
    }
}
