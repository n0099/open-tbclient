package rx.internal.schedulers;

import h.k;
import h.o.d.h;
import h.r.c;
import h.u.b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes7.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, k {
    public static final long serialVersionUID = -3962399486978279857L;
    public final h.n.a action;
    public final h cancel;

    /* loaded from: classes7.dex */
    public static final class Remover extends AtomicBoolean implements k {
        public static final long serialVersionUID = 247232374289553518L;
        public final b parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, b bVar) {
            this.s = scheduledAction;
            this.parent = bVar;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class Remover2 extends AtomicBoolean implements k {
        public static final long serialVersionUID = 247232374289553518L;
        public final h parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, h hVar) {
            this.s = scheduledAction;
            this.parent = hVar;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final Future<?> f69103e;

        public a(Future<?> future) {
            this.f69103e = future;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69103e.isCancelled();
        }

        @Override // h.k
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f69103e.cancel(true);
            } else {
                this.f69103e.cancel(false);
            }
        }
    }

    public ScheduledAction(h.n.a aVar) {
        this.action = aVar;
        this.cancel = new h();
    }

    public void add(k kVar) {
        this.cancel.a(kVar);
    }

    public void addParent(b bVar) {
        this.cancel.a(new Remover(this, bVar));
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } finally {
                unsubscribe();
            }
        } catch (OnErrorNotImplementedException e2) {
            signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e2));
        } catch (Throwable th) {
            signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
        }
    }

    public void signalError(Throwable th) {
        c.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(h hVar) {
        this.cancel.a(new Remover2(this, hVar));
    }

    public ScheduledAction(h.n.a aVar, b bVar) {
        this.action = aVar;
        this.cancel = new h(new Remover(this, bVar));
    }

    public ScheduledAction(h.n.a aVar, h hVar) {
        this.action = aVar;
        this.cancel = new h(new Remover2(this, hVar));
    }
}
