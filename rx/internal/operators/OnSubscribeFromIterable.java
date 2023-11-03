package rx.internal.operators;

import com.baidu.tieba.hkc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.ujc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements ijc.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements kjc {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final ojc<? super T> o;

        public IterableProducer(ojc<? super T> ojcVar, Iterator<? extends T> it) {
            this.o = ojcVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            ojc<? super T> ojcVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!ojcVar.isUnsubscribed()) {
                try {
                    ojcVar.onNext((T) it.next());
                    if (ojcVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!ojcVar.isUnsubscribed()) {
                                ojcVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        ujc.f(th, ojcVar);
                        return;
                    }
                } catch (Throwable th2) {
                    ujc.f(th2, ojcVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.kjc
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && hkc.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            ojc<? super T> ojcVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (ojcVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            ojcVar.onNext((T) it.next());
                            if (ojcVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!ojcVar.isUnsubscribed()) {
                                        ojcVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                ujc.f(th, ojcVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            ujc.f(th2, ojcVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = hkc.g(this, j2);
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
    @Override // com.baidu.tieba.wjc
    /* renamed from: a */
    public void call(ojc<? super T> ojcVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!ojcVar.isUnsubscribed()) {
                if (!hasNext) {
                    ojcVar.onCompleted();
                } else {
                    ojcVar.f(new IterableProducer(ojcVar, it));
                }
            }
        } catch (Throwable th) {
            ujc.f(th, ojcVar);
        }
    }
}
