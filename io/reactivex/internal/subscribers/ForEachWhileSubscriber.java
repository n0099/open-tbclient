package io.reactivex.internal.subscribers;

import com.google.android.exoplayer2.Format;
import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes4.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<d> implements io.reactivex.disposables.b, j<T> {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final io.reactivex.b.j<? super T> onNext;

    public ForEachWhileSubscriber(io.reactivex.b.j<? super T> jVar, g<? super Throwable> gVar, io.reactivex.b.a aVar) {
        this.onNext = jVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Format.OFFSET_SAMPLE_RELATIVE);
    }

    @Override // org.a.c
    public void onNext(T t) {
        if (!this.done) {
            try {
                if (!this.onNext.test(t)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                dispose();
                onError(th);
            }
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.d.a.onError(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.I(th2);
            io.reactivex.d.a.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.a.c
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                io.reactivex.d.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }
}
