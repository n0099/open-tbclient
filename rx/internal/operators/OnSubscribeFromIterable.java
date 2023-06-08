package rx.internal.operators;

import com.baidu.tieba.inb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.zmb;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements nmb.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements pmb {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final tmb<? super T> o;

        public IterableProducer(tmb<? super T> tmbVar, Iterator<? extends T> it) {
            this.o = tmbVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            tmb<? super T> tmbVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!tmbVar.isUnsubscribed()) {
                try {
                    tmbVar.onNext((T) it.next());
                    if (tmbVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!tmbVar.isUnsubscribed()) {
                                tmbVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        zmb.f(th, tmbVar);
                        return;
                    }
                } catch (Throwable th2) {
                    zmb.f(th2, tmbVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.pmb
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && inb.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            tmb<? super T> tmbVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (tmbVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            tmbVar.onNext((T) it.next());
                            if (tmbVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!tmbVar.isUnsubscribed()) {
                                        tmbVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                zmb.f(th, tmbVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            zmb.f(th2, tmbVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = inb.g(this, j2);
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

    public void call(tmb<? super T> tmbVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!tmbVar.isUnsubscribed()) {
                if (!hasNext) {
                    tmbVar.onCompleted();
                } else {
                    tmbVar.f(new IterableProducer(tmbVar, it));
                }
            }
        } catch (Throwable th) {
            zmb.f(th, tmbVar);
        }
    }

    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tmb) ((tmb) obj));
    }
}
