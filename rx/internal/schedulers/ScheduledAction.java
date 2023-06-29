package rx.internal.schedulers;

import com.baidu.tieba.etb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.kxb;
import com.baidu.tieba.ovb;
import com.baidu.tieba.xxb;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, etb {
    public static final long serialVersionUID = -3962399486978279857L;
    public final ktb action;
    public final ovb cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements etb {
        public static final long serialVersionUID = 247232374289553518L;
        public final xxb parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, xxb xxbVar) {
            this.s = scheduledAction;
            this.parent = xxbVar;
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements etb {
        public static final long serialVersionUID = 247232374289553518L;
        public final ovb parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, ovb ovbVar) {
            this.s = scheduledAction;
            this.parent = ovbVar;
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements etb {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(ktb ktbVar) {
        this.action = ktbVar;
        this.cancel = new ovb();
    }

    public void add(etb etbVar) {
        this.cancel.a(etbVar);
    }

    public void addParent(ovb ovbVar) {
        this.cancel.a(new Remover2(this, ovbVar));
    }

    public void signalError(Throwable th) {
        kxb.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(ktb ktbVar, ovb ovbVar) {
        this.action = ktbVar;
        this.cancel = new ovb(new Remover2(this, ovbVar));
    }

    public ScheduledAction(ktb ktbVar, xxb xxbVar) {
        this.action = ktbVar;
        this.cancel = new ovb(new Remover(this, xxbVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(xxb xxbVar) {
        this.cancel.a(new Remover(this, xxbVar));
    }

    @Override // com.baidu.tieba.etb
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

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
