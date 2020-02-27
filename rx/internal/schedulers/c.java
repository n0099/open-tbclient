package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes6.dex */
public final class c extends rx.g {
    final Executor executor;

    public c(Executor executor) {
        this.executor = executor;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.executor);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a implements Runnable {
        final Executor executor;
        final ConcurrentLinkedQueue<ScheduledAction> nPS = new ConcurrentLinkedQueue<>();
        final AtomicInteger wip = new AtomicInteger();
        final rx.subscriptions.b nRB = new rx.subscriptions.b();
        final ScheduledExecutorService nRC = d.dOx();

        public a(Executor executor) {
            this.executor = executor;
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.e.dPA();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.i(aVar), this.nRB);
            this.nRB.add(scheduledAction);
            this.nPS.offer(scheduledAction);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                    return scheduledAction;
                } catch (RejectedExecutionException e) {
                    this.nRB.a(scheduledAction);
                    this.wip.decrementAndGet();
                    rx.c.c.onError(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.nRB.isUnsubscribed()) {
                ScheduledAction poll = this.nPS.poll();
                if (poll != null) {
                    if (!poll.isUnsubscribed()) {
                        if (!this.nRB.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.nPS.clear();
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
            this.nPS.clear();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return c(aVar);
            }
            if (isUnsubscribed()) {
                return rx.subscriptions.e.dPA();
            }
            final rx.functions.a i = rx.c.c.i(aVar);
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            final rx.subscriptions.c cVar2 = new rx.subscriptions.c();
            cVar2.f(cVar);
            this.nRB.add(cVar2);
            final k l = rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.schedulers.c.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.nRB.a(cVar2);
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
                scheduledAction.add(this.nRC.schedule(scheduledAction, j, timeUnit));
                return l;
            } catch (RejectedExecutionException e) {
                rx.c.c.onError(e);
                throw e;
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRB.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nRB.unsubscribe();
            this.nPS.clear();
        }
    }
}
