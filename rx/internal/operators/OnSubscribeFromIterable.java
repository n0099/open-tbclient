package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements d.a<T> {
    final Iterable<? extends T> knZ;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.knZ = iterable;
    }

    public void call(rx.j<? super T> jVar) {
        try {
            Iterator<? extends T> it = this.knZ.iterator();
            boolean hasNext = it.hasNext();
            if (!jVar.isUnsubscribed()) {
                if (!hasNext) {
                    jVar.onCompleted();
                } else {
                    jVar.setProducer(new IterableProducer(jVar, it));
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements rx.f {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final rx.j<? super T> o;

        IterableProducer(rx.j<? super T> jVar, Iterator<? extends T> it) {
            this.o = jVar;
            this.it = it;
        }

        @Override // rx.f
        public void request(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && a.a(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        void slowPath(long j) {
            rx.j<? super T> jVar = this.o;
            Iterator<? extends T> it = this.it;
            long j2 = 0;
            while (true) {
                if (j2 != j) {
                    if (!jVar.isUnsubscribed()) {
                        try {
                            jVar.onNext((T) it.next());
                            if (!jVar.isUnsubscribed()) {
                                try {
                                    if (!it.hasNext()) {
                                        if (!jVar.isUnsubscribed()) {
                                            jVar.onCompleted();
                                            return;
                                        }
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    rx.exceptions.a.a(th, jVar);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            rx.exceptions.a.a(th2, jVar);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    j = get();
                    if (j2 == j) {
                        j = a.b(this, j2);
                        if (j == 0) {
                            return;
                        }
                        j2 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        void fastPath() {
            rx.j<? super T> jVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!jVar.isUnsubscribed()) {
                try {
                    jVar.onNext((T) it.next());
                    if (!jVar.isUnsubscribed()) {
                        try {
                            if (!it.hasNext()) {
                                if (!jVar.isUnsubscribed()) {
                                    jVar.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, jVar);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.a(th2, jVar);
                    return;
                }
            }
        }
    }
}
