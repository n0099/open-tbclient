package io.reactivex.internal.operators.flowable;

import f.a.x.c.a;
/* loaded from: classes7.dex */
public final class FlowableRange$RangeConditionalSubscription extends FlowableRange$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final a<? super Integer> actual;

    public FlowableRange$RangeConditionalSubscription(a<? super Integer> aVar, int i, int i2) {
        super(i, i2);
        this.actual = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int i = this.end;
        a<? super Integer> aVar = this.actual;
        for (int i2 = this.index; i2 != i; i2++) {
            if (this.cancelled) {
                return;
            }
            aVar.tryOnNext(Integer.valueOf(i2));
        }
        if (this.cancelled) {
            return;
        }
        aVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void slowPath(long j) {
        int i = this.end;
        int i2 = this.index;
        a<? super Integer> aVar = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i2 == i) {
                    if (i2 == i) {
                        if (this.cancelled) {
                            return;
                        }
                        aVar.onComplete();
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
                    if (aVar.tryOnNext(Integer.valueOf(i2))) {
                        j2++;
                    }
                    i2++;
                }
            }
        } while (j != 0);
    }
}
