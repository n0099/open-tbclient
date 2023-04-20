package rx.internal.schedulers;

import com.baidu.tieba.a2b;
import com.baidu.tieba.h6b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.u5b;
import com.baidu.tieba.y3b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, u1b {
    public static final long serialVersionUID = -3962399486978279857L;
    public final a2b action;
    public final y3b cancel;

    /* loaded from: classes9.dex */
    public static final class Remover extends AtomicBoolean implements u1b {
        public static final long serialVersionUID = 247232374289553518L;
        public final h6b parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, h6b h6bVar) {
            this.s = scheduledAction;
            this.parent = h6bVar;
        }

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Remover2 extends AtomicBoolean implements u1b {
        public static final long serialVersionUID = 247232374289553518L;
        public final y3b parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, y3b y3bVar) {
            this.s = scheduledAction;
            this.parent = y3bVar;
        }

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class a implements u1b {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(a2b a2bVar) {
        this.action = a2bVar;
        this.cancel = new y3b();
    }

    public void add(u1b u1bVar) {
        this.cancel.a(u1bVar);
    }

    public void addParent(h6b h6bVar) {
        this.cancel.a(new Remover(this, h6bVar));
    }

    public void signalError(Throwable th) {
        u5b.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(a2b a2bVar, h6b h6bVar) {
        this.action = a2bVar;
        this.cancel = new y3b(new Remover(this, h6bVar));
    }

    public ScheduledAction(a2b a2bVar, y3b y3bVar) {
        this.action = a2bVar;
        this.cancel = new y3b(new Remover2(this, y3bVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(y3b y3bVar) {
        this.cancel.a(new Remover2(this, y3bVar));
    }

    @Override // com.baidu.tieba.u1b
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
        } catch (OnErrorNotImplementedException e) {
            signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
        } catch (Throwable th) {
            signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
        }
    }

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
