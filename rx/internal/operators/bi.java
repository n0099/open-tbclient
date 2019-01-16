package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class bi<T> implements d.b<T, T> {
    private final T iJI;
    private final boolean iMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bi<?> iMf = new bi<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bi<T> cfp() {
        return (bi<T>) a.iMf;
    }

    bi() {
        this(false, null);
    }

    public bi(T t) {
        this(true, t);
    }

    private bi(boolean z, T t) {
        this.iMe = z;
        this.iJI = t;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.iMe, this.iJI);
        jVar.add(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final T iJI;
        private final boolean iMe;
        private boolean iMg;
        private boolean iMh;
        private T value;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.child = jVar;
            this.iMe = z;
            this.iJI = t;
            request(2L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iMh) {
                if (this.iMg) {
                    this.iMh = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = t;
                this.iMg = true;
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iMh) {
                if (this.iMg) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.iMe) {
                    this.child.setProducer(new SingleProducer(this.child, this.iJI));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iMh) {
                rx.c.c.onError(th);
            } else {
                this.child.onError(th);
            }
        }
    }
}
