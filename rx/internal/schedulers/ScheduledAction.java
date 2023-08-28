package rx.internal.schedulers;

import com.baidu.tieba.c8c;
import com.baidu.tieba.dcc;
import com.baidu.tieba.hac;
import com.baidu.tieba.qcc;
import com.baidu.tieba.w7c;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, w7c {
    public static final long serialVersionUID = -3962399486978279857L;
    public final c8c action;
    public final hac cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements w7c {
        public static final long serialVersionUID = 247232374289553518L;
        public final qcc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, qcc qccVar) {
            this.s = scheduledAction;
            this.parent = qccVar;
        }

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements w7c {
        public static final long serialVersionUID = 247232374289553518L;
        public final hac parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, hac hacVar) {
            this.s = scheduledAction;
            this.parent = hacVar;
        }

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements w7c {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(c8c c8cVar) {
        this.action = c8cVar;
        this.cancel = new hac();
    }

    public void add(w7c w7cVar) {
        this.cancel.a(w7cVar);
    }

    public void addParent(hac hacVar) {
        this.cancel.a(new Remover2(this, hacVar));
    }

    public void signalError(Throwable th) {
        dcc.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(c8c c8cVar, hac hacVar) {
        this.action = c8cVar;
        this.cancel = new hac(new Remover2(this, hacVar));
    }

    public ScheduledAction(c8c c8cVar, qcc qccVar) {
        this.action = c8cVar;
        this.cancel = new hac(new Remover(this, qccVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(qcc qccVar) {
        this.cancel.a(new Remover(this, qccVar));
    }

    @Override // com.baidu.tieba.w7c
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

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
