package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class bi<T> implements d.b<T, T> {
    private final T iwy;
    private final boolean iyU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bi<?> iyV = new bi<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bi<T> ccr() {
        return (bi<T>) a.iyV;
    }

    bi() {
        this(false, null);
    }

    public bi(T t) {
        this(true, t);
    }

    private bi(boolean z, T t) {
        this.iyU = z;
        this.iwy = t;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.iyU, this.iwy);
        jVar.add(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final T iwy;
        private final boolean iyU;
        private boolean iyW;
        private boolean iyX;
        private T value;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.child = jVar;
            this.iyU = z;
            this.iwy = t;
            request(2L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iyX) {
                if (this.iyW) {
                    this.iyX = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = t;
                this.iyW = true;
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iyX) {
                if (this.iyW) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.iyU) {
                    this.child.setProducer(new SingleProducer(this.child, this.iwy));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iyX) {
                rx.c.c.onError(th);
            } else {
                this.child.onError(th);
            }
        }
    }
}
