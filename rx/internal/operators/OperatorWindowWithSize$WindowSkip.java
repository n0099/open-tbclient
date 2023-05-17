package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.ccb;
import com.baidu.tieba.h7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.u7b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes10.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends n7b<T> implements u7b {
    public final n7b<? super h7b<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public ccb<T, T> j;

    /* loaded from: classes10.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements j7b {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.j7b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(c8b.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(c8b.a(c8b.c(j, operatorWindowWithSize$WindowSkip.f), c8b.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.u7b
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.i7b
    public void onCompleted() {
        ccb<T, T> ccbVar = this.j;
        if (ccbVar != null) {
            this.j = null;
            ccbVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.i7b
    public void onError(Throwable th) {
        ccb<T, T> ccbVar = this.j;
        if (ccbVar != null) {
            this.j = null;
            ccbVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.i7b
    public void onNext(T t) {
        int i = this.i;
        UnicastSubject unicastSubject = this.j;
        if (i == 0) {
            this.h.getAndIncrement();
            unicastSubject = UnicastSubject.H(this.f, this);
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
