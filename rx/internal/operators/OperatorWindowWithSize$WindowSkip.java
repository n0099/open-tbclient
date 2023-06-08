package rx.internal.operators;

import com.baidu.tieba.anb;
import com.baidu.tieba.inb;
import com.baidu.tieba.irb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends tmb<T> implements anb {
    public final tmb<? super nmb<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public irb<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements pmb {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.pmb
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(inb.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(inb.a(inb.c(j, operatorWindowWithSize$WindowSkip.f), inb.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.anb
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.omb
    public void onCompleted() {
        irb<T, T> irbVar = this.j;
        if (irbVar != null) {
            this.j = null;
            irbVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.omb
    public void onError(Throwable th) {
        irb<T, T> irbVar = this.j;
        if (irbVar != null) {
            this.j = null;
            irbVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.omb
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
