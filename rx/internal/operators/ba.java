package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public class ba<T> implements d.b<T, T> {
    final rx.functions.b<? super T> ixB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ba<Object> ixE = new ba<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ba<T> ccl() {
        return (ba<T>) a.ixE;
    }

    ba() {
        this(null);
    }

    public ba(rx.functions.b<? super T> bVar) {
        this.ixB = bVar;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        final AtomicLong atomicLong = new AtomicLong();
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.ba.1
            @Override // rx.f
            public void request(long j) {
                rx.internal.operators.a.a(atomicLong, j);
            }
        });
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.ba.2
            boolean done;

            @Override // rx.j
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    jVar.onCompleted();
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    jVar.onError(th);
                    return;
                }
                rx.c.c.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                if (!this.done) {
                    if (atomicLong.get() > 0) {
                        jVar.onNext(t);
                        atomicLong.decrementAndGet();
                    } else if (ba.this.ixB != null) {
                        try {
                            ba.this.ixB.call(t);
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, this, t);
                        }
                    }
                }
            }
        };
    }
}
