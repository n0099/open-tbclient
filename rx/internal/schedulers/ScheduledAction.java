package rx.internal.schedulers;

import com.baidu.tieba.gtc;
import com.baidu.tieba.koc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.xqc;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, koc {
    public static final long serialVersionUID = -3962399486978279857L;
    public final qoc action;
    public final xqc cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements koc {
        public static final long serialVersionUID = 247232374289553518L;
        public final gtc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, gtc gtcVar) {
            this.s = scheduledAction;
            this.parent = gtcVar;
        }

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements koc {
        public static final long serialVersionUID = 247232374289553518L;
        public final xqc parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, xqc xqcVar) {
            this.s = scheduledAction;
            this.parent = xqcVar;
        }

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements koc {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(qoc qocVar) {
        this.action = qocVar;
        this.cancel = new xqc();
    }

    public void add(koc kocVar) {
        this.cancel.a(kocVar);
    }

    public void addParent(gtc gtcVar) {
        this.cancel.a(new Remover(this, gtcVar));
    }

    public void signalError(Throwable th) {
        tsc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(qoc qocVar, gtc gtcVar) {
        this.action = qocVar;
        this.cancel = new xqc(new Remover(this, gtcVar));
    }

    public ScheduledAction(qoc qocVar, xqc xqcVar) {
        this.action = qocVar;
        this.cancel = new xqc(new Remover2(this, xqcVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(xqc xqcVar) {
        this.cancel.a(new Remover2(this, xqcVar));
    }

    @Override // com.baidu.tieba.koc
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

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
