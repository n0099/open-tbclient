package io.reactivex.internal.operators.flowable;

import f.b.x.c.a;
/* loaded from: classes7.dex */
public final class FlowableFromArray$ArrayConditionalSubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    public static final long serialVersionUID = 2587302975077663557L;
    public final a<? super T> actual;

    public FlowableFromArray$ArrayConditionalSubscription(a<? super T> aVar, T[] tArr) {
        super(tArr);
        this.actual = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        a<? super T> aVar = this.actual;
        for (int i = this.index; i != length; i++) {
            if (this.cancelled) {
                return;
            }
            T t = tArr[i];
            if (t == null) {
                aVar.onError(new NullPointerException("array element is null"));
                return;
            }
            aVar.tryOnNext(t);
        }
        if (this.cancelled) {
            return;
        }
        aVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void slowPath(long j) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        a<? super T> aVar = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i == length) {
                    if (i == length) {
                        if (this.cancelled) {
                            return;
                        }
                        aVar.onComplete();
                        return;
                    }
                    j = get();
                    if (j2 == j) {
                        this.index = i;
                        j = addAndGet(-j2);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    T t = tArr[i];
                    if (t == null) {
                        aVar.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    if (aVar.tryOnNext(t)) {
                        j2++;
                    }
                    i++;
                }
            }
        } while (j != 0);
    }
}
