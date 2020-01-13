package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import org.a.d;
/* loaded from: classes5.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements j<T>, d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final org.a.c<? super R> actual;
    protected long produced;
    protected d s;
    protected R value;

    public SinglePostCompleteSubscriber(org.a.c<? super R> cVar) {
        this.actual = cVar;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            io.reactivex.internal.util.b.c(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                onDrop(r);
                return;
            } else if ((j2 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.onNext(r);
                this.actual.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                }
                this.value = null;
            }
        }
    }

    protected void onDrop(R r) {
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: R, ? super R */
    @Override // org.a.d
    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.actual.onNext((R) this.value);
                        this.actual.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, io.reactivex.internal.util.b.ae(j2, j)));
            this.s.request(j);
        }
    }

    public void cancel() {
        this.s.cancel();
    }
}
