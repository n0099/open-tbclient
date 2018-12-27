package rx.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rx.j;
/* loaded from: classes2.dex */
public class h<T> extends j<T> {
    private static final rx.e<Object> iQz = new rx.e<Object>() { // from class: rx.b.h.1
        @Override // rx.e
        public void onCompleted() {
        }

        @Override // rx.e
        public void onError(Throwable th) {
        }

        @Override // rx.e
        public void onNext(Object obj) {
        }
    };
    private final rx.e<T> iQu;
    private final List<Throwable> iQv;
    private int iQw;
    private final CountDownLatch iQx;
    private volatile Thread iQy;
    private volatile int valueCount;
    private final List<T> values;

    public h(long j) {
        this(iQz, j);
    }

    public h(rx.e<T> eVar, long j) {
        this.iQx = new CountDownLatch(1);
        if (eVar == null) {
            throw new NullPointerException();
        }
        this.iQu = eVar;
        if (j >= 0) {
            request(j);
        }
        this.values = new ArrayList();
        this.iQv = new ArrayList();
    }

    public h() {
        this(-1L);
    }

    @Override // rx.e
    public void onCompleted() {
        try {
            this.iQw++;
            this.iQy = Thread.currentThread();
            this.iQu.onCompleted();
        } finally {
            this.iQx.countDown();
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        try {
            this.iQy = Thread.currentThread();
            this.iQv.add(th);
            this.iQu.onError(th);
        } finally {
            this.iQx.countDown();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQy = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.iQu.onNext(t);
    }
}
