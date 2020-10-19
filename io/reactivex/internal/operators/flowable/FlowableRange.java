package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes17.dex */
public final class FlowableRange extends io.reactivex.g<Integer> {
    final int end;
    final int start;

    @Override // io.reactivex.g
    public void a(org.a.c<? super Integer> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            cVar.onSubscribe(new RangeConditionalSubscription((io.reactivex.internal.a.a) cVar, this.start, this.end));
        } else {
            cVar.onSubscribe(new RangeSubscription(cVar, this.start, this.end));
        }
    }

    /* loaded from: classes17.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        abstract void fastPath();

        abstract void slowPath(long j);

        BaseRangeSubscription(int i, int i2) {
            this.index = i;
            this.end = i2;
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int i) {
            return i & 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.a.g
        public final Integer poll() {
            int i = this.index;
            if (i == this.end) {
                return null;
            }
            this.index = i + 1;
            return Integer.valueOf(i);
        }

        @Override // io.reactivex.internal.a.g
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.a.g
        public final void clear() {
            this.index = this.end;
        }

        @Override // org.a.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
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

    /* loaded from: classes17.dex */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.c<? super Integer> actual;

        RangeSubscription(org.a.c<? super Integer> cVar, int i, int i2) {
            super(i, i2);
            this.actual = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int i = this.end;
            org.a.c<? super Integer> cVar = this.actual;
            for (int i2 = this.index; i2 != i; i2++) {
                if (!this.cancelled) {
                    cVar.onNext(Integer.valueOf(i2));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long j) {
            int i = this.end;
            int i2 = this.index;
            org.a.c<? super Integer> cVar = this.actual;
            long j2 = 0;
            while (true) {
                if (j2 != j && i2 != i) {
                    if (!this.cancelled) {
                        cVar.onNext(Integer.valueOf(i2));
                        j2++;
                        i2++;
                    } else {
                        return;
                    }
                } else if (i2 == i) {
                    if (!this.cancelled) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j2 == j) {
                        this.index = i2;
                        j = addAndGet(-j2);
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

    /* loaded from: classes17.dex */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.internal.a.a<? super Integer> actual;

        RangeConditionalSubscription(io.reactivex.internal.a.a<? super Integer> aVar, int i, int i2) {
            super(i, i2);
            this.actual = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int i = this.end;
            io.reactivex.internal.a.a<? super Integer> aVar = this.actual;
            for (int i2 = this.index; i2 != i; i2++) {
                if (!this.cancelled) {
                    aVar.tryOnNext(Integer.valueOf(i2));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                aVar.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long j) {
            int i = this.end;
            int i2 = this.index;
            io.reactivex.internal.a.a<? super Integer> aVar = this.actual;
            int i3 = i2;
            long j2 = 0;
            while (true) {
                if (j2 != j && i3 != i) {
                    if (!this.cancelled) {
                        if (aVar.tryOnNext(Integer.valueOf(i3))) {
                            j2++;
                        }
                        i3++;
                    } else {
                        return;
                    }
                } else if (i3 == i) {
                    if (!this.cancelled) {
                        aVar.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j2 == j) {
                        this.index = i3;
                        j = addAndGet(-j2);
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
