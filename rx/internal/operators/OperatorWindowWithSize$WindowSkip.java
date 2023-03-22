package rx.internal.operators;

import com.baidu.tieba.bsa;
import com.baidu.tieba.gwa;
import com.baidu.tieba.jsa;
import com.baidu.tieba.ora;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes9.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends ura<T> implements bsa {
    public final ura<? super ora<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public gwa<T, T> j;

    /* loaded from: classes9.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements qra {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.qra
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(jsa.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(jsa.a(jsa.c(j, operatorWindowWithSize$WindowSkip.f), jsa.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.bsa
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.pra
    public void onCompleted() {
        gwa<T, T> gwaVar = this.j;
        if (gwaVar != null) {
            this.j = null;
            gwaVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.pra
    public void onError(Throwable th) {
        gwa<T, T> gwaVar = this.j;
        if (gwaVar != null) {
            this.j = null;
            gwaVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.pra
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
