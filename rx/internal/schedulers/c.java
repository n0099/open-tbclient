package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes2.dex */
public final class c extends rx.g {
    final Executor executor;

    public c(Executor executor) {
        this.executor = executor;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.executor);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a implements Runnable {
        final Executor executor;
        final ConcurrentLinkedQueue<ScheduledAction> iKG = new ConcurrentLinkedQueue<>();
        final AtomicInteger wip = new AtomicInteger();
        final rx.subscriptions.b iPm = new rx.subscriptions.b();
        final ScheduledExecutorService iPn = d.cfH();

        public a(Executor executor) {
            this.executor = executor;
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.e.cgS();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.g(aVar), this.iPm);
            this.iPm.add(scheduledAction);
            this.iKG.offer(scheduledAction);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                    return scheduledAction;
                } catch (RejectedExecutionException e) {
                    this.iPm.b(scheduledAction);
                    this.wip.decrementAndGet();
                    rx.c.c.onError(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.iPm.isUnsubscribed()) {
                ScheduledAction poll = this.iKG.poll();
                if (poll != null) {
                    if (!poll.isUnsubscribed()) {
                        if (!this.iPm.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.iKG.clear();
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
            this.iKG.clear();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(aVar);
            }
            if (isUnsubscribed()) {
                return rx.subscriptions.e.cgS();
            }
            final rx.functions.a g = rx.c.c.g(aVar);
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            final rx.subscriptions.c cVar2 = new rx.subscriptions.c();
            cVar2.g(cVar);
            this.iPm.add(cVar2);
            final k j2 = rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.schedulers.c.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.iPm.b(cVar2);
                }
            });
            ScheduledAction scheduledAction = new ScheduledAction(new rx.functions.a() { // from class: rx.internal.schedulers.c.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!cVar2.isUnsubscribed()) {
                        k a = a.this.a(g);
                        cVar2.g(a);
                        if (a.getClass() == ScheduledAction.class) {
                            ((ScheduledAction) a).add(j2);
                        }
                    }
                }
            });
            cVar.g(scheduledAction);
            try {
                scheduledAction.add(this.iPn.schedule(scheduledAction, j, timeUnit));
                return j2;
            } catch (RejectedExecutionException e) {
                rx.c.c.onError(e);
                throw e;
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iPm.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iPm.unsubscribe();
            this.iKG.clear();
        }
    }
}
