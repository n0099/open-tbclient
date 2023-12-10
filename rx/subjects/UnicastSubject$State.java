package rx.subjects;

import com.baidu.tieba.dpc;
import com.baidu.tieba.drc;
import com.baidu.tieba.dsc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.erc;
import com.baidu.tieba.esc;
import com.baidu.tieba.foc;
import com.baidu.tieba.goc;
import com.baidu.tieba.koc;
import com.baidu.tieba.ksc;
import com.baidu.tieba.loc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.roc;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject$State<T> extends AtomicLong implements goc, foc<T>, eoc.a<T>, loc {
    public static final long serialVersionUID = -9044104859202255786L;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<koc<? super T>> subscriber = new AtomicReference<>();
    public final AtomicReference<roc> terminateOnce;

    public UnicastSubject$State(int i, roc rocVar) {
        AtomicReference<roc> atomicReference;
        Queue<Object> drcVar;
        Queue<Object> queue;
        if (rocVar != null) {
            atomicReference = new AtomicReference<>(rocVar);
        } else {
            atomicReference = null;
        }
        this.terminateOnce = atomicReference;
        if (i > 1) {
            if (ksc.b()) {
                queue = new esc<>(i);
            } else {
                queue = new erc<>(i);
            }
        } else {
            if (ksc.b()) {
                drcVar = new dsc<>();
            } else {
                drcVar = new drc<>();
            }
            queue = drcVar;
        }
        this.queue = queue;
    }

    public void call(koc<? super T> kocVar) {
        if (this.subscriber.compareAndSet(null, kocVar)) {
            kocVar.b(this);
            kocVar.f(this);
            return;
        }
        kocVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }

    @Override // com.baidu.tieba.foc
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

    @Override // com.baidu.tieba.goc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                dpc.b(this, j);
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

    @Override // com.baidu.tieba.soc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((koc) ((koc) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, koc<? super T> kocVar) {
        if (kocVar.isUnsubscribed()) {
            this.queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                kocVar.onError(th);
                return true;
            } else if (z2) {
                kocVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void doTerminate() {
        roc rocVar;
        AtomicReference<roc> atomicReference = this.terminateOnce;
        if (atomicReference != null && (rocVar = atomicReference.get()) != null && atomicReference.compareAndSet(rocVar, null)) {
            rocVar.call();
        }
    }

    @Override // com.baidu.tieba.loc
    public boolean isUnsubscribed() {
        return this.done;
    }

    @Override // com.baidu.tieba.foc
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

    @Override // com.baidu.tieba.loc
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

    @Override // com.baidu.tieba.foc
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
            koc<? super T> kocVar = this.subscriber.get();
            try {
                kocVar.onNext(t);
            } catch (Throwable th) {
                qoc.g(th, kocVar, t);
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
                koc<? super T> kocVar = this.subscriber.get();
                if (kocVar != null) {
                    if (checkTerminated(this.done, queue.isEmpty(), kocVar)) {
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
                        if (checkTerminated(z3, z2, kocVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.e(poll);
                        try {
                            kocVar.onNext(obj);
                            j--;
                            j2++;
                        } catch (Throwable th) {
                            queue.clear();
                            qoc.e(th);
                            kocVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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
