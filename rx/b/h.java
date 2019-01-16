package rx.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rx.j;
/* loaded from: classes2.dex */
public class h<T> extends j<T> {
    private static final rx.e<Object> iRG = new rx.e<Object>() { // from class: rx.b.h.1
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
    private final rx.e<T> iRB;
    private final List<Throwable> iRC;
    private int iRD;
    private final CountDownLatch iRE;
    private volatile Thread iRF;
    private volatile int valueCount;
    private final List<T> values;

    public h(long j) {
        this(iRG, j);
    }

    public h(rx.e<T> eVar, long j) {
        this.iRE = new CountDownLatch(1);
        if (eVar == null) {
            throw new NullPointerException();
        }
        this.iRB = eVar;
        if (j >= 0) {
            request(j);
        }
        this.values = new ArrayList();
        this.iRC = new ArrayList();
    }

    public h() {
        this(-1L);
    }

    @Override // rx.e
    public void onCompleted() {
        try {
            this.iRD++;
            this.iRF = Thread.currentThread();
            this.iRB.onCompleted();
        } finally {
            this.iRE.countDown();
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        try {
            this.iRF = Thread.currentThread();
            this.iRC.add(th);
            this.iRB.onError(th);
        } finally {
            this.iRE.countDown();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iRF = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.iRB.onNext(t);
    }
}
