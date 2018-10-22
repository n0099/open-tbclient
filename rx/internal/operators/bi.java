package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class bi<T> implements d.b<T, T> {
    private final T iwz;
    private final boolean iyV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bi<?> iyW = new bi<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bi<T> ccr() {
        return (bi<T>) a.iyW;
    }

    bi() {
        this(false, null);
    }

    public bi(T t) {
        this(true, t);
    }

    private bi(boolean z, T t) {
        this.iyV = z;
        this.iwz = t;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.iyV, this.iwz);
        jVar.add(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final T iwz;
        private final boolean iyV;
        private boolean iyX;
        private boolean iyY;
        private T value;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.child = jVar;
            this.iyV = z;
            this.iwz = t;
            request(2L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iyY) {
                if (this.iyX) {
                    this.iyY = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = t;
                this.iyX = true;
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iyY) {
                if (this.iyX) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.iyV) {
                    this.child.setProducer(new SingleProducer(this.child, this.iwz));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iyY) {
                rx.c.c.onError(th);
            } else {
                this.child.onError(th);
            }
        }
    }
}
