package rx.internal.operators;

import com.baidu.tieba.dpc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.goc;
import com.baidu.tieba.koc;
import com.baidu.tieba.qoc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements eoc.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements goc {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final koc<? super T> o;

        public IterableProducer(koc<? super T> kocVar, Iterator<? extends T> it) {
            this.o = kocVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            koc<? super T> kocVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!kocVar.isUnsubscribed()) {
                try {
                    kocVar.onNext((T) it.next());
                    if (kocVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!kocVar.isUnsubscribed()) {
                                kocVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        qoc.f(th, kocVar);
                        return;
                    }
                } catch (Throwable th2) {
                    qoc.f(th2, kocVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.goc
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && dpc.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            koc<? super T> kocVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (kocVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            kocVar.onNext((T) it.next());
                            if (kocVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!kocVar.isUnsubscribed()) {
                                        kocVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                qoc.f(th, kocVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            qoc.f(th2, kocVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = dpc.g(this, j2);
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
    @Override // com.baidu.tieba.soc
    /* renamed from: a */
    public void call(koc<? super T> kocVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!kocVar.isUnsubscribed()) {
                if (!hasNext) {
                    kocVar.onCompleted();
                } else {
                    kocVar.f(new IterableProducer(kocVar, it));
                }
            }
        } catch (Throwable th) {
            qoc.f(th, kocVar);
        }
    }
}
