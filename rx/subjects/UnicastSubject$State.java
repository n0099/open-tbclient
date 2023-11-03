package rx.subjects;

import com.baidu.tieba.hkc;
import com.baidu.tieba.hmc;
import com.baidu.tieba.hnc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.imc;
import com.baidu.tieba.inc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.onc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.ujc;
import com.baidu.tieba.vjc;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject$State<T> extends AtomicLong implements kjc, jjc<T>, ijc.a<T>, pjc {
    public static final long serialVersionUID = -9044104859202255786L;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<ojc<? super T>> subscriber = new AtomicReference<>();
    public final AtomicReference<vjc> terminateOnce;

    public UnicastSubject$State(int i, vjc vjcVar) {
        AtomicReference<vjc> atomicReference;
        Queue<Object> hmcVar;
        Queue<Object> queue;
        if (vjcVar != null) {
            atomicReference = new AtomicReference<>(vjcVar);
        } else {
            atomicReference = null;
        }
        this.terminateOnce = atomicReference;
        if (i > 1) {
            if (onc.b()) {
                queue = new inc<>(i);
            } else {
                queue = new imc<>(i);
            }
        } else {
            if (onc.b()) {
                hmcVar = new hnc<>();
            } else {
                hmcVar = new hmc<>();
            }
            queue = hmcVar;
        }
        this.queue = queue;
    }

    public void call(ojc<? super T> ojcVar) {
        if (this.subscriber.compareAndSet(null, ojcVar)) {
            ojcVar.b(this);
            ojcVar.f(this);
            return;
        }
        ojcVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }

    @Override // com.baidu.tieba.jjc
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

    @Override // com.baidu.tieba.kjc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                hkc.b(this, j);
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

    @Override // com.baidu.tieba.wjc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ojc) ((ojc) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, ojc<? super T> ojcVar) {
        if (ojcVar.isUnsubscribed()) {
            this.queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                ojcVar.onError(th);
                return true;
            } else if (z2) {
                ojcVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void doTerminate() {
        vjc vjcVar;
        AtomicReference<vjc> atomicReference = this.terminateOnce;
        if (atomicReference != null && (vjcVar = atomicReference.get()) != null && atomicReference.compareAndSet(vjcVar, null)) {
            vjcVar.call();
        }
    }

    @Override // com.baidu.tieba.pjc
    public boolean isUnsubscribed() {
        return this.done;
    }

    @Override // com.baidu.tieba.jjc
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

    @Override // com.baidu.tieba.pjc
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

    @Override // com.baidu.tieba.jjc
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
            ojc<? super T> ojcVar = this.subscriber.get();
            try {
                ojcVar.onNext(t);
            } catch (Throwable th) {
                ujc.g(th, ojcVar, t);
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
                ojc<? super T> ojcVar = this.subscriber.get();
                if (ojcVar != null) {
                    if (checkTerminated(this.done, queue.isEmpty(), ojcVar)) {
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
                        if (checkTerminated(z3, z2, ojcVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.e(poll);
                        try {
                            ojcVar.onNext(obj);
                            j--;
                            j2++;
                        } catch (Throwable th) {
                            queue.clear();
                            ujc.e(th);
                            ojcVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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
