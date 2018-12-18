package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.d;
/* loaded from: classes2.dex */
public final class af<T, TClosing> implements d.b<List<T>, T> {
    final rx.functions.e<? extends rx.d<? extends TClosing>> iEf;
    final int iEg;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public af(rx.functions.e<? extends rx.d<? extends TClosing>> eVar, int i) {
        this.iEf = eVar;
        this.iEg = i;
    }

    public af(final rx.d<? extends TClosing> dVar, int i) {
        this.iEf = new rx.functions.e<rx.d<? extends TClosing>>() { // from class: rx.internal.operators.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.e, java.util.concurrent.Callable
            /* renamed from: cdm */
            public rx.d<? extends TClosing> call() {
                return dVar;
            }
        };
        this.iEg = i;
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        try {
            rx.d<? extends TClosing> call = this.iEf.call();
            final a aVar = new a(new rx.b.f(jVar));
            rx.j<TClosing> jVar2 = new rx.j<TClosing>() { // from class: rx.internal.operators.af.2
                @Override // rx.e
                public void onNext(TClosing tclosing) {
                    aVar.emit();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    aVar.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    aVar.onCompleted();
                }
            };
            jVar.add(jVar2);
            jVar.add(aVar);
            call.unsafeSubscribe(jVar2);
            return aVar;
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
            return rx.b.g.ceM();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends rx.j<T> {
        final rx.j<? super List<T>> child;
        boolean done;
        List<T> iEk;

        public a(rx.j<? super List<T>> jVar) {
            this.child = jVar;
            this.iEk = new ArrayList(af.this.iEg);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this) {
                if (!this.done) {
                    this.iEk.add(t);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.iEk = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.iEk;
                        this.iEk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.child);
            }
        }

        void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.iEk;
                    this.iEk = new ArrayList(af.this.iEg);
                    try {
                        this.child.onNext(list);
                    } finally {
                    }
                }
            }
        }
    }
}
