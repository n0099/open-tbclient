package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.d;
/* loaded from: classes2.dex */
public final class af<T, TClosing> implements d.b<List<T>, T> {
    final rx.functions.e<? extends rx.d<? extends TClosing>> iIw;
    final int iIx;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public af(rx.functions.e<? extends rx.d<? extends TClosing>> eVar, int i) {
        this.iIw = eVar;
        this.iIx = i;
    }

    public af(final rx.d<? extends TClosing> dVar, int i) {
        this.iIw = new rx.functions.e<rx.d<? extends TClosing>>() { // from class: rx.internal.operators.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.e, java.util.concurrent.Callable
            /* renamed from: ceL */
            public rx.d<? extends TClosing> call() {
                return dVar;
            }
        };
        this.iIx = i;
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        try {
            rx.d<? extends TClosing> call = this.iIw.call();
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
            return rx.b.g.cgl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends rx.j<T> {
        final rx.j<? super List<T>> child;
        boolean done;
        List<T> iIB;

        public a(rx.j<? super List<T>> jVar) {
            this.child = jVar;
            this.iIB = new ArrayList(af.this.iIx);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this) {
                if (!this.done) {
                    this.iIB.add(t);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.iIB = null;
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
                        List<T> list = this.iIB;
                        this.iIB = null;
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
                    List<T> list = this.iIB;
                    this.iIB = new ArrayList(af.this.iIx);
                    try {
                        this.child.onNext(list);
                    } finally {
                    }
                }
            }
        }
    }
}
