package rx.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rx.j;
/* loaded from: classes2.dex */
public class h<T> extends j<T> {
    private static final rx.e<Object> iRH = new rx.e<Object>() { // from class: rx.b.h.1
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
    private final rx.e<T> iRC;
    private final List<Throwable> iRD;
    private int iRE;
    private final CountDownLatch iRF;
    private volatile Thread iRG;
    private volatile int valueCount;
    private final List<T> values;

    public h(long j) {
        this(iRH, j);
    }

    public h(rx.e<T> eVar, long j) {
        this.iRF = new CountDownLatch(1);
        if (eVar == null) {
            throw new NullPointerException();
        }
        this.iRC = eVar;
        if (j >= 0) {
            request(j);
        }
        this.values = new ArrayList();
        this.iRD = new ArrayList();
    }

    public h() {
        this(-1L);
    }

    @Override // rx.e
    public void onCompleted() {
        try {
            this.iRE++;
            this.iRG = Thread.currentThread();
            this.iRC.onCompleted();
        } finally {
            this.iRF.countDown();
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        try {
            this.iRG = Thread.currentThread();
            this.iRD.add(th);
            this.iRC.onError(th);
        } finally {
            this.iRF.countDown();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iRG = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.iRC.onNext(t);
    }
}
