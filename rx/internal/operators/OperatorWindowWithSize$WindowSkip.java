package rx.internal.operators;

import com.baidu.tieba.bpb;
import com.baidu.tieba.btb;
import com.baidu.tieba.gob;
import com.baidu.tieba.iob;
import com.baidu.tieba.mob;
import com.baidu.tieba.tob;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends mob<T> implements tob {
    public final mob<? super gob<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public btb<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements iob {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.iob
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(bpb.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(bpb.a(bpb.c(j, operatorWindowWithSize$WindowSkip.f), bpb.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.tob
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.hob
    public void onCompleted() {
        btb<T, T> btbVar = this.j;
        if (btbVar != null) {
            this.j = null;
            btbVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.hob
    public void onError(Throwable th) {
        btb<T, T> btbVar = this.j;
        if (btbVar != null) {
            this.j = null;
            btbVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.hob
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
