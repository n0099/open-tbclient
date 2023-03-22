package rx.internal.schedulers;

import com.baidu.tieba.bsa;
import com.baidu.tieba.iwa;
import com.baidu.tieba.vra;
import com.baidu.tieba.vva;
import com.baidu.tieba.zta;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, vra {
    public static final long serialVersionUID = -3962399486978279857L;
    public final bsa action;
    public final zta cancel;

    /* loaded from: classes9.dex */
    public static final class Remover extends AtomicBoolean implements vra {
        public static final long serialVersionUID = 247232374289553518L;
        public final iwa parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, iwa iwaVar) {
            this.s = scheduledAction;
            this.parent = iwaVar;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Remover2 extends AtomicBoolean implements vra {
        public static final long serialVersionUID = 247232374289553518L;
        public final zta parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, zta ztaVar) {
            this.s = scheduledAction;
            this.parent = ztaVar;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class a implements vra {
        public final Future<?> a;

        public a(Future<?> future) {
            this.a = future;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return this.a.isCancelled();
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.a.cancel(true);
            } else {
                this.a.cancel(false);
            }
        }
    }

    public ScheduledAction(bsa bsaVar) {
        this.action = bsaVar;
        this.cancel = new zta();
    }

    public void add(vra vraVar) {
        this.cancel.a(vraVar);
    }

    public void addParent(iwa iwaVar) {
        this.cancel.a(new Remover(this, iwaVar));
    }

    public void signalError(Throwable th) {
        vva.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public ScheduledAction(bsa bsaVar, iwa iwaVar) {
        this.action = bsaVar;
        this.cancel = new zta(new Remover(this, iwaVar));
    }

    public ScheduledAction(bsa bsaVar, zta ztaVar) {
        this.action = bsaVar;
        this.cancel = new zta(new Remover2(this, ztaVar));
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(zta ztaVar) {
        this.cancel.a(new Remover2(this, ztaVar));
    }

    @Override // com.baidu.tieba.vra
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

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }
}
