package rx.internal.schedulers;

import com.baidu.tieba.htc;
import com.baidu.tieba.loc;
import com.baidu.tieba.roc;
import com.baidu.tieba.usc;
import com.baidu.tieba.yqc;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, loc {
    public static final long serialVersionUID = -3962399486978279857L;
    public final roc action;
    public final yqc cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements loc {
        public static final long serialVersionUID = 247232374289553518L;
        public final htc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, htc htcVar) {
            this.s = scheduledAction;
            this.parent = htcVar;
        }

        @Override // com.baidu.tieba.loc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.loc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements loc {
        public static final long serialVersionUID = 247232374289553518L;
        public final yqc parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, yqc yqcVar) {
            this.s = scheduledAction;
            this.parent = yqcVar;
        }

        @Override // com.baidu.tieba.loc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.loc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements loc {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.loc
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.loc
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(roc rocVar) {
        this.action = rocVar;
        this.cancel = new yqc();
    }

    public void add(loc locVar) {
        this.cancel.a(locVar);
    }

    public void addParent(htc htcVar) {
        this.cancel.a(new Remover(this, htcVar));
    }

    public void signalError(Throwable th) {
        usc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(roc rocVar, htc htcVar) {
        this.action = rocVar;
        this.cancel = new yqc(new Remover(this, htcVar));
    }

    public ScheduledAction(roc rocVar, yqc yqcVar) {
        this.action = rocVar;
        this.cancel = new yqc(new Remover2(this, yqcVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(yqc yqcVar) {
        this.cancel.a(new Remover2(this, yqcVar));
    }

    @Override // com.baidu.tieba.loc
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

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
