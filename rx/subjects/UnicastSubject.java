package rx.subjects;

import com.baidu.tieba.arb;
import com.baidu.tieba.asb;
import com.baidu.tieba.bpb;
import com.baidu.tieba.btb;
import com.baidu.tieba.gob;
import com.baidu.tieba.gsb;
import com.baidu.tieba.hob;
import com.baidu.tieba.iob;
import com.baidu.tieba.mob;
import com.baidu.tieba.nob;
import com.baidu.tieba.sob;
import com.baidu.tieba.tob;
import com.baidu.tieba.zqb;
import com.baidu.tieba.zrb;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends btb<T, T> {
    public final State<T> b;

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicLong implements iob, hob<T>, gob.a<T>, nob {
        public static final long serialVersionUID = -9044104859202255786L;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<mob<? super T>> subscriber = new AtomicReference<>();
        public final AtomicReference<tob> terminateOnce;

        public State(int i, tob tobVar) {
            AtomicReference<tob> atomicReference;
            Queue<Object> zqbVar;
            Queue<Object> queue;
            if (tobVar != null) {
                atomicReference = new AtomicReference<>(tobVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (gsb.b()) {
                    queue = new asb<>(i);
                } else {
                    queue = new arb<>(i);
                }
            } else {
                if (gsb.b()) {
                    zqbVar = new zrb<>();
                } else {
                    zqbVar = new zqb<>();
                }
                queue = zqbVar;
            }
            this.queue = queue;
        }

        public void call(mob<? super T> mobVar) {
            if (this.subscriber.compareAndSet(null, mobVar)) {
                mobVar.b(this);
                mobVar.f(this);
                return;
            }
            mobVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        @Override // com.baidu.tieba.hob
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

        @Override // com.baidu.tieba.iob
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    bpb.b(this, j);
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

        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mob) ((mob) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, mob<? super T> mobVar) {
            if (mobVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    mobVar.onError(th);
                    return true;
                } else if (z2) {
                    mobVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void doTerminate() {
            tob tobVar;
            AtomicReference<tob> atomicReference = this.terminateOnce;
            if (atomicReference != null && (tobVar = atomicReference.get()) != null && atomicReference.compareAndSet(tobVar, null)) {
                tobVar.call();
            }
        }

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // com.baidu.tieba.hob
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

        @Override // com.baidu.tieba.nob
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

        @Override // com.baidu.tieba.hob
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
                mob<? super T> mobVar = this.subscriber.get();
                try {
                    mobVar.onNext(t);
                } catch (Throwable th) {
                    sob.g(th, mobVar, t);
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
                    mob<? super T> mobVar = this.subscriber.get();
                    if (mobVar != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), mobVar)) {
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
                            if (checkTerminated(z3, z2, mobVar)) {
                                return;
                            }
                            if (z2) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                mobVar.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                sob.e(th);
                                mobVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

    @Override // com.baidu.tieba.hob
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.hob
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> UnicastSubject<T> H(int i, tob tobVar) {
        return new UnicastSubject<>(new State(i, tobVar));
    }

    @Override // com.baidu.tieba.hob
    public void onCompleted() {
        this.b.onCompleted();
    }
}
