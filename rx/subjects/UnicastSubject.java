package rx.subjects;

import com.baidu.tieba.asa;
import com.baidu.tieba.bsa;
import com.baidu.tieba.eua;
import com.baidu.tieba.eva;
import com.baidu.tieba.fua;
import com.baidu.tieba.fva;
import com.baidu.tieba.gwa;
import com.baidu.tieba.jsa;
import com.baidu.tieba.lva;
import com.baidu.tieba.ora;
import com.baidu.tieba.pra;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends gwa<T, T> {
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements qra, pra<T>, ora.a<T>, vra {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<ura<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<bsa> terminateOnce;

        public State(int i, bsa bsaVar) {
            AtomicReference<bsa> atomicReference;
            Queue<Object> euaVar;
            Queue<Object> queue;
            if (bsaVar != null) {
                atomicReference = new AtomicReference<>(bsaVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (lva.b()) {
                    queue = new fva<>(i);
                } else {
                    queue = new fua<>(i);
                }
            } else {
                if (lva.b()) {
                    euaVar = new eva<>();
                } else {
                    euaVar = new eua<>();
                }
                queue = euaVar;
            }
            this.queue = queue;
        }

        public void call(ura<? super T> uraVar) {
            if (this.subscriber.compareAndSet(null, uraVar)) {
                uraVar.b(this);
                uraVar.f(this);
                return;
            }
            uraVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.pra
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

        @Override // com.baidu.tieba.qra
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    jsa.b(this, j);
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

        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((ura) ((ura) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, ura<? super T> uraVar) {
            if (uraVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    uraVar.onError(th);
                    return true;
                } else if (z2) {
                    uraVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            bsa bsaVar;
            AtomicReference<bsa> atomicReference = this.terminateOnce;
            if (atomicReference != null && (bsaVar = atomicReference.get()) != null && atomicReference.compareAndSet(bsaVar, null)) {
                bsaVar.call();
            }
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.pra
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

        @Override // com.baidu.tieba.vra
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

        @Override // com.baidu.tieba.pra
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
                ura<? super T> uraVar = this.subscriber.get();
                try {
                    uraVar.onNext(t);
                } catch (Throwable th) {
                    asa.g(th, uraVar, t);
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
                    ura<? super T> uraVar = this.subscriber.get();
                    if (uraVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), uraVar)) {
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
                            if (checkTerminated(z3, z2, uraVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                uraVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                asa.e(th);
                                uraVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.pra
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.pra
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> D(int i, bsa bsaVar) {
        return new UnicastSubject<>(new State(i, bsaVar));
    }

    @Override // com.baidu.tieba.pra
    public void onCompleted() {
        this.b.onCompleted();
    }
}
