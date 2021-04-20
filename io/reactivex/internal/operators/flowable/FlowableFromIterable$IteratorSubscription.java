package io.reactivex.internal.operators.flowable;

import f.b.u.a;
import g.d.c;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class FlowableFromIterable$IteratorSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    public static final long serialVersionUID = -6022804456014692607L;
    public final c<? super T> actual;

    public FlowableFromIterable$IteratorSubscription(c<? super T> cVar, Iterator<? extends T> it) {
        super(it);
        this.actual = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void fastPath() {
        Iterator<? extends T> it = this.it;
        c<? super T> cVar = this.actual;
        while (!this.cancelled) {
            try {
                Object obj = (T) it.next();
                if (this.cancelled) {
                    return;
                }
                if (obj == null) {
                    cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                }
                cVar.onNext(obj);
                if (this.cancelled) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        if (this.cancelled) {
                            return;
                        }
                        cVar.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    a.a(th);
                    cVar.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                a.a(th2);
                cVar.onError(th2);
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void slowPath(long j) {
        Iterator<? extends T> it = this.it;
        c<? super T> cVar = this.actual;
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
                            cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        cVar.onNext(obj);
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (this.cancelled) {
                                    return;
                                }
                                cVar.onComplete();
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            a.a(th);
                            cVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        a.a(th2);
                        cVar.onError(th2);
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
