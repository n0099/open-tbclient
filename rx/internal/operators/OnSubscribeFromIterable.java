package rx.internal.operators;

import com.baidu.tieba.asa;
import com.baidu.tieba.jsa;
import com.baidu.tieba.ora;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements ora.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements qra {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final ura<? super T> o;

        public IterableProducer(ura<? super T> uraVar, Iterator<? extends T> it) {
            this.o = uraVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            ura<? super T> uraVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!uraVar.isUnsubscribed()) {
                try {
                    uraVar.onNext((T) it.next());
                    if (uraVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!uraVar.isUnsubscribed()) {
                                uraVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        asa.f(th, uraVar);
                        return;
                    }
                } catch (Throwable th2) {
                    asa.f(th2, uraVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.qra
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && jsa.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            ura<? super T> uraVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (uraVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            uraVar.onNext((T) it.next());
                            if (uraVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!uraVar.isUnsubscribed()) {
                                        uraVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                asa.f(th, uraVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            asa.f(th2, uraVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = jsa.g(this, j2);
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

    public void call(ura<? super T> uraVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!uraVar.isUnsubscribed()) {
                if (!hasNext) {
                    uraVar.onCompleted();
                } else {
                    uraVar.f(new IterableProducer(uraVar, it));
                }
            }
        } catch (Throwable th) {
            asa.f(th, uraVar);
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
