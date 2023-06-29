package rx.internal.schedulers;

import com.baidu.tieba.atb;
import com.baidu.tieba.ayb;
import com.baidu.tieba.etb;
import com.baidu.tieba.fxb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.ptb;
import com.baidu.tieba.vsb;
import com.baidu.tieba.wsb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.ysb;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends atb implements etb {
    public static final etb d = new c();
    public static final etb e = ayb.c();
    public final atb a;
    public final ysb<xsb<vsb>> b;
    public final etb c;

    /* loaded from: classes2.dex */
    public static class c implements etb {
        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ptb<ScheduledAction, vsb> {
        public final /* synthetic */ atb.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0796a implements vsb.f {
            public final /* synthetic */ ScheduledAction a;

            public C0796a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.vsb.f, com.baidu.tieba.ltb
            public void call(wsb wsbVar) {
                wsbVar.onSubscribe(this.a);
                this.a.call(a.this.a, wsbVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, atb.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public vsb call(ScheduledAction scheduledAction) {
            return vsb.b(new C0796a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final ktb action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(ktb ktbVar, long j, TimeUnit timeUnit) {
            this.action = ktbVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public etb callActual(atb.a aVar, wsb wsbVar) {
            return aVar.c(new d(this.action, wsbVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final ktb action;

        public ImmediateAction(ktb ktbVar) {
            this.action = ktbVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public etb callActual(atb.a aVar, wsb wsbVar) {
            return aVar.b(new d(this.action, wsbVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<etb> implements etb {
        public abstract etb callActual(atb.a aVar, wsb wsbVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            etb etbVar;
            etb etbVar2 = SchedulerWhen.e;
            do {
                etbVar = get();
                if (etbVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(etbVar, etbVar2));
            if (etbVar != SchedulerWhen.d) {
                etbVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(atb.a aVar, wsb wsbVar) {
            etb etbVar = get();
            if (etbVar == SchedulerWhen.e || etbVar != SchedulerWhen.d) {
                return;
            }
            etb callActual = callActual(aVar, wsbVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends atb.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ atb.a b;
        public final /* synthetic */ ysb c;

        public b(SchedulerWhen schedulerWhen, atb.a aVar, ysb ysbVar) {
            this.b = aVar;
            this.c = ysbVar;
        }

        @Override // com.baidu.tieba.atb.a
        public etb c(ktb ktbVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(ktbVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.atb.a
        public etb b(ktb ktbVar) {
            ImmediateAction immediateAction = new ImmediateAction(ktbVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements ktb {
        public wsb a;
        public ktb b;

        public d(ktb ktbVar, wsb wsbVar) {
            this.b = ktbVar;
            this.a = wsbVar;
        }

        @Override // com.baidu.tieba.ktb
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.ysb<com.baidu.tieba.xsb<com.baidu.tieba.vsb>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.atb
    public atb.a createWorker() {
        atb.a createWorker = this.a.createWorker();
        BufferUntilSubscriber O = BufferUntilSubscriber.O();
        fxb fxbVar = new fxb(O);
        Object p = O.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, fxbVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(ptb<xsb<xsb<vsb>>, vsb> ptbVar, atb atbVar) {
        this.a = atbVar;
        PublishSubject O = PublishSubject.O();
        this.b = new fxb(O);
        this.c = ptbVar.call(O.v()).f();
    }
}
