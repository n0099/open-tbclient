package rx.internal.schedulers;

import com.baidu.tieba.m1b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.q3b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.z5b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, m1b {
    public static final long serialVersionUID = -3962399486978279857L;
    public final s1b action;
    public final q3b cancel;

    /* loaded from: classes9.dex */
    public static final class Remover extends AtomicBoolean implements m1b {
        public static final long serialVersionUID = 247232374289553518L;
        public final z5b parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, z5b z5bVar) {
            this.s = scheduledAction;
            this.parent = z5bVar;
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Remover2 extends AtomicBoolean implements m1b {
        public static final long serialVersionUID = 247232374289553518L;
        public final q3b parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, q3b q3bVar) {
            this.s = scheduledAction;
            this.parent = q3bVar;
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class a implements m1b {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(s1b s1bVar) {
        this.action = s1bVar;
        this.cancel = new q3b();
    }

    public void add(m1b m1bVar) {
        this.cancel.a(m1bVar);
    }

    public void addParent(q3b q3bVar) {
        this.cancel.a(new Remover2(this, q3bVar));
    }

    public void signalError(Throwable th) {
        m5b.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(s1b s1bVar, q3b q3bVar) {
        this.action = s1bVar;
        this.cancel = new q3b(new Remover2(this, q3bVar));
    }

    public ScheduledAction(s1b s1bVar, z5b z5bVar) {
        this.action = s1bVar;
        this.cancel = new q3b(new Remover(this, z5bVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(z5b z5bVar) {
        this.cancel.a(new Remover(this, z5bVar));
    }

    @Override // com.baidu.tieba.m1b
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

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
