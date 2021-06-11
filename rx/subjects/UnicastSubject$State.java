package rx.subjects;

import h.d;
import h.e;
import h.f;
import h.j;
import h.k;
import h.n.a;
import h.o.d.j.f0;
import h.o.d.j.y;
import h.o.d.j.z;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public final class UnicastSubject$State<T> extends AtomicLong implements f, e<T>, d.a<T>, k {
    public static final long serialVersionUID = -9044104859202255786L;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<j<? super T>> subscriber = new AtomicReference<>();
    public final AtomicReference<a> terminateOnce;

    public UnicastSubject$State(int i2, a aVar) {
        Queue<Object> yVar;
        this.terminateOnce = aVar != null ? new AtomicReference<>(aVar) : null;
        if (i2 > 1) {
            yVar = f0.b() ? new z<>(i2) : new h.o.d.i.f<>(i2);
        } else {
            yVar = f0.b() ? new y<>() : new h.o.d.i.e<>();
        }
        this.queue = yVar;
    }

    @Override // h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, j<? super T> jVar) {
        if (jVar.isUnsubscribed()) {
            this.queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                jVar.onError(th);
                return true;
            } else if (z2) {
                jVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void doTerminate() {
        a aVar;
        AtomicReference<a> atomicReference = this.terminateOnce;
        if (atomicReference == null || (aVar = atomicReference.get()) == null || !atomicReference.compareAndSet(aVar, null)) {
            return;
        }
        aVar.call();
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.done;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.done) {
            return;
        }
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

    @Override // h.e
    public void onError(Throwable th) {
        if (this.done) {
            return;
        }
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

    @Override // h.e
    public void onNext(T t) {
        if (this.done) {
            return;
        }
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
        j<? super T> jVar = this.subscriber.get();
        try {
            jVar.onNext(t);
        } catch (Throwable th) {
            h.m.a.g(th, jVar, t);
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
        synchronized (this) {
            if (this.emitting) {
                this.missed = true;
                return;
            }
            this.emitting = true;
            Queue<Object> queue = this.queue;
            while (true) {
                j<? super T> jVar = this.subscriber.get();
                if (jVar == null) {
                    z = false;
                } else if (checkTerminated(this.done, queue.isEmpty(), jVar)) {
                    return;
                } else {
                    long j = get();
                    z = j == Long.MAX_VALUE;
                    long j2 = 0;
                    while (j != 0) {
                        boolean z2 = this.done;
                        Object poll = queue.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, jVar)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.e(poll);
                        try {
                            jVar.onNext(obj);
                            j--;
                            j2++;
                        } catch (Throwable th) {
                            queue.clear();
                            h.m.a.e(th);
                            jVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                            return;
                        }
                    }
                    if (!z && j2 != 0) {
                        addAndGet(-j2);
                    }
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

    @Override // h.f
    public void request(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (i2 > 0) {
            h.o.a.a.b(this, j);
            replay();
        } else if (this.done) {
            replay();
        }
    }

    @Override // h.k
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

    public void call(j<? super T> jVar) {
        if (this.subscriber.compareAndSet(null, jVar)) {
            jVar.add(this);
            jVar.setProducer(this);
            return;
        }
        jVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }
}
