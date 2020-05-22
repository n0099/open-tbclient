package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
import rx.k;
/* loaded from: classes6.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, k {
    private static final long serialVersionUID = -3962399486978279857L;
    final rx.functions.a action;
    final rx.internal.util.i cancel;

    public ScheduledAction(rx.functions.a aVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.i();
    }

    public ScheduledAction(rx.functions.a aVar, rx.subscriptions.b bVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.i(new Remover(this, bVar));
    }

    public ScheduledAction(rx.functions.a aVar, rx.internal.util.i iVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.i(new Remover2(this, iVar));
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } catch (OnErrorNotImplementedException e) {
                signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
            }
        } finally {
            unsubscribe();
        }
    }

    void signalError(Throwable th) {
        rx.c.c.onError(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }

    public void add(k kVar) {
        this.cancel.add(kVar);
    }

    public void add(Future<?> future) {
        this.cancel.add(new a(future));
    }

    public void addParent(rx.subscriptions.b bVar) {
        this.cancel.add(new Remover(this, bVar));
    }

    public void addParent(rx.internal.util.i iVar) {
        this.cancel.add(new Remover2(this, iVar));
    }

    /* loaded from: classes6.dex */
    final class a implements k {
        private final Future<?> nID;

        a(Future<?> future) {
            this.nID = future;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.nID.cancel(true);
            } else {
                this.nID.cancel(false);
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nID.isCancelled();
        }
    }

    /* loaded from: classes6.dex */
    static final class Remover extends AtomicBoolean implements k {
        private static final long serialVersionUID = 247232374289553518L;
        final rx.subscriptions.b parent;
        final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, rx.subscriptions.b bVar) {
            this.s = scheduledAction;
            this.parent = bVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.a(this.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class Remover2 extends AtomicBoolean implements k {
        private static final long serialVersionUID = 247232374289553518L;
        final rx.internal.util.i parent;
        final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, rx.internal.util.i iVar) {
            this.s = scheduledAction;
            this.parent = iVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.a(this.s);
            }
        }
    }
}
