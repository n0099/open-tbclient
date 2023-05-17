package rx.internal.schedulers;

import com.baidu.tieba.ecb;
import com.baidu.tieba.o7b;
import com.baidu.tieba.rbb;
import com.baidu.tieba.u7b;
import com.baidu.tieba.v9b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes10.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, o7b {
    public static final long serialVersionUID = -3962399486978279857L;
    public final u7b action;
    public final v9b cancel;

    /* loaded from: classes10.dex */
    public static final class Remover extends AtomicBoolean implements o7b {
        public static final long serialVersionUID = 247232374289553518L;
        public final ecb parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, ecb ecbVar) {
            this.s = scheduledAction;
            this.parent = ecbVar;
        }

        @Override // com.baidu.tieba.o7b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.o7b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class Remover2 extends AtomicBoolean implements o7b {
        public static final long serialVersionUID = 247232374289553518L;
        public final v9b parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, v9b v9bVar) {
            this.s = scheduledAction;
            this.parent = v9bVar;
        }

        @Override // com.baidu.tieba.o7b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.o7b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes10.dex */
    public final class a implements o7b {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.o7b
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.o7b
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(u7b u7bVar) {
        this.action = u7bVar;
        this.cancel = new v9b();
    }

    public void add(o7b o7bVar) {
        this.cancel.a(o7bVar);
    }

    public void addParent(ecb ecbVar) {
        this.cancel.a(new Remover(this, ecbVar));
    }

    public void signalError(Throwable th) {
        rbb.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(u7b u7bVar, ecb ecbVar) {
        this.action = u7bVar;
        this.cancel = new v9b(new Remover(this, ecbVar));
    }

    public ScheduledAction(u7b u7bVar, v9b v9bVar) {
        this.action = u7bVar;
        this.cancel = new v9b(new Remover2(this, v9bVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(v9b v9bVar) {
        this.cancel.a(new Remover2(this, v9bVar));
    }

    @Override // com.baidu.tieba.o7b
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

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
