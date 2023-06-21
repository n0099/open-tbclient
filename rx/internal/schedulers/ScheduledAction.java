package rx.internal.schedulers;

import com.baidu.tieba.dtb;
import com.baidu.tieba.nob;
import com.baidu.tieba.qsb;
import com.baidu.tieba.tob;
import com.baidu.tieba.uqb;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, nob {
    public static final long serialVersionUID = -3962399486978279857L;
    public final tob action;
    public final uqb cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements nob {
        public static final long serialVersionUID = 247232374289553518L;
        public final dtb parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, dtb dtbVar) {
            this.s = scheduledAction;
            this.parent = dtbVar;
        }

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements nob {
        public static final long serialVersionUID = 247232374289553518L;
        public final uqb parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, uqb uqbVar) {
            this.s = scheduledAction;
            this.parent = uqbVar;
        }

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements nob {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(tob tobVar) {
        this.action = tobVar;
        this.cancel = new uqb();
    }

    public void add(nob nobVar) {
        this.cancel.a(nobVar);
    }

    public void addParent(dtb dtbVar) {
        this.cancel.a(new Remover(this, dtbVar));
    }

    public void signalError(Throwable th) {
        qsb.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(tob tobVar, dtb dtbVar) {
        this.action = tobVar;
        this.cancel = new uqb(new Remover(this, dtbVar));
    }

    public ScheduledAction(tob tobVar, uqb uqbVar) {
        this.action = tobVar;
        this.cancel = new uqb(new Remover2(this, uqbVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(uqb uqbVar) {
        this.cancel.a(new Remover2(this, uqbVar));
    }

    @Override // com.baidu.tieba.nob
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

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
