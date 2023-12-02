package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.doc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.poc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements doc.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements foc {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final joc<? super T> o;

        public IterableProducer(joc<? super T> jocVar, Iterator<? extends T> it) {
            this.o = jocVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            joc<? super T> jocVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!jocVar.isUnsubscribed()) {
                try {
                    jocVar.onNext((T) it.next());
                    if (jocVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!jocVar.isUnsubscribed()) {
                                jocVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        poc.f(th, jocVar);
                        return;
                    }
                } catch (Throwable th2) {
                    poc.f(th2, jocVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && cpc.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            joc<? super T> jocVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (jocVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            jocVar.onNext((T) it.next());
                            if (jocVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!jocVar.isUnsubscribed()) {
                                        jocVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                poc.f(th, jocVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            poc.f(th2, jocVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = cpc.g(this, j2);
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
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    public void call(joc<? super T> jocVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!jocVar.isUnsubscribed()) {
                if (!hasNext) {
                    jocVar.onCompleted();
                } else {
                    jocVar.f(new IterableProducer(jocVar, it));
                }
            }
        } catch (Throwable th) {
            poc.f(th, jocVar);
        }
    }
}
