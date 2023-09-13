package rx.subjects;

import com.baidu.tieba.ebc;
import com.baidu.tieba.fbc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.pdc;
import com.baidu.tieba.pec;
import com.baidu.tieba.qdc;
import com.baidu.tieba.qec;
import com.baidu.tieba.rfc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.uac;
import com.baidu.tieba.wec;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends rfc<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements uac, tac<T>, sac.a<T>, zac {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<yac<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<fbc> terminateOnce;

        public State(int i, fbc fbcVar) {
            AtomicReference<fbc> atomicReference;
            Queue<Object> pdcVar;
            Queue<Object> queue;
            if (fbcVar != null) {
                atomicReference = new AtomicReference<>(fbcVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (wec.b()) {
                    queue = new qec<>(i);
                } else {
                    queue = new qdc<>(i);
                }
            } else {
                if (wec.b()) {
                    pdcVar = new pec<>();
                } else {
                    pdcVar = new pdc<>();
                }
                queue = pdcVar;
            }
            this.queue = queue;
        }

        public void call(yac<? super T> yacVar) {
            if (this.subscriber.compareAndSet(null, yacVar)) {
                yacVar.b(this);
                yacVar.f(this);
                return;
            }
            yacVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    pbc.b(this, j);
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

        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yac) ((yac) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, yac<? super T> yacVar) {
            if (yacVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    yacVar.onError(th);
                    return true;
                } else if (z2) {
                    yacVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            fbc fbcVar;
            AtomicReference<fbc> atomicReference = this.terminateOnce;
            if (atomicReference != null && (fbcVar = atomicReference.get()) != null && atomicReference.compareAndSet(fbcVar, null)) {
                fbcVar.call();
            }
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.zac
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

        @Override // com.baidu.tieba.tac
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
                yac<? super T> yacVar = this.subscriber.get();
                try {
                    yacVar.onNext(t);
                } catch (Throwable th) {
                    ebc.g(th, yacVar, t);
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
                    yac<? super T> yacVar = this.subscriber.get();
                    if (yacVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), yacVar)) {
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
                            if (checkTerminated(z3, z2, yacVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                yacVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                ebc.e(th);
                                yacVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.tac
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.tac
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> Q(int i, fbc fbcVar) {
        return new UnicastSubject<>(new State(i, fbcVar));
    }

    @Override // com.baidu.tieba.tac
    public void onCompleted() {
        this.b.onCompleted();
    }
}
