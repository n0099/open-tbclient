package rx.internal.schedulers;

import com.baidu.tieba.b9c;
import com.baidu.tieba.kbc;
import com.baidu.tieba.o6c;
import com.baidu.tieba.u6c;
import com.baidu.tieba.xac;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, o6c {
    public static final long serialVersionUID = -3962399486978279857L;
    public final u6c action;
    public final b9c cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements o6c {
        public static final long serialVersionUID = 247232374289553518L;
        public final kbc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, kbc kbcVar) {
            this.s = scheduledAction;
            this.parent = kbcVar;
        }

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements o6c {
        public static final long serialVersionUID = 247232374289553518L;
        public final b9c parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, b9c b9cVar) {
            this.s = scheduledAction;
            this.parent = b9cVar;
        }

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements o6c {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(u6c u6cVar) {
        this.action = u6cVar;
        this.cancel = new b9c();
    }

    public void add(o6c o6cVar) {
        this.cancel.a(o6cVar);
    }

    public void addParent(b9c b9cVar) {
        this.cancel.a(new Remover2(this, b9cVar));
    }

    public void signalError(Throwable th) {
        xac.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(u6c u6cVar, b9c b9cVar) {
        this.action = u6cVar;
        this.cancel = new b9c(new Remover2(this, b9cVar));
    }

    public ScheduledAction(u6c u6cVar, kbc kbcVar) {
        this.action = u6cVar;
        this.cancel = new b9c(new Remover(this, kbcVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(kbc kbcVar) {
        this.cancel.a(new Remover(this, kbcVar));
    }

    @Override // com.baidu.tieba.o6c
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

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
