package io.reactivex.internal.operators.flowable;

import g.d.c;
/* loaded from: classes7.dex */
public final class FlowableFromArray$ArraySubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    public static final long serialVersionUID = 2587302975077663557L;
    public final c<? super T> actual;

    public FlowableFromArray$ArraySubscription(c<? super T> cVar, T[] tArr) {
        super(tArr);
        this.actual = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        c<? super T> cVar = this.actual;
        for (int i = this.index; i != length; i++) {
            if (this.cancelled) {
                return;
            }
            T t = tArr[i];
            if (t == null) {
                cVar.onError(new NullPointerException("array element is null"));
                return;
            }
            cVar.onNext(t);
        }
        if (this.cancelled) {
            return;
        }
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void slowPath(long j) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        c<? super T> cVar = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i == length) {
                    if (i == length) {
                        if (this.cancelled) {
                            return;
                        }
                        cVar.onComplete();
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
                        cVar.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    cVar.onNext(t);
                    j2++;
                    i++;
                }
            }
        } while (j != 0);
    }
}
