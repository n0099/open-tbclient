package io.reactivex.internal.operators.flowable;

import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableCache$ReplaySubscription<T> extends AtomicInteger implements d {
    public static final long serialVersionUID = -2557562030197141021L;
    public final c<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public int index;
    public final AtomicLong requested = new AtomicLong();
    public final f.b.x.e.a.c<T> state;

    public FlowableCache$ReplaySubscription(c<? super T> cVar, f.b.x.e.a.c<T> cVar2) {
        this.child = cVar;
        this.state = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.requested.getAndSet(-1L) != -1) {
            this.state.c(this);
        }
    }

    public void replay() {
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.child;
        AtomicLong atomicLong = this.requested;
        int i = 1;
        int i2 = 1;
        while (true) {
            long j = atomicLong.get();
            if (j < 0) {
                return;
            }
            int b2 = this.state.b();
            if (b2 != 0) {
                Object[] objArr = this.currentBuffer;
                if (objArr == null) {
                    objArr = this.state.a();
                    this.currentBuffer = objArr;
                }
                int length = objArr.length - i;
                int i3 = this.index;
                int i4 = this.currentIndexInBuffer;
                int i5 = 0;
                while (i3 < b2 && j > 0) {
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (i4 == length) {
                        objArr = (Object[]) objArr[length];
                        i4 = 0;
                    }
                    if (NotificationLite.accept(objArr[i4], cVar)) {
                        return;
                    }
                    i4++;
                    i3++;
                    j--;
                    i5++;
                }
                if (atomicLong.get() == -1) {
                    return;
                }
                if (j == 0) {
                    Object obj = objArr[i4];
                    if (NotificationLite.isComplete(obj)) {
                        cVar.onComplete();
                        return;
                    } else if (NotificationLite.isError(obj)) {
                        cVar.onError(NotificationLite.getError(obj));
                        return;
                    }
                }
                if (i5 != 0) {
                    b.f(atomicLong, i5);
                }
                this.index = i3;
                this.currentIndexInBuffer = i4;
                this.currentBuffer = objArr;
            }
            i2 = addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            i = 1;
        }
    }

    @Override // g.d.d
    public void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = this.requested.get();
                if (j2 == -1) {
                    return;
                }
            } while (!this.requested.compareAndSet(j2, b.c(j2, j)));
            replay();
        }
    }
}
