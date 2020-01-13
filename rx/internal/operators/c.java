package rx.internal.operators;

import java.util.Arrays;
import rx.d;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public class c<T> implements d.a<T> {
    private final rx.d<T> nMM;
    private final rx.e<? super T> nNn;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public c(rx.d<T> dVar, rx.e<? super T> eVar) {
        this.nMM = dVar;
        this.nNn = eVar;
    }

    public void call(rx.j<? super T> jVar) {
        this.nMM.a((rx.j) new a(jVar, this.nNn));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> {
        private boolean done;
        private final rx.e<? super T> nNn;
        private final rx.j<? super T> subscriber;

        a(rx.j<? super T> jVar, rx.e<? super T> eVar) {
            super(jVar);
            this.subscriber = jVar;
            this.nNn = eVar;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                try {
                    this.nNn.onCompleted();
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
                this.nNn.onError(th);
                this.subscriber.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.I(th2);
                this.subscriber.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.nNn.onNext(t);
                    this.subscriber.onNext(t);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this, t);
                }
            }
        }
    }
}
