package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class bi<T> implements d.b<T, T> {
    private final T iIB;
    private final boolean iKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bi<?> iKY = new bi<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bi<T> ceH() {
        return (bi<T>) a.iKY;
    }

    bi() {
        this(false, null);
    }

    public bi(T t) {
        this(true, t);
    }

    private bi(boolean z, T t) {
        this.iKX = z;
        this.iIB = t;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.iKX, this.iIB);
        jVar.add(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final T iIB;
        private final boolean iKX;
        private boolean iKZ;
        private boolean iLa;
        private T value;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.child = jVar;
            this.iKX = z;
            this.iIB = t;
            request(2L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iLa) {
                if (this.iKZ) {
                    this.iLa = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = t;
                this.iKZ = true;
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iLa) {
                if (this.iKZ) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.iKX) {
                    this.child.setProducer(new SingleProducer(this.child, this.iIB));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iLa) {
                rx.c.c.onError(th);
            } else {
                this.child.onError(th);
            }
        }
    }
}
