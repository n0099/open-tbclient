package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.v5c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends d1c<T> implements k1c {
    public final d1c<? super x0c<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public v5c<T, T> j;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements z0c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.z0c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(t1c.c(j, operatorWindowWithSize$WindowSkip.g));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(t1c.a(t1c.c(j, operatorWindowWithSize$WindowSkip.f), t1c.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.k1c
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.y0c
    public void onCompleted() {
        v5c<T, T> v5cVar = this.j;
        if (v5cVar != null) {
            this.j = null;
            v5cVar.onCompleted();
        }
        this.e.onCompleted();
    }

    @Override // com.baidu.tieba.y0c
    public void onError(Throwable th) {
        v5c<T, T> v5cVar = this.j;
        if (v5cVar != null) {
            this.j = null;
            v5cVar.onError(th);
        }
        this.e.onError(th);
    }

    @Override // com.baidu.tieba.y0c
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
