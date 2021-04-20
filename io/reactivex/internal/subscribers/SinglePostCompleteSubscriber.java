package io.reactivex.internal.subscribers;

import f.b.g;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements g<T>, d {
    public static final long COMPLETE_MASK = Long.MIN_VALUE;
    public static final long REQUEST_MASK = Long.MAX_VALUE;
    public static final long serialVersionUID = 7917814472626990048L;
    public final c<? super R> actual;
    public long produced;
    public d s;
    public R value;

    public SinglePostCompleteSubscriber(c<? super R> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
    }

    public final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            b.e(this, j);
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

    public abstract /* synthetic */ void onComplete();

    public void onDrop(R r) {
    }

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(T t);

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    /* JADX DEBUG: Type inference failed for r11v0. Raw type applied. Possible types: R, ? super R */
    @Override // g.d.d
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
            } while (!compareAndSet(j2, b.c(j2, j)));
            this.s.request(j);
        }
    }
}
