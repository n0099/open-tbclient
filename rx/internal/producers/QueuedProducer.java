package rx.internal.producers;

import h.e;
import h.f;
import h.j;
import h.m.a;
import h.o.d.j.f0;
import h.o.d.j.y;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class QueuedProducer<T> extends AtomicLong implements f, e<T> {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final j<? super T> child;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    public QueuedProducer(j<? super T> jVar) {
        this(jVar, f0.b() ? new y() : new h.o.d.i.e());
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
            } else {
                return false;
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
                    if (checkTerminated(z, poll == null)) {
                        return;
                    }
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
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        a.g(th, jVar, poll);
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

    @Override // h.e
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // h.e
    public void onNext(T t) {
        if (offer(t)) {
            return;
        }
        onError(new MissingBackpressureException());
    }

    @Override // h.f
    public void request(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (i2 > 0) {
            h.o.a.a.b(this, j);
            drain();
        }
    }

    public QueuedProducer(j<? super T> jVar, Queue<Object> queue) {
        this.child = jVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
