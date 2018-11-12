package rx.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import rx.j;
/* loaded from: classes2.dex */
public class h<T> extends j<T> {
    private static final rx.e<Object> iGi = new rx.e<Object>() { // from class: rx.b.h.1
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
    private final rx.e<T> iGd;
    private final List<Throwable> iGe;
    private int iGf;
    private final CountDownLatch iGg;
    private volatile Thread iGh;
    private volatile int valueCount;
    private final List<T> values;

    public h(long j) {
        this(iGi, j);
    }

    public h(rx.e<T> eVar, long j) {
        this.iGg = new CountDownLatch(1);
        if (eVar == null) {
            throw new NullPointerException();
        }
        this.iGd = eVar;
        if (j >= 0) {
            request(j);
        }
        this.values = new ArrayList();
        this.iGe = new ArrayList();
    }

    public h() {
        this(-1L);
    }

    @Override // rx.e
    public void onCompleted() {
        try {
            this.iGf++;
            this.iGh = Thread.currentThread();
            this.iGd.onCompleted();
        } finally {
            this.iGg.countDown();
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        try {
            this.iGh = Thread.currentThread();
            this.iGe.add(th);
            this.iGd.onError(th);
        } finally {
            this.iGg.countDown();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iGh = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.iGd.onNext(t);
    }
}
