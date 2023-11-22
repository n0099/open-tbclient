package rx.subjects;

import com.baidu.tieba.ikc;
import com.baidu.tieba.imc;
import com.baidu.tieba.inc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.jmc;
import com.baidu.tieba.jnc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.pnc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.vjc;
import com.baidu.tieba.wjc;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject$State<T> extends AtomicLong implements ljc, kjc<T>, jjc.a<T>, qjc {
    public static final long serialVersionUID = -9044104859202255786L;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<pjc<? super T>> subscriber = new AtomicReference<>();
    public final AtomicReference<wjc> terminateOnce;

    public UnicastSubject$State(int i, wjc wjcVar) {
        AtomicReference<wjc> atomicReference;
        Queue<Object> imcVar;
        Queue<Object> queue;
        if (wjcVar != null) {
            atomicReference = new AtomicReference<>(wjcVar);
        } else {
            atomicReference = null;
        }
        this.terminateOnce = atomicReference;
        if (i > 1) {
            if (pnc.b()) {
                queue = new jnc<>(i);
            } else {
                queue = new jmc<>(i);
            }
        } else {
            if (pnc.b()) {
                imcVar = new inc<>();
            } else {
                imcVar = new imc<>();
            }
            queue = imcVar;
        }
        this.queue = queue;
    }

    public void call(pjc<? super T> pjcVar) {
        if (this.subscriber.compareAndSet(null, pjcVar)) {
            pjcVar.b(this);
            pjcVar.f(this);
            return;
        }
        pjcVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }

    @Override // com.baidu.tieba.kjc
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

    @Override // com.baidu.tieba.ljc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                ikc.b(this, j);
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

    @Override // com.baidu.tieba.xjc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((pjc) ((pjc) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, pjc<? super T> pjcVar) {
        if (pjcVar.isUnsubscribed()) {
            this.queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                pjcVar.onError(th);
                return true;
            } else if (z2) {
                pjcVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void doTerminate() {
        wjc wjcVar;
        AtomicReference<wjc> atomicReference = this.terminateOnce;
        if (atomicReference != null && (wjcVar = atomicReference.get()) != null && atomicReference.compareAndSet(wjcVar, null)) {
            wjcVar.call();
        }
    }

    @Override // com.baidu.tieba.qjc
    public boolean isUnsubscribed() {
        return this.done;
    }

    @Override // com.baidu.tieba.kjc
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

    @Override // com.baidu.tieba.qjc
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

    @Override // com.baidu.tieba.kjc
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
            pjc<? super T> pjcVar = this.subscriber.get();
            try {
                pjcVar.onNext(t);
            } catch (Throwable th) {
                vjc.g(th, pjcVar, t);
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
                pjc<? super T> pjcVar = this.subscriber.get();
                if (pjcVar != null) {
                    if (checkTerminated(this.done, queue.isEmpty(), pjcVar)) {
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
                        if (checkTerminated(z3, z2, pjcVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.e(poll);
                        try {
                            pjcVar.onNext(obj);
                            j--;
                            j2++;
                        } catch (Throwable th) {
                            queue.clear();
                            vjc.e(th);
                            pjcVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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
