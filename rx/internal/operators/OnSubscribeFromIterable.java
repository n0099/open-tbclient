package rx.internal.operators;

import com.baidu.tieba.hdc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.wcc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements kcc.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements mcc {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final qcc<? super T> o;

        public IterableProducer(qcc<? super T> qccVar, Iterator<? extends T> it) {
            this.o = qccVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            qcc<? super T> qccVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!qccVar.isUnsubscribed()) {
                try {
                    qccVar.onNext((T) it.next());
                    if (qccVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!qccVar.isUnsubscribed()) {
                                qccVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        wcc.f(th, qccVar);
                        return;
                    }
                } catch (Throwable th2) {
                    wcc.f(th2, qccVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.mcc
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && hdc.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            qcc<? super T> qccVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (qccVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            qccVar.onNext((T) it.next());
                            if (qccVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!qccVar.isUnsubscribed()) {
                                        qccVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                wcc.f(th, qccVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            wcc.f(th2, qccVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = hdc.g(this, j2);
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

    public void call(qcc<? super T> qccVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!qccVar.isUnsubscribed()) {
                if (!hasNext) {
                    qccVar.onCompleted();
                } else {
                    qccVar.f(new IterableProducer(qccVar, it));
                }
            }
        } catch (Throwable th) {
            wcc.f(th, qccVar);
        }
    }

    @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((qcc) ((qcc) obj));
    }
}
