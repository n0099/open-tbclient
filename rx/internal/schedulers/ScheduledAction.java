package rx.internal.schedulers;

import com.baidu.tieba.dmc;
import com.baidu.tieba.moc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.wjc;
import com.baidu.tieba.znc;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, qjc {
    public static final long serialVersionUID = -3962399486978279857L;
    public final wjc action;
    public final dmc cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements qjc {
        public static final long serialVersionUID = 247232374289553518L;
        public final moc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, moc mocVar) {
            this.s = scheduledAction;
            this.parent = mocVar;
        }

        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements qjc {
        public static final long serialVersionUID = 247232374289553518L;
        public final dmc parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, dmc dmcVar) {
            this.s = scheduledAction;
            this.parent = dmcVar;
        }

        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements qjc {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(wjc wjcVar) {
        this.action = wjcVar;
        this.cancel = new dmc();
    }

    public void add(qjc qjcVar) {
        this.cancel.a(qjcVar);
    }

    public void addParent(dmc dmcVar) {
        this.cancel.a(new Remover2(this, dmcVar));
    }

    public void signalError(Throwable th) {
        znc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(wjc wjcVar, dmc dmcVar) {
        this.action = wjcVar;
        this.cancel = new dmc(new Remover2(this, dmcVar));
    }

    public ScheduledAction(wjc wjcVar, moc mocVar) {
        this.action = wjcVar;
        this.cancel = new dmc(new Remover(this, mocVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(moc mocVar) {
        this.cancel.a(new Remover(this, mocVar));
    }

    @Override // com.baidu.tieba.qjc
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

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
