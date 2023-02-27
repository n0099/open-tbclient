package rx.internal.schedulers;

import com.baidu.tieba.fna;
import com.baidu.tieba.kna;
import com.baidu.tieba.pra;
import com.baidu.tieba.qma;
import com.baidu.tieba.rma;
import com.baidu.tieba.sma;
import com.baidu.tieba.tma;
import com.baidu.tieba.uqa;
import com.baidu.tieba.vma;
import com.baidu.tieba.zma;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes9.dex */
public class SchedulerWhen extends vma implements zma {
    public static final zma d = new c();
    public static final zma e = pra.c();
    public final vma a;
    public final tma<sma<qma>> b;
    public final zma c;

    /* loaded from: classes9.dex */
    public static class c implements zma {
        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements kna<ScheduledAction, qma> {
        public final /* synthetic */ vma.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0740a implements qma.f {
            public final /* synthetic */ ScheduledAction a;

            public C0740a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qma.f, com.baidu.tieba.gna
            public void call(rma rmaVar) {
                rmaVar.onSubscribe(this.a);
                this.a.call(a.this.a, rmaVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, vma.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public qma call(ScheduledAction scheduledAction) {
            return qma.b(new C0740a(scheduledAction));
        }
    }

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public final fna action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(fna fnaVar, long j, TimeUnit timeUnit) {
            this.action = fnaVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public zma callActual(vma.a aVar, rma rmaVar) {
            return aVar.c(new d(this.action, rmaVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final fna action;

        public ImmediateAction(fna fnaVar) {
            this.action = fnaVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public zma callActual(vma.a aVar, rma rmaVar) {
            return aVar.b(new d(this.action, rmaVar));
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<zma> implements zma {
        public abstract zma callActual(vma.a aVar, rma rmaVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
            zma zmaVar;
            zma zmaVar2 = SchedulerWhen.e;
            do {
                zmaVar = get();
                if (zmaVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(zmaVar, zmaVar2));
            if (zmaVar != SchedulerWhen.d) {
                zmaVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(vma.a aVar, rma rmaVar) {
            zma zmaVar = get();
            if (zmaVar == SchedulerWhen.e || zmaVar != SchedulerWhen.d) {
                return;
            }
            zma callActual = callActual(aVar, rmaVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends vma.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ vma.a b;
        public final /* synthetic */ tma c;

        public b(SchedulerWhen schedulerWhen, vma.a aVar, tma tmaVar) {
            this.b = aVar;
            this.c = tmaVar;
        }

        @Override // com.baidu.tieba.vma.a
        public zma c(fna fnaVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(fnaVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.vma.a
        public zma b(fna fnaVar) {
            ImmediateAction immediateAction = new ImmediateAction(fnaVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements fna {
        public rma a;
        public fna b;

        public d(fna fnaVar, rma rmaVar) {
            this.b = fnaVar;
            this.a = rmaVar;
        }

        @Override // com.baidu.tieba.fna
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.tma<com.baidu.tieba.sma<com.baidu.tieba.qma>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.vma
    public vma.a createWorker() {
        vma.a createWorker = this.a.createWorker();
        BufferUntilSubscriber D = BufferUntilSubscriber.D();
        uqa uqaVar = new uqa(D);
        Object h = D.h(new a(this, createWorker));
        b bVar = new b(this, createWorker, uqaVar);
        this.b.onNext(h);
        return bVar;
    }

    @Override // com.baidu.tieba.zma
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(kna<sma<sma<qma>>, qma> knaVar, vma vmaVar) {
        this.a = vmaVar;
        PublishSubject D = PublishSubject.D();
        this.b = new uqa(D);
        this.c = knaVar.call(D.n()).f();
    }
}
