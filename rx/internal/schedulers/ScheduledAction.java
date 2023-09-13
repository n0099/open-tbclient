package rx.internal.schedulers;

import com.baidu.tieba.fbc;
import com.baidu.tieba.gfc;
import com.baidu.tieba.kdc;
import com.baidu.tieba.tfc;
import com.baidu.tieba.zac;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, zac {
    public static final long serialVersionUID = -3962399486978279857L;
    public final fbc action;
    public final kdc cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements zac {
        public static final long serialVersionUID = 247232374289553518L;
        public final tfc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, tfc tfcVar) {
            this.s = scheduledAction;
            this.parent = tfcVar;
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements zac {
        public static final long serialVersionUID = 247232374289553518L;
        public final kdc parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, kdc kdcVar) {
            this.s = scheduledAction;
            this.parent = kdcVar;
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements zac {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(fbc fbcVar) {
        this.action = fbcVar;
        this.cancel = new kdc();
    }

    public void add(zac zacVar) {
        this.cancel.a(zacVar);
    }

    public void addParent(kdc kdcVar) {
        this.cancel.a(new Remover2(this, kdcVar));
    }

    public void signalError(Throwable th) {
        gfc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(fbc fbcVar, kdc kdcVar) {
        this.action = fbcVar;
        this.cancel = new kdc(new Remover2(this, kdcVar));
    }

    public ScheduledAction(fbc fbcVar, tfc tfcVar) {
        this.action = fbcVar;
        this.cancel = new kdc(new Remover(this, tfcVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(tfc tfcVar) {
        this.cancel.a(new Remover(this, tfcVar));
    }

    @Override // com.baidu.tieba.zac
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

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
