package rx.internal.operators;

import java.util.Arrays;
import rx.d;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public class c<T> implements d.a<T> {
    private final rx.e<? super T> obP;
    private final rx.d<T> obo;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public c(rx.d<T> dVar, rx.e<? super T> eVar) {
        this.obo = dVar;
        this.obP = eVar;
    }

    public void call(rx.j<? super T> jVar) {
        this.obo.a((rx.j) new a(jVar, this.obP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> {
        private boolean done;
        private final rx.e<? super T> obP;
        private final rx.j<? super T> subscriber;

        a(rx.j<? super T> jVar, rx.e<? super T> eVar) {
            super(jVar);
            this.subscriber = jVar;
            this.obP = eVar;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                try {
                    this.obP.onCompleted();
                    this.done = true;
                    this.subscriber.onCompleted();
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.done = true;
            try {
                this.obP.onError(th);
                this.subscriber.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.L(th2);
                this.subscriber.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.obP.onNext(t);
                    this.subscriber.onNext(t);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this, t);
                }
            }
        }
    }
}
