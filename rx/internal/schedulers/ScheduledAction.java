package rx.internal.schedulers;

import com.baidu.tieba.frb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.sqb;
import com.baidu.tieba.vmb;
import com.baidu.tieba.wob;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, pmb {
    public static final long serialVersionUID = -3962399486978279857L;
    public final vmb action;
    public final wob cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements pmb {
        public static final long serialVersionUID = 247232374289553518L;
        public final frb parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, frb frbVar) {
            this.s = scheduledAction;
            this.parent = frbVar;
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements pmb {
        public static final long serialVersionUID = 247232374289553518L;
        public final wob parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, wob wobVar) {
            this.s = scheduledAction;
            this.parent = wobVar;
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements pmb {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(vmb vmbVar) {
        this.action = vmbVar;
        this.cancel = new wob();
    }

    public void add(pmb pmbVar) {
        this.cancel.a(pmbVar);
    }

    public void addParent(frb frbVar) {
        this.cancel.a(new Remover(this, frbVar));
    }

    public void signalError(Throwable th) {
        sqb.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(vmb vmbVar, frb frbVar) {
        this.action = vmbVar;
        this.cancel = new wob(new Remover(this, frbVar));
    }

    public ScheduledAction(vmb vmbVar, wob wobVar) {
        this.action = vmbVar;
        this.cancel = new wob(new Remover2(this, wobVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(wob wobVar) {
        this.cancel.a(new Remover2(this, wobVar));
    }

    @Override // com.baidu.tieba.pmb
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

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
