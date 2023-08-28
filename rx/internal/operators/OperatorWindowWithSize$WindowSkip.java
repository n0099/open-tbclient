package rx.internal.operators;

import com.baidu.tieba.c8c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.occ;
import com.baidu.tieba.p7c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends v7c<T> implements c8c {
    public final v7c<? super p7c<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public occ<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements r7c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.r7c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(m8c.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(m8c.a(m8c.c(j, operatorWindowWithSize$WindowSkip.f), m8c.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.c8c
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.q7c
    public void onCompleted() {
        occ<T, T> occVar = this.j;
        if (occVar != null) {
            this.j = null;
            occVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.q7c
    public void onError(Throwable th) {
        occ<T, T> occVar = this.j;
        if (occVar != null) {
            this.j = null;
            occVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.q7c
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
