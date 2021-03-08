package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes4.dex */
public final class c extends rx.g {
    final Executor executor;

    public c(Executor executor) {
        this.executor = executor;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.executor);
    }

    /* loaded from: classes4.dex */
    static final class a extends g.a implements Runnable {
        final Executor executor;
        final ConcurrentLinkedQueue<ScheduledAction> qBB = new ConcurrentLinkedQueue<>();
        final AtomicInteger wip = new AtomicInteger();
        final rx.subscriptions.b qDl = new rx.subscriptions.b();
        final ScheduledExecutorService qDm = d.eMY();

        public a(Executor executor) {
            this.executor = executor;
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.e.eOd();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.i(aVar), this.qDl);
            this.qDl.add(scheduledAction);
            this.qBB.offer(scheduledAction);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                    return scheduledAction;
                } catch (RejectedExecutionException e) {
                    this.qDl.a(scheduledAction);
                    this.wip.decrementAndGet();
                    rx.c.c.onError(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.qDl.isUnsubscribed()) {
                ScheduledAction poll = this.qBB.poll();
                if (poll != null) {
                    if (!poll.isUnsubscribed()) {
                        if (!this.qDl.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.qBB.clear();
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.qBB.clear();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return c(aVar);
            }
            if (isUnsubscribed()) {
                return rx.subscriptions.e.eOd();
            }
            final rx.functions.a i = rx.c.c.i(aVar);
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            final rx.subscriptions.c cVar2 = new rx.subscriptions.c();
            cVar2.f(cVar);
            this.qDl.add(cVar2);
            final k l = rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.schedulers.c.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.qDl.a(cVar2);
                }
            });
            ScheduledAction scheduledAction = new ScheduledAction(new rx.functions.a() { // from class: rx.internal.schedulers.c.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!cVar2.isUnsubscribed()) {
                        k c = a.this.c(i);
                        cVar2.f(c);
                        if (c.getClass() == ScheduledAction.class) {
                            ((ScheduledAction) c).add(l);
                        }
                    }
                }
            });
            cVar.f(scheduledAction);
            try {
                scheduledAction.add(this.qDm.schedule(scheduledAction, j, timeUnit));
                return l;
            } catch (RejectedExecutionException e) {
                rx.c.c.onError(e);
                throw e;
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qDl.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qDl.unsubscribe();
            this.qBB.clear();
        }
    }
}
