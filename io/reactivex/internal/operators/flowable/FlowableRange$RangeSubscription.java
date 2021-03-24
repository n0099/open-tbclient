package io.reactivex.internal.operators.flowable;

import g.d.c;
/* loaded from: classes7.dex */
public final class FlowableRange$RangeSubscription extends FlowableRange$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final c<? super Integer> actual;

    public FlowableRange$RangeSubscription(c<? super Integer> cVar, int i, int i2) {
        super(i, i2);
        this.actual = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int i = this.end;
        c<? super Integer> cVar = this.actual;
        for (int i2 = this.index; i2 != i; i2++) {
            if (this.cancelled) {
                return;
            }
            cVar.onNext(Integer.valueOf(i2));
        }
        if (this.cancelled) {
            return;
        }
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void slowPath(long j) {
        int i = this.end;
        int i2 = this.index;
        c<? super Integer> cVar = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i2 == i) {
                    if (i2 == i) {
                        if (this.cancelled) {
                            return;
                        }
                        cVar.onComplete();
                        return;
                    }
                    j = get();
                    if (j2 == j) {
                        this.index = i2;
                        j = addAndGet(-j2);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    cVar.onNext(Integer.valueOf(i2));
                    j2++;
                    i2++;
                }
            }
        } while (j != 0);
    }
}
