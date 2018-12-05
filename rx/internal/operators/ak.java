package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class ak<T> implements d.b<T, T> {
    final long ayx;
    final rx.g scheduler;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ak(long j, TimeUnit timeUnit, rx.g gVar) {
        this.ayx = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        rx.b.f fVar = new rx.b.f(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        fVar.add(createWorker);
        fVar.add(dVar);
        return new AnonymousClass1(jVar, dVar, createWorker, fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.ak$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends rx.j<T> {
        final /* synthetic */ rx.subscriptions.d iCt;
        final /* synthetic */ g.a iDr;
        final a<T> iEE;
        final rx.j<?> iEF;
        final /* synthetic */ rx.b.f iEG;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(rx.j jVar, rx.subscriptions.d dVar, g.a aVar, rx.b.f fVar) {
            super(jVar);
            this.iCt = dVar;
            this.iDr = aVar;
            this.iEG = fVar;
            this.iEE = new a<>();
            this.iEF = this;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            final int bg = this.iEE.bg(t);
            this.iCt.g(this.iDr.a(new rx.functions.a() { // from class: rx.internal.operators.ak.1.1
                @Override // rx.functions.a
                public void call() {
                    AnonymousClass1.this.iEE.a(bg, AnonymousClass1.this.iEG, AnonymousClass1.this.iEF);
                }
            }, ak.this.ayx, ak.this.unit));
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iEG.onError(th);
            unsubscribe();
            this.iEE.clear();
        }

        @Override // rx.e
        public void onCompleted() {
            this.iEE.a(this.iEG, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        boolean emitting;
        boolean hasValue;
        boolean iEL;
        int index;
        T value;

        public synchronized int bg(T t) {
            int i;
            this.value = t;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }

        public void a(int i, rx.j<T> jVar, rx.j<?> jVar2) {
            synchronized (this) {
                if (!this.emitting && this.hasValue && i == this.index) {
                    T t = this.value;
                    this.value = null;
                    this.hasValue = false;
                    this.emitting = true;
                    try {
                        jVar.onNext(t);
                        synchronized (this) {
                            if (!this.iEL) {
                                this.emitting = false;
                            } else {
                                jVar.onCompleted();
                            }
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, jVar2, t);
                    }
                }
            }
        }

        public void a(rx.j<T> jVar, rx.j<?> jVar2) {
            synchronized (this) {
                if (this.emitting) {
                    this.iEL = true;
                    return;
                }
                T t = this.value;
                boolean z = this.hasValue;
                this.value = null;
                this.hasValue = false;
                this.emitting = true;
                if (z) {
                    try {
                        jVar.onNext(t);
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, jVar2, t);
                        return;
                    }
                }
                jVar.onCompleted();
            }
        }

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }
    }
}
