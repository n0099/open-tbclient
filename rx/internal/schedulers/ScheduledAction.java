package rx.internal.schedulers;

import com.baidu.tieba.fcb;
import com.baidu.tieba.p7b;
import com.baidu.tieba.sbb;
import com.baidu.tieba.v7b;
import com.baidu.tieba.w9b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes10.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, p7b {
    public static final long serialVersionUID = -3962399486978279857L;
    public final v7b action;
    public final w9b cancel;

    /* loaded from: classes10.dex */
    public static final class Remover extends AtomicBoolean implements p7b {
        public static final long serialVersionUID = 247232374289553518L;
        public final fcb parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, fcb fcbVar) {
            this.s = scheduledAction;
            this.parent = fcbVar;
        }

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class Remover2 extends AtomicBoolean implements p7b {
        public static final long serialVersionUID = 247232374289553518L;
        public final w9b parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, w9b w9bVar) {
            this.s = scheduledAction;
            this.parent = w9bVar;
        }

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes10.dex */
    public final class a implements p7b {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(v7b v7bVar) {
        this.action = v7bVar;
        this.cancel = new w9b();
    }

    public void add(p7b p7bVar) {
        this.cancel.a(p7bVar);
    }

    public void addParent(fcb fcbVar) {
        this.cancel.a(new Remover(this, fcbVar));
    }

    public void signalError(Throwable th) {
        sbb.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(v7b v7bVar, fcb fcbVar) {
        this.action = v7bVar;
        this.cancel = new w9b(new Remover(this, fcbVar));
    }

    public ScheduledAction(v7b v7bVar, w9b w9bVar) {
        this.action = v7bVar;
        this.cancel = new w9b(new Remover2(this, w9bVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(w9b w9bVar) {
        this.cancel.a(new Remover2(this, w9bVar));
    }

    @Override // com.baidu.tieba.p7b
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

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
