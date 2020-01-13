package io.reactivex.internal.subscribers;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import org.a.d;
/* loaded from: classes5.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements j<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected d s;

    public DeferredScalarSubscriber(org.a.c<? super R> cVar) {
        super(cVar);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }
}
