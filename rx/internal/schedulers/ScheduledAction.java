package rx.internal.schedulers;

import com.baidu.tieba.f1c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.l5c;
import com.baidu.tieba.p3c;
import com.baidu.tieba.y5c;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, f1c {
    public static final long serialVersionUID = -3962399486978279857L;
    public final l1c action;
    public final p3c cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements f1c {
        public static final long serialVersionUID = 247232374289553518L;
        public final y5c parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, y5c y5cVar) {
            this.s = scheduledAction;
            this.parent = y5cVar;
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.f1c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements f1c {
        public static final long serialVersionUID = 247232374289553518L;
        public final p3c parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, p3c p3cVar) {
            this.s = scheduledAction;
            this.parent = p3cVar;
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.f1c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements f1c {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.f1c
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(l1c l1cVar) {
        this.action = l1cVar;
        this.cancel = new p3c();
    }

    public void add(f1c f1cVar) {
        this.cancel.a(f1cVar);
    }

    public void addParent(p3c p3cVar) {
        this.cancel.a(new Remover2(this, p3cVar));
    }

    public void signalError(Throwable th) {
        l5c.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(l1c l1cVar, p3c p3cVar) {
        this.action = l1cVar;
        this.cancel = new p3c(new Remover2(this, p3cVar));
    }

    public ScheduledAction(l1c l1cVar, y5c y5cVar) {
        this.action = l1cVar;
        this.cancel = new p3c(new Remover(this, y5cVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(y5c y5cVar) {
        this.cancel.a(new Remover(this, y5cVar));
    }

    @Override // com.baidu.tieba.f1c
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

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
