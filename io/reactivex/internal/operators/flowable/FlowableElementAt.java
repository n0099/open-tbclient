package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public final class FlowableElementAt<T> extends a<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nvK.a((j) new ElementAtSubscriber(cVar, this.index, this.defaultValue, this.errorOnFewer));
    }

    /* loaded from: classes5.dex */
    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        org.a.d s;

        ElementAtSubscriber(org.a.c<? super T> cVar, long j, T t, boolean z) {
            super(cVar);
            this.index = j;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.s.cancel();
                    complete(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t = this.defaultValue;
                if (t == null) {
                    if (this.errorOnFewer) {
                        this.actual.onError(new NoSuchElementException());
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                }
                complete(t);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
