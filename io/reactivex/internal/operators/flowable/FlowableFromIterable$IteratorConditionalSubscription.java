package io.reactivex.internal.operators.flowable;

import f.b.x.c.a;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class FlowableFromIterable$IteratorConditionalSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    public static final long serialVersionUID = -6022804456014692607L;
    public final a<? super T> actual;

    public FlowableFromIterable$IteratorConditionalSubscription(a<? super T> aVar, Iterator<? extends T> it) {
        super(it);
        this.actual = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void fastPath() {
        Iterator<? extends T> it = this.it;
        a<? super T> aVar = this.actual;
        while (!this.cancelled) {
            try {
                Object obj = (T) it.next();
                if (this.cancelled) {
                    return;
                }
                if (obj == null) {
                    aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                }
                aVar.tryOnNext(obj);
                if (this.cancelled) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        if (this.cancelled) {
                            return;
                        }
                        aVar.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    f.b.u.a.a(th);
                    aVar.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                f.b.u.a.a(th2);
                aVar.onError(th2);
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void slowPath(long j) {
        Iterator<? extends T> it = this.it;
        a<? super T> aVar = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j) {
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        Object obj = (T) it.next();
                        if (this.cancelled) {
                            return;
                        }
                        if (obj == null) {
                            aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        boolean tryOnNext = aVar.tryOnNext(obj);
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (this.cancelled) {
                                    return;
                                }
                                aVar.onComplete();
                                return;
                            } else if (tryOnNext) {
                                j2++;
                            }
                        } catch (Throwable th) {
                            f.b.u.a.a(th);
                            aVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        f.b.u.a.a(th2);
                        aVar.onError(th2);
                        return;
                    }
                } else {
                    j = get();
                    if (j2 == j) {
                        j = addAndGet(-j2);
                    }
                }
            }
        } while (j != 0);
    }
}
