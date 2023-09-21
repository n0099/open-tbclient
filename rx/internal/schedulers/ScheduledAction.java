package rx.internal.schedulers;

import com.baidu.tieba.cfc;
import com.baidu.tieba.lhc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.xcc;
import com.baidu.tieba.ygc;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, rcc {
    public static final long serialVersionUID = -3962399486978279857L;
    public final xcc action;
    public final cfc cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements rcc {
        public static final long serialVersionUID = 247232374289553518L;
        public final lhc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, lhc lhcVar) {
            this.s = scheduledAction;
            this.parent = lhcVar;
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements rcc {
        public static final long serialVersionUID = 247232374289553518L;
        public final cfc parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, cfc cfcVar) {
            this.s = scheduledAction;
            this.parent = cfcVar;
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements rcc {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(xcc xccVar) {
        this.action = xccVar;
        this.cancel = new cfc();
    }

    public void add(rcc rccVar) {
        this.cancel.a(rccVar);
    }

    public void addParent(cfc cfcVar) {
        this.cancel.a(new Remover2(this, cfcVar));
    }

    public void signalError(Throwable th) {
        ygc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(xcc xccVar, cfc cfcVar) {
        this.action = xccVar;
        this.cancel = new cfc(new Remover2(this, cfcVar));
    }

    public ScheduledAction(xcc xccVar, lhc lhcVar) {
        this.action = xccVar;
        this.cancel = new cfc(new Remover(this, lhcVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(lhc lhcVar) {
        this.cancel.a(new Remover(this, lhcVar));
    }

    @Override // com.baidu.tieba.rcc
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

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
