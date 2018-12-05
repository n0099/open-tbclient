package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class bi<T> implements d.b<T, T> {
    private final T iFr;
    private final boolean iHN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bi<?> iHO = new bi<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bi<T> cdR() {
        return (bi<T>) a.iHO;
    }

    bi() {
        this(false, null);
    }

    public bi(T t) {
        this(true, t);
    }

    private bi(boolean z, T t) {
        this.iHN = z;
        this.iFr = t;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.iHN, this.iFr);
        jVar.add(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final T iFr;
        private final boolean iHN;
        private boolean iHP;
        private boolean iHQ;
        private T value;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.child = jVar;
            this.iHN = z;
            this.iFr = t;
            request(2L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iHQ) {
                if (this.iHP) {
                    this.iHQ = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = t;
                this.iHP = true;
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iHQ) {
                if (this.iHP) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.iHN) {
                    this.child.setProducer(new SingleProducer(this.child, this.iFr));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iHQ) {
                rx.c.c.onError(th);
            } else {
                this.child.onError(th);
            }
        }
    }
}
