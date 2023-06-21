package rx.internal.schedulers;

import com.baidu.tieba.eob;
import com.baidu.tieba.fob;
import com.baidu.tieba.gob;
import com.baidu.tieba.gtb;
import com.baidu.tieba.hob;
import com.baidu.tieba.job;
import com.baidu.tieba.lsb;
import com.baidu.tieba.nob;
import com.baidu.tieba.tob;
import com.baidu.tieba.yob;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends job implements nob {
    public static final nob d = new c();
    public static final nob e = gtb.c();
    public final job a;
    public final hob<gob<eob>> b;
    public final nob c;

    /* loaded from: classes2.dex */
    public static class c implements nob {
        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements yob<ScheduledAction, eob> {
        public final /* synthetic */ job.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0786a implements eob.f {
            public final /* synthetic */ ScheduledAction a;

            public C0786a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.eob.f, com.baidu.tieba.uob
            public void call(fob fobVar) {
                fobVar.onSubscribe(this.a);
                this.a.call(a.this.a, fobVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, job.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public eob call(ScheduledAction scheduledAction) {
            return eob.b(new C0786a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final tob action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(tob tobVar, long j, TimeUnit timeUnit) {
            this.action = tobVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public nob callActual(job.a aVar, fob fobVar) {
            return aVar.c(new d(this.action, fobVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final tob action;

        public ImmediateAction(tob tobVar) {
            this.action = tobVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public nob callActual(job.a aVar, fob fobVar) {
            return aVar.b(new d(this.action, fobVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<nob> implements nob {
        public abstract nob callActual(job.a aVar, fob fobVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
            nob nobVar;
            nob nobVar2 = SchedulerWhen.e;
            do {
                nobVar = get();
                if (nobVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(nobVar, nobVar2));
            if (nobVar != SchedulerWhen.d) {
                nobVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(job.a aVar, fob fobVar) {
            nob nobVar = get();
            if (nobVar == SchedulerWhen.e || nobVar != SchedulerWhen.d) {
                return;
            }
            nob callActual = callActual(aVar, fobVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends job.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ job.a b;
        public final /* synthetic */ hob c;

        public b(SchedulerWhen schedulerWhen, job.a aVar, hob hobVar) {
            this.b = aVar;
            this.c = hobVar;
        }

        @Override // com.baidu.tieba.job.a
        public nob c(tob tobVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(tobVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.job.a
        public nob b(tob tobVar) {
            ImmediateAction immediateAction = new ImmediateAction(tobVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements tob {
        public fob a;
        public tob b;

        public d(tob tobVar, fob fobVar) {
            this.b = tobVar;
            this.a = fobVar;
        }

        @Override // com.baidu.tieba.tob
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.hob<com.baidu.tieba.gob<com.baidu.tieba.eob>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.job
    public job.a createWorker() {
        job.a createWorker = this.a.createWorker();
        BufferUntilSubscriber H = BufferUntilSubscriber.H();
        lsb lsbVar = new lsb(H);
        Object j = H.j(new a(this, createWorker));
        b bVar = new b(this, createWorker, lsbVar);
        this.b.onNext(j);
        return bVar;
    }

    @Override // com.baidu.tieba.nob
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(yob<gob<gob<eob>>, eob> yobVar, job jobVar) {
        this.a = jobVar;
        PublishSubject H = PublishSubject.H();
        this.b = new lsb(H);
        this.c = yobVar.call(H.p()).f();
    }
}
