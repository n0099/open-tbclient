package rx.internal.operators;

import h.d;
import h.f;
import h.j;
import h.m.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class OnSubscribeFromIterable<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final Iterable<? extends T> f69163e;

    /* loaded from: classes7.dex */
    public static final class IterableProducer<T> extends AtomicLong implements f {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final j<? super T> o;

        public IterableProducer(j<? super T> jVar, Iterator<? extends T> it) {
            this.o = jVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            j<? super T> jVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!jVar.isUnsubscribed()) {
                try {
                    jVar.onNext((T) it.next());
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            jVar.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        a.f(th, jVar);
                        return;
                    }
                } catch (Throwable th2) {
                    a.f(th2, jVar);
                    return;
                }
            }
        }

        @Override // h.f
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j <= 0 || h.o.a.a.b(this, j) != 0) {
            } else {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            j<? super T> jVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            jVar.onNext((T) it.next());
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (jVar.isUnsubscribed()) {
                                        return;
                                    }
                                    jVar.onCompleted();
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                a.f(th, jVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            a.f(th2, jVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = h.o.a.a.g(this, j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f69163e = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(j<? super T> jVar) {
        try {
            Iterator<? extends T> it = this.f69163e.iterator();
            boolean hasNext = it.hasNext();
            if (jVar.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                jVar.onCompleted();
            } else {
                jVar.setProducer(new IterableProducer(jVar, it));
            }
        } catch (Throwable th) {
            a.f(th, jVar);
        }
    }
}
