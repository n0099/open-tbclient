package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.f6b;
import com.baidu.tieba.i2b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes9.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends t1b<T> implements a2b {
    public final t1b<? super n1b<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public f6b<T, T> j;

    /* loaded from: classes9.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements p1b {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.p1b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(i2b.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(i2b.a(i2b.c(j, operatorWindowWithSize$WindowSkip.f), i2b.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.a2b
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.o1b
    public void onCompleted() {
        f6b<T, T> f6bVar = this.j;
        if (f6bVar != null) {
            this.j = null;
            f6bVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.o1b
    public void onError(Throwable th) {
        f6b<T, T> f6bVar = this.j;
        if (f6bVar != null) {
            this.j = null;
            f6bVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.o1b
    public void onNext(T t) {
        int i = this.i;
        UnicastSubject unicastSubject = this.j;
        if (i == 0) {
            this.h.getAndIncrement();
            unicastSubject = UnicastSubject.D(this.f, this);
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
