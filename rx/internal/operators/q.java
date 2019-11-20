package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
import rx.h;
/* loaded from: classes2.dex */
public final class q<T> implements h.a<T> {
    final d.a<T> kBK;

    public q(d.a<T> aVar) {
        this.kBK = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.add(aVar);
        this.kBK.call(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        final rx.i<? super T> actual;
        int state;
        T value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.i<? super T> iVar) {
            this.actual = iVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.state;
            if (i == 0) {
                this.state = 1;
                this.value = t;
            } else if (i == 1) {
                this.state = 2;
                this.actual.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.state == 2) {
                rx.c.c.onError(th);
                return;
            }
            this.value = null;
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            int i = this.state;
            if (i == 0) {
                this.actual.onError(new NoSuchElementException());
            } else if (i == 1) {
                this.state = 2;
                T t = this.value;
                this.value = null;
                this.actual.onSuccess(t);
            }
        }
    }
}
