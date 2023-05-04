package rx.internal.schedulers;

import com.baidu.tieba.fab;
import com.baidu.tieba.q5b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.w5b;
import com.baidu.tieba.w7b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, q5b {
    public static final long serialVersionUID = -3962399486978279857L;
    public final w5b action;
    public final w7b cancel;

    /* loaded from: classes9.dex */
    public static final class Remover extends AtomicBoolean implements q5b {
        public static final long serialVersionUID = 247232374289553518L;
        public final fab parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, fab fabVar) {
            this.s = scheduledAction;
            this.parent = fabVar;
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Remover2 extends AtomicBoolean implements q5b {
        public static final long serialVersionUID = 247232374289553518L;
        public final w7b parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, w7b w7bVar) {
            this.s = scheduledAction;
            this.parent = w7bVar;
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class a implements q5b {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(w5b w5bVar) {
        this.action = w5bVar;
        this.cancel = new w7b();
    }

    public void add(q5b q5bVar) {
        this.cancel.a(q5bVar);
    }

    public void addParent(fab fabVar) {
        this.cancel.a(new Remover(this, fabVar));
    }

    public void signalError(Throwable th) {
        s9b.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(w5b w5bVar, fab fabVar) {
        this.action = w5bVar;
        this.cancel = new w7b(new Remover(this, fabVar));
    }

    public ScheduledAction(w5b w5bVar, w7b w7bVar) {
        this.action = w5bVar;
        this.cancel = new w7b(new Remover2(this, w7bVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(w7b w7bVar) {
        this.cancel.a(new Remover2(this, w7bVar));
    }

    @Override // com.baidu.tieba.q5b
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

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
