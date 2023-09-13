package rx.internal.operators;

import com.baidu.tieba.fbc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.rfc;
import com.baidu.tieba.sac;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends yac<T> implements fbc {
    public final yac<? super sac<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public rfc<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements uac {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(pbc.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(pbc.a(pbc.c(j, operatorWindowWithSize$WindowSkip.f), pbc.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.fbc
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.tac
    public void onCompleted() {
        rfc<T, T> rfcVar = this.j;
        if (rfcVar != null) {
            this.j = null;
            rfcVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.tac
    public void onError(Throwable th) {
        rfc<T, T> rfcVar = this.j;
        if (rfcVar != null) {
            this.j = null;
            rfcVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.tac
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
