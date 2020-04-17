package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes6.dex */
public final class OnSubscribeFromArray<T> implements d.a<T> {
    final T[] array;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super T> jVar) {
        jVar.setProducer(new FromArrayProducer(jVar, this.array));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class FromArrayProducer<T> extends AtomicLong implements rx.f {
        private static final long serialVersionUID = 3534218984725836979L;
        final T[] array;
        final rx.j<? super T> child;
        int index;

        public FromArrayProducer(rx.j<? super T> jVar, T[] tArr) {
            this.child = jVar;
            this.array = tArr;
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j == Long.MAX_VALUE) {
                if (a.e(this, j) == 0) {
                    fastPath();
                }
            } else if (j != 0 && a.e(this, j) == 0) {
                slowPath(j);
            }
        }

        void fastPath() {
            rx.j<? super T> jVar = this.child;
            for (T t : this.array) {
                Object obj = (Object) t;
                if (!jVar.isUnsubscribed()) {
                    jVar.onNext(obj);
                } else {
                    return;
                }
            }
            if (!jVar.isUnsubscribed()) {
                jVar.onCompleted();
            }
        }

        void slowPath(long j) {
            rx.j<? super T> jVar = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (!jVar.isUnsubscribed()) {
                        jVar.onNext((Object) tArr[i]);
                        i++;
                        if (i == length) {
                            if (!jVar.isUnsubscribed()) {
                                jVar.onCompleted();
                                return;
                            }
                            return;
                        }
                        j--;
                        j2--;
                    } else {
                        return;
                    }
                } else {
                    j = get() + j2;
                    if (j == 0) {
                        this.index = i;
                        j = addAndGet(j2);
                        if (j == 0) {
                            return;
                        }
                        j2 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
