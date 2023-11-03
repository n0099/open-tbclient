package rx.internal.schedulers;

import com.baidu.tieba.cmc;
import com.baidu.tieba.loc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.vjc;
import com.baidu.tieba.ync;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, pjc {
    public static final long serialVersionUID = -3962399486978279857L;
    public final vjc action;
    public final cmc cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements pjc {
        public static final long serialVersionUID = 247232374289553518L;
        public final loc parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, loc locVar) {
            this.s = scheduledAction;
            this.parent = locVar;
        }

        @Override // com.baidu.tieba.pjc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.pjc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements pjc {
        public static final long serialVersionUID = 247232374289553518L;
        public final cmc parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, cmc cmcVar) {
            this.s = scheduledAction;
            this.parent = cmcVar;
        }

        @Override // com.baidu.tieba.pjc
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.pjc
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements pjc {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.pjc
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.pjc
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(vjc vjcVar) {
        this.action = vjcVar;
        this.cancel = new cmc();
    }

    public void add(pjc pjcVar) {
        this.cancel.a(pjcVar);
    }

    public void addParent(cmc cmcVar) {
        this.cancel.a(new Remover2(this, cmcVar));
    }

    public void signalError(Throwable th) {
        ync.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(vjc vjcVar, cmc cmcVar) {
        this.action = vjcVar;
        this.cancel = new cmc(new Remover2(this, cmcVar));
    }

    public ScheduledAction(vjc vjcVar, loc locVar) {
        this.action = vjcVar;
        this.cancel = new cmc(new Remover(this, locVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(loc locVar) {
        this.cancel.a(new Remover(this, locVar));
    }

    @Override // com.baidu.tieba.pjc
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

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
