package rx.internal.schedulers;

import com.baidu.tieba.anb;
import com.baidu.tieba.bpb;
import com.baidu.tieba.krb;
import com.baidu.tieba.umb;
import com.baidu.tieba.xqb;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, umb {
    public static final long serialVersionUID = -3962399486978279857L;
    public final anb action;
    public final bpb cancel;

    /* loaded from: classes2.dex */
    public static final class Remover extends AtomicBoolean implements umb {
        public static final long serialVersionUID = 247232374289553518L;
        public final krb parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, krb krbVar) {
            this.s = scheduledAction;
            this.parent = krbVar;
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Remover2 extends AtomicBoolean implements umb {
        public static final long serialVersionUID = 247232374289553518L;
        public final bpb parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, bpb bpbVar) {
            this.s = scheduledAction;
            this.parent = bpbVar;
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class a implements umb {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(anb anbVar) {
        this.action = anbVar;
        this.cancel = new bpb();
    }

    public void add(umb umbVar) {
        this.cancel.a(umbVar);
    }

    public void addParent(bpb bpbVar) {
        this.cancel.a(new Remover2(this, bpbVar));
    }

    public void signalError(Throwable th) {
        xqb.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(anb anbVar, bpb bpbVar) {
        this.action = anbVar;
        this.cancel = new bpb(new Remover2(this, bpbVar));
    }

    public ScheduledAction(anb anbVar, krb krbVar) {
        this.action = anbVar;
        this.cancel = new bpb(new Remover(this, krbVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(krb krbVar) {
        this.cancel.a(new Remover(this, krbVar));
    }

    @Override // com.baidu.tieba.umb
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

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
