package rx.subjects;

import com.baidu.tieba.axb;
import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.ttb;
import com.baidu.tieba.tvb;
import com.baidu.tieba.twb;
import com.baidu.tieba.uvb;
import com.baidu.tieba.uwb;
import com.baidu.tieba.vxb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.ysb;
import com.baidu.tieba.zsb;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends vxb<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements zsb, ysb<T>, xsb.a<T>, etb {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<dtb<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<ktb> terminateOnce;

        public State(int i, ktb ktbVar) {
            AtomicReference<ktb> atomicReference;
            Queue<Object> tvbVar;
            Queue<Object> queue;
            if (ktbVar != null) {
                atomicReference = new AtomicReference<>(ktbVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (axb.b()) {
                    queue = new uwb<>(i);
                } else {
                    queue = new uvb<>(i);
                }
            } else {
                if (axb.b()) {
                    tvbVar = new twb<>();
                } else {
                    tvbVar = new tvb<>();
                }
                queue = tvbVar;
            }
            this.queue = queue;
        }

        public void call(dtb<? super T> dtbVar) {
            if (this.subscriber.compareAndSet(null, dtbVar)) {
                dtbVar.b(this);
                dtbVar.f(this);
                return;
            }
            dtbVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.ysb
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

        @Override // com.baidu.tieba.zsb
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    ttb.b(this, j);
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

        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dtb) ((dtb) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, dtb<? super T> dtbVar) {
            if (dtbVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    dtbVar.onError(th);
                    return true;
                } else if (z2) {
                    dtbVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            ktb ktbVar;
            AtomicReference<ktb> atomicReference = this.terminateOnce;
            if (atomicReference != null && (ktbVar = atomicReference.get()) != null && atomicReference.compareAndSet(ktbVar, null)) {
                ktbVar.call();
            }
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.ysb
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

        @Override // com.baidu.tieba.etb
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

        @Override // com.baidu.tieba.ysb
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
                dtb<? super T> dtbVar = this.subscriber.get();
                try {
                    dtbVar.onNext(t);
                } catch (Throwable th) {
                    jtb.g(th, dtbVar, t);
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
                    dtb<? super T> dtbVar = this.subscriber.get();
                    if (dtbVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), dtbVar)) {
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
                            if (checkTerminated(z3, z2, dtbVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                dtbVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                jtb.e(th);
                                dtbVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.ysb
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.ysb
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> O(int i, ktb ktbVar) {
        return new UnicastSubject<>(new State(i, ktbVar));
    }

    @Override // com.baidu.tieba.ysb
    public void onCompleted() {
        this.b.onCompleted();
    }
}
