package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class bi<T> implements d.b<T, T> {
    private final boolean iAF;
    private final T iyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bi<?> iAG = new bi<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bi<T> cbO() {
        return (bi<T>) a.iAG;
    }

    bi() {
        this(false, null);
    }

    public bi(T t) {
        this(true, t);
    }

    private bi(boolean z, T t) {
        this.iAF = z;
        this.iyj = t;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.iAF, this.iyj);
        jVar.add(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final boolean iAF;
        private boolean iAH;
        private boolean iAI;
        private final T iyj;
        private T value;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.child = jVar;
            this.iAF = z;
            this.iyj = t;
            request(2L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iAI) {
                if (this.iAH) {
                    this.iAI = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = t;
                this.iAH = true;
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iAI) {
                if (this.iAH) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.iAF) {
                    this.child.setProducer(new SingleProducer(this.child, this.iyj));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iAI) {
                rx.c.c.onError(th);
            } else {
                this.child.onError(th);
            }
        }
    }
}
