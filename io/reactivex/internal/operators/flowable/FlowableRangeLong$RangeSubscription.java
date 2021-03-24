package io.reactivex.internal.operators.flowable;

import g.d.c;
/* loaded from: classes7.dex */
public final class FlowableRangeLong$RangeSubscription extends FlowableRangeLong$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final c<? super Long> actual;

    public FlowableRangeLong$RangeSubscription(c<? super Long> cVar, long j, long j2) {
        super(j, j2);
        this.actual = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long j = this.end;
        c<? super Long> cVar = this.actual;
        for (long j2 = this.index; j2 != j; j2++) {
            if (this.cancelled) {
                return;
            }
            cVar.onNext(Long.valueOf(j2));
        }
        if (this.cancelled) {
            return;
        }
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void slowPath(long j) {
        long j2 = this.end;
        long j3 = this.index;
        c<? super Long> cVar = this.actual;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == j || j3 == j2) {
                    if (j3 == j2) {
                        if (this.cancelled) {
                            return;
                        }
                        cVar.onComplete();
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
                    cVar.onNext(Long.valueOf(j3));
                    j4++;
                    j3++;
                }
            }
        } while (j != 0);
    }
}
