package io.reactivex.internal.operators.observable;

import f.b.o;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
/* loaded from: classes7.dex */
public final class ObservableRange$RangeDisposable extends BasicIntQueueDisposable<Integer> {
    public static final long serialVersionUID = 396518478098735504L;
    public final o<? super Integer> actual;
    public final long end;
    public boolean fused;
    public long index;

    public ObservableRange$RangeDisposable(o<? super Integer> oVar, long j, long j2) {
        this.actual = oVar;
        this.index = j;
        this.end = j2;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public void clear() {
        this.index = this.end;
        lazySet(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public void dispose() {
        set(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public boolean isDisposed() {
        return get() != 0;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public boolean isEmpty() {
        return this.index == this.end;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.c
    public int requestFusion(int i) {
        if ((i & 1) != 0) {
            this.fused = true;
            return 1;
        }
        return 0;
    }

    public void run() {
        if (this.fused) {
            return;
        }
        o<? super Integer> oVar = this.actual;
        long j = this.end;
        for (long j2 = this.index; j2 != j && get() == 0; j2++) {
            oVar.onNext(Integer.valueOf((int) j2));
        }
        if (get() == 0) {
            lazySet(1);
            oVar.onComplete();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public Integer poll() throws Exception {
        long j = this.index;
        if (j != this.end) {
            this.index = 1 + j;
            return Integer.valueOf((int) j);
        }
        lazySet(1);
        return null;
    }
}
