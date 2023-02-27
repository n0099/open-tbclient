package rx.subjects;

import com.baidu.tieba.ena;
import com.baidu.tieba.fna;
import com.baidu.tieba.ipa;
import com.baidu.tieba.iqa;
import com.baidu.tieba.jpa;
import com.baidu.tieba.jqa;
import com.baidu.tieba.kra;
import com.baidu.tieba.nna;
import com.baidu.tieba.pqa;
import com.baidu.tieba.sma;
import com.baidu.tieba.tma;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends kra<T, T> {
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements uma, tma<T>, sma.a<T>, zma {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<yma<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<fna> terminateOnce;

        public State(int i, fna fnaVar) {
            AtomicReference<fna> atomicReference;
            Queue<Object> ipaVar;
            Queue<Object> queue;
            if (fnaVar != null) {
                atomicReference = new AtomicReference<>(fnaVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (pqa.b()) {
                    queue = new jqa<>(i);
                } else {
                    queue = new jpa<>(i);
                }
            } else {
                if (pqa.b()) {
                    ipaVar = new iqa<>();
                } else {
                    ipaVar = new ipa<>();
                }
                queue = ipaVar;
            }
            this.queue = queue;
        }

        public void call(yma<? super T> ymaVar) {
            if (this.subscriber.compareAndSet(null, ymaVar)) {
                ymaVar.b(this);
                ymaVar.f(this);
                return;
            }
            ymaVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.tma
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

        @Override // com.baidu.tieba.uma
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    nna.b(this, j);
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

        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yma) ((yma) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, yma<? super T> ymaVar) {
            if (ymaVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    ymaVar.onError(th);
                    return true;
                } else if (z2) {
                    ymaVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            fna fnaVar;
            AtomicReference<fna> atomicReference = this.terminateOnce;
            if (atomicReference != null && (fnaVar = atomicReference.get()) != null && atomicReference.compareAndSet(fnaVar, null)) {
                fnaVar.call();
            }
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.tma
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

        @Override // com.baidu.tieba.zma
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

        @Override // com.baidu.tieba.tma
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
                yma<? super T> ymaVar = this.subscriber.get();
                try {
                    ymaVar.onNext(t);
                } catch (Throwable th) {
                    ena.g(th, ymaVar, t);
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
                    yma<? super T> ymaVar = this.subscriber.get();
                    if (ymaVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), ymaVar)) {
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
                            if (checkTerminated(z3, z2, ymaVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                ymaVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                ena.e(th);
                                ymaVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.tma
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.tma
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> D(int i, fna fnaVar) {
        return new UnicastSubject<>(new State(i, fnaVar));
    }

    @Override // com.baidu.tieba.tma
    public void onCompleted() {
        this.b.onCompleted();
    }
}
