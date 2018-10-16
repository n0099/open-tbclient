package rx.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rx.j;
/* loaded from: classes2.dex */
public class h<T> extends j<T> {
    private static final rx.e<Object> iEx = new rx.e<Object>() { // from class: rx.b.h.1
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
    private final rx.e<T> iEs;
    private final List<Throwable> iEt;
    private int iEu;
    private final CountDownLatch iEv;
    private volatile Thread iEw;
    private volatile int valueCount;
    private final List<T> values;

    public h(long j) {
        this(iEx, j);
    }

    public h(rx.e<T> eVar, long j) {
        this.iEv = new CountDownLatch(1);
        if (eVar == null) {
            throw new NullPointerException();
        }
        this.iEs = eVar;
        if (j >= 0) {
            request(j);
        }
        this.values = new ArrayList();
        this.iEt = new ArrayList();
    }

    public h() {
        this(-1L);
    }

    @Override // rx.e
    public void onCompleted() {
        try {
            this.iEu++;
            this.iEw = Thread.currentThread();
            this.iEs.onCompleted();
        } finally {
            this.iEv.countDown();
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        try {
            this.iEw = Thread.currentThread();
            this.iEt.add(th);
            this.iEs.onError(th);
        } finally {
            this.iEv.countDown();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iEw = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.iEs.onNext(t);
    }
}
