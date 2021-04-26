package rx.internal.operators;

import h.f;
import h.j;
import h.o.a.a;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements f {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final j<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(j<? super T> jVar, T[] tArr) {
        this.child = jVar;
        this.array = tArr;
    }

    public void fastPath() {
        j<? super T> jVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onNext(obj);
        }
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onCompleted();
    }

    @Override // h.f
    public void request(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        } else if (j == Long.MAX_VALUE) {
            if (a.b(this, j) == 0) {
                fastPath();
            }
        } else if (i2 == 0 || a.b(this, j) != 0) {
        } else {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        j<? super T> jVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i2 = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i2 != length) {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onNext((Object) tArr[i2]);
                    i2++;
                    if (i2 == length) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        jVar.onCompleted();
                        return;
                    }
                    j--;
                    j2--;
                } else {
                    j = get() + j2;
                    if (j == 0) {
                        this.index = i2;
                        j = addAndGet(j2);
                    }
                }
            }
        } while (j != 0);
    }
}
