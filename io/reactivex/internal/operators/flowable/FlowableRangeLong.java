package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes4.dex */
public final class FlowableRangeLong extends g<Long> {
    final long end;
    final long start;

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            cVar.onSubscribe(new RangeConditionalSubscription((io.reactivex.internal.a.a) cVar, this.start, this.end));
        } else {
            cVar.onSubscribe(new RangeSubscription(cVar, this.start, this.end));
        }
    }

    /* loaded from: classes4.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        abstract void fastPath();

        abstract void slowPath(long j);

        BaseRangeSubscription(long j, long j2) {
            this.index = j;
            this.end = j2;
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int i) {
            return i & 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.a.f
        public final Long poll() {
            long j = this.index;
            if (j == this.end) {
                return null;
            }
            this.index = 1 + j;
            return Long.valueOf(j);
        }

        @Override // io.reactivex.internal.a.f
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.a.f
        public final void clear() {
            this.index = this.end;
        }

        @Override // org.a.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                if (j == Format.OFFSET_SAMPLE_RELATIVE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // org.a.d
        public final void cancel() {
            this.cancelled = true;
        }
    }

    /* loaded from: classes4.dex */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.c<? super Long> actual;

        RangeSubscription(org.a.c<? super Long> cVar, long j, long j2) {
            super(j, j2);
            this.actual = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long j = this.end;
            org.a.c<? super Long> cVar = this.actual;
            for (long j2 = this.index; j2 != j; j2++) {
                if (!this.cancelled) {
                    cVar.onNext(Long.valueOf(j2));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long j) {
            long j2 = this.end;
            long j3 = this.index;
            org.a.c<? super Long> cVar = this.actual;
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (!this.cancelled) {
                        cVar.onNext(Long.valueOf(j3));
                        j4++;
                        j3++;
                    } else {
                        return;
                    }
                } else if (j3 == j2) {
                    if (!this.cancelled) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j4 == j) {
                        this.index = j3;
                        j = addAndGet(-j4);
                        if (j == 0) {
                            return;
                        }
                        j4 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.internal.a.a<? super Long> actual;

        RangeConditionalSubscription(io.reactivex.internal.a.a<? super Long> aVar, long j, long j2) {
            super(j, j2);
            this.actual = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long j = this.end;
            io.reactivex.internal.a.a<? super Long> aVar = this.actual;
            for (long j2 = this.index; j2 != j; j2++) {
                if (!this.cancelled) {
                    aVar.tryOnNext(Long.valueOf(j2));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                aVar.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long j) {
            long j2 = this.end;
            long j3 = this.index;
            io.reactivex.internal.a.a<? super Long> aVar = this.actual;
            long j4 = j3;
            long j5 = 0;
            while (true) {
                if (j5 != j && j4 != j2) {
                    if (!this.cancelled) {
                        if (aVar.tryOnNext(Long.valueOf(j4))) {
                            j5++;
                        }
                        j4++;
                    } else {
                        return;
                    }
                } else if (j4 == j2) {
                    if (!this.cancelled) {
                        aVar.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j5 == j) {
                        this.index = j4;
                        j = addAndGet(-j5);
                        if (j == 0) {
                            return;
                        }
                        j5 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
