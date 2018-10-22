package rx.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rx.j;
/* loaded from: classes2.dex */
public class h<T> extends j<T> {
    private static final rx.e<Object> iEy = new rx.e<Object>() { // from class: rx.b.h.1
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
    private final rx.e<T> iEt;
    private final List<Throwable> iEu;
    private int iEv;
    private final CountDownLatch iEw;
    private volatile Thread iEx;
    private volatile int valueCount;
    private final List<T> values;

    public h(long j) {
        this(iEy, j);
    }

    public h(rx.e<T> eVar, long j) {
        this.iEw = new CountDownLatch(1);
        if (eVar == null) {
            throw new NullPointerException();
        }
        this.iEt = eVar;
        if (j >= 0) {
            request(j);
        }
        this.values = new ArrayList();
        this.iEu = new ArrayList();
    }

    public h() {
        this(-1L);
    }

    @Override // rx.e
    public void onCompleted() {
        try {
            this.iEv++;
            this.iEx = Thread.currentThread();
            this.iEt.onCompleted();
        } finally {
            this.iEw.countDown();
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        try {
            this.iEx = Thread.currentThread();
            this.iEu.add(th);
            this.iEt.onError(th);
        } finally {
            this.iEw.countDown();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iEx = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.iEt.onNext(t);
    }
}
