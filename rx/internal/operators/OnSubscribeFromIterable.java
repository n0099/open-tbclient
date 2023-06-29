package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.ttb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.zsb;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements xsb.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements zsb {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final dtb<? super T> o;

        public IterableProducer(dtb<? super T> dtbVar, Iterator<? extends T> it) {
            this.o = dtbVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            dtb<? super T> dtbVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!dtbVar.isUnsubscribed()) {
                try {
                    dtbVar.onNext((T) it.next());
                    if (dtbVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!dtbVar.isUnsubscribed()) {
                                dtbVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        jtb.f(th, dtbVar);
                        return;
                    }
                } catch (Throwable th2) {
                    jtb.f(th2, dtbVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.zsb
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && ttb.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            dtb<? super T> dtbVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (dtbVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            dtbVar.onNext((T) it.next());
                            if (dtbVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!dtbVar.isUnsubscribed()) {
                                        dtbVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                jtb.f(th, dtbVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            jtb.f(th2, dtbVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = ttb.g(this, j2);
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

    public void call(dtb<? super T> dtbVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!dtbVar.isUnsubscribed()) {
                if (!hasNext) {
                    dtbVar.onCompleted();
                } else {
                    dtbVar.f(new IterableProducer(dtbVar, it));
                }
            }
        } catch (Throwable th) {
            jtb.f(th, dtbVar);
        }
    }

    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dtb) ((dtb) obj));
    }
}
