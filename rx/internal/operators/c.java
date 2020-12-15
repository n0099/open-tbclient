package rx.internal.operators;

import java.util.Arrays;
import rx.d;
import rx.exceptions.CompositeException;
/* loaded from: classes12.dex */
public class c<T> implements d.a<T> {
    private final rx.d<T> pPC;
    private final rx.e<? super T> pQd;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public c(rx.d<T> dVar, rx.e<? super T> eVar) {
        this.pPC = dVar;
        this.pQd = eVar;
    }

    public void call(rx.j<? super T> jVar) {
        this.pPC.a((rx.j) new a(jVar, this.pQd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a<T> extends rx.j<T> {
        private boolean done;
        private final rx.e<? super T> pQd;
        private final rx.j<? super T> subscriber;

        a(rx.j<? super T> jVar, rx.e<? super T> eVar) {
            super(jVar);
            this.subscriber = jVar;
            this.pQd = eVar;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                try {
                    this.pQd.onCompleted();
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
                this.pQd.onError(th);
                this.subscriber.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.J(th2);
                this.subscriber.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.pQd.onNext(t);
                    this.subscriber.onNext(t);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this, t);
                }
            }
        }
    }
}
