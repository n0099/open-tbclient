package rx.b;

import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.k;
/* loaded from: classes12.dex */
public final class b implements rx.c, k {
    final rx.c actual;
    boolean done;
    k pUQ;

    public b(rx.c cVar) {
        this.actual = cVar;
    }

    @Override // rx.c
    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.J(th);
                throw new OnCompletedFailedException(th);
            }
        }
    }

    @Override // rx.c
    public void onError(Throwable th) {
        rx.c.c.onError(th);
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.J(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }

    @Override // rx.c
    public void onSubscribe(k kVar) {
        this.pUQ = kVar;
        try {
            this.actual.onSubscribe(this);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        this.pUQ.unsubscribe();
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.done || this.pUQ.isUnsubscribed();
    }
}
