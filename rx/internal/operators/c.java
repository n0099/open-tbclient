package rx.internal.operators;

import java.util.Arrays;
import rx.d;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public class c<T> implements d.a<T> {
    private final rx.d<T> qyO;
    private final rx.e<? super T> qzp;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public c(rx.d<T> dVar, rx.e<? super T> eVar) {
        this.qyO = dVar;
        this.qzp = eVar;
    }

    public void call(rx.j<? super T> jVar) {
        this.qyO.a((rx.j) new a(jVar, this.qzp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> {
        private boolean done;
        private final rx.e<? super T> qzp;
        private final rx.j<? super T> subscriber;

        a(rx.j<? super T> jVar, rx.e<? super T> eVar) {
            super(jVar);
            this.subscriber = jVar;
            this.qzp = eVar;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                try {
                    this.qzp.onCompleted();
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
                this.qzp.onError(th);
                this.subscriber.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.N(th2);
                this.subscriber.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.qzp.onNext(t);
                    this.subscriber.onNext(t);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this, t);
                }
            }
        }
    }
}
