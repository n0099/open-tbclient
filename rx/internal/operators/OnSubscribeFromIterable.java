package rx.internal.operators;

import com.baidu.tieba.ikc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.vjc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements jjc.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements ljc {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final pjc<? super T> o;

        public IterableProducer(pjc<? super T> pjcVar, Iterator<? extends T> it) {
            this.o = pjcVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            pjc<? super T> pjcVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!pjcVar.isUnsubscribed()) {
                try {
                    pjcVar.onNext((T) it.next());
                    if (pjcVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!pjcVar.isUnsubscribed()) {
                                pjcVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        vjc.f(th, pjcVar);
                        return;
                    }
                } catch (Throwable th2) {
                    vjc.f(th2, pjcVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ljc
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && ikc.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            pjc<? super T> pjcVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (pjcVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            pjcVar.onNext((T) it.next());
                            if (pjcVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!pjcVar.isUnsubscribed()) {
                                        pjcVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                vjc.f(th, pjcVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            vjc.f(th2, pjcVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = ikc.g(this, j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xjc
    /* renamed from: a */
    public void call(pjc<? super T> pjcVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!pjcVar.isUnsubscribed()) {
                if (!hasNext) {
                    pjcVar.onCompleted();
                } else {
                    pjcVar.f(new IterableProducer(pjcVar, it));
                }
            }
        } catch (Throwable th) {
            vjc.f(th, pjcVar);
        }
    }
}
