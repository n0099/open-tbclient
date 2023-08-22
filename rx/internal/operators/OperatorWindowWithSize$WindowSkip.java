package rx.internal.operators;

import com.baidu.tieba.a8c;
import com.baidu.tieba.k8c;
import com.baidu.tieba.mcc;
import com.baidu.tieba.n7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends t7c<T> implements a8c {
    public final t7c<? super n7c<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public mcc<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements p7c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(k8c.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(k8c.a(k8c.c(j, operatorWindowWithSize$WindowSkip.f), k8c.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.a8c
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.o7c
    public void onCompleted() {
        mcc<T, T> mccVar = this.j;
        if (mccVar != null) {
            this.j = null;
            mccVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.o7c
    public void onError(Throwable th) {
        mcc<T, T> mccVar = this.j;
        if (mccVar != null) {
            this.j = null;
            mccVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.o7c
    public void onNext(T t) {
        int i = this.i;
        UnicastSubject unicastSubject = this.j;
        if (i == 0) {
            this.h.getAndIncrement();
            unicastSubject = UnicastSubject.Q(this.f, this);
            this.j = unicastSubject;
            this.e.onNext(unicastSubject);
        }
        int i2 = i + 1;
        if (unicastSubject != null) {
            unicastSubject.onNext(t);
        }
        if (i2 == this.f) {
            this.i = i2;
            this.j = null;
            unicastSubject.onCompleted();
        } else if (i2 == this.g) {
            this.i = 0;
        } else {
            this.i = i2;
        }
    }
}
