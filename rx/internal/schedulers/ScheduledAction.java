package rx.internal.schedulers;

import com.baidu.tieba.dpa;
import com.baidu.tieba.fna;
import com.baidu.tieba.mra;
import com.baidu.tieba.zma;
import com.baidu.tieba.zqa;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, zma {
    public static final long serialVersionUID = -3962399486978279857L;
    public final fna action;
    public final dpa cancel;

    /* loaded from: classes9.dex */
    public static final class Remover extends AtomicBoolean implements zma {
        public static final long serialVersionUID = 247232374289553518L;
        public final mra parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, mra mraVar) {
            this.s = scheduledAction;
            this.parent = mraVar;
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Remover2 extends AtomicBoolean implements zma {
        public static final long serialVersionUID = 247232374289553518L;
        public final dpa parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, dpa dpaVar) {
            this.s = scheduledAction;
            this.parent = dpaVar;
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class a implements zma {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(fna fnaVar) {
        this.action = fnaVar;
        this.cancel = new dpa();
    }

    public void add(zma zmaVar) {
        this.cancel.a(zmaVar);
    }

    public void addParent(dpa dpaVar) {
        this.cancel.a(new Remover2(this, dpaVar));
    }

    public void signalError(Throwable th) {
        zqa.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(fna fnaVar, dpa dpaVar) {
        this.action = fnaVar;
        this.cancel = new dpa(new Remover2(this, dpaVar));
    }

    public ScheduledAction(fna fnaVar, mra mraVar) {
        this.action = fnaVar;
        this.cancel = new dpa(new Remover(this, mraVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(mra mraVar) {
        this.cancel.a(new Remover(this, mraVar));
    }

    @Override // com.baidu.tieba.zma
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

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
