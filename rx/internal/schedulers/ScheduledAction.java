package rx.internal.schedulers;

import com.baidu.tieba.a8c;
import com.baidu.tieba.bcc;
import com.baidu.tieba.fac;
import com.baidu.tieba.occ;
import com.baidu.tieba.u7c;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, u7c {
    public static final long serialVersionUID = -3962399486978279857L;
    public final a8c action;
    public final fac cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements u7c {
        public static final long serialVersionUID = 247232374289553518L;
        public final occ parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, occ occVar) {
            this.s = scheduledAction;
            this.parent = occVar;
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements u7c {
        public static final long serialVersionUID = 247232374289553518L;
        public final fac parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, fac facVar) {
            this.s = scheduledAction;
            this.parent = facVar;
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements u7c {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(a8c a8cVar) {
        this.action = a8cVar;
        this.cancel = new fac();
    }

    public void add(u7c u7cVar) {
        this.cancel.a(u7cVar);
    }

    public void addParent(fac facVar) {
        this.cancel.a(new Remover2(this, facVar));
    }

    public void signalError(Throwable th) {
        bcc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(a8c a8cVar, fac facVar) {
        this.action = a8cVar;
        this.cancel = new fac(new Remover2(this, facVar));
    }

    public ScheduledAction(a8c a8cVar, occ occVar) {
        this.action = a8cVar;
        this.cancel = new fac(new Remover(this, occVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(occ occVar) {
        this.cancel.a(new Remover(this, occVar));
    }

    @Override // com.baidu.tieba.u7c
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

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
