package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes16.dex */
public final class c extends rx.g {
    final Executor executor;

    public c(Executor executor) {
        this.executor = executor;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.executor);
    }

    /* loaded from: classes16.dex */
    static final class a extends g.a implements Runnable {
        final Executor executor;
        final ConcurrentLinkedQueue<ScheduledAction> pWN = new ConcurrentLinkedQueue<>();
        final AtomicInteger wip = new AtomicInteger();
        final rx.subscriptions.b pYx = new rx.subscriptions.b();
        final ScheduledExecutorService pYy = d.eCg();

        public a(Executor executor) {
            this.executor = executor;
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.e.eDj();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.i(aVar), this.pYx);
            this.pYx.add(scheduledAction);
            this.pWN.offer(scheduledAction);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                    return scheduledAction;
                } catch (RejectedExecutionException e) {
                    this.pYx.a(scheduledAction);
                    this.wip.decrementAndGet();
                    rx.c.c.onError(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.pYx.isUnsubscribed()) {
                ScheduledAction poll = this.pWN.poll();
                if (poll != null) {
                    if (!poll.isUnsubscribed()) {
                        if (!this.pYx.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.pWN.clear();
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
            this.pWN.clear();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return c(aVar);
            }
            if (isUnsubscribed()) {
                return rx.subscriptions.e.eDj();
            }
            final rx.functions.a i = rx.c.c.i(aVar);
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            final rx.subscriptions.c cVar2 = new rx.subscriptions.c();
            cVar2.f(cVar);
            this.pYx.add(cVar2);
            final k l = rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.schedulers.c.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.pYx.a(cVar2);
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
                scheduledAction.add(this.pYy.schedule(scheduledAction, j, timeUnit));
                return l;
            } catch (RejectedExecutionException e) {
                rx.c.c.onError(e);
                throw e;
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pYx.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.pYx.unsubscribe();
            this.pWN.clear();
        }
    }
}
