package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.f;
import rx.internal.util.a.ae;
import rx.internal.util.a.x;
import rx.j;
/* loaded from: classes2.dex */
public final class QueuedProducer<T> extends AtomicLong implements e<T>, f {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final j<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(j<? super T> jVar) {
        this(jVar, ae.cPs() ? new x() : new rx.internal.util.atomic.e());
    }

    public QueuedProducer(j<? super T> jVar, Queue<Object> queue) {
        this.child = jVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    @Override // rx.f
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j > 0) {
            rx.internal.operators.a.a(this, j);
            drain();
        }
    }

    public boolean offer(T t) {
        if (t == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // rx.e
    public void onNext(T t) {
        if (!offer(t)) {
            onError(new MissingBackpressureException());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.e
    public void onCompleted() {
        this.done = true;
        drain();
    }

    private boolean checkTerminated(boolean z, boolean z2) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                this.child.onError(th);
                return true;
            } else if (z2) {
                this.child.onCompleted();
                return true;
            }
        }
        return false;
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            j<? super T> jVar = this.child;
            Queue<Object> queue = this.queue;
            while (!checkTerminated(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0) {
                    boolean z = this.done;
                    Object poll = queue.poll();
                    if (!checkTerminated(z, poll == null)) {
                        if (poll == null) {
                            break;
                        }
                        try {
                            if (poll == NULL_SENTINEL) {
                                jVar.onNext(null);
                            } else {
                                jVar.onNext(poll);
                            }
                            j--;
                            j2 = 1 + j2;
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, jVar, poll != NULL_SENTINEL ? poll : null);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j2 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j2);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}
