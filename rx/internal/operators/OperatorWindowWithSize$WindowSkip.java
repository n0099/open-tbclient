package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.dcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.v7b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes10.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends o7b<T> implements v7b {
    public final o7b<? super i7b<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public dcb<T, T> j;

    /* loaded from: classes10.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements k7b {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.k7b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(d8b.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(d8b.a(d8b.c(j, operatorWindowWithSize$WindowSkip.f), d8b.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.v7b
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.j7b
    public void onCompleted() {
        dcb<T, T> dcbVar = this.j;
        if (dcbVar != null) {
            this.j = null;
            dcbVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.j7b
    public void onError(Throwable th) {
        dcb<T, T> dcbVar = this.j;
        if (dcbVar != null) {
            this.j = null;
            dcbVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.j7b
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
