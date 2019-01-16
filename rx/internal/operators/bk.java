package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.d;
/* loaded from: classes2.dex */
public class bk<T> implements d.b<T, T> {
    final int count;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bk(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("count could not be negative");
        }
        this.count = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.bk.1
            private final Deque<Object> iMl = new ArrayDeque();

            @Override // rx.e
            public void onCompleted() {
                jVar.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: rx.j */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public void onNext(T t) {
                if (bk.this.count == 0) {
                    jVar.onNext(t);
                    return;
                }
                if (this.iMl.size() == bk.this.count) {
                    jVar.onNext(NotificationLite.bb(this.iMl.removeFirst()));
                } else {
                    request(1L);
                }
                this.iMl.offerLast(NotificationLite.aY(t));
            }
        };
    }
}
