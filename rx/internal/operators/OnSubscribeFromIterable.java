package rx.internal.operators;

import com.baidu.tieba.ena;
import com.baidu.tieba.nna;
import com.baidu.tieba.sma;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements sma.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements uma {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final yma<? super T> o;

        public IterableProducer(yma<? super T> ymaVar, Iterator<? extends T> it) {
            this.o = ymaVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            yma<? super T> ymaVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!ymaVar.isUnsubscribed()) {
                try {
                    ymaVar.onNext((T) it.next());
                    if (ymaVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!ymaVar.isUnsubscribed()) {
                                ymaVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        ena.f(th, ymaVar);
                        return;
                    }
                } catch (Throwable th2) {
                    ena.f(th2, ymaVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.uma
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && nna.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            yma<? super T> ymaVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (ymaVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            ymaVar.onNext((T) it.next());
                            if (ymaVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!ymaVar.isUnsubscribed()) {
                                        ymaVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                ena.f(th, ymaVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            ena.f(th2, ymaVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = nna.g(this, j2);
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

    public void call(yma<? super T> ymaVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!ymaVar.isUnsubscribed()) {
                if (!hasNext) {
                    ymaVar.onCompleted();
                } else {
                    ymaVar.f(new IterableProducer(ymaVar, it));
                }
            }
        } catch (Throwable th) {
            ena.f(th, ymaVar);
        }
    }

    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yma) ((yma) obj));
    }
}
