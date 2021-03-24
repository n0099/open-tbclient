package io.reactivex.internal.operators.flowable;

import f.a.x.c.a;
/* loaded from: classes7.dex */
public final class FlowableRangeLong$RangeConditionalSubscription extends FlowableRangeLong$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final a<? super Long> actual;

    public FlowableRangeLong$RangeConditionalSubscription(a<? super Long> aVar, long j, long j2) {
        super(j, j2);
        this.actual = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long j = this.end;
        a<? super Long> aVar = this.actual;
        for (long j2 = this.index; j2 != j; j2++) {
            if (this.cancelled) {
                return;
            }
            aVar.tryOnNext(Long.valueOf(j2));
        }
        if (this.cancelled) {
            return;
        }
        aVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void slowPath(long j) {
        long j2 = this.end;
        long j3 = this.index;
        a<? super Long> aVar = this.actual;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == j || j3 == j2) {
                    if (j3 == j2) {
                        if (this.cancelled) {
                            return;
                        }
                        aVar.onComplete();
                        return;
                    }
                    j = get();
                    if (j4 == j) {
                        this.index = j3;
                        j = addAndGet(-j4);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    if (aVar.tryOnNext(Long.valueOf(j3))) {
                        j4++;
                    }
                    j3++;
                }
            }
        } while (j != 0);
    }
}
