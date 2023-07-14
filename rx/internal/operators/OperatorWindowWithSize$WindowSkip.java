package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.s6c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.w1c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends a2c<T> implements h2c {
    public final a2c<? super u1c<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public s6c<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements w1c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(q2c.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(q2c.a(q2c.c(j, operatorWindowWithSize$WindowSkip.f), q2c.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.h2c
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.v1c
    public void onCompleted() {
        s6c<T, T> s6cVar = this.j;
        if (s6cVar != null) {
            this.j = null;
            s6cVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.v1c
    public void onError(Throwable th) {
        s6c<T, T> s6cVar = this.j;
        if (s6cVar != null) {
            this.j = null;
            s6cVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.v1c
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
