package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class al<T> implements d.b<T, T> {
    final long iHW;
    final rx.g scheduler;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public al(long j, TimeUnit timeUnit, rx.g gVar) {
        this.iHW = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        return new AnonymousClass1(jVar, createWorker, jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.al$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends rx.j<T> {
        boolean done;
        final /* synthetic */ rx.j iFC;
        final /* synthetic */ g.a iGB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(rx.j jVar, g.a aVar, rx.j jVar2) {
            super(jVar);
            this.iGB = aVar;
            this.iFC = jVar2;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iGB.a(new rx.functions.a() { // from class: rx.internal.operators.al.1.1
                @Override // rx.functions.a
                public void call() {
                    if (!AnonymousClass1.this.done) {
                        AnonymousClass1.this.done = true;
                        AnonymousClass1.this.iFC.onCompleted();
                    }
                }
            }, al.this.iHW, al.this.unit);
        }

        @Override // rx.e
        public void onError(final Throwable th) {
            this.iGB.a(new rx.functions.a() { // from class: rx.internal.operators.al.1.2
                @Override // rx.functions.a
                public void call() {
                    if (!AnonymousClass1.this.done) {
                        AnonymousClass1.this.done = true;
                        AnonymousClass1.this.iFC.onError(th);
                        AnonymousClass1.this.iGB.unsubscribe();
                    }
                }
            });
        }

        @Override // rx.e
        public void onNext(final T t) {
            this.iGB.a(new rx.functions.a() { // from class: rx.internal.operators.al.1.3
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.j */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.functions.a
                public void call() {
                    if (!AnonymousClass1.this.done) {
                        AnonymousClass1.this.iFC.onNext(t);
                    }
                }
            }, al.this.iHW, al.this.unit);
        }
    }
}
