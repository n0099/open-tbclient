package rx.internal.operators;

import com.baidu.tieba.dab;
import com.baidu.tieba.e6b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.w5b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes9.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends p5b<T> implements w5b {
    public final p5b<? super j5b<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public dab<T, T> j;

    /* loaded from: classes9.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements l5b {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.l5b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(e6b.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(e6b.a(e6b.c(j, operatorWindowWithSize$WindowSkip.f), e6b.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.w5b
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.k5b
    public void onCompleted() {
        dab<T, T> dabVar = this.j;
        if (dabVar != null) {
            this.j = null;
            dabVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.k5b
    public void onError(Throwable th) {
        dab<T, T> dabVar = this.j;
        if (dabVar != null) {
            this.j = null;
            dabVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.k5b
    public void onNext(T t) {
        int i = this.i;
        UnicastSubject unicastSubject = this.j;
        if (i == 0) {
            this.h.getAndIncrement();
            unicastSubject = UnicastSubject.F(this.f, this);
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
