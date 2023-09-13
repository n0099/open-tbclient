package rx.internal.operators;

import com.baidu.tieba.ebc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements sac.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements uac {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final yac<? super T> o;

        public IterableProducer(yac<? super T> yacVar, Iterator<? extends T> it) {
            this.o = yacVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            yac<? super T> yacVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!yacVar.isUnsubscribed()) {
                try {
                    yacVar.onNext((T) it.next());
                    if (yacVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!yacVar.isUnsubscribed()) {
                                yacVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        ebc.f(th, yacVar);
                        return;
                    }
                } catch (Throwable th2) {
                    ebc.f(th2, yacVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && pbc.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            yac<? super T> yacVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (yacVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            yacVar.onNext((T) it.next());
                            if (yacVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!yacVar.isUnsubscribed()) {
                                        yacVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                ebc.f(th, yacVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            ebc.f(th2, yacVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = pbc.g(this, j2);
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

    public void call(yac<? super T> yacVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!yacVar.isUnsubscribed()) {
                if (!hasNext) {
                    yacVar.onCompleted();
                } else {
                    yacVar.f(new IterableProducer(yacVar, it));
                }
            }
        } catch (Throwable th) {
            ebc.f(th, yacVar);
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
