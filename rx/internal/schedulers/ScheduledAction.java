package rx.internal.schedulers;

import com.baidu.tieba.b2c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.l4c;
import com.baidu.tieba.u6c;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, b2c {
    public static final long serialVersionUID = -3962399486978279857L;
    public final h2c action;
    public final l4c cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements b2c {
        public static final long serialVersionUID = 247232374289553518L;
        public final u6c parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, u6c u6cVar) {
            this.s = scheduledAction;
            this.parent = u6cVar;
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements b2c {
        public static final long serialVersionUID = 247232374289553518L;
        public final l4c parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, l4c l4cVar) {
            this.s = scheduledAction;
            this.parent = l4cVar;
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements b2c {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(h2c h2cVar) {
        this.action = h2cVar;
        this.cancel = new l4c();
    }

    public void add(b2c b2cVar) {
        this.cancel.a(b2cVar);
    }

    public void addParent(l4c l4cVar) {
        this.cancel.a(new Remover2(this, l4cVar));
    }

    public void signalError(Throwable th) {
        h6c.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(h2c h2cVar, l4c l4cVar) {
        this.action = h2cVar;
        this.cancel = new l4c(new Remover2(this, l4cVar));
    }

    public ScheduledAction(h2c h2cVar, u6c u6cVar) {
        this.action = h2cVar;
        this.cancel = new l4c(new Remover(this, u6cVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(u6c u6cVar) {
        this.cancel.a(new Remover(this, u6cVar));
    }

    @Override // com.baidu.tieba.b2c
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

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
