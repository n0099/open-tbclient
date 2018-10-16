package rx.internal.operators;
/* loaded from: classes2.dex */
public abstract class c<T, R> extends b<T, R> {
    protected boolean done;

    public c(rx.j<? super R> jVar) {
        super(jVar);
    }

    @Override // rx.internal.operators.b, rx.e
    public void onError(Throwable th) {
        if (!this.done) {
            this.done = true;
            super.onError(th);
            return;
        }
        rx.c.c.onError(th);
    }

    @Override // rx.internal.operators.b, rx.e
    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            super.onCompleted();
        }
    }
}
