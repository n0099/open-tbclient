package rx.subjects;

import com.baidu.tieba.g7c;
import com.baidu.tieba.g9c;
import com.baidu.tieba.gac;
import com.baidu.tieba.h6c;
import com.baidu.tieba.h9c;
import com.baidu.tieba.hac;
import com.baidu.tieba.i6c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.nac;
import com.baidu.tieba.o6c;
import com.baidu.tieba.t6c;
import com.baidu.tieba.u6c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject$State<T> extends AtomicLong implements j6c, i6c<T>, h6c.a<T>, o6c {
    public static final long serialVersionUID = -9044104859202255786L;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<n6c<? super T>> subscriber = new AtomicReference<>();
    public final AtomicReference<u6c> terminateOnce;

    public UnicastSubject$State(int i, u6c u6cVar) {
        AtomicReference<u6c> atomicReference;
        Queue<Object> g9cVar;
        Queue<Object> queue;
        if (u6cVar != null) {
            atomicReference = new AtomicReference<>(u6cVar);
        } else {
            atomicReference = null;
        }
        this.terminateOnce = atomicReference;
        if (i > 1) {
            if (nac.b()) {
                queue = new hac<>(i);
            } else {
                queue = new h9c<>(i);
            }
        } else {
            if (nac.b()) {
                g9cVar = new gac<>();
            } else {
                g9cVar = new g9c<>();
            }
            queue = g9cVar;
        }
        this.queue = queue;
    }

    public void call(n6c<? super T> n6cVar) {
        if (this.subscriber.compareAndSet(null, n6cVar)) {
            n6cVar.b(this);
            n6cVar.f(this);
            return;
        }
        n6cVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }

    @Override // com.baidu.tieba.i6c
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

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                g7c.b(this, j);
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

    @Override // com.baidu.tieba.v6c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n6c) ((n6c) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, n6c<? super T> n6cVar) {
        if (n6cVar.isUnsubscribed()) {
            this.queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                n6cVar.onError(th);
                return true;
            } else if (z2) {
                n6cVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void doTerminate() {
        u6c u6cVar;
        AtomicReference<u6c> atomicReference = this.terminateOnce;
        if (atomicReference != null && (u6cVar = atomicReference.get()) != null && atomicReference.compareAndSet(u6cVar, null)) {
            u6cVar.call();
        }
    }

    @Override // com.baidu.tieba.o6c
    public boolean isUnsubscribed() {
        return this.done;
    }

    @Override // com.baidu.tieba.i6c
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

    @Override // com.baidu.tieba.o6c
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

    @Override // com.baidu.tieba.i6c
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
            n6c<? super T> n6cVar = this.subscriber.get();
            try {
                n6cVar.onNext(t);
            } catch (Throwable th) {
                t6c.g(th, n6cVar, t);
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
                n6c<? super T> n6cVar = this.subscriber.get();
                if (n6cVar != null) {
                    if (checkTerminated(this.done, queue.isEmpty(), n6cVar)) {
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
                        if (checkTerminated(z3, z2, n6cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.e(poll);
                        try {
                            n6cVar.onNext(obj);
                            j--;
                            j2++;
                        } catch (Throwable th) {
                            queue.clear();
                            t6c.e(th);
                            n6cVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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
