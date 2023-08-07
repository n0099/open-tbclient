package rx.internal.schedulers;

import com.baidu.tieba.e1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.k5c;
import com.baidu.tieba.o3c;
import com.baidu.tieba.x5c;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, e1c {
    public static final long serialVersionUID = -3962399486978279857L;
    public final k1c action;
    public final o3c cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements e1c {
        public static final long serialVersionUID = 247232374289553518L;
        public final x5c parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, x5c x5cVar) {
            this.s = scheduledAction;
            this.parent = x5cVar;
        }

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements e1c {
        public static final long serialVersionUID = 247232374289553518L;
        public final o3c parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, o3c o3cVar) {
            this.s = scheduledAction;
            this.parent = o3cVar;
        }

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements e1c {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(k1c k1cVar) {
        this.action = k1cVar;
        this.cancel = new o3c();
    }

    public void add(e1c e1cVar) {
        this.cancel.a(e1cVar);
    }

    public void addParent(o3c o3cVar) {
        this.cancel.a(new Remover2(this, o3cVar));
    }

    public void signalError(Throwable th) {
        k5c.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(k1c k1cVar, o3c o3cVar) {
        this.action = k1cVar;
        this.cancel = new o3c(new Remover2(this, o3cVar));
    }

    public ScheduledAction(k1c k1cVar, x5c x5cVar) {
        this.action = k1cVar;
        this.cancel = new o3c(new Remover(this, x5cVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(x5c x5cVar) {
        this.cancel.a(new Remover(this, x5cVar));
    }

    @Override // com.baidu.tieba.e1c
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

    @Override // com.baidu.tieba.e1c
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
