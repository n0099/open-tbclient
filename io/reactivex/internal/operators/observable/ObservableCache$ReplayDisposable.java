package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.x.e.c.c;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableCache$ReplayDisposable<T> extends AtomicInteger implements b {
    public static final long serialVersionUID = 7058506693698832024L;
    public volatile boolean cancelled;
    public final o<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public int index;
    public final c<T> state;

    public ObservableCache$ReplayDisposable(o<? super T> oVar, c<T> cVar) {
        this.child = oVar;
        this.state = cVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.state.c(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void replay() {
        if (getAndIncrement() != 0) {
            return;
        }
        o<? super T> oVar = this.child;
        int i = 1;
        while (!this.cancelled) {
            int b2 = this.state.b();
            if (b2 != 0) {
                Object[] objArr = this.currentBuffer;
                if (objArr == null) {
                    objArr = this.state.a();
                    this.currentBuffer = objArr;
                }
                int length = objArr.length - 1;
                int i2 = this.index;
                int i3 = this.currentIndexInBuffer;
                while (i2 < b2) {
                    if (this.cancelled) {
                        return;
                    }
                    if (i3 == length) {
                        objArr = (Object[]) objArr[length];
                        i3 = 0;
                    }
                    if (NotificationLite.accept(objArr[i3], oVar)) {
                        return;
                    }
                    i3++;
                    i2++;
                }
                if (this.cancelled) {
                    return;
                }
                this.index = i2;
                this.currentIndexInBuffer = i3;
                this.currentBuffer = objArr;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }
}
